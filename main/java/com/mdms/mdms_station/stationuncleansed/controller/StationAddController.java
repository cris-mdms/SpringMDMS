/*This controller provides all services for adding new record in station golden master.
 * Created By : Anshul, 21-10-2020
 * 
 */
package com.mdms.mdms_station.stationuncleansed.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mdms.mdms_station.stationuncleansed.model.StationCleansedData;
import com.mdms.mdms_station.stationuncleansed.model.StationPKey;
import com.mdms.mdms_station.stationuncleansed.model.StationUncleansedData;
import com.mdms.mdms_station.stationuncleansed.service.StationAddService;
@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")

@RestController
public class StationAddController {
	@Autowired
	private StationAddService stn_add_serv;
	
	Logger logger=LoggerFactory.getLogger(StationAddController.class);

	
	@RequestMapping(method=RequestMethod.POST, value="/gldenmstr")
	public String checkStncodeExist(@RequestBody String station_code) throws Exception {

	/* 
	Developer – Ritu 
	*/
//	@RequestMapping(method=RequestMethod.POST, value="/checkstncodeexist")
//	public String checkStnCode(@RequestBody String station_code) throws Exception {

		 logger.error("controller : StationAddController || Method : checkStnCode || input recieved checkStnCode: "+station_code);		 
	return stn_add_serv.checkStncodeExist(station_code);	
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/savecmicleanseddraft")
	public  String saveCmiCleansedDraft(@RequestBody StationUncleansedData stationdraftcmi) throws Exception
	{	logger.error("controller : StationAddController || Method : saveCmiCleansedDraft || input recieved stationdraftcmi: "+stationdraftcmi);	
		return  stn_add_serv.saveCmiCleansedDraft(stationdraftcmi);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/stnclnsunaprvdcmi")
	public  String forwardToDCM(@RequestBody StationUncleansedData stationdataapprovebydcm) throws Exception
	{
		logger.error("controller : StationAddController || Method : forwardToDCM || input recieved stationdataapprovebydcm: "+stationdataapprovebydcm.getStn_Id().getStation_code());
		
		return stn_add_serv.forwardToDCM(stationdataapprovebydcm);
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/stationcodewithdivcode")
	public List<String> stationCodeDiv(@RequestBody String div) throws Exception {
		logger.info("controller : StationAddController || Method : stationCodeDiv  || input recieved : ", div);
		List<String> flag=stn_add_serv.stationCodeDiv(div);
		return flag;
	}
	

	@RequestMapping(method=RequestMethod.POST, value="/validstncode")
	public  StationPKey getvalidstn(@RequestBody String station_code) throws Exception
	{
		logger.error("controller : StationAddController || Method : getvalidstn || input recieved  "+station_code);		
		return stn_add_serv.getvalidstation(station_code);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/draftdti")
	public  StationUncleansedData getDraftUncleansedDti(@RequestParam (value="useriddti") String useriddti ,  @RequestParam(value="station_code") String station_code ) throws Exception
	{
		logger.error("controller : StationAddController || Method : getDraftUncleansedDti || input recieved  "+useriddti+", "+station_code);	
		return stn_add_serv.getDraftDti(useriddti,station_code);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/updatedtidraft")
	public  String updateDtiDraft(@RequestBody StationUncleansedData stationdraftdti) throws Exception
	{
		logger.error("controller : StationAddController || Method : updateDtiDraft || input recieved stationdraftdti: "+stationdraftdti.getStn_Id().getStation_code());		
		return stn_add_serv.updateDtiDraft(stationdraftdti);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/forwardtoapprovedti")
	public  String forwardDTIToDOM(@RequestBody StationUncleansedData stationdtiapprovebydcm) throws Exception
	{
		logger.error("controller : StationAddController || Method : forwardDTIToDCM || input recieved stationdataapprovebydcm: "+stationdtiapprovebydcm.getStn_Id().getStation_code());
				return stn_add_serv.forwardDTIDraft(stationdtiapprovebydcm);
	}
	
	
}
