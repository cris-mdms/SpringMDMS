package com.mdms.datadictionary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mdms.datadictionary.model.StationDataDictionary;

@Repository("StationDataDictionaryRepo")
public interface StationDataDictionaryRepo extends CrudRepository<StationDataDictionary,String> {
	
	@Query(value = "SELECT * FROM mdms_data_dictionary.station_attribute where asset_name=?1", nativeQuery = true)
	List<StationDataDictionary> getStationDataDictionary(String assetName);
	
	
	
	// JYOTI BISHT 28-3-23 DATA COLLATION
	@Query(value = "SELECT * FROM mdms_data_dictionary.station_attribute where asset_name=?1 and attribute_name not in ( select mdms_attribute\r\n"
			+ "	FROM mdms_data_dictionary.md_data_collation where entity_group=?2 and mdms_attribute is not null)", nativeQuery = true)
	List<StationDataDictionary> getFilteredAttributes(String assetName, String asset_group);

}
