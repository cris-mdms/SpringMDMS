package com.mdms.wagon.wagonuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.wagon.wagonuncleansed.model.MWagonType;

public interface MWagonTypeRepository extends CrudRepository<MWagonType , Long> {
	
	// Developer : ritu - service to fetch wagon type code  27.8.21
//	@Query(value="SELECT *	FROM mdms_wagon.m_wagon_type_irwms where active='Y'", nativeQuery=true)	
			@Query(value="SELECT * FROM mdms_wagon.m_wagon_type", nativeQuery=true)
			List<MWagonType> getWagonTypecode();

}
