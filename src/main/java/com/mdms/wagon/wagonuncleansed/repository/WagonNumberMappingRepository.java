package com.mdms.wagon.wagonuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.wagon.wagonuncleansed.model.WagonNumberMapping;

public interface WagonNumberMappingRepository extends CrudRepository<WagonNumberMapping,Long>{
	// Developer : ritu - service to check wagon number exist in db or not 01.09.21
			@Query(value="SELECT wagon_owning_rly	FROM mdms_wagon.m_wagon_owning_rly", nativeQuery=true)
			List<String> getWagonOwningRlycode();
	
}
