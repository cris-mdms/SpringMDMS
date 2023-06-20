package com.mdms.wagon.wagonuncleansed.service;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.ParseException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mdms.loco.locouncleansed.model.BoardZonalApproval;
import com.mdms.loco.locouncleansed.model.LocoDataFois;
import com.mdms.loco.locouncleansed.model.LocoUncleansedDataElectric;
import com.mdms.wagon.wagonuncleansed.model.IRWMS_Wagon_Type_Mapping_With_Fois;
import com.mdms.wagon.wagonuncleansed.model.IRWMS_Wagon_Type_Mapping_with_Fmm;
import com.mdms.wagon.wagonuncleansed.model.NewOwningrly;
import com.mdms.wagon.wagonuncleansed.model.NewVehicleType;

import com.mdms.wagon.wagonuncleansed.model.NewWagonDataIrwms;
import com.mdms.wagon.wagonuncleansed.model.RohPohDetailsModel;
import com.mdms.wagon.wagonuncleansed.model.VehicleNo;
import com.mdms.wagon.wagonuncleansed.model.WagonDataIRWMS1;
import com.mdms.wagon.wagonuncleansed.model.WagonUncleansedData;
import com.mdms.wagon.wagonuncleansed.repository.IRWMS_Wagon_Type_Mapping_With_Fmm_Repository;
import com.mdms.wagon.wagonuncleansed.repository.IRWMS_Wagon_Type_Mapping_With_Fois_Repository;
import com.mdms.wagon.wagonuncleansed.repository.NewOwningrlyRepo;
import com.mdms.wagon.wagonuncleansed.repository.NewVehicleTypeRepo;
import com.mdms.wagon.wagonuncleansed.repository.NewWagonDataIrwmsRepo;
import com.mdms.wagon.wagonuncleansed.repository.NewvehicleNo;
import com.mdms.wagon.wagonuncleansed.repository.RohPohDetailsRepo;
import com.mdms.wagon.wagonuncleansed.repository.WagonDataIrwmsRepository;
import com.mdms.wagon.wagonuncleansed.repository.WagonUncleansedRepository;
import com.mdms.wagon.wagonuncleansed.repository.Wagon_data_FMM_Repo;
@Service
public class WagonEditForwardService {
@Autowired
private WagonUncleansedRepository repo_uncleansed;

@Autowired
private IRWMS_Wagon_Type_Mapping_With_Fois_Repository obj_irwms_fois_mapping_repo;

@Autowired
private IRWMS_Wagon_Type_Mapping_With_Fmm_Repository obj_irwms_fmm_mapping_repo;

@Autowired
private NewvehicleNo newvehicleNo;

@Autowired
private NewOwningrlyRepo newOwningrlyRepo;

@Autowired
private NewVehicleTypeRepo newVehicleTypeRepo;

@Autowired
private WagonDataIrwmsRepository obj_repo;

@Autowired
private RohPohDetailsRepo rohPohDetailsRepo;

@Autowired
private NewWagonDataIrwmsRepo newWagonDataIrwmsRepo;

@Autowired
private Wagon_data_FMM_Repo wagon_fmm_repo;

public List<WagonUncleansedData> getWagonCleansedRecord(WagonUncleansedData objwagon)
{ 
String basedepo= objwagon.getBase_depo_station();
String status=objwagon.getStatus();
repo_uncleansed.getWagonCleansedRecord(basedepo,status);
List<WagonUncleansedData> temp =new ArrayList<>();
repo_uncleansed.getWagonCleansedRecord(basedepo,status).forEach(temp::add);
return repo_uncleansed.getWagonCleansedRecord(basedepo,status);
	}



	
//	  public List<String> getvehicaltypeirwms(NewWagonDataIrwms obj){
//		 
//			String owningrly=obj.getOwningrly();
//			newWagonDataIrwmsRepo.getvehicaltype(owningrly);
//			 List<String> temp1 =new ArrayList<>();		
//			newWagonDataIrwmsRepo.getvehicaltype(owningrly).forEach(temp1::add);	
//			return newWagonDataIrwmsRepo.getvehicaltype(owningrly);
//	  }
	 

	/*
	 * public List<NewWagonDataIrwms> getvehicletypeirwms(String owningrly){ return
	 * newWagonDataIrwmsRepo.getvehicaltype(owningrly);
	 */
	
	
 
	


//public List<Long> getvehicalnumberirwms(NewWagonDataIrwms obj){	
//	List<Long> temp =new ArrayList<>();
//	String vehicaltype= obj.getVehicletype();
//	String owningrly=obj.getOwningrly();
//	newWagonDataIrwmsRepo.getvehicalnumber(vehicaltype,owningrly).forEach(temp::add);	
//	if(temp.isEmpty()) {
//		return  temp ;
//	}
//	else
//		System.out.println("data" +temp);
//		return  temp;
//	
//
//}

public List<NewWagonDataIrwms> getNewWagonDataIrwms(){
	return newWagonDataIrwmsRepo.getNewWagonDataIrwms();
}



public List<NewWagonDataIrwms> findwagondata(String vehicletype,String owningrly,Long vehicleno){
	return newWagonDataIrwmsRepo.getNewWagonDataIrwmsDetails(vehicletype, owningrly, vehicleno);
}

public List<VehicleNo> getvehicleNoIrwms(String vehicletype,String owningrly, String groupname){
	return newvehicleNo.getVehicleNO(vehicletype,owningrly,groupname);
}

// get wagon number from wagon uncleansed - Draft and Reject Record - Developer : ritu 22.12.21
public List<WagonUncleansedData> getdraftVehicleNO(String vehicletype,String owningrly, String groupname){
	return repo_uncleansed.getdraftVehicleNO(vehicletype,owningrly,groupname);
}

public List<VehicleNo> getRohPohvehicleNoIrwms(String vehicletype,String owningrly, String groupname){
	//return newvehicleNo.getVehicleNO(vehicletype,owningrly,groupname);
	return newvehicleNo.getRohPohVehicleNO(vehicletype, owningrly, groupname);
}

public List<NewOwningrly> getOwingrly(){
	return newOwningrlyRepo.getOwingrlyData();
	
}

public List<NewVehicleType> getVehicleTypeDetails(String owningrly, String groupname){
	return newVehicleTypeRepo.getVehicleTypeData(owningrly,groupname);
}


public List<String> getgroupname(String rly)
{
	return obj_repo.getgroupname( rly);
}


//Developer : Ritu : Service to check  wagon number exist  Dt. 13.12.21 
public List<WagonUncleansedData>  checkwagonexist(WagonUncleansedData wgnno) {	
	List<WagonUncleansedData> wgnno1= new ArrayList<>();	
	repo_uncleansed.checkwagonexist(wgnno.getWagon_no())
	.forEach(wgnno1::add);		
	if(wgnno1.isEmpty()) {
		return  wgnno1 ;
	}
	else
		System.out.println("data" +wgnno1);
		return  wgnno1;
	

}

//Developer : Ritu : Service to Save  Wagon Clean Data  as draft or U Dt. 15.12.21 
	public boolean adddata(WagonUncleansedData obj_save) {
		Date date = new Date();  
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		obj_save.setTxn_dates(date);	
		
//		try{
		if(repo_uncleansed.save(obj_save) != null)
		{
					return true;	
		}
//catch(Exception e){
			
			
		else {	return false;}
//		}
		
		
					}
	
	//Developer : Ritu : Service to Update Wagon Draft Data  Dt. 17.12.21 
	@Transactional(rollbackOn = Exception.class)
	public String updatewagondraft(WagonUncleansedData updatewagon) {
		Date date = new Date();
		try {String returnValue = null;
			String wgntype=updatewagon.getWagon_type();
			String rly=updatewagon.getWagon_owning_rly();
			String orgtype=updatewagon.getOrgnization_type();		
			String rfid1=updatewagon.getWagon_rfid1();
		String rfid2=updatewagon.getWagon_rfid2();
			String clasgroup=updatewagon.getWagon_class_group();
			Long tarewght=updatewagon.getWagon_tare();
			Long carrycap=updatewagon.getWagon_carrying_capacity();
			String scheme=updatewagon.getWagon_scheme_name();
			Integer mfgcode=updatewagon.getWagon_manufacture_code();
			String  wgnstatus=updatewagon.getWagon_status();
			String status=updatewagon.getStatus();
			String remarks=updatewagon.getRemarks();
			String uid=updatewagon.getUser_id();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			updatewagon.setTxn_dates(Timestamp.valueOf(formatter.format(new Date())));	
			Date txndt=updatewagon.getTxn_dates();
			System.out.println(txndt);
			Date mfgdt=updatewagon.getWagon_manufacture_date();
			String coowner=updatewagon.getWagon_co_owner();
			String basestn=updatewagon.getBase_depo_station();
			String stcktypecode=updatewagon.getStock_type_code();
			String mfgcountry=updatewagon.getManufacturing_country();
			BigInteger wgnoldno=updatewagon.getWagonno_old();
			String mfgyr=updatewagon.getWagon_manufacture_year();
			String allotedby=updatewagon.getAlloted_by();
			String alloteno=updatewagon.getAllotment_no();
			Date alloteddt=updatewagon.getAllotment_date();
			String gaugecode=updatewagon.getWagon_gauge_code();
			BigInteger wagonno=updatewagon.getWagon_no();				
			repo_uncleansed.updatewagondraft(wgntype, rly, orgtype, rfid1, rfid2, clasgroup, tarewght, carrycap, scheme, mfgcode, wgnstatus, 
					status, remarks, uid,  mfgdt, coowner, basestn, stcktypecode,  mfgcountry, wgnoldno, mfgyr, allotedby, alloteno, alloteddt, txndt,gaugecode,wagonno);
			returnValue = "Record Update Sucessfully";
			return returnValue;
		} catch (Exception e) {

			System.out.println(e);
			return "Failed To Approve Record";
		}

	}

	

public List<RohPohDetailsModel> getRohPohDetails(String owningrly,String groupname,String vehicletype,Long vehicleno){	
return rohPohDetailsRepo.getRohPohData( owningrly, groupname, vehicletype, vehicleno);
}

//Developer : Ritu : Service to update  Wagon clean status(D) in wagon irwms table  Data  Dt. 21.12.21 
	public boolean updatestatus(WagonDataIRWMS1 uncleansedwagon ) {
		try{
		String cleanstatus= uncleansedwagon.getClean_status();
		Long wagonno=uncleansedwagon.getVehicleno();
		System.out.println(wagonno);
		obj_repo.updateirwmsstatus(wagonno);				
			return  true ;
		
		}
		catch(Exception e){
			
			System.out.println(e);
			return false;
		}
	}	

	
	public List<IRWMS_Wagon_Type_Mapping_With_Fois> getirwmsmappingdatawithfois(){
		return obj_irwms_fois_mapping_repo.getirwmsmappingdatawithfois();
	}

	public List<IRWMS_Wagon_Type_Mapping_with_Fmm> getirwmsmappingdatawithfmm(){
		return obj_irwms_fmm_mapping_repo.getirwmsmappingdatawithfmm();
	}
	// Jyoti Bisht 1-11-22
	public List<Object[]> integration_stats(String from, String to) throws ParseException
	{   
		Date date1= new SimpleDateFormat("yyyy-MM-dd").parse(from);  
		Date date2= new SimpleDateFormat("yyyy-MM-dd").parse(to); 
		return (List<Object[]>) wagon_fmm_repo.integration(date1, date2);
			
	}
	
	// JYOTI BISHT 1-11-22
	   public int get_wagon_total_count() 
		{
		 
		  return wagon_fmm_repo.wagon_total_count();
		}
		   
	// Ritu 7-11-22
	   public List<Object[]>  getwagontypecount() 
		{
		 
		  return wagon_fmm_repo.getwagontypecount();
		}
	
}
