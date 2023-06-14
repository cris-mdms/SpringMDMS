package com.mdms.wagon.wagonuncleansed.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mdms.wagon.wagonuncleansed.model.WagonNumberMapping;
import com.mdms.wagon.wagonuncleansed.service.WagonNumberMappingService;
@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")

@RestController
public class WagonNumberMappingController {
	@Autowired
	private WagonNumberMappingService obj;
	
	@RequestMapping(method=RequestMethod.POST, value = "/getWagonDetail")
	public List<WagonNumberMapping> getAllWagonDetail()
	{
		return obj.getAllWagonDetail();
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/deleteWagonDetail")
	public boolean deleteWagonrecord(@RequestBody WagonNumberMapping irwmswagonnumber)
		{		
		return  obj.deleteWagonrecord(irwmswagonnumber.getIrwms_wagon_no());
		
	}
	

}
