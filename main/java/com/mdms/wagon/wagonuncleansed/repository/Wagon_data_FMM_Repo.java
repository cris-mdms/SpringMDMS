package com.mdms.wagon.wagonuncleansed.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.jpa.repository.query.Procedure;

import org.springframework.data.repository.CrudRepository;


import com.mdms.wagon.wagonuncleansed.model.Wagon_data_fmm;

public interface Wagon_data_FMM_Repo extends CrudRepository<Wagon_data_fmm,String> {
	
    // JYOTI BISHT 1-11-22
    @Query(value="select extract(month from  txn_timestamp) as mon,record_status,count(wagonid) from  mdms_wagon.wagon_data_fmm\r\n"
    		+ "where wagonid in (select wagonid from  mdms_wagon.wagon_data_fmm\r\n"
    		+ "where txn_timestamp>=?1 and  txn_timestamp<=?2 and wagon_status in ('A','R' ,'N') and wagon_valid_flag='Y')\r\n"
    		+ "and txn_timestamp>=?1 and  txn_timestamp<=?2 and wagon_status in ('A','R','N')\r\n"
    		+ "group by 1,2\r\n"
    		+ "", nativeQuery = true)
    List<Object[]> integration(Date date1, Date date2);
    
    
    // JYOTI BISHT 1-11-22
    @Query(value="select count(wagonid) from mdms_wagon.wagon_data_fmm\r\n"
    		+ "where wagon_status in ('A','R','N') and wagon_valid_flag='Y'\r\n"
    		+ "", nativeQuery=true)
    int wagon_total_count();
    
    //Ritu 07-11-22
    @Query(value="SELECT  orgtype, count(wagonid) FROM mdms_wagon.wagon_data_fmm where wagon_status in ('A','R','N') and wagon_valid_flag='Y' group by 1" , nativeQuery=true)
    List<Object[]> getwagontypecount();

  
    //Ritu 20-03-23
    @Procedure(value="mdms_wagon.f_wagon_dashboard_total_ess")
  		String getWagonDashboardCount();


}
