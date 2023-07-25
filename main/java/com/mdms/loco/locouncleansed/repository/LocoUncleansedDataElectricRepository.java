package com.mdms.loco.locouncleansed.repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.dahsboard.model.DashBoardLocoCountShedWiseModel;
import com.mdms.dahsboard.model.DashBoardStationCountDivisionWiseModel;
import com.mdms.loco.locouncleansed.model.LocoDataFois;
import com.mdms.loco.locouncleansed.model.LocoUncleansedData;
import com.mdms.loco.locouncleansed.model.LocoUncleansedDataAddNewLoco;
import com.mdms.loco.locouncleansed.model.LocoUncleansedDataElectric;

public interface LocoUncleansedDataElectricRepository extends CrudRepository <LocoUncleansedDataElectric,Long> {

	@Query(value="SELECT * FROM  mdms_loco.loco_uncleansed_data WHERE loco_no=?1 AND record_status='O' AND  (status='D' OR Status='R') ",nativeQuery=true)
	List<LocoUncleansedDataElectric> getDraftLoco(int elno);
	
	@Query(value="SELECT * FROM  mdms_loco.loco_uncleansed_data WHERE loco_owning_shed=?1 AND  loco_flag=?2 AND status='U' AND (record_status='O' OR record_status ='N')",nativeQuery=true)
	List<LocoUncleansedDataElectric> getUnapprovedLoco(String eshedid, String locoflag);
	
	@Query(value="SELECT * FROM  mdms_loco.loco_uncleansed_data WHERE  status='D' OR status='U'",nativeQuery=true)
	List<LocoUncleansedDataElectric> getAllShedData();
	
	@Query(value="SELECT * FROM  mdms_loco.loco_uncleansed_data WHERE loco_owning_shed=?1 AND loco_flag=?2 AND record_status='O' AND (status='D' OR Status='R')",nativeQuery=true)
	List<LocoUncleansedDataElectric> getcleansedDraftLoco(String eshedid, String locoflag);
	
	
	
	@Query(value="DELETE   FROM  mdms_loco.loco_uncleansed_data WHERE loco_no=?1 ",nativeQuery=true)
	int  deletedraftloco(int elocono);
	
	@Transactional
	@Modifying
	@Query(value ="UPDATE mdms_loco.loco_uncleansed_data SET loco_type=?1,loco_manufacturer=?2, loco_control_type=?3, loco_permanent_domain=?4,loco_receiving_date=?5, loco_commissioning_date=?6,"
			+ " loco_auxilary=?7,loco_traction_motor_type=?8, loco_owning_zone=?9,"
			+ " loco_owning_shed=?10, loco_boogie_type=?11, loco_lease_type=?12,"
			+ " loco_brake_type=?13, loco_brake_sub_type=?14, loco_cabin_ac=?15, "
			+ "loco_entry_date=?16, is_gps_enabled=?17, status=?18,"
			+ "remarks=?19, loco_hotel_load=?20, flag_type=?21 , loco_manufacturing_date =?22 , loco_gauge_type=?23 , loco_axle_load=?24, loco_hauling_power=?25 WHERE loco_no=?26",nativeQuery=true)
	int updateEDraftRecord(String var1,String var2,String var3,String var4,Date var5,Date var6,String var7,String var8,String var9,
			String var10,  String var11,String var12,String var13,String var14,String var15,Date var16,String var17,String var18,String var19,String var20,String var21,
			Date var22,String var23, String var24, String var25, int locono);	
 	

	@Transactional
	@Modifying
	@Query(value="UPDATE mdms_loco.loco_uncleansed_data SET status=?1, remarks=?2, user_id=?3  WHERE loco_no =?4", nativeQuery=true)
	int updatestatus(String status , String remarks, String uid , int locono);

	
//	@Transactional
//	@Modifying
//	@Query(value="\r\n" + 
//			"	UPDATE mdms_loco.loco_uncleansed_data SET  loco_auxilary=?2,loco_boogie_type=?3, loco_brake_sub_type=?4, loco_brake_type=?5,\r\n" + 
//			"	loco_cabin_ac=?6, loco_commissioned_shed_id=?7,loco_control_type=?8,loco_commissioning_date=?9,loco_entry_date=?10,loco_hotel_load=?11,\r\n" + 
//			"	loco_manufacturer=?12,is_gps_enabled=?13,flag_type=?14,status=?15, user_id=?16, txn_date=?17 WHERE loco_no=?1", nativeQuery=true)
//	int updateWithElectricLocoShedData(String locoAuxiliaryOutput, String locoBoogieType, String locoBrakeSubtype,
//			String locoBrakeType, String locoCabac, String locoCommissionedShedId, String locoControlType,
//			Date locoDateOfCommision, Date locoEntryDate, String locoHotelLoad,String locoManfacturer,String isGPSEnabled,String flagtype,
//			String status,String userid,Date txndate,int locono);
//	
	

	@Query(value="SELECT * FROM  mdms_loco.loco_uncleansed_data WHERE loco_owning_zone=?1  AND record_status='N'AND status='ZU' ",nativeQuery=true)
	List<LocoUncleansedDataElectric> getUnapprovedZonalBoardLoco(String locozone);
	
	
	@Transactional
	@Modifying
	@Query(value="INSERT INTO mdms_loco.loco_approved_data(\r\n" + 
			"	loco_no, loco_type, loco_owning_zone, loco_owning_division, loco_owning_shed,loco_permanent_domain,	loco_initial_cost, loco_poh_cost, loco_auxilaryoutput,\r\n" + 
			"	loco_lease_type,loco_mfg_dt, loco_recd_dt, loco_boogie_type,loco_brake_sub_type,loco_brake_type,loco_cabac, loco_commissioned_shed_id,  loco_control_type,\r\n" + 
			"	 loco_doc,loco_entry_date, loco_hotel_load,loco_manufacturer,  \r\n" + 
			"	 is_gps_enabled,flag_type, loco_traction_motor_type,status, user_id, txn_date, remarks, loco_flag, record_status)\r\n" + 
			"	VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12, ?13, ?14, ?15, ?16, ?17, ?18, ?19, ?20, ?21, ?22, ?23, ?24,?25,?26.?27,?28,?29,?30,?31);", nativeQuery=true)

		int insertNewLocoShedData(long locoNo, String locoType, String locoOwningZone, String locoOwningDivision,

//			int insertNewLocoShedData(int locoNo, String locoType, String locoOwningZone, String locoOwningDivision,

					String locOwningShed, String locoPermanentDomain, Long locoInitialCost, Long locoPOHCost,
					String locoAuxiliaryOutput, String leaseType, Date dateOfMfg, Date dateOfRcng,
					String locoBoogieType, String locoBrakeSubtype, String locoBrakeType, String locoCabac,
					String locoCommissionedShedId, String locoControlType, Date locoDateOfCommision, Date locoEntryDate,
					String locoHotelLoad,String locoManfacturer, String isGPSEnable,String flagtype, String locoTractionMotorType, String status, String userid,Date txndate,String remarks,String locoflag,String recordstatus);

//	int insertNewLocoShedData(int locoNo, String locoType, String locoOwningZone, String locoOwningDivision,
//			String locOwningShed, String locoPermanentDomain, Long locoInitialCost, Long locoPOHCost,
//			String locoAuxiliaryOutput, String leaseType, Date dateOfMfg, Date dateOfRcng,
//			String locoBoogieType, String locoBrakeSubtype, String locoBrakeType, String locoCabac,
//			String locoCommissionedShedId, String locoControlType, Date locoDateOfCommision, Date locoEntryDate,
//			String locoHotelLoad,String locoManfacturer, String isGPSEnable,String flagtype, String locoTractionMotorType, String status, String userid,Date txndate,String remarks,String locoflag,String recordstatus);

	
	// Shilpi 09-03-2021
    

//	@Query(value="SELECT loco_owning_shed as loco_Owningshed , COUNT(*)  as draft_forward_approval_count FROM  mdms_loco.loco_uncleansed_data WHERE loco_owning_shed=?1 AND (status='D' OR Status='R') AND LOCO_NO IN (SELECT DISTINCT  loco_no from  mdms_loco.loco_data_fois ) GROUP BY loco_owning_shed",nativeQuery=true)
	@Query(value="SELECT loco_owning_shed as loco_Owningshed , COUNT(*)  as draft_forward_approval_count FROM  mdms_loco.loco_uncleansed_data WHERE loco_owning_shed=?1 AND (status='D' OR Status='R')  GROUP BY loco_owning_shed",nativeQuery=true)
	Collection<DashBoardLocoCountShedWiseModel> getDraftLocoApprovalSingleshed(String eshedid);
	
	
	

	//@Query(value="SELECT loco_owning_shed as loco_Owningshed , COUNT(*)  as pending_approval FROM  mdms_loco.loco_uncleansed_data WHERE loco_owning_shed=?1 AND (status='U') AND LOCO_NO IN (SELECT DISTINCT  loco_no from  mdms_loco.loco_data_fois ) GROUP BY loco_owning_shed ",nativeQuery=true)
	@Query(value="SELECT loco_owning_shed as loco_Owningshed , COUNT(*)  as pending_approval FROM  mdms_loco.loco_uncleansed_data WHERE loco_owning_shed=?1 AND status='U' GROUP BY loco_owning_shed ",nativeQuery=true)
	Collection<DashBoardLocoCountShedWiseModel> getLocoPendingSingleshed(String eshedid);

	//Shilpi 18-03-2021 --FOR ZONE WISE
	
	@Query(value="SELECT loco_owning_zone as loco_owning_zone_code,loco_owning_shed as loco_Owningshed , COUNT(*)  as draft_forward_approval_count FROM  mdms_loco.loco_uncleansed_data WHERE loco_owning_zone=?1 AND (status='D' OR Status='R')  GROUP BY loco_owning_zone,loco_owning_shed order by 2",nativeQuery=true)
	Collection<DashBoardLocoCountShedWiseModel> getDraftLocoApprovalZoneshed(String loco_owning_zone_code);
	
	//@Query(value="SELECT loco_owning_zone as loco_owning_zone_code,loco_owning_shed as loco_Owningshed , COUNT(*)  as pending_approval FROM  mdms_loco.loco_uncleansed_data WHERE loco_owning_zone=?1 AND status='U' AND LOCO_NO IN (SELECT DISTINCT  loco_no from  mdms_loco.loco_data_fois ) GROUP BY loco_owning_zone,loco_owning_shed order by 2",nativeQuery=true)
	@Query(value="SELECT loco_owning_zone as loco_owning_zone_code,loco_owning_shed as loco_Owningshed ,COUNT(*)  as pending_approval "
			+ "FROM  mdms_loco.loco_uncleansed_data a join mdms_loco.m_loco_shed as b on a.loco_owning_shed=b.shed_code  WHERE loco_owning_zone=?1 AND status='U' and  loco_owning_shed not in(select shed_code from mdms_loco.m_loco_shed where private_shed='Y' and validity='Y')	GROUP BY loco_owning_zone,loco_owning_shed order by 2",nativeQuery=true) 
	Collection<DashBoardLocoCountShedWiseModel> getLocoPendingZoneshed(String loco_owning_zone_code);
	
	//Shilpi 09-04-2021 zonal hyperlink
	
	@Query(value="SELECT * FROM  mdms_loco.loco_uncleansed_data WHERE loco_owning_shed=?1 AND (status='D' OR Status='R')",nativeQuery=true)
	List<LocoUncleansedDataElectric> getDraftLocoApprovalHypershed(String eshedid);
	
	
     @Query(value="SELECT * FROM  mdms_loco.loco_uncleansed_data WHERE loco_owning_shed=?1 AND status='U'",nativeQuery=true)
     List<LocoUncleansedDataElectric> getLocoPendingHypershed(String eshedid);
     
     
     
// 	@Query(value="select * from mdms_loco.loco_uncleansed_data where status in('U','D') AND loco_no=?1",nativeQuery=true)
//    List<LocoUncleansedDataElectric> getLocoUnclnesedData(int loco_no);

 	
 	
 	@Query(value="select * from mdms_loco.loco_uncleansed_data where status in('U','D') AND loco_no=?1",nativeQuery=true)
    List<LocoUncleansedDataElectric> getLocoUnclnesedData(int loco_no);
 	
 	 //amit to update loco transfer status
    @Transactional
	  @Modifying
	  @Query(value="UPDATE mdms_loco.loco_uncleansed_data\r\n"
	  		+ "	SET  loco_owning_zone=?1, loco_owning_shed=?2,  status=?3 \r\n"
	  		+ "	WHERE loco_no=?4",nativeQuery=true)
	  int updateStatus(String loco_owning_zone,String loco_owning_shed,String status,int loco_no);
    
    
 // JYOTI BISHT 17-10-22
	
 	  @Query(value="select count(*) from mdms_loco.loco_uncleansed_data  where status='D' and loco_entry_date between ?1 and ?2",nativeQuery = true)
       int getLocoDraft(Date from, Date to);

 	  @Query(value="select count(*) from mdms_loco.loco_uncleansed_data  where status='U' and loco_entry_date between ?1 and ?2",nativeQuery = true)
       int getLocoPending(Date from, Date to);

 // JYOTI BISHT 5-1-23  for dashboard without Login
 	  
 	 @Query(value="select * from mdms_loco.loco_uncleansed_data where loco_owning_zone=?1 and loco_owning_shed=?2 and status=?3 ",nativeQuery = true)
 	 List<LocoUncleansedDataElectric>  getLocoDetails(String zone, String shed, String status);
    
	
 // Shilpi 09-03-2021

  // JYOTI BISHT 5-1-23 for dashboard zone & shed wise loco draft count
 	@Query(value="SELECT loco_owning_zone as loco_owning_zone_code,loco_owning_shed as loco_Owningshed , COUNT(*)  as draft_forward_approval_count FROM  mdms_loco.loco_uncleansed_data "
 			+ "WHERE (status='D' OR Status='R') and loco_no not in (select loco_no from mdms_loco.loco_condemnation_detail)  GROUP BY loco_owning_zone,loco_owning_shed order by loco_owning_zone",nativeQuery=true)
	Collection<DashBoardLocoCountShedWiseModel> getDraftLocoApprovalZoneshed1();
 	
 	//ritu 20-7-2023 to get pvt  unapporved loco shed wise 
 	@Query(value="SELECT loco_owning_zone as loco_owning_zone_code,loco_owning_shed as loco_Owningshed , \r\n"
 			+ "COUNT(*)  as pending_approval FROM  mdms_loco.loco_uncleansed_data a join\r\n"
 			+ "mdms_loco.m_loco_shed as b on a.loco_owning_shed=b.shed_code\r\n"
 			+ "WHERE loco_owning_zone=?1 \r\n"
 			+ "AND status='U' and  loco_owning_shed  in\r\n"
 			+ "(select shed_code from mdms_loco.m_loco_shed where private_shed='Y' and validity='Y')\r\n"
 			+ "GROUP BY loco_owning_zone,loco_owning_shed order by 2 ",nativeQuery=true)
 				Collection<DashBoardLocoCountShedWiseModel> getLocoPendingZoneshedprivate(String loco_owning_zone_code);
	
 	//ritu 20-7-2023 to get pvt  draft loco shed wise 
 	 	@Query(value="SELECT loco_owning_zone as loco_owning_zone_code,loco_owning_shed as loco_Owningshed , \r\n"
 	 			+ "COUNT(*)  as pending_approval FROM  mdms_loco.loco_uncleansed_data a join\r\n"
 	 			+ "mdms_loco.m_loco_shed as b on a.loco_owning_shed=b.shed_code\r\n"
 	 			+ "WHERE loco_owning_zone=?1 \r\n"
 	 			+ "AND status='D' and  loco_owning_shed  in\r\n"
 	 			+ "(select shed_code from mdms_loco.m_loco_shed where private_shed='Y' and validity='Y')\r\n"
 	 			+ "GROUP BY loco_owning_zone,loco_owning_shed order by 2 ",nativeQuery=true)
 	 				Collection<DashBoardLocoCountShedWiseModel> getDraftLocoApprovalZoneshedprivate(String loco_owning_zone_code);
 		

}





