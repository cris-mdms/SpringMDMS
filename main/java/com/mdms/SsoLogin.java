package com.mdms;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpHeaders;

import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mdms.app.mgmt.model.SsoHrmsTokenCheckModel;

import com.mdms.app.mgmt.model.SsoReceiveUserDetailsModel;


@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")
@RestController
public class SsoLogin  {
	Logger logger=LoggerFactory.getLogger(SsoLogin.class);
		
	@RequestMapping(method=RequestMethod.POST, value="/verifyssouser")
	public void verifyHrmsSSoUser(@RequestBody SsoReceiveUserDetailsModel hrmsidModel) throws URISyntaxException{	
		
				
		logger.info("Controller : SsoLogin || Method : verifyHrmsSSoUser ||hrmsEmployeeInfo: ");	
		
		URI verify_user = new URI("http://10.77.48.16:8080/hrmssinglesignon/tokencheck");    

//		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();

		 HttpHeaders headers = new HttpHeaders();
         headers.setContentType(MediaType.APPLICATION_JSON);
         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
         

//      SsoHrmsTokenResponseModel uservalidity;
//		logger.info("hrmsId:" + hrmsidModel.getHrmsId());
//        logger.info("SessionId:" + hrmsidModel.getSessionId());
//        logger.info("token:" + hrmsidModel.getToken());
//        logger.info("SSOUid:" + hrmsidModel.getSSOUid());
//        
        SsoHrmsTokenCheckModel ssotokenmodel =new SsoHrmsTokenCheckModel();
        ssotokenmodel.setHrmsId(hrmsidModel.getHrmsId());
        ssotokenmodel.setToken(hrmsidModel.getToken());
        
        
        boolean b=TokenValidator.validateToken(hrmsidModel.getHrmsId(), hrmsidModel.getToken());
        

					        
		        if(!b)
	        {
		        	//redirect to website
		        	System.out.println("Message from HRMS ");
		        	
		        }
		        
		    
		   
	
	}}
	


