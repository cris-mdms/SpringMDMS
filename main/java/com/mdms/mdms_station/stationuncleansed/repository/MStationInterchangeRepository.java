package com.mdms.mdms_station.stationuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.mdms_station.stationuncleansed.model.MStationInterchange;
public interface MStationInterchangeRepository extends CrudRepository<MStationInterchange,String>{

	@Query(value="Select * from mdms_station.m_station_interchange", nativeQuery = true)
	List<MStationInterchange> getStationInterchange();
	
	@Query(value="Select description from mdms_station.m_station_interchange where interchange_flag=?1", nativeQuery = true)
	String getStationInterchangeDescription(String interchange_flag);

}
