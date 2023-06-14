package com.mdms.loco.locouncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.loco.locouncleansed.model.MLocoStoreAuxilary;

public interface MLocoStoreAuxilaryRepository extends CrudRepository<MLocoStoreAuxilary,Long> {

	@Query(value ="SELECT *	FROM mdms_loco.m_loco_store_auxilary",nativeQuery=true)
	List<MLocoStoreAuxilary> findall();
	
	
}
