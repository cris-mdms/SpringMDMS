package com.mdms.app.mgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.mdms.app.mgmt.repository.UserProfileRegistrationHistory;

@Service
public class UserProfileRegistrationHistoryService {
	
	@Autowired
	UserProfileRegistrationHistory user_obj;
	
	public boolean add_user_details(String user_id, String parent_id) {
		 //boolean active=false;
		 try {
			 user_obj.insert_details(user_id, parent_id);
			 //active=true;
			 return true;
		 }
		 catch(Exception e) {
			 //active=false;
			 return false;
		 }
		 
	}
	

}
