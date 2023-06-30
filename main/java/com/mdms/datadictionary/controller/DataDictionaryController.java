
package com.mdms.datadictionary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mdms.datadictionary.model.DataDictionaryDocumentModel;
import com.mdms.datadictionary.model.ReferentialsDynamicmodel;
import com.mdms.datadictionary.model.StationDataDictionary;
import com.mdms.datadictionary.model.publishedToMdmdModel;
import com.mdms.datadictionary.service.DataDictionaryService;
@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")
@RestController
public class DataDictionaryController {
	@Autowired
	private DataDictionaryService dataDictionaryService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/getassetDocument")
	public List<DataDictionaryDocumentModel> getAssetData(@RequestBody DataDictionaryDocumentModel dataDictionaryDocumentModel) {
		List<DataDictionaryDocumentModel> listt = dataDictionaryService.findDataDictionaryDocument(dataDictionaryDocumentModel.getAssetName());
		System.out.println(dataDictionaryDocumentModel.getAssetName());
		System.out.println(listt);
		return listt;
		
	}

	//@Autowired
	//private StationDictionaryService stationDictionaryService;
	@RequestMapping(method = RequestMethod.POST, value = "/stationdata")
	public List<StationDataDictionary> getStationDictionaryData(
			@RequestBody StationDataDictionary stationDataDictionary) {
		List<StationDataDictionary> list = dataDictionaryService
				.findStationDictionaryData(stationDataDictionary.getAssetName());
		return list;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/publishedtomdms")
	public List<publishedToMdmdModel> getPublishedToMdmsData(@RequestBody publishedToMdmdModel PublishedToMdmdModel) {
		List<publishedToMdmdModel> list = dataDictionaryService.findPublishedToMdmsData(PublishedToMdmdModel.getPublisher(),PublishedToMdmdModel.getAsset_name());
		System.out.println(PublishedToMdmdModel.getPublisher());
		System.out.println(PublishedToMdmdModel.getAsset_name());
		return list;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/subscribetomdms")
	public List<publishedToMdmdModel> getSubscriberToMdmsData(@RequestBody publishedToMdmdModel PublishedToMdmdModel) {
		List<publishedToMdmdModel> list = dataDictionaryService
				.findSubscriberToMdmsData(PublishedToMdmdModel.getSubscriber(),PublishedToMdmdModel.getAsset_name());
		return list;
	}

	
	@RequestMapping(method = RequestMethod.GET, value = "/getgismasterdetail")
	public List<ReferentialsDynamicmodel> findRefrentialDynamicData(){		
		List<ReferentialsDynamicmodel> listt= dataDictionaryService.getRefrentialsDynamicData();		
		return listt;
	}
	
	
	


	




}
