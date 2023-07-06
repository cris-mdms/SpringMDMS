package com.mdms.loco.locouncleansed.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mdms.loco.locouncleansed.model.BoardZonalApproval;
import com.mdms.loco.locouncleansed.model.LocoUncleansedDataAddNewLoco;
import com.mdms.loco.locouncleansed.model.LocoUncleansedDataElectric;
import com.mdms.loco.locouncleansed.service.LocoAddService;
@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")
@RestController
public class LocoAddController {
	Logger logger=LoggerFactory.getLogger(LocoAddController.class);
	
	@Autowired
	private LocoAddService obj_newlocoservice;

	@RequestMapping(method=RequestMethod.POST, value="/savedieselboardzonalloco")
	public String savedslnewloco(@RequestBody LocoUncleansedDataAddNewLoco dieselLocoBoardZonal) throws JSONException, JsonMappingException, IOException 
	{
		logger.info("----------/saveDieselBoardZonalNewLocoAddtion",dieselLocoBoardZonal);
		System.out.println(dieselLocoBoardZonal);
		return obj_newlocoservice.saveDieselBoardZonalData(dieselLocoBoardZonal);
			}
	
	
	
	@RequestMapping(method=RequestMethod.POST, value="/updatedieselboardzonalloco")
	public String updatedsllocobyboardzonaldata(@RequestBody LocoUncleansedDataAddNewLoco updatedieselLocoBoardZonal) throws JSONException, JsonMappingException, IOException 
	{
		logger.info("----------/updateDieselBoardZonalNewLocoAddtion",updatedieselLocoBoardZonal);
		System.out.println(updatedieselLocoBoardZonal);
		return obj_newlocoservice.updateDieselBoardZonalData(updatedieselLocoBoardZonal);
			}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/saveelectricboardzonalloco")
	public String saveelecnewloco(@RequestBody LocoUncleansedDataAddNewLoco dieselLocoBoardZonal) throws JSONException, JsonMappingException, IOException 
	{
		logger.info("----------/saveElectricBoardZonalNewLocoAddtion",dieselLocoBoardZonal);
		
		return obj_newlocoservice.saveDieselBoardZonalData(dieselLocoBoardZonal);
			}
	
	
	

	//Anshul.............19-06-2023
	@RequestMapping(method=RequestMethod.POST, value="/savedraftnewloco")
	public String saveDraftNewLoco(@RequestBody LocoUncleansedDataAddNewLoco locodraft) throws Exception 
	{
		logger.info("----------/saveDraftNewLoco");
		
		
		return obj_newlocoservice.saveDraftNewLoco(locodraft);
			}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/updateelectricboardzonalloco")
	public String updateelecbyboardzonaldata(@RequestBody BoardZonalApproval updateElectricLocoBoardZonal) throws JSONException, JsonMappingException, IOException 
	{
		logger.info("----------/updateElectricBoardZonalNewLocoAddtion",updateElectricLocoBoardZonal);
		System.out.println(updateElectricLocoBoardZonal);
		return obj_newlocoservice.updateElectricBoardZonalData(updateElectricLocoBoardZonal);
			}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/checkloconoexist")
	public boolean checklocono(@RequestBody LocoUncleansedDataAddNewLoco objlocono) {

		long locono=objlocono.getLoco_no();

//		int locono=objlocono.getLoco_no();

	boolean flag= obj_newlocoservice.checkloconoexist(locono);
	return flag;
	} 
	
	//Anshul 05-07-2023
	@RequestMapping(method=RequestMethod.GET, value="/checkloconoexistadd")
	public boolean checkNewLocoNumberExist(@RequestParam(value="loco_no") long objlocono  ) {

	boolean flag= obj_newlocoservice.checkNewLocoNumberExist(objlocono);
	System.out.println("flag:    "+flag);
	return flag;
	} 





//	@RequestMapping(method=RequestMethod.POST, value="/updateelectricboardzonalloco")
//	public String updateelecbyboardzonaldata(@RequestBody BoardZonalApproval updateElectricLocoBoardZonal) throws JSONException, JsonMappingException, IOException 
//	{
//		logger.info("----------/updateElectricBoardZonalNewLocoAddtion",updateElectricLocoBoardZonal);
//		System.out.println(updateElectricLocoBoardZonal);
//		return obj_newlocoservice.updateElectricBoardZonalData(updateElectricLocoBoardZonal);
//			}
	
	
//	@RequestMapping(method=RequestMethod.POST, value="/checkloconoexist")
//	public boolean checklocono(@RequestBody LocoUncleansedDataAddNewLoco objlocono) {
//		int locono=objlocono.getLoco_no();
//	boolean flag= obj_newlocoservice.checkloconoexist(locono);
//	return flag;
//	}   
	

	@RequestMapping(method=RequestMethod.POST, value="/updateelectricshednewloco")
	public String updateElectricNewLocoData(@RequestBody LocoUncleansedDataAddNewLoco updateElectricLocoShedUser) throws JSONException, JsonMappingException, IOException 
	{
		logger.info("----------/updateElectricShedNewLocoAddtion",updateElectricLocoShedUser);
		System.out.println(updateElectricLocoShedUser);
		return obj_newlocoservice.updateElectricShedData(updateElectricLocoShedUser);
			}
	
	@RequestMapping(method=RequestMethod.POST, value="/updatedieselshednewloco")
	public String updateDieselNewLocoData(@RequestBody LocoUncleansedDataAddNewLoco updateDieselLocoShedUser) throws JSONException, JsonMappingException, IOException 
	{
		logger.info("----------/updateDieselShedNewLocoAddtion",updateDieselLocoShedUser);
		System.out.println(updateDieselLocoShedUser);
		return obj_newlocoservice.updateWithDieselNewLocoShedData(updateDieselLocoShedUser);
			}
	

	 @RequestMapping(method=RequestMethod.POST, value = "/zonalUnapprovedLoco")
 	public List<LocoUncleansedDataAddNewLoco> getZonalUnapprovedLoco(){
 	 		return obj_newlocoservice.getUnapprovedZonalLocos();
			
 	}

	 @RequestMapping(method=RequestMethod.POST, value = "/getRBVerifiedNewLoco")
	 	public List<LocoUncleansedDataAddNewLoco> getTotalRBVerifiedNewLoco(){
	 	 		return obj_newlocoservice.getTotalRBVerifiedNewLoco();
				
	 	}
//	 @RequestMapping(method=RequestMethod.POST, value = "/zonalUnapprovedLoco")
// 	public List<LocoUncleansedDataAddNewLoco> getZonalUnapprovedLoco(@RequestBody LocoUncleansedDataElectric obj_zonalunapproved){
// 		System.out.println("zoneid"+ obj_zonalunapproved.getElec_locoOwningZone());
// 		return obj_newlocoservice.getUnapprovedZonalLocos(obj_zonalunapproved);
//			
// 	}

	 
	 @RequestMapping(method=RequestMethod.POST, value = "/savenewlocogoldenrecord")
 	public String saveNewGoldenRecord(@RequestBody LocoUncleansedDataAddNewLoco obj_newgoldenloco){
 		System.out.println("zoneid"+ obj_newgoldenloco.getLoco_owning_shed());
 		return obj_newlocoservice.savegoldenrecord(obj_newgoldenloco);
			
 	}

	 

	 @RequestMapping(method=RequestMethod.POST, value = "/zonalapprovedLoco")
 	public List<LocoUncleansedDataAddNewLoco> getZonalUnapprovedLoco(@RequestBody LocoUncleansedDataAddNewLoco obj_zonalunapproved){
 		System.out.println("zoneid"+ obj_zonalunapproved.getLoco_owning_zone());
 		return obj_newlocoservice.getApprovedZonalLocos(obj_zonalunapproved);
			
 	}

	
	  @RequestMapping(method=RequestMethod.POST, value = "/getloconumber")
	  public List<Integer> getLocoNumber(@RequestBody LocoUncleansedDataAddNewLoco objnewloco){  
	  return obj_newlocoservice.getLocoNumber(objnewloco.getLoco_owning_shed());
	  }
	 
	
	 
	  @RequestMapping(method=RequestMethod.POST, value = "/getlocodetails")
	   public List<LocoUncleansedDataAddNewLoco> getLocoDetailBasedOnLocoNo(@RequestBody LocoUncleansedDataAddNewLoco locoUncleansedDataAddNewLoco){
		  		  System.out.println(locoUncleansedDataAddNewLoco.getLoco_no());
		 return obj_newlocoservice.getLocoDetailOnLocoNo(locoUncleansedDataAddNewLoco.getLoco_no());
	  }
	 
	  @RequestMapping(method=RequestMethod.POST, value = "/getlocodetailforzonaldraft")
	   public List<LocoUncleansedDataAddNewLoco> findlocoDetailforZonalDraft(){		  		  

		 return obj_newlocoservice.findlocoDetailforZonalDraft();}
	  
	  
	  //Anshul ........19-06-2023
		 
		  @RequestMapping(method=RequestMethod.GET, value = "/getdraftnloco")
		   public List<LocoUncleansedDataAddNewLoco>  findDraftNewLoco(@RequestParam(value="shed") String shed)
		   {
			  return obj_newlocoservice.findDraftNewLoco(shed);
	 }

		  
		//Anshul.............19-06-2023
			@RequestMapping(method=RequestMethod.POST, value="/fwdnewloco")
			public String forwardForApprovalNewLoco(@RequestBody LocoUncleansedDataAddNewLoco locoapp) throws Exception 
			{
				logger.info("----------/forwardForApprovalNewLoco");
				
				return obj_newlocoservice.forwardForApprovalNewLoco(locoapp);
					} 
			
		

		 //Ritu 06-07-2023
			@RequestMapping(method=RequestMethod.GET, value="/getlocoservice")
			public List<String> getlocoservice() throws Exception 
			{
				logger.info("----------/getlocoservice");
				
				return obj_newlocoservice.getlocoservice();
					} 
	 

}
