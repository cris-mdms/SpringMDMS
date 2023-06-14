package com.mdms.datadictionary.service;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSCredentials;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import com.mdms.app.mgmt.service.MdmsFileuploadDocsService;
@Service
public class MdmsDataDictionaryFileUploadService {
private AmazonS3 s3client;
	
	private final String endpointUrl="http://mdmsdatadictionary.s3-website.ap-south-1.amazonaws.com";
	private final String bucketName="mdmsdatadictionary";
	private final String accessKey="AKIASFBV5NAH4AK7UNMR";
	private final String secretKey="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";
//@Service
//public class MdmsDataDictionaryFileUploadService {
//
//	
//private AmazonS3 s3client;
//	
//	private final String endpointUrl="http://mdmusermanuals.s3-website.ap-south-1.amazonaws.com";
//	private final String bucketName="mdmsdatadictionary";
//	private final String accessKey="AKIASFBV5NAH7QKLXTN4";
//	private final String secretKey="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";
//>>>>>>> d5ee4e121f4789be7ab0e3b4a7eb873bb1225352
	
	private Logger logger = LoggerFactory.getLogger(MdmsDataDictionaryFileUploadService.class);
	
	@PostConstruct
	private void initializeAmazon() {
		AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);

		this.s3client = AmazonS3ClientBuilder.standard().withRegion(Regions.AP_SOUTH_1)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();

		this.s3client = new AmazonS3Client(credentials);

}
	
	
	 public byte[] downloadFile2(final String keyName) {
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

