package com.mdms.wagon.wagonuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.wagon.wagonuncleansed.model.NewOwningrly;


public interface NewOwningrlyRepo extends CrudRepository<NewOwningrly,String> {	
	@Query(value="SELECT DISTINCT owningrly FROM mdms_wagon.wagon_data_irwms where wagon_valid_flag='true' and status IN ('A','R','I')", nativeQuery=true)
	List<NewOwningrly> getOwingrlyData();

}
