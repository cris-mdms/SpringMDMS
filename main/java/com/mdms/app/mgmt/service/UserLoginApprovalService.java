package com.mdms.app.mgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdms.app.mgmt.model.UserProfileRegistrationDetailModel;
import com.mdms.app.mgmt.repository.UserProfileRegistrationRepository;


@Service
public class UserLoginApprovalService {
	
	
	
	 
	 @Autowired
	 UserProfileRegistrationRepository  profileRegistrationRepoObj;
	 
	 
	 
	 public List<UserProfileRegistrationDetailModel> getUserProfiles() {
		 
		List<UserProfileRegistrationDetailModel> list= profileRegistrationRepoObj.getUserProfiles();
		
		return list;
		 
	 }
	 
	 
	 

}



