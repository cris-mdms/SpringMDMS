package com.mdms.feedback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import com.mdms.feedback.model.FeedbackModel;
public interface FeedbackRepository extends CrudRepository<FeedbackModel,Long>{
	
	@Query(value ="SELECT *	FROM mdms_feedback.feedback_master  WHERE \"sender_id\" =?1",nativeQuery=true)
	List<FeedbackModel> findAll(String senderid);
	 @Transactional
	@Query(value ="SELECT *	FROM mdms_feedback.feedback_master  WHERE \"asset_owner_id\" =?1",nativeQuery=true)
	List<FeedbackModel> findOwnerFeedback(String assetownerid);
	
	@Query(value ="SELECT *	FROM mdms_feedback.feedback_master",nativeQuery=true)
	List<FeedbackModel> superuserfeedback();
	
	@Transactional
	@Modifying
	@Query(value="UPDATE   mdms_feedback.feedback_master SET status=?1 WHERE request_id=?2", nativeQuery=true)
	int updatestatus(String status, Long rid);
	
	 @Transactional
	@Query(value ="SELECT MAX(request_id) FROM mdms_feedback.feedback_master",nativeQuery=true)
	int getrequestid();
	 
	@Modifying
	@Transactional
	@Query
	(value ="INSERT INTO mdms_feedback.feedback_master(request_title,  asset_module, status, sender_id, sender_name, "
	 		+ "sender_designation,   asset_owner_id, asset_type, request_reply_id, request_reply_comment,reply_to)"
	          +" VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7,?8,?9,?10,?11)",nativeQuery = true)
	int insertReplyByAdmin(String requesttitle, String assetmodule, String requeststatus, String senderid, String sendername, String senderdegis, String assetownerid, String assettype,
			int replyid, String replycomment,String receiverID);
	 
	    @Transactional
		@Query(value ="SELECT * FROM mdms_feedback.feedback_master WHERE \"reply_to\" =?1",nativeQuery=true)
		List<FeedbackModel> getreplybyadmin(String receiverid);

		
		 @Transactional
			@Query(value ="SELECT COUNT(*) FROM mdms_feedback.feedback_master WHERE request_reply_id=?1",nativeQuery=true)
			int getcountreply(int replyid);
	
}
