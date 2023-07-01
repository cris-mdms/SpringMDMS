package com.mdms.loco.locouncleansed.service;

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
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;


@Service
public class LocoS3FileUploadService {
	
	private AmazonS3 s3client;
	private final String endpointUrl="http://loco-condemnation-data.s3-website.ap-south-1.amazonaws.com";
	private final String bucketName="loco-condemnation-data";
	private final String accessKey="AKIASFBV5NAHXITKSB2D";
	private final String secretKey="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";
	
	private Logger logger = LoggerFactory.getLogger(LocoS3FileUploadService.class);

	



	@PostConstruct
	private void initializeAmazon() {
		AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
	
		this.s3client=AmazonS3ClientBuilder.standard().withRegion(Regions.AP_SOUTH_1)
        .withCredentials(new AWSStaticCredentialsProvider(credentials))
        .build();

	}

//	S3 File upload method- CMM
	/*
	public String uploadFileCMM(MultipartFile multipartFile,String sender, String coachtype,
			String capacity,String description,String remarks) throws IOException {
		  logger.info("UploadFile Service");
		 String fileUrl = "";
		try {
			File file = convertMultiPartToFile(multipartFile);
			String fileName = generateFileName(multipartFile);
			
			
			int result=cmmtyperepo.savecmmtype(coachtype, capacity, description, remarks, sender, fileName, "U");
				if (result>0)
			
				{	fileUrl = "RECORD SAVED AND LAYOUT UPLOADED AT : "+endpointUrl + "/" + bucketName + "/" + fileName;
			
		
			uploadFileTos3bucket(fileName, file);
			file.delete();}
		
				
				
				
		} 
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
	                return " Exception Occurred. Contact Administrator";
	            } catch (IOException ioe) {
	              logger.info("IOE Error Message: " + ioe.getMessage());
	              return " Exception Occurred. Contact Administrator";
	              
	            }
		return fileUrl;

	}
*/
	
	public String uploadFileCondemn(MultipartFile multipartFile) throws IOException {
		  logger.info("UploadFile Service");
		 String fileUrl = "";
		try {
			File file = convertMultiPartToFile(multipartFile);
			String fileName = generateFileName(multipartFile);
			
			fileUrl = "RECORD SAVED AND UPLOADED AT : "+endpointUrl + "/" + bucketName + "/" + fileName;
			uploadFileTos3bucket(fileName, file);
			file.delete();
		
				
		} 
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
	                return " Exception Occurred. Contact Administrator";
	            } catch (IOException ioe) {
	              logger.info("IOE Error Message: " + ioe.getMessage());
	              return " Exception Occurred. Contact Administrator";
	              
	            }
		
		return fileUrl;

	}
	
	
	
	
//	S3 File upload method- PRS
	/*
	
	public String uploadFilePRS(MultipartFile multipartFile,String sender, String coachtype,
			String capacity,String description,String remarks) throws IOException {
		  logger.info("UploadFile Service");
		String fileUrl = "";
		try {
			File file = convertMultiPartToFile(multipartFile);
			String fileName = generateFileName(multipartFile);
			
			int result=prstyperepo.saveprstype(coachtype, capacity, description, remarks, sender, fileName, "U");
				if (result>0)
			
				{	fileUrl = "RECORD SAVED AND LAYOUT UPLOADED AT : "+endpointUrl + "/" + bucketName + "/" + fileName;
			
		
			uploadFileTos3bucket(fileName, file);
			file.delete();}
				
				
				
		} 
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
		                return " Exception Occurred. Contact Administrator";
		            } catch (IOException ioe) {
		              logger.info("IOE Error Message: " + ioe.getMessage());
		              return " Exception Occurred. Contact Administrator";
		              
		            }
		return fileUrl;

	}
	
*/
	
	
	
	private File convertMultiPartToFile(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}
	
	private String generateFileName(MultipartFile multiPart) {
		return new Date().getTime() + "-" + multiPart.getOriginalFilename().replace(" ", "_");
	}
	
	private void uploadFileTos3bucket(String fileName, File file) {
		s3client.putObject(
				new PutObjectRequest(bucketName, fileName, file));
				
	}

	  public byte[] downloadFile1(final String keyName) {
	        byte[] content = null;
	     
	        final S3Object s3Object = s3client.getObject(bucketName, keyName);
	        final S3ObjectInputStream stream = s3Object.getObjectContent();
	        try {
	            content = IOUtils.toByteArray(stream);
	  
	            s3Object.close();
	        } catch(final IOException ex) {
	
	        }
	        return content;
	    }
	  
	  
	  

}
