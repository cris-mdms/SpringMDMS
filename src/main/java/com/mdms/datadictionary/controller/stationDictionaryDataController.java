
package com.mdms.datadictionary.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.mdms.datadictionary.model.StationDataDictionary;
import com.mdms.datadictionary.service.StationDictionaryService;
@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false")
@RestController
public class stationDictionaryDataController {
	Logger logger=LoggerFactory.getLogger(stationDictionaryDataController.class);
	//  @Autowired
	 // @Qualifier("stationDictionaryService")
	/*  private StationDictionaryService stationDictionaryService;
	  
	 
	  @RequestMapping(method=RequestMethod.GET, value="/stationdata")
	  public List<StationDataDictionary> getStationDictionaryData(HttpSession
	  session, HttpServletRequest request) {
		  List<StationDataDictionary> list = stationDictionaryService.findStationDictionaryData();
		  return list;
		  
	  }*/
	  
//	  @Autowired
//	  private StationDictionaryService stationDictionaryService;	  
//	  
//	  @RequestMapping(method=RequestMethod.POST, value="/stationdata")
//	  public List<StationDataDictionary> getStationDictionaryData(@RequestBody StationDataDictionary stationDataDictionary) {
//		  logger.info("----------/datadictionary");
//		  List<StationDataDictionary> list = stationDictionaryService.findStationDictionaryData(stationDataDictionary.getAssetName());
//		  return list;
//	  
//	  }
}

/*
 * package com.mdms.datadictionary.controller;
 * 
 * import java.util.List;
 * 
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpSession;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.beans.factory.annotation.Qualifier; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.mdms.datadictionary.model.StationDataDictionary; import
 * com.mdms.datadictionary.service.StationDictionaryService;
 * 
 * 
 * @RestController
 * 
 * @RequestMapping("datadictionary") public class
 * stationDictionaryDataController {
 * 
 * // @Autowired // @Qualifier("stationDictionaryService") private
 * StationDictionaryService stationDictionaryService;
 * 
 * 
 * @RequestMapping(method=RequestMethod.GET, value="/stationdata") public
 * List<StationDataDictionary> getStationDictionaryData(HttpSession session,
 * HttpServletRequest request) { List<StationDataDictionary> list =
 * stationDictionaryService.findStationDictionaryData(); return list;
 * 
 * }
 * 
 * @Autowired private StationDictionaryService stationDictionaryService;
 * 
 * @RequestMapping(method=RequestMethod.POST, value="/stationdata") public
 * List<StationDataDictionary> getStationDictionaryData(@RequestBody
 * StationDataDictionary stationDataDictionary) { List<StationDataDictionary>
 * list =
 * stationDictionaryService.findStationDictionaryData(stationDataDictionary.
 * getAssetName()); return list;
 * 
 * } }
 */

