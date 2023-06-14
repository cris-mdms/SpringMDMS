package com.mdms.mdms_masters.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.mdms_masters.model.MDepartment;

public interface MDepartmentRepository extends CrudRepository<MDepartment,Long>{
	
	@Query(value="SELECT * FROM mdms_masters.m_department", nativeQuery = true)
	List<MDepartment> findDept(); 

}
