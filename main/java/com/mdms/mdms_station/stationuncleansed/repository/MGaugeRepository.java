package com.mdms.mdms_station.stationuncleansed.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.mdms_station.stationuncleansed.model.MGauge;
public interface MGaugeRepository extends CrudRepository<MGauge,String>{
	
	@Query(value="Select * from mdms_masters.m_gauge", nativeQuery = true)
	List<MGauge> getAllGauge();
	
	@Query(value="Select description from mdms_masters.m_gauge where gauge_code=?1", nativeQuery = true)
	String getAllGaugeDescription(String gauge_code);

}
