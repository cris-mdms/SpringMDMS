package com.mdms.mdms_coach.coachuncleansed.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import com.mdms.mdms_coach.coachuncleansed.model.PRSTypeLayout;

public interface PRSTypeLayoutRepository extends CrudRepository<PRSTypeLayout,String>{
	
	
	@Modifying
	@Transactional
	@Query(value="INSERT INTO mdms_coach.prs_type_layout(\r\n" + 
			"			coach_code, capacity, coachtypedescription, remarks, user_id, filename, status)\r\n" + 
			"			VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7)", nativeQuery = true)
	int saveprstype(String coachtype, String capacity, String description, String remarks, String sender,
			String fileName, String string);
	
	
@Query(value="select * from  mdms_coach.prs_type_layout where status='U'", nativeQuery = true)
	List<PRSTypeLayout>getUnappPRSLayout( );

@Query(value="select * from  mdms_coach.prs_type_layout where status='A'", nativeQuery = true)
List<PRSTypeLayout>getAppPRSLayout( );

@Modifying
@Transactional
@Query(value="update  mdms_coach.prs_type_layout set status='A' where coach_code=?1 ", nativeQuery = true)
int approvePrsCoachLayout(String cmmcoachtype);



}
