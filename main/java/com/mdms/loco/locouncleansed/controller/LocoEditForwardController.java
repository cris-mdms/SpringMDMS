package com.mdms.loco.locouncleansed.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

//All Service Method of Loco : Developer: Ritu on 24.10.2020//

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mdms.loco.locouncleansed.model.LocoCondemnation;
import com.mdms.loco.locouncleansed.model.LocoDataFois;
import com.mdms.loco.locouncleansed.model.LocoTransferResponse;
import com.mdms.loco.locouncleansed.model.LocoUncleansedData;
import com.mdms.loco.locouncleansed.model.LocoUncleansedDataElectric;
import com.mdms.loco.locouncleansed.model.MLocoBoggie;
import com.mdms.loco.locouncleansed.model.MLocoBrakeSubtype;
import com.mdms.loco.locouncleansed.model.MLocoBrakeType;
import com.mdms.loco.locouncleansed.model.MLocoShed;
import com.mdms.loco.locouncleansed.model.MLocoShedNew;
import com.mdms.loco.locouncleansed.model.MLocoStoreAuxilary;
import com.mdms.loco.locouncleansed.model.MLocoTractionMotor;
import com.mdms.loco.locouncleansed.model.MLocoType;
import com.mdms.loco.locouncleansed.model.MlocoControlType;
import com.mdms.loco.locouncleansed.model.MlocoDomainType;
import com.mdms.loco.locouncleansed.model.MlocoManufactureType;
import com.mdms.loco.locouncleansed.repository.LocoCondemnRepo;
import com.mdms.loco.locouncleansed.repository.LocoUncleansedDataElectricRepository;
import com.mdms.loco.locouncleansed.repository.LocoUncleansedDataRepository;
import com.mdms.loco.locouncleansed.service.LocoEditForwardService;
import com.mdms.mdms_masters.model.MDivision;
import java.text.ParseException;

@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")
@RestController
public class LocoEditForwardController {
	Logger logger=LoggerFactory.getLogger(LocoEditForwardController.class);
	
	@Autowired
	 private LocoEditForwardService obj_uncleasedservice;
	

	@Autowired
	LocoCondemnRepo condemn_repo;
	
	@Autowired
	LocoUncleansedDataRepository uncleansed_repo;
	
	
	//getloconominationtype
	//domain
	@RequestMapping(method=RequestMethod.POST, value ="/loconominationtype")
	public List<MlocoDomainType> getloconomination() {
		List<MlocoDomainType> list= obj_uncleasedservice.getloconomination();
		return list;
		
	}
	//getlococontroltype
	@RequestMapping(method=RequestMethod.POST, value ="/lococontroltype")
	public List<MlocoControlType> getlococtrltype() {
		return obj_uncleasedservice.getlococtrltype();
		
	}

	
	  //get all locomake
	  @RequestMapping(method=RequestMethod.POST, value ="/locomake") public
	  List<MlocoManufactureType> getlocomake() { return
	  obj_uncleasedservice.getlocomake(); }
	 
	//get uncleansed locono  according to shedbased 
	  @RequestMapping(method=RequestMethod.POST, value="/getuncleansedlocono")
			public List<Integer> getloco(@RequestBody LocoDataFois locos){		 
			 System.out.println(locos.getLoco_Owningshed());				
				  obj_uncleasedservice.getAllLocos(locos);
					System.out.println(obj_uncleasedservice.getAllLocos(locos));					
				  return obj_uncleasedservice.getAllLocos(locos);		 	 	
			}
		 
		 
		 //get uncleanesd loco type list	 
		 @RequestMapping(method=RequestMethod.POST, value="/getuncleansedlocotype")
		 public List<MLocoType> getlocotypelist(){
						 return obj_uncleasedservice.getlocotypelist();
			 
		 }
		 
		
			
			@RequestMapping(method=RequestMethod.POST, value="/getelectricshedid")	
			public List<MLocoShed> getbaseshed(){
			return obj_uncleasedservice.getallelctricshedid();
			}
			
			
			@RequestMapping(method=RequestMethod.POST, value="/getallshedid")	
			public List<MLocoShed> getallshed(){
			return obj_uncleasedservice.getallshedid();
			}
			
			@RequestMapping(method=RequestMethod.POST, value="/getallzoneid")	
			public List<String> getAllZoneID(){
			return obj_uncleasedservice.getAllZoneID();
			}
			
			
			@RequestMapping(method=RequestMethod.POST, value="/getallshedbyzoneid")	
			public List<MLocoShed> getAllShedbyZoneID(@RequestBody MLocoShed zoneid){
				System.out.println( "controller" + zoneid.getZoneCode());
				List<MLocoShed>  temp = obj_uncleasedservice.getAllShedbyZoneID(zoneid);
						for(int i = 0; i < temp.size(); i++) {
				            System.out.println(temp.get(i).getZoneCode());
				        }				
			return obj_uncleasedservice.getAllShedbyZoneID(zoneid);
			}
			
			@RequestMapping(method=RequestMethod.POST, value="/getallshedbyuserzone")	
			public List<String> getAllShedbyuserZone(@RequestParam("userid") String userid, @RequestParam("zoneid")String zoneid, @RequestParam("zone")String zone){
		System.out.println("userid"+ userid);
		System.out.println("userid"+ zoneid);
		System.out.println("userid"+ zone);
				List<String>  temp = obj_uncleasedservice.getAllShedbyuserZoneID(userid,zoneid,zone);
						for(int i = 0; i < temp.size(); i++) {
//				            System.out.println(temp.get(i).getZoneCode());
				        }				
			return temp;
			}
			
			
			@RequestMapping(method=RequestMethod.POST, value="/getdieselshedid")	
			public List<MLocoShed> getdbaseshed(){
			return obj_uncleasedservice.getalldieselshedid();
			}
			
			//get uncleansed loco data from  loco master 
			 @RequestMapping(method=RequestMethod.POST, value="/getuncleansedlocodata")
				public List<LocoDataFois> getdata(@RequestBody LocoDataFois locos){		 
				 System.out.println(locos.getLoco_Owningshed());
				 System.out.println(locos.getLoco_Tractioncode());		 
				  obj_uncleasedservice.getdata(locos);
				 	 		return obj_uncleasedservice.getdata(locos); 	 		
					
				}
			 
			 
			//get  Traction Code from  loco master 
			 @RequestMapping(method=RequestMethod.POST, value="/getuncleansedlocotractioncode")
				public String gettractioncode(@RequestBody LocoDataFois locos){		 
				 System.out.println(locos.getLoco_Owningshed());
				 System.out.println(locos.getLoco_Tractioncode());		 
				  obj_uncleasedservice.gettractioncode(locos);
				 	 		return obj_uncleasedservice.gettractioncode(locos); 	 		
					
				}
			 
			//get uncleansed loco data from loco type master
			 @RequestMapping(method=RequestMethod.POST, value="/getuncleansedlocotypedata")
				public List<MLocoType> getlocotypedata(@RequestBody MLocoType unlocotype){		 
				 System.out.println( "controller" + unlocotype.getLoco_Type());
				 	  obj_uncleasedservice.getAllLocotypedata(unlocotype);
						System.out.println(obj_uncleasedservice.getAllLocotypedata(unlocotype));					
					  return obj_uncleasedservice.getAllLocotypedata(unlocotype);		 	 	
				}
			 
			 	
					@RequestMapping(method=RequestMethod.POST, value = "/breaktype")
					public List<MLocoBrakeType> getbreak() {
						return obj_uncleasedservice.getbreaktyp();
					}
					
					//get auxilary output 
					@RequestMapping(method=RequestMethod.POST,value="/getauxilaryoutput")
					public List<MLocoStoreAuxilary> getauxilaryoutput(){		
						return obj_uncleasedservice.getauxilaryoutput();
					}
					
					@RequestMapping(method=RequestMethod.POST, value="/get_tractionmotorcode")
					public List<MLocoTractionMotor> getAllMotor(){
						return obj_uncleasedservice.getAllMotor();
					}
					
					@RequestMapping(method=RequestMethod.GET, value="/getzoneService")
					public String getElectricZones(@RequestParam("shed") String shed) {
						return obj_uncleasedservice.getZone(shed);
				}
					
					@RequestMapping(method=RequestMethod.POST, value = "/boogie")
					public List<MLocoBoggie> getboogie() {
						return obj_uncleasedservice.getboogie();
					}

				//  status updated = cleansed "C"
			        @RequestMapping(method=RequestMethod.POST, value="/markedStatusCinFOIS")
					public boolean updatestatus(@RequestBody LocoDataFois uncleasedo) {
						boolean flag=obj_uncleasedservice.updatestatus(uncleasedo);
							return flag;
					}
					
			        @RequestMapping(method=RequestMethod.POST, value = "/eCleansedUnapprovedLoco")
			    	public List<LocoUncleansedDataElectric> geteUnapprovedLoco(@RequestBody LocoUncleansedDataElectric obj_eunapproved){
			    		System.out.println("shedid"+ obj_eunapproved.getElec_locoOwningShed());
			    		return obj_uncleasedservice.getUnapprovedLocos(obj_eunapproved);
						
			    	}
			    	
			    	//status update U to A  unapproved table
			    	@RequestMapping(method=RequestMethod.POST, value="/updatestatusApproved")
			    	public boolean updatestatus(@RequestBody LocoUncleansedDataElectric unapproved) {
			    		System.out.println("status"+unapproved.getElec_Status());
			    		System.out.println("locono"+unapproved.getElec_locoNo());
			    		System.out.println("usid"+unapproved.getUserid());			    					    		
			    				boolean flag=obj_uncleasedservice.updatestatus(unapproved);
			    					return flag;
			    			}
			    	
			    	@RequestMapping(method=RequestMethod.POST, value = "/gethyperPendingLocoService")
			    	public List<LocoUncleansedDataElectric> getLocoPendingHypershed(@RequestBody LocoUncleansedDataElectric objdraft ){
			    		System.out.println("shedid"+ objdraft.getElec_locoOwningShed());
			        return obj_uncleasedservice.getLocoPendingHypershed(objdraft);	
			    	}
			    	
			    	@RequestMapping(method=RequestMethod.POST, value = "/gethyperUncleansedLocoService")
			    	public List<LocoDataFois> getUncleansedLocoHyperShed(@RequestBody LocoDataFois objuncleansed ){
			    		System.out.println("shedid"+ objuncleansed.getLoco_Owningshed());
			        return obj_uncleasedservice.getUncleansedLocoHyperShed(objuncleansed);	
			    	}
			    	
			    	
//			    	@RequestMapping(method=RequestMethod.POST, value = "/getlocodetailfortransfer")
//			    	public Map<String, Object> getLocoDetails(@RequestBody List<LocoUncleansedDataElectric> listt){
//			    		System.out.println("$$inside controller"+listt.size());
//			    		return obj_uncleasedservice.getLocoUnclenshedDetails(listt);
//			    	}
			    	
			    	@RequestMapping(method=RequestMethod.POST, value = "/getlocodetailfortransfer")
			    	public List<LocoTransferResponse> getLocoDetails1(@RequestBody LocoUncleansedDataElectric locoUncleansedData){
			    		System.out.println("inside controller"+locoUncleansedData.getElec_locoNo());
			    		return obj_uncleasedservice.getLocoUnclenshedDetails1(locoUncleansedData.getElec_locoNo());
			    	}
			    	
			    	// update status for loco transfer
			    	@RequestMapping(method=RequestMethod.POST, value="/updatelocotransferuncleanseddetail")
			    	public int updateLocoDetailss(@RequestBody LocoUncleansedDataElectric locoUncleansedDataElectric) {
			    		return obj_uncleasedservice.updataLocoDetails(locoUncleansedDataElectric);
			    	}
			    	
			    	@RequestMapping(method=RequestMethod.POST, value="/updatelocotrffoisdetail")
			    	public int updateLocoFoisDetails(@RequestBody LocoDataFois locoDataFois) {
			    		return obj_uncleasedservice.updateLocoDetail(locoDataFois);
			    	}
			    	

			      	
			    	// JYOTI BISHT 17-10-22
			    	
			    	@PostMapping("/get_loco_pending_count")
					public int getLocoPending(@RequestParam("from")String from, @RequestParam("to") String to) throws ParseException{
				    return obj_uncleasedservice.getLocoPending(from, to);	
					}
					
			    	// JYOTI BISHT 31-10-22
			    	
			    	@PostMapping("/loco_integration")
			    	public List<Object[]> integration_stats(@RequestParam("from") String from, @RequestParam("to") String to) throws ParseException
			    	{
			    		
			    		return obj_uncleasedservice.integration_stats(from, to);
			    	}
			    	
			    	// Jyoti bisht 31-10-22
			    	
			    	@PostMapping("/get_total_loco_fois")
			    	public int get_total_loco_fois()
			    	{
			    		return obj_uncleasedservice.get_total_loco_fois();
			    	}
                  // Jyoti bisht 2-11-22
			    	
			    	@PostMapping("/get_shed_by_zone")
			    	public List<String> get_shed_by_zone(@RequestParam("zone")String zone)
			    	{
			    		return obj_uncleasedservice.get_shed_by_zone(zone);
			    	}
                   // Jyoti bisht 2-11-22
			    	
			    	@PostMapping("/get_div_by_zone")
			    	public List<String> get_shed_by_zone_div(@RequestParam("zone")String zone)
			    	{
			    		return obj_uncleasedservice.get_div_by_zone(zone);
			    	}
			    	
			    	@PostMapping("/get_loco_details")
				    public List<LocoUncleansedDataElectric> geteLocoDetails(@RequestParam("zone") String zone, @RequestParam("shed") String shed, @RequestParam("status") String status)
			    	{
				   
				    	return obj_uncleasedservice.get_loco_details(zone, shed, status);
							
				    }
			    	
//			    	// JYOTI BISHT 7-1-23   for shed Code Creation from m_loco_shed_new table 
//			    	@PostMapping("/get_loco_shed_details")
//				    public List<MLocoShedNew> geteLocoShedDetails(@RequestBody MLocoShedNew mlocoshed)
//			    	{
//				   
//				    	return obj_uncleasedservice.get_loco_shed_details(mlocoshed);
//							
//				    }
//			    	
//			    	@PostMapping("/getallzoneid_new")	
//					public List<Object[]> getAllZoneID_new(){
//					return obj_uncleasedservice.getAllZone_names();
//					}
//					
//			    	
//			    	@PostMapping("/get_div_by_zone_new")
//			    	public List<Object[]> get_shed_by_zone_div_new(@RequestParam("zone")String zone)
//			    	{
//			    		return obj_uncleasedservice.get_div_by_zone_name(zone);
//			    	}
					
			    	
//			    	@RequestMapping(method=RequestMethod.POST, value="/getbrakesubtype")	
//					public List<MLocoBrakeSubtype> getallsubtype(){
//					return obj_uncleasedservice.getallsubtype();
//					}
//					
			    	
			    	//ritu- 20june 2023
			    	 
			    	
//			    	@PostMapping("/get_loco_uncleanseddetails")
//				    public List<LocoDataFois> get_loco_uncleanseddetails(@RequestParam("zone") String zone, @RequestParam("shed") String shed )
//			    	{
//				   
//				    	return obj_uncleasedservice.get_loco_uncleanseddetails(zone, shed);
//							
//				    }
//			    	
//                     //ritu to get total loco - 20june 2023
//			    	 
//			    	@PostMapping("/get_loco_totaldetails")
//				    public List<LocoDataFois> get_loco_totaldetails(@RequestParam("zone") String zone, @RequestParam("shed") String shed )
//			    	{
//				   
//				    	return obj_uncleasedservice.get_loco_totaldetails(zone, shed);
//							
//				    }
//
			      	// JYOTI BISHT 7-1-23   for shed Code Creation from m_loco_shed_new table 
			    	@PostMapping("/get_loco_shed_details")
				    public List<MLocoShedNew> geteLocoShedDetails(@RequestBody MLocoShedNew mlocoshed)
			    	{
				   
				    	return obj_uncleasedservice.get_loco_shed_details(mlocoshed);
							
				    }
			    	
			    	@PostMapping("/getallzoneid_new")	
					public List<Object[]> getAllZoneID_new(){
					return obj_uncleasedservice.getAllZone_names();
					}
					
			    	
			    	@PostMapping("/get_div_by_zone_new")
			    	public List<Object[]> get_shed_by_zone_div_new(@RequestParam("zone")String zone)
			    	{
			    		return obj_uncleasedservice.get_div_by_zone_name(zone);
			    	}
					

			    	@RequestMapping(method=RequestMethod.POST, value="/getbrakesubtype")	
					public List<MLocoBrakeSubtype> getallsubtype(){
					return obj_uncleasedservice.getallsubtype();
					}

			    	
			    	//ritu- 20june 2023
			    	   
			    	   
			        @PostMapping("/get_loco_uncleanseddetails")
			       public List<LocoDataFois> get_loco_uncleanseddetails(@RequestParam("zone") String zone, @RequestParam("shed") String shed )
			        {
			     
			        return obj_uncleasedservice.get_loco_uncleanseddetails(zone, shed);

			       }
			       
			       //ritu to get total loco - 20june 2023
			       
			        @PostMapping("/get_loco_totaldetails")
			       public List<LocoDataFois> get_loco_totaldetails(@RequestParam("zone") String zone, @RequestParam("shed") String shed )
			        {
			     
			        return obj_uncleasedservice.get_loco_totaldetails(zone, shed);

			       }
			        
			    
			        
			        @PostMapping("/save_condemn_details")
			        LocoCondemnation insert_condemn_details(@RequestBody LocoCondemnation loco)
			        {
			        	try
			        	{
			        		 LocalDateTime localDateTime = LocalDateTime.now();
			        		 loco.setTxn_date(localDateTime);
			        		 return condemn_repo.save(loco);
			        	}
			        	catch(Exception e)
			        	{
			        		return null;
			        	}
			        	
			        }
			        
			        @PostMapping("/check_in_condemn")
			        public boolean check_loco_condemn(@RequestParam("loco_no")String loco_no)
			        {
			        
			        	if(condemn_repo.condemn_loco_check(Integer.parseInt(loco_no)) == null)
			        	{
			        		return false;
			        	}
			
			        	else
			        		return true;
			        	
			        }
			        
			        @PostMapping("/get_condemn_loco_details")
				       public List<LocoCondemnation> get_condemn_loco_details(@RequestParam("zone") String zone, @RequestParam("shed") String shed )
				        {
				     
				        return condemn_repo.get_condemn_loco(zone,shed);

				       }
			        @PostMapping("/update_condemn_loco_details")
				       public int update_condemn_loco_details(@RequestParam("loco") String loco, @RequestParam("status") String status , @RequestParam("remarks") String remarks)
				        {
				     
				        try
				        {
				        	condemn_repo.update_condemn_loco_status(Integer.parseInt(loco),status,remarks);
				        	return 1;
				       
				        }catch(Exception e)
				        {
				        return 0;
				        
				        }

				       } 
			        
			        @PostMapping("/check_in_uncleansed")
			        Optional<LocoUncleansedData> check_loco_in_uncleansed(@RequestParam("loco_no")String loco_no)
			        {
			        
			        	Optional<LocoUncleansedData> loco= uncleansed_repo.find_loco(Integer.parseInt(loco_no));
			        	//System.out.println("return value is "+loco);
			        	return loco;
			        	
			        }
			        
			    	
			    	
			    	
			    	
			    	
			    	
			    	
			    	
			    	
			    	
			    	
			    	
			    	

			    	
			    	
}
