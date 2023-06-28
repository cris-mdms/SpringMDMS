/*This controller provides all MDMS COMMON MASTERS .
 * Zone , Division , Designation , State , Pincode , District , Tehsil etc...
 * Created By : Anshul, 02-11-2020
 * 
 */
package com.mdms.mdms_masters.controller;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mdms.mdms_masters.model.MDivision;
import com.mdms.mdms_masters.model.MShed;
import com.mdms.mdms_masters.model.MShedMgmt;
import com.mdms.mdms_masters.model.MZone;
import com.mdms.mdms_masters.repository.MShedMgmtRepository;
import com.mdms.mdms_masters.service.MdmsMasterService;
import com.mdms.mdms_station.stationuncleansed.model.StationPKey;
import com.mdms.mdms_masters.model.MDepartment;
import com.mdms.mdms_masters.model.MDesignation;
import com.mdms.mdms_masters.model.MDesignationCode;
@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")
@RestController
public class MdmsMastersController {
	
	@Autowired	
	MdmsMasterService mdm_mstr_serv;
	
	@Autowired
	MShedMgmtRepository m_loco_shed_repo;
	

	Logger logger=LoggerFactory.getLogger(MdmsMastersController.class);
	
	@RequestMapping(method=RequestMethod.POST, value="/division")
	public List<MDivision> getAllDivision(){
		return mdm_mstr_serv.getAllDivision();
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/divisionbyzonecode")
	public List<MDivision> findByZone(@RequestBody MDivision division) {
		List<MDivision> temp=mdm_mstr_serv.findByZone(division);
		 for(int i = 0; i < temp.size(); i++) {
	            System.out.println(temp.get(i).getDivision_code());
	        }
	return mdm_mstr_serv.findByZone(division);  
	
	}    
	
	@RequestMapping(method=RequestMethod.POST, value="/dvsnmstr")
	public String findByDivison(@RequestBody String division)throws Exception {
		 logger.error("controller : MdmsMastersController || Method : findByDivison || input recieved findByDivison: "+division);		 
       return mdm_mstr_serv.findByDivision(division) ;

	} 
	
	@RequestMapping(method=RequestMethod.GET, value="/mdivisioncode")
	List<String> getZonewiseDivisionCode(@RequestParam(value="zone_code" )String zone_code)throws Exception {
		logger.error("controller : MdmsMastersController || Method : getZonewiseDivisionCode || input recieved zone: "+zone_code);		 
	       return mdm_mstr_serv.getZonewiseDivisionCode(zone_code) ;
		
	
	

	}    
	

	@RequestMapping(method=RequestMethod.POST, value="/zone")
	public	 List<String> getAllZone(){
		return mdm_mstr_serv.getAllZone();
	}
	@RequestMapping(method=RequestMethod.POST, value="/zonemaster")
	public	 List<MZone> getZone(){
		return mdm_mstr_serv.getZone();
	}

	@RequestMapping(method=RequestMethod.POST, value="/mdivision")
	public	 List<MDivision> getZonewisedivision(@RequestParam String zone_code ){
		return mdm_mstr_serv.getzonewisedivlist(zone_code);
	}
	 @RequestMapping(method=RequestMethod.POST, value="/stnuserdesignation")
		public boolean findStnDesignation(@RequestBody MDesignation desig){ 										
			  return  mdm_mstr_serv.verifyStnUserDesig(desig);		 	 	
		}
	 @RequestMapping(method=RequestMethod.POST, value="/coachuserdesignation")
		public boolean findCoachDesignation(@RequestBody MDesignation desig){ 										
			  return  mdm_mstr_serv.verifyCoachUserDesig(desig);		 	 	
		}
	 @RequestMapping(method=RequestMethod.POST, value="/locouserdesignation")
		public boolean findLocoDesignation(@RequestBody MDesignation desig){ 
		 System.out.println("DESIGNATION"+desig.getDesignation_name());
		
			    System.out.println( mdm_mstr_serv.verifyLocoUserDesig(desig)); 
			    
			    
			    return mdm_mstr_serv.verifyLocoUserDesig(desig);
		}
	 
	 @RequestMapping(method=RequestMethod.POST, value="/getlocoassetdesignation")
		public List<MDesignationCode> getLocoUserDesig(@RequestBody MDesignationCode desig){ 
		 System.out.println("DESIGNATION"+desig.getHrms_designation());

			    System.out.println( mdm_mstr_serv.getLocoUserDesig(desig));
			    
			    return mdm_mstr_serv.getLocoUserDesig(desig);
		}
	 

	 @RequestMapping(method=RequestMethod.POST, value="/getdesignation")
		public MDesignationCode getDesig(@RequestParam("designation") String desig){ 
	//	 System.out.println("DESIGNATION"+desig.getHrms_designation());
		 String new_design=null;
		 System.out.println("...................designation is "+desig);
			    if(desig.contains("&"))
			    {
			    	String old_desig[]=desig.split("&");
			    	new_design=old_desig[0]+"%" ;// +"\\&"+old_desig[1];
			    	System.out.println("new generated ..............."+new_design);
			    	 	
			    }
			    if(new_design!=null)
			    	return mdm_mstr_serv.getDesig(new_design);
			    else
			    	
			    return mdm_mstr_serv.getDesig(desig);
		}
	 

	 
	 @RequestMapping(method=RequestMethod.POST, value="/checkassetcodeexist")
		public boolean checkassetscodeexist(@RequestBody MDesignationCode assetcode){ 
		 System.out.println("AssetCode"+assetcode.getAsset_designation_code());		
			    System.out.println( "Asset Code"+ mdm_mstr_serv.checkassetscodeexist(assetcode)); 
			    return mdm_mstr_serv.checkassetscodeexist(assetcode);
		}


		@RequestMapping(method=RequestMethod.POST, value="/department")
		public List<MDepartment> getAllDepartment(){
			return mdm_mstr_serv.getAllDepartment();
		}
		
		@RequestMapping(method=RequestMethod.POST, value="/getsheddetailfois")
		public List<MShed> getShedDetailsfois(@RequestBody MShed shed)	{
//			List<MShed> fetchedList = new ArrayList<>();
			return mdm_mstr_serv.getShedDetailsfois(shed);				
					
		}	
		
		@RequestMapping(method=RequestMethod.POST, value="/getsheddetailslam")
		public List<MShed> getShedDetails1am(@RequestBody MShed shed)	{
//			List<MShed> fetchedList = new ArrayList<>();
			return mdm_mstr_serv.getShedDetailsslam(shed);				
					
		}	
		
		@RequestMapping(method=RequestMethod.POST, value="/getsheddetailrb")
		public List<MShed> getShedDetailsrb1(@RequestBody MShed shed)	{
//			List<MShed> fetchedList = new ArrayList<>();
			return mdm_mstr_serv.getShedDetailsrb(shed);				
					
		}	
		
		@RequestMapping(method=RequestMethod.POST, value="/getfoiszonelist")
		public List<String> getfoiszonelist()	{
//			List<MShed> fetchedList = new ArrayList<>();
			return mdm_mstr_serv.getfoiszonelist();				
					
		}
		
		@RequestMapping(method=RequestMethod.POST, value="/getfoisdivlist")
		public List<String> getdivlist(@RequestParam String zonecode)	{
//			List<MShed> fetchedList = new ArrayList<>();
			System.out.println(zonecode);
			return mdm_mstr_serv.getfoisdivlist(zonecode);				
					
		}
		
		
		@RequestMapping(method=RequestMethod.POST, value="/saveAppprovedShedCode")
		public int insertApprovedShedCodeDetails(@RequestBody MShedMgmt shed){
			logger.info("----------/insertApprovedShedCodeDetails",shed);
			System.out.println(shed);
			try {
			int rowsInserted = 0;
			rowsInserted = mdm_mstr_serv.insertNewApprovedShedCode(shed);
			return rowsInserted;	
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
				return 0;	
			}

		}
		
		@RequestMapping(method=RequestMethod.POST, value="/getnewshedcode")
		public List<MShedMgmt> getNewgeneratedshedcodedetail(@RequestBody MShedMgmt obj){			
			//return mdm_mstr_serv.getShedDetails();
			return mdm_mstr_serv.getNewgeneratedshedcode(obj);
		}
		
		@RequestMapping(method=RequestMethod.POST, value="/getapprovednewshedcode")
		public List<MShedMgmt> getNewgeneratedapprovedshedcodedetail(@RequestBody MShedMgmt obj){			
			//return mdm_mstr_serv.getShedDetails();
			return mdm_mstr_serv.returnapprovedNewGeneratedShedCode(obj);
		}
		
		@RequestMapping(method=RequestMethod.POST, value="/getExclShedDetails")
		public List<MShed> getExclusiveShedDetails(@RequestParam(required = false,value ="zone") String zone, @RequestParam(required = false,value ="division") String division){
			//return mdm_mstr_serv.getShedDetails();
			return mdm_mstr_serv.getExclShedList(zone, division);
		}
		
		
		@RequestMapping(method=RequestMethod.POST, value="/getfoisdatashedcode")
		public List<MShed> returnfoidata(@RequestBody MShed obj){			
			//return mdm_mstr_serv.getShedDetails();
			return mdm_mstr_serv.returnfoidata(obj);
		}
		@RequestMapping(method=RequestMethod.POST, value="/approveshedcode")
		public boolean updateshedStatus(@RequestParam String cStatus, @RequestParam String userid , @RequestParam String shedcode) {
			mdm_mstr_serv.updateStatusForshed(cStatus,userid, shedcode);
			return true;		
		}
		
		// JYOTI BISHT
		@PostMapping("/getRejectedShedCode")
		public List<MShedMgmt> getRejectedshedcodedetail(@RequestBody MShedMgmt obj){			
			return mdm_mstr_serv.rejectedShedCodes(obj);
		}
		
		//JYOTI BISHT
		@PostMapping("/delete_loco_shed")
		public boolean delete_loco_shed(@RequestParam("sno") int sno)
		{
			boolean test=false;
			try
			{
				m_loco_shed_repo.deleteById(sno);
				return true;
			}catch(Exception e)
			{
				return  false;
			}
			
		}
		//JYOTI BISHT
		@PostMapping("/find_loco_shed")
		public boolean find_loco_shed(@RequestParam("sno") int sno)
		{
			return m_loco_shed_repo.existsById(sno);
		
		}
		
		//JYOTI BISHT  24-01-23
		@PostMapping("/display_new_shed_codes")
		public List<MShedMgmt> display_approved_shed(@RequestParam(name="zone", required = false) String zone, @RequestParam(name="division", required = false) String division)
		{
		//	return m_loco_shed_repo.display_approved_NewShedCode(zone, division);
			
			return mdm_mstr_serv.display_approved_NewShedCode(zone, division);
				
		}
				
		
		
		
}
