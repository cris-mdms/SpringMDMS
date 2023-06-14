package com.mdms.loco.locouncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.mdms.loco.locouncleansed.model.MLocoBoggie;

public interface MLocoBoggieRepository extends  CrudRepository<MLocoBoggie,Long>{

	@Query(value ="SELECT *	FROM mdms_loco.m_loco_boggie",nativeQuery=true)
	List<MLocoBoggie> findAll();
}
