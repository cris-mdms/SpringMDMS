package com.mdms.datadictionary.controller;



import com.mdms.app.mgmt.controller.MdmsFileuploadDocsController;
import com.mdms.app.mgmt.service.MdmsFileuploadDocsService;
import com.mdms.datadictionary.service.MdmsDataDictionaryFileUploadService;
//@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")
//
//@RestController
//@RequestMapping("/mdmdatadictionary")
//public class MdmsDataDictionaryFileUploadController {
//
//MdmsDataDictionaryFileUploadService amazonClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mdms.datadictionary.service.MdmsDataDictionaryFileUploadService;
@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")
@RestController
@RequestMapping("/mdmdatadictionary")
public class MdmsDataDictionaryFileUploadController {	
	MdmsDataDictionaryFileUploadService amazonClient;
	private	Logger logger=LoggerFactory.getLogger(MdmsDataDictionaryFileUploadController.class);
	
	@Autowired
	MdmsDataDictionaryFileUploadController(MdmsDataDictionaryFileUploadService amazonClient) {
		this.amazonClient = amazonClient;

}	
//	@GetMapping(value= "/download2")
//	public ResponseEntity<ByteArrayResource> downloadFile2(@RequestParam(value= "fileName")  String keyName){
//		System.out.println(keyName);
//		 final byte[] data = amazonClient.downloadFile2(keyName);
//			 
//
//}

	
	@GetMapping(value= "/download2")
	public ResponseEntity<ByteArrayResource> downloadFile2(@RequestParam(value= "fileName")  String keyName){		
		 final byte[] data = amazonClient.downloadFile2(keyName); 
		    logger.info("controller : MdmsDataDictionaryFileUploadController || Method : downloadFile2");		    
		 final ByteArrayResource resource = new ByteArrayResource(data);
		 return ResponseEntity
	                .ok()
	                .contentLength(data.length)
	                .header("Content-type", "application/octet-stream")
	                .header("Content-disposition", "attachment; filename=\"" + keyName + "\"")
	                .body(resource);	
		
		
		
		
	}
	
	
	
	
	
	
	
	
}