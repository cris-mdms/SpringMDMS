package com.mdms.wagon.wagonuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.mdms.wagon.wagonuncleansed.model.IRWMS_Wagon_Type_Mapping_with_Fmm;

public interface IRWMS_Wagon_Type_Mapping_With_Fmm_Repository extends CrudRepository<IRWMS_Wagon_Type_Mapping_with_Fmm, Long> {	
	@Query(value="SELECT * FROM mdms_wagon.irwms_wagon_type_mapping_with_fmm", nativeQuery=true)
	List<IRWMS_Wagon_Type_Mapping_with_Fmm> getirwmsmappingdatawithfmm();
}
