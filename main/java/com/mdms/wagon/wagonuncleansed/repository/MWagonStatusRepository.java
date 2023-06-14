package com.mdms.wagon.wagonuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.wagon.wagonuncleansed.model.MWagonStatus;

public interface MWagonStatusRepository extends CrudRepository<MWagonStatus,Long>{
	// Developer : ritu - service to fetch data   18.10.21
			@Query(value="SELECT * FROM mdms_wagon.m_wagon_status", nativeQuery=true)
			List<MWagonStatus> getWagonStatus();
		
		
}
