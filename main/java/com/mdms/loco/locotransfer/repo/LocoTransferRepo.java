package com.mdms.loco.locotransfer.repo;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.loco.locotransfer.model.LocoTransferModel;

public interface LocoTransferRepo extends CrudRepository<LocoTransferModel,Long> {	
	@Transactional
	  @Modifying
	  @Query(value="INSERT INTO mdms_loco.loco_transfer_detail(\r\n"
	  		+ "	loco_no, loco_new_shed, loco_new_zone, loco_old_shed, loco_old_zone, loco_traction_code, loco_transfer_letter_no, loco_transfer_date,\r\n"
	  		+ "	remarks, transfer_by, data_entry_date, status,loco_new_division,loco_table_name) \r\n"
	  		+ "	\r\n"
	  		+ "	VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12,?13,?14);", nativeQuery=true)
	  int saveLocoTransferDetail(int
	  loco_no,String loco_new_shed,String loco_new_zone, String loco_old_shed,
	  String loco_old_zone, String loco_traction_code, String
	  loco_transfer_letter_no, Date loco_transfer_date, String remarks,String
	  transfer_by,Date data_entry_date,String status, String newdivision, String tablename
	  );
	 
	 // LocoCountshedWiseResponse
	  @Query(value="select  COUNT(*) FROM mdms_loco.loco_transfer_detail where loco_old_zone=?1 AND status='RS'",nativeQuery=true)
	    int getLocoCountzonewise(String loco_old_zone);
	  
	  
	  @Query(value="SELECT loco_no, loco_new_shed, loco_new_zone, loco_old_shed, loco_old_zone, loco_traction_code, loco_transfer_letter_no, loco_transfer_date, remarks, transfer_by, data_entry_date, status, reject_remarks, reject_user_id, reject_txn_time, accept_remarks,count_no_of_update,loco_new_division, accept_user_id, loco_table_name,accept_txn_time\r\n"
		  		+ "	FROM mdms_loco.loco_transfer_detail WHERE status=?1 and loco_old_zone=?2 and loco_traction_code=?3",nativeQuery=true)
		 List<LocoTransferModel> getLocoDataStatusWise(String status,String loco_old_zone, String tc);
	  
	  
		  
		  //have to write service where loco_old_shed will replace by loco_new_shed
		  
		  @Transactional
		  @Modifying
		  @Query(value="UPDATE mdms_loco.loco_transfer_detail\r\n"
		  		+ "	SET status=?1,accept_user_id=?2,accept_remarks=?3,accept_txn_time=?4"
		  		+ "	WHERE loco_no=?5",nativeQuery=true)
		  int updateStatus(String Status, String userid, String remarks, Date txntime,int loco_no);
		  
		  @Transactional
		  @Modifying
		  @Query(value="UPDATE mdms_loco.loco_transfer_detail\r\n"
		  		+ "	SET status=?1,reject_user_id=?2,reject_remarks=?3,reject_txn_time=?4"
		  		+ "	WHERE loco_no=?5",nativeQuery=true)
		  int updateRejectStatus(String Status, String userid, String rejectremarks, Date txntime,int loco_no);
		  
		  @Query(value="select  COUNT(*) FROM mdms_loco.loco_transfer_detail where loco_new_shed=?1 AND status='RA'",nativeQuery=true)
		    int getLocoCountNewShedwise(String loco_new_shed);
		  
		  
		  @Query(value="SELECT loco_no, loco_new_shed, loco_new_zone, loco_old_shed, loco_old_zone, loco_traction_code, loco_transfer_letter_no, loco_transfer_date, "
		  		+ "remarks, transfer_by, data_entry_date, status, reject_remarks, reject_user_id, reject_txn_time, accept_remarks, accept_user_id, accept_txn_time,loco_table_name,loco_new_division ,count_no_of_update\r\n"
			  		+ "	FROM mdms_loco.loco_transfer_detail WHERE status=?1 and loco_new_shed=?2",nativeQuery=true)
			 List<LocoTransferModel> getLocoDataStatusNewShedWise(String status,String loco_new_shed);
		  
//		  @Query(value="select exists(select 1,status from mdms_loco.loco_transfer_detail where loco_no=?1 )",nativeQuery=true)
		  @Query(value="select * FROM mdms_loco.loco_transfer_detail where loco_no=?1",nativeQuery=true)
		  public List<LocoTransferModel> checkLocoExitOrNot(int loco_no);
		  
		 
		 // Developer : Jyoti dt.21.9.22  
		  @Query(value="select * FROM mdms_loco.loco_transfer_detail where transfer_by=?1  AND status in ('RS','RR')",nativeQuery=true)
		  List<LocoTransferModel> getTransferLocoRepo(String transfer_by);
		  
		// query for updating loco status -- **Gaurav Agarwal**281122**
			@Transactional
			@Modifying
			@Query(value="update mdms_loco.loco_transfer_detail set loco_table_name=?1 where loco_no=?2",nativeQuery=true)
			void updateLocoStatus(String tbal, int oLocoNo);
		  
			//query for updating draft Loco Status -- **Ritu**281222**
						@Transactional
						@Modifying
						@Query(value="UPDATE mdms_loco.loco_transfer_detail	SET loco_new_shed=?1, loco_new_zone=?2, loco_transfer_letter_no=?3, loco_transfer_date=?4, transfer_by=?5, data_entry_date=?6, "
								+ "status=?7, loco_new_division=?8,count_no_of_update=?9, reject_remarks=?10 WHERE loco_no=?11",nativeQuery=true)
									int updateLocoDraft(String newshed, String newzone, String trfletter,Date loco_transfer_date,String userid,  Date entrydt, String status, String newdivision, int countno, String rejectremarks, int locono );
						
						//query for updating re-transfer Loco Status -- **Ritu**150123**
						@Transactional
						@Modifying
						@Query(value="UPDATE mdms_loco.loco_transfer_detail\r\n"
								+ "	SET loco_new_shed=?1, loco_new_zone=?2, loco_old_shed=?3, loco_old_zone=?4, \r\n"
								+ "	 loco_transfer_letter_no=?5, loco_transfer_date=?6, remarks=?7, transfer_by=?8,\r\n"
								+ "	data_entry_date=?9, status=?10, loco_new_division=?11, count_no_of_update=?12 WHERE loco_no=?13",nativeQuery=true)
									int updateRetransferLoco(String newshed, String newzone, String oldshed , String oldzone, String trfletter,Date loco_transfer_date,String remarks, String userid,  Date entrydt, 
											String status, String newdivision, int countno, int locono);
						
						
}
