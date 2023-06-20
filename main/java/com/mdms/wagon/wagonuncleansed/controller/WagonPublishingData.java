package com.mdms.wagon.wagonuncleansed.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mdms.wagon.wagonuncleansed.model.PublishingWagonDataIrwmsModel;
import com.mdms.wagon.wagonuncleansed.service.PublishingWagonDataIrwmsService;
@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")

@RestController
public class WagonPublishingData {
	@Autowired
	PublishingWagonDataIrwmsService publishingWagonDataIrwmsService;
	
	@RequestMapping(method=RequestMethod.POST, value = "/getpublishedwagondata")
	public List<PublishingWagonDataIrwmsModel> getPublishingData(@RequestBody PublishingWagonDataIrwmsModel publishingWagonDataIrwmsModel){		
		//System.out.println(publishingWagonDataIrwmsModel.getVehicleno());
		return publishingWagonDataIrwmsService.FindPublishingDataIrwms(publishingWagonDataIrwmsModel);
		
	}


}
