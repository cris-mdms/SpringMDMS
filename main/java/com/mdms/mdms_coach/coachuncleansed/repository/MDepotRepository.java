package com.mdms.mdms_coach.coachuncleansed.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.mdms.mdms_coach.coachuncleansed.model.MDepot;
public interface MDepotRepository  extends CrudRepository<MDepot,String> {
	
	
	@Query(value="select depo_code from mdms_coach.m_depo ",nativeQuery = true)
	List<String> getDepotTypes();

}
