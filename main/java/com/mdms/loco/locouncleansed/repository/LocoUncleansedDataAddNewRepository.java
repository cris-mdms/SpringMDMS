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
	List<LocoUncleansedDataAddNewLoco> findlocoDetailBasedOnLocoNo(Integer loco_no);
	
	@Query(value="SELECT * FROM  mdms_loco.loco_uncleansed_data WHERE record_status='N' and (status='ZD' OR status='R')",nativeQuery=true)
	List<LocoUncleansedDataAddNewLoco> findlocoDetailforZonalDraft();
	
	@Transactional
	@Modifying
	@Query(value="\r\n" + 
			"	UPDATE mdms_loco.loco_uncleansed_data SET  loco_auxilary=?1,loco_boogie_type=?2, loco_brake_sub_type=?3, loco_brake_type=?4,\r\n" + 
			"	loco_cabin_ac=?5, flag_type=?6,loco_control_type=?7,loco_traction_motor_type=?8,loco_commissioning_date=?9,loco_entry_date=?10,loco_hotel_load=?11,\r\n" + 
			"	loco_manufacturer=?12,is_gps_enabled=?13,status=?14, user_id=?15, txn_date=?16 WHERE loco_no=?17", nativeQuery=true)
	int updateWithElectricNewLocoShedData(String locoAuxiliaryOutput, String locoBoogieType, String locoBrakeSubtype,
			String locoBrakeType, String locoCabac, String gpsflagtype,  String locoControlType,String tmtype,
			Date locoDateOfCommision, Date locoEntryDate, String locoHotelLoad,String locoManfacturer,String isGPSEnabled,
			String status,String userid,Date txndate,int locono);
	
	
	@Transactional
	@Modifying
	@Query(value="\r\n" + 
			"	UPDATE mdms_loco.loco_uncleansed_data SET loco_control_type=?1,loco_brake_sub_type=?2, loco_brake_type=?3, loco_commissioning_date=?4,loco_entry_date=?5,\r\n" + 
			"	loco_manufacturer=?6,is_gps_enabled=?7,flag_type=?8,loco_traction_motor_type=?9,loco_axle_load=?10, status=?11, user_id=?12, txn_date=?13 WHERE loco_no=?14", nativeQuery=true)
	void updateWithDieselNewLocoShedData( 
			String locoControlType, String brakesubtype, String braketype, Date locoDateOfCommision, Date locoEntryDate, String locoManfacturer,
			String isGpsEnabled, String flagtype, String locoTractionMotorType, String locoAxleLoad,String status,String userid,Date txndate,int locono);


}
