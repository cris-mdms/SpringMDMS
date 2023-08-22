package com.mdms.app.mgmt.controller;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;

import org.bouncycastle.crypto.CryptoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mdms.BackToSSO;
import com.mdms.TokenValidator;
import com.mdms.app.mgmt.model.SsoReceiveUserDetailsModel;
import com.mdms.app.mgmt.service.SSOService;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false")

@Controller
//@RestController
public class LoginToSSOController implements ErrorController {
	
	String url="http://ssomdms.s3-website.ap-south-1.amazonaws.com";
	String secretkey="KeH45QazsQ1Edc740IRu" ;
	String input="DOOHYS";
	@Autowired
	SSOService ssoservice;
	
	private  final static String TRANSFORMATION = "AES/ECB/PKCS5Padding";
	Logger logger=LoggerFactory.getLogger(LoginToSSOController.class);
	 SsoReceiveUserDetailsModel hrmsidModel1 =new SsoReceiveUserDetailsModel();
		
	@RequestMapping(method= {RequestMethod.POST,RequestMethod.GET },value="/verifyssouser", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)

	public String verifyHrmsSSoUser(@ModelAttribute ("encData") String hrmsidModel,HttpServletRequest request)throws URISyntaxException, CryptoException{	
		
		logger.info("Controller : LoginToSSOController || Method : verifyHrmsSSoUser ||SSOEmployeeInfo: " +hrmsidModel);	
		
		  
//		ssoservice.decrypt(hrmsidModel);
		System.out.println("Decrypt received EncData");
				
		String decryptedData= SSOService.doDecrypt("a5e922f36498d43983cb1afaf991459250bcf40d8b1f7909322e010d058a772e",hrmsidModel);
				
				
 //Split the contents ............................................................       
	   String [] dataArr=decryptedData.split("\\|");
  
       for(int i=0 ; i < dataArr.length ;i++){
	      String enqData=dataArr[i];
	      String [] enqDataArr=enqData.split("=");
	    	System.out.println(enqDataArr[0]+"==="+enqDataArr[1]);
		}
   
   String[] dataArray = decryptedData.split("\\|");
	for (String item : dataArray) {
	    String[] keyValue = item.split("=");
	    if (keyValue.length == 2) {
	        String key = keyValue[0];
	        String value = keyValue[1];
        System.out.println("Key: " + key + ", Value: " + value);
	        if("SessionId".equalsIgnoreCase(key)) {
	        	hrmsidModel1.setSessionId(value);
	        }
	        else if("token".equalsIgnoreCase(key)) {
	        	hrmsidModel1.setToken(value);
	        	
	        }
	        else if("hrmsId".equalsIgnoreCase(key)) {
	        	hrmsidModel1.setHrmsId(value);
	        }
	        else if("SSOUid".equalsIgnoreCase(key)) {
	        	hrmsidModel1.setSSOUid(value);
	        }
	        else if("app_code".equalsIgnoreCase(key)) {
	        	hrmsidModel1.setApp_code(value);
	        }
	    }
	}
   
	
//	System.out.println("Encrypt received EncData\n");
//	
//	String token=BackToSSO.generateToken(input, secretkey);
//	String backToSSOString="SessionId=" + hrmsidModel1.getSessionId() + "|token=" + token + "|hrmsId=" + hrmsidModel1.getHrmsId() + "|SSOUid=" + hrmsidModel1.SSOUid+ "|app_code=" + hrmsidModel1.getApp_code();
//	
//	System.out.println("backToSSOString    "+backToSSOString);
//	System.out.println("Encrypt received EncData\n");
//
//	 String encrptedString = SSOService.doEncrypt(secretkey, backToSSOString);
//	 System.out.println(encrptedString);
//	 String plainString="app_code="+hrmsidModel1.getApp_code();
//	
//	String encData = encrptedString+"#"+plainString;
	
	
	
		
//	 System.out.println("Decrypt existing EncData");
//	
//	 String decryptedData1= SSOService.doDecrypt("a5e922f36498d43983cb1afaf991459250bcf40d8b1f7909322e010d058a772e",encrptedString);
//	 
	//Split the contents ............................................................       
//	   String [] dataArr1=decryptedData1.split("\\|");
//
//     for(int i=0 ; i < dataArr1.length ;i++){
//	      String enqData=dataArr1[i];
//	      String [] enqDataArr=enqData.split("=");
//	    	System.out.println(enqDataArr[0]+"==="+enqDataArr[1]);
//		}
// 
// String[] dataArray1 = decryptedData1.split("\\|");
//	for (String item : dataArray1) {
//	    String[] keyValue = item.split("=");
//	    if (keyValue.length == 2) {
//	        String key = keyValue[0];
//	        String value = keyValue[1];
//        System.out.println("Key: " + key + ", Value: " + value);
//	        if("SessionId".equalsIgnoreCase(key)) {
//	        	hrmsidModel1.setSessionId(value);
//	        }
//	        else if("token".equalsIgnoreCase(key)) {
//	        	hrmsidModel1.setToken(value);
//	        	
//	        }
//	        else if("hrmsId".equalsIgnoreCase(key)) {
//	        	hrmsidModel1.setHrmsId(value);
//	        }
//	        else if("SSOUid".equalsIgnoreCase(key)) {
//	        	hrmsidModel1.setSSOUid(value);
//	        }
//	        else if("app_code".equalsIgnoreCase(key)) {
//	        	hrmsidModel1.setApp_code(value);
//	        }
//	    }
//	}
 
	 
	 
	 
	 
	 
	 
   
//   ...............................................................................................................      
             
         try {  

             char status=ssoservice.chcekuserexists(hrmsidModel);
             status='R';
             if (status=='N')
             {//redirect for registration
            	 
            	 return "redirect:"+url+"/register";
            	 

            	 }
             
             else if(status=='C')
             {
            	 //cris user page
            	 return null;
             }
             else if(status=='R')
             {
             
            	 boolean a= ssoservice.savessodetails(hrmsidModel1);
        	  
            	 boolean b=TokenValidator.validateToken(hrmsidModel1.getHrmsId(), hrmsidModel1.getToken());
                
            	 if(b)
            	 {
		        	//redirect to website
            		 logger.info("Controller :LoginToSSOController  : redirect ");	
            		 
            		 
            		 
            		 
            		 
            		 
// .....................................................................................................................           		 
		         //		     	 return "redirect:http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com/";
//              		 return "redirect:"+url+"/login/"+hrmsidModel1.getHrmsId();
            		 return "redirect:"+url+"/login/"+"45436400546";
//            		 return "redirect:http://localhost:4200/login/"+"45436400546";
//            		 return "redirect:"+url;
//.......................................................................................................................		        	
            	 }
            	 else
            	 {return null;}
		        
         }
             return null;
		   
         }catch(Exception e)
         {
        	 return "Page not found";

         }
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return null;
	}


}
	


