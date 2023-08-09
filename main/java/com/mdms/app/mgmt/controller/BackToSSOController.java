package com.mdms.app.mgmt.controller;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.mdms.BackToSSO;
import com.mdms.BackToSSOConroller;
import com.mdms.app.mgmt.model.SsoReceiveUserDetailsModel;
import com.mdms.app.mgmt.service.SSOService;

import java.net.URI;

@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")
@RestController
public class BackToSSOController {
	@Autowired
	SSOService ssoservice;
	Logger logger=LoggerFactory.getLogger(BackToSSOConroller.class);
	String secretkey="KeH45QazsQ1Edc740IRu" ;
    String encData;
   @RequestMapping(method= {RequestMethod.GET},value="/logoutssouser")
    public String logoutHrmsSSoUser(@RequestParam("user_id") String input ,HttpServletRequest request,final RedirectAttributes redirectAttributes){
	   
    	logger.info("Controller : BackToSSOConroller || Method : logoutHrmsSSoUser ||hrmsEmployeeInfo: ");
    	SsoReceiveUserDetailsModel temp;
    	input="DOOHYS";

        try {
        	temp= ssoservice.getssodetails(input)	;
        	
        	
			String token=BackToSSO.generateToken(input, secretkey);
			String backToSSOString="SessionId=" + temp.getSessionId() + "|token=" + token + "|hrmsId=" + temp.getHrmsId() + "|SSOUid=" + temp.SSOUid+ "|app_code=" + temp.getApp_code();
			
			System.out.println("backToSSOString    "+backToSSOString);
		
			 String encrptedString = BackToSSO.doEncrypt(secretkey, backToSSOString);
			
			 String plainString="app_code="+temp.getApp_code();
			
			encData =encrptedString+"#"+plainString;
			

			 
			 return encData;
		}
        catch(Exception e)
		{return null;	}
 
        
    }
   
   @RequestMapping(method= {RequestMethod.GET},value="/logoutssouser1")
   public String logoutHrmsSSoUser1(@RequestParam("user_id") String input ,HttpServletRequest request,final RedirectAttributes redirectAttributes){

	   
	   ssoservice.decrypt(input);
	   return "success";
   }
   }


