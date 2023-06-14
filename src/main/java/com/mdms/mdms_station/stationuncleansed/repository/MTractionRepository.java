package com.mdms.mdms_station.stationuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.mdms_station.stationuncleansed.model.MTraction;

public interface MTractionRepository extends CrudRepository<MTraction,String>{
	@Query(value="Select * from mdms_station.m_traction", nativeQuery = true)
	List<MTraction> getTraction();
	
	
	@Query(value="Select description from mdms_station.m_traction where traction_code=?1", nativeQuery = true)
	String getTractionDescription(String traction_code);

}
