package com.mdms.dashboard.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mdms.app.mgmt.model.GetListUserRegistrationJsonModel;
import com.mdms.app.mgmt.model.UserProfileRegistrationDetailModel;
import com.mdms.dahsboard.model.DashBoardCoachCountDepoWiseModel;
import com.mdms.dahsboard.model.DashboardStationModel;
import com.mdms.dahsboard.model.GetLocoZonewiseDashboardJsonModel;
import com.mdms.dahsboard.model.ZonalUserReportModel;
import com.mdms.dahsboard.model.ZonalUsersAssetModel;
import com.mdms.dashboard.service.StationDashboardService;
@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false")
@RestController
public class StationDashboardController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private StationDashboardService stationServ_obj;
	
Logger logger=LoggerFactory.getLogger(StationDashboardController.class);

	
	@RequestMapping(method=RequestMethod.POST, value="/getStationStats")
	public HashMap<String,Integer> getStationStats(){
		
		logger.info("controller : StationDashboardController || Method : getStationStats");
		return stationServ_obj.getStationStats();
	}

	@RequestMapping(method=RequestMethod.POST, value="/getDivStationStats")
	public HashMap<String,Integer> getDivStationStats(String divcode){	
		
		logger.info("controller : StationDashboardController || Method : getDivStationStats");		
		return stationServ_obj.getDivisionWiseStationStats(divcode);
	}

		List<DashboardStationModel> list =new ArrayList<DashboardStationModel>();
		@RequestMapping(method=RequestMethod.POST, value="/getstationcountdivisionwise")
		public List<DashboardStationModel> getStationCountDivisionWise(@RequestBody DashboardStationModel  zone_code) {	
			list= stationServ_obj.getStationCountDivisionWise(zone_code);
		//	list.forEach((n) -> System.out.println(n.getDivision_code())); 
			logger.info("Controller : DashBoardStationController || Method: getStationCountDivisionWise || getStationCountDivisionWise Query list return : "+list.size());

	return list;

			}
		

	
		// shilpi 05-03-2021
		List<DashboardStationModel> list1 =new ArrayList<DashboardStationModel>();
		@RequestMapping(method=RequestMethod.POST, value="/getstationcountsingledivisionwise")
		public List<DashboardStationModel> getStationCountSingleDivisionWise(@RequestBody DashboardStationModel  division_code) {	
			list1= stationServ_obj.getStationCountSingleDivisionWise(division_code);
	    	logger.info("Controller : DashBoardStationController || Method: getStationCountSingleDivisionWise || getStationCountSingleDivisionWise Query list return : "+list1.size());

	return list1;

			}

		// shilpi 09-03-2021
				List<DashboardStationModel> list2 =new ArrayList<DashboardStationModel>();
				@RequestMapping(method=RequestMethod.POST, value="/getlococountsingleShedwise")
				public List<DashboardStationModel> getLocoCountSingleShedWise(@RequestBody DashboardStationModel  shedid) {	
					System.out.println(shedid);
					 list2= stationServ_obj.getLocoCountSingleShedWise(shedid);
				//	list.forEach((n) -> System.out.println(n.getDivision_code())); 
					logger.info("Controller : DashBoardStationController || Method: getLocoCountSingleShedWise || getLocoCountSingleShedWise Query list return : "+list2.size());

			return list2;

					}
				
				
				// shilpi 15-03-2021
				List<DashboardStationModel> list3 =new ArrayList<DashboardStationModel>();
				@RequestMapping(method=RequestMethod.POST, value="/getCoachcountsingleDepowise")
				public List<DashboardStationModel> getCoachCountSingleDepotWise(@RequestBody DashboardStationModel  owning_depot) {	
					System.out.println("depot"+ owning_depot.getOwning_depot());
					 list3= stationServ_obj.getCoachCountSingleDepotWise(owning_depot);
				//	list.forEach((n) -> System.out.println(n.getDivision_code())); 
					logger.info("Controller : DashBoardStationController || Method: getCoachCountSingleDepotWise || getCoachCountSingleDepotWise Query list return : "+list3.size());

			return list3;

					}
				
				
				// shilpi 19-03-2021
				List<DashboardStationModel> list4 =new ArrayList<DashboardStationModel>();
				@RequestMapping(method=RequestMethod.POST, value="/getLococountZonewise")
				public List<DashboardStationModel> getLocoCountZoneWise(@RequestBody DashboardStationModel  loco_owning_zone_code) {	
					System.out.println(loco_owning_zone_code);
					 list4=stationServ_obj.getLocoCountZoneWise(loco_owning_zone_code);
				//	list.forEach((n) -> System.out.println(n.getDivision_code())); 
					logger.info("Controller : DashBoardStationController || Method: getLocoCountZoneWise || getLocoCountZoneWise Query list4 return : "+list4.size());
			return list4;
					}
				
				
				//Shilpi 23-03-2021
				
				List<DashboardStationModel> list5 =new ArrayList<DashboardStationModel>();
				@RequestMapping(method=RequestMethod.POST, value="/getstationcountZonewise")
				public List<DashboardStationModel> getStationCountZoneWise(@RequestBody DashboardStationModel  zone_code) {	
					list5= stationServ_obj.getStationCountZoneWise(zone_code);
				//	list.forEach((n) -> System.out.println(n.getDivision_code())); 
					logger.info("Controller : DashBoardStationController || Method: getStationCountZoneWise || getStationCountZoneWise Query list5 return : "+list5.size());

			return list5;
					}


				@RequestMapping(method=RequestMethod.POST, value="/singlezonewiseusers")
				public 	List<ZonalUserReportModel> getSingleZoneWiseUsers(@RequestBody UserProfileRegistrationDetailModel obj1) {
										logger.info("controller : DashBoardStationController || Method : getSingleZoneWiseUsers");
					return stationServ_obj.getSingleZoneWiseUsers(obj1);
					
				}
				
				
				@RequestMapping(method=RequestMethod.POST, value="/singlezonelocowiseusers")
				public 	List<ZonalUserReportModel> getSingleLocoZoneWiseUsers(@RequestBody UserProfileRegistrationDetailModel obj1) {
										logger.info("controller : DashBoardStationController || Method : getSingleLocoZoneWiseUsers");
					return stationServ_obj.getSingleLocoZoneWiseUsers(obj1);
					
				}
				
				@RequestMapping(method=RequestMethod.POST, value="/singlezonecoachwiseusers")
				public 	List<ZonalUserReportModel> getSingleCoachZoneWiseUsers(@RequestBody UserProfileRegistrationDetailModel obj1) {
										logger.info("controller : DashBoardStationController || Method : getSingleCoachZoneWiseUsers");
					return stationServ_obj.getSingleCoachZoneWiseUsers(obj1);
					
				}

				// shilpi 20-04-2021 zone wise depot
				List<DashboardStationModel> list6 =new ArrayList<DashboardStationModel>();
				@RequestMapping(method=RequestMethod.POST, value="/getCoachCountZoneDepotWise")
				public List<DashboardStationModel> getCoachCountZoneDepotWise(@RequestBody DashboardStationModel  owning_rly) {	
					System.out.println(owning_rly);
					 list6= stationServ_obj.getCoachCountZoneDepotWise(owning_rly);
				//	list.forEach((n) -> System.out.println(n.getDivision_code())); 
					logger.info("Controller : DashBoardStationController || Method: getCoachCountZoneDepotWise || getCoachCountZoneDepotWise Query list6 return : "+list6.size());

			return list6;


					}
				
	

//				//coach type mapping	 
//				@RequestMapping(method=RequestMethod.POST, value = "/getcoachmapcount")
//				public List<DashBoardCoachCountDepoWiseModel> getCoachMapCount(@RequestBody DashBoardCoachCountDepoWiseModel objdraft ){				
//			    return stationServ_obj.geCoachMapCount(objdraft);	
//				}

				
				
				@RequestMapping(method=RequestMethod.POST, value="/getlocozonewisedashboardreport")
				public List<GetLocoZonewiseDashboardJsonModel> getLocoZonewiseReport(){
									
//					GetLocoZonewiseDashboardJsonModel response= stationServ_obj.getLocoZonewiseReport();
				
										logger.info("Controller : StationDashBoardController || Method : getLocoZonewiseReport ");

					return stationServ_obj.getLocoZonewiseReport();
					
				}

				
//				@RequestMapping(method=RequestMethod.POST, value="/getlocozonewisedashboardreport")
//				public 	 List<Object[]> getLocoZonewiseReport() {
//										logger.info("controller : DashBoardStationController || Method : getLocoZonewiseReport");
//										return stationServ_obj.getLocoZonewiseReport1();
//					
//				}
				@RequestMapping(method=RequestMethod.POST, value="/getloco")
				public List<GetLocoZonewiseDashboardJsonModel> getloco(){	
					
					logger.info("controller : StationDashboardController || Method : getDivStationStats");		
					return  stationServ_obj.getloco();
				}
}
