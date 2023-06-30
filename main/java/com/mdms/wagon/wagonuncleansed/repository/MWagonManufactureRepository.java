package com.mdms.wagon.wagonuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.wagon.wagonuncleansed.model.MWagonManufacture;

public interface MWagonManufactureRepository extends CrudRepository<MWagonManufacture,Long>{
	// Developer : Ritu - service to fetch wagon_manufacture data   18.10.21
			@Query(value="SELECT * FROM mdms_wagon.m_wagon_manufacture", nativeQuery=true)
			List<MWagonManufacture> getWagonManufacture();
}

