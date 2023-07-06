package com.mdms.hr.hub.controller;

import java.util.Date;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mdms.hr.hub.model.EmployeeDataHRMS;
import com.mdms.hr.hub.service.EmployeeDataHRMSService;

@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")
@RestController
public class EmployeeDataHRMSController {
	@Autowired
	EmployeeDataHRMSService obj_service;
	//getIPASSuserdetail 
		@RequestMapping(method=RequestMethod.POST, value="/getipassuserdata")
		public  List<EmployeeDataHRMS>  getipassuserdetail(@RequestParam("ipas_id") String ipas_id) {


		   System.out.println(ipas_id);

		   System.out.println("hello user"+ipas_id);


		 


			return obj_service.getipassuserdetail(ipas_id);
		}
	   
	   
		@RequestMapping(method=RequestMethod.POST, value="/get_total_hr_count")
		public  int  gettotalhrcount()
		{
			return obj_service.get_hr_total_count();
		}
		
		@RequestMapping(method=RequestMethod.POST, value="/hr_integration")
		public  int  gettotalcountmonthwise(@RequestParam("from") String from, @RequestParam("to") String to) throws ParseException
		{
			return obj_service.integration_stats(from, to);
		}
		@RequestMapping(method=RequestMethod.POST, value="/hr_integration_insert")
		public  int  gettotainsertlcountmonthwise(@RequestParam("from") String from, @RequestParam("to") String to) throws ParseException
		{
			return obj_service.integration_stats_insert(from, to);
		}
		

		//jyoti bisht 17-3-23
		
		@PostMapping("/get_designations")
		public List<String> get_designation()
		{
			return obj_service.getDesignations();
		}
		
		

}
