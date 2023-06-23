package com.mdms.mdms_station.stationuncleansed.repository;


import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.dahsboard.model.DashBoardStationCountDivisionWiseModel;
import com.mdms.loco.locouncleansed.model.LocoApprovedData;
import com.mdms.mdms_station.stationuncleansed.model.StationPKey;
import com.mdms.mdms_station.stationuncleansed.model.StationTableRbs;
import com.mdms.mdms_station.stationuncleansed.model.StationUncleansedData;


public interface StationUncleansedDataRepository extends CrudRepository <StationUncleansedData,StationPKey>{	
	@Query(value="select * FROM mdms_station.station_uncleansed_data where user_id_cmi=?1 and ( cmi_status='D'OR  cmi_status='R') and station_code=?2", nativeQuery = true)
	StationUncleansedData getDraftFromUncleansedCmi(String useridcmi, String station_code);


	
	@Query(value="select * FROM mdms_station.station_uncleansed_data where user_id_dti=?1 and ( dti_status='D'OR  dti_status='R') and station_code=?2", nativeQuery = true)
	StationUncleansedData getDraftFromUncleansedDti(String useriddti, String station_code);

	@Modifying
	@Transactional
	@Query(value="UPDATE mdms_station.station_uncleansed_data\r\n" + 
			"	SET station_numeric_code=?5, station_name=?6, traffic_type=?7, transhipment_flag=?8, station_class=?9, junction_flag=?10, interchange_flag=?11, state=?12, pincode=?13, district=?14, tehsil=?15, "+
			 "station_short_name=?16,interlocking_standard=?17, working_division=?18,  weight_bridge=?19, siding=?20, booking_type=?21, cmi_status=?22,  txn_date_cmi=?23 , booking_resource=?24 \r\n" + 
			"	WHERE user_id_cmi =?1 AND station_code =?2 AND station_valid_from =?3  AND station_valid_upto=?4",nativeQuery = true)
	int updateDraftCmi(String userid, String cmi_station_code, Date cmi_valid_from, Date cmi_valid_upto , long numeric_code , String station_name,
			String traffic, String transhipment , String stationclass , String junctionf, String interchngf , String state, String pincode , String district , String tehsil , 
			String shprtname, String intrlckstd , String wrkngdvsn , int weighbridge, String siding ,  String bookingtype , String cmistatus, Date dt ,String booking_resource );

	@Query(value="select * FROM mdms_station.station_uncleansed_data where  cmi_status='U' and division_code=?1", nativeQuery = true)
	List<StationUncleansedData>fetchUnapprovedCmiRecords(String division_code);

	@Query(value="select * FROM mdms_station.station_uncleansed_data where  dti_status='U' and division_code=?1", nativeQuery = true)
	List<StationUncleansedData>fetchUnapprovedDtiRecords(String division_code);
	
	
			@Modifying
			@Transactional
			@Query(value="UPDATE mdms_station.station_uncleansed_data SET cmi_status='A' \r\n" + 
					"	where station_code=?1",nativeQuery = true)
	int approvedByDcm(String station_code);

			
			@Modifying
			@Transactional
			@Query(value="UPDATE mdms_station.station_uncleansed_data SET dti_status='A' \r\n" + 
					"	where station_code=?1",nativeQuery = true)
	int approvedByDom(String station_code);
			
			
			
			@Modifying
			@Transactional
			@Query(value="UPDATE mdms_station.station_uncleansed_data SET cmi_status='R' \r\n" + 
					"	where station_code=?1",nativeQuery = true)
	int rejectByDcm(String station_code);
			
			@Modifying
			@Transactional
			@Query(value="UPDATE mdms_station.station_uncleansed_data SET dti_status='R' \r\n" + 
					"	where station_code=?1",nativeQuery = true)
	int rejectByDom(String station_code);
			
			@Modifying
			@Transactional
			@Query(value="UPDATE mdms_station.station_uncleansed_data\r\n" + 
					"	SET gauge_code=?5, station_category=?6, interchange_flag=?7, traction=?8, interlocking_standard=?9, junction_flag=?10, no_of_lines=?11, operating_station_signal=?12 ,  txn_date_dti=?13 ,dti_status=?14" + 
					"	WHERE user_id_dti =?1 AND station_code =?2 AND station_valid_from =?3  AND station_valid_upto=?4",nativeQuery = true)
			int updateDraftDti(String userid, String dti_station_code, Date dti_valid_from, Date dti_valid_upto,String gauge_code, String station_category,
					String interchange_flag , String traction , String interlocking_standard , String junction_flag , String no_of_lines , String operating_station_signal,
					Date date,String dti_status);


			
			

			@Modifying
			@Transactional
			@Query(value="UPDATE mdms_station.station_uncleansed_data\r\n" + 

					"	SET station_numeric_code=?5, station_name=?6, traffic_type=?7, transhipment_flag=?8, station_class=?9, state=?10, pincode=?11, district=?12, tehsil=?13, "+
					 "station_short_name=?14, working_division=?15,  weight_bridge=?16, siding=?17, booking_type=?18, cmi_status=?19,  txn_date_cmi=?20 ,user_id_cmi=?1 , booking_resource=?21 \r\n" + 
					"	WHERE station_code =?2 AND station_valid_from =?3  AND station_valid_upto=?4",nativeQuery = true)
			int updateDraftCmiDti(String userid, String cmi_station_code, Date cmi_valid_from, Date cmi_valid_upto , long numeric_code , String station_name,
					String traffic, String transhipment , String stationclass , String state, String pincode , String district , String tehsil , 
					String shprtname, String wrkngdvsn , int weighbridge, String siding ,  String bookingtype , String cmistatus, Date dt , String booking_resource);

				
			@Modifying
			@Transactional
			@Query(value="UPDATE mdms_station.station_uncleansed_data SET gauge_code=?5, station_category=?6, interchange_flag=?7, traction=?8, interlocking_standard=?9, junction_flag=?10, no_of_lines=?11, operating_station_signal=?12 ,  txn_date_dti=?13 , user_id_dti=?1 ,dti_status=?14 " + 
					"	WHERE station_code =?2 AND station_valid_from =?3  AND station_valid_upto=?4",nativeQuery = true)
			int updateDraftDtiCmi(String userid, String dti_station_code, Date dti_valid_from, Date dti_valid_upto,String gauge_code, String station_category,
					String interchange_flag , String traction , String interlocking_standard , String junction_flag , String no_of_lines , String operating_station_signal,
					Date date ,String dti_status);


			@Query(value="select * from mdms_station.station_uncleansed_data where station_code=?1 AND record_status='N' and cmi_status='D'",nativeQuery=true)
			StationUncleansedData   checkStnData(String stncode);
			
			@Modifying
			@Transactional
			@Query(value="UPDATE mdms_station.station_uncleansed_data\r\n" + 
					"	SET station_numeric_code=?5, station_name=?6, traffic_type=?7, transhipment_flag=?8, station_class=?9, junction_flag=?10, interchange_flag=?11, state=?12, pincode=?13, district=?14, tehsil=?15, "+
					 "station_short_name=?16,interlocking_standard=?17, working_division=?18,  weight_bridge=?19, siding=?20, booking_type=?21, cmi_status=?22,  txn_date_cmi=?23 ,booking_resource=?24 \r\n" + 
					"	WHERE user_id_cmi =?1 AND station_code =?2 AND station_valid_from =?3  AND station_valid_upto=?4",nativeQuery = true)
			int updateCleansedDraftCmi(String userid, String cmi_station_code, Date cmi_valid_from, Date cmi_valid_upto , long numeric_code , String station_name,
					String traffic, String transhipment , String stationclass , String junctionf, String interchngf , String state, String pincode , String district , String tehsil , 
					String shprtname, String intrlckstd , String wrkngdvsn , int weighbridge, String siding ,  String bookingtype , String cmistatus, Date dt ,String booking_resource );

			@Query(value="select station_code from  mdms_station.station_uncleansed_data where division_code=?1 and cmi_status='A' and record_status='N' and (dti_status='N' or dti_status= 'D')",nativeQuery=true)
			List<String> getDraftStncode(String divcode);
			
			@Query(value="select * from mdms_station.station_uncleansed_data where station_code=?1",nativeQuery=true)
			StationUncleansedData findvalidstn(String station_code);
			
			@Query(value="select * FROM mdms_station.station_uncleansed_data where user_id_dti=?1 and dti_status='D' and station_code=?2", nativeQuery = true)
	StationUncleansedData getDraftDti(String useriddti, String station_code);
			
			
			@Modifying
			@Transactional
			@Query(value="UPDATE mdms_station.station_uncleansed_data\r\n" + 
					"	SET gauge_code=?5, station_category=?6, interchange_flag=?7, traction=?8, interlocking_standard=?9, junction_flag=?10, no_of_lines=?11, operating_station_signal=?12 ,  txn_date_dti=?13 ,dti_status=?14" + 
					"	WHERE user_id_dti =?1 AND station_code =?2 AND station_valid_from =?3  AND station_valid_upto=?4",nativeQuery = true)
			int forwardDraftDti(String userid, String dti_station_code, Date dti_valid_from, Date dti_valid_upto,String gauge_code, String station_category,
					String interchange_flag , String traction , String interlocking_standard , String junction_flag , String no_of_lines , String operating_station_signal,
					Date date,String dti_status);

			
			 @Query(value="select division_code,count(*) as pending_approval" + 

				  		"  from mdms_station.station_uncleansed_data where zone_code=?1 and (cmi_status='U' OR dti_status='U') group by division_code"				  	
				  					  		,nativeQuery = true)
			  Collection<DashBoardStationCountDivisionWiseModel> getPendingApprovalStationCountDivisionWise(String zone_code);

				

			 //Shilpi 04-03-2021
			 @Query(value="select division_code,count(*) as pending_approval" + 
				  		"  from mdms_station.station_uncleansed_data where division_code=?1 and (cmi_status='U' OR dti_status='U') group by division_code"
				  					  		,nativeQuery = true)
			  Collection<DashBoardStationCountDivisionWiseModel> getPendingApprovalStationCountSingleDivisionWise(String division_code);
			 
               //END CHANGE
			  
			  @Query(value="select division_code, count(*) as cleansed_count " + 
				  		"from mdms_station.station_cleansed_data where zone_code=?1 group by division_code",nativeQuery=true)
			  Collection<DashBoardStationCountDivisionWiseModel> getTotalCleansedStationCountDivisionWise(String zone_code);
		  
			 
			 
			  @Query(value=" select division_code,count(*) as draft_forward_approval_count\r\n"
			  		+ "			  	from mdms_station.station_uncleansed_data where zone_code=?1 and (cmi_status='D' OR dti_status='D' or cmi_status='R' OR dti_status='R') group by division_code\r\n"
			  		+ "			",nativeQuery=true)
			  Collection<DashBoardStationCountDivisionWiseModel> getTotalDraftForwardApprovalStationCountDivisionWise(String zone_code);
			  
			  //Shilpi 04-03-2021
			  
			  @Query(value=" select division_code,count(*) as draft_forward_approval_count\r\n"
				  		+ "			  	from mdms_station.station_uncleansed_data where division_code=?1 and (cmi_status='D' OR dti_status='D' OR cmi_status='R' OR dti_status='R') group by division_code\r\n"
				  		+ "			",nativeQuery=true)
				  Collection<DashBoardStationCountDivisionWiseModel> getTotalDraftForwardApprovalStationCountSingleDivisionWise(String division_code);
			  
			  //end changes
			  
			  // Shilpi 22-03-2021
			  
			  @Query(value="select zone_code,division_code,count(*) as pending_approval from mdms_station.station_uncleansed_data where zone_code=?1 and (cmi_status='U' OR dti_status='U') group by 1,2",nativeQuery = true)
			  Collection<DashBoardStationCountDivisionWiseModel> getPendingApprovalStationCountZoneWise(String zone_code);
			  
			  
			  @Query(value=" select zone_code,division_code,count(*) as draft_forward_approval_count\r\n"
				  		+ "			  	from mdms_station.station_uncleansed_data where zone_code=?1 and (cmi_status='D' OR dti_status='D' or cmi_status='R' OR dti_status='R') group by 1,2 ORDER BY 2\r\n"
				  		+ "			",nativeQuery=true)
				  Collection<DashBoardStationCountDivisionWiseModel> getTotalDraftForwardApprovalStationCountZoneWise(String zone_code);

			 
			  //Shilpi 09-04-2021 zonal hyperlink
			  
			  @Query(value=" select * from mdms_station.station_uncleansed_data where division_code=?1 and (cmi_status='D' OR dti_status='D' OR cmi_status='R' OR dti_status='R')",nativeQuery=true)
			  List<StationUncleansedDataRepository> getTotalDraftForwardApprovalStationHyperDivisionWise(String division_code);
			  


              @Query(value="select * from mdms_station.station_uncleansed_data where division_code=?1 and (cmi_status='U' OR dti_status='U') ",nativeQuery = true)
              List<StationUncleansedDataRepository> getPendingApprovalStationHyperDivisionWise(String division_code);


 //JYOTI BISHT 17-10-22
              
              @Query(value="select count(*) from mdms_station.station_uncleansed_data where (cmi_status='D' OR dti_status='D') and "
              		+ "((txn_date_cmi between ?1 and ?2)  or  (txn_date_dti between ?1 and ?2))",nativeQuery = true)
              int getStationDraft(Date from, Date to);

              
              @Query(value="select count(*) from mdms_station.station_uncleansed_data where (cmi_status='U' OR dti_status='U') and "
                		+ "((txn_date_cmi between ?1 and ?2)  or  (txn_date_dti between ?1 and ?2))",nativeQuery = true)
                int getStationPending(Date from, Date to);

			
		
			  
			  
//			  @Query(value="select division_code, count(*) as cleansed_count " + 
//				  		"from mdms_station.station_uncleansed_data where zone_code=?1 group by division_code",nativeQuery=true)
//			  Collection<DashBoardStationCountDivisionWiseModel> getTotalCleansedStationCountDivisionWise(String zone_code);
//		  
//			  
			 
//			  @Query(value=" select division_code,count(*) as draft_forward_approval_count\r\n"
//			  		+ "			  	from mdms_station.station_uncleansed_data where zone_code=?1 and cmi_status='D' OR dti_status='D' group by division_code\r\n"
//			  		+ "			",nativeQuery=true)
//			  Collection<DashBoardStationCountDivisionWiseModel> getTotalDraftForwardApprovalStationCountDivisionWise(String zone_code);
//			  

			  
//			  @Query(value="select t.division_code, count(*) as draft_forward_approval_count from\r\n" + 
//				  		"	(SELECT d.userid ,r.division_code  from  station.draft d,\r\n" + 
//				  		"	station.station_user_registration r\r\n" + 
//				  		"where d.userid=r.emp_id) t group by t.division_code",nativeQuery=true)
//				  Collection<DashBoardStationCountDivisionWiseModel> getTotalDraftForwardApprovalStationCountDivisionWise();
//				  

         	 // JYOTI BISHT 5-1-23  for dashboard without Login
        	  
         	 @Query(value="select * from mdms_station.station_uncleansed_data where (cmi_status=?3 or dti_status=?3) AND zone_code=?1 and division_code=?2 ",nativeQuery = true)
         	 List<StationUncleansedData>  getStationDetails(String zone, String division, String status);
         		


        	 // JYOTI BISHT 29-5-23  for station draft records
       	  
         	 @Query(value="select * from mdms_station.station_uncleansed_data where (user_id_dti=?1 or user_id_cmi=?1) and (dti_status='D' or cmi_status='D') ",nativeQuery = true)
         	 List<StationUncleansedData>  getDraftStationByUser(String user_id);


			  
			  
}


