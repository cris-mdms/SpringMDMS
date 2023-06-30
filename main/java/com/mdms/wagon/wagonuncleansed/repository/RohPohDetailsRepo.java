package com.mdms.wagon.wagonuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.wagon.wagonuncleansed.model.RohPohDetailsModel;
import com.mdms.wagon.wagonuncleansed.model.WagonDataIRWMS1;

public interface RohPohDetailsRepo extends CrudRepository<RohPohDetailsModel,String> {
	
	
	@Query(value="select roh_station,roh_date,poh_date,poh_workshop,poh_due_date from mdms_wagon.wagon_data_irwms \r\n"
			+ "where owningrly=?1 AND groupname=?2 AND vehicletype=?3 AND vehicleno=?4 and\r\n"
			+ "roh_date is not null and poh_date is not null", nativeQuery=true)
	List<RohPohDetailsModel> getRohPohData(String owningrly,String groupname,String vehicletype,Long vehicleno);

}
