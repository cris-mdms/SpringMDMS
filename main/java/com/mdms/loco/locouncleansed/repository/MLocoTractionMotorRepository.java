package com.mdms.loco.locouncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.loco.locouncleansed.model.MLocoTractionMotor;


public interface MLocoTractionMotorRepository extends CrudRepository<MLocoTractionMotor,Long>{
	
	@Query(value="SELECT * FROM mdms_loco.m_loco_traction_motor",nativeQuery =true)	
	List<MLocoTractionMotor> findmotorcode();
	

}
