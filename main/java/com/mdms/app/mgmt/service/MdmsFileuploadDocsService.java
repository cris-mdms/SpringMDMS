package com.mdms.app.mgmt.service;




import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;




@Service
public class MdmsFileuploadDocsService {
	
	private AmazonS3 s3client;
	
	private final String endpointUrl="http://mdmusermanuals.s3-website.ap-south-1.amazonaws.com";
	private final String bucketName="mdmusermanuals";
	private final String accessKey="AKIASFBV5NAHRZIR7NXD";
	private final String secretKey="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";

	private Logger logger = LoggerFactory.getLogger(MdmsFileuploadDocsService.class);
	
	
	@PostConstruct
	private void initializeAmazon() {
		AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
		this.s3client = AmazonS3ClientBuilder.standard().withRegion(Regions.AP_SOUTH_1)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();
	}
//	......................................................................
	  public byte[] downloadFile1(final String keyName) {
	        byte[] content = null;
	       // LOGGER.info("Downloading an object with key= " + keyName);
	        final S3Object s3Object = s3client.getObject(bucketName, keyName);
	        final S3ObjectInputStream stream = s3Object.getObjectContent();
	        try {
	            content = IOUtils.toByteArray(stream);
	     //       LOGGER.info("File downloaded successfully.");
	            s3Object.close();
	        } catch(final IOException ex) {
	      //      LOGGER.info("IO Error Message= " + ex.getMessage());
	        }
	        return content;
	    }

}
