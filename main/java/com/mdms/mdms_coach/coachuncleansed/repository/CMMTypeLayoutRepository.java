package com.mdms.mdms_coach.coachuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.mdms.mdms_coach.coachuncleansed.model.CMMTypeLayout;

public interface CMMTypeLayoutRepository extends CrudRepository<CMMTypeLayout,String> {

	@Modifying
	@Transactional
	@Query(value="INSERT INTO mdms_coach.cmm_type_layout(\r\n" + 
			"			cmmcoachtype, capacity, coachtypedescription, remarks, user_id, filename, status)\r\n" + 
			"			VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7)", nativeQuery = true)
	int savecmmtype(String coachtype, String capacity, String description, String remarks, String sender,
			String fileName, String string);
	
	
@Query(value="select * from  mdms_coach.cmm_type_layout where status='U'", nativeQuery = true)
	List<CMMTypeLayout>getUnappCMMLayout( );

@Query(value="select * from  mdms_coach.cmm_type_layout where status='A'", nativeQuery = true)
List<CMMTypeLayout>getAppCMMLayout( );

@Modifying
@Transactional
@Query(value="update  mdms_coach.cmm_type_layout set status='A' where cmmcoachtype=?1 ", nativeQuery = true)
int approveCmmCoachLayout(String cmmcoachtype);

}
