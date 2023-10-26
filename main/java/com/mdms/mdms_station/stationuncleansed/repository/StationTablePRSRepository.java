package com.mdms.mdms_station.stationuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.mdms_station.stationuncleansed.model.StationTablePRS;


public interface StationTablePRSRepository extends CrudRepository<StationTablePRS,String>{
	
	//Anshul  17-10-2023 //select station short name for station code 
	@Query(value="SELECT stn_name FROM mdms_station.station_table_prs where stn_code=?1", nativeQuery = true)
	String getShortNamePrs(String stn_code);

}
