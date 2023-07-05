package com.mdms.loco.locouncleansed.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.loco.locouncleansed.model.LocoCondemnation;

public interface LocoCondemnRepo extends CrudRepository<LocoCondemnation, Integer>{
	
    	@Query(value="select a.loco_no from\r\n"
    			+ "(select loco_no from mdms_loco.loco_condemnation_mdms_user where (status='A' OR status='U')\r\n"
    			+ "union\r\n"
    			+ "select loco_no from mdms_loco.loco_condemnation_detail) a where a.loco_no=?1 ", nativeQuery = true)
	    public Integer condemn_loco_check(int loco_no);

		@Query(value="select * from mdms_loco.loco_condemnation_mdms_user where loco_owning_zone_code=? and loco_owning_shed_code=? and (status!='A' AND status!='R') ", nativeQuery = true)
		public List<LocoCondemnation>get_condemn_loco(String zone, String shed);
		
		@Modifying
		@Transactional
		@Query(value="update mdms_loco.loco_condemnation_mdms_user set status=?2, remarks=?3, user_id=?4, txn_date=?5 where loco_no=?1", nativeQuery = true)
		public int update_condemn_loco_status(int loco, String status, String remarks, String user_id, LocalDateTime date);
	
		@Modifying
		@Transactional
		@Query(value="insert into mdms_loco.loco_condemnation_mdms_user_history (select * from mdms_loco.loco_condemnation_mdms_user where loco_no=?1)",nativeQuery = true)
		public int insert_into_history(int loco);
		


}
