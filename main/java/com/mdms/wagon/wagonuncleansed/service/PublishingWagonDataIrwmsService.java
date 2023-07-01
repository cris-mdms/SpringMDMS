package com.mdms.wagon.wagonuncleansed.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdms.wagon.wagonuncleansed.model.PublishingWagonDataIrwmsModel;

import com.mdms.wagon.wagonuncleansed.model.p_wagon_data_fmm;
import com.mdms.wagon.wagonuncleansed.repository.PublishingWagonDataIrwmsRepo;
import com.mdms.wagon.wagonuncleansed.repository.p_wagon_data_fmm_repo;

@Service
public class PublishingWagonDataIrwmsService {
	
	@Autowired
	private PublishingWagonDataIrwmsRepo publishingWagonDataIrwmsRepo;
	
	@Autowired
	private p_wagon_data_fmm_repo publishingWagonDataFMMRepo;
	
	
	public List<PublishingWagonDataIrwmsModel> FindPublishingDataIrwms(PublishingWagonDataIrwmsModel publishingWagonDataIrwmsModel){		
		return publishingWagonDataIrwmsRepo.getPublishingDataIrwms(publishingWagonDataIrwmsModel.getVehicleno());
		
	}

	
	public List<Object> gettotalpublishwagoncount(){
		return publishingWagonDataFMMRepo.gettotalpublishwagoncount();

}
}

