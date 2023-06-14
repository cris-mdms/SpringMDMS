package com.mdms.loco.locouncleansed.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.loco.locouncleansed.model.LocoApprovedDslData;



public interface LocoApprovedDslDataRepo extends CrudRepository<LocoApprovedDslData,Long>{
	@Transactional
	@Modifying
	@Query(value="UPDATE mdms_loco.loco_uncleansed_data SET status=?1, remarks=?2, user_id=?3  WHERE loco_no =?4", nativeQuery=true)
	int updatedslstatus(String status , String remarks, String uid , int locono);

}
