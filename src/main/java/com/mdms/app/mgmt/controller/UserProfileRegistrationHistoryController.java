package com.mdms.app.mgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.mdms.app.mgmt.service.UserProfileRegistrationHistoryService;

@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false")

@RestController
public class UserProfileRegistrationHistoryController {
	
	@Autowired
	UserProfileRegistrationHistoryService user;
		// Jyoti Bisht 05-12-22  for User Privilege
	
	@PostMapping("/insert_user")
		public boolean getUsersByShed(@RequestParam("user_id") String user_id, @RequestParam("parent_id") String parent_id)
		{
			return user.add_user_details(user_id, parent_id);
		}
		

}
