package com.mdms.loco.locouncleansed.controller;




import java.util.List;
import java.util.Optional;

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
import com.mdms.loco.locouncleansed.model.LocoApprovedDslData;
import com.mdms.loco.locouncleansed.model.LocoUncleansedDataElectric;
import com.mdms.loco.locouncleansed.repository.LocoApprovedDataRepository;
import com.mdms.loco.locouncleansed.service.LocoApproveService;
import java.text.ParseException;
@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")

@RestController
public class LocoApproveController {
Logger logger=LoggerFactory.getLogger(LocoApproveController.class);
	
	@Autowired
	 private LocoApproveService obj_cleasedservice;
	
	@Autowired
	LocoApprovedDataRepository loco_approve_repo;
	
	@RequestMapping(method=RequestMethod.POST,value="/savelocogoldenrecord")
		public boolean adddata(@RequestBody LocoApprovedData objcleansed){		
		boolean flag= obj_cleasedservice.adddata(objcleansed);
				return true;}	
	
	
	@RequestMapping(method=RequestMethod.POST,value="/savedsllocogoldenrecord")
		public boolean adddsldata(@RequestBody LocoApprovedDslData objdslcleansed){		
		boolean flag= obj_cleasedservice.adddsldata(objdslcleansed);
				return true;}	
	
	
	 @RequestMapping(method=RequestMethod.POST, value = "/locogoldenrecords")
 	public List<LocoApprovedData> geteUnapprovedLoco(@RequestBody LocoApprovedData obj_approved){
 		System.out.println("shedid"+ obj_approved.getElec_locoOwningShed());
 		return obj_cleasedservice.getApprovedLocos(obj_approved);
			
 	}
	 @RequestMapping(method=RequestMethod.POST, value = "/gethyperApprovedLocoService")
		public List<LocoApprovedData> getLocoApprovedHypershed(@RequestBody LocoApprovedData objdraft ){
			System.out.println("shedid"+ objdraft.getElec_locoOwningShed());
	    return obj_cleasedservice.getLocoApprovedHypershed(objdraft);	
		}

	 
	//status update U to A diesel unapproved table
 	@RequestMapping(method=RequestMethod.POST, value="/updatedslstatusApproved")
 	public boolean updatestatus(@RequestBody LocoApprovedDslData updatestatus) {
 		System.out.println("status"+updatestatus.getvStatus());
 		System.out.println("loconohh"+updatestatus.getLoco_No());
 		System.out.println("usid"+updatestatus.getUserid()); 					    		
 				boolean flag=obj_cleasedservice.updatedslstatus(updatestatus);
 					return flag;
 			}
 	
 	//update record - Electric Golden Record
 	 	@RequestMapping(method=RequestMethod.POST, value ="/updateEGoldenRecord")
 	 	public boolean updateEGoldenRecord(@RequestBody LocoApprovedData obj_approvedclass)
 	 	{
 	 		System.out.println("locono"+ obj_approvedclass.getElec_locoNo());	
 	 		System.out.println("flagtype"+ obj_approvedclass.getFlagType());
 	 		System.out.println("isgps"+ obj_approvedclass.getIsGPSEnabled()); 	
 	 		System.out.println("hotel"+ obj_approvedclass.getElec_locoHotelLoad()); 		
 	 		
 	 		System.out.println("brakesubtype"+ obj_approvedclass.getElec_locoBrakeSubtype()); 
 	 		System.out.println("recddt"+ obj_approvedclass.getElec_locoRcvdDate());  		
	boolean flag = obj_cleasedservice.updateEGoldenRecord(obj_approvedclass);
 	 	return flag;
 	 	}
 	 	
 	 //update record - Diesel Golden Record
 	 	@RequestMapping(method=RequestMethod.POST, value ="/updateDGoldenRecord")
 	 	public boolean updateDGoldenRecord(@RequestBody LocoApprovedData obj_approvedclass)
 	 	{
 	 		System.out.println("locono"+ obj_approvedclass.getElec_locoNo());	
 	 		System.out.println("flagtype"+ obj_approvedclass.getFlagType());
 	 		System.out.println("isgps"+ obj_approvedclass.getIsGPSEnabled()); 	
 	 		System.out.println("brakesubtype"+ obj_approvedclass.getElec_locoBrakeSubtype()); 
 	 		System.out.println("recddt"+ obj_approvedclass.getElec_locoRcvdDate());  		
	boolean flag = obj_cleasedservice.updateDGoldenRecord(obj_approvedclass);
 	 	return flag;
 	 	}

 	 	@RequestMapping(method=RequestMethod.POST, value="/updateLocoApprovalDetails")
 		public boolean callUpdateLocoApproveDetails(@RequestBody LocoApprovedData objlocoAppr)
 		{
 			//return objlocoAppr.getLocoTypeAttributes(objlocoType);
 			boolean temp = false;
 			
 			//temp = obj_locoApprService.updateLocoApprove(objlocoAppr);
 			temp = obj_cleasedservice.updateLocoApprove(objlocoAppr);
 			return temp;
 			/*
 			 * if (temp) return true; else return false;
 			 */
 		}
 	 	
 	 	
//JYOTI BISHT 23-09-22
 	 	
 		@PostMapping("/getGoldentransferLoco")
 		public List<LocoApprovedData> selectGoldenLocoApproveDetails(@RequestParam("loco_owning_shed") String owning_shed)
 		{
 	
 			return obj_cleasedservice.getGoldenLoco(owning_shed);
 			
 		}

 		//JYOTI BISHT 17-10-22
 	 	 
 		
 		@PostMapping("/get_loco_approved_count")
		public int getlocoApproved(@RequestParam("from")String from, @RequestParam("to") String to) throws ParseException{
	    return obj_cleasedservice.getLocoApproved(from, to);	
		}
 		
 		//JYOTI BISHT 06-01-23
 		
 		@PostMapping("/get_golden_loco_details")
	    public List<LocoApprovedData> geteLocoDetails(@RequestParam("zone") String zone, @RequestParam("shed") String shed, @RequestParam("status") String status)
    	{
	   
	    	return obj_cleasedservice.get_loco_details(zone, shed, status);
				
	    }
 		
 		
       //JYOTI BISHT 23-06-23
 		
 		@PostMapping("/get_complete_loco_details")
	    public LocoApprovedData geteLocoDetails(@RequestParam("loco_no")String loco_no)
    	{
 			
 			LocoApprovedData loco=null;
 		
 		
 			loco=loco_approve_repo.getLocoCompletedetail(Integer.parseInt(loco_no));
 			if(loco!=null)
 			{
 				return loco;
 			}
 			else
 			return null;
	    		
	    }
 		
	
		
}
