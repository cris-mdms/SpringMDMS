package com.mdms.loco.locouncleansed.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdms.loco.locouncleansed.model.LocoApprovedData;
import com.mdms.loco.locouncleansed.model.LocoApprovedDslData;
import com.mdms.loco.locouncleansed.model.LocoUncleansedDataElectric;
import com.mdms.loco.locouncleansed.repository.LocoApprovedDataRepository;
import com.mdms.loco.locouncleansed.repository.LocoApprovedDslDataRepo;
@Service
public class LocoApproveService {	
	@Autowired 
	private LocoApprovedDataRepository approved_repo;
	@Autowired 
	private LocoApprovedDslDataRepo dslapproved_repo;
	public boolean adddata(LocoApprovedData objcleansed) {
		try{
			
			objcleansed.setElec_Remarks("Approved");
			objcleansed.setElec_Status("A");		
			
		if(approved_repo.save(objcleansed) != null)
					return true;				
				
			}
	catch(Exception e){
		
		System.out.println(e);
		
		}
		return false;
	}
	public boolean adddsldata(LocoApprovedDslData objcleansed) {
		try{
			
			objcleansed.setdRemarks("Approved");
			objcleansed.setvStatus("A");		
			
		if(dslapproved_repo.save(objcleansed) != null)
					return true;				
				
			}
	catch(Exception e){
		
		System.out.println(e);
		
		}
		return false;
	}
	
	 public List<LocoApprovedData> getApprovedLocos(LocoApprovedData obj_approved) {
//			// TODO Auto-generated method stub
			System.out.println("getGoldendlocos");
			String shedid=obj_approved.getElec_locoOwningShed();
			String locoflag=obj_approved.getLocoflag();
			approved_repo.getApprovedLoco(shedid,locoflag);
			List<LocoApprovedData> approvedLoco= new ArrayList<>();
			approved_repo.getApprovedLoco(shedid,locoflag)
			.forEach(approvedLoco::add);
			System.out.println(" End GetGoldenLocos");
			return approved_repo.getApprovedLoco(shedid,locoflag);
		}
	 
		public List<LocoApprovedData> getLocoApprovedHypershed( LocoApprovedData objelecmodel) {
//			// TODO Auto-generated method stub
			System.out.println("getDraftUnapprovedLocos");
			String shedid=objelecmodel.getElec_locoOwningShed();
			approved_repo.getLocoApprovedHypershed(shedid);
			List<LocoApprovedData> uncleaseLoco= new ArrayList<>();
			approved_repo.getLocoApprovedHypershed(shedid)
			.forEach(uncleaseLoco::add);
			System.out.println(" End getuncleansedunapprovedocos");
			return approved_repo.getLocoApprovedHypershed(shedid);
//			return uncleaseLoco;
		}
		
		//status changed - Approved(A)  for dsl attribute
		public boolean updatedslstatus(LocoApprovedDslData updatestatus) {
			try{
			String locostatus= updatestatus.getvStatus();
			String remarks=updatestatus.getdRemarks();
			String user_id=updatestatus.getUserid();		
			
			int lno=updatestatus.getLoco_No();
			System.out.println(lno);
			dslapproved_repo.updatedslstatus(locostatus,remarks,user_id,lno);				
				return  true ;			
			}
			catch(Exception e){
				
				System.out.println(e);
				return false;
			}
	
}
		
		//service to Update E-golden  Records in Approved Table  
		public boolean updateEGoldenRecord(LocoApprovedData approvedloco) {
			try{ 
				 Date date = new Date(); 
			String var1=approvedloco.getElec_locoCabac();
			String var2=approvedloco.getElec_locoPermanentDomain();
			String var3=approvedloco.getElec_locoControlType();
			Date var4=approvedloco.getElec_locoRcvdDate();
			String var5=approvedloco.getElec_locoAuxiliaryOutput();			
			String var6=approvedloco.getElec_locoTractionMotorType();
			String var7=approvedloco.getElec_locoHotelLoad();
			String var8=approvedloco.getIsGPSEnabled();
			String var9=approvedloco.getFlagType();
			String var10=approvedloco.getElec_locoBrakeSubtype();
			String txnDate1 = new SimpleDateFormat("yyyy-MM-dd").format(date);
			String axleload=approvedloco.getLoco_Axleload();
			Date txnDate = date;
			int locono=approvedloco.getElec_locoNo();
			System.out.println(locono);
			approved_repo.updateEGoldenRecord(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10,txnDate,axleload, locono);
			System.out.println(approved_repo.updateEGoldenRecord(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10,txnDate,axleload,locono));
			
			return  true ;			
			}
			catch(Exception e){
				
				System.out.println(e);
				return false;
			}					
		}
		
		//service to Update D-golden  Records in Approved Table  Developer : Gaurav 
				public boolean updateDGoldenRecord(LocoApprovedData approvedloco) {
					try{ 
						 Date date = new Date(); 
					String var1=approvedloco.getElec_locoType();
					String var2=approvedloco.getElec_locoPermanentDomain();
					String var3=approvedloco.getElec_locoControlType();
					Date var4=approvedloco.getElec_locoRcvdDate();
					String var5=approvedloco.getElec_locoBrakeType();			
					String var6=approvedloco.getElec_locoTractionMotorType();					
					String var7=approvedloco.getIsGPSEnabled();
					String var8=approvedloco.getFlagType();
					String var9=approvedloco.getElec_locoBrakeSubtype();
					String txnDate1 = new SimpleDateFormat("yyyy-MM-dd").format(date);
					Date txnDate = date;
					String axleload=approvedloco.getLoco_Axleload();
					int locono=approvedloco.getElec_locoNo();
					System.out.println(locono);
					approved_repo.updateDGoldenRecord(var1, var2, var3, var4, var5, var6, var7, var8, var9, txnDate, axleload,locono);
					System.out.println(approved_repo.updateDGoldenRecord(var1, var2, var3, var4, var5, var6, var7, var8, var9, txnDate,axleload,locono));
					
					return  true ;			
					}
					catch(Exception e){
						
						System.out.println(e);
						return false;
					}					
				}
		
				public boolean updateLocoApprove(LocoApprovedData locoApprModel) {
					boolean t=false;
					//int i =0;
					
					
					try {
						System.out.println("t one==========="+t);
						approved_repo.updateLocoApproveData(locoApprModel.getElec_locoOwningZone() ,locoApprModel.getElec_locoOwningShed(),locoApprModel.getElec_locoOwningdivision(),locoApprModel.getElec_locoNo());
						t=true;
						//System.out.println("i========="+i);
						//int i = locoApproveRepo.updateLocoApproveData(locoApprModel.getLocoOwningZone(), locoApprModel.getLocoOwningShed(),locoApprModel.getLocoOwningDivision(),locoApprModel.getLocoNo());

					/*
					 * if(i==1) { flag =true ; }
					 */ 
					
					System.out.println("t two==========="+t);
					return t;
					
					}catch(Exception e) {
						t=false;
						e.printStackTrace();
//						System.out.println(e.getMessage());
						//return 0;
						return t;
					}
				}

				// jyoti bisht 23-09-22
				public List<LocoApprovedData> getGoldenLoco (String loco_owning_shed) {				
					return approved_repo.getGoldenLocoTranfer(loco_owning_shed);
				}
				
				
                // JYOTI BISHT 17-10-22
				
				public int getLocoApproved(String from, String to) throws ParseException
				{
					Date date1= new SimpleDateFormat("yyyy-MM-dd").parse(from);  
					Date date2= new SimpleDateFormat("yyyy-MM-dd").parse(to);  
					return approved_repo.getLocoApproved(date1, date2);

				}
				
				// JYOTI BISHT 6-1-23
				
				public List<LocoApprovedData> get_loco_details(String zone, String shed, String status)
				{
					return approved_repo.getLocoDetails(zone, shed, status);
				}
				
		
				

}
