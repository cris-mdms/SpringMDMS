package com.mdms.loco.locouncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.loco.locouncleansed.model.MlocoControlType;

public interface MlocoControlTypeRepo extends CrudRepository<MlocoControlType,Long> {
	
	@Query(value="select  * from mdms_loco.m_loco_control_type", nativeQuery=true)
	List<MlocoControlType> findctrltype();

}
 