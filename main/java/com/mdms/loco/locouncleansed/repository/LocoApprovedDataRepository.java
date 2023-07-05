package com.mdms.loco.locouncleansed.repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.dahsboard.model.DashBoardLocoCountShedWiseModel;
import com.mdms.loco.locouncleansed.model.LocoApprovedData;
import com.mdms.loco.locouncleansed.model.LocoUncleansedDataElectric;


public interface LocoApprovedDataRepository extends CrudRepository<LocoApprovedData,Long>{

	@Query(value="select * from mdms_loco.loco_approved_data where loco_owning_shed=?1 AND loco_flag=?2 AND status='A'AND (record_status='O' OR record_status='N')",nativeQuery=true)
	List<LocoApprovedData> getApprovedLoco(String eshedid, String locoflag);

	//@Query(value="SELECT loco_owning_shed as loco_Owningshed,COUNT(*)  as cleansed_count FROM  mdms_loco.loco_approved_data WHERE loco_owning_shed=?1 AND record_status='O' AND LOCO_NO IN (SELECT DISTINCT  loco_no from  mdms_loco.loco_data_fois )AND LOCO_NO IN (SELECT DISTINCT  loco_no from  mdms_loco.loco_data_fois ) GROUP BY loco_owning_shed",nativeQuery=true)
	@Query(value="SELECT loco_owning_shed as loco_Owningshed,COUNT(*)  as cleansed_count FROM  mdms_loco.loco_approved_data WHERE loco_owning_shed=?1 AND record_status='O'  GROUP BY loco_owning_shed",nativeQuery=true)
	Collection<DashBoardLocoCountShedWiseModel> getLocoApprovedSingleshed(String eshedid);
	
	//Shilpi 19-03-2021
//	 	@Query(value="SELECT  distinct a.zone_code as loco_owning_zone_code, b.loco_Owningshed as loco_Owningshed, b.cleansed_count FROM (mdms_masters.m_zone a  inner join mdms_loco.m_loco_shed c on a.zone_code=c.zone_code  LEFT JOIN \r\n"
//	 			+ "		(SELECT loco_approved_data.loco_owning_zone AS loco_owning_zone_code, loco_approved_data.loco_owning_shed AS loco_Owningshed, count(*) AS cleansed_count \r\n"
//	 			+ "		 FROM mdms_loco.loco_approved_data  WHERE status='A' and record_status='O' and  loco_owning_zone=?1 GROUP BY loco_owning_zone_code,loco_Owningshed) b ON (b.loco_owning_zone_code =a.zone_code) ) where a.zone_code=?1 order by 3",nativeQuery=true)	
 	@Query(value="SELECT loco_owning_zone as loco_owning_zone_code ,loco_owning_shed as loco_Owningshed,COUNT(*)  as cleansed_count FROM  mdms_loco.loco_approved_data WHERE loco_owning_zone=?1 AND record_status='O'  and status ='A' GROUP BY loco_owning_zone,loco_owning_shed order by 2",nativeQuery=true)
	Collection<DashBoardLocoCountShedWiseModel> getLocoApprovedZoneShed(String loco_owning_zone_code);
	
	//Shilpi 09-04-2021 zonal hyperlink
	@Query(value="SELECT * FROM  mdms_loco.loco_approved_data WHERE loco_owning_shed=?1 AND record_status='O'and status ='A'  ",nativeQuery=true)
	List<LocoApprovedData> getLocoApprovedHypershed(String eshedid);
	
	// ritu 21-3-2022 - update golden record based on loco type -D/E
	@Transactional
	@Modifying
	@Query(value ="UPDATE mdms_loco.loco_approved_data SET loco_cabin_ac=?1,loco_permanent_domain=?2, loco_control_type=?3, loco_receiving_date=?4"
			+ " ,loco_auxilary=?5,loco_traction_motor_type=?6, loco_hotel_load=?7,is_gps_enabled=?8, flag_type=?9, loco_brake_sub_type=?10 ,txn_date=?11 ,loco_axle_load=?12 WHERE loco_no=?13",nativeQuery=true)
	int updateEGoldenRecord(String var1,String var2,String var3,Date var4,String var5,String var6,String var7,String var8,String var9,String var10, Date var11,String var12,  int locono);
	
	@Transactional
	@Modifying
	@Query(value ="UPDATE mdms_loco.loco_approved_data SET loco_type=?1,loco_permanent_domain=?2, loco_control_type=?3, loco_receiving_date=?4"
			+ ", loco_brake_type=?5,loco_traction_motor_type=?6,is_gps_enabled=?7, flag_type=?8, loco_brake_sub_type=?9 , txn_date=?10,loco_axle_load=?11 WHERE loco_no=?12",nativeQuery=true)
	int updateDGoldenRecord(String var1,String var2,String var3,Date var4,String var5,String var6,String var7,String var8,String var9,Date var10, String var11,int locono);	
	
	
	@Transactional
	@Modifying
	@Query(value="update mdms_loco.loco_approved_data set loco_owning_zone=?1, loco_owning_shed=?2, loco_owning_division=?3, transfer_loco_status='TA' where loco_no=?4",nativeQuery=true)
	void updateLocoApproveData(String oZoneCode, String oShedCode, String oDivnCode, int locoNo);
	
	//Jyoti Bisht 23-09-22
	
	@Query(value="select * from mdms_loco.loco_approved_data WHERE loco_owning_shed=?1 AND transfer_loco_status='TA'",nativeQuery=true)
	List<LocoApprovedData> getGoldenLocoTranfer(String loco_shed);
		
	// JYOTI BISHT 17-10-22
		
	@Query(value="select count(*) from mdms_loco.loco_approved_data  where status='A' and loco_entry_date between ?1 and ?2",nativeQuery = true)
	int getLocoApproved(Date from, Date to);
	
	 // JYOTI BISHT 5-1-23  for dashboard without Login
	  
	 @Query(value="select * from mdms_loco.loco_approved_data where loco_owning_zone=?1 and loco_owning_shed=?2 and status=?3 ",nativeQuery = true)
	 List<LocoApprovedData>  getLocoDetails(String zone, String shed, String status);
		
		


	//JYOTI BISHT for dashboard zone-shed wise loco approved count
	
	@Query(value="SELECT loco_owning_zone as loco_owning_zone_code ,loco_owning_shed as loco_Owningshed, COUNT(*)  as cleansed_count FROM  mdms_loco.loco_approved_data "
				+ "WHERE status='A' and loco_no not in (select loco_no from mdms_loco.loco_condemnation_detail) GROUP BY loco_owning_zone,loco_owning_shed order by loco_owning_zone",nativeQuery=true)
	Collection<DashBoardLocoCountShedWiseModel> getLocoApprovedZoneShed1();

	
	// JYOTI BISHT 23-06-23
	@Query(value="select * from mdms_loco.loco_approved_data where loco_no=?1 and loco_owning_shed=?2",nativeQuery = true)
	LocoApprovedData getLocoCompletedetail(int loco_no,String shed);
		
	

		
}
