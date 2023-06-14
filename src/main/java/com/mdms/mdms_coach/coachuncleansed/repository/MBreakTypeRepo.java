package com.mdms.mdms_coach.coachuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.mdms_coach.coachuncleansed.model.MBreakType;

public interface MBreakTypeRepo extends CrudRepository<MBreakType,String> {
	
	@Query(value="select * from mdms_coach.m_brake_type ",nativeQuery = true)
	List<MBreakType> getMbreakType();

}
