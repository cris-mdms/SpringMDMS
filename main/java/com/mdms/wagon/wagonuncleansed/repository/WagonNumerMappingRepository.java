package com.mdms.wagon.wagonuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.mdms.wagon.wagonuncleansed.model.WagonNumberMapping;
import com.mdms.wagon.wagonuncleansed.model.WagonUncleansedData;

public interface WagonNumerMappingRepository extends CrudRepository<WagonNumberMapping,Long>{
	
	// Developer : ritu - service to fetch wagon detail and check wagon number exist with status (D) 02.9.21
		@Query(value="SELECT * FROM mdms_wagon.wagon_number_mapping", nativeQuery=true)
		List<WagonNumberMapping> getAllWagonDetail();
	
		
		// Developer : ritu - service to Delete record already exist wagon with status (D) 02.9.21
		@Transactional
		@Modifying
		@Query(value="DELETE FROM mdms_wagon.wagon_number_mapping WHERE irwms_wagon_no=?1", nativeQuery=true)
		void deleteWagonrecord(String irwmswagonno);

				

			
}
