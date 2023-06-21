package com.mdms.dashboard.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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

import com.mdms.dahsboard.model.DailyIntegrationModel;
import com.mdms.dahsboard.model.DivisonUsersAssetModel;
import com.mdms.dahsboard.model.RbUserCount;
import com.mdms.dahsboard.model.ZonalUsersAssetModel;
import com.mdms.dashboard.service.SuperUserDashboardService;

@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false")

@RestController
public class SuperUserDashboardController {
	Logger logger=LoggerFactory.getLogger(SuperUserDashboardController.class);
	
	@Autowired
	SuperUserDashboardService su_dash_servc;
	
	@RequestMapping(method=RequestMethod.POST, value="/getTotalAsset")
	public HashMap<String,Integer> getTotalAssets(){
		
		logger.info("controller : SuperUserDashboardController || Method : getTotalAssets");
		return su_dash_servc.getTotalAssets();
	}
	
	
	
	@RequestMapping(method=RequestMethod.POST, value="/getCleansedAsset")
	public HashMap<String,Integer>getCleansedAssets(){
		
		logger.info("controller : SuperUserDashboardController || Method : getCleansedAssets");
		return su_dash_servc.getCleansedAssets();
	}
	
	
	
	@RequestMapping(method=RequestMethod.POST, value="/regusercount")
	public  ArrayList<HashMap<String,String>> getRegisteredUserCount(){
		
		logger.info("controller : SuperUserDashboardController || Method : getRegisteredUserCount");
		return su_dash_servc.getRegisteredUserCount();
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/assetstats")
	public 	ArrayList<HashMap<String,String>> getAssetRecords() {
		
		logger.info("controller : SuperUserDashboardController || Method : getAssetRecords");
		return su_dash_servc.getAssetRecords();
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/zonewiseusers")
	public 	List<ZonalUsersAssetModel> getZoneWiseUsers(@RequestBody String usertype) {
		
		logger.info("controller : SuperUserDashboardController || Method : getZoneWiseUsers");
		return su_dash_servc.getZoneWiseUsers(usertype);
		
	}
	@RequestMapping(method=RequestMethod.POST, value="/zonewiseuserswithoutlogin")
	public 	List<ZonalUsersAssetModel> getZoneWiseUsersfordashboarwithoutlogin(@RequestBody String usertype) {
		
		logger.info("controller : SuperUserDashboardController || Method : getZoneWiseUsersfordashboarwithoutlogin");
		return su_dash_servc.getZoneWiseUsersfordashboarwithoutlogin(usertype);
		
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/zonewiserec")
	public 	List<ZonalUsersAssetModel> getZoneWiseRecords(@RequestBody String usertype) {
		
		logger.info("controller : SuperUserDashboardController || Method : getZoneWiseRecords");
		return su_dash_servc.getZoneWiseRecords(usertype);
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/divwiserec")
	public 	List<DivisonUsersAssetModel> getDivisionWiseRecords(@RequestParam (value="usertype") String usertype ,@RequestParam (value="zone") String zone ) {
		
		logger.info("controller : SuperUserDashboardController || Method : getDivisionWiseRecords");
		return su_dash_servc.getDivisionWiseRecords(usertype,zone);}

	
	@RequestMapping(method=RequestMethod.POST, value="/dailypublishdata")
	public 	List<DailyIntegrationModel> getdailypublishintegration() {
				logger.info("controller : SuperUserDashboardController || Method : getdailypublishintegration");
		return su_dash_servc.getdailypublishintegration();}

	
	@RequestMapping(method=RequestMethod.POST, value="/dailysubscribedata")
	public 	List<DailyIntegrationModel> getdailysubscriptionintegration() {
				logger.info("controller : SuperUserDashboardController || Method : getdailysubscriptionintegration");
		return su_dash_servc.getdailysubscriptionintegration();}
	
	// 26-04-2021
	@RequestMapping(method=RequestMethod.POST, value="/coachtypemappingcount")
	public 	ArrayList<HashMap<String,String>> getCoachAssetRecords() {
		
		logger.info("controller : SuperUserDashboardController || Method : getCoachAssetRecords");
		return su_dash_servc.getCoachAssetRecords();
		
	}
	
	//Shilpi 26-04-2021
	
	@RequestMapping(method=RequestMethod.POST, value="/getCoachLayoutRecords")
	public 	ArrayList<HashMap<String,String>> getCoachLayoutRecords() {
		
		logger.info("controller : SuperUserDashboardController || Method : getCoachLayoutRecords");
		return su_dash_servc.getCoachLayoutRecords();

		
	}
	
	
	
	

}
