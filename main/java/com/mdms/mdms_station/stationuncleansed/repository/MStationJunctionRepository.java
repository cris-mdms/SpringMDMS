
package com.mdms.mdms_station.stationuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.mdms_station.stationuncleansed.model.MStationJunction;

public interface MStationJunctionRepository extends CrudRepository<MStationJunction,String> {

	@Query(value="Select * from mdms_station.m_station_junction", nativeQuery = true)
	List<MStationJunction> getStationJunction();
	
	@Query(value="Select description from mdms_station.m_station_junction where junction_flag=?1", nativeQuery = true)
	String getStationJunctionDescription(String junction_flag);
	

}
