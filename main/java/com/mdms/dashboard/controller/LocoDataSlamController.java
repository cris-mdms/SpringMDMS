package com.mdms.dashboard.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mdms.app.mgmt.controller.UserLoginController;
import com.mdms.dahsboard.model.LocoDataSlamModel;
import com.mdms.dashboard.service.LocoDataSlamService;
import com.mdms.loco.locouncleansed.model.LocoDataSlam;

@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")
@RestController
public class LocoDataSlamController {
	@Autowired
	private LocoDataSlamService obj_service;
	Logger logger=LoggerFactory.getLogger(LocoDataSlamController.class);
	
	@RequestMapping(method=RequestMethod.POST, value ="/getslamloco_only")
	public List<LocoDataSlamModel> getslamloco()
	{
		logger.info("Controller : LocoDataSlamController || Method : getslamloco");
		return obj_service.getslamlocoonly();
	
	}
	

	@RequestMapping(method=RequestMethod.POST, value ="/getmdmsloco_only")
	public List<LocoDataSlam> getmdmsloco()
	{
		logger.info("Controller : LocoDataSlamController || Method : getmdmsloco");
		return obj_service.getmdmslocoonly();
	
	}
	
	@RequestMapping(method=RequestMethod.POST, value ="/getmismatchedsheddata")
	public List<LocoDataSlam> getmismatchedsheddata()
	{
		logger.info("Controller : LocoDataSlamController || Method : getmismatchedsheddata");
		return obj_service.getshedcodemismatche();
	
	}
	
	@RequestMapping(method=RequestMethod.POST, value ="/gettypemismatched")
	public List<LocoDataSlam> gettypemismatche()
	{
		logger.info("Controller : LocoDataSlamController || Method : gettypemismatche");
		return obj_service.gettypemismatche();
	
	}

	@RequestMapping(method=RequestMethod.POST, value ="/getalltypemismatched")
	public List<LocoDataSlam> getalltypemismatche()
	{
		logger.info("Controller : LocoDataSlamController || Method : gettypemismatche");
		return obj_service.getalltypemismatche();
	
	}
}
