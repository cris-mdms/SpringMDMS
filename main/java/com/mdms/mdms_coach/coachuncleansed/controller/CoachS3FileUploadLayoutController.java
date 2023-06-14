package com.mdms.mdms_coach.coachuncleansed.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mdms.mdms_coach.coachuncleansed.service.CoachS3FileUploadLayoutService;

@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")


@RestController
@RequestMapping("/fileuploadS3")
public class CoachS3FileUploadLayoutController {
	
	@Autowired
	private CoachS3FileUploadLayoutService amazonClient;
	
    Logger logger=LoggerFactory.getLogger(CoachS3FileUploadLayoutController.class);
    
	@Autowired
	CoachS3FileUploadLayoutController(CoachS3FileUploadLayoutService amazonClient) {
		this.amazonClient = amazonClient;
	}
	
	
	@PostMapping("/uploadCmmFile")
	public String uploadFileCMM(@RequestPart(value = "file") MultipartFile file,@RequestParam(value="sender")String sender
			,@RequestParam(value="coachtype")String coachtype,@RequestParam(value="capacity")String capacity
			,@RequestParam(value="description")String description,@RequestParam(value="remarks")String remarks	) throws IOException {
		logger.info("controller : CoachS3FileUploadController || Method : uploadFileCMM||")	;
		
		return this.amazonClient.uploadFileCMM(file,sender,coachtype,capacity,description,remarks);

	}
	
	
	
	@PostMapping("/uploadPrsFile")
	public String uploadFilePRS(@RequestPart(value = "file") MultipartFile file,@RequestParam(value="sender")String sender
			,@RequestParam(value="coachtype")String coachtype,@RequestParam(value="capacity")String capacity
			,@RequestParam(value="description")String description,@RequestParam(value="remarks")String remarks	) throws IOException {
		logger.info("controller : CoachS3FileUploadController || Method : uploadFilePRS||")	;
		
		return this.amazonClient.uploadFilePRS(file,sender,coachtype,capacity,description,remarks);

	}
	
//	  download from s3
	  @GetMapping(value= "/download")
	    public ResponseEntity<ByteArrayResource> downloadFile1(@RequestParam(value= "fileName")  String keyName) {
	        final byte[] data = amazonClient.downloadFile1(keyName);
	        logger.info("controller : CoachS3FileUploadController || Method : downloadFile1");
	        final ByteArrayResource resource = new ByteArrayResource(data);
	        return ResponseEntity
	                .ok()
	                .contentLength(data.length)
	                .header("Content-type", "application/octet-stream")
	                .header("Content-disposition", "attachment; filename=\"" + keyName + "\"")
	                .body(resource);
	    }
	  
	  
	  
	   
	  
	  

}
