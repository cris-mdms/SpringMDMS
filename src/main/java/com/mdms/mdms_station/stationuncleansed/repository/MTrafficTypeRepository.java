package com.mdms.mdms_station.stationuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.mdms_station.stationuncleansed.model.MTrafficType;

public interface MTrafficTypeRepository extends CrudRepository<MTrafficType,String> {
	
	@Query(value="Select * from mdms_station.m_traffic_type", nativeQuery = true)
	List<MTrafficType> getTraffic();

	@Query(value="Select description from mdms_station.m_traffic_type where traffic_type=?1", nativeQuery = true)
	String getTrafficDescription(String traffic_type);

}
