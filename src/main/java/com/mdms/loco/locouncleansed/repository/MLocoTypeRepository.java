package com.mdms.loco.locouncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.mdms.loco.locouncleansed.model.MLocoType;

public interface MLocoTypeRepository extends CrudRepository<MLocoType,Long>{

	
	
	
	  @Query(value="SELECT * FROM mdms_loco.m_loco_type WHERE loco_type=?1"
	  ,nativeQuery=true) List<MLocoType> getallLocotypedata(String locotype);
	 
	 
	
	
	  @Query(value="SELECT * FROM mdms_loco.m_loco_type",nativeQuery=true)
	  List<MLocoType> getallLocotype();
	 
	 
}
