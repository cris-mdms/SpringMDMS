package com.mdms.mdms_masters.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.mdms_masters.model.MShed;
import com.mdms.mdms_masters.model.MShedMgmt;
public interface MShedMgmtRepository extends CrudRepository<MShedMgmt,Integer>{
	@Query(value="select * from mdms_masters.m_shed_mgmt where zone_code=?1 and division_code=?2 and status='U'",nativeQuery=true)
	List<MShedMgmt> returnNewGeneratedShedCode(String zoneCode, String divnCode);
	
	@Query(value="select * from mdms_masters.m_shed_mgmt where zone_code=?1 and division_code=?2 and status='R'",nativeQuery=true)
	List<MShedMgmt> returnRejectedShedCode(String zoneCode, String divnCode);
	
	@Query(value="select * from mdms_masters.m_shed_mgmt where zone_code=?1 and division_code=?2 and status='A'",nativeQuery=true)
	List<MShedMgmt> returnapprovedNewGeneratedShedCode(String zoneCode, String divnCode);
	
	
	
	@Transactional
	@Modifying
	@Query(value="update  mdms_masters.m_shed_mgmt set status=?1 , approved_by=?2 where shed_code=?3",nativeQuery=true)
	void updateshedStatus(String status, String approvedby, String shedcode);
	
	
	@Query(value="SELECT * FROM mdms_masters.m_shed_mgmt \r\n"
			+ "	where (cast(:zone_code as text) is null or zone_code=(cast(:zone_code as text))) and (cast(:div_code as text) is null or division_code=(cast(:div_code as text))) AND status='A' \r\n"
			+ "	order by zone_code, division_code, serving_stn_code asc ",nativeQuery=true)
	 List<MShedMgmt> display_approved_shed(@org.springframework.data.repository.query.Param("zone_code") String zone, @org.springframework.data.repository.query.Param("div_code") String division);
	
}
