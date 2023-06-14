package com.mdms.mdms_coach.coachuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.loco.locouncleansed.model.MLocoType;
import com.mdms.mdms_coach.coachuncleansed.model.MCoachTypePrs;

public interface MCoachTypePrsRepository extends CrudRepository<MCoachTypePrs,String>{
	@Query(value="select coach_code from mdms_coach.m_coach_type_prs except select prs_coach_type from mdms_coach.coach_type_mapping ",nativeQuery = true)
	List<String> getCoachTypesPrs();
	
	
		
	@Query(value="SELECT * FROM mdms_coach.m_coach_type_prs WHERE coach_code=?1",nativeQuery=true)
   	List<MCoachTypePrs> getCoachTypesPrsData(String coachtype);	
	
	@Query(value="select coach_code from mdms_coach.m_coach_type_prs except select coach_code from mdms_coach.prs_type_layout",nativeQuery = true)
	List<String> getCoachTypesPrsLayout();
	
	@Query(value="select * from mdms_coach.m_coach_type_prs ",nativeQuery = true)
	List<MCoachTypePrs> getMCoachTypesPrs();
	

}
