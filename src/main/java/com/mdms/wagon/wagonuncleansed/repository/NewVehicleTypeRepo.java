package com.mdms.wagon.wagonuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.mdms.wagon.wagonuncleansed.model.NewVehicleType;

public interface NewVehicleTypeRepo extends CrudRepository<NewVehicleType,String> {
	
	@Query(value="SELECT DISTINCT vehicletype FROM mdms_wagon.wagon_data_irwms where owningrly=?1 and groupname=?2 and  wagon_valid_flag='true' and status IN ('A','R','I')", nativeQuery=true)
	List<NewVehicleType> getVehicleTypeData(String owningrly, String groupname);

}
