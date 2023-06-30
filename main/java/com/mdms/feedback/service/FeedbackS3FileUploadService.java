package com.mdms.feedback.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import com.mdms.feedback.repository.FeedbackSnapshortRepository;


@Service
public class FeedbackS3FileUploadService {
	private AmazonS3 s3client;
	private final String endpointUrl="http://feedback-snapshort.s3-website.ap-south-1.amazonaws.com";
	private final String bucketName="feedback-snapshort";
	private final String accessKey="AKIASFBV5NAHQS5Q6GQI";
	private final String secretKey="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";	
	private Logger logger = LoggerFactory.getLogger(FeedbackS3FileUploadService.class);

	@Autowired
	private FeedbackSnapshortRepository objSnapRepo;
	
	@PostConstruct
	private void initializeAmazon() {
		AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
		this.s3client = new AmazonS3Client(credentials);
	}

//	File Upload in S3 Bucket Thorugh Angular- Feedback Snapshort		
	public String uploadFeedbackFile(MultipartFile multipartFile,String requestid) throws IOException {
		  logger.info("UploadFile Service");
		String fileUrl = "";
		try {
			File file = convertMultiPartToFile(multipartFile);
			String snapfilename = generateFileName(multipartFile);
//			
			System.out.println("filename="+snapfilename);

			System.out.println("id="+requestid);
				
			int result=objSnapRepo.savesnapshorttype(requestid, snapfilename);
				if (result>0)
			
				{
			
			fileUrl = endpointUrl + "/" + bucketName + "/" + snapfilename;
			
			System.out.println("filename="+fileUrl);
			uploadFileTos3bucket(snapfilename, file);
			file.delete();
			}
				
				
				
		} /*catch (Exception e) {
			e.printStackTrace();
		}*/
		catch (AmazonServiceException ase) {
	          logger.info("Caught an AmazonServiceException from GET requests, rejected reasons:");
	          logger.info("Error Message:    " + ase.getMessage());
	          logger.info("HTTP Status Code: " + ase.getStatusCode());
	          logger.info("AWS Error Code:   " + ase.getErrorCode());
	          logger.info("Error Type:       " + ase.getErrorType());
	          logger.info("Request ID:       " + ase.getRequestId());
	          
	          
	            } catch (AmazonClientException ace) {
	              logger.info("Caught an AmazonClientException: ");
	                logger.info("Error Message: " + ace.getMessage());
	            } catch (IOException ioe) {
	              logger.info("IOE Error Message: " + ioe.getMessage());
	              
	            }
		return fileUrl;

	}
	
	private String generateFileName(MultipartFile multiPart) {
		return new Date().getTime() + "-" + multiPart.getOriginalFilename().replace(" ", "_");
	}

	private File convertMultiPartToFile(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}
	
//	......................................................................
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
	

	
	  public String deleteFileFromS3Bucket(String fileUrl) {
			String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
			s3client.deleteObject(new DeleteObjectRequest(bucketName + "/", fileName));
			return "Successfully deleted";
		}

		private void uploadFileTos3bucket(String fileName, File file) {
			s3client.putObject(
					new PutObjectRequest(bucketName, fileName, file));
					//.withCannedAcl(CannedAccessControlList.PublicRead));
		}

	
	
	
}
