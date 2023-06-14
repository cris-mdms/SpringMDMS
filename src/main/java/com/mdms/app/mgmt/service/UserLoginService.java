package com.mdms.app.mgmt.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.mdms.PasswordSecurityConfiguration;
import com.mdms.app.mgmt.model.LoginOtpModel;
import com.mdms.app.mgmt.model.MasterUserLoginDetail;
import com.mdms.app.mgmt.model.UserLoginDetailModel;
import com.mdms.app.mgmt.model.UserProfileRegistrationDetailModel;
import com.mdms.app.mgmt.repository.MasterUserLoginDetailRepository;
import com.mdms.app.mgmt.repository.UserLoginDetailRepository;
import com.mdms.app.mgmt.repository.UserProfileRegistrationRepository;
@Service
public class UserLoginService {	
	 Logger logger=LoggerFactory.getLogger(UserLoginService.class);	 
	 @Autowired
	 UserLoginDetailRepository loginDetailObj;	 
	 @Autowired
	 UserProfileRegistrationRepository  profileRegistrationRepoObj;
	 
	 @Autowired
	 MasterUserLoginDetailRepository  mstRepoObj;
	 
	 private final PasswordEncoder passwordEncoder = new PasswordSecurityConfiguration().passwordEncoder();
public String verifyLogin(String user_id,String pwd) {	
	String response = "failed";
	try {	
			logger.info("Service : UserLoginService || Method : verifyLogin ||");

			
			List<UserLoginDetailModel> list  =	loginDetailObj.getDeatils(user_id.toUpperCase());
			List<UserProfileRegistrationDetailModel> listUserProfileObj  =	profileRegistrationRepoObj.getUserDetail(user_id.toUpperCase());
			if((list.size()>0) && (listUserProfileObj.size()>0)) {
				if(listUserProfileObj.get(0).getUser_register_approval().equalsIgnoreCase("N")) {
					
					logger.info("Service : UserLoginService || Method : getUser_register_approval 'N'||");
				response = "Registered MDMS user is not approved by approving authority.";
					
				}else if(listUserProfileObj.get(0).getUser_register_approval().equalsIgnoreCase("Y") ){
					
					logger.info("Service : UserLoginService || Method : getUser_register_approval 'Y'||");
				
				boolean result=passwordEncoder.matches(pwd,list.get(0).getEmp_password());
			if(result) {
				
				logger.info("Service : UserLoginService || Method : passwordEncoder.matches  'Y'||");
				response="success";	
				
				
			}else {
				response="Wrong Password";	
			}

			}
				}
			
			else {
				response="This UserId is not registered.Please Registered First.";
			}
}catch(Exception ex) {
	
	logger.info("Service : UserProfileRegistrationService || Method : saveUserDetails ||Exception pwd encryption" + ex.getMessage());

//	System.out.print(ex.getMessage());
}
	return response;

}

public String resetPassword(UserLoginDetailModel obj_resetpwd) {
	String response = "not Reset";
	 String encodedPassword="";
	 try {
		 encodedPassword = passwordEncoder.encode(obj_resetpwd.getEmp_password());		 
		 logger.info("Service : UserLoginService || Method : resetPassword ||NEW Password ");		 
		 String uid=obj_resetpwd.getUser_id();	
			loginDetailObj.updatePassword(encodedPassword, uid);
			response=  "NEWPassword" ;	
}catch(Exception ex) {
	
	logger.info("Service : UserLoginService || Method : resetPassword ||Exception pwd encryption" + ex.getMessage());
	response="OLD Password";
//	System.out.print(ex.getMessage());
}
	return response;
	
}

public boolean savemstuser(MasterUserLoginDetail objmst) {
	  boolean flag = false;
//	try{
		 logger.info("Service : UserLoginService || Method : savemstuser ||Create Master User ");		 
		 if(mstRepoObj.save(objmst)!= null)
			{
						return true;	
			}
		 else
		 {
			 return false;
		 }
}


//public boolean verifyOtp(MasterUserLoginDetail verifypwd){	
//	String uid =verifypwd.getUser_id();
//	int pwd=verifypwd.getEmp_password();
//	boolean flag = mstRepoObj.verifyOtp(uid, pwd);
//	if(flag=true) {
//		logger.info("Service : UserLoginService || Method : verifyOtp||user_id: "+uid);
//
//	 return true;
//	}
//	else
//	{
//		return false;
//	}
//		 
//}

public String verifymstOtp(String user_id, Integer emp_password) {			 
	String response = "not Reset";
	try {
//	logger.info("Service : UserLoginService || Method : verifymstOtp ||user_id " + user_id +" || emp_password "+emp_password);
				
 List<MasterUserLoginDetail>  list= mstRepoObj.verifyOtp(user_id,emp_password); 	
 if(list.size()>0) {
	 logger.info("Service : UserLoginService || Method : verifymstOtp ||Response success");
	 response="success";	
 }
		
 return response;
	}
 catch(Exception ex) {
	 
		logger.info("Service : UserLoginService || Method : verifymstOtp ||Exception pwd encryption + ex.getMessage()");
		response="failed";
	
		return response;					 }
	
}


public boolean updatelogginsession(UserLoginDetailModel obj_updatesession ) {
	
	
	 try {
		String isactive=obj_updatesession.getIs_active(); 
		 logger.info("Service : UserLoginService || Method : updatelogginsession ||NEW session ");		 
		 String uid=obj_updatesession.getUser_id();	
			loginDetailObj.updateusersession(isactive, uid);
			return true;	
			
}catch(Exception ex) {
	
	logger.info("Service : UserLoginService || Method : updatelogginsession ||Exception update session encryption" + ex.getMessage());
	
//	System.out.print(ex.getMessage());
}
	return false;
	
}

public boolean updatelastlogindate(UserLoginDetailModel obj_updatelastlogindate ) {
	
	 try {
		Date last_login_date=obj_updatelastlogindate.getLast_login_date(); 		
		 logger.info("Service : UserLoginService || Method : updatelastlogindate ||Login Date ");		 
		 String uid=obj_updatelastlogindate.getUser_id();	
			loginDetailObj.updatelastlogindate(last_login_date, uid);
			return true;	
			
}catch(Exception ex) {
	
	logger.info("Service : UserLoginService || Method : updatelogginsession ||Exception update session encryption" + ex.getMessage());
	
//	System.out.print(ex.getMessage());
}
	return false;
	
}
public List<UserLoginDetailModel> checksessionactive(UserLoginDetailModel verifysession){	
String uid =verifysession.getUser_id();
 return loginDetailObj.checkusersessionactive(uid);
	 
}


}