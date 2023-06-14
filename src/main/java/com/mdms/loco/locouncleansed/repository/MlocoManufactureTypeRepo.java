package com.mdms.loco.locouncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.loco.locouncleansed.model.MlocoManufactureType;

public interface MlocoManufactureTypeRepo extends CrudRepository<MlocoManufactureType,String> {
	
	@Query(value="SELECT * from mdms_loco.m_loco_manufacturer",nativeQuery=true)
	List<MlocoManufactureType> getlocomake();

}
