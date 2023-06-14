package com.mdms.mdms_station.stationuncleansed.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdms.mdms_station.stationuncleansed.model.StationPKey;
import com.mdms.mdms_station.stationuncleansed.model.StationUncleansedData;
import com.mdms.mdms_station.stationuncleansed.repository.StationCleansedDataRepository;
import com.mdms.mdms_station.stationuncleansed.repository.StationUncleansedDataRepository;
@Service
public class StationAddService {
@Autowired	
StationCleansedDataRepository stn_clnsd_repo;

@Autowired
StationUncleansedDataRepository stn_unclsnd_repo;


	public String checkStncodeExist(String stncode) throws Exception {
		String returnstmt=null;
		String sc;
		 sc=stn_clnsd_repo.checkStnCodeExist(stncode);	
		try {		 
			if(sc!=null)
			{
				returnstmt="true";

		}	else
		{
			returnstmt="false";
			return returnstmt; 
		
		}}catch(Exception e)
		{
			}
		return returnstmt;
		}
	
public String saveCmiCleansedDraft(StationUncleansedData stationdraftcmi)throws Exception {
	
	boolean ispresent;
	String returnstmt="";
	try {
	ispresent=stn_unclsnd_repo.findById(stationdraftcmi.getStn_Id()).isPresent();//Check if record is already present	
	if(ispresent)
	{
//1.that record is already saved as draft 
		
		String status=stn_clnsd_repo.findById(stationdraftcmi.getStn_Id()).get().getCmi_status();
		String useridcmi=stn_clnsd_repo.findById(stationdraftcmi.getStn_Id()).get().getUser_id_cmi();		
		if(status.equals("D"))
			
		{//by the same user.
			if(useridcmi.equals(stationdraftcmi.getUser_id_cmi()))
			{
				//if this is the same user
				String cmi_station_code=stationdraftcmi.getStn_Id().getStation_code();
				Date cmi_valid_from=stationdraftcmi.getStn_Id().getStation_valid_from();
				Date cmi_valid_upto=stationdraftcmi.getStn_Id().getStation_valid_upto();
				String userid=stationdraftcmi.getUser_id_cmi();
				  Date date = new Date();  
				  stn_unclsnd_repo.updateCleansedDraftCmi( userid,  cmi_station_code ,  cmi_valid_from ,  cmi_valid_upto , stationdraftcmi.getStation_numeric_code(),
					stationdraftcmi.getStation_name(),	stationdraftcmi.getTraffic_type(),stationdraftcmi.getTranshipment_flag() ,
					stationdraftcmi.getStation_class() ,stationdraftcmi.getJunction_flag(), stationdraftcmi.getInterchange_flag() , 
					stationdraftcmi.getState(), stationdraftcmi.getPincode() , stationdraftcmi.getDistrict(),stationdraftcmi.getTehsil(), 
					stationdraftcmi.getStation_short_name(), stationdraftcmi.getInterlocking_standard() , stationdraftcmi.getWorking_division(),
					stationdraftcmi.getWeight_bridge(), stationdraftcmi.getSiding() , stationdraftcmi.getBooking_type() , stationdraftcmi.getCmi_status(), date ,stationdraftcmi.getBooking_resource()  );
			returnstmt="DRAFT UPDATED SUCCESSFULLY";	
			
			}
			
			//2.that record is already saved as draft by the OTHER user.
			else
				returnstmt="TRANSACTION ABORTED . THIS DRAFT IS ALREADY SAVED BY OTHER USER.";
			
		}
		
	
		
	else returnstmt="INVALID TRANSACTION";	
	}
	
	else
	{
//		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		    Date date = new Date();  
		  
		stationdraftcmi.setTxn_date_cmi(date);
		
		if(stn_unclsnd_repo.save(stationdraftcmi)!=null) {
		
		returnstmt="DRAFT SAVED SUCCESSFULLY";
		
	}
		else
		{
				returnstmt="FAILED TO SAVE DRAFT";
		}}}
				catch(Exception e)
				{
					System.out.printf(e.getMessage(),e.getStackTrace());
					return "EXCEPTION OCCURRED!!!";
				}

	return returnstmt;
		

 
}

@Transactional(rollbackOn = Exception.class)
public String forwardToDCM(StationUncleansedData stationdataapprovebydcm) throws Exception{	 
	 boolean ispresent;
		String returnstmt="";
		try {
		ispresent=stn_unclsnd_repo.findById(stationdataapprovebydcm.getStn_Id()).isPresent();		
		if(ispresent)
		{String status=stn_unclsnd_repo.findById(stationdataapprovebydcm.getStn_Id()).get().getCmi_status();
			if(status.equals("D")) {
			String cmi_station_code=stationdataapprovebydcm.getStn_Id().getStation_code();
			Date cmi_valid_from=stationdataapprovebydcm.getStn_Id().getStation_valid_from();
			Date cmi_valid_upto=stationdataapprovebydcm.getStn_Id().getStation_valid_upto();
			String userid=stationdataapprovebydcm.getUser_id_cmi();
//			String station_status="U";
			String cmi_status="U";
			  Date date = new Date();  
			  stn_unclsnd_repo.updateCleansedDraftCmi( userid,  cmi_station_code ,  cmi_valid_from ,  cmi_valid_upto , stationdataapprovebydcm.getStation_numeric_code(),
					  stationdataapprovebydcm.getStation_name(),	stationdataapprovebydcm.getTraffic_type(),stationdataapprovebydcm.getTranshipment_flag() ,
					  stationdataapprovebydcm.getStation_class() ,stationdataapprovebydcm.getJunction_flag(), stationdataapprovebydcm.getInterchange_flag() , 
					  stationdataapprovebydcm.getState(), stationdataapprovebydcm.getPincode() , stationdataapprovebydcm.getDistrict(),stationdataapprovebydcm.getTehsil(), 
					  stationdataapprovebydcm.getStation_short_name(), stationdataapprovebydcm.getInterlocking_standard() , stationdataapprovebydcm.getWorking_division(),
					  stationdataapprovebydcm.getWeight_bridge(), stationdataapprovebydcm.getSiding() ,  stationdataapprovebydcm.getBooking_type() , cmi_status, date ,stationdataapprovebydcm.getBooking_resource());
		returnstmt="RECORD FORWARDED TO DCM SUCCESSFULLY";
			}
			
			
			
		}
		else
		{
			
			   Date date = new Date();  
				  
			   stationdataapprovebydcm.setTxn_date_cmi(date);
				
			   stn_unclsnd_repo.save(stationdataapprovebydcm);
				
				returnstmt="RECORD FORWARDED TO DCM SUCCESSFULLY";
		}
		
		
		

return returnstmt;
		}catch(Exception e)
		{
			System.out.printf(e.getMessage(),e.getStackTrace());
			return "Exception Occurred!!!";
			
		}
}


public List<String> stationCodeDiv(String division) {
	List<String> stationCode=new ArrayList<>();
	stn_unclsnd_repo.getDraftStncode(division)
	.forEach(stationCode::add);
	return stationCode;

}

@Transactional(rollbackOn = Exception.class)
public StationPKey getvalidstation(String station_code) throws Exception {	
	StationUncleansedData stndata=stn_unclsnd_repo.findvalidstn(station_code);	
	return stndata.getStn_Id();
	
	
			
		

}

public StationUncleansedData getDraftDti(String useriddti, String station_code) throws Exception
{
	
	return stn_unclsnd_repo.getDraftDti(useriddti,station_code);
	
}

@Transactional(rollbackOn = Exception.class)
public String updateDtiDraft(StationUncleansedData stationdraftdti) throws Exception {
	boolean ispresent;
	String returnstmt="";
	
	try {
	ispresent=stn_unclsnd_repo.findById(stationdraftdti.getStn_Id()).isPresent();//Check if record is already present
	// If record is already present their are two cases:
	
	if(ispresent)
	{
//1.that record is already saved as draft
		String status=stn_unclsnd_repo.findById(stationdraftdti.getStn_Id()).get().getDti_status();
		String useriddti=stn_unclsnd_repo.findById(stationdraftdti.getStn_Id()).get().getUser_id_dti();
		
		if(status.equals("D"))
			
		{//by the same user.
			if(useriddti.equals(stationdraftdti.getUser_id_dti()))
			{
				//if this is the same user
				String dti_station_code=stationdraftdti.getStn_Id().getStation_code();
				Date dti_valid_from=stationdraftdti.getStn_Id().getStation_valid_from();
				Date dti_valid_upto=stationdraftdti.getStn_Id().getStation_valid_upto();
				String userid=stationdraftdti.getUser_id_dti();
				  Date date = new Date();  
			stn_unclsnd_repo.updateDraftDti(userid,  dti_station_code,  dti_valid_from,  dti_valid_upto, stationdraftdti.getGauge_code(), stationdraftdti.getStation_category(),
					stationdraftdti.getInterchange_flag() , stationdraftdti.getTraction() , stationdraftdti.getInterlocking_standard()  , stationdraftdti.getJunction_flag() , 
					stationdraftdti.getNo_of_lines() , stationdraftdti.getOperating_station_signal(),date,stationdraftdti.getDti_status());
			returnstmt="DRAFT UPDATED SUCCESSFULLY";	
			
			}
			
			//2.that record is already saved as draft by the OTHER user.
			else
				returnstmt="TRANSACTION ABORTED . THIS DRAFT IS ALREADY SAVED BY OTHER USER.";
			
		}
		
	else if(status.equals("N"))
		{
			// 3. this record is already initiated by cmi. so update attributes but reply message as draft created
     		String dti_station_code=stationdraftdti.getStn_Id().getStation_code();
			Date dti_valid_from=stationdraftdti.getStn_Id().getStation_valid_from();
			Date dti_valid_upto=stationdraftdti.getStn_Id().getStation_valid_upto();
			String userid=stationdraftdti.getUser_id_dti();
			  Date date = new Date();  
		stn_unclsnd_repo.updateDraftDtiCmi( userid,  dti_station_code,  dti_valid_from,  dti_valid_upto, stationdraftdti.getGauge_code(), stationdraftdti.getStation_category(),
				stationdraftdti.getInterchange_flag() , stationdraftdti.getTraction() , stationdraftdti.getInterlocking_standard()  , stationdraftdti.getJunction_flag() , 
				stationdraftdti.getNo_of_lines() , stationdraftdti.getOperating_station_signal(),date,stationdraftdti.getDti_status() );
		returnstmt="DRAFT CREATED SUCCESSFULLY";	
		}
			
	else returnstmt="INVALID TRANSACTION";	
	}
	
	else
	{
//		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		
//		System.out.println(stationdraftdti.getOperating_station_signal());
		    Date date = new Date();  
	       stationdraftdti.setTxn_date_dti(date);
	    	stn_unclsnd_repo.save(stationdraftdti);
		
		returnstmt="DRAFT CREATED SUCCESSFULLY";	
		
	}

return returnstmt;
	}
	catch(Exception e)
	{
		return "Exception Occurred";
	}
 }




@Transactional(rollbackOn = Exception.class)
public String forwardDTIDraft(StationUncleansedData stationdtidataapprovebydcm) throws Exception{	 
	 boolean ispresent;
		String returnstmt="";
		try {
		ispresent=stn_unclsnd_repo.findById(stationdtidataapprovebydcm.getStn_Id()).isPresent();		
		if(ispresent)
		{String status=stn_unclsnd_repo.findById(stationdtidataapprovebydcm.getStn_Id()).get().getDti_status();
			if(status.equals("D")) {
			String dti_station_code=stationdtidataapprovebydcm.getStn_Id().getStation_code();
			Date dti_valid_from=stationdtidataapprovebydcm.getStn_Id().getStation_valid_from();
			Date dti_valid_upto=stationdtidataapprovebydcm.getStn_Id().getStation_valid_upto();
			String userid=stationdtidataapprovebydcm.getUser_id_dti();
//			String station_status="U";
			String dti_status="U";
			  Date date = new Date();  
			  stn_unclsnd_repo.forwardDraftDti(userid,  dti_station_code,  dti_valid_from,  dti_valid_upto, stationdtidataapprovebydcm.getGauge_code(), stationdtidataapprovebydcm.getStation_category(),
					  stationdtidataapprovebydcm.getInterchange_flag() , stationdtidataapprovebydcm.getTraction() , stationdtidataapprovebydcm.getInterlocking_standard()  , stationdtidataapprovebydcm.getJunction_flag() , 
					  stationdtidataapprovebydcm.getNo_of_lines() , stationdtidataapprovebydcm.getOperating_station_signal(),date,dti_status);				
			  	returnstmt="RECORD FORWARDED TO DOM SUCCESSFULLY";
			}
			
			
			
		}
		
		

return returnstmt;
		}catch(Exception e)
		{
			System.out.printf(e.getMessage(),e.getStackTrace());
			return "Exception Occurred!!!";
			
		}
}
}




