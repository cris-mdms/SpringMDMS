package com.mdms.datadictionary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdms.datadictionary.model.DataDictionaryDocumentModel;
import com.mdms.datadictionary.model.ReferentialsDynamicmodel;
import com.mdms.datadictionary.model.StationDataDictionary;
import com.mdms.datadictionary.model.publishedToMdmdModel;
import com.mdms.datadictionary.repository.DataDictionaryRepo;
import com.mdms.datadictionary.repository.PublishedTOMdmsRepo;
import com.mdms.datadictionary.repository.RefrentialDynamicTableRepo;
import com.mdms.datadictionary.repository.StationDataDictionaryRepo;
import com.mdms.datadictionary.repository.PublishedTOMdmsRepo;


@Service
public class DataDictionaryService {	
	@Autowired
	private DataDictionaryRepo dataDictionaryRepo;
	
	@Autowired
	private StationDataDictionaryRepo stationDataDictionaryRepo;
	
	
	@Autowired
	private PublishedTOMdmsRepo publishedTOMdmsRepo;

	


	@Autowired
	private RefrentialDynamicTableRepo refrentialDynamicTableRepo;

	public List<DataDictionaryDocumentModel> findDataDictionaryDocument(String assetName){		
		List<DataDictionaryDocumentModel> dataDictionaryDocument = dataDictionaryRepo.getAssetDetail(assetName);
		System.out.print("amit its a new service");
		System.out.print(assetName);
		return dataDictionaryDocument;
		
	}
	
	
	public List<StationDataDictionary> findStationDictionaryData(String assetName){
		
		
		List<StationDataDictionary> stationDictionaryData= stationDataDictionaryRepo.getStationDataDictionary(assetName);
		return stationDictionaryData;
	}
	
	
	public List<publishedToMdmdModel> findPublishedToMdmsData(String attribute, String asset_name){
		
		List<publishedToMdmdModel> publishtoMdms= publishedTOMdmsRepo.getPublishToMdms(attribute, asset_name);
		return publishtoMdms;
	}
	

//public List<publishedToMdmdModel> findSubscriberToMdmsData(String attribute, String asset_name){
//		
//		List<publishedToMdmdModel> publishtoMdms= publishedTOMdmsRepo.getSubscriberoMdms(attribute, asset_name);
//		return publishtoMdms;
//	}

	
	

public List<ReferentialsDynamicmodel> getRefrentialsDynamicData(){
		
		List<ReferentialsDynamicmodel> list4= refrentialDynamicTableRepo.getRefrentialDynamicData();
		
		return list4;
}

	public List<publishedToMdmdModel> findSubscriberToMdmsData(String attribute, String asset_name){
			
			List<publishedToMdmdModel> publishtoMdms= publishedTOMdmsRepo.getSubscriberoMdms(attribute, asset_name);
			return publishtoMdms;
		}
	
		
		
	
//	public List<ReferentialsDynamicmodel> getRefrentialsDynamicData(){
//			
//			List<ReferentialsDynamicmodel> list4= refrentialDynamicTableRepo.getRefrentialDynamicData();
//			
//			return list4;
//			
//		}
	
	// JYOTI BISHT 28-3-23 DATA COLLATION
	public List<StationDataDictionary> getAttributes(String asset, String group)
	{
		String asset_group=asset+"_"+group;
		List<StationDataDictionary> stationDictionaryData= stationDataDictionaryRepo.getFilteredAttributes(asset, asset_group);
		return stationDictionaryData;

		
	}


}
