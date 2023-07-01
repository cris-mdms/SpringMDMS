package com.mdms.mdms_station.stationuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.mdms_station.stationuncleansed.model.MInterlockingStandard;

public interface MInterlockingStandardRepository extends CrudRepository<MInterlockingStandard,String> {



	@Query(value="Select * from mdms_station.m_interlocking_standard", nativeQuery = true)
	List<MInterlockingStandard> getInterLock();
	

	//@Query(value="Select * from mdms_station.m_interlocking_standard where standard_code=?1", nativeQuery = true)


	@Query(value="Select description from mdms_station.m_interlocking_standard where standard_code='1'", nativeQuery = true)
	String getInterLockDescription(String standard_code);

//	@Query(value="Select * from mdms_station.m_interlocking_standard where standard_code=?1", nativeQuery = true)


	
}
