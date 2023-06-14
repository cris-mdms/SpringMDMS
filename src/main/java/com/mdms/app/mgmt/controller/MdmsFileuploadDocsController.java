package com.mdms.app.mgmt.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.File;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import com.mdms.app.mgmt.service.MdmsFileuploadDocsService;
@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")

@RestController
@RequestMapping("/mdmdocs")

public class MdmsFileuploadDocsController {
	MdmsFileuploadDocsService amazonClient;
	private	Logger logger=LoggerFactory.getLogger(MdmsFileuploadDocsController.class);
	
	
	@Autowired
	MdmsFileuploadDocsController(MdmsFileuploadDocsService amazonClient) {
		this.amazonClient = amazonClient;
		
	}
	
//	  download from s3
	  @GetMapping(value= "/download")
	    public ResponseEntity<ByteArrayResource> downloadFile(@RequestParam(value= "fileName")  String keyName) {
	        final byte[] data = amazonClient.downloadFile1(keyName);
	        logger.info("controller : MdmsFileuploadDocsController || Method : downloadFile");
	        final ByteArrayResource resource = new ByteArrayResource(data);
	        return ResponseEntity
	                .ok()
	                .contentLength(data.length)
	                .header("Content-type", "application/octet-stream")
	                .header("Content-disposition", "attachment; filename=\"" + keyName + "\"")
	                .body(resource);
	    }

}
