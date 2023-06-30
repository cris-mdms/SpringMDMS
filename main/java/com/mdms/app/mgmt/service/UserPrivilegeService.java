package com.mdms.app.mgmt.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdms.app.mgmt.model.MasterUserLoginDetail;
import com.mdms.app.mgmt.model.OldUserDetailModel;
import com.mdms.app.mgmt.model.UserPrivilegeModel;
import com.mdms.app.mgmt.model.UserRegistrationJsonModel;
import com.mdms.app.mgmt.repository.UserPrivilegeRepository;
@Service
public class UserPrivilegeService {
	 Logger logger=LoggerFactory.getLogger(UserPrivilegeService.class);	 
	@Autowired
	UserPrivilegeRepository obj_repo;
	
	//fetch list of userdetail  :Developer :Ritu
	public List<UserPrivilegeModel> getuserprivilegedetail(UserPrivilegeModel obj_userprivilege ) {	
		String userid = obj_userprivilege.getUser_id();
		List<UserPrivilegeModel> temp= new ArrayList<>();
		obj_repo.getuserprivilegedetail(userid)			
        .forEach(temp::add);
		int size = temp.size();
//		return size;
		return temp;
	}
	
	
	//savedata
	//savedata
	public boolean saveuserprivilege(UserPrivilegeModel obj_save) {
		  boolean flag = false;
//		try{
			 logger.info("Service : UserPrivilegeService || Method : saveuserprivilege ||Create User Privilege ");		 
			 if(obj_repo.save(obj_save)!= null)
				{
							return true;	
				}
			 else
			 {
				 return false;
			 }
	}
		
	// update current status - Active/Long Leave 
	public void updatestatus(UserPrivilegeModel obj_status) {
		//String response = "not Reset";
	//	
		// try {
			 			 
			 logger.info("Service : UserPrivilegeService || Method : updatestatus ||NEW STATUS");		 
			 String uid=obj_status.getUser_id();
			 String curr_status=obj_status.getCurrent_status();
			 String addi_role= obj_status.getAdditional_role_type();
			 String addi_active= obj_status.getAdditional_role_active();
			 obj_repo.updatestatus(curr_status,addi_role,addi_active,uid);
			//	response="NEW STATUS" ;	
	//}catch(Exception ex) {
		
		//logger.info("Service : UserPrivilegeService || Method : updatestatus ||Exception Old STATUS" + ex.getMessage());
	//	response="Old STATUS";
//		System.out.print(ex.getMessage());
//	}
		//return response;
		
	}
	
//	//fetch list of sheduserdetail  :Developer :Ritu
//		public List<Object[]> getshedadminuserdetail1(UserPrivilegeModel obj_userprivilege ) {	
//			String shedid = obj_userprivilege.getShed();
//			List<String> temp= new ArrayList<>();
//			obj_repo.getshedadminuserdetail1(shedid)			
//	        .forEach(temp::add);		
////			return size;
//			return temp;
//		}
		
	//fetch list of sheduserdetail  :Developer :Ritu
	public List<UserPrivilegeModel> getshedadminuserdetail(UserPrivilegeModel obj_userprivilege ) {	
		String shedid = obj_userprivilege.getShed();
		List<UserPrivilegeModel> temp= new ArrayList<>();
		obj_repo.getshedadminuserdetail(shedid)			
        .forEach(temp::add);		
//		return size;
		return temp;
	}

	
	
	// Jyoti Bisht 6-12-22

	public boolean delete_user_details(String user_id)	{
		
		try
		{
			obj_repo.delete_user(user_id);
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
		
}
