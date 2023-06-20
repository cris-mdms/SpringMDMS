package com.mdms.mdms_coach.coachuncleansed.repository;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.mdms.mdms_coach.coachuncleansed.model.MCoachType;

public interface MCoachTypeRepository  extends CrudRepository<MCoachType,String>{
@Query(value="select * from mdms_coach.m_coach_type_cmm where coach_type=?1",nativeQuery = true)
	MCoachType getCoachTypeDetails(String coachtype);

@Query(value="select coach_type from mdms_coach.m_coach_type_cmm ",nativeQuery = true)
List<String> getCoachTypes();


// query updated by JYOTI BISHT 10-4-23
//@Query(value="select coach_type from mdms_coach.m_coach_type_cmm except select cmm_coach_type from mdms_coach.coach_type_mapping ",nativeQuery = true)
@Query(value="select coach_type from mdms_coach.m_coach_type_cmm",nativeQuery = true)
List<String> getCoachTypesCmm();

@Query(value="select coach_type from mdms_coach.m_coach_type_cmm except select cmmcoachtype from mdms_coach.cmm_type_layout ",nativeQuery = true)
List<String> getCoachTypesCmmLayout();


@Query(value="select depo_code from mdms_coach.m_depo ",nativeQuery = true)
List<String> getCoachDepots();

@Query(value="select coach_category from mdms_coach.m_coach_category ",nativeQuery = true)
List<String> getCoachCategory();

@Query(value="select coupling_type from mdms_coach.m_coupling_type ",nativeQuery = true)
List<String> getCoachCouplingType();


@Query(value="select fitness_type from mdms_coach.m_fitness_type ",nativeQuery = true)
List<String> getCoachFitnessType();

@Query(value="select power_generation_type from mdms_coach.m_power_gen_type ",nativeQuery = true)
List<String> getPowerGenType();

@Query(value="select brake_type from mdms_coach.m_brake_type ",nativeQuery = true)
List<String> getBrakeType();

@Query(value="select * from mdms_coach.m_coach_type_cmm ",nativeQuery = true)
List<MCoachType> getMCoachTypeCmm();


@Query(value="select * from mdms_coach.m_coach_type_cmm where reserved_flag ='Y' order by coach_type ",nativeQuery = true)
List<MCoachType> getMCoachTypeCmmReservedCoach();


}
 
