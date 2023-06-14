//Developed By: Anshu Sharma , Date 08/Oct/2020 
package com.mdms.app.mgmt.controller;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mdms.app.mgmt.model.LoginOtpModel;
import com.mdms.app.mgmt.model.MenuIdResponseModel;
import com.mdms.app.mgmt.service.LoginOtpService;
import com.mdms.app.mgmt.service.ShowMenuRightsService;
@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")
@RestController
public class LoginOtpController {	
	@Autowired
	private LoginOtpService otpService;	
	@Autowired
	private ShowMenuRightsService menuRightService;	
	Logger logger=LoggerFactory.getLogger(LoginOtpController.class);
	@RequestMapping(method=RequestMethod.POST, value="/sendotp")
	public String sendOTP(@RequestParam("user_id") String user_id){		
		logger.info("Controller : LoginOtpController || Method : sendOTP ||user_id: "+user_id);	
		String response= otpService.getOtp(user_id);
		//code to send otp, on hold because of Api for sending otp		
		logger.info("Controller : LoginOtpController || Method : sendOTP ||user_id: "+user_id);
		return response;
		
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/verifyotp")
	public MenuIdResponseModel verifyOtp(@RequestParam("user_id") String user_id,@RequestParam("otp") Integer otp){	
		
		MenuIdResponseModel obj=new MenuIdResponseModel();
		logger.info("Controller : LoginOtpController || Method : verifyOtp || user_id: "+user_id +" ||otp: " +otp);
		List<String> response= new ArrayList<String>();
	List<LoginOtpModel>	result=otpService.verifyOtp(user_id,otp);
	if(result.size()>0) {
		 response= menuRightService.showMenuRights(result.get(0).getUser_id());
		if(response.size()>0)
		{		
		obj.setMenuid_list(response);
		obj.setStatus("success");
		obj.setMessage("otp is correct");
		
		 logger.info("Controller : LoginOtpController || Method : sendOTP ||showMenuRights:user_id "+user_id +" ||menuId list size"+ response.size() +"|| otp is correct");

		}else {
			
			
			obj.setMenuid_list(response);
			obj.setStatus("success");
			obj.setMessage("no menu rights for this user");
			 logger.info("Controller : LoginOtpController || Method : sendOTP ||showMenuRights:user_id "+user_id +" ||no menu rights");

		}
		

	}else {
		
		obj.setMenuid_list(response);
		obj.setStatus("failed");
		obj.setMessage("otp is wrong");
		 logger.info("Controller : LoginOtpController || Method : sendOTP ||showMenuRights:user_id "+user_id +" ||otp is wrong");

		
	}
		
	
	
		return obj;
		
		
		
		
		
	}
	

}