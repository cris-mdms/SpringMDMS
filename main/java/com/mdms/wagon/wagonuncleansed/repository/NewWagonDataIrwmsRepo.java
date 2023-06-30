package com.mdms.wagon.wagonuncleansed.repository;

import java.util.List;

import org.bouncycastle.util.BigIntegers;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.wagon.wagonuncleansed.model.NewWagonDataIrwms;
import com.mdms.wagon.wagonuncleansed.model.WagonDataIRWMS1;

public interface NewWagonDataIrwmsRepo extends CrudRepository<NewWagonDataIrwms,Long> {
	
	@Query(value="SELECT DISTINCT vehicletype FROM mdms_wagon.wagon_data_irwms where owningrly=?1 and wagon_valid_flag='true' and status IN ('A','R','I')", nativeQuery=true)
	List<String> getvehicaltype(String ownngrly);
	
	@Query(value="SELECT DISTINCT vehicleno FROM mdms_wagon.wagon_data_irwms where vehicletype =?1 and owningrly=?2 and wagon_valid_flag='true' and status IN ('A','R','I')", nativeQuery=true)
	List<Long> getvehicalnumber(String vehicalno, String owningrly);
	
	
	@Query(value="SELECT DISTINCT owningrly FROM mdms_wagon.wagon_data_irwms where wagon_valid_flag='true' and status IN ('A','R','I') ", nativeQuery=true)
	List<NewWagonDataIrwms> getNewWagonDataIrwms();
	
	
	
	@Query(value="SELECT * FROM mdms_wagon.wagon_data_irwms where owningrly=?1 and vehicletype=?2 and vehicleno=?3", nativeQuery=true)
	List<NewWagonDataIrwms> getNewWagonDataIrwmsDetails(String owningrly,String vehicletype, Long vehicleno);


	@Query(value="SELECT vehicleno FROM mdms_wagon.wagon_data_irwms", nativeQuery=true)
	List<NewWagonDataIrwms> getVehicleNO();
	
	
	
	
	
}
