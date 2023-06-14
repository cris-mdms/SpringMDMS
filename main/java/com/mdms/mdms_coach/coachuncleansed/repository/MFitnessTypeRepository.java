package com.mdms.mdms_coach.coachuncleansed.repository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.mdms.mdms_coach.coachuncleansed.model.MFitnessType;

public interface MFitnessTypeRepository extends CrudRepository<MFitnessType,String>{
	
	@Query(value="Select * from mdms_coach.m_fitness_type ", nativeQuery = true)
	List<MFitnessType> getAllFitnessType();

}
