package com.mdms.mdms_masters.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdms.mdms_masters.model.MDivision;
import com.mdms.mdms_masters.model.MShed;
import com.mdms.mdms_masters.model.MShedMgmt;
import com.mdms.mdms_masters.model.MZone;

import com.mdms.loco.locouncleansed.model.MLocoType;
import com.mdms.mdms_masters.model.MDepartment;
import com.mdms.mdms_masters.model.MDesignation;
import com.mdms.mdms_masters.model.MDesignationCode;
import com.mdms.mdms_masters.model.MDivision;
import com.mdms.mdms_masters.model.MZone;
import com.mdms.mdms_masters.repository.MDepartmentRepository;
import com.mdms.mdms_masters.repository.MDesignationCodeRepository;
import com.mdms.mdms_masters.repository.MDesignationRepository;

import com.mdms.mdms_masters.repository.MDivisionRepository;
import com.mdms.mdms_masters.repository.MShedMgmtRepository;
import com.mdms.mdms_masters.repository.MShedRepo;
import com.mdms.mdms_masters.repository.MZoneRepository;

@Service
public class MdmsMasterService {	
	@Autowired
	MDivisionRepository divsn_repo;
	@Autowired
	MZoneRepository zone_repo;	
	@Autowired
	MDesignationRepository desig_repo;
	
	@Autowired
	MDesignationCodeRepository assetcode_repo;

	@Autowired
	MDepartmentRepository deprt_repo;
	
	@Autowired
	MShedRepo shedRepoObj;
	
	@Autowired
	MShedMgmtRepository shedmgmtRepoObj;
	
	
	
	//insertNewApprovedShedCode - Gaurav
		public int insertNewApprovedShedCode(MShedMgmt shedd) {			
			int noOfRowsIns = 0;
			System.out.println(shedd.getRemarks());
	        noOfRowsIns = shedRepoObj.insertApprovedShedCode(shedd.getShedCode(),shedd.getShedName(),shedd.getZoneCode(),shedd.getDivisionCode(),shedd.getTractionCode(),shedd.getServingStnCode(),shedd.getShedType(),shedd.getEntry_by(),shedd.getUser_shed(),shedd.getStatus(),shedd.getSrNo(),shedd.getRemarks(),shedd.getElec_loco_in_dslshed());
			
	        //2022-06-23 16:05:15.630381
			//String shedCode, String shedName, String zoneCode, String divisionCode, String tractionCode, String servingStnCode, String servingStnName, String shedType, String userId, String userShed, String txn_timestamp
			
			return noOfRowsIns;			
			
		}
	
private String div_code;
	private String zone_code;
	public List<MDivision> getAllDivision() {
		// TODO Auto-generated method stub
		return divsn_repo.getAllDivision();
	}

	
	public List<String> getAllZone() {
		// TODO Auto-generated method stub
		return zone_repo.getAllZone();
	}

	public List<MZone> getZone() {
		// TODO Auto-generated method stub
		return zone_repo.getZone();
	}

	public List<MDivision> findByZone(MDivision division) {
		zone_code=division.getZone_code();
		
		List<MDivision> tmp = new ArrayList<>();
		divsn_repo.findByZoneCode(zone_code).forEach(tmp::add);
	    return tmp;
	}
	
	public String findByDivision(String division) throws Exception{		
		String zonecode;		
		 zonecode=divsn_repo.findByDivCode(division);
    return zonecode;
		
	}

	
	public List<String> getZonewiseDivisionCode(String zone) throws Exception{
		
		return divsn_repo.getZonewiseDivisionCode(zone);
	}
	
//	public List<MDesignation> findDesignation(MDesignation desig) throws Exception
//	{		
//		List<MDesignation> temp=new ArrayList<>();
//		desig_repo.findDesignation(desig)
//		.forEach(temp::add);
//		return temp;  		
//	
//	
//	}
	public boolean verifyStnUserDesig(MDesignation userdesig) {
	   String udesigname=userdesig.getDesignation_name();       
	   String desig=desig_repo.findStnDesignation(udesigname);
	   if((desig!=null )&&(desig.equals(desig)) ){
	    	return true;
	       	
	    	
	    } else {
	    	return false;
	    }
	   
	}
	
	public boolean verifyCoachUserDesig(MDesignation userdesig) {
		   String udesigname=userdesig.getDesignation_name();       
		   String desig=desig_repo.findcoachDesignation(udesigname);
		   if((desig!=null )&&(desig.equals(desig)) ){
		    	return true;
		       	
		    	
		    } else {
		    	return false;
		    }
		   
		}
	public boolean verifyLocoUserDesig(MDesignation userdesig) {
		   String udesigname=userdesig.getDesignation_name();       
		   String desig=desig_repo.findLocoDesignation(udesigname);
		   if((desig!=null)&&(desig.equals(desig)) ){
		    	return true;
		       	
		    	
		    } else {
		    	return false;
		    }
		   
		}
	// get asset designation code from designation table -- Developer : Ritu Dt. 17.6.22
	public List<MDesignationCode> getLocoUserDesig(MDesignationCode userdesig) {
		   String udesigname=userdesig.getHrms_designation();       
		   List<MDesignationCode> desig=assetcode_repo.getassetsLocoDesignation(udesigname);
		   if((desig!=null)&&(desig.equals(desig)) ){
		    	return assetcode_repo.getassetsLocoDesignation(udesigname);	       	
		    	
		    } else {
		    	return assetcode_repo.getassetsLocoDesignation(udesigname);
		    }
		   
		}
	
	public List<MDepartment> getAllDepartment() {
		// TODO Auto-generated method stub
		return deprt_repo.findDept();
	}
	
	
	public boolean checkassetscodeexist(MDesignationCode assetdesig) {
		   String assetcode=assetdesig.getAsset_designation_code();       
		   String assetcode1=assetcode_repo.checkassetscodeexist(assetcode);
		   if((assetcode1!=null)&&(assetcode1.equals(assetcode1)) ){
		    	return true;
		       	
		    	
		    } else {
		    	return false;
		    }
		   
		}
	
	public List<String> getfoiszonelist()	{
		List<String> fetchedList1 = new ArrayList<>();
		 fetchedList1 = shedRepoObj.getfoiszonelist();		
		 //System.out.println("shed----divn:::::::"+shed.getDivisionCode());
		
		return fetchedList1;
		
		//.forEach(fetchedList::add)
				
	}	
	public List<String> getfoisdivlist(String zonecode)	{
		List<String> fetchedList1 = new ArrayList<>();
		 fetchedList1 = shedRepoObj.getfoisdivlist(zonecode);		
		 //System.out.println("shed----divn:::::::"+shed.getDivisionCode());		
		return fetchedList1;
		
		//.forEach(fetchedList::add)
				
	}	
	
	public List<MDivision> getzonewisedivlist(String zonecode)	{
		List<MDivision> fetchedList2 = new ArrayList<>();
		 fetchedList2 = divsn_repo.getZonewiseDivision(zonecode);
		return fetchedList2;
		
		
	}	
	public List<MShed> getShedDetailsfois(MShed shed)	{
		String zonecode=shed.getZoneCode();
		String divcode=shed.getDivisionCode();
		
		System.out.println(zonecode);System.out.println(divcode);	
		List<MShed> fetchedList = new ArrayList<>();	
				 shedRepoObj.returnShedDetailsfois(zonecode,divcode).forEach(fetchedList::add);	
//		 int len = fetchedList.size();
//	 System.out.println("len:::::::"+len);
	return fetchedList;				
	
				
	}	
	
	public List<MShed> getShedDetailsslam(MShed shed)	{
		String zonecode=shed.getZoneCode();
		String divcode=shed.getDivisionCode();
		
		System.out.println(zonecode);System.out.println(divcode);	
		List<MShed> fetchedList = new ArrayList<>();	
				 shedRepoObj.returnShedDetailsslam(zonecode,divcode).forEach(fetchedList::add);	
//		 int len = fetchedList.size();
//	 System.out.println("len:::::::"+len);
	return fetchedList;				
	
				
	}	
	public List<MShed> getShedDetailsrb(MShed shed)	{
		String zonecode=shed.getZoneCode();
//		String divcode=shed.getDivisionCode();
		
//		System.out.println(zonecode);System.out.println(divcode);	
		List<MShed> fetchedList = new ArrayList<>();	
				 shedRepoObj.returnShedDetailsrb(zonecode).forEach(fetchedList::add);	
//		 int len = fetchedList.size();
//	 System.out.println("len:::::::"+len);
	return fetchedList;				
	
				
	}	

//	public List<MShed> getExclShedList1(MShed obj){
//		String zc=obj.getZoneCode();
//				String dc=obj.getShedCode();
//		List<MShed> list=new ArrayList<>();		
//		shedRepoObj.returnExclShedDetails(zc,dc).forEach(list::add);		
//		return list;
//		
//	}
	public List<MShed> getExclShedList(String zone, String division){
		List<MShed> list=new ArrayList<>();
		
		shedRepoObj.returnExclShedDetails(zone, division).forEach(list::add);
//		int len = list.size();
//		System.out.println("size:::::::::::"+len);
		
		return list;
		
	}
	public List<MShed> returnfoidata(MShed obj){
		List<MShed> list=new ArrayList<>();		
		shedRepoObj.returnfoidata(obj.getZoneCode(), obj.getDivisionCode()).forEach(list::add);
		return list;		
	}
	
	
	public List<MShedMgmt> getNewgeneratedshedcode(MShedMgmt obj){
		String zc=obj.getZoneCode();
				String dc=obj.getDivisionCode();
				System.out.println(zc);
				System.out.println(dc);
		List<MShedMgmt> list=new ArrayList<>();		
		shedmgmtRepoObj.returnNewGeneratedShedCode(zc,dc).forEach(list::add);		
		return list;
		
	}
	
	
	public List<MShedMgmt> returnapprovedNewGeneratedShedCode(MShedMgmt obj){
		String zc=obj.getZoneCode();
				String dc=obj.getDivisionCode();
				System.out.println(zc);
				System.out.println(dc);
		List<MShedMgmt> list=new ArrayList<>();		
		shedmgmtRepoObj.returnapprovedNewGeneratedShedCode(zc,dc).forEach(list::add);		
		return list;
		
	}
	
	
	
	public void updateStatusForshed(String sStatus,String userid, String shedcode) {
		shedmgmtRepoObj.updateshedStatus(sStatus, userid , shedcode);
	}
	
	
	// JYOTI BISHT 2-1-23
	
	public List<MShedMgmt> rejectedShedCodes(MShedMgmt obj){
		String zc=obj.getZoneCode();
				String dc=obj.getDivisionCode();
		return shedmgmtRepoObj.returnRejectedShedCode(zc,dc);
	
	}
	
	// JYOTI BISHT 24-01-23
	public List<MShedMgmt> display_approved_NewShedCode(String zone, String division){
		return shedmgmtRepoObj.display_approved_shed(zone,division);		
	}
	
}


	

