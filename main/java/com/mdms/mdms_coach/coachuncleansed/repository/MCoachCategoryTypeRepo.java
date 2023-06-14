package com.mdms.mdms_coach.coachuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.mdms_coach.coachuncleansed.model.MCoachCategoryType;

public interface MCoachCategoryTypeRepo extends CrudRepository<MCoachCategoryType,String>{
	
	@Query(value="select * from mdms_coach.m_coach_category ",nativeQuery = true)
	List<MCoachCategoryType> getMCoachCategoryType();

}
