package com.mdms.mdms_masters.repository;

import org.springframework.data.repository.CrudRepository;
import com.mdms.mdms_masters.model.MDivision;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface MDivisionRepository extends CrudRepository<MDivision,String> {

	
	@Query(value="Select * from mdms_masters.m_division", nativeQuery = true)
	List<MDivision> getAllDivision();
		
	@Query(value="Select division_sr_no from mdms_masters.m_division where division_code=?1", nativeQuery = true)
	int getDivsionCode(String division);
	

	@Query(value="Select * from mdms_masters.m_division where zone_code=?1 order by division_code", nativeQuery = true)
	List<MDivision> findByZoneCode(String zone_code); 
	
	@Query(value="select zone_code from mdms_masters.m_division where division_code=?1", nativeQuery = true)
	String findByDivCode(String div_code); 
	
	@Query(value="select * from mdms_masters.m_division where zone_code=?1 ", nativeQuery = true)
	List<MDivision> getZonewiseDivision(String zc);
	

	@Query(value="select division_code from mdms_masters.m_division where zone_code=?1 ", nativeQuery = true)
	List<String> getZonewiseDivisionCode(String zc);


	
	


}
