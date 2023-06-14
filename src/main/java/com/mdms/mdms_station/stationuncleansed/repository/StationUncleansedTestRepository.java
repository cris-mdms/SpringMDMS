package com.mdms.mdms_station.stationuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.mdms_station.stationuncleansed.model.StationUncleansedTest;

public interface StationUncleansedTestRepository extends CrudRepository<StationUncleansedTest,String> {
	
	
	@Query(value="select station_code, station_numeric_code , station_name,traffic_type,transhipment_flag ,zone_code ,division_code ,gauge_code FROM mdms_station.station_uncleansed_data where  cmi_status='U' and division_code=?1", nativeQuery = true)
	List<StationUncleansedTest>fetchUnapprovedCmiRecords1(String division_code);

}
