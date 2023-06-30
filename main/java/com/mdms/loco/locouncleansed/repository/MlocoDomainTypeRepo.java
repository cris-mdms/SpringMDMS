package com.mdms.loco.locouncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.loco.locouncleansed.model.MlocoDomainType;

public interface MlocoDomainTypeRepo extends CrudRepository<MlocoDomainType,Long> {
	
	@Query(value="select  *  from mdms_loco.m_loco_domain_type", nativeQuery=true)
	List<MlocoDomainType> findnomitype();


}
