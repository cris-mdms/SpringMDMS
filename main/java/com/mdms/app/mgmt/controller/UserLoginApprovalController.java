package com.mdms.app.mgmt.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.mdms.app.mgmt.model.UserProfileRegistrationDetailModel;
import com.mdms.app.mgmt.service.UserLoginApprovalService;

@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")
@RestController
public class UserLoginApprovalController {
	
	
	@Autowired
	UserLoginApprovalService userLoginApprovalServiceObj;
	
	Logger logger=LoggerFactory.getLogger(UserLoginController.class);

	@RequestMapping(method=RequestMethod.POST, value="/loginapprovallist")
	public List<UserProfileRegistrationDetailModel> getUserProfiles(){
		
		
	return 	userLoginApprovalServiceObj.getUserProfiles();
		
	
	}
	

}
