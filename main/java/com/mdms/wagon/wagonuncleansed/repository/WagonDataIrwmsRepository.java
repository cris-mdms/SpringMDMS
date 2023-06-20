package com.mdms.wagon.wagonuncleansed.repository;

import java.math.BigInteger;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.wagon.wagonuncleansed.model.VehicleNo;
import com.mdms.wagon.wagonuncleansed.model.WagonDataIRWMS1;
//import com.mdms.wagon.wagonuncleansed.model.WagonDataIrwms;

public interface WagonDataIrwmsRepository extends CrudRepository<WagonDataIRWMS1,Long> {
	// Developer : ritu - service to fetch IRWMS wagon number based on own_rly and wagon_type  27.8.21
		@Query(value="select vehicleno from mdms_wagon.wagon_data_irwms where owningrly=?1 and vehicletype =?2", nativeQuery=true)
		List<BigInteger> getIrwmsWagonNumber(String ownrly, String wagontype);
		
		@Query(value="SELECT DISTINCT groupname FROM mdms_wagon.wagon_data_irwms where  owningrly=?1 and wagon_valid_flag='true' and status IN ('A','R','I')", nativeQuery=true)
		List<String> getgroupname(String rly);
		
		
		@Transactional	
		@Modifying
		@Query(value="UPDATE   mdms_wagon.wagon_data_irwms SET clean_status='D' WHERE vehicleno =?1", nativeQuery=true)
		int updateirwmsstatus(Long wagonno);


		
}
