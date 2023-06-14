package com.mdms.mdms_coach.coachuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.mdms_coach.coachuncleansed.model.MCoachStatus;


public interface MCoachStatusRepo extends CrudRepository<MCoachStatus,String> {
	
	@Query(value="select * from mdms_coach.m_coach_status ",nativeQuery = true)
	List<MCoachStatus> getMCoachStatusType();

}
