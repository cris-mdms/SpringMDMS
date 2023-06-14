/*Created By : Ritu, 19-07-2021 */
package com.mdms.wagon.wagonuncleansed.repository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.wagon.wagonuncleansed.model.VehicleNo;
import com.mdms.wagon.wagonuncleansed.model.WagonUncleansedData;
public interface WagonUncleansedRepository extends CrudRepository<WagonUncleansedData,Long>{	
	// Developer : ritu - service to fetch cleansed record based on status (D/R/U) 19.5.21
	@Query(value="select * from mdms_wagon.wagon_uncleansed_data where base_depo_station=?1 and status=?2", nativeQuery=true)
	List<WagonUncleansedData> getWagonCleansedRecord(String basedepo , String status);

	@Query(value="SELECT * FROM  mdms_wagon.wagon_uncleansed_data WHERE wagon_no=?1 and status in ('D','R') ", nativeQuery=true)
	List<WagonUncleansedData>  checkwagonexist(BigInteger wgnno);
	
@Transactional
	@Modifying
	@Query(value="UPDATE mdms_wagon.wagon_uncleansed_data  SET wagon_type=?1, wagon_owning_rly=?2, "
			+ "orgnization_type=?3, wagon_rfid1=?4, wagon_rfid2=?5, wagon_class_group=?6, wagon_tare=?7, wagon_carrying_capacity=?8, "
			+ "wagon_scheme_name=?9,wagon_manufacture_code=?10, wagon_status=?11, "
			+ "status=?12, remarks=?13, user_id=?14,  wagon_manufacture_date=?15, wagon_co_owner=?16, base_depo_station=?17,"
			+ " stock_type_code=?18,  manufacturing_country=?19,  wagonno_old=?20, wagon_manufacture_year=?21, "
			+ "alloted_by=?22, allotment_no=?23, allotment_date=?24	,txn_date=?25,wagon_gauge_code=?26 WHERE wagon_no=?27", nativeQuery=true)
int updatewagondraft( String wgntype, String rly, String orgtype,
		String rfid1,String rfid2, String clasgroup , Long tarewght, Long carrycap, 
		String scheme, Integer mfgcode, String  wgnstatus, String status, String remarks, 
		String uid,  Date mfgdt,  String coowner, String basestn, String stcktypecode, 
		String mfgcountry, BigInteger wgnoldno, String mfgyr, String allotedby, String alloteno, Date alloteddt, Date txndate, String gaugecode, BigInteger wagonno );

	
@Query(value="SELECT DISTINCT wagon_no FROM mdms_wagon.wagon_uncleansed_data where wagon_type =?1 and wagon_owning_rly=?2 and wagon_class_group=?3  and status IN ('D','R') and record_status='O'", nativeQuery=true)
List<WagonUncleansedData> getdraftVehicleNO(String vehivletype,String owningrly, String groupname);

	
}
