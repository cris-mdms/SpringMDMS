package com.mdms.app.mgmt.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mdms.app.mgmt.model.LoginOtpModel;
import com.mdms.app.mgmt.model.MasterUserLoginDetail;
import com.mdms.app.mgmt.model.MenuIdResponseModel;

import com.mdms.app.mgmt.model.UserLoginDetailModel;

import com.mdms.app.mgmt.model.UserProfileRegistrationDetailModel;
import com.mdms.app.mgmt.service.LoginOtpService;
import com.mdms.app.mgmt.service.ShowMenuRightsService;
import com.mdms.app.mgmt.service.UserLoginService;
import com.mdms.app.mgmt.service.UserProfileRegistrationService;
import com.mdms.loco.locouncleansed.model.LocoUncleansedDataElectric;

//import com.mdms.app.mgmt.service.LoginOtpService;
//import com.mdms.app.mgmt.service.ShowMenuRightsService;
//import com.mdms.app.mgmt.service.UserLoginService;


//@CrossOrigin(origins = {"http://localhost:4200","http://cris-mdm-angular.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")




import com.mdms.app.mgmt.service.LoginOtpService;
import com.mdms.app.mgmt.service.ShowMenuRightsService;
import com.mdms.app.mgmt.service.UserLoginService;




import com.mdms.app.mgmt.service.LoginOtpService;
import com.mdms.app.mgmt.service.ShowMenuRightsService;
import com.mdms.app.mgmt.service.UserLoginService;

@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")
@RestController
public class UserLoginController {
	
	@Autowired
	private UserLoginService userLoginService;
	
	
	@Autowired
	private ShowMenuRightsService menuRightService;
	

	@Autowired
	UserProfileRegistrationService profileRegistrationService;
	Logger logger=LoggerFactory.getLogger(UserLoginController.class);

	@RequestMapping(method=RequestMethod.POST, value="/userlogin")
	public MenuIdResponseModel userLogin(@RequestParam("user_id") String user_id,@RequestParam("password") String password){
		

		
		MenuIdResponseModel obj=new MenuIdResponseModel();
		logger.info("Controller : UserLoginController || Method : userLogin || user_id: "+user_id +" ||password: " +password);
		List<String> response= new ArrayList<String>();
	
		try {
		String 	result=userLoginService.verifyLogin(user_id,password);
		
		if(result.equalsIgnoreCase("success")) {	

		 response= menuRightService.showMenuRights(user_id);
	String user_type=	 menuRightService.getUserType(user_id);
	UserProfileRegistrationDetailModel registrationObj=profileRegistrationService.getUserDetail(user_id);
	System.out.println("username"+registrationObj.getUname());
	obj.setDivision(registrationObj.getDivision());
	obj.setDesignation(registrationObj.getDesignation());
obj.setUser_role(registrationObj.getRole_type());
obj.setUname(registrationObj.getUname());
obj.setZone(registrationObj.getZone());
obj.setUser_id(user_id);
obj.setCris_user(registrationObj.getCris_user());
obj.setDepartment(registrationObj.getDepartment());
obj.setShed(registrationObj.getShed());
obj.setDepo(registrationObj.getDepo());
obj.setAsset_designation_code(registrationObj.getAsset_designation_code());
obj.setAdditional_shed(registrationObj.getAdditional_shed());
obj.setAdditional_shed_active(registrationObj.getAdditional_shed_active());
obj.setSenior_id(profileRegistrationService.seniorID(registrationObj.getDesignation(), registrationObj.getDivision()));
//System.out.println("asset_desig"+registrationObj.getAsset_designation_code());	
	obj.setUser_type(user_type);
//	System.out.println("menusize"+response.size());
//	System.out.println("result"+result);
		if(response.size()>0)
		{
			System.out.println("asset_desigabove"+registrationObj.getAsset_designation_code());
			
		obj.setMenuid_list(response);
		obj.setStatus("success");
		obj.setMessage("credentials are correct");
		
		
		 logger.info("Controller : UserLoginController || Method : userLogin ||showMenuRights:user_id "+user_id +" ||menuId list size"+ response.size() +"|| credentails are right");

		}else {
			System.out.println("asset_desigbelow"+registrationObj.getAsset_designation_code());
			
			obj.setMenuid_list(response);
			obj.setStatus("success");
			obj.setMessage("no menu rights for this user");
			 logger.info("Controller : UserLoginController || Method : userLogin ||showMenuRights:user_id "+user_id +" ||no menu rights");

		}
		

	}else {
		
		obj.setMenuid_list(response);
		obj.setStatus("failed");
		obj.setMessage(result);
		 logger.info("Controller : UserLoginController || Method : userLogin ||showMenuRights:user_id "+user_id +" ||credentials are wrong");

		
	}
		}catch(Exception ex) {
			ex.getMessage();
			 logger.info("Controller : UserLoginController || Method : userLogin ||showMenuRights:user_id "+user_id +" || Exception "+ex.getMessage());
		
		}
	
	
		return obj;
			
		
		
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value ="/resetpassword")
	public String resetpassword(@RequestBody UserLoginDetailModel obj_resetpwd)
	{
		logger.info("Controller : UserLoginController || Method : resetpassword || password:" +obj_resetpwd.getEmp_password() +" || user_id: "+obj_resetpwd.getUser_id()+"" );
		System.out.println("pwd"+ obj_resetpwd.getEmp_password());
		System.out.println("id"+ obj_resetpwd.getUser_id());	
	String flag = userLoginService.resetPassword(obj_resetpwd);
	return flag;
	}
 
	//create masteruser
	@RequestMapping(method=RequestMethod.POST, value="/createmastruser")
	public boolean createmstuser(@RequestBody MasterUserLoginDetail objmstrlogin) {
		System.out.println("id"+objmstrlogin.getUser_id());		
		
		System.out.println("pwd"+objmstrlogin.getEmp_password());
				boolean flag=userLoginService.savemstuser(objmstrlogin);
					return flag;
			}

//
//	@RequestMapping(method=RequestMethod.POST, value="/verifymstrpwd")
//	public boolean verifypwd(@RequestBody MasterUserLoginDetail verifypwd){
//		System.out.println("id"+verifypwd.getUser_id());	
//		System.out.println("id"+verifypwd.getEmp_password());			
//		return userLoginService.verifyOtp(verifypwd);
//				
//		
//	}
//	
	
	@RequestMapping(method=RequestMethod.POST, value="/verifymstrpwd")
	public String verifymstotp(@RequestBody MasterUserLoginDetail objpwd){
		String user_id=objpwd.getUser_id();
		Integer emp_password=objpwd.getEmp_password();
		String response= userLoginService.verifymstOtp(user_id,emp_password);
		logger.info("Controller : UserLoginController || Method : verifymstotp ||user_id  "+ user_id + "|| pwd  "+ emp_password +" ||Find  user pwd Response  "+ response);
				
		 return JSONObject.quote(response);
		
	}
	



	@RequestMapping(method=RequestMethod.POST, value ="/checkuserloggedin")
	public List<UserLoginDetailModel> checksessionactive(@RequestBody UserLoginDetailModel obj_checksession)
	{
		logger.info("Controller : UserLoginController || Method : checksessionactive || userid:" +obj_checksession.getUser_id());
		
		System.out.println("id"+ obj_checksession.getUser_id());	
	List<UserLoginDetailModel> flag = userLoginService.checksessionactive(obj_checksession);
	return flag;
	}
	@RequestMapping(method=RequestMethod.POST, value ="/updateloginsession")
	public boolean updatesession(@RequestBody UserLoginDetailModel obj_session)
	{
		logger.info("Controller : UserLoginController || Method : updatesession || isactive:" +obj_session.getIs_active()  );
		
		System.out.println("id"+ obj_session.getUser_id());	
	boolean flag = userLoginService.updatelogginsession(obj_session);
	return flag;
	}
	
	@RequestMapping(method=RequestMethod.POST, value ="/updatelastloginsession")
	public boolean updatelastlogindate(@RequestBody UserLoginDetailModel obj_lastloginsession)
	{SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	obj_lastloginsession.setLast_login_date(Timestamp.valueOf(formatter.format(new Date())));
		logger.info("Controller : UserLoginController || Method : updatelastlogindate ");		
		System.out.println("id"+ obj_lastloginsession.getUser_id());	
	boolean flag = userLoginService.updatelastlogindate(obj_lastloginsession);
	return flag;
	}
	
}
