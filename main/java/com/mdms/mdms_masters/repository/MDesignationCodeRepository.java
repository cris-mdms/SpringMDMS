package com.mdms.mdms_masters.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.mdms_masters.model.MDesignationCode;

public interface MDesignationCodeRepository extends CrudRepository<MDesignationCode,Long>{
	@Query(value="select * from  mdms_masters.m_designation e where e.hrms_designation=?1 and is_active_designation ='Y'", nativeQuery = true)
	List<MDesignationCode> getassetsLocoDesignation(String locodesig); 
	
//	@Query(value="select distinct asset_designation_code  from  mdms_masters.m_designation  where asset_designation_code like '%:?1%' and  is_active_designation ='Y'", nativeQuery = true)
//	String checkassetscodeexist(String locodesig1); 
	
	@Query(value="select distinct asset_designation_code  from  mdms_masters.m_designation  where asset_designation_code=?1 and  is_active_designation ='Y'", nativeQuery = true)
	String checkassetscodeexist(String locodesig1); 
	
	

}
