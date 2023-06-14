package com.mdms.mdms_station.stationuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.mdms_station.stationuncleansed.model.MgsNewModel;

public interface MgisLatLongRepo  extends CrudRepository<MgsNewModel,String> {	
	@Query(value="Select station_latitude,station_longitude from mdms_station.rtis_lat_long_10_01_22 where station_code=?1", nativeQuery = true)
	List<MgsNewModel> getLatLatLongitude(String station_code);

}



//SELECT * FROM mdms_wagon.wagon_data_irwms where owningrly=?1 and vehicletype=?2 and vehicleno=?3", nativeQuery=true)