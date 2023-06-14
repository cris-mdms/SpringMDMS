package com.mdms.wagon.wagonuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.wagon.wagonuncleansed.model.MwagonGaugeModel;

public interface MwagonGagueRepo  extends CrudRepository<MwagonGaugeModel,String> {
	
	
	
	@Query(value="SELECT * FROM mdms_wagon.m_wagon_gauge;", nativeQuery=true)
	List<MwagonGaugeModel> getMwagonGaguedata();

}
