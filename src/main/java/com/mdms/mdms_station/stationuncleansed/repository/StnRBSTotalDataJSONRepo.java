package com.mdms.mdms_station.stationuncleansed.repository;

import java.util.List;

//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import com.mdms.mdms_station.stationuncleansed.model.StnRBSTotalDataJSON;
//public interface StnRBSTotalDataJSONRepo extends CrudRepository<StnRBSTotalDataJSON, Long>{
////	 @Query(value="select a.stn_name, a.stn_code, a.category, \r\n"
////	    		+ "b.division_code, b.division_name, b.zone_code, a.district_code,a.state_code,a.gauge_type,a.pin_code,a.tehsil,a.traffic_type ,c.district_name,c.state_name,\r\n"
////	    		+ "a.stn_vld_upto,a.stn_vld_from "
////	    		+ "from MDMS_station.station_table_rbs a join mdms_station.rbs_division b on a.div_ser_no=b.division_ser_no join  mdms_masters.m_district c on c.district_code=a.district_code "
////	    		+ "where current_date between stn_vld_from and stn_vld_upto ",  nativeQuery = true)
////	    		List<StnRBSTotalDataJSON> findAll();
//}
