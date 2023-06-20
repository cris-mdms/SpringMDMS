package com.mdms.loco.locouncleansed.repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.dahsboard.model.DashBoardLocoCountShedWiseModel;
import com.mdms.loco.locouncleansed.model.LocoUncleansedData;
import com.mdms.loco.locouncleansed.model.LocoUncleansedDataElectric;



public interface LocoUncleansedDataRepository extends CrudRepository<LocoUncleansedData,Long>{

	
	
	@Query(value="SELECT loco_no FROM  mdms_loco.loco_uncleansed_data WHERE loco_owning_shed=?1 AND  (status='V' OR status='D' OR status='R') AND record_status='N'",nativeQuery=true)
	List<Integer> findlocoNumber(String loco_owning_shed);
	
	
	
	@Transactional
	@Modifying
	@Query(value ="UPDATE mdms_loco.loco_uncleansed_data\r\n" + 
			"	SET loco_type=?1, loco_commissioning_date=?2, loco_owning_shed=?3, loco_manufacturer=?4,loco_receiving_date=?5,"
			+ "loco_axle_load=?6, loco_hauling_power=?7, loco_owning_zone=?8, loco_traction_code=?9, "
			+ "loco_brake_type=?10, loco_control_type=?11, loco_entry_date=?12, loco_permanent_domain=?13, "
			+ "loco_gauge_type=?14, loco_traction_motor_type=?15, is_gps_enabled=?16, loco_lease_type=?17, "
			+ "status=?18, remarks=?19,"
			+ " loco_manufacturing_country=?20,loco_manufacturing_date=?21, flag_type=?22,loco_brake_sub_type=?23 WHERE loco_no=?24",nativeQuery=true)
	int updateDslDraftRecord(String var1,Date var2 ,String var3,String var4, Date var5,double var6,String var7,String var8,String var9,  String var10,String var11,Date var12,String var13,String var14,String var15,String var16,String var17,String var18, String var19 ,String var20, Date var21, String var22,String var23, int locono);	
 
	
	@Query(value="SELECT * FROM  mdms_loco.loco_uncleansed_data WHERE loco_owning_shed=?1 AND status='U'",nativeQuery=true)
	List<LocoUncleansedDataElectric> getUnapprovedLoco(String eshedid);
//	loco_no, loco_type, loco_commissioning_date, loco_owning_zone, loco_owning_shed, loco_owning_division, loco_commissioned_shed_id,
//	loco_manufacturing_country, loco_manufacturing_date, loco_receiving_date, loco_manufacturer, loco_axle_load, loco_axle_load_unit, 
//	loco_traction_motor_type, loco_hauling_power, loco_traction_code, loco_brake_type, loco_brake_sub_type, loco_control_type, 
//	loco_permanent_domain, loco_gauge_type, loco_lease_type, loco_auxilary, loco_boogie_type, loco_cabin_ac, loco_hotel_load, is_gps_enabled,
//	flag_type, loco_initial_cost, loco_poh_cost, loco_last_poh_done, loco_rebuild_date, loco_entry_date, record_status, status, user_id, txn_date,
//	remarks, loco_flag
	
	
	@Transactional
	@Modifying
	@Query(value="INSERT INTO mdms_loco.loco_uncleansed_data(\r\n" + 
			"loco_no, loco_permanent_domain, loco_type,loco_owning_zone, loco_owning_division, loco_manufacturing_date,loco_owning_shed,loco_manufacturer,"
			+ "loco_lease_type, loco_initial_cost, loco_poh_cost, loco_traction_code, loco_gauge_type, loco_hauling_power, loco_manufacturing_country,"
			+ "loco_entry_date, record_status, status, user_id, txn_date,\r\n"
			+ "	remarks, loco_flag, loco_receiving_date)\r\n" + 
			"VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12, ?13, ?14,?15,?16,?17,?18,?19,?20,?21,?22,?23);", nativeQuery=true)
	int saveDieselBoardZonalLocoData(int locoNo, String locoPermanentDomain, String locoType, String locoOwningZone,
			String locoOwningDivision, Date locoMfgDt, String locOwningShed, String locoManufacturer, String locoLeasetype,
			long locoInitialCost, long locoPOHCost, String tractionCode, String gaugeType, Long locoHaulingPower,
			String locoMfgCountry,Date locoEtryDt,String recordstatus,String status,String uid,Date txndate,String remarks,String locoflag, Date locoRecdDate);
	

	@Transactional
	@Modifying
	@Query(value="UPDATE mdms_loco.loco_uncleansed_data\r\n" + 
			"	SET loco_permanent_domain=?1, loco_type=?2,loco_owning_zone=?3, loco_owning_division=?4, loco_manufacturing_date=?5, loco_owning_shed=?6, loco_receiving_date=?7,loco_lease_type=?8,loco_initial_cost=?9,  loco_poh_cost=?10,loco_flag=?11,loco_gauge_type=?12,loco_hauling_power=?13, loco_manufacturing_country=?14 ,record_status=?15 ,status=?16,user_id=?17,txn_date=?18,loco_entry_date=?19,remarks=?20"
			+ "  WHERE loco_no=?21", nativeQuery=true)	
	int updateDieselBoardZonalRecord( String locoPermanentDomain, String locoType, String locoOwningZone,
			String locoOwningDivision, Date locoMfgDt, String locOwningShed, Date recddt,  String locoLeasetype,
			 long locoInitialCost, long locoPOHCost, String flagCode, String gaugeType, Long locoHaulingPower,
			String locoMfgCountry,String recordstatus,String status,String uid, Date locotxndate,Date locoentrydate ,String remarks, int locoNo);
	
	
	@Query(value="select loco_no from mdms_loco.loco_uncleansed_data where loco_no=?1", nativeQuery=true)
	Integer checklocoNoExist(int locoNo);
	
	
	@Transactional
	@Modifying
	@Query(value="INSERT INTO mdms_loco.loco_uncleansed_data(\r\n" + 
			" loco_no, loco_permanent_domain, loco_type,loco_owning_zone, loco_owning_division, loco_manufacturing_date,loco_owning_shed,"
			+ "loco_lease_type, loco_initial_cost, loco_poh_cost,loco_receiving_date,loco_entry_date, record_status, status, user_id, txn_date,remarks, loco_flag)\r\n" + 
			"VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12,?13,?14,?15,?16,?17,?18);", nativeQuery=true)
	int saveElectricBoardZonalData( int locoNo, String locoPermanentDomain, String locoType,
			String locoOwningZone, String locoOwningDivision, Date locoMfgDt, String locOwningShed,
			String locoLeasetype, long locoInitialCost, long locoPOHCost, Date locoRcvdDate,Date locoEtryDt,String recordstatus,String status,String uid,Date txndate,String remarks,String locoflag);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE mdms_loco.loco_uncleansed_data\r\n" + 
			"	SET loco_permanent_domain=?2, loco_type=?3,loco_owning_zone=?4, loco_owning_division=?5, loco_manufacturing_date=?6, loco_owning_shed=?7,"
			+ "loco_receiving_date=?8,loco_lease_type=?9,loco_initial_cost=?10,  loco_poh_cost=?11, status=?12, user_id=?13, txn_date=?14, remarks=?15, loco_gauge_type=?16, loco_manufacturing_country=?17, loco_hauling_power=?18 "
			+ "  WHERE loco_no=?1", nativeQuery=true)	
	int updateElectricBoardZonalRecord( int locoNo, String locoPermanentDomain, String locoType, String locoOwningZone,
			String locoOwningDivision, Date locoMfgDt, String locOwningShed, Date locoRecdDt,String locoLeasetype,
			long locoInitialCost, long locoPOHCost, 
			String status, String uid, Date locotxndate,  String remarks, String gaugeType, String manCntry, Long haulingPower);
	
	
	
	@Transactional
	@Modifying
	@Query(value="INSERT INTO mdms_loco.loco_approved_data(\r\n" + 
			"	loco_no, loco_type, loco_owning_zone, loco_owning_shed, loco_owning_division, loco_manufacturing_country, loco_manufacturing_date, \r\n" + 
			"loco_receiving_date, loco_hauling_power, loco_traction_code, loco_permanent_domain, loco_gauge_type,\r\n" + 
			" loco_lease_type, loco_initial_cost, loco_poh_cost, loco_entry_date, status, user_id, txn_date, remarks, loco_flag, record_status)\r\n" + 
			"	VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12, ?13, ?14, ?15, ?16, ?17, ?18, ?19, ?20, ?21, ?22);", nativeQuery=true)
	void insertRBZonalToGoldenMaster(int locoNo, String locoType, String locoOwningZone, String locOwningShed,
			String locoOwningDivision, String manuCntry, Date locoMfgDt, Date locoRecdDt, Long haulingPower,
			String traction, String locoPermanentDomain, String gaugeType, String locoLeasetype, long locoInitialCost,
			long locoPOHCost, Date locoEntryDate, String status, String uid, Date txnDate, String remarks,
			String locoFlag, String recordStatus);
	
   // JYOTI BISHT - FOR DASHBOARD ZONE-SHED WISE unapproved/uncleansed count 

	  @Query(value="SELECT loco_owning_zone as loco_owning_zone_code, loco_owning_shed as loco_Owningshed ,count(*) as uncleansed_count FROM  mdms_loco.loco_uncleansed_data "
	  		+ "WHERE status='U' and loco_no not in (select loco_no from mdms_loco.loco_condemnation_detail) GROUP BY  loco_owning_zone ,loco_owning_shed ORDER BY loco_owning_zone",nativeQuery=true)
	    Collection<DashBoardLocoCountShedWiseModel> getLocoPendingZoneshed1();
	  
	  

	  
	 

	
}
