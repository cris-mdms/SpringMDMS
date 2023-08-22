package com.mdms.app.mgmt.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.mdms.app.mgmt.model.SsoReceiveUserDetailsModel;

public interface ssosavedetails extends CrudRepository<SsoReceiveUserDetailsModel,String>{
	
	
   @Query(value="SELECT * FROM mdms_app_mgmt.sso_login_details where hrmsid=?1 ",nativeQuery=true)
	SsoReceiveUserDetailsModel getSSOUserById(String hrmsid);
   
   @Modifying
   @Transactional
   @Query(value="Update mdms_app_mgmt.sso_login_details set sessionid=?1, ssouid=?2, token=?3 where hrmsid=?4 ",nativeQuery=true)
int updatedetails(String sessionId, String ssoUid, String token,String hrmsid);
	
	

}
