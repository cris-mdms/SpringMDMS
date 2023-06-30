package com.mdms.dashboard.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mdms.dashboard.service.ElectricLocoDashboardService;
@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false")

@RestController
public class ElectricLocoDashboardController {
	Logger logger=LoggerFactory.getLogger(ElectricLocoDashboardController.class);
	@Autowired
	private ElectricLocoDashboardService elecLocoServ_Obj;
	
//	@RequestMapping(method=RequestMethod.POST, value="/getCleansedElectricLocoshedwise")
//	public HashMap<String,Integer> getCleansedElectricLocoshedwise(){
//		
//		logger.info("controller : ElectricLocoDashboardController || Method : getCleansedElectricLocoshedwise");
//		return elecLocoServ_Obj.getCleansedElectricLocoshedwise();
//	}
//	
	
	

}
