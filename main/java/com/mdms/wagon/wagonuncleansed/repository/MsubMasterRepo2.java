package com.mdms.wagon.wagonuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.wagon.wagonuncleansed.model.MsubMaster2Model;


public interface MsubMasterRepo2 extends CrudRepository<MsubMaster2Model,String> {
	
	@Query(value="SELECT * FROM mdms_wagon.m_wagon_class_group;", nativeQuery=true)
	List<MsubMaster2Model> getsubmaster2Data();

}
