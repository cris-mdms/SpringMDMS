package com.mdms.loco.locouncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.loco.locouncleansed.model.MLocoShed;



public interface MLocoShedRepository extends CrudRepository <MLocoShed,Long>{

	@Query(value="SELECT * FROM mdms_loco.m_loco_shed where shed_flag='E' and ir_flag='Y'AND validity='Y'",nativeQuery=true)
	List<MLocoShed> findAll();

	@Query(value="SELECT * FROM mdms_loco.m_loco_shed where shed_flag='D' and ir_flag='Y'AND validity='Y'",nativeQuery=true)
	List<MLocoShed> findDShed();

	
	@Query(value="select  distinct zone_code FROM mdms_loco.m_loco_shed WHERE shed_code=?1 and ir_flag='Y' and validity='Y'",nativeQuery=true)	
	String findzone(String shedcode);	
	
	
	@Query(value="SELECT * FROM mdms_loco.m_loco_shed WHERE ir_flag='Y'AND validity='Y'",nativeQuery=true)
	List<MLocoShed> findAllShed();

	@Query(value="SELECT distinct zone_code FROM mdms_loco.m_loco_shed WHERE  ir_flag='Y'AND validity='Y'",nativeQuery=true)
	List<String> findAllZone();

	@Query(value="select  * from  mdms_loco.m_loco_shed where zone_code=?1 AND ir_flag='Y' and validity='Y'",nativeQuery=true)
	List<MLocoShed> findshedbyZone(String zonecode);
	
	@Query(value="select DISTINCT shed_code from mdms_loco.m_loco_shed where  ir_flag='Y' and  validity='Y' AND shed_code NOT IN(select shed from mdms_app_mgmt.user_profile_registration_detail where user_id=?1 and zone=?2) and zone_code=?3",nativeQuery=true)	
	List<String> findshedbyuserZone(String userid, String zonecode,String zone);
	
	//JYOTI BISHT 2-11-22
		@Query(value="select distinct shed_code from mdms_loco.m_loco_shed where zone_code=?1 ir_flag='Y' AND validity='Y'", nativeQuery = true)
		List<String> get_shed_by_zone(String zone);
		//JYOTI BISHT 2-11-22
		@Query(value="select distinct division_code from mdms_loco.m_loco_shed where zone_code=?1 ir_flag='Y' AND validity='Y'", nativeQuery = true)
		List<String> get_div_by_zone(String zone);
		
}
