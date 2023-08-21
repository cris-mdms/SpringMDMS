package com.mdms.dashboard.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.dahsboard.model.StationHomeDashboard;

public interface StationHomeDashboardRepo extends CrudRepository <StationHomeDashboard,String>{

	//total
	  @Query(value="select count(*) total from (\r\n"
	  		+ "SELECT distinct stn_code Total  from mdms_station.station_table_rbs where current_date between stn_vld_from and stn_vld_upto and div_ser_no=?1)a",nativeQuery=true)
	  String getTotal(int div);
	  
	  
	  
	  //getuncleansed
	  @Query(value="select count(*) from (\r\n"
	  		+ "SELECT distinct stn_code from mdms_station.station_table_rbs where current_date between stn_vld_from and stn_vld_upto and div_ser_no=?1\r\n"
	  		+ "except\r\n"
	  		+ "SELECT distinct station_code from mdms_station.station_uncleansed_data where division_code=?2 and dti_status='A' and cmi_status='A' \r\n"
	  		+ ")b",nativeQuery=true)
		  String getuncleansed(int div,String div_code);
	  
	  //getuncleansed DTI
	  @Query(value="select count(*) from (\r\n"
	  		+ "SELECT distinct stn_code from mdms_station.station_table_rbs where current_date between stn_vld_from and stn_vld_upto and div_ser_no=?1\r\n"
	  		+ "except\r\n"
	  		+ "SELECT distinct station_code from mdms_station.station_uncleansed_data where division_code=?2 and dti_status='A'\r\n"
	  		+ ")b",nativeQuery=true)
		  String getuncleansedDTI(int div,String div_code);
	  
	  //getuncleansed CMI
	  @Query(value="select count(*) from (\r\n"
	  		+ "SELECT distinct stn_code from mdms_station.station_table_rbs where current_date between stn_vld_from and stn_vld_upto and div_ser_no=?1\r\n"
	  		+ "except\r\n"
	  		+ "SELECT distinct station_code from mdms_station.station_uncleansed_data where division_code=?2 and cmi_status='A'\r\n"
	  		+ ")b",nativeQuery=true)
		  String getuncleansedCMI(int div,String div_code);
	  
	  //cleansed
	  @Query(value="select count(*) from (\r\n"
	  		+ "SELECT distinct station_code from mdms_station.station_uncleansed_data where division_code=?1 and dti_status='A' and cmi_status='A' \r\n"
	  		+ ")b",nativeQuery=true)
			  String getcleansed(String div_code);
	  
	  
	  //cleansed DTI
	  @Query(value="select count(*) from (\r\n"
	  		+ "SELECT distinct station_code from mdms_station.station_uncleansed_data where division_code=?1 and dti_status='A'\r\n"
	  		+ ")b",nativeQuery=true)
			  String getcleanseddti(String div_code);
	  //cleansed CMI
	  @Query(value="select count(*) from (\r\n"
	  		+ "SELECT distinct station_code from mdms_station.station_uncleansed_data where division_code=?1 and cmi_status='A'\r\n"
	  		+ ")b",nativeQuery=true)
			  String getcleansedcmi(String div_code);
	  
	  
	  //pending at dti
	  @Query(value="select count(*) from (\r\n"
	  		+ "SELECT distinct station_code from mdms_station.station_uncleansed_data where division_code=?1 and dti_status='U'\r\n"
	  		+ ")b",nativeQuery=true)
				  String getpendingdti(String div_code);
	//pending at cmi
	  @Query(value="select count(*) from (\r\n"
	  		+ "SELECT distinct station_code from mdms_station.station_uncleansed_data where division_code=?1 and cmi_status='U'\r\n"
	  		+ ")b",nativeQuery=true)
				  String getpendingcmi(String div_code);
	  
	  
	  //reject at dti
	  @Query(value="select count(*) from (\r\n"
	  		+ "SELECT distinct station_code from mdms_station.station_uncleansed_data where division_code=?1 and dti_status='R'\r\n"
	  		+ ")b",nativeQuery=true)
				  String getrejectdti(String div_code);
	  
	  //reject at cmi
	  @Query(value="select count(*) from (\r\n"
	  		+ "SELECT distinct station_code from mdms_station.station_uncleansed_data where division_code=?1 and cmi_status='R'\r\n"
	  		+ ")b",nativeQuery=true)
				  String getrejectcmi(String div_code);
	  
	//draft dti
	  @Query(value="select count(*) from (\r\n"
	  		+ "SELECT distinct station_code from mdms_station.station_uncleansed_data where division_code=?1 and dti_status='D'\r\n"
	  		+ ")b",nativeQuery=true)
				  String getdraftdti(String div_code);
	  
	//draft cmi
	  @Query(value="select count(*) from (\r\n"
	  		+ "SELECT distinct station_code from mdms_station.station_uncleansed_data where division_code=?1 and cmi_status='D'\r\n"
	  		+ ")b",nativeQuery=true)
				  String getdraftcmi(String div_code);
	  
	  
		//not initiated by cmi
	  @Query(value="select count(*) from (\r\n"
	  		+ "SELECT distinct station_code from mdms_station.station_uncleansed_data where division_code=?1 and cmi_status='N'\r\n"
	  		+ ")b",nativeQuery=true)
				  String getnotinitiatedcmi(String div_code);
	  
		//not initiated by dti
	  @Query(value="select count(*) from (\r\n"
	  		+ "SELECT distinct station_code from mdms_station.station_uncleansed_data where division_code=?1 and dti_status='N'\r\n"
	  		+ ")b",nativeQuery=true)
				  String getnotinitiateddti(String div_code);
	  
	//uncleansedntinitiated
	  @Query(value="select count(*) from (SELECT distinct stn_code from mdms_station.station_table_rbs where current_date between stn_vld_from and stn_vld_upto and div_ser_no=?1 \r\n"
	  		+ "except SELECT distinct station_code from mdms_station.station_uncleansed_data where division_code=?2)b",nativeQuery=true)
				  String getuncleansednotinitiated(int div,String div_code);
	  
	  
}
