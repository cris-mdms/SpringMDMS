package com.mdms.dashboard.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.jpa.repository.query.Procedure;

import org.springframework.data.repository.CrudRepository;

import com.mdms.dahsboard.model.DashBoardStationCountDivisionWiseModel;
import com.mdms.dahsboard.model.DashboardStationModel;
import com.mdms.dahsboard.model.ZonalUsersAssetModel;

public interface StationDashboardRepo  {
	  @Query(value="SELECT division_code,count(*) as total_division_count FROM mdms_masters.m_division  group by division_code",nativeQuery=true)
	  Collection<DashBoardStationCountDivisionWiseModel> getTotalStationCountDivisionWise();

	  
	  @Query(value=" select division_code,uncleansed_count from (\\r\\n\"\r\n"
	  		+ "	  		+ \"			  select e.zone_code,f.division_code,count(*) as uncleansed_count from (select distinct  division_code, stn_code\\r\\n\"\r\n"
	  		+ "	  		+ \"																	  FROM mdms_station.station_table_rbs as a join mdms_masters.m_division as b\\r\\n\"\r\n"
	  		+ "	  		+ \"	  				on a.div_ser_no= b.division_sr_no except select division_code,station_code FROM mdms_station.station_uncleansed_data) AS f\\r\\n\"\r\n"
	  		+ "	  		+ \"					join mdms_masters.m_division as e\\r\\n\"\r\n"
	  		+ "	  		+ \"					on f.division_code=e.division_code\\r\\n\"\r\n"
	  		+ "	  		+ \"					where e.zone_code=?1\\r\\n\"\r\n"
	  		+ "	  		+ \"					group by 1,2 ) as aa",nativeQuery=true)
  Collection<DashBoardStationCountDivisionWiseModel> getUncleansedStationCountDivisionWise(String zonecode);

	  @Query(value="SELECT division_code,COUNT(*) as total_division_count_single from mdms_station.station_table_rbs as a, mdms_masters.m_division as b where current_date between stn_vld_from and stn_vld_upto and a.div_ser_no=b.division_sr_no and b.division_code=?1 GROUP BY division_code",nativeQuery=true)
	Collection<DashBoardStationCountDivisionWiseModel> getTotalStationCountSingleDivisionWise(String division_code);
		
	  
	  @Query(value=" select division_code,uncleansed_count from (\\r\\n\"\r\n"
		  		+ "	  		+ \"			  select e.zone_code,f.division_code,count(*) as uncleansed_count from (select distinct  division_code, stn_code\\r\\n\"\r\n"
		  		+ "	  		+ \"																	  FROM mdms_station.station_table_rbs as a join mdms_masters.m_division as b\\r\\n\"\r\n"
		  		+ "	  		+ \"	  				on a.div_ser_no= b.division_sr_no except select division_code,station_code FROM mdms_station.station_uncleansed_data) AS f\\r\\n\"\r\n"
		  		+ "	  		+ \"					join mdms_masters.m_division as e\\r\\n\"\r\n"
		  		+ "	  		+ \"					on f.division_code=e.division_code\\r\\n\"\r\n"
		  		+ "	  		+ \"					where e.divcode=?1\\r\\n\"\r\n"
		  		+ "	  		+ \"					group by 1,2 ) as aa",nativeQuery=true)
	  Collection<DashBoardStationCountDivisionWiseModel> getUncleansedStationCountSingleDivisionWise(String divcode);
		  

	


}