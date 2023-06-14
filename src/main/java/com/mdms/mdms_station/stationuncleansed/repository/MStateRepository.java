package com.mdms.mdms_station.stationuncleansed.repository;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.mdms.mdms_station.stationuncleansed.model.MState;

public interface MStateRepository extends CrudRepository<MState,Long> {

	@Query(value="Select * FROM mdms_masters.m_state",nativeQuery = true)
	List<MState> getLgdState();
	
	@Query(value="Select state_name FROM mdms_masters.m_state where state_code =?1",nativeQuery = true)
	String getLgdStateName(int state_code);
}
