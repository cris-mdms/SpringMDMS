package com.mdms.wagon.wagonuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.mdms.wagon.wagonuncleansed.model.FoisWagonTxn;
public interface FoisWagonTxnRepository extends CrudRepository<FoisWagonTxn,Long>{
	// Developer : ritu - service to fetch wagon number based on own_rly and wagon_type  27.8.21
	@Query(value="SELECT wagon_no FROM mdms_wagon.fois_wagon_txn WHERE wagon_no LIKE %?1%", nativeQuery=true)
	List<String> getFoisWagonNumber(String wagonno);

}
