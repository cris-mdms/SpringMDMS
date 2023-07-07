package com.mdms.loco.locouncleansed.repository;


import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.loco.locouncleansed.model.LocoApprovedRecords;

public interface LocoApprovedRecordsRepository extends CrudRepository<LocoApprovedRecords,Long>{
	
	
	//Anshul 22-06-2023 To save records in golden master table
		@Query(value="INSERT INTO mdms_loco.loco_approved_data(\r\n"
			+ "	loco_traction_code,loco_no, loco_type,loco_permanent_domain,loco_service "
			+ "	loco_owning_shed,loco_owning_zone, loco_owning_division, loco_manufacturing_date,loco_receiving_date,loco_initial_cost,loco_poh_cost,loco_lease_type,loco_gauge_type,"
			+ "loco_hauling_power,loco_manufacturing_country,"
			+ "	loco_cabin_ac,loco_commissioning_date,loco_hotel_load,loco_manufacturer,is_gps_enabled,flag_type,\r\n"
			+ "	loco_auxilary,loco_boogie_type,loco_traction_motor_type,loco_control_type,loco_brake_type,user_id,status,record_status,txn_date) \r\n"
			+ "	VALUES (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12,?13,?14,?15,?16,?17,?18,?19,?20,?21,?22,?23,?24,?25,?26,?27,?28,?29,?30)",nativeQuery=true)
	int saveApprovedRecords(String loco_traction_code,long loco_no, String loco_type,String loco_permanent_domain, String locoservice,
			String loco_owning_shed,String loco_owning_zone, String loco_owning_division,Date loco_manufacturing_date,Date loco_receiving_date,long loco_initial_cost,
			long loco_poh_cost,String loco_lease_type,String loco_gauge_type,Long loco_hauling_power,String loco_manufacturing_country,
			String loco_cabin_ac,Date loco_commissioning_date,String loco_hotel_load,String loco_manufacturer,String is_gps_enabled,String flag_type,
			String loco_auxilary,String loco_boogie_type,String loco_traction_motor_type, String loco_control_type,String loco_brake_type,
			String user_id,String status,String record_status,Date date);

}
