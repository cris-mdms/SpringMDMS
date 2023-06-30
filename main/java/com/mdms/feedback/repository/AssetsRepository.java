package com.mdms.feedback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.mdms.feedback.model.AssetsModel;


public interface AssetsRepository extends CrudRepository<AssetsModel,Long>{
	@Transactional
	@Query(value ="	Select * FROM mdms_feedback.assets_master WHERE \"asset_name\"=?1",nativeQuery=true)
	List<AssetsModel> findAllModule(String aName);	


}
