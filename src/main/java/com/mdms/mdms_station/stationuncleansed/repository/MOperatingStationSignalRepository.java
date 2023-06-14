package com.mdms.mdms_station.stationuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.mdms_station.stationuncleansed.model.MOperatingStationSignal;

public interface MOperatingStationSignalRepository extends CrudRepository<MOperatingStationSignal,String>{
	
	@Query(value="Select * from mdms_station.m_operating_station_signal", nativeQuery = true)
	List<MOperatingStationSignal> getOperatingSignal();

}
