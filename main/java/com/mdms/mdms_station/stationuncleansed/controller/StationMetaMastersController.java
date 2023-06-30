/*This controller provides all Station Meta Masters .
 * Gauge,Gis,Interlocking,Operating_signal,Category,Station Class,Interchange Junction,Status,Traction,Traffic Type
 * Created By : Anshul, 22-10-2020
 * 
 */
package com.mdms.mdms_station.stationuncleansed.controller;


import java.util.ArrayList;
import java.util.List;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mdms.mdms_station.stationuncleansed.model.MBookingResource;
import com.mdms.mdms_station.stationuncleansed.model.MBookingType;

import com.mdms.mdms_station.stationuncleansed.model.MGauge;
import com.mdms.mdms_station.stationuncleansed.model.MGisDetail;
import com.mdms.mdms_station.stationuncleansed.model.MInterlockingStandard;
import com.mdms.mdms_station.stationuncleansed.model.MOperatingStationSignal;
import com.mdms.mdms_station.stationuncleansed.model.MStationCategory;
import com.mdms.mdms_station.stationuncleansed.model.MStationClass;
import com.mdms.mdms_station.stationuncleansed.model.MStationInterchange;
import com.mdms.mdms_station.stationuncleansed.model.MStationJunction;
import com.mdms.mdms_station.stationuncleansed.model.MStationStatus;
import com.mdms.mdms_station.stationuncleansed.model.MTraction;
import com.mdms.mdms_station.stationuncleansed.model.MTrafficType;
import com.mdms.mdms_station.stationuncleansed.model.MgisDetails;
import com.mdms.mdms_station.stationuncleansed.model.MgsNewModel;
import com.mdms.mdms_station.stationuncleansed.model.RtisLatLongModel;
import com.mdms.mdms_station.stationuncleansed.model.rbs_division;
import com.mdms.mdms_station.stationuncleansed.service.StationMetaMastersService;

import com.mdms.mdms_station.stationuncleansed.model.MState;
import com.mdms.mdms_station.stationuncleansed.model.MDistrict;

import com.mdms.mdms_station.stationuncleansed.service.StationMetaMastersService;

@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")


@RestController
public class StationMetaMastersController {
	
	
	@Autowired
	private StationMetaMastersService stn_meta_serv;
	

	Logger logger=LoggerFactory.getLogger(StationMetaMastersController.class);

	@RequestMapping(method=RequestMethod.POST,value="/gauge")
	public List<MGauge> getAllGauge(){
		
		logger.info("Controller : StationMetaMastersController || Method : getAllGauge ");


		return stn_meta_serv.getAllGauge();
	}
	
//	
//	@RequestMapping(method=RequestMethod.POST, value="/gis")
//	public List<MGisDetail> getLatLong(@RequestParam("station_code")String station_code){
//		return stn_meta_serv.getLatLong(station_code);
//	}
//	
	
	
	
	@RequestMapping(method=RequestMethod.POST, value="/gis")
	public List<MgsNewModel> getlatLong(@RequestParam(name = "stationCode") String station_code){
		
		return stn_meta_serv.getlatlongitude(station_code);
     }
	
	@RequestMapping(method=RequestMethod.POST, value="/interlck")
	public List<MInterlockingStandard> getInterLock(){
		return stn_meta_serv.getInterLock();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/oprtnsignal")
	public List<MOperatingStationSignal> getOperatingSignal(){
		return stn_meta_serv.getOperatingSignal();
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/stnclass")
	public List<MStationClass> getStationClass(){
		return stn_meta_serv.getStationClass();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/interchng")
	public List<MStationInterchange> getStationInterchange(){
		return stn_meta_serv.getStationInterchange();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/junction")
	public List<MStationJunction> getStationJunction(){
		return stn_meta_serv.getStationJunction();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/traction")
	public List<MTraction> getTraction(){
		return stn_meta_serv.getTraction();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/traffictype")
	public List<MTrafficType> getTraffic(){
		return stn_meta_serv.getTraffic();
	}

	
	@RequestMapping(method=RequestMethod.POST, value="/bookingtype")
	public List<MBookingType> getBookingType(){
		return stn_meta_serv.getBookingType();
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/bookingresource")
	public List<MBookingResource> getBookingResource(){
		return stn_meta_serv.getBookingResource();
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/stncategory")
	public List<MStationCategory> getStationCategory(){
		
		return stn_meta_serv.getStationCategory();
		
	}
	
	
	
	/* function definition – To send all LGD -states data
	 * 	Developer – Anshul 
	Date : 23-10-2020
	*/
	@RequestMapping(method=RequestMethod.POST , value="/state")
	public List<MState> getLgdState()
	
		{
		logger.info("controller : StationMetaMastersController || Method : sendState ");
	
		return stn_meta_serv.getLgdState();
	
		
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/getrbszone")
	public List<String> getrbsallzone(){
		return stn_meta_serv.getrbsallzone();
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/getrbsdivision")
	public List<rbs_division> getrbsdivbyzone(@RequestParam String zonecode){
		System.out.println(zonecode);
		return stn_meta_serv.getrbsdivision(zonecode);
	}

	/* function definition – To send all LGD -district data
	 * 	Developer – Anshul 
	Date : 23-10-2020
	*/
	
	@RequestMapping(method=RequestMethod.POST , value="/district")
	public	List<MDistrict> getLgdDistrict()
	{	logger.info("controller : StationMetaMastersController || Method : sendDistrict ");
	
	return stn_meta_serv.getLgdDistrict();
}

	@RequestMapping(method=RequestMethod.POST, value="/gisss")
	public List<MgisDetails> getLatLongData(@RequestParam(name = "stationCode") String station_code){
		
		return stn_meta_serv.getLatLongDetails(station_code);
     }
	
		/*
		 * @RequestMapping(method=RequestMethod.POST, value="/gissss") public
		 * List<RtisLatLongModel> getLatLongRtisData(@RequestParam(name = "stationCode")
		 * String station_code){
		 * 
		 * return stn_meta_serv.getLatLongRtisDetails(station_code); }
		 */
}
