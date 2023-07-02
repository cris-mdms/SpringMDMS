package com.mdms.hr.hub.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.hr.hub.model.EmployeeDataHRMS;

public interface EmployeeDataHRMSRepo  extends CrudRepository<EmployeeDataHRMS,Long>{
	// getuserdetail

		  @Query(value="SELECT * FROM mdms_hr_hub.employee_data_hrms where ipas_id=?1",nativeQuery=true)
          List<EmployeeDataHRMS> getipassuserdetail(String ipassid);
		 
		  @Query(value="select count(*) from mdms_hr_hub.employee_data_hrms",nativeQuery=true)
		  int gettotalcount();
		  
		  //—----Total transaction—--		  
		  @Query(value="select count(*) from mdms_hr_hub.employee_data_hrms where txn_timestamp>=?1 and txn_timestamp<=?2",nativeQuery=true)
		  int gettotalcountmonthwise(Date from, Date to);
		  
		//  —----Total insert—--
		  @Query(value="select count(*) from mdms_hr_hub.employee_data_hrms  where txn_timestamp >=?1 and txn_timestamp <=?2 and insert_date>=?1 and insert_date <=?2",nativeQuery=true)
		  int gettotalinsertcpuntmonthwise(Date from, Date to);
 
		  @Query(value="SELECT distinct designation FROM mdms_hr_hub.employee_data_hrms ORDER BY designation",nativeQuery=true)
		  List<String> getdesignations();


}
