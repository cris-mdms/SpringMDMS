package com.mdms.feedback.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.mdms.feedback.model.FeedbackSnapshortModel;

public interface FeedbackSnapshortRepository extends CrudRepository<FeedbackSnapshortModel,Long> {
	@Modifying
	@Transactional
	@Query(value="INSERT INTO mdms_feedback.feedback_snapshort_master(\r\n" + 
			"			request_id, docname)\r\n" + 
			"			VALUES (?1, ?2)", nativeQuery = true)	
	int savesnapshorttype( String requestid, String filename);
	
	@Query(value ="SELECT docname FROM  mdms_feedback.feedback_snapshort_master where request_id=?1",nativeQuery=true)
	String getfilename(String requestid);
}
