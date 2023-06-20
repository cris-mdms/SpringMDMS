package com.mdms.mdms_coach.coachuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.dahsboard.model.DashBoardCoachCountDepoWiseModel;
import com.mdms.mdms_coach.coachuncleansed.model.CMMTypeLayout;
import com.mdms.mdms_coach.coachuncleansed.model.CoachTypeMapping;
import com.mdms.mdms_coach.coachuncleansed.model.MCoachType;


public interface CoachTypeMappingRepository extends CrudRepository<CoachTypeMapping,Long>{
	//Shilpi 26-04-2021
//	@Query(value="select count(*) as cleansed_count from (SELECT * FROM mdms_coach.coach_type_mapping) as aa",nativeQuery=true)
//	List<DashBoardCoachCountDepoWiseModel> getCoachmapcount();
	
	@Query(value="select count(*) as cleansed_count from (SELECT * FROM mdms_coach.coach_type_mapping) as aa",nativeQuery=true)
	List<DashBoardCoachCountDepoWiseModel> getCoachmapcount();
	//Ritu 26-10-2021
	@Query(value="SELECT * FROM mdms_coach.coach_type_mapping",nativeQuery=true)
	List<CoachTypeMapping> getCoachMapData();
	
	@Query(value="SELECT * FROM mdms_coach.cmm_type_layout",nativeQuery=true)
	List<CMMTypeLayout> getCoachMapLayout();
	

}
