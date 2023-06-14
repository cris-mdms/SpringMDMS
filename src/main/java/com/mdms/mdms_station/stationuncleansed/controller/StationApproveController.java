/*This controller provides all services for approving records in station golden master.
 * Created By : Anshul, 21-10-2020
 * 
 */
package com.mdms.mdms_station.stationuncleansed.controller;

import org.slf4j.Logger;
import java.text.ParseException;
import java.text.SimpleDateFormat; 
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mdms.mdms_station.stationuncleansed.model.StationCleansedData;
import com.mdms.mdms_station.stationuncleansed.model.StationTableRbs;
import com.mdms.mdms_station.stationuncleansed.model.StationUncleansedData;
import com.mdms.mdms_station.stationuncleansed.service.StationApproveService;
import com.mdms.mdms_station.stationuncleansed.service.StationEditForwardService;
@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")

@RestController
public class StationApproveController {
	@Autowired
	private StationApproveService stn_cleansed_serv;
	
	Logger logger=LoggerFactory.getLogger(StationApproveController.class);
	
	@RequestMapping(method=RequestMethod.POST, value="/getTotalCleansedStationHyperDivisionWise")
	public  StationCleansedData getTotalCleansedStationHyperDivisionWise(@RequestBody StationCleansedData   stationdiv) throws Exception	{		
		return stn_cleansed_serv.getTotalCleansedStationHyperDivisionWise(stationdiv);
	}

	// JYOTI BISHT 17-10-22
	
		@PostMapping("/get_station_approved_count")
		public int getStationPending(@RequestParam("from")String from, @RequestParam("to") String to) throws ParseException{
	    return stn_cleansed_serv.getStationApproved(from, to);	
		}
		
}
