package com.mdms.mdms_coach.coachuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.mdms_coach.coachuncleansed.model.MCouplingType;


public interface MCuplingTypeRepo extends CrudRepository<MCouplingType,String> {
	
	@Query(value="select * from mdms_coach.m_coupling_type ",nativeQuery = true)
	List<MCouplingType> getMCouplingType();

	

}
