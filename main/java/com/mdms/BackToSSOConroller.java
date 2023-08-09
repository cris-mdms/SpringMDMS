package com.mdms;

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

import com.mdms.app.mgmt.model.SsoReceiveUserDetailsModel;
import com.mdms.app.mgmt.service.SSOService;

import java.net.URI;

@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false")
//@Controller
//public class BackToSSOConroller {
//	Logger logger=LoggerFactory.getLogger(BackToSSOConroller.class);
//	String secretkey="KeH45QazsQ1Edc740IRu" ;
//	@RequestMapping(method= {RequestMethod.POST },value="/logoutssouser",  
//			consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
//		public String logoutHrmsSSoUser(@ModelAttribute SsoReceiveUserDetailsModel hrmsidModel) throws URISyntaxException{	
//		logger.info("Controller : BackToSSOConroller || Method : logoutHrmsSSoUser ||hrmsEmployeeInfo: ");
//		
//		try {
//		
//			String token=BackToSSO.generateToken(hrmsidModel.getHrmsId(), secretkey);
//			return "redirect:https://www.trial.ireps.gov.in/sso/home/userLogin.do";	
//		
//		}catch(Exception e)
//		{return null;	}
//		
//		
//}
//}


@RestController
public class BackToSSOConroller {
	
	@Autowired
	SSOService ssoservice;
	Logger logger=LoggerFactory.getLogger(BackToSSOConroller.class);
	String secretkey="KeH45QazsQ1Edc740IRu" ;
    String encData;
//   @RequestMapping(method= {RequestMethod.POST},value="/logoutssouser")
    public RedirectView logoutHrmsSSoUser(@RequestParam("user_id") String input ,HttpServletRequest request,final RedirectAttributes redirectAttributes){
	   
    	logger.info("Controller : BackToSSOConroller || Method : logoutHrmsSSoUser ||hrmsEmployeeInfo: ");
    	SsoReceiveUserDetailsModel temp;

        try {
        	temp= ssoservice.getssodetails(input)	;
        	
        	
			String token=BackToSSO.generateToken(input, secretkey);
			String backToSSOString="SessionId=" + temp.getSessionId() + "|token=" + token + "|hrmsId=" + temp.getHrmsId() + "|SSOUid=" + temp.SSOUid+ "|app_code=" + temp.getApp_code();
			
			 String encrptedString = BackToSSO.doEncrypt(secretkey, backToSSOString);
			 String plainString="app_code="+temp.getApp_code();
			encData =encrptedString+"#"+plainString;
			 redirectAttributes.addAttribute("encData",encData);
		       

//			return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("redirect:https://www.trial.ireps.gov.in/sso/home/userLogin.do")).build();
			return new RedirectView("redirect:https://www.trial.ireps.gov.in/sso/home/userLogin.do");
		}
        catch(Exception e)
		{return null;	}
 
        
    }
    
    
    
    
    
}
