package com.mdms.loco.locouncleansed.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.mdms.loco.locouncleansed.model.LocoTransferDetails;

public interface LocoTransferDetailRepository extends CrudRepository<LocoTransferDetails,Long>{
	
	@Transactional
	@Modifying
	@Query(value="INSERT INTO mdms_loco.loco_transfer_detail(loco_no, loco_new_shed, loco_new_zone, loco_old_shed, loco_old_zone, loco_traction_code, "
			+ "loco_transfer_letter_no,	loco_transfer_date, remarks, transfer_by,  status)" +
			"VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11);", nativeQuery=true)
	int saveLocoTransferDetail(int locoNo, String loconewshed,String loconewZone,String locooldshed,String locooldZone,			
			String tractionCode, String trnsferletterno, Date locotrfdt,String remarks,String uid,String status
			);
	
	//update status -approved/Reject  
	
	
	 @Transactional 
	@Modifying	
	@Query(value="UPDATE  mdms_loco.loco_transfer_detail SET status=?1 , remarks=?2 WHERE loco_no=?3", nativeQuery=true)
	int updatestatus(String status, String remarks , int locono);
		
	 
	 
	
}
