package com.mdms.loco.locotransfer.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mdms.loco.locotransfer.model.LocoTransferModel;
import com.mdms.loco.locotransfer.service.LocoTransferService;
@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")
@RestController
public class LocoTransferController {

	@Autowired
	LocoTransferService locoTransferService;
	

	
	@RequestMapping(method=RequestMethod.POST, value="/savelocotransferdetail")
	public boolean insertLocoDetails(@RequestBody LocoTransferModel locoTransferModel) {		
		boolean flag=false;
		int a= locoTransferService.saveLocoDetails(locoTransferModel);
		if(a==1)
		{
			System.out.print(locoTransferModel.getLoco_transfer_letter_no());
			System.out.print(locoTransferModel.getLoco_traction_code());
			System.out.print(locoTransferModel.getLoco_transfer_date());
		 flag= true;
		}
		return flag;
	}
	//LocoCountshedWiseResponse
	@RequestMapping(method=RequestMethod.POST, value="/lococountzonewise")
	public int  findLocoCountShedWise(@RequestBody LocoTransferModel locoTransferModel) {
		return locoTransferService.getLocoCountShedWise(locoTransferModel);
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/getlocoforoldzonewise")
	public List<LocoTransferModel> findStatusWiseLoco(@RequestBody LocoTransferModel locoTransferModel){
		return locoTransferService.findLocoStatusWise(locoTransferModel);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/updatelocostatus")
	public boolean updateLocoStatusOfLoco(@RequestBody LocoTransferModel locoTransferModel) {
		boolean flag=false;
		int b= locoTransferService.updateLocoStatus(locoTransferModel);
		 if(b==1)
		 {
			 flag=true;
		 }
		 return flag;
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/updateRejctlocostatus")
	public boolean updateRejectLocoStatus(@RequestBody LocoTransferModel locoTransferModel) {
		boolean flag=false;
		int b= locoTransferService.updateRejectLocoStatus(locoTransferModel);
		 if(b==1)
		 {
			 flag=true;
		 }
		 return flag;
	}
	
	//count for new shed wise
	
		@RequestMapping(method=RequestMethod.POST, value="/getlocotrfdetailnewshedwise")
		public List<LocoTransferModel> findStatusWiseLoco0(@RequestBody LocoTransferModel locoTransferModel){
			return locoTransferService.findLocoStatusNewShedWise(locoTransferModel);
		}
	
		
		//for new shed wise count
		@RequestMapping(method=RequestMethod.POST, value="/locotrfcountnewshedwise")
		public int  findLocoCountNewShedWise(@RequestBody LocoTransferModel locoTransferModel) {
			return locoTransferService.getLocoCountNewShedWise(locoTransferModel);
		}

//		@RequestMapping(method=RequestMethod.POST, value="/checklocoexitornot")
//		public boolean checkLocoNo(@RequestBody LocoTransferModel locoTransferModel) {
//			return locoTransferService.checkGivenLocoNo(locoTransferModel);
//		}
		
		@RequestMapping(method=RequestMethod.POST, value="/checklocoexitornot")
		public List<LocoTransferModel> checkLocoNo(@RequestBody LocoTransferModel locoTransferModel) {
			return locoTransferService.checkGivenLocoNo(locoTransferModel);
		}
		@PostMapping("/getTransferLoco")
		public List<LocoTransferModel> get_transfer_loco_details(@RequestParam("transfer_by") String transfer_by )
		{System.out.println("transferby" + transfer_by);
			return locoTransferService.gettransferloco(transfer_by);			
			
		} 				
				
				// service for updating loco status -- **Gaurav Agarwal**281122**
				@RequestMapping(method=RequestMethod.POST, value ="/updateLocoStatus")
				public boolean updateLocoStatus(@RequestParam String cStatus, @RequestParam int cLocoNo) {
					locoTransferService.updateStatusForLoco(cStatus, cLocoNo);
					return true;		
				}	
				
				
				// service for updating draftloco status -- Ritu 030123**
				@RequestMapping(method=RequestMethod.POST, value ="/updatetrfdraftLoco")
				public boolean updateLocodraftStatus(@RequestBody LocoTransferModel obj) {
					locoTransferService.updatetrfdraftRejectLocoStatus(obj);
					return true;		
				}	
				
				
				// service for updating draftloco status -- Ritu 140123**
				@RequestMapping(method=RequestMethod.POST, value ="/update_retransferLoco")
				public boolean update_retrf_loco(@RequestBody LocoTransferModel obj) {
					locoTransferService.update_retrf_loco(obj);
					return true;		
				}	
}
