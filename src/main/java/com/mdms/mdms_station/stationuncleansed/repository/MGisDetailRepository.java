package com.mdms.mdms_station.stationuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.mdms_station.stationuncleansed.model.MGisDetail;
import com.mdms.mdms_station.stationuncleansed.model.MgsNewModel;

public interface MGisDetailRepository extends CrudRepository<MGisDetail,String>{
	
	@Query(value="Select * from mdms_station.m_gis_detail where statio_code=?1", nativeQuery = true)
	List<MGisDetail> getLatLong(String station_code);
	
	
//	
//	@Query(value="Select station_latitude,station_longitude from mdms_station.m_gis_detail where statio_code=?1", nativeQuery = true)
//	List<MgsNewModel> getLatLatLongitude(String station_code);

}
