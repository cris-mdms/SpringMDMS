package com.mdms.wagon.wagonuncleansed.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.mdms.wagon.wagonuncleansed.model.WagonCleansedData;
import com.mdms.wagon.wagonuncleansed.model.WagonUncleansedData;

public interface WagonCleansedRepository extends CrudRepository<WagonCleansedData,Long>{	
	
						

}


