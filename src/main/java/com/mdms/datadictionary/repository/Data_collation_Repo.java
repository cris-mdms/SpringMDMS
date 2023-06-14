package com.mdms.datadictionary.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mdms.datadictionary.model.MD_DataCollation;

@Repository
public interface Data_collation_Repo extends CrudRepository<MD_DataCollation, Integer> {

}
