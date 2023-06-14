package com.mdms.dashboard.service;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.mdms.mdms_station.stationuncleansed.model.StationTableRbs;
import com.mdms.mdms_station.stationuncleansed.repository.StationTableRbsRepository;
@Service
public class IntegrationStatisticsService {
Logger logger=LoggerFactory.getLogger(SuperUserDashboardService.class);		
@Autowired
private JdbcTemplate jdbcTemplate;
@Autowired
StationTableRbsRepository stn_db_repo;		
	public List<StationTableRbs> getStnStatus(Date fromdt , Date todate) {
		logger.info("Service : IntegrationStatisticsService || Method: getStnStatus");		 		
		List<StationTableRbs> tmp = new ArrayList<>();
		stn_db_repo.getstnintegrationstats(fromdt,todate).forEach(tmp::add);		
	    return tmp;
	
	  
		
	}
 
	
}
