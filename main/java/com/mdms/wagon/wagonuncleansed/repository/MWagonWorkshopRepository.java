package com.mdms.wagon.wagonuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.mdms.wagon.wagonuncleansed.model.MWagonWorkshop;

public interface MWagonWorkshopRepository extends CrudRepository<MWagonWorkshop,Long>{
	// Developer : Ritu - service to fetch wagon_workshop data   18.10.21
 @Query(value="SELECT * from mdms_wagon.m_wagon_workshop", nativeQuery=true)
List<MWagonWorkshop> getWagonWorkshop();

}
