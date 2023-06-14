package com.mdms.app.mgmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.mdms.app.mgmt.model.UserProfileRegistrationDetailHistory;



public interface UserProfileRegistrationHistory  extends CrudRepository<UserProfileRegistrationDetailHistory, String>{
	
	@Transactional
	@Modifying
	@Query(value="insert into mdms_app_mgmt.user_profile_registration_history_table(user_id, name, designation, department, loco_type, shed, from_date, \r\n"
			+ "	to_date, role_type, user_type, mobile_no, entity, email, created_by, zone, division, user_register_approval, service_status, depo, \r\n"
			+ "	old_user_id, cris_user, asset_designation_code, additional_shed, additional_shed_active, additional_shed_date,last_status,updated_by) \r\n"
			+ "	\r\n"
			+ "	SELECT a.user_id, a.name, a.designation, a.department, a.loco_type, a.shed, a.from_date, a.to_date, a.role_type, a.user_type, \r\n"
			+ "	a.mobile_no, a.entity, a.email, a.created_by, a.zone, a.division, a.user_register_approval, a.service_status, a.depo, a.old_user_id, \r\n"
			+ "	a.cris_user, a.asset_designation_code, a.additional_shed, a.additional_shed_active, a.additional_shed_date, \r\n"
			+ "	b.current_status, ?2 FROM mdms_app_mgmt.user_profile_registration_detail a join mdms_app_mgmt.user_privilege b on a.user_id=b.user_id where b.user_id=?1",nativeQuery=true)
	 int insert_details(String user_id, String parent_id);
	

}
