package com.mdms.app.mgmt.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.text.ParseException;


import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.mdms.PasswordSecurityConfiguration;
import com.mdms.app.mgmt.model.GetListUserRegistrationJsonModel;
import com.mdms.app.mgmt.model.MasterUserLoginDetail;
import com.mdms.app.mgmt.model.OldUserDetailModel;
import com.mdms.app.mgmt.model.UserLoginDetailModel;
import com.mdms.app.mgmt.model.UserProfileRegistrationDetailModel;
import com.mdms.app.mgmt.model.UserRegistrationJsonModel;
import com.mdms.app.mgmt.repository.MasterUserLoginDetailRepository;
import com.mdms.app.mgmt.repository.OldUserDetailRepository;
import com.mdms.app.mgmt.repository.UserLoginDetailRepository;
import com.mdms.app.mgmt.repository.UserProfileRegistrationRepository;
import com.mdms.loco.locouncleansed.model.LocoUncleansedDataElectric;
import com.mdms.mdms_masters.model.MDepartment;


@Service
public class UserProfileRegistrationService {

	
	@Autowired
	private UserLoginDetailRepository loginDetailRepo;
	
	@Autowired
	private UserProfileRegistrationRepository profileRegistrationRepo;
	
	 @Autowired
	 MasterUserLoginDetailRepository  mstRepoObj;
	 
	 @Autowired
		private OldUserDetailRepository oldRegistrationRepo;
		 
	
	
	 Logger logger=LoggerFactory.getLogger(UserProfileRegistrationService.class);
	 private final PasswordEncoder passwordEncoder = new PasswordSecurityConfiguration().passwordEncoder();
		
	 
	 public String  saveUserDetails(UserRegistrationJsonModel obj) {
		 UserLoginDetailModel userLoginDetailObj=new UserLoginDetailModel();
		 userLoginDetailObj.setUser_id(obj.getUser_id().toUpperCase());
		 String encodedPassword=""; 
		 //Hashing Password first
		 
		 
		 //System.out.print("pwd: "+ obj.getEmp_password());	 
		try {
				 encodedPassword = passwordEncoder.encode(obj.getEmp_password());
					logger.info("Service : UserProfileRegistrationService || Method : saveUserDetails ||");

//System.out.print("Encripted pwd: "+ encodedPassword);
		}catch(Exception ex) {
			
			logger.info("Service : UserProfileRegistrationService || Method : saveUserDetails ||Exception pwd encryption" + ex.getMessage());

		//	System.out.print(ex.getMessage());
		}
		 userLoginDetailObj.setEmp_password(encodedPassword);
		 userLoginDetailObj.setEmail(obj.getEmail());
		 userLoginDetailObj.setRole_type(obj.getRole_type());
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		 userLoginDetailObj.setTxn_timestamp(Timestamp.valueOf(formatter.format(new Date())));
		 userLoginDetailObj.setLast_password_change_txn_timestamp(Timestamp.valueOf(formatter.format(new Date())));
		 userLoginDetailObj.setLast_login_date(Timestamp.valueOf(formatter.format(new Date())));
	
	
	
	
	//save data in userprofileregistration tbl
	
	
	UserProfileRegistrationDetailModel registrationModelObj= new UserProfileRegistrationDetailModel();
	registrationModelObj.setUser_id(obj.getUser_id().toUpperCase());
	registrationModelObj.setUser_type(obj.getUser_type());
	registrationModelObj.setUname(obj.getUname().toUpperCase());
	registrationModelObj.setEmail(obj.getEmail());
	registrationModelObj.setDepartment(obj.getDepartment());
	registrationModelObj.setDesignation(obj.getDesignation());
	registrationModelObj.setLoco_type(obj.getLoco_type());
	registrationModelObj.setMobile_no(obj.getMobile_no());
	registrationModelObj.setRole_type(obj.getRole_type());
	registrationModelObj.setShed(obj.getShed());
	registrationModelObj.setFrom_date(new Date());
	registrationModelObj.setZone(obj.getZone());
	registrationModelObj.setDivision(obj.getDivision());
	//registrationModelObj.setTo_date(new Date());
	registrationModelObj.setCreated_by(obj.getUser_id().toUpperCase());
	registrationModelObj.setEntity("Entity");
	registrationModelObj.setUser_register_approval("Y");
	registrationModelObj.setHrms_service_status(obj.getHrms_service_status());
	registrationModelObj.setDepo(obj.getDepo());
	registrationModelObj.setOld_user_id(obj.getOld_user_id());
	registrationModelObj.setCris_user(obj.getCris_user());
	registrationModelObj.setAsset_designation_code(obj.getAsset_designation_code());	
	System.out.println("old user id "+obj.getOld_user_id());
	System.out.println("crisuser id "+obj.getCris_user());
    System.out.println("asset_desig_code"+obj.getAsset_designation_code());


	
	


//	String result = null;
	UserLoginDetailModel response = null;
//	try {
//		result= profileRegistrationRepo.saveUser(registrationModelObj.getUser_id(),registrationModelObj.getName(),registrationModelObj.getDesignation(),registrationModelObj.getDepartment()
//			,registrationModelObj.getLoco_type(),registrationModelObj.getShed(),registrationModelObj.getFrom_date()
//			,registrationModelObj.getRole_type(),registrationModelObj.getUser_type(),registrationModelObj.getMobile_no(),registrationModelObj.getEmail(),
//			registrationModelObj.getCreated_by());
//	System.out.print("result:"+result);
//	}catch(Exception ex) {
//	ex.getMessage();
//	if(ex.getMessage().contains("user_profile_registration_detail_pkey")) {
//		return "User Already Exist";
//	}
//	}
	try {
	 UserProfileRegistrationDetailModel result=profileRegistrationRepo.save(registrationModelObj);
	 response=loginDetailRepo.save(userLoginDetailObj);
	 response.getUser_id().toUpperCase();
		result.getUser_id().toUpperCase();
		logger.info("Service : UserRegistrationService || Method : saveUserDetails ||user_id: "+registrationModelObj.getUser_id());

	//save data in logindetails table
//		if(result!=null) {
//		 response=loginDetailRepo.save(userLoginDetailObj);
//		}
		
		
if(response!=null && result!=null) {
	
	
	
	logger.info("Service : UserProfileRegistrationService || Method : saveUserDetails ||Record Inserted Successfully " );

	return "Record Inserted Successfully";
}else {
	logger.info("Service : UserProfileRegistrationService || Method : saveUserDetails ||Record did not insert" );

	return "Record did not insert";
}
	}catch(Exception ex) {
		ex.getMessage();
		
		
		
		logger.info("Service : UserProfileRegistrationService || Method : saveUserDetails ||Exception " + ex.getMessage());

		return ex.getMessage();
	}
	
	 }
	 
	 
	
	 
	 public GetListUserRegistrationJsonModel getListUserRegistration() {
			logger.info("Service : UserProfileRegistrationService || Method : getListUserRegistration ");	 
	GetListUserRegistrationJsonModel obj = new GetListUserRegistrationJsonModel();
	 UserProfileRegistrationDetailModel objregi=new UserProfileRegistrationDetailModel();
	 
	String userType="";
	String userRole="";
	String userTypeRole="";
	String userDepartment="";
	String userDesignation= "";
	String zones="";
	String divisions="";
	String loco_types="";
	String sheds="";	
	String depo="";
	String oldid="";
String crisuser="";
String asset_designation_code="";

			
		try {
	 userType=	 loginDetailRepo.getUserTypes();
		}catch(Exception ex) {
			
			logger.info("Service : UserProfileRegistrationService || Method : getListUserRegistration ||Exception GET USERTYPE" + ex.getMessage());
			ex.getMessage();
		}
		
		try {
	 userRole=	 loginDetailRepo.getUserRoles();
		}catch(Exception ex) {
			logger.info("Service : UserProfileRegistrationService || Method : getListUserRegistration ||Exception GET USEROLE" + ex.getMessage());

			ex.getMessage();
		}
		
	
		try {
	 userDepartment=	 loginDetailRepo.getDepartments();
		}catch(Exception ex) {
			logger.info("Service : UserProfileRegistrationService || Method : getListUserRegistration ||Exception GET Departments" + ex.getMessage());

			ex.getMessage();
		}
		
		
		try {
	 userDesignation=	 loginDetailRepo.getDesignations();
		}catch(Exception ex) {
			logger.info("Service : UserProfileRegistrationService || Method : getListUserRegistration ||Exception GET Designations" + ex.getMessage());

			ex.getMessage();
		}
	try {
	 zones=	 loginDetailRepo.getZones();
	}catch(Exception ex) {
		ex.getMessage();
		logger.info("Service : UserProfileRegistrationService || Method : getListUserRegistration ||Exception GET zones" + ex.getMessage());

	}
	
	try {
	 divisions=	 loginDetailRepo.getDivisions();
	}catch(Exception ex) {
		ex.getMessage();
		logger.info("Service : UserProfileRegistrationService || Method : getListUserRegistration ||Exception GET divisions" + ex.getMessage());

	}
	
	
	try {
	 loco_types=	 loginDetailRepo.getLocoTypes();
	}catch(Exception ex) {
		ex.getMessage();
		logger.info("Service : UserProfileRegistrationService || Method : getListUserRegistration ||Exception GET locoTypes" + ex.getMessage());

	}
	
	try {
	 sheds=	 loginDetailRepo.getLocoSheds();
	}catch(Exception ex) {
		ex.getMessage();
		logger.info("Service : UserProfileRegistrationService || Method : getListUserRegistration ||Exception GET locoSheds" + ex.getMessage());

	}

	try {
		 depo=loginDetailRepo.getCoachDepos();
		}catch(Exception ex) {
			ex.getMessage();
			logger.info("Service : UserProfileRegistrationService || Method : getListUserRegistration ||Exception GET CoachDepos" + ex.getMessage());

		}
	
	
	try {
	obj.setUser_role_list(userRole);
	obj.setUser_type_list(userType);
	obj.setDepartment_list(userDepartment);
	obj.setDesignation_list(userDesignation);
	obj.setDivision_list(divisions);
	obj.setZone_list(zones);
	obj.setLoco_shed_list(sheds);
  
    obj.setUser_type_role_list(userTypeRole);

	obj.setLoco_type_list(loco_types);	

	obj.setLoco_type_list(loco_types);
	obj.setDepo_list(depo);

	}catch(Exception ex) {
		
		ex.getMessage();
	}

		 return obj ;
		 
	 }
	 
	 
	 public String  getusertyperole(@RequestBody UserRegistrationJsonModel userObj) {	
		 String utype= userObj.getUser_type();
		 String response=loginDetailRepo.getUserTypeRoles(utype);
			logger.info("Service : UserProfileRegistrationService || Method : getUserTypeRoles||user_Type: "+utype+"||response:"+response);
		 return response;
		 } 
	 

	 public String  getLocoshed(@RequestBody UserRegistrationJsonModel  Obj) {	
		 String uzone= Obj.getZone();
		 String response=loginDetailRepo.getLocoshed(uzone);
			logger.info("Service : UserProfileRegistrationService || Method : getLocoshed||user_zone: "+uzone+"||response:"+response);
		 return response;
		 } 

	 
	
	
	  


	 public String findUserRecord(String user_id) {	 		 

			logger.info("Service : UserProfileRegistrationService || Method : findUserRecord ||userID " + user_id);

		 List<UserLoginDetailModel>  list= loginDetailRepo.getDeatils(user_id);
// System.out.print("list: "+list.size() +"||User_id: "+user_id);
		 if(list.size()>0) {			 
				logger.info("Service : UserProfileRegistrationService || Method : findUserRecord ||Response User Already Exist");

			return "User Already Exist"; 
		 }else {
			 
				logger.info("Service : UserProfileRegistrationService || Method : findUserRecord ||Response User not exist");
			 return "User Not Exist";
		 }
		 
		
	 }


	 public UserProfileRegistrationDetailModel getUserDetail(String user_id) {
		 List<UserProfileRegistrationDetailModel> list = new ArrayList<UserProfileRegistrationDetailModel>();

		
		 UserProfileRegistrationDetailModel obj = new UserProfileRegistrationDetailModel(); 		 
		list= profileRegistrationRepo.getUserRoleAndType(user_id);
		 if(list.size()>0) {
			 if(list.get(0).getUser_type().equalsIgnoreCase("SU")  ) {

			
			 }
			 
			 return list.get(0);
		 }else {
			return obj; 
		 }
		 
			 
	 }
	 
	public String seniorID(String designation,String division) {
		
		String seniorId="";
		 if(designation.equalsIgnoreCase("CMI")||designation.equalsIgnoreCase("COMMERCIAL INSPECTOR")||designation.equalsIgnoreCase("CHIEF COMMERCIAL INSPECTOR")||designation.equalsIgnoreCase("CHIEF COMMERCIAL SUPERVISOR(CCS)")||designation.equalsIgnoreCase("CHIEF COMMERCIAL INSPECTOR /CHIEF COMMERCIAL SUPERVISOR(CCS)"))
		 {
			seniorId=  profileRegistrationRepo.getSeniorIdForCMI(division); 
			 
			 
		 }else if (designation.equalsIgnoreCase("DTI")||designation.equalsIgnoreCase("TRAFFIC INSPECTOR")||designation.equalsIgnoreCase("CHIEF TRAFFIC INSPECTOR")||designation.equalsIgnoreCase("TRAFFIC INSPECTOR (PLANNING)")||designation.equalsIgnoreCase("TRAFFIC INSPECTOR (MOVEMENT)")) {
			 seniorId=  profileRegistrationRepo.getSeniorIdForDTI(division); 
		 }
		
		return seniorId;		
	}
	//fetch list of userdetail  based on user type:Developer :Ritu
		public List<UserProfileRegistrationDetailModel> getalluserdetail(UserProfileRegistrationDetailModel objurecord ) {	
		
			String usertype = objurecord.getUser_type();
			List<UserProfileRegistrationDetailModel> temp= new ArrayList<>();
			profileRegistrationRepo.getUserRecords(usertype)
	        .forEach(temp::add);
			return temp;
		}
		
		//fetch list of userdetail  :Developer :Ritu
				public List<UserProfileRegistrationDetailModel> getusercontrol(UserProfileRegistrationDetailModel objuctrl ) {	
					String userid = objuctrl.getUser_id();
					List<UserProfileRegistrationDetailModel> temp= new ArrayList<>();
					profileRegistrationRepo.getUserControlRecords(userid)
			        .forEach(temp::add);
					return temp;
				}
				
				
				 public List<MasterUserLoginDetail> findMstrUserRecord(String user_id) {	 
						logger.info("Service : UserProfileRegistrationService || Method : findMstrUserRecord ||user_id " + user_id);
					 List<MasterUserLoginDetail>  list= mstRepoObj.checkmstruserexist(user_id);
			// System.out.print("list: "+list.size() +"||User_id: "+user_id);
					 if(list.size()>0) {						 
							logger.info("Service : UserProfileRegistrationService || Method : findMstrUserRecord ||Response User Already Exist");
 						return list ; 
					 }else {						 
							logger.info("Service : UserProfileRegistrationService || Method : findMstrUserRecord ||Response User not exist");
						
						 return  list ; 
					 }
					 
					
				 }
		 
				 
				 public String findUserRecorinRegistration(String user_id) {			 

						logger.info("Service : UserProfileRegistrationService || Method : findUserRecorinRegistration ||user_id " + user_id);

					 List<UserProfileRegistrationDetailModel>  list= profileRegistrationRepo.checkuserexistinregsitration(user_id);
			// System.out.print("list: "+list.size() +"||User_id: "+user_id);
					 if(list.size()>0) {			 
							logger.info("Service : UserProfileRegistrationService || Method : findUserRecorinRegistration ||Response User Already Exist");

						return "User Already Exist"; 
					 }else {
						 
							logger.info("Service : UserProfileRegistrationService || Method : findUserRecorinRegistration ||Response User not exist");
						 return "User Not Exist";					 }
					 
					
				 }
				 
				//service to Update master password in master login table
					public boolean updatemstrpwd(MasterUserLoginDetail obj_pwdupdate) {
						try{				
						
							
						Date var1=obj_pwdupdate.getValid_from();
						Date var2=obj_pwdupdate.getValid_to();	
					     int emp_password=obj_pwdupdate.getEmp_password();
					     String uid=obj_pwdupdate.getUser_id();
						System.out.println(uid);
						mstRepoObj.updatepwd(var1, var2,emp_password,uid);//						
						return  true ;			
						}
						catch(Exception e){
							
							System.out.println(e);
							return false;
						}					
					}
				
					
					//fetch report based on department and date :Developer :Ritu
					public List<UserProfileRegistrationDetailModel> getreportdeprtanddatewise(UserProfileRegistrationDetailModel objdeprtdate ) {
						System.out.println("objrecd."+objdeprtdate);
					String user_type=objdeprtdate.getUser_type();
						String user_deprt = objdeprtdate.getDepartment();	
						Date date_from =objdeprtdate.getFrom_date();
						Date date_to =objdeprtdate.getTo_date();	
						Date date_fromto=date_to;
						System.out.println(date_from);
						System.out.println(date_to);						
						List<UserProfileRegistrationDetailModel> temp= new ArrayList<>();
						profileRegistrationRepo.userreportdateanddeprtwise(user_type,user_deprt,date_from,date_fromto)
				        .forEach(temp::add);
						System.out.println(temp);
						return temp;
						
					}
					
//					//fetch list of userdetail according to all parameter for divisioNAL USER:Developer :Ritu
//					public List<UserProfileRegistrationDetailModel> getcustomizeduserdetaildivisionuser(UserProfileRegistrationDetailModel objdatedashboaduser ) {		
//						String user_type=objdatedashboaduser.getUser_type();
//						String user_divi = objdatedashboaduser.getDivision();	
//						String user_deprt = objdatedashboaduser.getDepartment();
//						String user_desig = objdatedashboaduser.getDesignation();						
//						Date from_dt = objdatedashboaduser.getFrom_date();
//						Date to_date = objdatedashboaduser.getTo_date();	
//						Date date_to=to_date;
//						List<UserProfileRegistrationDetailModel> temp= new ArrayList<>();
//						profileRegistrationRepo.getReportdivisionuserallparameter(user_type,user_divi,user_deprt,user_desig,from_dt,date_to)
//				        .forEach(temp::add);
//						System.out.println(temp);
//						return temp;
//						
//					}
					
					
					public String findOldUserRecorinRegistration(String olduser_id) {			 

						logger.info("Service : UserProfileRegistrationService || Method : findOldUserRecorinRegistration ||olduser_id " + olduser_id);

					 List<OldUserDetailModel>  list= oldRegistrationRepo.checkuserexistinoldregsitration(olduser_id);
			
					 if(list.size()>0) {			 
							logger.info("Service : UserProfileRegistrationService || Method : findOldUserRecorinRegistration ||Response User Already Exist");

						return "User Already Exist"; 
					 }else {
						 
							logger.info("Service : UserProfileRegistrationService || Method : findOldUserRecorinRegistration ||Response User not exist");
						 return "User Not Exist";					 }
					 
					
				 }
					

public String updateflagolduser(OldUserDetailModel obj_flag) {
	String response = "not Reset";
	
	 try {
		 			 
		 logger.info("Service : UserProfileRegistrationService || Method : updateflagolduser ||NEW Flag ");		 
		 String uid=obj_flag.getOld_user_id();	
		 oldRegistrationRepo.updateFlag(uid);
			response=  "NEW Flag" ;	
}catch(Exception ex) {
	
	logger.info("Service : UserProfileRegistrationService || Method : updateflagolduser ||Exception Old User Flag" + ex.getMessage());
	response="OLD Flag";
//	System.out.print(ex.getMessage());
}
	return response;
	
}
public List<String> getAllRegisteredDepartment() {
	// TODO Auto-generated method stub
	return profileRegistrationRepo.findRegisteredDept();
}

public List<String> getAllRegisteredDesignation(UserProfileRegistrationDetailModel objdesig) {
	// TODO Auto-generated method stub
	String utype=objdesig.getUser_type();
	return profileRegistrationRepo.findRegisteredDesig(utype);
}
//get user report zone based :Developer :Ritu
public List<UserProfileRegistrationDetailModel> getuserreportzonewise(UserProfileRegistrationDetailModel objzonereport ) {	
	String user_type = objzonereport.getUser_type();
	String user_zone = objzonereport.getZone();				
	List<UserProfileRegistrationDetailModel> temp= new ArrayList<>();
	profileRegistrationRepo.getUserReportzonewise(user_type,user_zone)
    .forEach(temp::add);
	System.out.println(temp);
	return temp;
	
}

//get user report division based :Developer :Ritu
public List<UserProfileRegistrationDetailModel> getuserreportdiviwise(UserProfileRegistrationDetailModel objdivireport ) {	
	String user_type = objdivireport.getUser_type();
	String user_divi = objdivireport.getDivision();				
	List<UserProfileRegistrationDetailModel> temp= new ArrayList<>();
	profileRegistrationRepo.getUserReportdivisiontwise(user_type,user_divi)
  .forEach(temp::add);
	System.out.println(temp);
	return temp;
	
}

//get user report zone and  division based :Developer :Ritu
public List<UserProfileRegistrationDetailModel> getuserreportzoneanddiviwise(UserProfileRegistrationDetailModel objdivireport ) {	
	String user_type = objdivireport.getUser_type();
	String user_zone = objdivireport.getZone();
	String user_divi = objdivireport.getDivision();				
	List<UserProfileRegistrationDetailModel> temp= new ArrayList<>();
	profileRegistrationRepo.getUserReportzoneanddivisiontwise(user_type,user_zone,user_divi)
.forEach(temp::add);
	System.out.println(temp);
	return temp;
	
}

//get user report department based :Developer :Ritu
public List<UserProfileRegistrationDetailModel> getuserreportdepartmentwise(UserProfileRegistrationDetailModel objdeprtreport ) {	
	String user_type = objdeprtreport.getUser_type();
	String user_deprt = objdeprtreport.getDepartment();				
	List<UserProfileRegistrationDetailModel> temp= new ArrayList<>();
	profileRegistrationRepo.getUserReportdeprtwise(user_deprt,user_type)
.forEach(temp::add);
	System.out.println(temp);
	return temp;	
}

	 

//get user report single zone and department based :Developer :Ritu
public List<UserProfileRegistrationDetailModel> getuserreportsinglezoneandeprttwise(UserProfileRegistrationDetailModel objzonedeprtreport ) {
	String user_type = objzonedeprtreport.getUser_type();
	String user_zone = objzonedeprtreport.getZone();	
	String user_deprt = objzonedeprtreport.getDepartment();				
	List<UserProfileRegistrationDetailModel> temp= new ArrayList<>();
	profileRegistrationRepo.getuserreportsinglezoneandsingledeprt(user_zone,user_deprt,user_type)
.forEach(temp::add);
	System.out.println(temp);
	return temp;
	
}


//get user report single divi and department based :Developer :Ritu
public List<UserProfileRegistrationDetailModel> getuserreportsinglediviandeprttwise(UserProfileRegistrationDetailModel objdivideprtreport ) {	
	
	String user_divi = objdivideprtreport.getDivision();	
	String user_type = objdivideprtreport.getUser_type();
	String user_deprt = objdivideprtreport.getDepartment();	
	String user_desig = objdivideprtreport.getDesignation();	
	List<UserProfileRegistrationDetailModel> temp= new ArrayList<>();
	profileRegistrationRepo.getuserreportsingledivandsingdeprt(user_divi,user_type,user_deprt,user_desig)
.forEach(temp::add);
	System.out.println(temp);
	return temp;
	
}
//get user report single divi and department&desig based :Developer :Ritu
public List<UserProfileRegistrationDetailModel> userzonedeprtdesigdatewisereport(UserProfileRegistrationDetailModel objdivideprtdesigreport ) {	
		
	String user_type = objdivideprtdesigreport.getUser_type();
	String zone=objdivideprtdesigreport.getZone();
	String user_desig = objdivideprtdesigreport.getDesignation();	
	String user_deprt = objdivideprtdesigreport.getDepartment();	
	Date date_from =objdivideprtdesigreport.getFrom_date();
	Date date_to =objdivideprtdesigreport.getTo_date();	
	Date date_fromto=date_to;
	List<UserProfileRegistrationDetailModel> temp= new ArrayList<>();
	profileRegistrationRepo.userzonedeprtdesigdatewisereport(user_type,zone,user_desig,user_deprt,date_from,date_fromto)
.forEach(temp::add);
	System.out.println(temp);
	return temp;
	
}
public List<UserProfileRegistrationDetailModel> getUserReportzoneandatewise(UserProfileRegistrationDetailModel objdivideprtdesigreport ) {	
	
	String user_type = objdivideprtdesigreport.getUser_type();
	String zone=objdivideprtdesigreport.getZone();
	Date date_from =objdivideprtdesigreport.getFrom_date();
	Date date_to =objdivideprtdesigreport.getTo_date();	
	Date date_fromto=date_to;
	List<UserProfileRegistrationDetailModel> temp= new ArrayList<>();
	profileRegistrationRepo.getUserReportzoneandatewise(user_type,zone,date_from,date_fromto)
.forEach(temp::add);
	System.out.println(temp);
	return temp;
	
}
//get user report single divi and department&desig based :Developer :Ritu
public List<UserProfileRegistrationDetailModel> getuserreportsinglediviandeprttanddesigwise(UserProfileRegistrationDetailModel objdivideprtdesigreport ) {	
		
	String user_type = objdivideprtdesigreport.getUser_type();
	String user_divi = objdivideprtdesigreport.getDivision();
	String user_deprt = objdivideprtdesigreport.getDepartment();	
	String user_desig = objdivideprtdesigreport.getDesignation();	
	List<UserProfileRegistrationDetailModel> temp= new ArrayList<>();
	profileRegistrationRepo.getUserRecordsdivsingledeprtanddesignwise(user_type,user_divi,user_deprt,user_desig)
.forEach(temp::add);
	System.out.println(temp);
	return temp;
}

//get user report single divi and department&desig based :Developer :Ritu
public List<UserProfileRegistrationDetailModel> getUserReportdivdeprtwise(UserProfileRegistrationDetailModel objdivideprtreport ) {	
		
	String user_type = objdivideprtreport.getUser_type();
	String user_divi = objdivideprtreport.getDivision();
	String user_deprt = objdivideprtreport.getDepartment();	
		
	List<UserProfileRegistrationDetailModel> temp= new ArrayList<>();
	profileRegistrationRepo.getUserReportdivdeprtwise(user_type,user_divi,user_deprt)
.forEach(temp::add);
	System.out.println(temp);
	return temp;
	
}//get user report single divi and department&desig based :Developer :Ritu
public List<UserProfileRegistrationDetailModel> getUserReportdivdesigwise(UserProfileRegistrationDetailModel objdividesigreport ) {	
		
	String user_type = objdividesigreport.getUser_type();
	String user_divi = objdividesigreport.getDivision();

	String user_desig = objdividesigreport.getDesignation();	
	List<UserProfileRegistrationDetailModel> temp= new ArrayList<>();
	profileRegistrationRepo.getUserReportdivdesigwise(user_type,user_divi,user_desig)
.forEach(temp::add);
	System.out.println(temp);
	return temp;
	
}

//get report zone &  datewise based :Developer :Ritu
public List<UserProfileRegistrationDetailModel> getreportzonedatewise(UserProfileRegistrationDetailModel objreportdatewise ) {
	System.out.println("objrecd."+objreportdatewise);	
	String user_type = objreportdatewise.getUser_type();
	String zone =objreportdatewise.getZone();
	Date date_from =objreportdatewise.getFrom_date();
	Date date_to =objreportdatewise.getTo_date();	
	Date date_fromto=date_to;
	System.out.println(date_from);
	System.out.println(date_to);						
	List<UserProfileRegistrationDetailModel> temp= new ArrayList<>();
	profileRegistrationRepo.getReportzonaluserdatewise(user_type,zone,date_from,date_fromto)
    .forEach(temp::add);
	System.out.println(temp);
	return temp;
	
}

//get report zone,division &  datewise based :Developer :Ritu
public List<UserProfileRegistrationDetailModel> getreportdivisiondatewise(UserProfileRegistrationDetailModel objreportdatewise ) {
	System.out.println("objrecd."+objreportdatewise);	
	String user_type = objreportdatewise.getUser_type();	
	String division =objreportdatewise.getDivision();	
	Date date_from =objreportdatewise.getFrom_date();
	Date date_to =objreportdatewise.getTo_date();	
	Date date_fromto=date_to;
	System.out.println(date_from);
	System.out.println(date_to);						
	List<UserProfileRegistrationDetailModel> temp= new ArrayList<>();
	profileRegistrationRepo.getReportdivisionuserdatewise(user_type,division,date_from,date_fromto)
  .forEach(temp::add);
	System.out.println(temp);
	return temp;
	
}
//get report   datewise based :Developer :Ritu
public List<UserProfileRegistrationDetailModel> getreportdatewise(UserProfileRegistrationDetailModel objreportdatewise ) {
	System.out.println("objrecd."+objreportdatewise);	
	String user_type = objreportdatewise.getUser_type(); 
	Date date_from =objreportdatewise.getFrom_date();
	Date date_to =objreportdatewise.getTo_date();	
	Date date_fromto=date_to;
	System.out.println(date_from);
	System.out.println(date_to);						
	List<UserProfileRegistrationDetailModel> temp= new ArrayList<>();
	profileRegistrationRepo.getReportdatewise(user_type,date_from,date_fromto)
.forEach(temp::add);
	System.out.println(temp);
	return temp;
	
}


//---------------------------------divisional user report-- Station-----------------------------------------//
//fetch list of userdetail  based on user type& Divisioanl:Developer :Ritu


		public List<UserProfileRegistrationDetailModel> getalldivuserdetail(UserProfileRegistrationDetailModel objurecord ) {	
			String usertype = objurecord.getUser_type();
			String userdiv = objurecord.getDivision();
			List<UserProfileRegistrationDetailModel> temp= new ArrayList<>();		
			profileRegistrationRepo.getUserRecordsdivwise(usertype,userdiv)
	        .forEach(temp::add);
			return temp;
		}
		


//get report depart&  datewise based :Developer :Ritu
public List<UserProfileRegistrationDetailModel> divuserreportdateanddeprtwise(UserProfileRegistrationDetailModel obj1 ) {
	System.out.println("objrecd."+obj1);	
	String user_type = obj1.getUser_type(); 
	String user_div = obj1.getDivision(); 
	String deprt=obj1.getDepartment();
	Date date_from =obj1.getFrom_date();
	Date date_to =obj1.getTo_date();	
	Date date_fromto=date_to;
	System.out.println(date_from);
	System.out.println(date_to);						
	List<UserProfileRegistrationDetailModel> temp= new ArrayList<>();
	profileRegistrationRepo.divuserreportdateanddeprtwise(user_type,user_div,deprt,date_from,date_fromto)
.forEach(temp::add);
	System.out.println(temp);
	return temp;
	
}

//get report desig&  datewise based :Developer :Ritu
public List<UserProfileRegistrationDetailModel> divuserreportdateandesigwise(UserProfileRegistrationDetailModel obj2 ) {
	System.out.println("objrecd."+obj2);	
	String user_type = obj2.getUser_type(); 
	String user_div = obj2.getDivision(); 
	String desig=obj2.getDesignation();
	Date date_from =obj2.getFrom_date();
	Date date_to =obj2.getTo_date();	
	Date date_fromto=date_to;
	System.out.println(date_from);
	System.out.println(date_to);						
	List<UserProfileRegistrationDetailModel> temp= new ArrayList<>();
	profileRegistrationRepo.divuserreportdateandesigwise(user_type,user_div,desig,date_from,date_fromto)
.forEach(temp::add);
	System.out.println(temp);
	return temp;
	
}








//---------------------------------Shed Admin report-- Loco-----------------------------------------//
//fetch list of user  based on user type & shed:Developer :Ritu


		public List<UserProfileRegistrationDetailModel> getallsheduserdetail(UserProfileRegistrationDetailModel objurecord ) {	
			String usertype = objurecord.getUser_type();
			String usershed = objurecord.getShed();
			List<UserProfileRegistrationDetailModel> temp= new ArrayList<>();		
			profileRegistrationRepo.getUserRecordsshedwise(usertype,usershed)
	        .forEach(temp::add);
			return temp;
		}
		



public List<UserProfileRegistrationDetailModel> sheduserreportdateanddeprtwise(UserProfileRegistrationDetailModel obj1 ) {
	System.out.println("objrecd."+obj1);	
	String user_type = obj1.getUser_type(); 
	String usershed = obj1.getShed();
	String deprt=obj1.getDepartment();
	Date date_from =obj1.getFrom_date();
	Date date_to =obj1.getTo_date();	
	Date date_fromto=date_to;
	System.out.println(date_from);
	System.out.println(date_to);						
	List<UserProfileRegistrationDetailModel> temp= new ArrayList<>();
	profileRegistrationRepo.getuserreportsheddateanddeprtwise(user_type,usershed,deprt,date_from,date_fromto)
.forEach(temp::add);
	System.out.println(temp);
	return temp;
	
}

//get report desig&  datewise based :Developer :Ritu
public List<UserProfileRegistrationDetailModel> sheduserreportdateandesigwise(UserProfileRegistrationDetailModel obj2 ) {
	System.out.println("objrecd."+obj2);	
	String user_type = obj2.getUser_type(); 
	String usershed = obj2.getShed();
	String desig=obj2.getDesignation();
	Date date_from =obj2.getFrom_date();
	Date date_to =obj2.getTo_date();	
	Date date_fromto=date_to;
	System.out.println(date_from);
	System.out.println(date_to);						
	List<UserProfileRegistrationDetailModel> temp= new ArrayList<>();
	profileRegistrationRepo.getuserreportsheddateanddeprtwise(user_type,usershed,desig,date_from,date_fromto)
.forEach(temp::add);
	System.out.println(temp);
	return temp;
	
}

//fetch list of userdetail according to all parameter for divisioNAL USER:Developer :Ritu
public List<UserProfileRegistrationDetailModel> getReportdivisionuserallparameter(UserProfileRegistrationDetailModel objdatedashboaduser ) {		
	String user_type=objdatedashboaduser.getUser_type();
	String user_divi = objdatedashboaduser.getDivision();	
	String user_deprt = objdatedashboaduser.getDepartment();
	String user_desig = objdatedashboaduser.getDesignation();						
	Date from_dt = objdatedashboaduser.getFrom_date();
	Date to_date = objdatedashboaduser.getTo_date();	
	Date date_to=to_date;
	List<UserProfileRegistrationDetailModel> temp= new ArrayList<>();
	profileRegistrationRepo.getReportdivisionuserallparameter(user_type,user_divi,user_deprt,user_desig,from_dt,date_to)
    .forEach(temp::add);
	System.out.println(temp);
	return temp;
	
}


//fetch list of loco userdetail according to zone,shed based :Developer :Ritu
public List<UserProfileRegistrationDetailModel> getLocoUserRecordszoneandshedwise(UserProfileRegistrationDetailModel objdashboaduser ) {
	System.out.println("objrecd."+objdashboaduser);
	String user_type=objdashboaduser.getUser_type();
	String user_zone = objdashboaduser.getZone();
	String user_shed = objdashboaduser.getShed();						
					
	List<UserProfileRegistrationDetailModel> temp= new ArrayList<>();
	profileRegistrationRepo.getLocoUserRecordszoneandshedwise(user_type,user_zone,user_shed)
    .forEach(temp::add);
	System.out.println(temp);
	return temp;
	
}


//fetch list of loco userdetail according to zone,shed based :Developer :Ritu
public List<UserProfileRegistrationDetailModel> getReportsheduserallparameter(UserProfileRegistrationDetailModel objdashboaduser ) {
	System.out.println("objrecd."+objdashboaduser);
	String user_type=objdashboaduser.getUser_type();	
	String user_shed = objdashboaduser.getShed();						
	String user_deprt = objdashboaduser.getDepartment();
	String user_desig = objdashboaduser.getDesignation();						
	Date from_dt = objdashboaduser.getFrom_date();
	Date to_date = objdashboaduser.getTo_date();	
	Date date_to=to_date;
	List<UserProfileRegistrationDetailModel> temp= new ArrayList<>();
	profileRegistrationRepo.getReportsheduserallparameter(user_type,user_shed,user_deprt,user_desig,from_dt,date_to)
  .forEach(temp::add);
	System.out.println(temp);
	return temp;
	
}


//get user report single shed and department based :Developer :Ritu
public List<UserProfileRegistrationDetailModel> getuserreportsingleshedandeprttwise(UserProfileRegistrationDetailModel obj2 ) {	
	
	
	String user_type = obj2.getUser_type();
	String user_shed = obj2.getShed();	
	String user_deprt = obj2.getDepartment();		
	List<UserProfileRegistrationDetailModel> temp= new ArrayList<>();
	profileRegistrationRepo.getUserReportsheddeprtwise(user_type,user_shed,user_deprt)
.forEach(temp::add);
	System.out.println(temp);
	return temp;
	
}

//get user report single shed and department based :Developer :Ritu
public List<UserProfileRegistrationDetailModel> getuserreportsingleshedandesigwise(UserProfileRegistrationDetailModel obj2 ) {	
	String user_type = obj2.getUser_type();
	String user_shed = obj2.getShed();	
	String user_desig = obj2.getDesignation();		
	List<UserProfileRegistrationDetailModel> temp= new ArrayList<>();
	profileRegistrationRepo.getUserReportsheddesigwise(user_type,user_shed,user_desig)
.forEach(temp::add);
	System.out.println(temp);
	return temp;
	
}

//fetch report based on shed and  date :Developer :Ritu
public List<UserProfileRegistrationDetailModel> getreportshedanddatewise(UserProfileRegistrationDetailModel obj ) {
	System.out.println("objrecd."+obj);
String user_type=obj.getUser_type();
	String user_shed = obj.getShed();	
	Date date_from =obj.getFrom_date();
	Date date_to =obj.getTo_date();	
	Date date_fromto=date_to;
	System.out.println(date_from);
	System.out.println(date_to);						
	List<UserProfileRegistrationDetailModel> temp= new ArrayList<>();
	profileRegistrationRepo.getReportsheduserdatewise(user_type,user_shed,date_from,date_fromto)
    .forEach(temp::add);
	System.out.println(temp);
	return temp;
	
}

public List<UserProfileRegistrationDetailModel> getuserreportsheddateandesigwise(UserProfileRegistrationDetailModel obj ) {
	System.out.println("objrecd."+obj);
String user_type=obj.getUser_type();
	String user_shed = obj.getShed();	
	String desig=obj.getDesignation();
	Date date_from =obj.getFrom_date();
	Date date_to =obj.getTo_date();	
	Date date_fromto=date_to;
	System.out.println(date_from);
	System.out.println(date_to);						
	List<UserProfileRegistrationDetailModel> temp= new ArrayList<>();
	profileRegistrationRepo.getuserreportsheddateandesigwise(user_type,user_shed,desig,date_from,date_fromto)
    .forEach(temp::add);
	System.out.println(temp);
	return temp;
	
}

//---------------------------------Depot Admin report Service -- Coach-----------------------------------------//
//fetch list of user  based on user type & Depo:Developer :Ritu


		public List<UserProfileRegistrationDetailModel> getUserRecordsdepotwise(UserProfileRegistrationDetailModel objurecord ) {	
			String usertype = objurecord.getUser_type();
			String userdepo = objurecord.getDepo();
			List<UserProfileRegistrationDetailModel> temp= new ArrayList<>();		
			profileRegistrationRepo.getUserRecordsdepotwise(usertype,userdepo)
	        .forEach(temp::add);
			return temp;
		}
		



public List<UserProfileRegistrationDetailModel> getuserreportdepotwisedateanddeprtwise(UserProfileRegistrationDetailModel obj1 ) {
	System.out.println("objrecd."+obj1);	
	String user_type = obj1.getUser_type(); 
	String userdepo = obj1.getDepo();
	String deprt=obj1.getDepartment();
	Date date_from =obj1.getFrom_date();
	Date date_to =obj1.getTo_date();	
	Date date_fromto=date_to;
	System.out.println(date_from);
	System.out.println(date_to);						
	List<UserProfileRegistrationDetailModel> temp= new ArrayList<>();
	profileRegistrationRepo.getuserreportdepotwisedateanddeprtwise(user_type,userdepo,deprt,date_from,date_fromto)
.forEach(temp::add);
	System.out.println(temp);
	return temp;
	
}

//get report desig&  datewise based :Developer :Ritu
public List<UserProfileRegistrationDetailModel> depotwiseuserreportdateandesigwise(UserProfileRegistrationDetailModel obj2 ) {
	System.out.println("objrecd."+obj2);	
	String user_type = obj2.getUser_type(); 
	String userdepo = obj2.getDepo();
	String desig=obj2.getDesignation();
//	String deprt=obj2.getDepartment();
	Date date_from =obj2.getFrom_date();
	Date date_to =obj2.getTo_date();	
	Date date_fromto=date_to;
	System.out.println(date_from);
	System.out.println(date_to);						
	List<UserProfileRegistrationDetailModel> temp= new ArrayList<>();
	profileRegistrationRepo.getuserreportdepotwisedateandesigwise(user_type,userdepo,desig,date_from,date_fromto)
.forEach(temp::add);
	System.out.println(temp);
	return temp;
	
}

//fetch list of userdetail according to all parameter for depo USER:Developer :Ritu
public List<UserProfileRegistrationDetailModel> getcustomizeduserdetaildepotuser(UserProfileRegistrationDetailModel objdatedashboaduser ) {		
	String user_type=objdatedashboaduser.getUser_type();
	String userdepo = objdatedashboaduser.getDepo();
	String user_deprt = objdatedashboaduser.getDepartment();
	String user_desig = objdatedashboaduser.getDesignation();						
	Date from_dt = objdatedashboaduser.getFrom_date();
	Date to_date = objdatedashboaduser.getTo_date();	
	Date date_to=to_date;
	List<UserProfileRegistrationDetailModel> temp= new ArrayList<>();
	profileRegistrationRepo.getReportdepotwiseuserallparameter(user_type,userdepo,user_deprt,user_desig,from_dt,date_to)
  .forEach(temp::add);
	System.out.println(temp);
	return temp;
	
}


//fetch list of loco userdetail according to zone,shed based :Developer :Ritu
public List<UserProfileRegistrationDetailModel> getUserRecordszoneanddepotwise(UserProfileRegistrationDetailModel objdashboaduser ) {
	System.out.println("objrecd."+objdashboaduser);
	String user_type=objdashboaduser.getUser_type();
	String user_zone = objdashboaduser.getZone();
	String userdepo = objdashboaduser.getDepo();			
					
	List<UserProfileRegistrationDetailModel> temp= new ArrayList<>();
	profileRegistrationRepo.getLocoUserRecordszoneandshedwise(user_type,user_zone,userdepo)
  .forEach(temp::add);
	System.out.println(temp);
	return temp;
	
}


//fetch list of loco userdetail according to zone,shed based :Developer :Ritu
public List<UserProfileRegistrationDetailModel> getReportdepouserallparameter(UserProfileRegistrationDetailModel objdashboaduser ) {
	System.out.println("objrecd."+objdashboaduser);
	String user_type=objdashboaduser.getUser_type();	
	String userdepo = objdashboaduser.getDepo();	
	String user_deprt = objdashboaduser.getDepartment();
	String user_desig = objdashboaduser.getDesignation();						
	Date from_dt = objdashboaduser.getFrom_date();
	Date to_date = objdashboaduser.getTo_date();	
	Date date_to=to_date;
	List<UserProfileRegistrationDetailModel> temp= new ArrayList<>();
	profileRegistrationRepo.getReportdepotwiseuserallparameter(user_type,userdepo,user_deprt,user_desig,from_dt,date_to)
.forEach(temp::add);
	System.out.println(temp);
	return temp;
	
}


//get user report single shed and department based :Developer :Ritu
public List<UserProfileRegistrationDetailModel> getuserreportsingledepoandeprttwise(UserProfileRegistrationDetailModel obj2 ) {	
	
	
	String user_type = obj2.getUser_type();
	String userdepo = obj2.getDepo();
	String user_deprt = obj2.getDepartment();		
	List<UserProfileRegistrationDetailModel> temp= new ArrayList<>();
	profileRegistrationRepo.getUserReportsheddeprtwise(user_type,userdepo,user_deprt)
.forEach(temp::add);
	System.out.println(temp);
	return temp;
	
}

//get user report single shed and department based :Developer :Ritu
public List<UserProfileRegistrationDetailModel> getuserreportsingledepoandesigwise(UserProfileRegistrationDetailModel obj2 ) {	
	String user_type = obj2.getUser_type();
	String userdepo = obj2.getDepo();
	String user_desig = obj2.getDesignation();		
	List<UserProfileRegistrationDetailModel> temp= new ArrayList<>();
	profileRegistrationRepo.getUserReportdepotwisedesigwise(user_type,userdepo,user_desig)
.forEach(temp::add);
	System.out.println(temp);
	return temp;
	
}

//fetch report based on shed and  date :Developer :Ritu
public List<UserProfileRegistrationDetailModel> getreportdepotanddatewise(UserProfileRegistrationDetailModel obj ) {
	System.out.println("objrecd."+obj);
String user_type=obj.getUser_type();
String userdepo = obj.getDepo();	
	Date date_from =obj.getFrom_date();
	Date date_to =obj.getTo_date();	
	Date date_fromto=date_to;
	System.out.println(date_from);
	System.out.println(date_to);						
	List<UserProfileRegistrationDetailModel> temp= new ArrayList<>();
	profileRegistrationRepo.getReportdepotwiseuserdatewise(user_type,userdepo,date_from,date_fromto)
  .forEach(temp::add);
	System.out.println(temp);
	return temp;
	
}

//update user addtional shed :Developer :Ritu
public boolean updateuseraddtionalshed(UserProfileRegistrationDetailModel obj1 ) {
	
	 try {
		 String addshed = obj1.getAdditional_shed();
		 String activeshed=obj1.getAdditional_shed_active();		
		 String userid=obj1.getUser_id();		
		 logger.info("Service : UserRegistrationService || Method : updateuseraddtionalshed ||UserID ");		 
		 profileRegistrationRepo.updateuseraddtionalshed(addshed,activeshed,userid);
			return true;	
			
}catch(Exception ex) {
	
	logger.info("Service : UserRegistrationService || Method : updateuseraddtionalshed ||Exception update session encryption" + ex.getMessage());
	return false;
	
//	System.out.print(ex.getMessage());
}
	
	
}

public List<UserProfileRegistrationDetailModel> getShedZoneWithNoAdditionalShed(UserProfileRegistrationDetailModel objUPRDM)	{
	 List<UserProfileRegistrationDetailModel> userProfileFetchedList = new ArrayList<>();		 
	 profileRegistrationRepo.getUserShedAndZone(objUPRDM.getUser_id()).forEach(userProfileFetchedList::add);			
	 return userProfileFetchedList;
}

public List<UserProfileRegistrationDetailModel> getActiveuser(UserProfileRegistrationDetailModel objUPRDM1)	{
	 List<UserProfileRegistrationDetailModel> userProfileFetchedList1 = new ArrayList<>();		 
	 profileRegistrationRepo.getActiveUser(objUPRDM1.getUser_id()).forEach(userProfileFetchedList1::add);			
	 return userProfileFetchedList1;
}


public List<UserProfileRegistrationDetailModel> getActiveuser1(UserProfileRegistrationDetailModel objUPRDM1)	{
	 List<UserProfileRegistrationDetailModel> userProfileFetchedList1 = new ArrayList<>();		 
	 profileRegistrationRepo.getActiveUser(objUPRDM1.getUser_id()).forEach(userProfileFetchedList1::add);			
	 return userProfileFetchedList1;
}


	//Jyoti Bisht   14-10-22  to get user count between dates for station user
	
	public int getusercount_station(String from, String to) throws ParseException {
		
		Date date1= new SimpleDateFormat("yyyy-MM-dd").parse(from);  
		Date date2= new SimpleDateFormat("yyyy-MM-dd").parse(to);  
	//	System.out.println("date...................................."+date1+"............."+date2);
		return profileRegistrationRepo.get_User_count_station(date1, date2);
		
	}
	//Jyoti Bisht   14-10-22  to get user count between dates for loco
	
	public int getusercount_loco(String from, String to) throws ParseException {
		
		Date date1= new SimpleDateFormat("yyyy-MM-dd").parse(from);  
		Date date2= new SimpleDateFormat("yyyy-MM-dd").parse(to);  
	//	System.out.println("date...................................."+date1+"............."+date2);
		return profileRegistrationRepo.get_User_count_loco(date1, date2);
		
	}
	//Jyoti Bisht   14-10-22  to get user count between dates for coach
	
	public int getusercount_coach(String from, String to) throws ParseException {
		
		Date date1= new SimpleDateFormat("yyyy-MM-dd").parse(from);  
		Date date2= new SimpleDateFormat("yyyy-MM-dd").parse(to);  
	//	System.out.println("date...................................."+date1+"............."+date2);
		return profileRegistrationRepo.get_User_count_coach(date1, date2);
		
	}
	
	
	public List<UserProfileRegistrationDetailModel> getuserdetailbyroleandtypezone(UserProfileRegistrationDetailModel objuserprivilege)	{
		 List<UserProfileRegistrationDetailModel> userProfileFetchedList = new ArrayList<>();		 
		 profileRegistrationRepo.getuserdetailbyroleandtypezone(objuserprivilege.getZone(), objuserprivilege.getUser_type(), objuserprivilege.getShed()).forEach(userProfileFetchedList::add);			
		 return userProfileFetchedList;
	}

	// Jyoti Bisht

	public List<Object[]> getuserdetailbyroleandtypezone1(UserProfileRegistrationDetailModel objuserprivilege)	{
			 
		 return profileRegistrationRepo.getuserdetailbyroleandtypezone1( objuserprivilege.getUser_type(), objuserprivilege.getShed(), objuserprivilege.getZone());		
		
	}
	
	//fetch list of sheduserdetail  :Developer :Ritu
	public List<UserProfileRegistrationDetailModel> getshedadminuserdetail1(UserProfileRegistrationDetailModel obj_userprivilege ) {	
		String shedid = obj_userprivilege.getShed();
		List<UserProfileRegistrationDetailModel> temp= new ArrayList<>();
		profileRegistrationRepo.getshedadminuserdetail1(shedid)			
        .forEach(temp::add);		
//		return size;
		return temp;
	}
	
	


	public boolean updateActivationStatusSM(UserProfileRegistrationDetailModel objUPRDM) {
		 //boolean active=false;
		 try {
			 profileRegistrationRepo.updateActivationStatus(objUPRDM.getUser_register_approval(), objUPRDM.getUser_id());
			 //active=true;
			 return true;
		 }
		 catch(Exception e) {
			 //active=false;
			 return false;
		 }
		 
	}
	// Jyoti Bisht 6-12-22

	public boolean delete_user_details(String user_id)	{

		
		try
		{
			profileRegistrationRepo.delete_user(user_id);
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
		
		
		
	}



	

		
		
		
	

	
	
	// Jyoti Bisht 23-02-23

		public boolean update_user_profile(String email, String mobile, String user_type, String user_id)	{
			try
			{
				profileRegistrationRepo.update_user_profile(email, mobile, user_type, user_id);
			    return true;
			}
			catch(Exception e)
			{
				return false;
			}
			
		}




	
}
