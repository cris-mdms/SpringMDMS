package com.mdms.loco.locouncleansed.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.mdms.loco.locouncleansed.model.LocoUncleansedDataElectric;

import com.mdms.loco.locouncleansed.model.LocoDataFois;
import com.mdms.loco.locouncleansed.model.LocoTransferResponse;
import com.mdms.loco.locouncleansed.model.LocoUncleansedData;
import com.mdms.loco.locouncleansed.model.MLocoBoggie;
import com.mdms.loco.locouncleansed.model.MLocoBrakeSubtype;
import com.mdms.loco.locouncleansed.model.MLocoBrakeType;
import com.mdms.loco.locouncleansed.model.MLocoShed;
import com.mdms.loco.locouncleansed.model.MLocoShedNew;
import com.mdms.loco.locouncleansed.model.MLocoStoreAuxilary;
import com.mdms.loco.locouncleansed.model.MLocoTractionMotor;
import com.mdms.loco.locouncleansed.repository.LocoDataFoisRepository;
import com.mdms.loco.locouncleansed.repository.LocoUncleansedDataElectricRepository;
import com.mdms.loco.locouncleansed.repository.LocoUncleansedDataRepository;
import com.mdms.loco.locouncleansed.repository.MLocoBoggieRepository;
import com.mdms.loco.locouncleansed.repository.MLocoBrakeSubTypeRepo;
import com.mdms.loco.locouncleansed.repository.MLocoBrakeTypeRepository;
import com.mdms.loco.locouncleansed.repository.MLocoShedNewRepository;
import com.mdms.loco.locouncleansed.repository.MLocoShedRepository;
import com.mdms.loco.locouncleansed.repository.MLocoStoreAuxilaryRepository;
import com.mdms.loco.locouncleansed.repository.MLocoTractionMotorRepository;
import com.mdms.loco.locouncleansed.repository.MLocoTypeRepository;
import com.mdms.loco.locouncleansed.repository.MlocoControlTypeRepo;
import com.mdms.loco.locouncleansed.repository.MlocoDomainTypeRepo;
import com.mdms.loco.locouncleansed.repository.MlocoManufactureTypeRepo;
import com.mdms.mdms_masters.model.MDivision;
import com.mdms.loco.locouncleansed.model.MLocoType;
import com.mdms.loco.locouncleansed.model.MlocoControlType;
import com.mdms.loco.locouncleansed.model.MlocoDomainType;
import com.mdms.loco.locouncleansed.model.MlocoManufactureType;
import java.text.ParseException;

@Service
public class LocoEditForwardService {
	
	
	@Autowired
	private LocoDataFoisRepository obj_uncleansedrepo;
	@Autowired
private MLocoTypeRepository obj_uncleansedtyperepo;

	@Autowired
	LocoUncleansedDataElectricRepository obj_elec;

//	   
	@Autowired
	private MLocoBrakeSubTypeRepo obj_subtype;
	@Autowired
	private LocoUncleansedDataRepository obj_uncleansedcommonrepo;
	
	@Autowired
	private MLocoShedRepository obj_shedrepo;
	@Autowired
	private MLocoBrakeTypeRepository obj_breaktyperepo;
	
	@Autowired
	private MLocoStoreAuxilaryRepository obj_repoaxo;
	
	@Autowired
	private  MLocoTractionMotorRepository obj_repo;
	
	@Autowired
	private  MLocoBoggieRepository	obj_boogierepo;
	
	@Autowired
	private MlocoControlTypeRepo mlocoControlTypeRepo;
	
	@Autowired
	private MlocoDomainTypeRepo mlocoDomainTypeRepo;
	
	@Autowired
	private MLocoTypeRepository mLocoTypeRepository;
	
	@Autowired
	private MlocoManufactureTypeRepo mlocoManufactureTypeRepo;
	
	@Autowired
	private MLocoShedNewRepository mlocoshednew;
	
	
	
	/*
	 * @Autowired private MlocoManufactureType mlocoManufactureTypeRepo;
	 */
	
	//get control type
	 Logger logger=LoggerFactory.getLogger(LocoDataFois.class);
		@Autowired
		private JdbcTemplate jdbcTemplate;	
		
		public List<MlocoControlType> getlococtrltype(){
			// TODO Auto-generated method stub
			List<MlocoControlType> lococtrl= new ArrayList<>();
			mlocoControlTypeRepo.findctrltype()
			.forEach(lococtrl::add);
			return lococtrl;
		}
		
		// get loco-make	
	public List<MlocoManufactureType> getlocomake() {
		// TODO Auto-generated method stub
		List<MlocoManufactureType> locomake= new ArrayList<>();
		 mlocoManufactureTypeRepo.getlocomake()
		.forEach(locomake::add);
		return locomake;
	}

		//get loconominationtype
		public List<MlocoDomainType> getloconomination() {
			// TODO Auto-generated method stub
			List<MlocoDomainType> loconomi= new ArrayList<>();
			mlocoDomainTypeRepo.findnomitype()
			.forEach(loconomi::add);	
			return loconomi;
		}


		
		
		
		//get all loco number according to shedid and locotype
		public List<Integer> getAllLocos(LocoDataFois unlocos) {
			// TODO Auto-generated method stub
			System.out.println("getuncleasedlocos");
			List<Integer> locos= new ArrayList<>();
			String shedid = unlocos.getLoco_Owningshed();
//			String traccode= unlocos.getLoco_Tractioncode();
			System.out.println("service"+shedid);
			obj_uncleansedrepo.getLocono(shedid).forEach(locos::add);
			if(locos.isEmpty()) {
			return  locos ;
		}
		else
			System.out.println("data" +locos);
			return  locos;
		
	
	}


//		status changed - Checked(C)
			public boolean updatestatus(LocoDataFois uncleansed ) {
				try{
				String locostatus= uncleansed.getuStatus();
				int lno=uncleansed.getLoco_No();
				System.out.println(lno);
				obj_uncleansedrepo.updatestatus(lno);				
					return  true ;
				
				}
				catch(Exception e){
					
					System.out.println(e);
					return false;
				}
			}	

		public List<MLocoType> getlocotypelist()
		{
			List<MLocoType> ltype=new ArrayList<>();
			mLocoTypeRepository.getallLocotype().forEach(ltype::add);
			 return ltype;
	}
		
		public List<MLocoShed> getallelctricshedid()
		{
			 List<MLocoShed> shedid = new ArrayList<>();		 
			 obj_shedrepo.findAll().forEach(shedid::add);
			 return shedid;
		}
		
		
		public List<MLocoShed> getallshedid()
		{
			 List<MLocoShed> shedid = new ArrayList<>();		 
			 obj_shedrepo.findAllShed().forEach(shedid::add);
			 return shedid;
		}
		
		public List<String> getAllZoneID()
		{
			 List<String> zoneid = new ArrayList<>();		 
			 obj_shedrepo.findAllZone().forEach(zoneid::add);
			 return zoneid;
		}
		
		public List<MLocoShed> getAllShedbyZoneID(MLocoShed zoneid)
		{
			String zonecode=zoneid.getZoneCode();
			 List<MLocoShed> shedid = new ArrayList<>();		 
			 obj_shedrepo.findshedbyZone(zonecode).forEach(shedid::add);
			 return shedid;
		}
		public List<String> getAllShedbyuserZoneID(String userid,String zoneid,String zone)
		{
			
//			String zonecode=zoneid.getZoneCode();
			 List<String> shedid = new ArrayList<>();		 
			 obj_shedrepo.findshedbyuserZone(userid,zoneid,zone).forEach(shedid::add);
			 return shedid;
		}
		
		
		public List<MLocoShed> getalldieselshedid()
		{
			 List<MLocoShed> shedid = new ArrayList<>();		 
			 obj_shedrepo.findDShed().forEach(shedid::add);
			 return shedid;
		}
		
		
		public String getZone(String shedmaster) {
			
			return obj_shedrepo.findzone(shedmaster);
			}

		//get uncleansed data - status ==null
		public List<LocoDataFois> getdata(LocoDataFois unlocos) {
			// TODO Auto-generated method stub
			System.out.println("getuncleasedlocos");
			int locono= unlocos.getLoco_No();
			List<LocoDataFois> locos= new ArrayList<>();
			obj_uncleansedrepo.getallLocodata(locono)
			.forEach(locos::add);		
			if(locos.isEmpty()) {
				return  locos ;
			}
			else
				System.out.println("data" +locos);
				return  locos;
			
		
		}
		
		//get uncleansed tracton code  data - status ==null
				public String gettractioncode(LocoDataFois unlocos) {
					// TODO Auto-generated method stub
					System.out.println("getuncleasedlocos");
					int locono= unlocos.getLoco_No();		
					System.out.println(locono);
				return  obj_uncleansedrepo.getLocoTractioncode(locono);		
//											return  tc;
					
				
				}
		
		//get uncleansed data as per  locotype 
		public List<MLocoType> getAllLocotypedata(MLocoType unlocotype) {
			// TODO Auto-generated method stub
			System.out.println("getuncleasedlocotype");
			String locotyped=((MLocoType) unlocotype).getLoco_Type();	
			System.out.println(locotyped +"getlocotype");		
			List<MLocoType> unlocotypedata= new ArrayList<>();
			mLocoTypeRepository.getallLocotypedata(locotyped)
			.forEach(unlocotypedata::add);
			if(unlocotypedata.isEmpty()){
				return  unlocotypedata;
			}
			else
			return  unlocotypedata;
		
		}
		
		public List<MLocoBrakeType> getbreaktyp() {
			// TODO Auto-generated method stub
			List<MLocoBrakeType> getbreaktype = new ArrayList<>();			
			obj_breaktyperepo.findAll()
			.forEach(getbreaktype::add);
			return getbreaktype;
			
					}
		
		
		//get all auxilary output list
		public List<MLocoStoreAuxilary> getauxilaryoutput()
		{System.out.println("loco_auxilaryoutput received");
		List<MLocoStoreAuxilary> auxioutput = new ArrayList<>();				
		obj_repoaxo.findall()
				.forEach(auxioutput::add);
		 System.out.println(auxioutput);
		 return auxioutput;		
		}
		
		
		public List<MLocoTractionMotor> getAllMotor() {
			List<MLocoTractionMotor> tmp=new ArrayList<>();
			obj_repo.findmotorcode().forEach(tmp::add);
				return tmp;
			}
		
		
		 public List<MLocoBoggie> getboogie() {
				// TODO Auto-generated method stub
				List<MLocoBoggie> getboogies = new ArrayList<>();
				obj_boogierepo.findAll()
				.forEach(getboogies::add);

				return getboogies;				
						}
		 
		 public List<LocoUncleansedDataElectric> getUnapprovedLocos(LocoUncleansedDataElectric obj_unapproved) {
//				// TODO Auto-generated method stub
				System.out.println("getuncleansedunapprovedocos");
				String shedid=obj_unapproved.getElec_locoOwningShed();
				String locoflag=obj_unapproved.getLocoflag();
				obj_elec.getUnapprovedLoco(shedid,locoflag);		
				List<LocoUncleansedDataElectric> uncleaseLoco= new ArrayList<>();
				obj_elec.getUnapprovedLoco(shedid,locoflag)
				.forEach(uncleaseLoco::add);
				System.out.println(" End getuncleansedunapprovedocos");
				return obj_elec.getUnapprovedLoco(shedid,locoflag);
			}
		 
		 
//			status changed - Approved(A)
			public boolean updatestatus(LocoUncleansedDataElectric unapproved) {
				try{
				String locostatus= unapproved.getElec_Status();
				String remarks=unapproved.getElec_Remarks();
				String user_id=unapproved.getUserid();		
				
				int lno=unapproved.getElec_locoNo();
				System.out.println(lno);
				obj_elec.updatestatus(locostatus,remarks,user_id,lno);				
					return  true ;			
				}
				catch(Exception e){
					
					System.out.println(e);
					return false;
				}
		
	}

			public List<LocoUncleansedDataElectric> getLocoPendingHypershed( LocoUncleansedDataElectric objelecmodel) {
//				// TODO Auto-generated method stub
				System.out.println("getpendingUnapprovedLocos");
				String shedid=objelecmodel.getElec_locoOwningShed();
				obj_elec.getLocoPendingHypershed(shedid);
				List<LocoUncleansedDataElectric> uncleaseLoco= new ArrayList<>();
				obj_elec.getLocoPendingHypershed(shedid)
				.forEach(uncleaseLoco::add);
				System.out.println(" End getuncleansedunapprovedocos");
				return obj_elec.getLocoPendingHypershed(shedid);
//				return uncleaseLoco;
			}
			public List<LocoDataFois> getUncleansedLocoHyperShed( LocoDataFois objelecmodel) {
//				// TODO Auto-generated method stub
				System.out.println("getpendingUnapprovedLocos");
				String shedid=objelecmodel.getLoco_Owningshed();
				obj_uncleansedrepo.getUncleansedLocoHyperShed(shedid);
				List<LocoDataFois> uncleaseLoco= new ArrayList<>();
				obj_uncleansedrepo.getUncleansedLocoHyperShed(shedid)
				.forEach(uncleaseLoco::add);
				System.out.println(" End getuncleansedunapprovedocos");
				return obj_uncleansedrepo.getUncleansedLocoHyperShed(shedid);
//				return uncleaseLoco;
			}

			
			
			/*
			 * public List<LocoDataFois>
			 * getLocoDataFoisDetails(loco_data_fois.getLoco_No()){ int
			 * loco_no=loco_data_fois.getLoco_No(); return
			 * obj_uncleansedrepo.getLocoDataFois(int loco_no);
			 * 
			 * }
			 */
			
			public List<LocoDataFois> getLocoDataFoisDetails(int loco_no){
				//int loco_no=locoDataFois.getLoco_No();
				
				return obj_uncleansedrepo.getLocoDataFois(loco_no);
				
			
			}
			
			
//			public Map<String, Object> getLocoUnclenshedDetails(List<LocoUncleansedDataElectric> listt) {
//
//				List<LocoUncleansedDataElectric> mn = new ArrayList<LocoUncleansedDataElectric>();
//				List<LocoDataFois> m = new ArrayList<LocoDataFois>();
//				Map<String, Object> map = new HashMap<>();
//				
//				for (int i = 0; i < listt.size(); i++) {
//     
//					//mn.addAll(obj_uncleansedcommonrepo.getLocoUnclnesedData(listt.get(i).getLoco_No()));
//					
//					//obj_uncleansedrepo.getLocoDataFois(listt.get(i).getLoco_No()).size()==0;
//					if(obj_uncleansedrepo.getLocoDataFois(listt.get(i).getElec_locoNo()).size()==0) {
//						mn.addAll(obj_elec.getLocoUnclnesedData(listt.get(i).getElec_locoNo()));
//						String s="from loco unclnesed table";
//						map.put(s, mn);
//					}
//					//obj_uncleansedrepo.getLocoDataFois(loco_no)
//					else if(obj_uncleansedrepo.getLocoDataFois(listt.get(i).getElec_locoNo()).size()!=0) {
//					m.addAll(obj_uncleansedrepo.getLocoDataFois(listt.get(i).getElec_locoNo()));
//					String ss="from loco data fois";
//					map.put(ss, m);
//					}
//				}
//				
//				return map;
//			}
//			
			
			
			public  List<LocoTransferResponse> getLocoUnclenshedDetails1( int loco_no) {
				List<LocoUncleansedDataElectric> mn = new ArrayList<LocoUncleansedDataElectric>();
				LocoTransferResponse locoTransferResponse= new LocoTransferResponse();
				List<LocoDataFois> m = new ArrayList<LocoDataFois>();
				Map<String, Object> map = new HashMap<>();				
				List<LocoTransferResponse> resp = new ArrayList<LocoTransferResponse>();				
					if(obj_uncleansedrepo.getLocoDataFois(loco_no).isEmpty()) {						
						if(obj_elec.getLocoUnclnesedData(loco_no).size()!=0) {
						mn.addAll(obj_elec.getLocoUnclnesedData(loco_no));
							System.out.println("inside loco");
						locoTransferResponse.setLocoNo(mn.get(0).getElec_locoNo());
						locoTransferResponse.setLocoType(mn.get(0).getElec_locoType());
						locoTransferResponse.setLocoOwningShed(mn.get(0).getElec_locoOwningShed());
						locoTransferResponse.setLocoOwningZone(mn.get(0).getElec_locoOwningZone());
						locoTransferResponse.setLocoDateOfCommissioning(mn.get(0).getElec_locoDateOfCommision());
						locoTransferResponse.setLocoTractionCode(mn.get(0).getLocoflag());
						locoTransferResponse.setTablestatus("from loco unclnesed table");
						locoTransferResponse.setStatus(mn.get(0).getElec_Status());
					resp.add(locoTransferResponse);
						String s="from loco unclnesed table";
//						map.put(s,resp);
						System.out.println(resp);
						return resp;
						
						} 
						else if(obj_elec.getLocoUnclnesedData(loco_no).size()==0) {
							locoTransferResponse.setStatus("data not present in mdms");
						String s="data not present in mdms";
//						map.put(s, 0);
						System.out.println(resp);
						return resp;
						}
					}
					
					else if(obj_uncleansedrepo.getLocoDataFois(loco_no).size()!=0) {
					m.addAll(obj_uncleansedrepo.getLocoDataFois(loco_no));
//					System.out.println("##inside loco data fois"+m.size());
					locoTransferResponse.setLocoNo(m.get(0).getLoco_No());
					locoTransferResponse.setLocoType(m.get(0).getLoco_Type());
					locoTransferResponse.setLocoOwningShed(m.get(0).getLoco_Owningshed());
					locoTransferResponse.setLocoOwningZone(m.get(0).getLoco_Owningzone());
					locoTransferResponse.setLocoDateOfCommissioning(m.get(0).getLoco_Doc());
					locoTransferResponse.setLocoTractionCode(m.get(0).getLoco_Tractioncode());
					locoTransferResponse.setTablestatus("from loco data fois");					
					List<LocoTransferResponse> response = new ArrayList<LocoTransferResponse>();
					resp.add(locoTransferResponse);
					String s="from loco data fois";
//					map.put(s, response);
//					System.out.println(resp);
					return resp;
					}
					return resp;				
				
//				return resp;
			}
			
		
			public int updataLocoDetails(LocoUncleansedDataElectric locoUncleansedDataElectric) {
				return obj_elec.updateStatus(locoUncleansedDataElectric.getElec_locoOwningZone(),
				locoUncleansedDataElectric.getElec_locoOwningShed(), locoUncleansedDataElectric.getElec_Status(),
				locoUncleansedDataElectric.getElec_locoNo());
			}	
			
			
			public int updateLocoDetail(LocoDataFois locoDataFois) {
				return obj_uncleansedrepo.updateStatus(locoDataFois.getLoco_Owningzone(),
				locoDataFois.getLoco_Owningshed(),locoDataFois.getLoco_No());
			}
			
			// JYOTI BISHT 17-10-22
			
						public int getLocoPending(String from, String to) throws ParseException
					    {
									Date date1= new SimpleDateFormat("yyyy-MM-dd").parse(from);  
									Date date2= new SimpleDateFormat("yyyy-MM-dd").parse(to);  
									return obj_elec.getLocoPending(date1, date2);

						}
			
						// Jyoti Bisht 31-10-22
						public List<Object[]> integration_stats(String from, String to) throws ParseException
						{   
							Date date1= new SimpleDateFormat("yyyy-MM-dd").parse(from);  
							Date date2= new SimpleDateFormat("yyyy-MM-dd").parse(to); 
							return (List<Object[]>) obj_uncleansedrepo.integration(date1, date2);
								
						}
						
						//jyoti bisht
						public int get_total_loco_fois()
						{
							return obj_uncleansedrepo.gettotalLocoDataFois();
						}
						
						// JYOTI BISHT 2-11-22 User privilege
						public List<String> get_shed_by_zone(String zone)
						{
							return obj_shedrepo.get_shed_by_zone(zone);
						}
								
						
						
						// JYOTI BISHT 2-11-22 User privilege
						public List<String> get_div_by_zone(String zone)
						{
							return obj_shedrepo.get_div_by_zone(zone);
						}
						
						// JYOTI BISHT 5-1-23
						
						public List<LocoUncleansedDataElectric> get_loco_details(String zone, String shed, String status)
						{
							return obj_elec.getLocoDetails(zone, shed, status);
						}
						
	                    // JYOTI BISHT 7-1-23   for Shed Code Creation from m_loco_shed_new table
						
						public List<MLocoShedNew> get_loco_shed_details(MLocoShedNew mlocoshed)
						{
							return mlocoshednew.return_loco_shed_data(mlocoshed.getZoneCode(), mlocoshed.getDivisionCode());
						}
						
						public List<Object[]> getAllZone_names()
						{
							 return mlocoshednew.findAllZone();
						}
					
						public List<Object[]> get_div_by_zone_name(String zone)
						{
							return mlocoshednew.get_div_by_zone(zone);
						}
						
						
						public List<MLocoBrakeSubtype> getallsubtype()
						{
							 List<MLocoBrakeSubtype> subtype = new ArrayList<>();		 
							 obj_subtype.getallsubtype().forEach(subtype::add);
							 return subtype;
						}
						
						//ritu  to get uncleansed loco 20june2023
						public List<LocoDataFois> get_loco_uncleanseddetails(String zone, String shed )
						{
							return obj_uncleansedrepo.getLocouncleansedDetails(zone, shed);
						}
						
						
						//ritu  to get total  loco 20june2023
						public List<LocoDataFois> get_loco_totaldetails(String zone, String shed )
						{
							return obj_uncleansedrepo.getLocototalDetails(zone, shed);
						}
						

}
