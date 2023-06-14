package com.mdms.mdms_masters.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.mdms_masters.model.MDesignation;
public interface MDesignationRepository extends CrudRepository<MDesignation,Long> {
	@Query(value="SELECT designation_name FROM mdms_masters.m_designation WHERE designation_name=?1 AND station_user='Y'", nativeQuery = true)
	String findStnDesignation(String stndesig);

	@Query(value="SELECT designation_name FROM mdms_masters.m_designation WHERE designation_name=?1 AND loco_user='Y'", nativeQuery = true)
	String findLocoDesignation(String locodesig); 

	@Query(value="SELECT designation_name FROM mdms_masters.m_designation WHERE designation_name=?1 AND coach_user='Y'", nativeQuery = true)
	String findcoachDesignation(String coachdesig); 

}
