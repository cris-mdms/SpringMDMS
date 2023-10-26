package com.mdms.loco.locouncleansed.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mdms.loco.locouncleansed.model.LocoDataSlam;

@Repository
public interface LocoDataSlamRepository extends CrudRepository<LocoDataSlam, Integer>{

}
