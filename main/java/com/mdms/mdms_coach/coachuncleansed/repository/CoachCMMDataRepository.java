package com.mdms.mdms_coach.coachuncleansed.repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.dahsboard.model.DashBoardCoachCountDepoWiseModel;
import com.mdms.dahsboard.model.DashBoardLocoCountShedWiseModel;
import com.mdms.mdms_coach.coachuncleansed.model.CoachDataCMM;

public interface CoachCMMDataRepository extends CrudRepository<CoachDataCMM, String> {	

	@Query(value="Select * from mdms_coach.coach_data_cmm where coach_id=?1", nativeQuery = true)
	Optional<CoachDataCMM> findByCoachId(String coachId);
	
	//Shilpi 15-03-2021
	
	@Query(value="SELECT base_depot as owning_depot, count(*) as total_depot_count from mdms_coach.coach_data_cmm WHERE base_depot=?1 GROUP BY base_depot",nativeQuery=true)
    Collection<DashBoardCoachCountDepoWiseModel> getCoachSingleDepo(String owning_depot);
       
    @Query(value="SELECT base_depot as owning_depot,COUNT(coach_id) as uncleansed_count FROM (select cast(coach_id as integer),base_depot from mdms_coach.coach_data_cmm EXCEPT SELECT coach_id,owning_depot FROM mdms_coach.coach_cleansed_data ) AS AA where BASE_depot=?1 group by 1",nativeQuery=true)
    Collection<DashBoardCoachCountDepoWiseModel> getUncleansedCoachSingleDepo(String owning_depot);
    
  // Shilpi 16-04-2021  ------hyper link depo wise
    
    @Query(value="SELECT * FROM mdms_coach.coach_data_cmm where cast(coach_id as integer) in (select cast(coach_id as integer) from mdms_coach.coach_data_cmm EXCEPT  SELECT coach_id FROM mdms_coach.coach_cleansed_data )  AND BASE_depot=?1",nativeQuery=true)
    List<CoachDataCMM> getUncleansedCoachHyperDepo(String owning_depot);
    
    // Shilpi 19-04-2021 zone wise depot

    @Query(value="SELECT base_depot as owning_depot,owning_rly  as owning_rly, count(*) as total_depot_count from mdms_coach.coach_data_cmm WHERE owning_rly=?1 GROUP BY base_depot,owning_rly",nativeQuery=true)
    Collection<DashBoardCoachCountDepoWiseModel> getCoachZoneDepo(String owning_rly);
    
  
    
    @Query(value="SELECT base_depot as owning_depot,COUNT(coach_id) as uncleansed_count FROM    (select owning_rly,cast(coach_id as integer),base_depot from mdms_coach.coach_data_cmm\n"
    		+ "	EXCEPT SELECT owning_rly  ,coach_id,owning_depot FROM mdms_coach.coach_cleansed_data where owning_rly=?1 ) AS AA   where owning_rly=?1 \n"
    		+ "	group by 1 ORDER BY 1",nativeQuery=true)
    Collection<DashBoardCoachCountDepoWiseModel> getUncleansedCoachZoneDepo(String owning_rly);
    
    // JYOTI BISHT 31-10-22
    @Query(value="select count(*) from MDMS_coach.coach_data_cmm where coach_status<>'CONDEMN'", nativeQuery=true)
    int coach_total_count();
    
    // JYOTI BISHT 31-10-22
    @Query(value=" select extract (month from  insert_or_update_date) as mon,insert_or_update,count (DISTINCT coach_id)\n"
    		+ " from mdms_coach.coach_data_cmm\n"
    		+ "where insert_or_update_date>=?1 and  insert_or_update_date<=?2\n"
    		+ " group by 1,2", nativeQuery = true)
    List<Object[]> integration(Date date1, Date date2);
}
