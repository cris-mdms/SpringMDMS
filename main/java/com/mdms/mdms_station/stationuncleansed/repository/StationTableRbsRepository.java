package com.mdms.mdms_station.stationuncleansed.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.mdms_station.stationuncleansed.model.StationTableRbs;
import com.mdms.mdms_station.stationuncleansed.model.StnRBSTotalDataJSON;
import com.mdms.app.mgmt.model.UserProfileRegistrationDetailModel;
import com.mdms.dahsboard.model.DashBoardStationCountDivisionWiseModel;
import com.mdms.dahsboard.model.ZonalUsersAssetModel;
import com.mdms.mdms_masters.model.MZone;
import com.mdms.mdms_station.stationuncleansed.model.RbsPKey;
import com.mdms.mdms_station.stationuncleansed.model.StationRbsAPIJSONModel;
public interface StationTableRbsRepository  extends CrudRepository<StationTableRbs,RbsPKey>{
	
	//Anshul
	@Query(value="select distinct stn_code from  mdms_station.station_table_rbs where div_ser_no=?1 except\r\n" + 
			"	select distinct station_code from mdms_station.station_uncleansed_data where cmi_status IN ('U','A')", nativeQuery = true)
	List<String>getDivisionalStnCodeCmi(int divsno);
	
	

	//Anshul //modified to select / station /yard/ cabin on the basis of category .
	@Query(value="select distinct stn_code from  mdms_station.station_table_rbs where div_ser_no=?1 and stn_status NOT in('A','B') except\r\n" + 
			"	select distinct station_code from mdms_station.station_uncleansed_data where dti_status IN ('U','A')", nativeQuery = true)
	List<String>getDivisionalStnCodeDti(int divsno);
	
	
	//Anshul 08-06-2023 // to select codes for siding only 
	@Query(value="select distinct stn_code from  mdms_station.station_table_rbs where div_ser_no=?1 and stn_status=?2 except\r\n" + 	
	"	select distinct station_code from mdms_station.station_uncleansed_data where dti_status IN ('U','A')", nativeQuery = true)
	List<String>getDivisionalStnCodeDti(int divsno,String cateogory);
	

	//Anshul
//	@Query(value="select distinct stn_code from  mdms_station.station_table_rbs where div_ser_no=?1 except\r\n" + 
//			"	select distinct station_code from mdms_station.station_uncleansed_data where dti_status IN ('U','A')", nativeQuery = true)
//	List<String>getDivisionalStnCodeDti(int divsno);
	

	//Anshul
	@Query(value="select * from  mdms_station.station_table_rbs where stn_code=?1 and stn_vld_upto=("
			+ "select stn_vld_upto from mdms_station.station_table_rbs where stn_code=?1 order by stn_vld_upto DESC LIMIT 1)", nativeQuery = true)
	StationTableRbs getStationRecordRBS(String station_code);
	
	
	//Anshul
	  @Query(value="select zone,count(*) as count from mdms_app_mgmt.user_profile_registration_detail where user_type='SU' group by zone",nativeQuery=true)
	  List<ZonalUsersAssetModel> getZoneWiseUsers();
	
	
	
	
	
	
	
	
	
	
	

	  @Query(value="SELECT division_code,count(*) as total_division_count FROM mdms_masters.m_division where zone_code=?1 group by division_code",nativeQuery=true)
	  Collection<DashBoardStationCountDivisionWiseModel> getTotalStationCountDivisionWise(String zone_code);	  
	  
	  @Query(value=" select division_code,uncleansed_count from (\r\n"
	  		+ "			  select e.zone_code,f.division_code,count(*) as uncleansed_count from (select distinct  division_code, stn_code\r\n"
	  		+ "																	  FROM mdms_station.station_table_rbs as a join mdms_masters.m_division as b\r\n"
	  		+ "	  				on a.div_ser_no= b.division_sr_no except select division_code,station_code FROM mdms_station.station_uncleansed_data) AS f\r\n"
	  		+ "					join mdms_masters.m_division as e\r\n"
	  		+ "					on f.division_code=e.division_code\r\n"
	  		+ "					where e.zone_code=?1\r\n"
	  		+ "					group by 1,2 ) as aa",nativeQuery=true)
			  Collection<DashBoardStationCountDivisionWiseModel> getUncleansedStationCountDivisionWise(String zone_code);

	
	  //shilpi 04-03-2021
	  @Query(value="SELECT division_code,COUNT(*) as total_division_count from mdms_station.station_table_rbs as a, mdms_masters.m_division as b"
	  		+ " where current_date between stn_vld_from and stn_vld_upto and a.div_ser_no=b.division_sr_no and b.division_code=?1 GROUP BY division_code",nativeQuery=true)
	Collection<DashBoardStationCountDivisionWiseModel> getTotalStationCountSingleDivisionWise(String division_code);
//	  @Query(value="SELECT division_code,count(*) as total_division_count_single FROM mdms_masters.m_division where division_code=?1 group by division_code",nativeQuery=true)
//	  Collection<DashBoardStationCountDivisionWiseModel> getTotalStationCountSingleDivisionWise(String division_code);	  
//	 
	  //	  
  
//shilpi -03-03-2021
	  
	  @Query(value=" select division_code,uncleansed_count from (\r\n"
		  		+ "			  select e.zone_code,f.division_code,count(*) as uncleansed_count from (select distinct  division_code, stn_code\r\n"
		  		+ "																	  FROM mdms_station.station_table_rbs as a join mdms_masters.m_division as b\r\n"
		  		+ "	  				on a.div_ser_no= b.division_sr_no WHERE current_date between a.stn_vld_from and a.stn_vld_upto except select division_code,station_code FROM mdms_station.station_cleansed_data) AS f\r\n"
		  		+ "					join mdms_masters.m_division as e\r\n"
		  		+ "					on f.division_code=e.division_code\r\n"
		  		+ "					where e.division_code=?1\r\n"
		  		+ "					group by 1,2 ) as aa",nativeQuery=true)
				  Collection<DashBoardStationCountDivisionWiseModel> getUncleansedStationCountsingledivision(String division_code);  

			  

	  @Query(value=" select division_code,count(*) as draft_forward_approval_count\r\n"
		  		+ "			  	from mdms_station.station_uncleansed_data where zone_code=?1 and cmi_status='D' OR dti_status='D' group by division_code\r\n"
		  		+ "			",nativeQuery=true)
		  Collection<DashBoardStationCountDivisionWiseModel> getTotalDraftForwardApprovalStationCountZoneDivisionWise(String zone_code);
		  

	  
	  
	  /// division and zone 
@Query(value="SELECT division_code,count(*) as total_division_count FROM mdms_masters.m_division where zone_code=?1 group by division_code",nativeQuery=true)
Collection<DashBoardStationCountDivisionWiseModel> getTotalStationCountZoneDivisionWise(String zone_code);	  

@Query(value=" select division_code,uncleansed_count from (\r\n"
		+ "			  select e.zone_code,f.division_code,count(*) as uncleansed_count from (select distinct  division_code, stn_code\r\n"
		+ "																	  FROM mdms_station.station_table_rbs as a join mdms_masters.m_division as b\r\n"
		+ "	  				on a.div_ser_no= b.division_sr_no except select division_code,station_code FROM mdms_station.station_uncleansed_data) AS f\r\n"
		+ "					join mdms_masters.m_division as e\r\n"
		+ "					on f.division_code=e.division_code\r\n"
		+ "					where e.zone_code=?1\r\n"
		+ "					group by 1,2 ) as aa",nativeQuery=true)
		  Collection<DashBoardStationCountDivisionWiseModel> getUncleansedStationCountZoneDivisionWise(String zone_code);



	  //shilpi 22-03-2021
//	  @Query(value="SELECT zone_code as zone_code , division_code,count(*) as total_division_count FROM mdms_masters.m_division where zone_code=?1 group by division_code",nativeQuery=true)
//	Collection<DashBoardStationCountDivisionWiseModel> getTotalStationCountZoneWise(String zone_code);

	  @Query(value="SELECT b.zone_code as zone_code,division_code,COUNT(*) as total_division_count \r\n"
	  		+ "				 from mdms_station.station_table_rbs as a,mdms_masters.m_division as b \r\n"
	  		+ "				 where current_date between stn_vld_from and stn_vld_upto and a.div_ser_no=b.division_sr_no \r\n"
	  		+ "				 and b.zone_code=?1 GROUP BY 1,2	 order by 2",nativeQuery=true)
		Collection<DashBoardStationCountDivisionWiseModel> getTotalStationCountZoneWise(String zone_code);


	  
	  @Query(value="select zone_code,division_code,count(*) as uncleansed_count from (select distinct b.zone_code, division_code, stn_code \r\n"
	  		+ "															 FROM mdms_station.station_table_rbs as a \r\n"
	  		+ "															 join mdms_masters.m_division as b\r\n"
	  		+ "		on a.div_ser_no= b.division_sr_no AND   current_date between stn_vld_from and stn_vld_upto \r\n"
	  		+ "															 and b.zone_code=?1  except select zone_code,division_code,station_code \r\n"
	  		+ "															 FROM mdms_station.station_cleansed_data)\r\n"
	  		+ "															 AS uncleansed  group by 1,2 ORDER BY 1",nativeQuery=true)
				  Collection<DashBoardStationCountDivisionWiseModel> getUncleansedStationCountZone(String zone_code);  

	  //Shilpi 09-04-2021 zonal hyperlink
	  
	  @Query(value="select  * FROM mdms_station.station_table_rbs as a join mdms_masters.m_division as b \r\n"
	  		+ "	on a.div_ser_no= b.division_sr_no 	WHERE current_date between a.stn_vld_from and a.stn_vld_upto AND division_code=?1\r\n"
	  		+ "	AND stn_code NOT IN (SELECT  station_code FROM mdms_station.station_cleansed_data WHERE division_code=?1)",nativeQuery=true)
	  List<StationTableRbs> getUncleanstnHyperDivision(String division_code);
	  
	  
	  // ritu - query to fetch station integration data  
	  @Query(value="select stn_code,count(*) from  mdms_station.station_table_rbs where stn_code in"
	  		+ " (select distinct stn_code from  mdms_station.station_table_rbs where timestamp>=?1 and  timestamp<=?2)"
	  		+ " group by 1 having count(*)=1",nativeQuery=true)
	  List<StationTableRbs> getstnintegrationstats(Date fromdt, Date todate);

	  
	    // JYOTI BISHT 31-10-22
	    @Query(value=" select extract(month from  \"timestamp\") as mon,count(distinct stn_code) from mdms_station.station_table_rbs\n"
	    		+ "where timestamp>=?1 and  timestamp<=?2\n"
	    		+ " group by mon\n"
	    		+ "", nativeQuery=true)
	    List<Object[]> station_total_count(Date date1, Date date2);
	    
	    // JYOTI BISHT 31-10-22
	    @Query(value=" select count(*) from MDMS_station.station_table_rbs\n"
	    		+ "where current_date between stn_vld_from and stn_vld_upto\n"
	    		+ "", nativeQuery=true)
	    int station_total_count1();
	    
	    // JYOTI BISHT 31-10-22
	    @Query(value=" select count(distinct stn_code) from  mdms_station.station_table_rbs\n"
	    		+ "where stn_code in (select stn_code from  mdms_station.station_table_rbs\n"
	    		+ "where stn_code in (select distinct stn_code from  mdms_station.station_table_rbs\n"
	    		+ "where timestamp>=?1 and  timestamp<=?2)\n"
	    		+ "group by 1\n"
	    		+ "having count(*)=1 )\n"
	    		+ "and  stn_vld_from>=?1", nativeQuery = true)
	   int integration(Date date1, Date date2);
	  
	    	
	    
	    @Query(value="select a.stn_name, a.stn_code, a.category, \r\n"
	    		+ "b.division_code, b.division_name, b.zone_code, a.district_code,a.state_code,a.gauge_type,a.pin_code,a.tehsil,a.traffic_type ,c.district_name,c.state_name,\r\n"
	    		+ "a.stn_vld_upto,a.stn_vld_from "
	    		+ "from MDMS_station.station_table_rbs a join mdms_station.rbs_division b on a.div_ser_no=b.division_ser_no join  mdms_masters.m_district c on c.district_code=a.district_code "
	    		+ "where (cast(:zone_code as text) is null or b.zone_code=cast(:zone_code as text)) and (cast(:div_code as text) is null or trim(b.division_code)=cast(:div_code as text)) and current_date between stn_vld_from and stn_vld_upto ",  nativeQuery = true)
//	    		List<Object[]> getstndatatilldate();
	    		List<Object[]> getstndatatilldate(@org.springframework.data.repository.query.Param("zone_code") String zone_code , @org.springframework.data.repository.query.Param("div_code")String div_code);
	   	
	    // JYOTI BISHT 9-5-23
	    @Query(value="select count(*) from\r\n"
	    				+ "	(select distinct stn_code,division_code from mdms_station.station_table_rbs join mdms_station.rbs_division on \r\n"
	    				+ "	 div_ser_no=division_ser_no where current_date between stn_vld_from and stn_vld_upto) a\r\n"
	    				+ "	group by a.division_code having rtrim(a.division_code)=?1", nativeQuery = true)
	    int get_division_station_count(String div);
	    	
	    
	    // JYOTI BISHT 10-5-23
	    @Query(value="select stn_code,stn_name,stn_vld_from,stn_vld_upto from mdms_station.station_table_rbs join mdms_station.rbs_division on\r\n"
	    		+ "	    				 div_ser_no=division_ser_no where rtrim(division_code)=?1  and  current_date between stn_vld_from and stn_vld_upto order by stn_code", nativeQuery = true)
	    List<Object[]> get_stations(String div);
	    

	    		
}


