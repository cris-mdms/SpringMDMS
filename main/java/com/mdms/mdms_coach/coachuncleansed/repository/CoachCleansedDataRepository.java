package com.mdms.mdms_coach.coachuncleansed.repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.dahsboard.model.DashBoardCoachCountDepoWiseModel;
import com.mdms.dahsboard.model.DashBoardLocoCountShedWiseModel;
import com.mdms.mdms_coach.coachuncleansed.model.CoachCleansedData;
import com.mdms.mdms_coach.coachuncleansed.model.CoachUncleansedData;

public interface CoachCleansedDataRepository  extends CrudRepository<CoachCleansedData,Long>{
	
	@Query(value="SELECT * FROM mdms_coach.coach_uncleansed_data WHERE coach_id=?1",nativeQuery = true)
	CoachCleansedData getCleanCoachRecord(Long coachid);

	@Transactional
	@Modifying
	@Query(value="INSERT INTO mdms_coach.coach_cleansed_data(\r\n" + 
			"	coach_no, coach_id, coach_type, owning_rly, coach_owning_div,"
			+ " fitness_type, brake_type, tare_weight, max_speed,coach_age,"
			+ " manufacturer, is_biotoilet_fitted, built_date, commissioning_date, "
			+ "maintenance_depot, no_of_berths, rfid_tag, "
			+ "coach_status, gauge, coupling_type, owning_depot, ac_flag ,\r\n" + 
			"	vehicle_type, power_generation_type, factory_turnout_date, "
			+ "coach_received_date, double_decker_flag,	coach_capacity, coach_vestibule,"+
			"underframe_no, shell_no, pu_order_id, coach_type_description, "
			+"record_status,status, user_id, txn_date, remarks , coach_category)\r\n" + 
			"	VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12, ?13, ?14, ?15, ?16, ?17, ?18, ?19, ?20, ?21, ?22, ?23, ?24, ?25, ?26, ?27, ?28, ?29, ?30, ?31, ?32, ?33, ?34, ?35, ?36, \r\n" + 
			"			?37, ?38 ,?39)",nativeQuery = true)
	void saveCleanRecord(String coach_no, Long coach_id, String coach_type, String owning_rly, String coach_owning_div,
			String fitness_type, String brake_type, float tare_weight, float max_speed, int coach_age,
			String manufacturer, String is_biotoilet_fitted, Date built_date, Date commissioning_date,
			String maintenance_depot, int no_of_berths, String rfid_tag,
			String coach_status, String gauge, String coupling_type, String owning_depot, String ac_flag,
			String vehicle_type, String power_generation_type, Date factory_turnout_date,
			Date coach_received_date, Boolean double_decker_flag, int coach_capacity, String coach_vestibule,
			String underframe_no, String shell_no, String pu_order_id, String coach_type_description,
			String record_status, String status, String user_id, Date txn_date, String remarks,String coach_catgory);

	
	//Shilpi 15-03-2021
	
	@Query(value="SELECT owning_depot,count(*) as cleansed_count FROM mdms_coach.coach_cleansed_data where owning_depot=?1 group by 1",nativeQuery=true)
	Collection<DashBoardCoachCountDepoWiseModel> getCoachApprovedSingleDepo(String owning_depot);
	
	//Shilpi 16-04-2021 hyper depot
	
		@Query(value="SELECT * FROM mdms_coach.coach_cleansed_data where owning_depot=?1",nativeQuery=true)
		List<CoachCleansedData> getCoachApprovedHyperDepo(String owning_depot);
		
		//Shilpi 19-04-2021
		
		@Query(value="SELECT owning_depot,count(*) as cleansed_count FROM mdms_coach.coach_cleansed_data where owning_rly=?1 group by 1",nativeQuery=true)
		Collection<DashBoardCoachCountDepoWiseModel> getCoachApprovedZonalDepo(String owning_rly);
		
		// JYOTI BISHT 17-10-22
		
		  @Query(value="select count(*) from mdms_coach.coach_cleansed_data  where status='A' and txn_date between ?1 and ?2",nativeQuery = true)
	      int getCoachApproved(Date from, Date to);
		  
        // JYOTI BISHT 13-1-23
		  
		  @Query(value="select * from mdms_coach.coach_cleansed_data where owning_rly=?1 and coach_owning_div=?2 and status=?3",nativeQuery = true)
		  List<CoachCleansedData>  getCoachDetails(String zone, String division, String status);


}
