package com.mdms.app.mgmt.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mdms.app.mgmt.model.UserLoginDetailModel;


public interface UserLoginDetailRepository extends CrudRepository<UserLoginDetailModel,String>{
	
	@Query(value="SELECT * from mdms_app_mgmt.user_login_detail where user_id=?1",nativeQuery=true)
	  List<UserLoginDetailModel> getDeatils(String userId);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE mdms_app_mgmt.user_login_detail SET emp_password=?1  where user_id=?2",nativeQuery=true)
	int updatePassword(String newPwd, String userId);


	@Transactional
	@Modifying
	@Query(value="UPDATE mdms_app_mgmt.user_login_detail SET is_active=?1  where user_id=?2",nativeQuery=true)
	int updateusersession(String isactive, String userId);
	
	@Query(value="SELECT * from mdms_app_mgmt.user_login_detail where user_id=?1",nativeQuery=true)
	 List<UserLoginDetailModel> checkusersessionactive(String userId);

	@Transactional
	@Modifying
	@Query(value="UPDATE mdms_app_mgmt.user_login_detail SET last_login_date=?1  where user_id=?2",nativeQuery=true)
	int updatelastlogindate(Date last_login_date, String userId);


	@Procedure(value="mdms_app_mgmt.f_get_user_type_list")
	String getUserTypes();

	

	@Procedure(value="mdms_app_mgmt.f_get_user_role_list")
	String getUserRoles();

	@Procedure(value="mdms_app_mgmt.f_get_user_type_role")
	String getUserTypeRoles(@Param("Puser_type") String Puser_type);	
	

	@Procedure(value="mdms_masters.f_get_departments_list")
	String getDepartments();

	

	@Procedure(value="mdms_masters.f_get_designation_list")
	String getDesignations();

	
	@Procedure(value="mdms_masters.f_get_zone_code")
	String getZones();

	
	@Procedure(value="mdms_masters.f_get_division_list")
	String getDivisions();

	
	@Procedure(value="mdms_loco.f_get_loco_type_list")
	String getLocoTypes();

	
	@Procedure(value="mdms_loco.f_get_loco_shed_list")
	String getLocoSheds();

	@Procedure(value="mdms_coach.f_get_coach_depo_list")
	String getCoachDepos();
	
	//Developer- Ritu dt. 11.9.21	
		@Procedure(value="mdms_loco.f_get_loco_shed")
		String getLocoshed(@Param("puser_shed") String puser_shed);




}

