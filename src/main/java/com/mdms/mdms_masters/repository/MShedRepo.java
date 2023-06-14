package com.mdms.mdms_masters.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.mdms_masters.model.MShed;

public interface MShedRepo extends CrudRepository<MShed, Long> {
	@Query(value="select * from mdms_masters.m_shed_code_management_existing where trim(zone_code)=?1 and trim(division_code)=?2 and group_name='FOIS' order by group_name, serving_stn_name, shed_name ",nativeQuery=true)
	List<MShed> returnShedDetailsfois(String zoneCode, String divnCode);
	
	@Query(value="select * from mdms_masters.m_shed_code_management_existing where trim(zone_code)=?1 and trim(division_code)=?2 and group_name='SLAM' order by group_name, serving_stn_name, shed_name ",nativeQuery=true)
	List<MShed> returnShedDetailsslam(String zoneCode, String divnCode);
	@Query(value="select * from mdms_masters.m_shed_code_management_existing where trim(zone_code)=?1  and group_name='RB' order by group_name, serving_stn_name, shed_name ",nativeQuery=true)
	List<MShed> returnShedDetailsrb(String zoneCode);
	@Query(value="select distinct zone_code from mdms_masters.m_shed_code_management_existing where group_name='FOIS'",nativeQuery=true)
	List<String> getfoiszonelist();
	
	@Query(value="select distinct division_code from mdms_masters.m_shed_code_management_existing where zone_code=?1 and group_name='FOIS'",nativeQuery=true)
	List<String> getfoisdivlist(String zonecode);

	@Modifying
	@Transactional
	@Query(value ="INSERT INTO mdms_masters.m_shed_mgmt(shed_code,  shed_name, zone_code, division_code, traction_code, serving_stn_code, shed_type, entry_by, user_shed,status,srno,remarks,elec_loco_in_dslshed) \r\n"
			+ "VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10,?11, ?12,?13)",nativeQuery = true)
	int insertApprovedShedCode(String shedCode, String shedName, String zoneCode, String divisionCode, String tractionCode, String servingStnCode, String shedType, String userId, String userShed,String status, int srno,String remarks, String shed_flag);
	
	@Query(value="SELECT zone_code, division_code, traction_code, shed_code, shed_name, serving_stn_code, serving_stn_name, shed_type, group_name, description, srno \r\n"
			+ "	FROM mdms_masters.m_shed_code_management_existing \r\n"
			+ "	 	where division_code is not null and srno not in (select \r\n"
			+ "	 srno from mdms_masters.m_shed_mgmt) and (cast(:zone_code as text) is null or zone_code=cast(:zone_code as text)) and (cast(:div_code as text) is null or division_code=(cast(:div_code as text))) \r\n"
			+ "	 order by zone_code, division_code,serving_stn_code, serving_stn_name, group_name, traction_code, shed_type, shed_code, shed_name;",nativeQuery=true)
	List<MShed> returnExclShedDetails(@org.springframework.data.repository.query.Param("zone_code") String zone, @org.springframework.data.repository.query.Param("div_code") String division);
	
	
	@Query(value="SELECT zone_code, division_code, traction_code, shed_code, shed_name, serving_stn_code, serving_stn_name, shed_type, group_name,"
			+ "description, srno FROM mdms_masters.m_shed_code_management_existing where group_name='FOIS' and zone_code =?1 and division_code=?2 and srno not in "
			+ "(select  srno from mdms_masters.m_shed_mgmt) order by shed_code asc",nativeQuery=true)
	List<MShed> returnfoidata(String zone_code, String Div_code);
					 		
		
	
	
}
