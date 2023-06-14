package com.mdms.mdms_station.stationuncleansed.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.mdms_station.stationuncleansed.model.MBookingResource;

public interface MBookingResourceRepository extends CrudRepository<MBookingResource,String>{

	
	@Query(value="Select * from mdms_station.m_booking_resource", nativeQuery = true)
	List<MBookingResource> getBookingResource();
	
	
	@Query(value="Select description from mdms_station.m_booking_resource where booking_code=?1", nativeQuery = true)
	String getBookingResourceDescription(String booking_resource);
}
