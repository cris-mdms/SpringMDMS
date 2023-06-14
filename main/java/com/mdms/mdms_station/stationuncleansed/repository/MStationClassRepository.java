package com.mdms.mdms_station.stationuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.mdms_station.stationuncleansed.model.MStationClass;
public interface MStationClassRepository extends CrudRepository<MStationClass,String>{
	
	@Query(value="Select * from mdms_station.m_station_class", nativeQuery = true)
	List<MStationClass> getStationClass() ;
	
	@Query(value="Select description from mdms_station.m_station_class where station_class=?1", nativeQuery = true)
	String getStationClassDescription(String station_class) ;

}
