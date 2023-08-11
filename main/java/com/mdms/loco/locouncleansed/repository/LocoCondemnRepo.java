package com.mdms.loco.locouncleansed.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mdms.loco.locouncleansed.model.LocoCondemnation;
import com.mdms.loco.locouncleansed.model.Loco_condemn_interface;

public interface LocoCondemnRepo extends CrudRepository<LocoCondemnation, Integer>{
	
    	@Query(value="select a.loco_no from\r\n"
    			+ "(select loco_no from mdms_loco.loco_condemnation_mdms_user \r\n"
    			+ "union\r\n"
    			+ "select loco_no from mdms_loco.loco_condemnation_detail) a where a.loco_no=?1 ", nativeQuery = true)
	    public Integer condemn_loco_check(int loco_no);

		@Query(value="select * from mdms_loco.loco_condemnation_mdms_user where loco_owning_zone_code=?1 and loco_owning_shed_code=?2 and status=?3 ", nativeQuery = true)
		public List<LocoCondemnation>get_condemn_loco(String zone, String shed, String status);
		
		@Modifying
		@Transactional
		@Query(value="update mdms_loco.loco_condemnation_mdms_user set status=?2, remarks=?3, user_id=?4, txn_date=?5 where loco_no=?1", nativeQuery = true)
		public int update_condemn_loco_status(int loco, String status, String remarks, String user_id, LocalDateTime date);
		
	/*	@Modifying
		@Transactional
		@Query(value="update mdms_loco.loco_condemnation_mdms_user set status=NULL, remarks=?2, user_id=?3, txn_date=?4 where loco_no=?1", nativeQuery = true)
		public int update_condemn_loco_status1(int loco, String remarks, String user_id, LocalDateTime date);
	
	*/		
		@Modifying
		@Transactional
		@Query(value="insert into mdms_loco.loco_condemnation_mdms_user_history (select * from mdms_loco.loco_condemnation_mdms_user where loco_no=?1)",nativeQuery = true)
		public int insert_into_history(int loco);
		
		//jyoti bisht 17-7-23
		@Query(value="select loco_no, loco_type, loco_owning_shed_code,loco_owning_zone_code, loco_permanent_domain, traction_code, condemnation_date,condemnation_proposal_type, user_id, status, 'MDMS' as through_interface\r\n"
				+ "from mdms_loco.loco_condemnation_mdms_user where status='A' and loco_owning_shed_code=?1\r\n"
				+ "union\r\n"
				+ "select loco_no, loco_type, loco_owning_shed_code,loco_owning_zone_code, loco_permanent_domain, loco_traction_code as traction_code, loco_condemnation_date as condemnation_date,condemnation_proposal_type, forward_by as user_id, status, 'FOIS' as through_interface\r\n"
				+ "from mdms_loco.loco_condemnation_detail where fois_webservice_flag='Y' and loco_owning_shed_code=?1", nativeQuery = true)
		public List<Loco_condemn_interface> view_condemn_loco(String shed);
		
		//jyoti bisht 1-8-23
		@Query(value="select loco_no, loco_type,loco_owning_shed_code,loco_owning_zone_code, loco_permanent_domain, traction_code, condemnation_date,condemnation_proposal_type, user_id,status, 'MDMS' as through_interface\r\n"
				+ "from mdms_loco.loco_condemnation_mdms_user where (status='A' or status='G') and loco_no=?1\r\n"
				+ "union\r\n"
				+ "select loco_no, loco_type,loco_owning_shed_code,loco_owning_zone_code, loco_permanent_domain, loco_traction_code as traction_code, loco_condemnation_date as condemnation_date,condemnation_proposal_type, forward_by as user_id,status,'FOIS' as through_interface\r\n"
				+ "from mdms_loco.loco_condemnation_detail where fois_webservice_flag='Y' and loco_no=?1", nativeQuery = true)
		public Loco_condemn_interface view_condemn_loco_by_loco_no(int loco_no);
		
		
		
		
		//jyoti bisht 18-7-23
		@Query(value="select * from mdms_loco.loco_condemnation_mdms_user where loco_owning_shed_code=?", nativeQuery = true)
		public List<LocoCondemnation>rejected_condemn_loco(String shed);
		
		//jyoti bisht 18-7-23
		@Query(value="select * from mdms_loco.loco_condemnation_mdms_user where loco_owning_shed_code=?2 and loco_no=?1", nativeQuery = true)
		public LocoCondemnation loco_status_in_condemnation(int loco_no, String shed);


}
