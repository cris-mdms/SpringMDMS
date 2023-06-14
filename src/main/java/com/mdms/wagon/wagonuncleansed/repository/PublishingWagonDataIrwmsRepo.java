package com.mdms.wagon.wagonuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.wagon.wagonuncleansed.model.PublishingWagonDataIrwmsModel;

public interface PublishingWagonDataIrwmsRepo extends CrudRepository<PublishingWagonDataIrwmsModel,Long> {
	
	@Query(value="select wagonid,vehicleno,owningrly,vehicletype,adb_timestamp,adb_l_delivery_status from mdms_wagon.p_wagon_data_irwms where vehicleno=?1 order by adb_timestamp desc;", nativeQuery=true)
	List<PublishingWagonDataIrwmsModel>getPublishingDataIrwms(Long vehicleno);

}
