package com.mdms.wagon.wagonuncleansed.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdms.wagon.wagonuncleansed.model.PublishingWagonDataIrwmsModel;
<<<<<<< HEAD
import com.mdms.wagon.wagonuncleansed.model.p_wagon_data_fmm;
import com.mdms.wagon.wagonuncleansed.repository.PublishingWagonDataIrwmsRepo;
import com.mdms.wagon.wagonuncleansed.repository.p_wagon_data_fmm_repo;
=======
import com.mdms.wagon.wagonuncleansed.repository.PublishingWagonDataIrwmsRepo;
>>>>>>> a796579cb9d19590a212ed54e6e06c965fa48879

@Service
public class PublishingWagonDataIrwmsService {
	
	@Autowired
	private PublishingWagonDataIrwmsRepo publishingWagonDataIrwmsRepo;
	
<<<<<<< HEAD
	@Autowired
	private p_wagon_data_fmm_repo publishingWagonDataFMMRepo;
	
	
	public List<PublishingWagonDataIrwmsModel> FindPublishingDataIrwms(PublishingWagonDataIrwmsModel publishingWagonDataIrwmsModel){		
=======
	
	public List<PublishingWagonDataIrwmsModel> FindPublishingDataIrwms(PublishingWagonDataIrwmsModel publishingWagonDataIrwmsModel){
		
>>>>>>> a796579cb9d19590a212ed54e6e06c965fa48879
		return publishingWagonDataIrwmsRepo.getPublishingDataIrwms(publishingWagonDataIrwmsModel.getVehicleno());
		
	}

<<<<<<< HEAD
	
	public List<Object> gettotalpublishwagoncount(){
		return publishingWagonDataFMMRepo.gettotalpublishwagoncount();

}
}
=======

}
>>>>>>> a796579cb9d19590a212ed54e6e06c965fa48879
