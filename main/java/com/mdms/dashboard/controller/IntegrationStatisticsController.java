package com.mdms.dashboard.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mdms.dashboard.service.IntegrationStatisticsService;
import com.mdms.mdms_station.stationuncleansed.model.StationTableRbs;
@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials="false")
@RestController
public class IntegrationStatisticsController {	
	Logger logger=LoggerFactory.getLogger(IntegrationStatisticsController.class);
	@Autowired
	IntegrationStatisticsService su_integr_servc;
	
	@RequestMapping(method=RequestMethod.POST, value="/getStnIntegrationStatus")
	public List<StationTableRbs> getStnStatus(@RequestParam("from_date") Date fromdt , @RequestParam("to_date") Date todate){		
		logger.info("controller : IntegrationStatisticsController || Method : getStnIntegrationStatus");
		return su_integr_servc.getStnStatus(fromdt,todate);
	}
}
