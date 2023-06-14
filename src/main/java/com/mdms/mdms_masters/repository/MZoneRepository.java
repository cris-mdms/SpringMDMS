package com.mdms.mdms_masters.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.mdms_masters.model.MZone;
public interface MZoneRepository extends CrudRepository<MZone,String>{
	@Query(value="Select zone_code from mdms_masters.m_zone where ir_zone='Y'", nativeQuery = true)
	List<String> getAllZone();
	
	@Query(value="Select * from mdms_masters.m_zone where ir_zone='Y'", nativeQuery = true)
	List<MZone> getZone();
	
	
	
}
