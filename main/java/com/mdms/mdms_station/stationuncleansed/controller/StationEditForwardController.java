/*This controller provides all services for cleansing of station.
 * Data is first fetched from RBS Master and shown to user on the basis of its division.
 * User corrects the input forward for approving to its approving authority
 * Created By : Anshul, 21-10-2020
 * 
 */
package com.mdms.mdms_station.stationuncleansed.controller;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.mdms.loco.locouncleansed.model.LocoApprovedData;
import com.mdms.mdms_station.stationuncleansed.model.StationCleansedData;
import com.mdms.mdms_station.stationuncleansed.model.StationPKey;
import com.mdms.mdms_station.stationuncleansed.model.StationRbsAPIJSONModel;
import com.mdms.mdms_station.stationuncleansed.model.StationTableRbs;
import com.mdms.mdms_station.stationuncleansed.model.StationUncleansedData;
import com.mdms.mdms_station.stationuncleansed.model.StationUncleansedTest;
import com.mdms.mdms_station.stationuncleansed.model.StnRBSTotalDataJSON;
import com.mdms.mdms_station.stationuncleansed.repository.StationUncleansedDataRepository;
import com.mdms.mdms_station.stationuncleansed.service.StationEditForwardService;
import java.text.ParseException;
import java.text.SimpleDateFormat; 
@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")

@RestController
public class StationEditForwardController {
	
	@Autowired
	private StationEditForwardService stn_edit_fwd_serv;
	
	
	Logger logger=LoggerFactory.getLogger(StationEditForwardController.class);
	
//	@RequestMapping(method=RequestMethod.GET, value="/tblrbscmi")
//	public List<String> getDivisionalStnCodeCmi(@RequestParam(value="division") String division){
//		return stn_edit_fwd_serv.getDivisionalStnCodeCmi(division);
//	}
//	
//	
//	@RequestMapping(method=RequestMethod.GET, value="/tblrbsdti")
//	public List<String> getDivisionalStnCodeDti(@RequestParam(value="division") String division){
//		return stn_edit_fwd_serv.getDivisionalStnCodeDti(division);
//	}
//	
//	@RequestMapping(method=RequestMethod.GET, value="/stncoderbs")
//	public  StationTableRbs getStationRecordRBS(@RequestParam(value="station_code") String station_code) throws Exception
//	{
//		return stn_edit_fwd_serv.getStationRecordRBS(station_code);
//	}
//	
//	
//	@RequestMapping(method=RequestMethod.GET, value="/stncodeunclnsdcmi")
//	public  StationUncleansedData getDraftFromUncleansedCmi(@RequestParam(value="useridcmi") String useridcmi , @RequestParam(value="station_code") String station_code ) throws Exception
//	{
//		
//		return stn_edit_fwd_serv.getDraftFromUncleansedCmi(useridcmi,station_code);
//	}
//	
//	
//	@RequestMapping(method=RequestMethod.GET, value="/stncodeunclnsddti")
//	public  StationUncleansedData getDraftFromUncleansedDti(@RequestParam(value="useriddti") String useriddti , @RequestParam(value="station_code") String station_code ) throws Exception
//	{
//		
//		return stn_edit_fwd_serv.getDraftFromUncleansedDti(useriddti,station_code);
//	}
//	
//	
//	@RequestMapping(method=RequestMethod.POST, value="/unclnsdcmidraft")
//	public  String saveCmiDraft(@RequestBody StationUncleansedData stationdraftcmi) throws Exception
//	{
////		System.out.println(stationdraftcmi.getStn_Id().getStation_code());
////		System.out.println(stationdraftcmi.getStn_Id().getStation_valid_from());
////		System.out.println(stationdraftcmi.getStn_Id().getStation_valid_upto());
//		logger.error("controller : StationEditForwardController || Method : saveCmiDraft || input recieved stationdraftcmi: "+stationdraftcmi.getStn_Id().getStation_code());
//		
//		return stn_edit_fwd_serv.saveCmiDraft(stationdraftcmi);
//	}
//	
//
//	
//	@RequestMapping(method=RequestMethod.POST, value="/unclnsddtidraft")
//	public  String saveDtiDraft(@RequestBody StationUncleansedData stationdraftdti) throws Exception
//	{
////		System.out.println(stationdraftcmi.getStn_Id().getStation_code());
////		System.out.println(stationdraftcmi.getStn_Id().getStation_valid_from());
////		System.out.println(stationdraftcmi.getStn_Id().getStation_valid_upto());
//		logger.error("controller : StationEditForwardController || Method : saveDtiDraft || input recieved stationdraftdti: "+stationdraftdti.getStn_Id().getStation_code());
//		
//		return stn_edit_fwd_serv.saveDtiDraft(stationdraftdti);
//	}
//	
//	
//	
//	
//	@RequestMapping(method=RequestMethod.POST, value="/stnunclnsunaprvdcmi")
//	public  String forwardToDcm(@RequestBody StationUncleansedData stationdatadcm) throws Exception
//	{
//
//		logger.error("controller : StationEditForwardController || Method : forwardToDcm || input recieved stationdatadcm: "+stationdatadcm.getStn_Id().getStation_code());
//		
//		return stn_edit_fwd_serv.forwardToDcm(stationdatadcm);
//	}
//	
//	
//
//	@RequestMapping(method=RequestMethod.POST, value="/stnunclnsunaprvddti")
//	public  String forwardToDom(@RequestBody StationUncleansedData stationdatadom) throws Exception
//	{
//
//		logger.error("controller : StationEditForwardController || Method : forwardToDom || input recieved stationdatadom: "+stationdatadom.getStn_Id().getStation_code());
//		
//		return stn_edit_fwd_serv.forwardToDom(stationdatadom);
//	}
//	
//	
//	
//	
//	@RequestMapping(method=RequestMethod.POST, value="/stnunclnsunaprvdcm")
//	public List<StationUncleansedData> fetchUnapprovedCmiRecords(@RequestParam(value="division_code") String division_code)
//	{
//		return stn_edit_fwd_serv.fetchUnapprovedCmiRecords(division_code);
//	}
//	
//	@RequestMapping(method=RequestMethod.POST, value="/stnunclnsunaprvdom")
//	public List<StationUncleansedData> fetchUnapprovedDtiRecords(@RequestParam(value="division_code") String division_code)
//	{
//		return stn_edit_fwd_serv.fetchUnapprovedDtiRecords(division_code);
//	}
//	
//	
//	
//	@RequestMapping(method=RequestMethod.POST, value="/stnunclnsunaprvdcm1")
//	public List<StationUncleansedTest> fetchUnapprovedCmiRecords1(@RequestParam(value="division_code") String division_code)
//	{
//		return stn_edit_fwd_serv.fetchUnapprovedCmiRecords1(division_code);
//	}
//	
//	
//	
//	@RequestMapping(method=RequestMethod.POST, value="/stnunclappdcm")
//	public  String approvedByDcm(@RequestBody String stationdatadcm) throws Exception
//	{
//
//		logger.error("controller : StationEditForwardController || Method : approvedByDcm || input recieved approvedByDcm: "+stationdatadcm);
//		
//		return stn_edit_fwd_serv.approvedByDcm(stationdatadcm);
//		
//		
//	}
//	
//	
//	
//	@RequestMapping(method=RequestMethod.POST, value="/stnunclappdom")
//	public  String approvedByDom(@RequestBody String stationdatadcm) throws Exception
//	{
//		logger.error("controller : StationEditForwardController || Method : approvedByDom || input recieved approvedByDom: "+stationdatadcm);		
//		return stn_edit_fwd_serv.approvedByDom(stationdatadcm);		
//		
//	}
//	
//
//	/*
//	  To Reject record DCM
//	  Developed By: Anshul
//	  Date: 09-01-2021
//	  
//	  */
//	@RequestMapping(method=RequestMethod.POST, value="/stnunclrejdcm")
//	public  String rejectByDcm(@RequestBody String stationdatadcm) throws Exception
//	{
//		logger.error("controller : StationEditForwardController || Method : rejectByDcm || input recieved rejectByDcm: "+stationdatadcm);		
//		return stn_edit_fwd_serv.rejectByDcm(stationdatadcm);		
//		
//	}
//	
//	/*
//	  To Reject record DOM
//	  Developed By: Anshul
//	  Date: 09-01-2021
//	  
//	  */
//	@RequestMapping(method=RequestMethod.POST, value="/stnunclrejdom")
//	public  String rejectByDom(@RequestBody String stationdatadom) throws Exception
//	{
//		logger.error("controller : StationEditForwardController || Method : rejectByDom || input recieved rejectByDom: "+stationdatadom);		
//		return stn_edit_fwd_serv.rejectByDom(stationdatadom);		
//		
//	}
//	
//	@RequestMapping(method=RequestMethod.POST, value="/getstndraftdata")
//	public StationUncleansedData checkStnData(@RequestBody String station_code) throws Exception {
//		 logger.error("controller : StationEditForwardController || Method : checkStnData || input recieved checkStnData: "+station_code);		 
//	return stn_edit_fwd_serv.getStnDraft(station_code);
//	}   
//	
//	
//// Shilpi 09-04-2021 for hyperlink  // Modified Anshul 27-05-2021 // change StationTableRbs to String request body
// 
//	@RequestMapping(method=RequestMethod.POST, value = "/gethyperUncleanstnService")
//
//	public List<StationTableRbs> getUncleanstnHyperDivision(@RequestBody String objdraft ){ 
//
////		System.out.println("division_code"+ objdraft.getDivision_code());
//    return stn_edit_fwd_serv.getUncleanstnHyperDivision(objdraft);	
//	}
//	
//	
//	@RequestMapping(method=RequestMethod.POST, value = "/gethyperdraftstnService")
//	public List<StationUncleansedDataRepository> getTotalDraftForwardApprovalStationHyperDivisionWise(@RequestBody StationUncleansedData objdraft ){
//		System.out.println("division_code"+ objdraft.getDivision_code());
//    return stn_edit_fwd_serv.getTotalDraftForwardApprovalStationHyperDivisionWise(objdraft);	
//	}
//	
//	
//	@RequestMapping(method=RequestMethod.POST, value = "/gethyperpendingAppService")
//	public List<StationUncleansedDataRepository> getPendingApprovalStationHyperDivisionWise(@RequestBody StationUncleansedData objdraft ){
//		System.out.println("division_code"+ objdraft.getDivision_code());
//    return stn_edit_fwd_serv.getPendingApprovalStationHyperDivisionWise(objdraft);	
//	}
//	
//	//JYOTI BISHT 17/10/22
//	
//		@PostMapping("/get_station_draft_count")
//		public int getStationDraft(@RequestParam("from")String from, @RequestParam("to") String to) throws ParseException{
//	    return stn_edit_fwd_serv.getStationDraft(from, to);	
//		}
//		
//		@PostMapping("/get_station_pending_count")
//		public int getStationPending(@RequestParam("from")String from, @RequestParam("to") String to) throws ParseException{
//	    return stn_edit_fwd_serv.getStationPending(from, to);	
//		}
//		
//		
//		// JYOTI BISHT 31-10-22
//					
//					@PostMapping("/get_total_station_count")
//					public List<Object[]>  get_station_count(@RequestParam("from") String from, @RequestParam("to") String to) throws ParseException
//					{
//						return stn_edit_fwd_serv.get_station_total_count(from, to);
//					}
//					
//		// JYOTI BISHT 31-10-22
//					
//					@PostMapping("/get_total_station_count1")
//					public int get_station_count1()
//					{
//						return stn_edit_fwd_serv.get_station_total_count1();
//					}
//												
//					
//		// JYOTI BISHT 31-10-22
//		    	
//			    	@PostMapping("/station_integration")
//			    	public int integration_stats(@RequestParam("from") String from, @RequestParam("to") String to) throws ParseException
//			    	{
//			    		
//			    		return stn_edit_fwd_serv.integration_stats(from, to);
//			    	}
//			    	
//			    	@RequestMapping(method=RequestMethod.POST, value = "/getstndatatilldate")
//			    	public List<Object[]> getstndatatilltoday(@RequestParam(required = false,value = "zone_code")String zone_code, @RequestParam(required = false, value = "div_code")String div_code ){
////			    		System.out.println("division_code"+ division_code);
////			    		System.out.println("division_code"+ zone_code);
//			        return stn_edit_fwd_serv.getstndatatilltoday(zone_code, div_code);	
//			    	}
//
//		//JYOTI BISHT 06-01-23
//			 		
//			 		@PostMapping("/get_unclean_station_details")
//				    public List<StationUncleansedData> geteUncleanStationDetails(@RequestParam("zone") String zone, @RequestParam("division") String division, @RequestParam("status") String status)
//			    	{
//				    	return stn_edit_fwd_serv.get_unclean_station_details(zone, division, status);
//							
//				    }	
//			 		
//			 		@PostMapping("/get_clean_station_details")
//				    public List<StationCleansedData> getCleanStationDetails(@RequestParam("zone") String zone, @RequestParam("division") String division, @RequestParam("status") String status)
//			    	{
//				    	return stn_edit_fwd_serv.get_clean_station_details(zone, division, status);
//							
//				    }	



	@RequestMapping(method=RequestMethod.GET, value="/tblrbscmi")
	public List<String> getDivisionalStnCodeCmi(@RequestParam(value="division") String division){
		return stn_edit_fwd_serv.getDivisionalStnCodeCmi(division);
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="/tblrbsdti")
	public List<String> getDivisionalStnCodeDti(@RequestParam(value="division") String division){
		return stn_edit_fwd_serv.getDivisionalStnCodeDti(division);
	}
	

	
	@RequestMapping(method=RequestMethod.GET, value="/sidingdti")
	public List<String> getDivisionalStnCodeDti(@RequestParam(value="division") String division,@RequestParam(value="category") String category){
		return stn_edit_fwd_serv.getDivisionalStnCodeDti(division,category);
	}
	

	@RequestMapping(method=RequestMethod.GET, value="/stncoderbs")
	public  StationTableRbs getStationRecordRBS(@RequestParam(value="station_code") String station_code) throws Exception
	{
		return stn_edit_fwd_serv.getStationRecordRBS(station_code);
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="/stncodeunclnsdcmi")
	public  StationUncleansedData getDraftFromUncleansedCmi(@RequestParam(value="useridcmi") String useridcmi , @RequestParam(value="station_code") String station_code ) throws Exception
	{
		
		return stn_edit_fwd_serv.getDraftFromUncleansedCmi(useridcmi,station_code);
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="/stncodeunclnsddti")
	public  StationUncleansedData getDraftFromUncleansedDti(@RequestParam(value="useriddti") String useriddti , @RequestParam(value="station_code") String station_code ) throws Exception
	{
		
		return stn_edit_fwd_serv.getDraftFromUncleansedDti(useriddti,station_code);
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/unclnsdcmidraft")
	public  String saveCmiDraft(@RequestBody StationUncleansedData stationdraftcmi) throws Exception
	{
//		System.out.println(stationdraftcmi.getStn_Id().getStation_code());
//		System.out.println(stationdraftcmi.getStn_Id().getStation_valid_from());
//		System.out.println(stationdraftcmi.getStn_Id().getStation_valid_upto());
		logger.error("controller : StationEditForwardController || Method : saveCmiDraft || input recieved stationdraftcmi: "+stationdraftcmi.getStn_Id().getStation_code());
		
		return stn_edit_fwd_serv.saveCmiDraft(stationdraftcmi);
	}
	

	
	@RequestMapping(method=RequestMethod.POST, value="/unclnsddtidraft")
	public  String saveDtiDraft(@RequestBody StationUncleansedData stationdraftdti) throws Exception
	{
//		System.out.println(stationdraftcmi.getStn_Id().getStation_code());
//		System.out.println(stationdraftcmi.getStn_Id().getStation_valid_from());
//		System.out.println(stationdraftcmi.getStn_Id().getStation_valid_upto());
		logger.error("controller : StationEditForwardController || Method : saveDtiDraft || input recieved stationdraftdti: "+stationdraftdti.getStn_Id().getStation_code());
		
		return stn_edit_fwd_serv.saveDtiDraft(stationdraftdti);
	}
	
	
	
	
	@RequestMapping(method=RequestMethod.POST, value="/stnunclnsunaprvdcmi")
	public  String forwardToDcm(@RequestBody StationUncleansedData stationdatadcm) throws Exception
	{

		logger.error("controller : StationEditForwardController || Method : forwardToDcm || input recieved stationdatadcm: "+stationdatadcm.getStn_Id().getStation_code());
		
		return stn_edit_fwd_serv.forwardToDcm(stationdatadcm);
	}
	
	

	@RequestMapping(method=RequestMethod.POST, value="/stnunclnsunaprvddti")
	public  String forwardToDom(@RequestBody StationUncleansedData stationdatadom) throws Exception
	{

		logger.error("controller : StationEditForwardController || Method : forwardToDom || input recieved stationdatadom: "+stationdatadom.getStn_Id().getStation_code());
		
		return stn_edit_fwd_serv.forwardToDom(stationdatadom);
	}
	
	
	
	
	@RequestMapping(method=RequestMethod.POST, value="/stnunclnsunaprvdcm")
	public List<StationUncleansedData> fetchUnapprovedCmiRecords(@RequestParam(value="division_code") String division_code)
	{
		return stn_edit_fwd_serv.fetchUnapprovedCmiRecords(division_code);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/stnunclnsunaprvdom")
	public List<StationUncleansedData> fetchUnapprovedDtiRecords(@RequestParam(value="division_code") String division_code)
	{
		return stn_edit_fwd_serv.fetchUnapprovedDtiRecords(division_code);
	}
	
	
	
	@RequestMapping(method=RequestMethod.POST, value="/stnunclnsunaprvdcm1")
	public List<StationUncleansedTest> fetchUnapprovedCmiRecords1(@RequestParam(value="division_code") String division_code)
	{
		return stn_edit_fwd_serv.fetchUnapprovedCmiRecords1(division_code);
	}
	
	
	
	@RequestMapping(method=RequestMethod.POST, value="/stnunclappdcm")
	public  String approvedByDcm(@RequestBody String stationdatadcm) throws Exception
	{

		logger.error("controller : StationEditForwardController || Method : approvedByDcm || input recieved approvedByDcm: "+stationdatadcm);
		
		return stn_edit_fwd_serv.approvedByDcm(stationdatadcm);
		
		
	}
	
	
	
	@RequestMapping(method=RequestMethod.POST, value="/stnunclappdom")
	public  String approvedByDom(@RequestBody String stationdatadcm) throws Exception
	{
		logger.error("controller : StationEditForwardController || Method : approvedByDom || input recieved approvedByDom: "+stationdatadcm);		
		return stn_edit_fwd_serv.approvedByDom(stationdatadcm);		
		
	}
	

	/*
	  To Reject record DCM
	  Developed By: Anshul
	  Date: 09-01-2021
	  
	  */
	@RequestMapping(method=RequestMethod.POST, value="/stnunclrejdcm")
	public  String rejectByDcm(@RequestBody String stationdatadcm) throws Exception
	{
		logger.error("controller : StationEditForwardController || Method : rejectByDcm || input recieved rejectByDcm: "+stationdatadcm);		
		return stn_edit_fwd_serv.rejectByDcm(stationdatadcm);		
		
	}
	
	/*
	  To Reject record DOM
	  Developed By: Anshul
	  Date: 09-01-2021
	  
	  */
	@RequestMapping(method=RequestMethod.POST, value="/stnunclrejdom")
	public  String rejectByDom(@RequestBody String stationdatadom) throws Exception
	{
		logger.error("controller : StationEditForwardController || Method : rejectByDom || input recieved rejectByDom: "+stationdatadom);		
		return stn_edit_fwd_serv.rejectByDom(stationdatadom);		
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/getstndraftdata")
	public StationUncleansedData checkStnData(@RequestBody String station_code) throws Exception {
		 logger.error("controller : StationEditForwardController || Method : checkStnData || input recieved checkStnData: "+station_code);		 
	return stn_edit_fwd_serv.getStnDraft(station_code);
	}   
	
	
// Shilpi 09-04-2021 for hyperlink  // Modified Anshul 27-05-2021 // change StationTableRbs to String request body
 
	@RequestMapping(method=RequestMethod.POST, value = "/gethyperUncleanstnService")

	public List<StationTableRbs> getUncleanstnHyperDivision(@RequestBody String objdraft ){ 

//		System.out.println("division_code"+ objdraft.getDivision_code());
    return stn_edit_fwd_serv.getUncleanstnHyperDivision(objdraft);	
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value = "/gethyperdraftstnService")
	public List<StationUncleansedDataRepository> getTotalDraftForwardApprovalStationHyperDivisionWise(@RequestBody StationUncleansedData objdraft ){
		System.out.println("division_code"+ objdraft.getDivision_code());
    return stn_edit_fwd_serv.getTotalDraftForwardApprovalStationHyperDivisionWise(objdraft);	
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value = "/gethyperpendingAppService")
	public List<StationUncleansedDataRepository> getPendingApprovalStationHyperDivisionWise(@RequestBody StationUncleansedData objdraft ){
		System.out.println("division_code"+ objdraft.getDivision_code());
    return stn_edit_fwd_serv.getPendingApprovalStationHyperDivisionWise(objdraft);	
	}
	
	//JYOTI BISHT 17/10/22
	
		@PostMapping("/get_station_draft_count")
		public int getStationDraft(@RequestParam("from")String from, @RequestParam("to") String to) throws ParseException{
	    return stn_edit_fwd_serv.getStationDraft(from, to);	
		}
		
		@PostMapping("/get_station_pending_count")
		public int getStationPending(@RequestParam("from")String from, @RequestParam("to") String to) throws ParseException{
	    return stn_edit_fwd_serv.getStationPending(from, to);	
		}
		
		
		// JYOTI BISHT 31-10-22
					
					@PostMapping("/get_total_station_count")
					public List<Object[]>  get_station_count(@RequestParam("from") String from, @RequestParam("to") String to) throws ParseException
					{
						return stn_edit_fwd_serv.get_station_total_count(from, to);
					}
					
		// JYOTI BISHT 31-10-22
					
					@PostMapping("/get_total_station_count1")
					public int get_station_count1()
					{
						return stn_edit_fwd_serv.get_station_total_count1();
					}
												
					
		// JYOTI BISHT 31-10-22
		    	
			    	@PostMapping("/station_integration")
			    	public int integration_stats(@RequestParam("from") String from, @RequestParam("to") String to) throws ParseException
			    	{
			    		
			    		return stn_edit_fwd_serv.integration_stats(from, to);
			    	}
			    	
			    	@RequestMapping(method=RequestMethod.POST, value = "/getstndatatilldate")
			    	public List<Object[]> getstndatatilltoday(@RequestParam(required = false,value = "zone_code")String zone_code, @RequestParam(required = false, value = "div_code")String div_code ){
//			    		System.out.println("division_code"+ division_code);
//			    		System.out.println("division_code"+ zone_code);
			        return stn_edit_fwd_serv.getstndatatilltoday(zone_code, div_code);	
			    	}

		//JYOTI BISHT 06-01-23
			 		
			 		@PostMapping("/get_unclean_station_details")
				    public List<StationUncleansedData> geteUncleanStationDetails(@RequestParam("zone") String zone, @RequestParam("division") String division, @RequestParam("status") String status)
			    	{
				    	return stn_edit_fwd_serv.get_unclean_station_details(zone, division, status);
							
				    }	
			 		
			 		@PostMapping("/get_clean_station_details")
				    public List<StationCleansedData> getCleanStationDetails(@RequestParam("zone") String zone, @RequestParam("division") String division, @RequestParam("status") String status)
			    	{
				    	return stn_edit_fwd_serv.get_clean_station_details(zone, division, status);
							
				    }	

			
			//JYOTI BISHT 29-05-23		
			 		
			 		@PostMapping("/get_draft_station_by_user")
				    public List<StationUncleansedData> getdraftStationDetails(@RequestParam("userid") String userid)
			    	{
				    	return stn_edit_fwd_serv.get_draft_station_details(userid);
							
				    }	
			 		
			 		

//Anshul 17-10-2023
			 		@RequestMapping(method=RequestMethod.POST, value="/getshortname")
			 		public String getShortNamePrs(@RequestBody String station_code) throws Exception {
			 			 logger.error("controller : StationEditForwardController || Method : getShortNamePrs || input recieved Stn_code: "+station_code);		 
			 		return stn_edit_fwd_serv.getShortNamePrs(station_code);
			 		}   
			 		    	
			    	
			    	

}



