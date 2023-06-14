package com.mdms.loco.locotransfer.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdms.loco.locotransfer.model.LocoTransferModel;
import com.mdms.loco.locotransfer.repo.LocoTransferRepo;
@Service
public class LocoTransferService {
	@Autowired
	LocoTransferRepo locoTransferRepo;

	public int saveLocoDetails(LocoTransferModel locoTransferModel) { 
		System.out.print(locoTransferModel.getLoco_transfer_letter_no());
		System.out.print(locoTransferModel.getLoco_traction_code());
		return
	  locoTransferRepo.saveLocoTransferDetail(locoTransferModel.getLoco_No(),
	  locoTransferModel.getLoco_new_shed(), locoTransferModel.getLoco_new_zone(),
	  locoTransferModel.getLoco_old_shed(), locoTransferModel.getLoco_old_zone(),	
	  locoTransferModel.getLoco_traction_code(),locoTransferModel.getLoco_transfer_letter_no(),
	  locoTransferModel.getLoco_transfer_date(), locoTransferModel.getRemarks(),
	  locoTransferModel.getTransfer_by(), locoTransferModel.getData_entry_date(),
	  locoTransferModel.getStatus(),locoTransferModel.getLoco_new_division(),
	locoTransferModel.getLoco_table_name());
	  
	
	 
	 
}
	//LocoCountshedWiseResponse
	public int  getLocoCountShedWise(LocoTransferModel locoTransferModel) {
		return locoTransferRepo.getLocoCountzonewise(locoTransferModel.getLoco_old_zone());
	}
	
	
	public List<LocoTransferModel> findLocoStatusWise(LocoTransferModel locoTransferModel){
		
		//this one
		return locoTransferRepo.getLocoDataStatusWise(locoTransferModel.getStatus(),locoTransferModel.getLoco_old_zone(),locoTransferModel.getLoco_traction_code());
		
	}
	
	public int updateLocoStatus(LocoTransferModel locoTransferModel) {
		return locoTransferRepo.updateStatus(locoTransferModel.getStatus(), locoTransferModel.getAccept_user_id(), locoTransferModel.getAccept_remarks(),locoTransferModel.getAccept_txn_time(),locoTransferModel.getLoco_No());
	}
	
	public int updateRejectLocoStatus(LocoTransferModel locoTransferModel) {
		return locoTransferRepo.updateRejectStatus(locoTransferModel.getStatus(), locoTransferModel.getReject_user_id(), locoTransferModel.getReject_remarks(),locoTransferModel.getReject_txn_time(),locoTransferModel.getLoco_No());
	}
	
	//for new shed wise count
		public int  getLocoCountNewShedWise(LocoTransferModel locoTransferModel) {
			return locoTransferRepo.getLocoCountNewShedwise(locoTransferModel.getLoco_new_shed());
		}
		
		
		 //for new shed wise 
		public List<LocoTransferModel> findLocoStatusNewShedWise(LocoTransferModel locoTransferModel){
			return locoTransferRepo.getLocoDataStatusNewShedWise(locoTransferModel.getStatus(),locoTransferModel.getLoco_new_shed());
			
		}
	
//		public boolean checkGivenLocoNo(LocoTransferModel locoTransferModel) {
//			String status="";
//			boolean flag=locoTransferRepo.checkLocoExitOrNot(locoTransferModel.getLoco_No());
//			if(flag==true) {
//					//status= "Exist";
//			return true;
//			}
//			else {
//				    //status="NO";
//			return false;
//			}
//		}
		public  List<LocoTransferModel> checkGivenLocoNo(LocoTransferModel locoTransferModel) {
//			String status="";
			return locoTransferRepo.checkLocoExitOrNot(locoTransferModel.getLoco_No());
//			boolean flag=locoTransferRepo.checkLocoExitOrNot(locoTransferModel.getLoco_No());
//			if(flag==true) {
//					//status= "Exist";
//			return true;
//			}
//			else {
//				    //status="NO";
//			return false;
//			}
		}
		
		
		public  List<LocoTransferModel> gettransferloco(String transfer_by)
		{
			System.out.println("transferby"+ transfer_by);
			return locoTransferRepo.getTransferLocoRepo(transfer_by);
		}

		// service for updating loco status -- **Gaurav Agarwal**281122**
		public void updateStatusForLoco(String sStatus, int sLocoNo) {
			locoTransferRepo.updateLocoStatus(sStatus, sLocoNo);
		}
		public int updatetrfdraftRejectLocoStatus(LocoTransferModel locoTransferModel) {
			System.out.println("reject remarks"+ locoTransferModel.getReject_remarks());
			return locoTransferRepo.updateLocoDraft(locoTransferModel.getLoco_new_shed(), locoTransferModel.getLoco_new_zone(), locoTransferModel.getLoco_transfer_letter_no(),locoTransferModel.getLoco_transfer_date(),
					locoTransferModel.getTransfer_by(),locoTransferModel.getData_entry_date(),locoTransferModel.getStatus(),locoTransferModel.getLoco_new_division(),locoTransferModel.getCount_no_of_update(),"Request Send Again",locoTransferModel.getLoco_No());
		}
		
		
		public int update_retrf_loco(LocoTransferModel locoTransferModel) {
			System.out.println("loco no"+ locoTransferModel.getLoco_No());
			return locoTransferRepo.updateRetransferLoco(locoTransferModel.getLoco_new_shed(), locoTransferModel.getLoco_new_zone(),locoTransferModel.getLoco_old_shed(), locoTransferModel.getLoco_old_zone(), 
					locoTransferModel.getLoco_transfer_letter_no(),locoTransferModel.getLoco_transfer_date(),locoTransferModel.getRemarks(),
					locoTransferModel.getTransfer_by(),locoTransferModel.getData_entry_date(),locoTransferModel.getStatus(),locoTransferModel.getLoco_new_division(),locoTransferModel.getCount_no_of_update(),locoTransferModel.getLoco_No());
		}

}
