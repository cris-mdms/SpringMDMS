package com.mdms.hr.hub.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdms.hr.hub.model.EmployeeDataHRMS;
import com.mdms.hr.hub.repository.EmployeeDataHRMSRepo;


@Service
public class EmployeeDataHRMSService {
	@Autowired
	EmployeeDataHRMSRepo obj_repo;
	
	//getuserdetail
		public  List<EmployeeDataHRMS>  getipassuserdetail(String ipas_id) {
			 List<EmployeeDataHRMS> userdata= new ArrayList<>();
//			 String ipassid=EmployeeDataHRMS.getIpas_id();
			 obj_repo.getipassuserdetail(ipas_id).forEach(userdata::add);
				if(userdata.isEmpty()) {
				return  userdata ;				
				}
				else
					System.out.println("data" +userdata);
					return  userdata;
				
			
			}
	/*	
		public  List<EmployeeDataHRMS>  gettotalcountmonthwise(EmployeeDataHRMS obj) {
					 List<EmployeeDataHRMS> usercount= new ArrayList<>();
//			 String ipassid=EmployeeDataHRMS.getIpas_id();					 
			 obj_repo.gettotalcountmonthwise(obj.getTxn_timestamp(), obj.getTxn_timestamp()).forEach(usercount::add);
				if(usercount.isEmpty()) {
				return  usercount ;				
				}
				else
					System.out.println("data" +usercount);
					return  usercount;
		}
		
		public  List<EmployeeDataHRMS>  gettotalinsertcountmonthwise(EmployeeDataHRMS obj) {
			 List<EmployeeDataHRMS> userinsertcount= new ArrayList<>();
//	 String ipassid=EmployeeDataHRMS.getIpas_id();					 
	 obj_repo.gettotalinsertcpuntmonthwise(obj.getTxn_timestamp(), obj.getTxn_timestamp(), obj.getInsert_date(), obj.getInsert_date()).forEach(userinsertcount::add);
		if(userinsertcount.isEmpty()) {
		return  userinsertcount ;				
		}
		else
			System.out.println("data" +userinsertcount);
			return  userinsertcount;
}  */
		
		// JYOTI BISHT 31-10-22
		public int get_hr_total_count()
		{
		
		return obj_repo.gettotalcount();
		}
		// Jyoti Bisht 31-10-22
		public int integration_stats_insert(String from, String to) throws ParseException
		{   
			Date date1= new SimpleDateFormat("yyyy-MM-dd").parse(from);  
			Date date2= new SimpleDateFormat("yyyy-MM-dd").parse(to); 
			return obj_repo.gettotalinsertcpuntmonthwise(date1, date2);
				
		}
		// Jyoti Bisht 31-10-22
		public int integration_stats(String from, String to) throws ParseException
		{   
			Date date1= new SimpleDateFormat("yyyy-MM-dd").parse(from);  
			Date date2= new SimpleDateFormat("yyyy-MM-dd").parse(to); 
			return obj_repo.gettotalcountmonthwise(date1, date2);
				
		}
		
<<<<<<< HEAD
=======
		// JYOTI BISHT 17-3-22
		
		public List<String> getDesignations()
		{
			return obj_repo.getdesignations();			
		}
>>>>>>> a796579cb9d19590a212ed54e6e06c965fa48879
		
		
		
}

