package com.mdms.loco.locouncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.loco.locouncleansed.model.MLocoShedNew;


public interface MLocoShedNewRepository  extends CrudRepository<MLocoShedNew, Integer> {
	
	@Query(value="SELECT * FROM mdms_loco.m_loco_shed_new where zone_code =?1 and division_code=?2 and sno not in "
			+ "(select  srno from mdms_masters.m_shed_mgmt where status='A' or status='U') order by shed_code asc",nativeQuery=true)
	List<MLocoShedNew> return_loco_shed_data(String zone_code, String Div_code);
	
	
//	@Query(value="SELECT distinct zone_code FROM mdms_loco.m_loco_shed_new",nativeQuery=true)
	@Query(value="select distinct a.zone_code as fois, b.zone_code as rb FROM mdms_loco.m_loco_shed_new a join mdms_masters.m_zone b on a.zone_code=b.fois_zone", nativeQuery = true)
	List<Object[]> findAllZone();
	
	//JYOTI BISHT 2-11-22
//	@Query(value="select distinct division_code from mdms_loco.m_loco_shed_new where zone_code=?1", nativeQuery = true)
	@Query(value="	SELECT distinct division_code, case when division_code='BB' THEN 'CSMT' WHEN division_code='BVC' THEN 'BVP' ELSE division_code\r\n"
			+ " END rbs_divison  \r\n"
			+ " from mdms_loco.m_loco_shed_new where zone_code=?1 order by 1",nativeQuery = true)
	List<Object[]> get_div_by_zone(String zone);

}
