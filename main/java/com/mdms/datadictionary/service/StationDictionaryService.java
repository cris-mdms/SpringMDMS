
package com.mdms.datadictionary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mdms.datadictionary.model.StationDataDictionary;
import com.mdms.datadictionary.repository.StationDataDictionaryRepo;

@Service
public class StationDictionaryService {

	@Autowired
	//@Qualifier("StationDataDictionaryRepo")
	private StationDataDictionaryRepo stationDataDictionaryRepo;
	
	
	/*public List<StationDataDictionary> findStationDictionaryData(){
		
		List<StationDataDictionary> stationDictionaryData= stationDataDictionaryRepo.getStationDataDictionary();
		
		return stationDictionaryData;
		
	}*/
	
	
	public List<StationDataDictionary> findStationDictionaryData(String assetName){		
		List<StationDataDictionary> stationDictionaryData= stationDataDictionaryRepo.getStationDataDictionary(assetName);
		return stationDictionaryData;
	}
	
	
	
	
	
	
	
	
}

/*
 * package com.mdms.datadictionary.service;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.beans.factory.annotation.Qualifier; import
 * org.springframework.stereotype.Service;
 * 
 * import com.mdms.datadictionary.model.StationDataDictionary; import
 * com.mdms.datadictionary.repository.StationDataDictionaryRepo;
 * 
 * @Service public class StationDictionaryService {
 * 
 * @Autowired //@Qualifier("StationDataDictionaryRepo") private
 * StationDataDictionaryRepo stationDataDictionaryRepo;
 * 
 * 
 * public List<StationDataDictionary> findStationDictionaryData(){
 * 
 * List<StationDataDictionary> stationDictionaryData=
 * stationDataDictionaryRepo.getStationDataDictionary();
 * 
 * return stationDictionaryData;
 * 
 * }
 * 
 * 
 * public List<StationDataDictionary> findStationDictionaryData(String
 * assetName){
 * 
 * 
 * List<StationDataDictionary> stationDictionaryData=
 * stationDataDictionaryRepo.getStationDataDictionary(assetName); return
 * stationDictionaryData; }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * }
 */

