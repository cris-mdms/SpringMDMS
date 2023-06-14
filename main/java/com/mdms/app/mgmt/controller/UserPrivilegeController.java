package com.mdms.app.mgmt.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mdms.app.mgmt.model.MasterUserLoginDetail;
import com.mdms.app.mgmt.model.UserLoginDetailModel;
import com.mdms.app.mgmt.model.UserPrivilegeModel;
import com.mdms.app.mgmt.model.UserProfileRegistrationDetailModel;
import com.mdms.app.mgmt.service.UserPrivilegeService;

@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false")
@RestController
public class UserPrivilegeController {
Logger logger=LoggerFactory.getLogger(UserProfileRegistrationController.class);	
	@Autowired
	UserPrivilegeService obj_service;
	
	@RequestMapping(method=RequestMethod.POST, value="/getuserprivilegedetail")
	public List<UserPrivilegeModel> getuserprivilegedetail(@RequestBody UserPrivilegeModel obj_userprivilege){		
		return obj_service.getuserprivilegedetail(obj_userprivilege);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/saveuserprivilege")
	public boolean saveuserprivilege(@RequestBody UserPrivilegeModel obj_priv) {
		System.out.println("id"+obj_priv.getUser_id());				
		System.out.println("name"+obj_priv.getUname());
				boolean flag=obj_service.saveuserprivilege(obj_priv);
					return flag;
			}


	@RequestMapping(method=RequestMethod.POST, value ="/updateprivilegestatus")
	public void updatestatus(@RequestBody UserPrivilegeModel obj_status)
	{
		logger.info("Controller : UserPrivilegeController || Method : updatestatus || isactive:" +obj_status.getCurrent_status());
		
		System.out.println("id"+ obj_status.getUser_id());	
	//String flag = 
		obj_service.updatestatus(obj_status);
//	return flag;
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/getsheduserdetail")
	public List<UserPrivilegeModel> getshedadminuserdetail(@RequestBody UserPrivilegeModel obj_userprivilege){		
		return obj_service.getshedadminuserdetail(obj_userprivilege);
	}
	
	// Jyoti Bisht 6-12-22  for User deletion
	@PostMapping("/delete_user_privilege")
	public boolean delete_user(@RequestParam("user_id") String user_id)
	{
		return obj_service.delete_user_details(user_id);
	}
	
}
