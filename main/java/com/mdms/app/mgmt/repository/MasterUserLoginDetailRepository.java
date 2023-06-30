package com.mdms.app.mgmt.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.mdms.app.mgmt.model.LoginOtpModel;
import com.mdms.app.mgmt.model.MasterUserLoginDetail;


public interface MasterUserLoginDetailRepository  extends CrudRepository<MasterUserLoginDetail,Long>{
//	@Transactional
//	@Query(value="INSERT INTO mdms_app_mgmt.master_user_login_detail(\r\n" + 
//			"user_id,user_control)\r\n" + 
//			"			VALUES (?1, ?2)", nativeQuery = true)	
//	boolean saveMstrUser( String user_id, String user_control);
	
	@Query(value="SELECT *  from mdms_app_mgmt.master_user_login_detail where user_id=?1 ",nativeQuery=true)
	 List<MasterUserLoginDetail> checkmstruserexist(String user_id);
	
	@Query(value="SELECT * FROM mdms_app_mgmt.master_user_login_detail\r\n" + 
			"WHERE user_id = ?1 AND  emp_password=?2 AND current_date BETWEEN valid_from AND valid_to",nativeQuery=true)
	List<MasterUserLoginDetail> verifyOtp(String user_id,int emppwd);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE mdms_app_mgmt.master_user_login_detail set valid_from=?1,valid_to=?2, emp_password=?3 where user_id=?4 ",nativeQuery=true)
	int  updatepwd(Date valid_from, Date valid_to, int emp_password,String user_id);
	
	
	
	
}
