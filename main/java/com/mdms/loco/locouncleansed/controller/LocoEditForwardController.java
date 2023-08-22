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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mdms.loco.locouncleansed.model.LocoCondemnation;
import com.mdms.loco.locouncleansed.model.LocoDataFois;
import com.mdms.loco.locouncleansed.model.LocoDataSlam;
import com.mdms.loco.locouncleansed.model.LocoTransferResponse;
import com.mdms.loco.locouncleansed.model.LocoUncleansedData;
import com.mdms.loco.locouncleansed.model.LocoUncleansedDataElectric;
import com.mdms.loco.locouncleansed.model.Loco_condemn_interface;
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
import com.mdms.loco.locouncleansed.repository.LocoDataFoisRepository;
import com.mdms.loco.locouncleansed.repository.LocoDataSlamRepository;
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
	
	@Autowired
	LocoDataFoisRepository loco_fois;
	
	@Autowired
	LocoDataSlamRepository slamrepo;
	

	
	
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
			        		if(condemn_repo.findById(loco.getLoco_no())!=null)
			        				{
			        			        condemn_repo.insert_into_history(loco.getLoco_no());
			        				}
			        		
			        		
			        		 LocalDateTime localDateTime = LocalDateTime.now();
			        		 loco.setTxn_date(localDateTime);
			        		 loco.setApproval_doc(loco.getLoco_no()+"-"+ loco.getApproval_doc().replace(" ", "_"));
			        	//	 loco.setProposal_doc(loco.getLoco_no()+"-"+ loco.getProposal_doc().replace(" ", "_"));
			        		 
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
				       public List<LocoCondemnation> get_condemn_loco_details(@RequestParam("zone") String zone, @RequestParam("shed") String shed, @RequestParam String status )
				        {
				     
				        return condemn_repo.get_condemn_loco(zone,shed,status);

				       }
			        @PostMapping("/update_condemn_loco_details")
				       public int update_condemn_loco_details(@RequestParam("loco") String loco, @RequestParam(value="status") String status , @RequestParam("remarks") String remarks, @RequestParam("user_id") String user_id)
				        {
				       
				        try
				        {
				        	 condemn_repo.insert_into_history(Integer.parseInt(loco));
				        	
				        	 LocalDateTime localDateTime = LocalDateTime.now();
			          //       if(status==null)
			          //       condemn_repo.update_condemn_loco_status1(Integer.parseInt(loco),remarks,user_id,localDateTime);  
			           //      else
				        	 condemn_repo.update_condemn_loco_status(Integer.parseInt(loco),status,remarks,user_id,localDateTime);
				        	
				             return 1;
				       
				        }catch(Exception e)
				        {
				        return 0;
				        
				        }

				       } 
			        
			        @PostMapping("/check_in_uncleansed")
			        Optional<LocoUncleansedData> check_loco_in_uncleansed(@RequestParam("loco_no")String loco_no,@RequestParam(value="shed", required = false) String shed)
			        {
			        	Optional<LocoUncleansedData> loco=null;
			        	//System.out.print("return value is "+loco_no,shed);
			        	if(shed!=null)
			        	loco= uncleansed_repo.find_loco(Integer.parseInt(loco_no),shed);
			        	else
			        	loco= uncleansed_repo.find_loco_by_no(Integer.parseInt(loco_no));
			        	
			        	return loco;
			        	
			        }
			        
			    	
			        
			        @PostMapping("/check_in_fois")
			        Optional<LocoDataFois> check_loco_in_fois(@RequestParam("loco_no")String loco_no,@RequestParam(value="shed", required = false) String shed)
			        {
			        	Optional<LocoDataFois> loco=null;
			        	//System.out.print("return value is "+loco_no,shed);
			        	if(shed!=null)
			        	loco= loco_fois.get_Locodata_from_fois(Integer.parseInt(loco_no),shed);
			        	else
			        	loco= loco_fois.get_Locodata_from_fois_loco_no(Integer.parseInt(loco_no));
			        	
			       	return loco;
			        	
			        }
			        
			        
			        
			        @PostMapping("/check_in_fois_original")
			        Optional<LocoDataFois> check_loco_in_fois_original(@RequestParam("loco_no")String loco_no)
			        {
			        	Optional<LocoDataFois> loco=null;
			        
			        	loco= loco_fois.get_Locodata_from_fois_original_loco_no(Integer.parseInt(loco_no));
			        	
			       	return loco;
			        	
			        }
			        
			        
			        @PostMapping("/check_in_slam")
			        Optional<LocoDataSlam> check_loco_in_slam(@RequestParam("loco_no")String loco_no)
			        {
			        	Optional<LocoDataSlam> loco=null;
			        
			        	loco= slamrepo.findById(Integer.parseInt(loco_no));
			        	
			       	return loco;
			        	
			        }
			        
			        
			        
			        //JYOTI BISHT 17-7-23
			        @GetMapping("/display_condemn_loco")
			        List<Loco_condemn_interface> display_condemn_loco(@RequestParam("shed") String shed)
			        {
			        return condemn_repo.view_condemn_loco(shed);
			        }
			        
			        //JYOTI BISHT 1-8-23 for loco display
			        @GetMapping("/display_condemn_loco_by_locono")
			      Loco_condemn_interface display_condemn_loco_no(@RequestParam("loco_no") String loco_no)
			        {
			        Loco_condemn_interface loco=null;
			        loco=condemn_repo.view_condemn_loco_by_loco_no(Integer.parseInt(loco_no));
			        return loco;
			        }
			    
			        //JYOTI BISHT 18-07-23
			        @GetMapping("/display_rejected_loco")
			        List<LocoCondemnation> display_rejected_condemn_loco(@RequestParam String shed )
			        {
			        return condemn_repo.rejected_condemn_loco(shed);
			        }
			        
			        //JYOTI BISHT 18-07-23
			        @GetMapping("/loco_details_in_condemn")
			        LocoCondemnation display_loco_deltails_in_condemn(@RequestParam String loco,@RequestParam String shed )
			        {
			        return condemn_repo.loco_status_in_condemnation(Integer.parseInt(loco),shed);
			        }
			        
			        //JYOTI BISHT 2-08-23 saving loco correction details
			        /*
			        @PostMapping("/save_loco_correction")
			        LocoCorrectionByUser save_loco_correction_details(@RequestBody LocoCorrectionByUser loco)
			        {
			        	try
			        	{
			        	loco.setTxn_date(LocalDateTime.now());
			        	return loco_correction.save(loco);
			        	}
			        	catch(Exception e)
			        	{
			        		return null;
			        	}
			        }
			        */
			        
			    
			    	//Ritu 25-07-23
			        @GetMapping("/getflagtype")
			        List<String> getflagtype()
			        {
			        	return obj_uncleasedservice.getflagtype();
			        }
			        
			      //Ritu 01-08-23
			        @GetMapping("/getslamlocomismatched")
			        List<Integer> getslamdata()
			        {
			        	return obj_uncleasedservice.getslamdata();
			        }
			    	
}
