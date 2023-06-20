package com.mdms.mdms_station.stationuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.mdms.mdms_station.stationuncleansed.model.MBookingType;

public interface MBookingTypeRepository  extends CrudRepository<MBookingType,String>{
	

	@Query(value="Select * from mdms_station.m_booking_type", nativeQuery = true)
	List<MBookingType> getBookingType();
	
	@Query(value="Select description from mdms_station.m_booking_type where booking_type_code=?1", nativeQuery = true)
	String getBookingDescription(String booking_type_code);
}
