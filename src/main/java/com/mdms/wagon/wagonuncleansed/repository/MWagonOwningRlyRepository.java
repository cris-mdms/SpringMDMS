package com.mdms.wagon.wagonuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.wagon.wagonuncleansed.model.MWagonOwningRly;
import com.mdms.wagon.wagonuncleansed.model.WagonUncleansedData;

public interface MWagonOwningRlyRepository extends CrudRepository<MWagonOwningRly,Long>{
	// Developer : ritu - service to fetch owning rly code  26.8.21
		@Query(value="SELECT *	FROM mdms_wagon.m_wagon_owning_rly", nativeQuery=true)
		List<MWagonOwningRly> getWagonOwningRlycode();
	
	

}
