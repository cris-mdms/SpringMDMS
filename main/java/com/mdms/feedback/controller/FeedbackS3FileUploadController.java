package com.mdms.feedback.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mdms.feedback.service.FeedbackS3FileUploadService;
@RestController
@RequestMapping("/feedbackfileuploadS3")
public class FeedbackS3FileUploadController {
	Logger logger=LoggerFactory.getLogger(FeedbackS3FileUploadController.class);
	private FeedbackS3FileUploadService amazonClient;
	
	
	@Autowired
	FeedbackS3FileUploadController(FeedbackS3FileUploadService amazonClient) {
		this.amazonClient = amazonClient;
	}

	
	@PostMapping("/uploadFeedbackFile")
	public String uploadFeedbackFile(@RequestPart(value = "file") MultipartFile file,@RequestParam(value="request_id")String request_id
			) throws IOException {
		logger.info("controller : FeedbackS3FileUploadController || Method : uploadFeedbackFile||")	;		
			
		return this.amazonClient.uploadFeedbackFile(file, request_id);

	}
//	  download from s3
	  @GetMapping(value= "/downloadsnapshort")
	    public ResponseEntity<ByteArrayResource> downloadFile2(@RequestParam(value= "fileName")  String keyName) {
	        final byte[] data = amazonClient.downloadFile2(keyName);
	        logger.info("controller : FeedbackS3FileUploadController || Method : downloadFile2");
	        final ByteArrayResource resource = new ByteArrayResource(data);
	        return ResponseEntity
	                .ok()
	                .contentLength(data.length)
	                .header("Content-type", "application/octet-stream")
	                .header("Content-disposition", "attachment; filename=\"" + keyName + "\"")
	                .body(resource);
	    }
	  
	
	 private MediaType contentType(String keyname) {
		    String[] arr = keyname.split("\\.");
		    String type = arr[arr.length-1];
		    switch(type) {
		      case "txt": return MediaType.TEXT_PLAIN;
		      case "png": return MediaType.IMAGE_PNG;
		      case "jpg": return MediaType.IMAGE_JPEG;
		      case "pdf": return MediaType.APPLICATION_PDF;
		      case "docx": return MediaType.MULTIPART_FORM_DATA;
		      
		      default: return MediaType.APPLICATION_OCTET_STREAM;
		    }
		  }

}
