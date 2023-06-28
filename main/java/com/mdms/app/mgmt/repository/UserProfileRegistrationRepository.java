package com.mdms.app.mgmt.repository;

import java.util.Date;
import java.util.List;


import java.util.Optional;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.mdms.app.mgmt.model.MasterUserLoginDetail;
import com.mdms.app.mgmt.model.UserProfileRegistrationDetailModel;
import com.mdms.app.mgmt.model.UserRegistrationJsonModel;
import com.mdms.mdms_masters.model.MDepartment;


public interface UserProfileRegistrationRepository extends CrudRepository<UserProfileRegistrationDetailModel,String>{
	
	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail where user_id=?1",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getUserRoleAndType(String user_id);
	
	
	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail where user_id=?1",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getUserDetail(String user_id);
	
	
	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail ",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getUserProfiles();
	

	@Query(value="SELECT user_id from mdms_app_mgmt.user_profile_registration_detail where division=?1 and designation='DCM'",nativeQuery=true)
	  String getSeniorIdForCMI(String division);
	
	
	@Query(value="SELECT user_id from mdms_app_mgmt.user_profile_registration_detail where division=?1 and designation='DOM'",nativeQuery=true)
	 String getSeniorIdForDTI(String division);

	@Transactional
	@Query(value="INSERT INTO mdms_app_mgmt.user_profile_registration_detail(\r\n" + 
			"user_id, name, designation, department, loco_type, shed, from_date,role_type,user_type,mobile_no,email,created_by)\r\n" + 
			"			VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7,?8,?9,?10,?11,?12)", nativeQuery = true)
	
	String saveUser( String user_id, String name,String designation,String department,String loco_type,
			String shed,Date from_date,String role_type,String user_type,String mobile_no,String email,String created_by);
	
	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail where user_type=?1",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getUserRecords(String user_type);

	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail where user_id=?1",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getUserControlRecords(String user_id);
	
	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail where user_id=?1",nativeQuery=true)
	 List<UserProfileRegistrationDetailModel> checkuserexistinregsitration(String user_id);
	

	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail WHERE user_type=?1 AND zone=?2 AND division=?3 AND department=?4 AND (from_date between ?5 and ?6)",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getCustomizeUserRecords(String utype ,String zone,String division,String department, Date from_to,Date to_date);
	
	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail WHERE user_type=?1 AND zone=?2 AND designation=?3 AND department=?4 AND (from_date between ?5 and ?6)",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> userzonedeprtdesigdatewisereport(String utype ,String zone,String designation,String department, Date from_to,Date to_date);
	
@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail WHERE  user_type=?1 AND (from_date between ?2 and ?3)",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getReportdatewise(String utype, Date from_date,Date to_date);

	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail WHERE user_type=?1 AND zone=?2 AND shed=?3",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getLocoUserRecordszoneandshedwise(String utype ,String zone,String shed);
	
@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail WHERE  user_type=?1 AND zone=?2 AND (from_date between ?3 and ?4)",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getReportzonaluserdatewise(String utype, String zone,Date from_date,Date to_date);

@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail WHERE  user_type=?1 AND division=?2 AND (from_date between ?3 and ?4)",nativeQuery=true)
List<UserProfileRegistrationDetailModel> getReportdivisionuserdatewise(String utype,String division, Date from_date,Date to_date);
	


@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail WHERE  user_type=?1  AND division=?2  AND department=?3  AND designation=?4 AND (from_date between ?5 and ?6)",nativeQuery=true)
List<UserProfileRegistrationDetailModel> getReportdivisionuserallparameter(String utype,String division,String deprt,String desig, Date from_date,Date to_date);
	
//@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail WHERE  user_type=?1  AND (from_date between ?4 and ?5)",nativeQuery=true)
//List<UserProfileRegistrationDetailModel> getReportdatewise(String utype, Date from_date,Date to_date);

	
	@Query(value="SELECT distinct department FROM  mdms_app_mgmt.user_profile_registration_detail", nativeQuery = true)
	List<String> findRegisteredDept(); 
	
	@Query(value="SELECT distinct designation FROM  mdms_app_mgmt.user_profile_registration_detail where  user_type=?1", nativeQuery = true)
	List<String> findRegisteredDesig(String utype); 
	@Query(value="SELECT * FROM mdms_app_mgmt.user_profile_registration_detail WHERE  department=?1 AND user_type=?2 ",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getUserReportdeprtwise(String department, String utype );
	
	@Query(value="SELECT * FROM mdms_app_mgmt.user_profile_registration_detail WHERE user_type=?1 AND department=?2 AND (from_date between ?3 and ?4)",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel>userreportdateanddeprtwise(String utype, String department, Date from_to,Date to_date);


	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail WHERE user_type=?1 AND zone=?2",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getUserReportzonewise(String utype,String zone);
	

	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail WHERE user_type=?1 AND zone=?2 AND (from_date between ?3 and ?4)",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getUserReportzoneandatewise(String utype,String zone,Date from_to,Date to_date);
	
			@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail where division=?1 and user_type=?2 and(coalesce(department,'')=?3 OR \r\n" + 

			"						coalesce(designation,'')=?4)",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getuserreportsingledivandsingdeprt(String division,String utype,String department,String desig);	

	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail WHERE  zone=?1 AND department=?2 AND user_type=?3 ",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getuserreportsinglezoneandsingledeprt(String zone,String department, String utype);

	
	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail where user_type=?1 and zone=?2 and division=?3 ",nativeQuery=true)
	List<UserProfileRegistrationDetailModel> getUserReportzoneanddivisiontwise(String utype,String zone,String division);
	
	
	
//	@Query(value="SELECT  a.*,b.description\n"
//			+ "	FROM mdms_app_mgmt.user_profile_registration_detail as a\n"
//			+ "	join mdms_app_mgmt.m_user_role as b on a.role_type=b.role_type where user_type=?1 and zone=?2 and division=?3\n"
//			+ ""			
//			+ "	 ",nativeQuery=true)
//	List<UserProfileRegistrationDetailModel> getUserReportzoneanddivisiontwise(String utype,String zone,String division);
	
	
	//----------------------------------------Divisional Admin User - Station Report-------------------------------------------------------//
	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail where user_type=?1 and division=?2",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getUserRecordsdivwise(String user_type,String divcode);
	
	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail where user_type=?1 and division=?2 and department=?3 and designation=?4",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getUserRecordsdivsingledeprtanddesignwise(String user_type,String divcode, String deprt, String desig);
	
	@Query(value="SELECT * FROM mdms_app_mgmt.user_profile_registration_detail WHERE user_type=?1 and division=?2 AND department=?3  ",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getUserReportdivdeprtwise(String utype,String div,String department  );
	
	@Query(value="SELECT * FROM mdms_app_mgmt.user_profile_registration_detail WHERE user_type=?1 and division=?2 AND designation=?3  ",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getUserReportdivdesigwise(String utype,String div,String desig  );
	
	@Query(value="SELECT * FROM mdms_app_mgmt.user_profile_registration_detail WHERE user_type=?1 AND division=?2 AND department=?3 AND (from_date between ?4 and ?5)",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel>divuserreportdateanddeprtwise(String utype,String div, String department, Date from_to,Date to_date);

	@Query(value="SELECT * FROM mdms_app_mgmt.user_profile_registration_detail WHERE user_type=?1 AND division=?2 AND designation=?3 AND (from_date between ?4 and ?5)",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel>divuserreportdateandesigwise(String utype, String div,String desig, Date from_to,Date to_date);

	
	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail WHERE user_type=?1 AND division=?2 ",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getUserReportdivisiontwise(String utype,String division);
	
	
	
	//--------------------------------------------------Shed Admin  User- Loco Report.................................................................................//
	
	
	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail where user_type=?1 and shed=?2",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getUserRecordsshedwise(String user_type,String shedcode);
	
	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail where user_type=?1 and shed=?2 and department=?3 and designation=?4",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getUserRecordsshedsingledeprtanddesignwise(String user_type,String shed, String deprt, String desig);
	
	@Query(value="SELECT * FROM mdms_app_mgmt.user_profile_registration_detail WHERE user_type=?1 and shed=?2 AND department=?3  ",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getUserReportsheddeprtwise(String utype,String shed,String department  );
	
	@Query(value="SELECT * FROM mdms_app_mgmt.user_profile_registration_detail WHERE user_type=?1 and shed=?2 AND designation=?3  ",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getUserReportsheddesigwise(String utype,String shed,String desig  );
	
	@Query(value="SELECT * FROM mdms_app_mgmt.user_profile_registration_detail WHERE user_type=?1 AND shed=?2 AND department=?3 AND (from_date between ?4 and ?5)",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel>getuserreportsheddateanddeprtwise(String utype,String shed, String department, Date from_to,Date to_date);

	@Query(value="SELECT * FROM mdms_app_mgmt.user_profile_registration_detail WHERE user_type=?1 AND shed=?2 AND designation=?3 AND (from_date between ?4 and ?5)",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel>getuserreportsheddateandesigwise(String utype, String shed,String desig, Date from_to,Date to_date);

	
	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail WHERE user_type=?1 AND shed=?2 ",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getUserReportshedwise(String utype,String shed);
	
	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail WHERE  user_type=?1  AND shed=?2  AND department=?3  AND designation=?4 AND (from_date between ?5 and ?6)",nativeQuery=true)
	List<UserProfileRegistrationDetailModel> getReportsheduserallparameter(String utype,String shed,String deprt,String desig, Date from_date,Date to_date);

	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail WHERE  user_type=?1 AND shed=?2 AND (from_date between ?3 and ?4)",nativeQuery=true)
	List<UserProfileRegistrationDetailModel> getReportsheduserdatewise(String utype,String shed, Date from_date,Date to_date);
	
	//-------------------------------------------Depot Admin - Coach Report Query---------------------//
	
	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail where user_type=?1 and depo=?2",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getUserRecordsdepotwise(String user_type,String depot);
	
	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail where user_type=?1 and depo=?2 and department=?3 and designation=?4",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getUserRecordsdepotwisesingledeprtanddesignwise(String user_type,String depo, String deprt, String desig);
	
	@Query(value="SELECT * FROM mdms_app_mgmt.user_profile_registration_detail WHERE user_type=?1 and depo=?2 AND department=?3  ",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getUserReportdepotwisedeprtwise(String utype,String depo,String department  );
	
	@Query(value="SELECT * FROM mdms_app_mgmt.user_profile_registration_detail WHERE user_type=?1 and depo=?2 AND designation=?3  ",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getUserReportdepotwisedesigwise(String utype,String depo,String desig  );
	
	@Query(value="SELECT * FROM mdms_app_mgmt.user_profile_registration_detail WHERE user_type=?1 AND depo=?2 AND department=?3 AND (from_date between ?4 and ?5)",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel>getuserreportdepotwisedateanddeprtwise(String utype,String depo, String department, Date from_to,Date to_date);

	@Query(value="SELECT * FROM mdms_app_mgmt.user_profile_registration_detail WHERE user_type=?1 AND depo=?2 AND designation=?3 AND (from_date between ?4 and ?5)",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel>getuserreportdepotwisedateandesigwise(String utype, String depo,String desig, Date from_to,Date to_date);

	
	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail WHERE user_type=?1 AND depo=?2 ",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getUserReportdepotwise(String utype,String depo);
	
	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail WHERE  user_type=?1  AND depo=?2  AND department=?3  AND designation=?4 AND (from_date between ?5 and ?6)",nativeQuery=true)
	List<UserProfileRegistrationDetailModel> getReportdepotwiseuserallparameter(String utype,String depo,String deprt,String desig, Date from_date,Date to_date);

	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail WHERE  user_type=?1 AND depo=?2 AND (from_date between ?3 and ?4)",nativeQuery=true)
	List<UserProfileRegistrationDetailModel> getReportdepotwiseuserdatewise(String utype,String depo, Date from_date,Date to_date);
	@Modifying
	@Transactional
	@Query(value="Update  mdms_app_mgmt.user_profile_registration_detail set additional_shed=?1, additional_shed_active=?2  where user_id=?3",nativeQuery=true)
	int updateuseraddtionalshed(String addshed , String activeshed,  String userId);
	
	
	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail where user_id=?1 and (additional_shed_active is NULL or additional_shed_active='N')",nativeQuery=true)
	List<UserProfileRegistrationDetailModel> getUserShedAndZone(String user_id);

	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail where user_id=?1 and additional_shed_active='Y'",nativeQuery=true)
	List<UserProfileRegistrationDetailModel> getActiveUser(String user_id);
	
	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail where user_id=?1 and additional_shed_active='Y'",nativeQuery=true)
	List<UserProfileRegistrationDetailModel> getActiveUser1(String user_id);

	
	
	@Transactional
	@Modifying
	@Query(value="update mdms_app_mgmt.user_profile_registration_detail set user_register_approval=?1 where user_id=?2",nativeQuery=true)
		void updateActivationStatus(String status, String uId);
	
	//Jyoti Bisht  14-10-22  To get no. of users registered BY STATION
	
	@Query(value="select count(*) from mdms_app_mgmt.user_profile_registration_detail where (from_date between ?1 and ?2) and user_type='SU'",nativeQuery=true)
	int get_User_count_station(Date localDate, Date localDate2);
	
	//Jyoti Bisht  14-10-22  To get no. of users registered BY LOCO
	
	@Query(value="select count(*) from mdms_app_mgmt.user_profile_registration_detail where (from_date between ?1 and ?2) and user_type='LU'",nativeQuery=true)
	int get_User_count_loco(Date localDate, Date localDate2);
	
	//Jyoti Bisht  14-10-22  To get no. of users registered BY COACH
	
	@Query(value="select count(*) from mdms_app_mgmt.user_profile_registration_detail where (from_date between ?1 and ?2) and user_type='CU'",nativeQuery=true)
	int get_User_count_coach(Date localDate, Date localDate2);
	
	//--- user privilege service-- ritu //
	//--- user privilege service-- ritu //	
	@Query(value="select * from mdms_app_mgmt.user_profile_registration_detail where zone=?1 and user_type=?2 and shed=?3 and role_type in ('DS','DAA') and user_register_approval='Y' and user_id not in (Select user_id from mdms_app_mgmt.user_privilege where additional_role_type='SHED_ADMIN')",nativeQuery=true)
	List<UserProfileRegistrationDetailModel> getuserdetailbyroleandtypezone(String zone, String utype, String shed );
	
	//
	//Jyoti Bisht 20-11-22
	@Query(value="select a.user_id, a.name, a.designation, a.department, a.division, b.current_status, b.additional_role_type, b.additional_role_active, a.role_type, a.mobile_no, a.email, a.additional_shed, a.additional_shed_active  \n"
			+ "	from mdms_app_mgmt.user_profile_registration_detail a left join mdms_app_mgmt.user_privilege b on a.user_id=b.user_id\n"
			+ "	where a.user_type=?1 and a.shed=?2 and a.zone=?3 and a.role_type in ('DS','DAA') and cris_user!='Y'  ",nativeQuery=true)
	List<Object[]> getuserdetailbyroleandtypezone1(String utype, String shed, String zone );
	
	//--end user privilege service-- //
	
	@Query(value="select a.name, a.designation , b.user_id from mdms_app_mgmt.user_profile_registration_detail a join mdms_app_mgmt.user_privilege b on a.user_id=b.user_id where  b.shed='ELTD' and b.additional_role_type='SHED_ADMIN' and b.additional_role_active='Y' and b.current_status='ACTIVE' ",nativeQuery=true)
	List<UserProfileRegistrationDetailModel> getshedadminuserdetail1(String shedid);

	@Transactional
	@Modifying
	@Query(value="delete from mdms_app_mgmt.user_profile_registration_detail where user_id=?1",nativeQuery=true)
		void delete_user(String uId);
	

	@Transactional
	@Modifying
	@Query(value="update mdms_app_mgmt.user_profile_registration_detail set email=?1, mobile_no=?2, user_type=?3 where user_id=?4",nativeQuery=true)
		void update_user_profile(String email, String mobile, String user_type, String uId);
	
	/*
	@Query(value="	select division_code, sum(e.user_count) from (\r\n"
			+ "		\r\n"
			+ "		select a.zone_code, COALESCE(r1.count,0) as \"user_count\"  from  mdms_masters.m_zone a left join \r\n"
			+ "			(select zone,count(*) as count from mdms_app_mgmt.user_profile_registration_detail \r\n"
			+ "		 where user_type='SU' AND role_type='DS' group by zone) r1 on r1.zone=a.zone_code \r\n"
			+ "					 where a.fois_zone is not null AND zone_code='CR' order by zone_code ) e join mdms_station.rbs_division on\r\n"
			+ "					 e.zone_code=mdms_station.rbs_division.zone_code group by division_code order by division_code", nativeQuery=true)
	*/
	
	@Query(value="select count(*) from mdms_app_mgmt.user_profile_registration_detail where division=?1 and user_type=?2 and role_type=?3", nativeQuery = true)
	int get_count_by_usertype(String division, String user_type, String role_type);
	

}
