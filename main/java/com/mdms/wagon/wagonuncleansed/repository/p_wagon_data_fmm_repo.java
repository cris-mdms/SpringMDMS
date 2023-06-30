package com.mdms.wagon.wagonuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.wagon.wagonuncleansed.model.p_wagon_data_fmm;

public interface p_wagon_data_fmm_repo extends CrudRepository<p_wagon_data_fmm,Long>{

	@Query(value="select 'WAGON-PUBLISHING',cast(adb_timestamp as date) as WAGON_publishing_date ,COALESCE( count(distinct wagonid ),0) "
			+ "as total_wagon from mdms_wagon.p_wagon_data_fmm  where adb_timestamp >=current_date  group by 1,2",nativeQuery=true)
	List<Object> gettotalpublishwagoncount();
	
//	@Query(value="select count(distinct vehicleno ) from mdms_wagon.p_wagon_data_fmm where adb_l_delivery_status='C'", nativeQuery=true)
//	List<Object> gettotalpublishwagoncount();
	
}
