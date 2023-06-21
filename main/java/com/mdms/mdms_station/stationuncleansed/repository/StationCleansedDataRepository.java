package com.mdms.mdms_station.stationuncleansed.repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.dahsboard.model.DashBoardStationCountDivisionWiseModel;
import com.mdms.mdms_station.stationuncleansed.model.StationCleansedData;
import com.mdms.mdms_station.stationuncleansed.model.StationPKey;
import com.mdms.mdms_station.stationuncleansed.model.StationUncleansedData;




public interface StationCleansedDataRepository extends CrudRepository <StationCleansedData,StationPKey>{	

	@Query(value="select * FROM mdms_station.station_uncleansed_data where  station_code=?1", nativeQuery = true)
	StationCleansedData findByStncode(String stationdatadcm);
	
	@Query(value="select station_code  from mdms_station.station_cleansed_data where station_code=?1",nativeQuery=true)
	String   checkStnCodeExist(String stncode);
	
//	@Transactional
//@Modifying
//	@Query(value="INSERT INTO mdms_station.station_cleansed_data(\r\n"
//			+ "	station_code,\r\n"
//			+ "	station_numeric_code,\r\n"
//			+ "	station_name, \r\n"
//			+ "	traffic_type, \r\n"
//			+ "	transhipment_flag,\r\n"
//			+ "	station_valid_from,\r\n"
//			+ "	station_valid_upto,\r\n"
//			+ "	zone_code,\r\n"
//			+ "	division_code,\r\n"
//			+ "	gauge_code,\r\n"
//			+ "	latitude,\r\n"
//			+ "	longitude, \r\n"
//			+ "	station_class,\r\n"
//			+ "	junction_flag,\r\n"
//			+ "	interchange_flag,\r\n"
//			+ "	state, \r\n"
//			+ "	pincode,\r\n"
//			+ "	district,\r\n"
//			+ "	tehsil, \r\n"
//			+ "	station_category,\r\n"
//			+ "	station_short_name,\r\n"
//			+ "	interlocking_standard,\r\n"
//			+ "	traction,\r\n"
//			+ "	working_division, \r\n"
//			+ "	no_of_lines,\r\n"
//			+ "	weight_bridge,\r\n"
//			+ "	siding, \r\n"
//			+ "	booking_type,\r\n"
//			+ "	record_status, \r\n"
//			+ "	cmi_status,\r\n"
//			+ "	dti_status, \r\n"
//			+ "	user_id_cmi,\r\n"
//			+ "	user_id_dti,\r\n"
//			+ "	txn_date_cmi,\r\n"
//			+ "	txn_date_dti,\r\n"
//			+ "	operating_station_signal)\r\n"
//			+ "	VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12, ?13, ?14, ?15, ?16, "
//			+ "?17, ?18, ?19, ?20, ?21, ?22, ?23, ?24, ?25, ?26, ?27, ?28, ?29, ?30, ?31, ?32, ?33, ?34, ?35, ?36)",nativeQuery=true)
//	void save();
	
	  @Query(value="select division_code, count(*) as cleansed_count " + 
		  		"from mdms_station.station_cleansed_data where zone_code=?1 group by division_code",nativeQuery=true)
	  Collection<DashBoardStationCountDivisionWiseModel> getTotalCleansedStationCountZoneDivisionWise(String zone_code);

	  
// Shilpi 23-03-2021
	 @Query(value="select zone_code,division_code, count(*) as cleansed_count " + 
		  		"from mdms_station.station_cleansed_data where zone_code=?1 group by 1,2 ORDER BY 2",nativeQuery=true)
	  Collection<DashBoardStationCountDivisionWiseModel> getTotalCleansedStationCountZoneWise(String zone_code);
	 
	 //Shilpi 04-03-2021
	  
	  @Query(value="select division_code, count(*) as cleansed_count " + 
		  		"from mdms_station.station_cleansed_data where division_code=?1 group by division_code",nativeQuery=true)
	  Collection<DashBoardStationCountDivisionWiseModel> getTotalCleansedStationCountSingleDivisionWise(String division_code);
 
	  //end changes
	


	//Shilpi 09-04-2021 zonal hyperlink
	  
	  @Query(value="select * from mdms_station.station_cleansed_data where division_code=?1 ",nativeQuery=true)
	  StationCleansedData getTotalCleansedStationHyperDivisionWise(String division_code);

	  
	  
	  // JYOTI BISHT 17-10-22

	  @Query(value="select count(*) from mdms_station.station_cleansed_data where (cmi_status='A' OR dti_status='A') and "
      		+ "((txn_date_cmi between ?1 and ?2)  or  (txn_date_dti between ?1 and ?2))",nativeQuery = true)
      int getStationApproved(Date from, Date to);
	  
		 // JYOTI BISHT 5-1-23  for dashboard without Login
	  
  	 @Query(value="select * from mdms_station.station_cleansed_data where (cmi_status=?3 or dti_status=?3) AND zone_code=?1 and division_code=?2 ",nativeQuery = true)
   	 List<StationCleansedData>  getStationDetails(String zone, String division, String status);

	void saveAndFlush(StationCleansedData stncldata);

	  
	}



	





