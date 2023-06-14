package com.mdms.datadictionary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mdms.datadictionary.model.ReferentialsDynamicmodel;

/*@Repository("refrentialDynamicTableRepo")
public interface RefrentialDynamicTableRepo extends CrudRepository<ReferentialsDynamicmodel,String> {

	
	@Query(value = "SELECT  latitude, longitude, station_code FROM mdms_station.m_gis_detail", nativeQuery = true)
	List<ReferentialsDynamicmodel> getRefrentialDynamicData();

	
	
	
}*/

import com.mdms.datadictionary.model.ReferentialsDynamicmodel;

public interface RefrentialDynamicTableRepo extends CrudRepository<ReferentialsDynamicmodel, String> {
	@Query(value = "SELECT  latitude, longitude, station_code FROM mdms_station.m_gis_detail", nativeQuery = true)
	List<ReferentialsDynamicmodel> getRefrentialDynamicData();

}
