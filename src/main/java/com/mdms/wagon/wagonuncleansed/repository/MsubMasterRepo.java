package com.mdms.wagon.wagonuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mdms.wagon.wagonuncleansed.model.FoisWagonTxn;
import com.mdms.wagon.wagonuncleansed.model.Msubmastermodel;


@Repository("msubMasterRepo")
public interface MsubMasterRepo extends CrudRepository<Msubmastermodel,String> {
	
	
	
	@Query(value="SELECT * FROM mdms_wagon.m_orgnization_type;", nativeQuery=true)
	List<Msubmastermodel> getsubMasterdata();

}
