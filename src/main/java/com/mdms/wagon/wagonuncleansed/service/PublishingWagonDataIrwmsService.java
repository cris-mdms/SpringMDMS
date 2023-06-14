package com.mdms.wagon.wagonuncleansed.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdms.wagon.wagonuncleansed.model.PublishingWagonDataIrwmsModel;
import com.mdms.wagon.wagonuncleansed.repository.PublishingWagonDataIrwmsRepo;

@Service
public class PublishingWagonDataIrwmsService {
	
	@Autowired
	private PublishingWagonDataIrwmsRepo publishingWagonDataIrwmsRepo;
	
	
	public List<PublishingWagonDataIrwmsModel> FindPublishingDataIrwms(PublishingWagonDataIrwmsModel publishingWagonDataIrwmsModel){
		
		return publishingWagonDataIrwmsRepo.getPublishingDataIrwms(publishingWagonDataIrwmsModel.getVehicleno());
		
	}


}
