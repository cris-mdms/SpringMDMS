package com.mdms.mdms_station.stationuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.mdms_station.stationuncleansed.model.MStationCategory;

public interface MStationCategoryRepository extends CrudRepository<MStationCategory,String>{
	

	@Query(value="Select * from mdms_station.m_station_category", nativeQuery = true)
	List<MStationCategory> getStationCategory();
	
	@Query(value="Select description from mdms_station.m_station_category where station_category=?1", nativeQuery = true)
	String getStationCategoryDescription(String station_category);

}
