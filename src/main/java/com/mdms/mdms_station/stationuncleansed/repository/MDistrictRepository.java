package com.mdms.mdms_station.stationuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.mdms.mdms_station.stationuncleansed.model.MDistrict;

public interface MDistrictRepository extends CrudRepository<MDistrict,Long> {
	
	@Query(value="Select * FROM mdms_masters.m_district",nativeQuery = true)
	List<MDistrict> getLgdDistrict();
	@Query(value="Select district_name  FROM mdms_masters.m_district where district_code =?1",nativeQuery = true)
	String getLgdDistrictName(int district_code);

}
