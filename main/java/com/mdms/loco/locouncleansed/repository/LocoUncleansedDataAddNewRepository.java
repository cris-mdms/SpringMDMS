package com.mdms.loco.locouncleansed.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.loco.locouncleansed.model.LocoUncleansedDataAddNewLoco;

import com.mdms.loco.locouncleansed.model.LocoUncleansedDataElectric;


public interface LocoUncleansedDataAddNewRepository extends CrudRepository<LocoUncleansedDataAddNewLoco, Long> {

	@Query(value="SELECT loco_flag, loco_no, loco_type, loco_permanent_domain, loco_owning_shed, loco_owning_zone, loco_traction_code, loco_owning_division, loco_manufacturing_date, loco_receiving_date,\r\n" + 
			"loco_initial_cost, loco_poh_cost, loco_lease_type, loco_gauge_type, loco_hauling_power, loco_manufacturing_country, record_status, status, user_id,  txn_date, remarks, loco_entry_date, flag_type, loco_commissioning_date, loco_commissioned_shed_id, loco_axle_load, loco_axle_load_unit, loco_traction_motor_type, loco_boogie_type, loco_control_type, is_gps_enabled, loco_manufacturer,loco_hotel_load,loco_auxilary,loco_brake_type,loco_brake_sub_type,loco_cabin_ac FROM  mdms_loco.loco_uncleansed_data WHERE  status='ZU' AND record_status='N'",nativeQuery=true)
	List<LocoUncleansedDataAddNewLoco> getUnapprovedZonalBoardLoco();




//	@Query(value="SELECT loco_flag, loco_no, loco_type, loco_permanent_domain, loco_owning_shed, loco_owning_zone, loco_traction_code, loco_owning_division, loco_manufacturing_date, loco_receiving_date,\r\n" + 
//			"loco_initial_cost,loco_hotel_load, loco_poh_cost, loco_lease_type, loco_gauge_type, loco_hauling_power, loco_manufacturing_country, flag_type, loco_commissioning_date, loco_commissioned_shed_id FROM  mdms_loco.loco_uncleansed_data WHERE loco_owning_zone=?1 AND status='V' AND record_status='N'",nativeQuery=true)
//	List<String> getApprovedZonalBoardLoco(String locozone);
	
	@Query(value="SELECT  * FROM  mdms_loco.loco_uncleansed_data WHERE loco_owning_zone=?1 AND status='V' AND record_status='N'",nativeQuery=true)
	List<LocoUncleansedDataAddNewLoco> getApprovedZonalBoardLoco(String locozone);
	
	@Query(value="SELECT  * FROM  mdms_loco.loco_uncleansed_data WHERE  status='V' AND record_status='N'",nativeQuery=true)
	List<LocoUncleansedDataAddNewLoco> getTotalRBVerifiedNewLoco();
	
	@Query(value="SELECT * FROM  mdms_loco.loco_uncleansed_data WHERE loco_no=?1",nativeQuery=true)
	List<LocoUncleansedDataAddNewLoco> findlocoDetailBasedOnLocoNo(Long loco_no);
	
	@Query(value="SELECT * FROM  mdms_loco.loco_uncleansed_data WHERE record_status='N' and (status='ZD' OR status='R')",nativeQuery=true)
	List<LocoUncleansedDataAddNewLoco> findlocoDetailforZonalDraft();
	
	
	//Anshul 19-06-2023
	@Query(value="SELECT * FROM  mdms_loco.loco_uncleansed_data WHERE record_status='N' and status='D' and loco_owning_shed=?1",nativeQuery=true)
	List<LocoUncleansedDataAddNewLoco> findDraftNewLoco(String shed);
	
	@Transactional
	@Modifying
	@Query(value="\r\n" + 
			"	UPDATE mdms_loco.loco_uncleansed_data SET  loco_auxilary=?1,loco_boogie_type=?2, loco_brake_sub_type=?3, loco_brake_type=?4,\r\n" + 
			"	loco_cabin_ac=?5, flag_type=?6,loco_control_type=?7,loco_traction_motor_type=?8,loco_commissioning_date=?9,loco_entry_date=?10,loco_hotel_load=?11,\r\n" + 
			"	loco_manufacturer=?12,is_gps_enabled=?13,status=?14, user_id=?15, txn_date=?16 WHERE loco_no=?17", nativeQuery=true)
	int updateWithElectricNewLocoShedData(String locoAuxiliaryOutput, String locoBoogieType, String locoBrakeSubtype,
			String locoBrakeType, String locoCabac, String gpsflagtype,  String locoControlType,String tmtype,
			Date locoDateOfCommision, Date locoEntryDate, String locoHotelLoad,String locoManfacturer,String isGPSEnabled,
			String status,String userid,Date txndate,long locono);
	
	
	@Transactional
	@Modifying
	@Query(value="\r\n" + 
			"	UPDATE mdms_loco.loco_uncleansed_data SET loco_control_type=?1,loco_brake_sub_type=?2, loco_brake_type=?3, loco_commissioning_date=?4,loco_entry_date=?5,\r\n" + 
			"	loco_manufacturer=?6,is_gps_enabled=?7,flag_type=?8,loco_traction_motor_type=?9,loco_axle_load=?10, status=?11, user_id=?12, txn_date=?13 WHERE loco_no=?14", nativeQuery=true)
	void updateWithDieselNewLocoShedData( 
			String locoControlType, String brakesubtype, String braketype, Date locoDateOfCommision, Date locoEntryDate, String locoManfacturer,
			String isGpsEnabled, String flagtype, String locoTractionMotorType, String locoAxleLoad,String status,String userid,Date txndate,long locono);

	//Anshul 17-06-2023
		//To save draft of new loco 
		@Transactional
		@Modifying
		@Query(value="INSERT INTO mdms_loco.loco_uncleansed_data(\r\n"
				+ "	loco_traction_code,loco_no, loco_type,loco_permanent_domain, "
				+ "	loco_owning_shed,loco_owning_zone, loco_owning_division, loco_manufacturing_date,loco_receiving_date,loco_initial_cost,loco_poh_cost,loco_lease_type,loco_gauge_type,"
				+ "loco_hauling_power,loco_manufacturing_country,"
				+ "	loco_cabin_ac,loco_commissioning_date,loco_hotel_load,loco_manufacturer,is_gps_enabled,flag_type,\r\n"
				+ "	loco_auxilary,loco_boogie_type,loco_traction_motor_type,loco_control_type,loco_brake_type,user_id,status,record_status) \r\n"
				+ "	VALUES (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12,?13,?14,?15,?16,?17,?18,?19,?20,?21,?22,?23,?24,?25,?26,?27,?28,?29)",nativeQuery=true)
		int saveDraftNewLoco(String loco_traction_code,long loco_no, String loco_type,String loco_permanent_domain, 
				String loco_owning_shed,String loco_owning_zone, String loco_owning_division,Date loco_manufacturing_date,Date loco_receiving_date,long loco_initial_cost,
				long loco_poh_cost,String loco_lease_type,String loco_gauge_type,Long loco_hauling_power,String loco_manufacturing_country,
				String loco_cabin_ac,Date loco_commissioning_date,String loco_hotel_load,String loco_manufacturer,String is_gps_enabled,String flag_type,
				String loco_auxilary,String loco_boogie_type,String loco_traction_motor_type, String loco_control_type,String loco_brake_type,
				String user_id,String status,String record_status);
		
		
		//Anshul 17-06-2023
				//To Update draft of new loco 
				@Transactional
				@Modifying
				@Query(value="UPDATE mdms_loco.loco_uncleansed_data	SET loco_traction_code=?1, loco_type=?3,loco_permanent_domain=?4,\r\n"
				+ "	loco_owning_shed=?5,loco_owning_zone=?6,  loco_owning_division=?7, loco_manufacturing_date=?8,loco_receiving_date=?9,\r\n"
				+ "	loco_initial_cost=?10,loco_poh_cost=?11,loco_lease_type=?12,loco_gauge_type=?13,loco_hauling_power=?14,\r\n"
				+ "	loco_manufacturing_country=?15,loco_cabin_ac=?16,loco_commissioning_date=?17,loco_hotel_load=?18,loco_manufacturer=?19,\r\n"
				+ "	is_gps_enabled=?20,flag_type=?21,loco_auxilary=?22,loco_boogie_type=?23,loco_traction_motor_type=?24,loco_control_type=?25,\r\n"
				+ "	loco_brake_type=?26\r\n"
				+ "	WHERE loco_no=?2 and user_id=?27",nativeQuery=true)
int updateDraftNewLoco(String loco_traction_code,long loco_no, String loco_type,String loco_permanent_domain, 
		String loco_owning_shed,String loco_owning_zone, String loco_owning_division,Date loco_manufacturing_date,Date loco_receiving_date,long loco_initial_cost,
		long loco_poh_cost,String loco_lease_type,String loco_gauge_type,Long loco_hauling_power,String loco_manufacturing_country,
		String loco_cabin_ac,Date  loco_commissioning_date,String loco_hotel_load,String loco_manufacturer,String is_gps_enabled,String flag_type,
		String loco_auxilary,String loco_boogie_type,String loco_traction_motor_type, String loco_control_type,String loco_brake_type,String user_id);
				
				
				//Anshul 17-06-2023
				//To Update Forward for Approval of new loco 
				@Transactional
				@Modifying
				@Query(value="UPDATE mdms_loco.loco_uncleansed_data	SET loco_traction_code=?1, loco_type=?3,loco_permanent_domain=?4,\r\n"
				+ "	loco_owning_shed=?5,loco_owning_zone=?6,  loco_owning_division=?7, loco_manufacturing_date=?8,loco_receiving_date=?9,\r\n"
				+ "	loco_initial_cost=?10,loco_poh_cost=?11,loco_lease_type=?12,loco_gauge_type=?13,loco_hauling_power=?14,\r\n"
				+ "	loco_manufacturing_country=?15,loco_cabin_ac=?16,loco_commissioning_date=?17,loco_hotel_load=?18,loco_manufacturer=?19,\r\n"
				+ "	is_gps_enabled=?20,flag_type=?21,loco_auxilary=?22,loco_boogie_type=?23,loco_traction_motor_type=?24,loco_control_type=?25,\r\n"
				+ "	loco_brake_type=?26 , status='U', record_status='N' \r\n"
				+ "	WHERE loco_no=?2 and user_id=?27",nativeQuery=true)
int updateFwdApp(String loco_traction_code,long loco_no, String loco_type,String loco_permanent_domain, 
		String loco_owning_shed,String loco_owning_zone, String loco_owning_division,Date loco_manufacturing_date,Date loco_receiving_date,long loco_initial_cost,
		long loco_poh_cost,String loco_lease_type,String loco_gauge_type,Long loco_hauling_power,String loco_manufacturing_country,
		String loco_cabin_ac,Date  loco_commissioning_date,String loco_hotel_load,String loco_manufacturer,String is_gps_enabled,String flag_type,
		String loco_auxilary,String loco_boogie_type,String loco_traction_motor_type, String loco_control_type,String loco_brake_type,String user_id);







}
