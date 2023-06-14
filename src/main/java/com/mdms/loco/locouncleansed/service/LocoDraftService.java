package com.mdms.loco.locouncleansed.service;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mdms.loco.locouncleansed.model.LocoUncleansedData;
import com.mdms.loco.locouncleansed.model.LocoUncleansedDataElectric;
import com.mdms.loco.locouncleansed.repository.LocoUncleansedDataElectricRepository;
import com.mdms.loco.locouncleansed.repository.LocoUncleansedDataRepository;

import java.text.ParseException;
@Service
public class LocoDraftService {
	@Autowired
	private LocoUncleansedDataElectricRepository obj_elecrepo;
	
	@Autowired
	private LocoUncleansedDataRepository obj_dslrepo;
	
	
	//saving data 
	public boolean adddata(LocoUncleansedDataElectric obj_electricclass) {
//		try{
		 Date date = new Date(); 
//		 obj_electricclass.setElec_locoDateOfCommision(date);
//		 obj_electricclass.setElec_locoDateOfCommision(date);
//		 obj_electricclass.setElec_locoDateOfCommision(date);
		if(obj_elecrepo.save(obj_electricclass) != null)
		{
					return true;	
		}
//catch(Exception e){
			
			
		else {	return false;}
//		}
		
		
					}
	
	// JYOTI BISHT 17-10-22
	
				public int getLocoDraft(String from, String to) throws ParseException
				{
					Date date1= new SimpleDateFormat("yyyy-MM-dd").parse(from);  
					Date date2= new SimpleDateFormat("yyyy-MM-dd").parse(to);  
					return obj_elecrepo.getLocoDraft(date1, date2);

				}
				
				
				
 
	
	//saving data -dloco
			public boolean adddata(LocoUncleansedData uncleanseddloco) {
				 Date date = new Date(); 
				if(obj_dslrepo.save(uncleanseddloco) != null)
					
							return true;
						
						else return false;
					}
			
			public List<LocoUncleansedDataElectric> getDraftLocos(LocoUncleansedDataElectric objelecmodel) {
//				// TODO Auto-generated method stub
				System.out.println("getDraftUnapprovedLocos");
				int elocono=objelecmodel.getElec_locoNo();
				obj_elecrepo.getDraftLoco(elocono);
				List<LocoUncleansedDataElectric> uncleaseLoco= new ArrayList<>();
				obj_elecrepo.getDraftLoco(elocono)
				.forEach(uncleaseLoco::add);
				System.out.println(" End getuncleansedunapprovedocos");
				return obj_elecrepo.getDraftLoco(elocono);
//				return uncleaseLoco;
			}
			
			
			
			//delete draft record
			public boolean deletedraftloco ( LocoUncleansedDataElectric obj_cleanseLoco){
			try{  Date date = new Date(); 
				int lno=obj_cleanseLoco.getElec_locoNo();
						System.out.println(lno);
				obj_elecrepo.deletedraftloco(lno);
				return true;
			}
			
			catch(Exception e){
				
				System.out.println(e);
				return false;
			}
				
				
			}
			
			//service to Update Draft Records in Uncleansed Table  
			public boolean updaterecord(LocoUncleansedDataElectric cleanseLoco) {
				try{ 
					 Date date = new Date(); 
				String var1=cleanseLoco.getElec_locoType();
				String var2=cleanseLoco.getElec_locoManfacturer();
				String var3=cleanseLoco.getElec_locoControlType();
				String var4=cleanseLoco.getElec_locoPermanentDomain();
				
				Date var5=cleanseLoco.getElec_locoRcvdDate();
				String txnDate1 = new SimpleDateFormat("yyyy-MM-dd").format(date);
				Date txnDate = new SimpleDateFormat("yyyy-MM-dd").parse(txnDate1);
				Date var6=cleanseLoco.getElec_locoDateOfCommision();
				String var7=cleanseLoco.getElec_locoAuxiliaryOutput();				
				String var8=cleanseLoco.getElec_locoTractionMotorType();
			    String var9=cleanseLoco.getElec_locoOwningZone();
			    String var10=cleanseLoco.getElec_locoOwningShed();
			    String var11=cleanseLoco.getElec_locoBoogieType();
			    String var12=cleanseLoco.getElec_locoLeaseType();
			    String var13=cleanseLoco.getElec_locoBrakeType();
			    String var14=cleanseLoco.getElec_locoBrakeSubtype();
			    String var15=cleanseLoco.getElec_locoCabac();
			    Date var16=cleanseLoco.getElec_locoEntryDate();
			    String var17=cleanseLoco.getIsGPSEnabled();
			    String var18 = cleanseLoco.getElec_Status();
			    String  var19 = cleanseLoco.getElec_Remarks();
			    String var20=cleanseLoco.getElec_locoHotelLoad();
			    String var21=cleanseLoco.getFlagType();
			    Date var22=cleanseLoco.getLoco_manufacturing_date();
			    String var23=cleanseLoco.getEloco_Gaugetype();
			    String var24=cleanseLoco.getEloco_Axleload();				
				String var25=cleanseLoco.getEloco_Hauling_Power();					
			     int locono=cleanseLoco.getElec_locoNo();
				System.out.println(locono);
				obj_elecrepo.updateEDraftRecord(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20, var21, var22,var23, var24, var25, locono);
				System.out.println(obj_elecrepo.updateEDraftRecord(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20, var21,var22,var23, var24, var25,locono));
				
				return  true ;			
				}
				catch(Exception e){
					
					System.out.println(e);
					return false;
				}					
			}
			
			
			//update - draft record to unapproved record by user 
			public boolean updatediseldraftrecord(LocoUncleansedData obj_cleanseDieselLoco) {
				try{		 Date date = new Date(); 			
				String var1=obj_cleanseDieselLoco.getLoco_Type();
				Date var2=obj_cleanseDieselLoco.getLoco_Doc();
				String var3=obj_cleanseDieselLoco.getLoco_Owningshed();
				String var4=obj_cleanseDieselLoco.getLoco_Manufac();
				Date var5=obj_cleanseDieselLoco.getLoco_Recd_Dt();		

				double var6=obj_cleanseDieselLoco.getLoco_Axleload();				
				String var7=obj_cleanseDieselLoco.getLoco_Hauling_Power();
			    String var8=obj_cleanseDieselLoco.getLoco_Owningzone();
			    String var9=obj_cleanseDieselLoco.getLoco_Tractioncode();
			    String var10=obj_cleanseDieselLoco.getLoco_Brake();
			    String var11=obj_cleanseDieselLoco.getLoco_Control_Type();
			    Date var12=obj_cleanseDieselLoco.getLoco_Entrydt();
			    String var13=obj_cleanseDieselLoco.getLoco_Permanentdomain();
			    String var14=obj_cleanseDieselLoco.getLoco_Gaugetype();
			    String var15= obj_cleanseDieselLoco.getLoco_Traction_Motor_Type();
			    String var16=obj_cleanseDieselLoco.getIsGPSEnabledDiesel();
			     String var17 = obj_cleanseDieselLoco.getLoco_lease_type();
			    String  var18 = obj_cleanseDieselLoco.getvStatus();
			    String var19=obj_cleanseDieselLoco.getdRemarks();
			    String var20=obj_cleanseDieselLoco.getLoco_MfgCountry();			  
			    Date var21=obj_cleanseDieselLoco.getLoco_Mfg_Dt();		
			     int locono=obj_cleanseDieselLoco.getLoco_No();
			     String var22=obj_cleanseDieselLoco.getFlagTypeDiesel();
			     String var23=obj_cleanseDieselLoco.getLocoBrakeSubtype();
				System.out.println(locono);
				System.out.println(var2);
				System.out.println(var23);
				System.out.println(var14);
				obj_dslrepo.updateDslDraftRecord(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20, var21,var22,var23, locono);
				return  true ;			
				}
				catch(Exception e){
					
					System.out.println(e);
					return false;
				}					
			}

			public List<LocoUncleansedDataElectric> getDraftLocoApprovalHypershed( LocoUncleansedDataElectric objelecmodel) {
//				// TODO Auto-generated method stub
				System.out.println("getDraftUnapprovedLocos");
				String shedid=objelecmodel.getElec_locoOwningShed();
				obj_elecrepo.getDraftLocoApprovalHypershed(shedid);
				List<LocoUncleansedDataElectric> uncleaseLoco= new ArrayList<>();
				obj_elecrepo.getDraftLocoApprovalHypershed(shedid)
				.forEach(uncleaseLoco::add);
				System.out.println(" End getuncleansedunapprovedocos");
				return obj_elecrepo.getDraftLocoApprovalHypershed(shedid);
//				return uncleaseLoco;
			}
			
			public List<LocoUncleansedDataElectric> getCleansedDraftLoco(LocoUncleansedDataElectric objelecmodel) {
//				// TODO Auto-generated method stub
				System.out.println("getcleansedDraftLocos");
				String shedid=objelecmodel.getElec_locoOwningShed();
				String locoflag=objelecmodel.getLocoflag();
				obj_elecrepo.getcleansedDraftLoco(shedid,locoflag);
				List<LocoUncleansedDataElectric> uncleaseLoco= new ArrayList<>();
				obj_elecrepo.getcleansedDraftLoco(shedid,locoflag)
				.forEach(uncleaseLoco::add);
				System.out.println(" End getcleansedDraftLocos");
				return obj_elecrepo.getcleansedDraftLoco(shedid,locoflag);
//				return uncleaseLoco;
			}
			
}
