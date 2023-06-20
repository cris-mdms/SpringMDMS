package com.mdms.mdms_coach.coachuncleansed.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.mdms_coach.coachuncleansed.model.CoachDataCMM;
import com.mdms.mdms_coach.coachuncleansed.model.MDepo;

public interface MDepoRepository extends CrudRepository <MDepo,Long>{
	
	@Query(value="select * FROM mdms_coach.m_depo where zone_code=?1 AND div_code=?2", nativeQuery = true)
	List<MDepo> findByZoneCode(String zonecode, String divcode);
	
	@Query(value="select * FROM mdms_coach.m_depo", nativeQuery = true)
	List<MDepo> findMDepo();


}
