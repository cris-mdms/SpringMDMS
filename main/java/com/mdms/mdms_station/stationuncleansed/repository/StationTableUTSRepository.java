package com.mdms.mdms_station.stationuncleansed.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.mdms_station.stationuncleansed.model.StationTableUTS;

public interface StationTableUTSRepository extends CrudRepository<StationTableUTS,String>{
	//Anshul  07-11-2023 //select station short name for station code 
		@Query(value="SELECT stn_name FROM mdms_station.station_table_uts where stn_code=?1", nativeQuery = true)
		String getShortNameUts(String stn_code);

}
