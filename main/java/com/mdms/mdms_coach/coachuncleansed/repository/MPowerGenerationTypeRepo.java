package com.mdms.mdms_coach.coachuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.mdms_coach.coachuncleansed.model.MPowerGenerationType;

public interface MPowerGenerationTypeRepo extends CrudRepository<MPowerGenerationType,String>{
	
	@Query(value="select * FROM mdms_coach.m_power_gen_type", nativeQuery = true)
	List<MPowerGenerationType> findMPowerGenerationType();

}
