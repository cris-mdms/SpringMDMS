/*This controller provides all services for cleansing of coach.
 * Data is first fetched from CMM Master and shown to user on the basis of its depot.
 * User corrects the data and forward it for approving to its approving authority
 * Created By : Firoz, 26-10-2020
 * 
 */


package com.mdms.mdms_coach.coachuncleansed.controller;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.text.ParseException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mdms.mdms_coach.coachuncleansed.model.CoachTypeMapping;
import com.mdms.dahsboard.model.DashBoardCoachCountDepoWiseModel;

import com.mdms.mdms_coach.coachuncleansed.model.CoachCleansedData;
import com.mdms.mdms_coach.coachuncleansed.model.CoachDataCMM;
import com.mdms.mdms_coach.coachuncleansed.model.CoachUncleansedData;
import com.mdms.mdms_coach.coachuncleansed.service.CoachEditForwardService;
import com.mdms.mdms_station.stationuncleansed.model.StationCleansedData;
import com.mdms.mdms_station.stationuncleansed.model.StationTableRbs;
import com.mdms.mdms_station.stationuncleansed.model.StationUncleansedTest;

import com.mdms.mdms_coach.coachuncleansed.model.MDepo;
import com.mdms.mdms_coach.coachuncleansed.service.CoachEditForwardService;

import com.mdms.mdms_masters.model.MDivision;

import com.mdms.mdms_station.stationuncleansed.model.StationUncleansedTest;
import java.text.ParseException;

@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")



@RestController
public class CoachEditForwardController {
	@Autowired
	private CoachEditForwardService coachEditFwdServ;
	



	Logger logger=LoggerFactory.getLogger(CoachEditForwardController.class);

	//-------------------------------------------return coachIds for a particular depot--------------------------------------------
	
	@RequestMapping(method=RequestMethod.GET, value="/getCoachesByDepot")

	public List<String> getCoachesByDepot(@RequestParam (value="depotId")String depotId) {

	logger.info("Controller : CoachEditForwardController || Method: getCoachesByDepot || getCoachForDepot: "+depotId);
	List<String> coachIds=coachEditFwdServ.getCoachesByDepot(depotId);
	return coachIds;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getCoachesnoByzone")
	public List<String> getCoachesByZone(@RequestParam (value="zone")String zone) {	
		
		logger.info("Controller : CoachEditForwardController || Method: getCoachesBytype || getCoachByzone: "+zone);
		List<String> coachIds=coachEditFwdServ.getCoachesByZone(zone);
			return coachIds;	
	}
	
	//-------------------------------------------return coachDetails for a particular coach Id--------------------------------------------
	@RequestMapping(method=RequestMethod.GET, value="/getCoachByCoachNo")
	public Optional<CoachDataCMM> getCoachByCoachId(@RequestParam String coachNo) {	
		Optional<CoachDataCMM> coachDetails=coachEditFwdServ.getCoachByCoachNo(coachNo);
		logger.info("Controller : CoachEditForwardController || Method: getCoachesByDepot || getCoachDetailsforCoachId: "+coachNo);
			return coachDetails;	
	}
	//-------------------------------------------return coachDetails for a particular coach Id--------------------------------------------
//		@RequestMapping(method=RequestMethod.GET, value="/getCoachByCoachId")
//		public Optional<CoachDataCMM> getCoachByCoachId(@RequestParam String coachId) {	
//			Optional<CoachDataCMM> coachDetails=coachEditFwdServ.getCoachByCoachNo(coachId);
//			logger.info("Controller : CoachEditForwardController || Method: getCoachesByDepot || getCoachDetailsforCoachId: "+coachId);
//				return coachDetails;	
//		}

//	public List<String> getCoachesByDepot(@RequestParam (value="depotId")String depotId) {	
//		
//		logger.info("Controller : CoachEditForwardController || Method: getCoachesByDepot || getCoachForDepot: "+depotId);
//		List<String> coachIds=coachEditFwdServ.getCoachesByDepot(depotId);
//			return coachIds;	
//	}
	
	//-------------------------------------------return coachDetails for a particular coach Id--------------------------------------------
//	@RequestMapping(method=RequestMethod.GET, value="/getCoachByCoachId")
//	public Optional<CoachDataCMM> getCoachByCoachId(@RequestParam String coachId) {	
//		Optional<CoachDataCMM> coachDetails=coachEditFwdServ.getCoachByCoachId(coachId);
//		logger.info("Controller : CoachEditForwardController || Method: getCoachesByDepot || getCoachDetailsforCoachId: "+coachId);
//			return coachDetails;	
//	}
//	


	//-------------------------------------------coach Details forwarded/saved as draft after cleaning of record--------------------------------------------
	@RequestMapping(method=RequestMethod.POST, value="/unclndraft")
	public String EditForwardCoach(@RequestBody CoachUncleansedData coachUncleansedData) throws Exception {		
		String response=coachEditFwdServ.saveAsDraftCoach(coachUncleansedData);	
			return response;	


	}

	
	//-------------------------------------------coach Details forwarded/saved as draft after cleaning of record--------------------------------------------
		@RequestMapping(method=RequestMethod.GET, value="/unclncoachdraft")
		public CoachUncleansedData getCoachDraft(@RequestParam(value="userid") String userid, @RequestParam(value="coachid") Long coach_id) throws Exception {		
			logger.info("Controller : CoachEditForwardController || Method: getCoachDraft || userid: "+userid);
			CoachUncleansedData response=coachEditFwdServ.getCoachDraft(userid, coach_id);	
				return response;	


		}

	//-------------------------------------------return coach Depo List as per Zone--------------------------------------------

	
	@RequestMapping(method=RequestMethod.POST, value="/depoByZoneCode")
	public List<MDepo> findByZone(@RequestBody MDepo depo) {
		List<MDepo> temp=coachEditFwdServ.findByZoneCode(depo);
		 return coachEditFwdServ.findByZoneCode(depo);  
	
	}    

	
	
	//-------------------------------------------coach Details forwarded after cleaning of record--------------------------------------------
	@RequestMapping(method=RequestMethod.POST, value="/unclnapp")
	public String forwardForApprovalCoach(@RequestBody CoachUncleansedData coachUncleansedData) throws Exception {		
		String response=coachEditFwdServ.forwardForApprovalCoach(coachUncleansedData);	
			return response;	


	}
	
	//-------------------------------------------coach Details pending for approval after cleaning of record-----------------------------------------
	@RequestMapping(method=RequestMethod.POST, value="/unclnsunaprvdcoach")
	public List<CoachUncleansedData> fetchUnapprovedCoachRecords(@RequestParam(value="depot") String depot)
	{
		return coachEditFwdServ.fetchUnapprovedCoachRecords(depot);
	}
	

	@RequestMapping(method=RequestMethod.POST, value="/cochunclapp")
	public String approvedCoachRecords(@RequestBody Long coachid)
	{
		return coachEditFwdServ.approvedCoachRecords(coachid);
	}
	
	
	/* function definition – Map cmm-prs coach types
	Developer – Anshul ,24/06/2020
	*/
	@RequestMapping(method=RequestMethod.POST, value="/coachmap")
	 public int saveCoachType(@RequestBody List<CoachTypeMapping> coachtypemap){
		
		return coachEditFwdServ.saveCoachType(coachtypemap);
	}

	
	// Shilpi 16-04-2021 for hyperlink
	
	//uncleansed	 
		@RequestMapping(method=RequestMethod.POST, value = "/gethyperUncleanCoachService")
		public List<CoachDataCMM> getUncleansedCoacHyperDepo(@RequestBody CoachDataCMM objdraft ){
			System.out.println("owning_depot"+ objdraft.getBase_depot());
	    return coachEditFwdServ.getUncleansedCoachHyperDepo(objdraft);	
		}
		
		//draft	 
				@RequestMapping(method=RequestMethod.POST, value = "/gethyperdraftCoachService")
				public List<CoachUncleansedData> getDraftCoachApprovalHyperdepo(@RequestBody CoachUncleansedData objdraft ){
					System.out.println("owning_depot"+ objdraft.getOwning_depot());
			    return coachEditFwdServ.getDraftCoachApprovalHyperdepo(objdraft);	
				}
				
	//pending	 
				@RequestMapping(method=RequestMethod.POST, value = "/gethyperpendingCoachService")
				public List<CoachUncleansedData> getCoachPendingHyperdepo(@RequestBody CoachUncleansedData objdraft ){
					System.out.println("owning_depot"+ objdraft.getOwning_depot());
			    return coachEditFwdServ.getCoachPendingHyperdepo(objdraft);	
				}
				
	//approved	 
				@RequestMapping(method=RequestMethod.POST, value = "/gethyperapproveCoachService")
				public List<CoachCleansedData> getCoachApprovedHyperDepo(@RequestBody CoachCleansedData objdraft ){
					System.out.println("owning_depot"+ objdraft.getOwning_depot());
			    return coachEditFwdServ.getCoachApprovedHyperDepo(objdraft);	
				}
				
	//Shilpi coach mapping	 26-04-2021
				//@RequestMapping(method=RequestMethod.POST, value = "/getCoachmapcount")
				//public List<CoachTypeMapping> getCoachmapcount(){
					//System.out.println("owning_depot"+ objdraft.getOwning_depot());
			    //return coachEditFwdServ.getCoachmapcount();	
				//}		
				
				@RequestMapping(method=RequestMethod.POST, value="/getCoachmapcount")
				 public List<DashBoardCoachCountDepoWiseModel> getCoachmapcount(@RequestBody DashBoardCoachCountDepoWiseModel coachtypemap){					
					return coachEditFwdServ.getCoachmapcount(coachtypemap);
				}

				// JYOTI BISHT 17-10-22			
				
				@PostMapping("/get_coach_draft_count")
				public int getCoachDraft(@RequestParam("from")String from, @RequestParam("to") String to) throws ParseException{
			    return coachEditFwdServ.getCoachDraft(from, to);	
				}
				@PostMapping("/get_coach_pending_count")
				public int getCoachPending(@RequestParam("from")String from, @RequestParam("to") String to) throws ParseException{
			    return coachEditFwdServ.getCoachPending(from, to);	
				}
				
				@PostMapping("/get_coach_approved_count")
				public int getCoachApproved(@RequestParam("from")String from, @RequestParam("to") String to) throws ParseException{
			    return coachEditFwdServ.getCoachApproved(from, to);	
				}
				
				// JYOTI BISHT 31-10-22
							
							@PostMapping("/get_total_coach_count")
							public int get_coach_count()
							{
								return coachEditFwdServ.get_coach_total_count();
							}
							
				// JYOTI BISHT 31-10-22
					    	
					    	@PostMapping("/coach_integration")
					    	public List<Object[]> integration_stats(@RequestParam("from") String from, @RequestParam("to") String to) throws ParseException
					    	{
					    		
					    		return coachEditFwdServ.integration_stats(from, to);
					    	}
				
					    	@PostMapping("/get_coach_details")
						    public List<CoachUncleansedData> getCoachDetails(@RequestParam("zone") String zone, @RequestParam("division") String division, @RequestParam("status") String status)
					    	{
						    	return coachEditFwdServ.get_coach_details(zone, division, status);
									
						    }	
					     	@PostMapping("/get_clean_coach_details")
						    public List<CoachCleansedData> getCleanCoachDetails(@RequestParam("zone") String zone, @RequestParam("division") String division, @RequestParam("status") String status)
					    	{
						    	return coachEditFwdServ.get_clean_coach_details(zone, division, status);
									
						    }	
}
