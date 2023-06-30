package com.mdms.loco.locouncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.loco.locouncleansed.model.MLocoBrakeType;

public interface MLocoBrakeTypeRepository extends CrudRepository <MLocoBrakeType,Long>{
	@Query(value ="SELECT *	FROM mdms_loco.m_loco_brake_type",nativeQuery=true)
	List<MLocoBrakeType> findAll();

}
