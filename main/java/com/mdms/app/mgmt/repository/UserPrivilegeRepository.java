package com.mdms.app.mgmt.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.app.mgmt.model.UserPrivilegeModel;
import com.mdms.app.mgmt.model.UserProfileRegistrationDetailModel;
import com.mdms.app.mgmt.model.UserRegistrationJsonModel;

public interface UserPrivilegeRepository extends CrudRepository<UserPrivilegeModel,Long>{	
	@Query(value="SELECT * from mdms_app_mgmt.user_privilege where user_id=?1",nativeQuery=true)
	List<UserPrivilegeModel> getuserprivilegedetail(String userid);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE mdms_app_mgmt.user_privilege set current_status=?1, additional_role_type=?2, additional_role_active=?3 where user_id=?4",nativeQuery=true)
	int updatestatus(String currentstatus,String addtion_role , String addition_active, String userId);
		/*
	@Query(value="select * FROM mdms_app_mgmt.user_privilege where shed=?1 and additional_role_type='SHED_ADMIN' and additional_role_active='Y' and current_status='ACTIVE'",nativeQuery=true)
	List<UserPrivilegeModel> getshedadminuserdetail(String shedid);
	*/
	
	@Query(value="select a.name, a.designation , b.user_id from mdms_app_mgmt.user_profile_registration_detail a join mdms_app_mgmt.user_privilege b on a.user_id=b.user_id where  b.shed='ELTD' and b.additional_role_type='SHED_ADMIN' and b.additional_role_active='Y' and b.current_status='ACTIVE' ",nativeQuery=true)
	 List<Object[]> getshedadminuserdetail1(String shedid);
	
	
		// Jyoti Bisht 11-11-22
		@Query(value="select * FROM mdms_app_mgmt.user_privilege where shed=?1 and additional_role_type='SHED_ADMIN'",nativeQuery=true)
		List<UserPrivilegeModel> getshedadminuserdetail(String shedid);
		
		// Jyoti Bisht 06-12-22
		
		@Transactional
		@Modifying
		@Query(value="delete from mdms_app_mgmt.user_privilege where user_id=?1",nativeQuery=true)
		void delete_user(String uId);
	 
}
