package com.mdms.mdms_masters.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.mdms_masters.model.MDesignationStation;
public interface MDesignationStationRepo extends CrudRepository<MDesignationStation,Long> {
	
	@Query(value="select distinct asset_designation_code  from  mdms_masters.m_designation_station  where  asset_designation_code=?1 and  user_role =?2 and asset=?3 and is_active ='Y'", nativeQuery = true)
	String checkassetscodeexist(String designation,String role,String asset); 

}
