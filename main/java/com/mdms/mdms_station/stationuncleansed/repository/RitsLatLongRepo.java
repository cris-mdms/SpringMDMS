package com.mdms.mdms_station.stationuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.mdms.mdms_station.stationuncleansed.model.RtisLatLongModel;

public interface RitsLatLongRepo extends CrudRepository<RtisLatLongModel,String> {
	
	@Query(value="Select station_latitude,station_longitude from mdms_station.rtis_lat_long_10_01_22 where station_code=?1", nativeQuery = true)
	List<RtisLatLongModel> getLatLatLongitudeDetail(String station_code);

}
