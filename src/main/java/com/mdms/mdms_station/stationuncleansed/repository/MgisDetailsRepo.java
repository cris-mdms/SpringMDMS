package com.mdms.mdms_station.stationuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.mdms_station.stationuncleansed.model.MgisDetails;

public interface MgisDetailsRepo extends CrudRepository<MgisDetails,String>{
	
	@Query(value="Select latitude,longitude from mdms_station.m_gis_detail where station_code=?1", nativeQuery = true)
	List<MgisDetails> getLatLatLongitude(String station_code);

}
