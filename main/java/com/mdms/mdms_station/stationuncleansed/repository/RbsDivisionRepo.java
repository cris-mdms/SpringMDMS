package com.mdms.mdms_station.stationuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.mdms_station.stationuncleansed.model.rbs_division;

public interface RbsDivisionRepo extends CrudRepository<rbs_division,Long>{
	
	@Query(value="SELECT distinct zone_code FROM mdms_station.rbs_division",nativeQuery=true)
	List<String> getrbszone();
	
	@Query(value="SELECT * FROM mdms_station.rbs_division where zone_code=?1",nativeQuery=true)
	List<rbs_division> getrbsdivision(String zc);
}
