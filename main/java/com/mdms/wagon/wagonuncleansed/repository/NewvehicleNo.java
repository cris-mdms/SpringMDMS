package com.mdms.wagon.wagonuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.mdms.wagon.wagonuncleansed.model.VehicleNo;

public interface NewvehicleNo extends CrudRepository<VehicleNo,Long>{
	
	@Query(value="SELECT DISTINCT vehicleno FROM mdms_wagon.wagon_data_irwms where vehicletype =?1 and owningrly=?2 and groupname=?3 and  wagon_valid_flag='true' and status IN ('A','R','I') and clean_status is Null", nativeQuery=true)
	List<VehicleNo> getVehicleNO(String vehivletype,String owningrly, String groupname);
	
	
	@Query(value="SELECT DISTINCT vehicleno FROM mdms_wagon.wagon_data_irwms where vehicletype =?1 and owningrly=?2 and groupname=?3 and roh_date is not null and poh_date is not null and wagon_valid_flag='true' and status IN ('A','R','I')", nativeQuery=true)
	List<VehicleNo> getRohPohVehicleNO(String vehivletype,String owningrly, String groupname);

}
