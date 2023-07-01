package com.mdms.app.mgmt.controller;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mdms.app.mgmt.model.GetListUserRegistrationJsonModel;
import com.mdms.app.mgmt.model.MasterUserLoginDetail;
import com.mdms.app.mgmt.model.OldUserDetailModel;
import com.mdms.app.mgmt.model.UserJsonModel;
import com.mdms.app.mgmt.model.UserLoginDetailModel;
import com.mdms.app.mgmt.model.UserPrivilegeModel;
import com.mdms.app.mgmt.model.UserProfileRegistrationDetailModel;
import com.mdms.app.mgmt.model.UserRegistrationJsonModel;
import com.mdms.app.mgmt.service.UserProfileRegistrationService;
import com.mdms.mdms_masters.model.MDepartment;

@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false")
@RestController
public class UserProfileRegistrationController {

	
	Logger logger=LoggerFactory.getLogger(UserProfileRegistrationController.class);
	
	@Autowired
	UserProfileRegistrationService registrationServiceObj;
	
	@RequestMapping(method=RequestMethod.POST, value="/userregistration")
	public String UserRegistration(@RequestBody UserRegistrationJsonModel userObj){
		if(userObj.getShed().equalsIgnoreCase("")) {
			userObj.setShed(null);
			
		}if(userObj.getLoco_type().equalsIgnoreCase("")) {
			userObj.setLoco_type(null);	
		}
		logger.info("Controller : UserRegistrationController || Method : UserRegistration ||user_id: "+userObj.getUser_id()
		+"||pwd"+userObj.getEmp_password()+"||shed"+ userObj.getShed() + "loco_type: "+ userObj.getLoco_type()+" ||user_id "+userObj.getUname()
		
				+"||zone : " +userObj.getZone()+"||division : " + userObj.getDivision());
		System.out.println(userObj.getDepartment());
		System.out.println("oldid"+userObj.getOld_user_id());
		System.out.println("crisuser"+userObj.getCris_user());
		
		String response= registrationServiceObj.saveUserDetails(userObj);
		//code to send otp, on hold because of Api for sending otp
		
		logger.info("Controller : UserRegistrationController || Method : UserRegistration ||user_id: "+userObj.getUser_id()+ "||Response save details:"+response);

		return response;
		
	}
	
	
	
	@RequestMapping(method=RequestMethod.POST, value="/getlistofitems")
	public GetListUserRegistrationJsonModel getListUserRegistration(){
						
		GetListUserRegistrationJsonModel response= registrationServiceObj.getListUserRegistration();
		//code to send otp, on hold because of Api for sending otp
		
		logger.info("Controller : UserRegistrationController || Method : getListUserRegistration ");

		return response;
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/getusertyperolelist")
	public String getusertyperolelis(@RequestBody UserRegistrationJsonModel userObj){		
		logger.info("Controller : UserRegistrationController || Method : getusertyperolelist ||user_type: "+userObj);	
		String response= registrationServiceObj.getusertyperole(userObj);
		//code to send otp, on hold because of Api for sending otp		
		logger.info("Controller : UserRegistrationController || Method : getusertyperolelist ||user_type: "+userObj);
		return response;
		
	}

	

	@RequestMapping(method=RequestMethod.POST, value="/getlocoshed")
	public String getLocoshed(@RequestBody UserRegistrationJsonModel userObj){		
		logger.info("Controller : UserRegistrationController || Method : getLocoshed ||user_zone: "+userObj);	
		String response= registrationServiceObj.getLocoshed(userObj);
		//code to send otp, on hold because of Api for sending otp		
		logger.info("Controller : UserRegistrationController || Method : getLocoshed ||user_zone: "+userObj);
		return response;
		
	}

	
	
	
	@RequestMapping(method=RequestMethod.POST, value="/finduserrecord")
	public String findUserRecord(@RequestParam  String user_id){	
		
		String response= registrationServiceObj.findUserRecord(user_id);
		//code to send otp, on hold because of Api for sending otp
		
		logger.info("Controller : UserRegistrationController || Method : findUserRecord ||user_id  "+user_id + "||Find Records Response  "+ response);

		 return JSONObject.quote(response);
		
	}
	
	//fetch userdetail based on user type	
		@RequestMapping(method=RequestMethod.POST , value ="/getuserdetaildashboard")
		public List<UserProfileRegistrationDetailModel> getallusertypedetails(@RequestBody UserProfileRegistrationDetailModel objurecord ){
				return registrationServiceObj.getalluserdetail(objurecord);
		
		}
	
		//fetch userdetail based on user type
		@RequestMapping(method=RequestMethod.POST , value ="/getusercontrl")
		public List<UserProfileRegistrationDetailModel> getuserctrl(@RequestBody UserProfileRegistrationDetailModel objuctrl ){
				return registrationServiceObj.getusercontrol(objuctrl);
		
		}
		
		
		@RequestMapping(method=RequestMethod.POST, value="/checkmstruserexist")
		public List<MasterUserLoginDetail> findMstrUserRecord(@RequestParam  String user_id){	
			List<MasterUserLoginDetail> response= registrationServiceObj.findMstrUserRecord(user_id);	
						logger.info("Controller : UserRegistrationController || Method : findMstrUserRecord ||user_id  "+user_id + "||Find Master Records Response  "+ response);

			 return response;
			
		}
		
		@RequestMapping(method=RequestMethod.POST, value="/checkregisteruserexist")
		public String findregUserRecord(@RequestParam  String user_id){	
			String response= registrationServiceObj.findUserRecorinRegistration(user_id);	
						logger.info("Controller : UserRegistrationController || Method : findregUserRecord ||user_id  "+user_id + "||Find registered user Records Response  "+ response);

			 return JSONObject.quote(response);
			
		}
		
		//update record - master password for current date
	 	@RequestMapping(method=RequestMethod.POST, value ="/updatemstrpassword")
	 	public boolean update_edraft(@RequestBody MasterUserLoginDetail obj_mstrpwd)
	 	{	 	
	 		
	 	boolean flag = registrationServiceObj.updatemstrpwd(obj_mstrpwd);
	 	return flag;
	 	}
	 	
	 	//fetch userdetail based on user zone , division,department	

//	 			@RequestMapping(method=RequestMethod.POST , value ="/getcustomizeduserdetaildashboard")
//	 			public List<UserProfileRegistrationDetailModel> getcustomizeuserdetails(@RequestBody UserProfileRegistrationDetailModel objrecord ){
////	 				logger.info("Controller : UserRegistrationController || Method : getcustomizeuserdetails ||user_zone  "+objrecord + "||Find Records Response  "+ objrecord);
//	 					return registrationServiceObj.getcustomizeduserdetail(objrecord);
//	 			}
//	 			@RequestMapping(method=RequestMethod.POST , value ="/getlocouserdetailshedwise")
//	 			public List<UserProfileRegistrationDetailModel> getcustomizeuserdetails1(@RequestBody UserProfileRegistrationDetailModel objrecord ){
////	 				logger.info("Controller : UserRegistrationController || Method : getcustomizeuserdetails ||user_zone  "+objrecord + "||Find Records Response  "+ objrecord);
//	 					return registrationServiceObj.getLocoUserRecordszoneandshedwise(objrecord);
//
//	 			
//	 			}
	 			
	 			@RequestMapping(method=RequestMethod.POST , value ="/getreportdatewise")
	 			public List<UserProfileRegistrationDetailModel> getreportdatewise(@RequestBody UserProfileRegistrationDetailModel objdatewise ){
//	 				logger.info("Controller : UserRegistrationController || Method : getcustomizeuserdetails ||user_zone  "+objrecord + "||Find Records Response  "+ objrecord);
	 					return registrationServiceObj.getreportdatewise(objdatewise);
	 			
	 			}
	 			


	 			
	 			@RequestMapping(method=RequestMethod.POST , value ="/getreportzonaldatewise")
	 			public List<UserProfileRegistrationDetailModel> getreportzonedatewise(@RequestBody UserProfileRegistrationDetailModel objdatewise ){
//	 				logger.info("Controller : UserRegistrationController || Method : getcustomizeuserdetails ||user_zone  "+objrecord + "||Find Records Response  "+ objrecord);
	 					return registrationServiceObj.getreportdatewise(objdatewise);
	 			
	 			}
	 			
	 			@RequestMapping(method=RequestMethod.POST , value ="/getreportdivisiondatewise")
	 			public List<UserProfileRegistrationDetailModel> getreportdivisdatewise(@RequestBody UserProfileRegistrationDetailModel objdatewise ){
//	 				logger.info("Controller : UserRegistrationController || Method : getcustomizeuserdetails ||user_zone  "+objrecord + "||Find Records Response  "+ objrecord);
	 					return registrationServiceObj.getreportdivisiondatewise(objdatewise);
	 			
	 			}
	 			

	 			@RequestMapping(method=RequestMethod.POST , value ="/getuserreportdepartandatewise")
	 			public List<UserProfileRegistrationDetailModel> getreportdeprtdatewise(@RequestBody UserProfileRegistrationDetailModel objreport1 ){
	 					return registrationServiceObj.getreportdeprtanddatewise(objreport1);
	 			
	 			}
	 			
	 			@RequestMapping(method=RequestMethod.POST, value="/checkoldregisteruserexist")
	 			public String findoldregUserRecord(@RequestParam  String olduser_id){	
	 				String response= registrationServiceObj.findOldUserRecorinRegistration(olduser_id);	
	 							logger.info("Controller : UserRegistrationController || Method : findoldregUserRecord ||olduser_id  "+olduser_id + "||Find old registered user Records Response  "+ response);

	 				 return JSONObject.quote(response);
	 				
	 			}	

	 			@RequestMapping(method=RequestMethod.POST, value ="/resetolduserflag")
	 			public String resetolduserflag(@RequestBody OldUserDetailModel obj_resetflag)
	 			{
	 				logger.info("Controller : UserRegistrationController || Method : resetolduserflag || old_user_id:" +obj_resetflag.getOld_user_id()  );
	 				
	 				System.out.println("id"+ obj_resetflag.getOld_user_id());	
	 			String flag = registrationServiceObj.updateflagolduser(obj_resetflag);
	 			return flag;
	 			}
	 			
	 			@RequestMapping(method=RequestMethod.POST, value="/getuserregistreddepartment")
	 			public List<String> getAllRegisteredDepartment(){
	 				return registrationServiceObj.getAllRegisteredDepartment();
	 			}

	 			@RequestMapping(method=RequestMethod.POST, value="/getuserregistreddesignation")
	 			public List<String> getAllRegisteredDesignation(@RequestBody UserProfileRegistrationDetailModel objdesig){
	 				return registrationServiceObj.getAllRegisteredDesignation(objdesig);
	 			}
	 			
	 			@RequestMapping(method=RequestMethod.POST, value="/getzonalreportwithalldivsion")
	 			public List<UserProfileRegistrationDetailModel> userzonedeprtdesigdatewisereport(@RequestBody UserProfileRegistrationDetailModel objdesig){
	 				return registrationServiceObj.userzonedeprtdesigdatewisereport(objdesig);
	 			}
	 			@RequestMapping(method=RequestMethod.POST, value="/getUserReportzoneandatewise")
	 			public List<UserProfileRegistrationDetailModel> getUserReportzoneandatewise(@RequestBody UserProfileRegistrationDetailModel objdesig){
	 				return registrationServiceObj.getUserReportzoneandatewise(objdesig);
	 			}
	 			
	 			
	 			@RequestMapping(method=RequestMethod.POST, value="/getuserregistreddepartanddesig")
	 			public List<UserProfileRegistrationDetailModel> getReportdeprtanddesig(@RequestBody UserProfileRegistrationDetailModel objdesig){
	 				return registrationServiceObj.getuserreportsinglediviandeprttanddesigwise(objdesig);
	 			}
	 			@RequestMapping(method=RequestMethod.POST, value="/getuserregistreddivdepart")
	 			public List<UserProfileRegistrationDetailModel> getUserReportdivdeprtwise(@RequestBody UserProfileRegistrationDetailModel objdivdepart){
	 				return registrationServiceObj.getUserReportdivdeprtwise(objdivdepart);
	 			}
	 			@RequestMapping(method=RequestMethod.POST, value="/getuserregistreddivdesig")
	 			public List<UserProfileRegistrationDetailModel> getUserReportdivdesigwise(@RequestBody UserProfileRegistrationDetailModel objdivdesig){
	 				return registrationServiceObj.getUserReportdivdesigwise(objdivdesig);
	 			}
	 			
	 			//fetch userdetail based on user zone , division,department	
	 			@RequestMapping(method=RequestMethod.POST , value ="/getuserreportzonewise")
	 			public List<UserProfileRegistrationDetailModel> getuserreportzonewise(@RequestBody UserProfileRegistrationDetailModel objzonerecord ){
//	 				logger.info("Controller : UserRegistrationController || Method : getcustomizeuserdetails ||user_zone  "+objrecord + "||Find Records Response  "+ objrecord);
	 					return registrationServiceObj.getuserreportzonewise(objzonerecord);
	 			
	 			}
	 			
	 			@RequestMapping(method=RequestMethod.POST , value ="/getuserreportdivisionwise")
	 			public List<UserProfileRegistrationDetailModel> getuserreportdivisionwise(@RequestBody UserProfileRegistrationDetailModel objdivirecord ){
//	 				logger.info("Controller : UserRegistrationController || Method : getcustomizeuserdetails ||user_zone  "+objrecord + "||Find Records Response  "+ objrecord);
	 					return registrationServiceObj.getuserreportdiviwise(objdivirecord);
	 			
	 			}

	 			@RequestMapping(method=RequestMethod.POST , value ="/getlocouserdetailshedwise")
	 			public List<UserProfileRegistrationDetailModel> getcustomizeuserdetailsshedwise(@RequestBody UserProfileRegistrationDetailModel objrecord ){
//	 				logger.info("Controller : UserRegistrationController || Method : getcustomizeuserdetails ||user_zone  "+objrecord + "||Find Records Response  "+ objrecord);
	 					return registrationServiceObj.getLocoUserRecordszoneandshedwise(objrecord);
	 			
	 			}	
	 			
	 			
	 			@RequestMapping(method=RequestMethod.POST , value ="/getuserreportzoneanddivisionwise")
	 			public List<UserProfileRegistrationDetailModel> getuserreportzoneanddivisionwise(@RequestBody UserProfileRegistrationDetailModel objzonedivirecord ){
//	 				logger.info("Controller : UserRegistrationController || Method : getcustomizeuserdetails ||user_zone  "+objrecord + "||Find Records Response  "+ objrecord);
	 					return registrationServiceObj.getuserreportzoneanddiviwise(objzonedivirecord);
	 			
	 			}

	 			@RequestMapping(method=RequestMethod.POST , value ="/getuserreportdeprtwise")
	 			public List<UserProfileRegistrationDetailModel> getuserreportdeprtwise(@RequestBody UserProfileRegistrationDetailModel objdeprtrecord ){
//	 				logger.info("Controller : UserRegistrationController || Method : getcustomizeuserdetails ||user_zone  "+objrecord + "||Find Records Response  "+ objrecord);
	 					return registrationServiceObj.getuserreportdepartmentwise(objdeprtrecord);
	 			
	 			}
	 			
	 			@RequestMapping(method=RequestMethod.POST , value ="/getuserreportsinglezoneanddeprtwise")
	 			public List<UserProfileRegistrationDetailModel> getuserreportsinglezonedeprtwise(@RequestBody UserProfileRegistrationDetailModel objzonedeprtrecord ){
//	 				logger.info("Controller : UserRegistrationController || Method : getcustomizeuserdetails ||user_zone  "+objrecord + "||Find Records Response  "+ objrecord);
	 					return registrationServiceObj.getuserreportsinglezoneandeprttwise(objzonedeprtrecord);
	 			
	 			}
	 			@RequestMapping(method=RequestMethod.POST , value ="/getuserreportsingledivianddeprtwise")
	 			public List<UserProfileRegistrationDetailModel> getuserreportsingledivideprtwise(@RequestBody UserProfileRegistrationDetailModel objdivideprtrecord ){
//	 				logger.info("Controller : UserRegistrationController || Method : getcustomizeuserdetails ||user_zone  "+objrecord + "||Find Records Response  "+ objrecord);
	 					return registrationServiceObj.getuserreportsinglediviandeprttwise(objdivideprtrecord);
	 			
	 			}

	 			@RequestMapping(method=RequestMethod.POST , value ="/getcustomizereportfordivisionuser")
	 			public List<UserProfileRegistrationDetailModel> getcustomizereportfordivisionuser(@RequestBody UserProfileRegistrationDetailModel objdiviuser ){
//	 				logger.info("Controller : UserRegistrationController || Method : getcustomizeuserdetails ||user_zone  "+objrecord + "||Find Records Response  "+ objrecord);
	 					return registrationServiceObj.getReportdivisionuserallparameter(objdiviuser);
	 			
	 			}
	 			
	 			
	 			//-------------------------Divisional User Report -- Station -------------------------//
	 			//fetch userdetail based on user type	
	 			@RequestMapping(method=RequestMethod.POST , value ="/getdivuserdetaildashboard")
	 			public List<UserProfileRegistrationDetailModel> getalldivusertypedetails(@RequestBody UserProfileRegistrationDetailModel objurecord ){
	 					return registrationServiceObj.getalldivuserdetail(objurecord);
	 			
	 			}
	 			@RequestMapping(method=RequestMethod.POST , value ="/getdivuserdetaildeprtdatewise")
	 			public List<UserProfileRegistrationDetailModel> divuserreportdateanddeprtwise(@RequestBody UserProfileRegistrationDetailModel objurecord ){
	 					return registrationServiceObj.divuserreportdateanddeprtwise(objurecord);
	 			
	 			}@RequestMapping(method=RequestMethod.POST , value ="/getdivuserdetaildesigdatewise")
	 			public List<UserProfileRegistrationDetailModel> divuserreportdateandesigwise(@RequestBody UserProfileRegistrationDetailModel objurecord ){
 					return registrationServiceObj.divuserreportdateandesigwise(objurecord);
 			
 			}
	 			
	 			
	 			
	 			
	 			//-------------------------DashboardShed Admin Report -- Loco -------------------------//
	 			//fetch userdetail based on user type	
	 			@RequestMapping(method=RequestMethod.POST , value ="/getsheduserdetaildashboard")
	 			public List<UserProfileRegistrationDetailModel> getallshedusertypedetails(@RequestBody UserProfileRegistrationDetailModel objurecord ){
	 					return registrationServiceObj.getallsheduserdetail(objurecord);
	 			
	 			}
	 			@RequestMapping(method=RequestMethod.POST , value ="/getsheduserdetaildeprtdatewise")
	 			public List<UserProfileRegistrationDetailModel> sheduserreportdateanddeprtwise(@RequestBody UserProfileRegistrationDetailModel objurecord ){
	 					return registrationServiceObj.sheduserreportdateanddeprtwise(objurecord);
	 			
	 			}@RequestMapping(method=RequestMethod.POST , value ="/getsheduserdetaildesigdatewise")
	 			public List<UserProfileRegistrationDetailModel> sheduserreportdateandesigwise(@RequestBody UserProfileRegistrationDetailModel objurecord ){
 					return registrationServiceObj.sheduserreportdateandesigwise(objurecord);
 			
 			}
	 			
	 		
	 			@RequestMapping(method=RequestMethod.POST , value ="/getlocoallparametershedwise")
	 			public List<UserProfileRegistrationDetailModel> getallcustomizeuserdetailsshedwise(@RequestBody UserProfileRegistrationDetailModel objrecord ){
//	 				logger.info("Controller : UserRegistrationController || Method : getcustomizeuserdetails ||user_zone  "+objrecord + "||Find Records Response  "+ objrecord);
	 					return registrationServiceObj.getReportsheduserallparameter(objrecord);
	 			
	 			}	
	 			
	 			@RequestMapping(method=RequestMethod.POST , value ="/getuserreportsingleshedanddeprtwise")
	 			public List<UserProfileRegistrationDetailModel> getuserreportsingleshedandeprttwise(@RequestBody UserProfileRegistrationDetailModel obj2 ){
//	 				logger.info("Controller : UserRegistrationController || Method : getcustomizeuserdetails ||user_zone  "+objrecord + "||Find Records Response  "+ objrecord);
	 					return registrationServiceObj.getuserreportsingleshedandeprttwise(obj2);
	 			
	 			}
	 			
	 			@RequestMapping(method=RequestMethod.POST , value ="/getuserreportsingleshedanddesigwise")
	 			public List<UserProfileRegistrationDetailModel> getuserreportsinglesheddesigwise(@RequestBody UserProfileRegistrationDetailModel obj2 ){
//	 				logger.info("Controller : UserRegistrationController || Method : getcustomizeuserdetails ||user_zone  "+objrecord + "||Find Records Response  "+ objrecord);
	 					return registrationServiceObj.getuserreportsingleshedandesigwise(obj2);
	 			
	 			}
	 			
	 			@RequestMapping(method=RequestMethod.POST , value ="/getuserreportsingleshedanddatewise")
	 			public List<UserProfileRegistrationDetailModel> getreportshedanddatewise(@RequestBody UserProfileRegistrationDetailModel obj2 ){
//	 				logger.info("Controller : UserRegistrationController || Method : getcustomizeuserdetails ||user_zone  "+objrecord + "||Find Records Response  "+ objrecord);
	 					return registrationServiceObj.getreportshedanddatewise(obj2);
	 			
	 			}
	 			@RequestMapping(method=RequestMethod.POST , value ="/getuserreportsheddateandesigwise")
	 			public List<UserProfileRegistrationDetailModel> getuserreportsheddateandesigwise(@RequestBody UserProfileRegistrationDetailModel obj2 ){
//	 				logger.info("Controller : UserRegistrationController || Method : getcustomizeuserdetails ||user_zone  "+objrecord + "||Find Records Response  "+ objrecord);
	 					return registrationServiceObj.getuserreportsheddateandesigwise(obj2);
	 			
	 			}
	 			
	 			
	 			
	 			//-------------------------Dashboard Depot Admin Report -- Coach -------------------------//
	 			//fetch userdetail based on user type	
	 			@RequestMapping(method=RequestMethod.POST , value ="/getdepotuserdetaildashboard")
	 			public List<UserProfileRegistrationDetailModel> getalldepotusertypedetails(@RequestBody UserProfileRegistrationDetailModel objurecord ){
	 					return registrationServiceObj.getUserRecordsdepotwise(objurecord);
	 			
	 			}
	 			@RequestMapping(method=RequestMethod.POST , value ="/getdepotuserdetaildeprtdatewise")
	 			public List<UserProfileRegistrationDetailModel> depotuserreportdateanddeprtwise(@RequestBody UserProfileRegistrationDetailModel objurecord ){
	 					return registrationServiceObj.getuserreportdepotwisedateanddeprtwise(objurecord);
	 			
	 			}
	 			
	 			@RequestMapping(method=RequestMethod.POST , value ="/getdepotuserdetaildesigdatewise")
	 			public List<UserProfileRegistrationDetailModel> depotuserreportdateandesigwise(@RequestBody UserProfileRegistrationDetailModel objurecord ){
 					return registrationServiceObj.depotwiseuserreportdateandesigwise(objurecord);
 			
 			}
	 			
	 		
	 			@RequestMapping(method=RequestMethod.POST , value ="/getdepotallparameter")
	 			public List<UserProfileRegistrationDetailModel> getallcustomizeuserdetailsdepotwise(@RequestBody UserProfileRegistrationDetailModel objrecord ){
//	 				logger.info("Controller : UserRegistrationController || Method : getcustomizeuserdetails ||user_zone  "+objrecord + "||Find Records Response  "+ objrecord);
	 					return registrationServiceObj.getReportdepouserallparameter(objrecord);
	 			
	 			}	
	 			
	 			@RequestMapping(method=RequestMethod.POST , value ="/getuserreportsingledepotanddeprtwise")
	 			public List<UserProfileRegistrationDetailModel> getuserreportsingledepotdeprtwise(@RequestBody UserProfileRegistrationDetailModel obj2 ){
//	 				logger.info("Controller : UserRegistrationController || Method : getcustomizeuserdetails ||user_zone  "+objrecord + "||Find Records Response  "+ objrecord);
	 					return registrationServiceObj.getuserreportsingledepoandeprttwise(obj2);
	 			
	 			}
	 			
	 			@RequestMapping(method=RequestMethod.POST , value ="/getuserreportsingledepotnddesigwise")
	 			public List<UserProfileRegistrationDetailModel> getuserreportsingledepotdesigwise(@RequestBody UserProfileRegistrationDetailModel obj2 ){
//	 				logger.info("Controller : UserRegistrationController || Method : getcustomizeuserdetails ||user_zone  "+objrecord + "||Find Records Response  "+ objrecord);
	 					return registrationServiceObj.getuserreportsingledepoandesigwise(obj2);
	 			
	 			}
	 			
	 			
	 			@RequestMapping(method=RequestMethod.POST , value ="/getuserreportsingledepoanddatewise")
	 			public List<UserProfileRegistrationDetailModel> getreportdepoanddatewise(@RequestBody UserProfileRegistrationDetailModel obj2 ){
//	 				logger.info("Controller : UserRegistrationController || Method : getreportdepoanddatewise ||user_zone  "+objrecord + "||Find Records Response  "+ objrecord);
	 					return registrationServiceObj.getreportdepotanddatewise(obj2);
	 			
	 			}
	 			
	 			@RequestMapping(method=RequestMethod.POST , value ="/updateadditionalshed")
	 			public boolean updateuseraddtionalshed(@RequestBody UserProfileRegistrationDetailModel obj2 ){
	 					return registrationServiceObj.updateuseraddtionalshed(obj2);	 					 
	 			
	 			}
	 			
	 			
	 			//method for fetching shed and zone for no additional shed rows for a given user ID.
	 			@RequestMapping(method=RequestMethod.POST, value="/getShedZoneForNonAdditionalShed")
	 			public List<UserProfileRegistrationDetailModel> callGetShedAndZone(@RequestBody UserProfileRegistrationDetailModel userObj){
	 				return registrationServiceObj.getShedZoneWithNoAdditionalShed(userObj);		
	 			}
	 			
	 			//method for fetching shed and zone for no additional shed rows for a given user ID.
	 			@RequestMapping(method=RequestMethod.POST, value="/getactiveuser")
	 			public List<UserProfileRegistrationDetailModel> getactiveuser(@RequestBody UserProfileRegistrationDetailModel userObj1){
	 				return registrationServiceObj.getActiveuser(userObj1);		
	 			}
	 		
	 			// Developer : Gaurav Dt. 25.9.2022
	 			@RequestMapping(method=RequestMethod.POST, value="/deactivateUserFromShed")
	 			public boolean callEnableDisableUser(@RequestBody UserProfileRegistrationDetailModel userObj) {
	 				//boolean flag = false;
	 				return registrationServiceObj.updateActivationStatusSM(userObj);
	 				//return flag;
	 			}
	 			
	 			//jyoti Bisht for MCDO
	 			// function to Fetch No. of registered users within a duration for station
	 			@PostMapping("/registered_users_station")
	 			public int getregisteredusers_station(@RequestParam("from") String date1, @RequestParam("to") String date2) throws ParseException{
	 				return registrationServiceObj.getusercount_station(date1,date2);		
	 			}
	 			//jyoti Bisht
	 			// function to Fetch No. of registered users within a duration
	 			@PostMapping("/registered_users_loco")
	 			public int getregisteredusers_loco(@RequestParam("from") String date1, @RequestParam("to") String date2) throws ParseException{
	 				return registrationServiceObj.getusercount_loco(date1,date2);		
	 			}
	 			//jyoti Bisht
	 			// function to Fetch No. of registered users within a duration
	 			@PostMapping("/registered_users_coach")
	 			public int getregisteredusers_coach(@RequestParam("from") String date1, @RequestParam("to") String date2) throws ParseException{
	 				return registrationServiceObj.getusercount_coach(date1,date2);		
	 			}
	 			
				@RequestMapping(method=RequestMethod.POST , value ="/getzonetyperolewiseuser")
	 			public List<UserProfileRegistrationDetailModel> getuserdetailbyroleandtypezone(@RequestBody UserProfileRegistrationDetailModel obj_user ){
	 					return registrationServiceObj.getuserdetailbyroleandtypezone(obj_user);
	 			
	 			}
	 			

	 			@RequestMapping(method=RequestMethod.POST , value ="/getzonetyperolewiseuser1")
	 			public List<Object[]> getuserdetailbyroleandtypezone1(@RequestBody UserProfileRegistrationDetailModel obj_user ){
	 					return registrationServiceObj.getuserdetailbyroleandtypezone1(obj_user);
	 			
	 			}
	 	
	 			// Jyoti Bisht 6-12-22  for User deletion
	 			@PostMapping("/delete_user")
	 			public boolean delete_user(@RequestParam("user_id") String user_id)
	 			{
	 				return registrationServiceObj.delete_user_details(user_id);
	 			}
	 			
	 			// Jyoti Bisht 23-02-23  for User profile update
	 			@PostMapping("/update_user_profile")
	 			public boolean update_user_profile(@RequestBody UserProfileRegistrationDetailModel user)
	 			{
	 				System.out.println("user email "+user.getEmail()+ user.getMobile_no()+ user.getUser_type()+ user.getUser_id());
	 				return registrationServiceObj.update_user_profile(user.getEmail(), user.getMobile_no(), user.getUser_type(), user.getUser_id());
	 			}
	 			



	 		
}
