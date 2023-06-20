package com.mdms.dashboard.service;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
@Service
public class ElectricLocoDashboardService {
	 Logger logger=LoggerFactory.getLogger(ElectricLocoDashboardService.class);
	 @Autowired
		private JdbcTemplate jdbcTemplate;
	 public HashMap<String,Integer> getCleansedElectricLocoshedwise() {
			logger.info("Service : ElectricLocoDashboardService || Method: getCleansedElectricLocoshedwise");

			 HashMap<String, Integer> map = new HashMap<>();
			 
			 try {
				final String shedwisecleansedeletricloco="SELECT  loco_owning_shed ,count(*) FROM loco.electric_loco_master_approved WHERE cleansed_uid is not null GROUP BY loco_owning_shed";
				final int shedwiserecords= (int)jdbcTemplate.queryForObject(shedwisecleansedeletricloco,Integer.class);

	       map.put("shedwiserecords",shedwiserecords);
			    return map;
			 }
			    catch(Exception e) {
			    	logger.error("Service : ElectricLocoDashboardService || Method: getCleansedElectricLocoshedwise|| Exception : " +e.getMessage());
					e.getMessage();
					return null;
			    }
}


}
