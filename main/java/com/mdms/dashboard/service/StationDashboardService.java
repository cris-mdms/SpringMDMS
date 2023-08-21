package com.mdms.dashboard.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.mdms.app.mgmt.model.UserProfileRegistrationDetailModel;
import com.mdms.dahsboard.model.DashBoardCoachCountDepoWiseModel;
import com.mdms.dahsboard.model.DashBoardLocoCountShedWiseModel;
import com.mdms.dahsboard.model.DashBoardStationCountDivisionWiseModel;
import com.mdms.dahsboard.model.DashboardStationModel;
import com.mdms.dahsboard.model.GetLocoZonewiseDashboardJsonModel;
import com.mdms.dahsboard.model.StationHomeDashboard;
import com.mdms.dahsboard.model.ZonalUserReportModel;
import com.mdms.dahsboard.model.ZonalUsersAssetModel;
import com.mdms.dashboard.repository.StationDashboardRepo;
import com.mdms.dashboard.repository.StationHomeDashboardRepo;
import com.mdms.loco.locouncleansed.model.LocoDashboardModelRepo;
import com.mdms.loco.locouncleansed.repository.LocoApprovedDataRepository;
import com.mdms.loco.locouncleansed.repository.LocoDataFoisRepository;
import com.mdms.loco.locouncleansed.repository.LocoUncleansedDataElectricRepository;
import com.mdms.mdms_coach.coachuncleansed.repository.CoachCMMDataRepository;
import com.mdms.mdms_coach.coachuncleansed.repository.CoachCleansedDataRepository;
import com.mdms.mdms_coach.coachuncleansed.repository.CoachTypeMappingRepository;
import com.mdms.mdms_coach.coachuncleansed.repository.CoachUncleansedDataRepository;
import com.mdms.mdms_masters.model.MDivision;
import com.mdms.mdms_masters.repository.MDivisionRepository;
import com.mdms.mdms_station.stationuncleansed.model.StationDataRbs;
import com.mdms.mdms_station.stationuncleansed.repository.StationCleansedDataRepository;
import com.mdms.mdms_station.stationuncleansed.repository.StationTableRbsRepository;
import com.mdms.mdms_station.stationuncleansed.repository.StationUncleansedDataRepository;

@Service
public class StationDashboardService {
	 Logger logger=LoggerFactory.getLogger(StationDashboardService.class);
	 
	 String a [];
	 int datel [];
	 String opdslipcount [];
	 
	 //@Autowired
 //LocoDashboardModelRepo locoobj;
//	 StationDashboardRepo stationRepositoryObj;
	 @Autowired 
		MDivisionRepository divsn_repo;
	 
	 @Autowired
	 StationHomeDashboardRepo station_repo;
		
	 
//	 
	 @Autowired
		StationUncleansedDataRepository stn_unclsnd_repo;
		
	 
	 @Autowired
	 StationCleansedDataRepository stn_clsnd_repo;
		
		@Autowired
		StationTableRbsRepository stn_tbl_rbs_repo;
		
		@Autowired
		LocoDataFoisRepository loco_tbl_fois_repo;
		
		@Autowired
		LocoUncleansedDataElectricRepository loco_tbl_repo;
		
		@Autowired
		LocoApprovedDataRepository  loco_tbl_approve;
		MDivision objmdiv;
		
		@Autowired
		CoachCMMDataRepository coach_cmm_repo;
		
		@Autowired
		CoachUncleansedDataRepository coach_unclean_repo;
		
		@Autowired
		CoachCleansedDataRepository coach_clean_repo;

		@Autowired
		private  CoachTypeMappingRepository coach_map_repo;
		@Autowired
		private JdbcTemplate jdbcTemplate;
		
		public HashMap<String, Integer> getStationStats() {
			logger.info("Service : StationDashboardService || Method: getStationStats");

	 HashMap<String, Integer> map = new HashMap<>();
			 
	 try {
			 final String noOfStations = "SELECT count(*) FROM mdms_station.station_table_rbs";
			    final int totalStations = (int)jdbcTemplate.queryForObject(noOfStations,Integer.class);
	
	 
	final String cleansedStations = "select count(*) from mdms_station.station_uncleansed_data";
	final int noOfCleansedStations = (int)jdbcTemplate.queryForObject(cleansedStations, Integer.class);
	
	final String uncleansedStations = "select count(*) from(\r\n" + 
			"	Select stn_code FROM mdms_station.station_table_rbs \r\n" + 
			"	except select station_code FROM mdms_station.station_uncleansed_data) AS uncleansed";
	final int noOfUncleansedStations = (int)jdbcTemplate.queryForObject(uncleansedStations, Integer.class);
	
	//Integer noOfUncleansedStations=totalStations-noOfCleansedStations;
	
	final String unapprovedStations = "select count(*) from mdms_station.station_uncleansed_data where cmi_status='0' OR dti_status='0'";
	final int waitingForApproval = (int)jdbcTemplate.queryForObject(unapprovedStations,Integer.class);
	
			    map.put("noOfUncleansedStations", noOfUncleansedStations);
			    map.put("noOfCleansedStations", noOfCleansedStations);
			    map.put("totalStations", totalStations);
			    map.put("waitingForApproval", waitingForApproval);
			    return map;
		}
		  catch(Exception e) {
		    	logger.error("Service : StationDashboardService || Method: getStationStats|| Exception : " +e.getMessage());
				e.getMessage();
				return null;
		    }
		}
		
		public HashMap<String, Integer> getDivisionWiseStationStats(String  divcode) {
			logger.info("Service : StationDashboardService || Method: getDivisionWiseStationStats");
			 String dc= "MAS";	
	 HashMap<String, Integer> map = new HashMap<>();			 
	 try {
		
			 final String noOfStations = "SELECT count(*) FROM mdms_station.station_table_rbs as a\r\n" + 
			 		"		join mdms_masters.m_division AS b on a.div_ser_no=b.division_sr_no\r\n" + 
			 		"		where b.division_code=dc";
			    final int totalStations = (int)jdbcTemplate.queryForObject(noOfStations,Integer.class);
	
	 
	final String cleansedStations = "select count(*) from mdms_station.station_uncleansed_data where division_code=?1";
	final int noOfCleansedStations = (int)jdbcTemplate.queryForObject(cleansedStations, Integer.class);
	
	final String uncleansedStations = "select count(*) from(\r\n" + 
			"	Select stn_code FROM mdms_station.station_table_rbs \r\n" + 
			"	except select station_code FROM mdms_station.station_uncleansed_data) AS uncleansed where division_code=?1 ";
	final int noOfUncleansedStations = (int)jdbcTemplate.queryForObject(uncleansedStations, Integer.class);
	
	//Integer noOfUncleansedStations=totalStations-noOfCleansedStations;
	
	final String unapprovedStations = "select count(*) from mdms_station.station_uncleansed_data where division_code=?1 AND(cmi_status='0' OR dti_status='0')";
	final int waitingForApproval = (int)jdbcTemplate.queryForObject(unapprovedStations,Integer.class);	
			    map.put("noOfUncleansedStations", noOfUncleansedStations);
			    map.put("noOfCleansedStations", noOfCleansedStations);
			    map.put("totalStations", totalStations);
			    map.put("waitingForApproval", waitingForApproval);
			    return map;
		}
		  catch(Exception e) {
		    	logger.error("Service : StationDashboardService || Method: getDivisionWiseStationStats|| Exception : " +e.getMessage());
				e.getMessage();
				return null;
		    }
		}

			
		 int uncleansedFlag=0;
			
		 
			
		 
		 DashBoardStationCountDivisionWiseModel obj;
		
		//find  station details
		
		public List<DashboardStationModel> getStationCountDivisionWise(DashboardStationModel objzone_code) {
			//String zone_code =objzone_code.getZone_code();
			String division_code =objzone_code.getDivision_code();
			
			List<DashboardStationModel> list= new ArrayList<DashboardStationModel>();			
			Collection<DashBoardStationCountDivisionWiseModel> totalCountList= stn_tbl_rbs_repo.getTotalStationCountDivisionWise(division_code);
				logger.info("Service : DashBoardStationService || Method: getStationCountDivisionWise || getTotalStationCountDivisionWise Query list return : "+totalCountList.size());
				if(totalCountList.size()>0) {
				totalCountList.forEach(DashBoardStationCountDivisionWiseModel -> setTotalDivision(DashBoardStationCountDivisionWiseModel,list));

				}	
				
				Collection<DashBoardStationCountDivisionWiseModel> uncleansedCountList= stn_tbl_rbs_repo.getUncleansedStationCountDivisionWise(division_code);
				logger.info("Service : DashBoardStationService || Method: getStationCountDivisionWise || getUncleansedStationCountDivisionWise Query list return : "+uncleansedCountList.size());

				uncleansedCountList.forEach(DashBoardStationCountDivisionWiseModel -> callTotal(DashBoardStationCountDivisionWiseModel,list));
				
				
				Collection<DashBoardStationCountDivisionWiseModel> pendingApprovalCountList= stn_unclsnd_repo.getPendingApprovalStationCountDivisionWise(division_code);
				logger.info("Service : DashBoardStationService || Method: getStationCountDivisionWise || getPendingApprovalStationCountDivisionWise Query list return : "+pendingApprovalCountList.size());
		
				pendingApprovalCountList.forEach(DashBoardStationCountDivisionWiseModel -> callPendingApproval(DashBoardStationCountDivisionWiseModel,list));

				
				Collection<DashBoardStationCountDivisionWiseModel> cleansedCountList= stn_unclsnd_repo.getTotalCleansedStationCountDivisionWise(division_code);
				logger.info("Service : DashBoardStationService || Method: getStationCountDivisionWise || getTotalCleansedStationCountDivisionWise Query list return : "+cleansedCountList.size());			
				cleansedCountList.forEach(DashBoardStationCountDivisionWiseModel -> callCleansedCount(DashBoardStationCountDivisionWiseModel,list));			
			
				
				Collection<DashBoardStationCountDivisionWiseModel> draftCountList= stn_unclsnd_repo.getTotalDraftForwardApprovalStationCountDivisionWise(division_code);
				logger.info("Service : DashBoardStationService || Method: getStationCountDivisionWise || getTotalDraftForwardApprovalStationCountDivisionWise Query list return : "+draftCountList.size());			
				draftCountList.forEach(DashBoardStationCountDivisionWiseModel -> callDraftCount(DashBoardStationCountDivisionWiseModel,list));	
				
				
				
				
				
				return list;
			
		}


	

		private void callTotal(DashBoardStationCountDivisionWiseModel uncleansedObj,Collection< DashboardStationModel>list) {
			// TODO Auto-generated method stub
			try {		
				uncleansedFlag=0;
				list.forEach(totalobj -> callTotalSub(uncleansedObj,totalobj));	
				if(uncleansedFlag==0){
					DashboardStationModel obj = new DashboardStationModel();
//					obj.setZone_code(uncleansedObj.getzone_code());
					obj.setDivision_code(uncleansedObj.getDivision_code());
					obj.setUncleansed_count(uncleansedObj.getuncleansed_count());
			//		list.add(obj);	
				}
					}catch (Exception e) {
				// TODO: Handle Exception
				e.getMessage();		}
		}
		private void callTotalSub(DashBoardStationCountDivisionWiseModel uncleansedObj,DashboardStationModel totalobj) {
			
			try {
			if(uncleansedObj.getDivision_code().equalsIgnoreCase(totalobj.getDivision_code())) {
				uncleansedFlag++;
				totalobj.setUncleansed_count(uncleansedObj.getuncleansed_count());
			}
			}catch (Exception e) {
				// TODO: handle exception
				e.getMessage();
			}
		}
		

		
		private void callPendingApproval(DashBoardStationCountDivisionWiseModel pendingApprovObj,Collection< DashboardStationModel>list) {
			// TODO Auto-generated method stub
			try {
			
				uncleansedFlag=0;
				list.forEach(totalobj -> callPendingApprovalSub(pendingApprovObj,totalobj));	
				if(uncleansedFlag==0) {
					DashboardStationModel obj = new DashboardStationModel();
//					obj.setZone_code(pendingApprovObj.getzone_code());					
					obj.setDivision_code(pendingApprovObj.getDivision_code());
					obj.setPending_approval(pendingApprovObj.getpending_approval());
			//		list.add(obj);	
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.getMessage();
			}
			
		}
		private void callPendingApprovalSub(DashBoardStationCountDivisionWiseModel pendingApprovObj,DashboardStationModel totalobj) {
			
			try {
			if(pendingApprovObj.getDivision_code().equalsIgnoreCase(totalobj.getDivision_code())) {
				uncleansedFlag++;
				totalobj.setPending_approval(pendingApprovObj.getpending_approval());		
		
			}
			}catch (Exception e) {
				// TODO: handle exception
				e.getMessage();
			}
		}
		
		
		private void callCleansedCount(DashBoardStationCountDivisionWiseModel cleansedObj,Collection< DashboardStationModel>list) {
			// TODO Auto-generated method stub
			
			try {
				uncleansedFlag=0;
				list.forEach(totalobj -> callCleansedCountSub(cleansedObj,totalobj));

		
				if(uncleansedFlag==0) {
					DashboardStationModel obj = new DashboardStationModel();
//					obj.setZone_code(cleansedObj.getzone_code());
					obj.setDivision_code(cleansedObj.getDivision_code());
					obj.setCleansed_count(cleansedObj.getcleansed_count());
				//	list.add(obj);		
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.getMessage();
			}
			
		}
		private void callCleansedCountSub(DashBoardStationCountDivisionWiseModel cleansedObj,DashboardStationModel totalobj) {
			try {
			if(cleansedObj.getDivision_code().equalsIgnoreCase(totalobj.getDivision_code())){
				uncleansedFlag++;
				totalobj.setCleansed_count(cleansedObj.getcleansed_count());	
			}
			}catch (Exception e) {
				// TODO: handle exception
				e.getMessage();
			}
		}
		
		private void callDraftCount(DashBoardStationCountDivisionWiseModel draftObj,Collection< DashboardStationModel>list) {
			// TODO Auto-generated method stub
			
			try {
				uncleansedFlag=0;
				list.forEach(totalobj -> callDraftCountSub(draftObj,totalobj));

		
				if(uncleansedFlag==0) {
					DashboardStationModel obj = new DashboardStationModel();
//					obj.setZone_code(draftObj.getzone_code());
					obj.setDivision_code(draftObj.getDivision_code());
					obj.setDraft_forward_approval_count(draftObj.getDraft_forward_approval_count());
				//	list.add(obj);		
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.getMessage();
			}
			
		}
		private void callDraftCountSub(DashBoardStationCountDivisionWiseModel draftObj,DashboardStationModel totalobj) {
			try {
			if(draftObj.getDivision_code().equalsIgnoreCase(totalobj.getDivision_code())){
				uncleansedFlag++;
				totalobj.setDraft_forward_approval_count(draftObj.getDraft_forward_approval_count());	
		//		System.out.println("draft add in list divcode"+ totalobj.getDivision_code()+"|| AND Draft count: "+totalobj.getDraft_forward_approval_count());
			}
			}catch (Exception e) {
				// TODO: handle exception
				e.getMessage();
			}
		}
		
		
		private void setTotalDivision(DashBoardStationCountDivisionWiseModel DashBoardStationCountDivisionWiseModel,Collection<DashboardStationModel> list) {
		DashboardStationModel obj =new DashboardStationModel();	
//		obj.setZone_code(DashBoardStationCountDivisionWiseModel.getzone_code());
			
		obj.setDivision_code(DashBoardStationCountDivisionWiseModel.getDivision_code());

//		obj.setTotal_division_count(DashBoardStationCountDivisionWiseModel.gettotal_division_count());			

		obj.setTotal_division_count(DashBoardStationCountDivisionWiseModel.gettotal_division_count());			

		list.add(obj);
		
		}
		


		
		
		
	//Shilpi 04-03-2021
		
		public List<DashboardStationModel> getStationCountSingleDivisionWise(DashboardStationModel objdivision_code) {
			String division_code =objdivision_code.getDivision_code();
			List<DashboardStationModel> list= new ArrayList<DashboardStationModel>();		
			Collection<DashBoardStationCountDivisionWiseModel> totalCountLists= stn_tbl_rbs_repo.getTotalStationCountSingleDivisionWise(division_code);
				logger.info("Service : DashBoardStationService || Method: getStationCountSingleDivisionWise || getTotalStationCountSingleDivisionWise Query list return : "+totalCountLists);
				if(totalCountLists.size()>0) {
				totalCountLists.forEach(DashBoardStationCountDivisionWiseModel -> setTotalDivision(DashBoardStationCountDivisionWiseModel,list));

			}	
				
				Collection<DashBoardStationCountDivisionWiseModel> uncleansedCountLists= stn_tbl_rbs_repo.getUncleansedStationCountsingledivision(division_code);
				logger.info("Service : DashBoardStationService || Method: getStationCountSingleDivisionWise || getUncleansedStationCountsingledivision Query list return : "+uncleansedCountLists.size());

				uncleansedCountLists.forEach(DashBoardStationCountDivisionWiseModel -> callTotal(DashBoardStationCountDivisionWiseModel,list));
				
				
				Collection<DashBoardStationCountDivisionWiseModel> pendingApprovalCountLists= stn_unclsnd_repo.getPendingApprovalStationCountSingleDivisionWise(division_code);
				logger.info("Service : DashBoardStationService || Method: getStationCountSingleDivisionWise || getPendingApprovalStationCountSingleDivisionWise Query list return : "+pendingApprovalCountLists.size());
		
				pendingApprovalCountLists.forEach(DashBoardStationCountDivisionWiseModel -> callPendingApproval(DashBoardStationCountDivisionWiseModel,list));

				
				Collection<DashBoardStationCountDivisionWiseModel> cleansedCountLists= stn_clsnd_repo.getTotalCleansedStationCountSingleDivisionWise(division_code);
				logger.info("Service : DashBoardStationService || Method: getStationCountSingleDivisionWise || getTotalCleansedStationCountSingleDivisionWise Query list return : "+cleansedCountLists.size());			
				cleansedCountLists.forEach(DashBoardStationCountDivisionWiseModel -> callCleansedCount(DashBoardStationCountDivisionWiseModel,list));			
			
				
				Collection<DashBoardStationCountDivisionWiseModel> draftCountLists= stn_unclsnd_repo.getTotalDraftForwardApprovalStationCountSingleDivisionWise(division_code);
				logger.info("Service : DashBoardStationService || Method: getStationCountSingleDivisionWise || getTotalDraftForwardApprovalStationCountSingleDivisionWise Query list return : "+draftCountLists.size());			
				draftCountLists.forEach(DashBoardStationCountDivisionWiseModel -> callDraftCount(DashBoardStationCountDivisionWiseModel,list));	
				
				
				
				
				
				return list;
			
		}
			//end changes
		
		private void callTotaldivisionwise(DashBoardStationCountDivisionWiseModel uncleansedObj,Collection< DashboardStationModel>list) {
			// TODO Auto-generated method stub
			try {		
				uncleansedFlag=0;
				list.forEach(totalobj -> callTotalSub(uncleansedObj,totalobj));	
				if(uncleansedFlag==0){
					DashboardStationModel obj = new DashboardStationModel();
//					obj.setZone_code(uncleansedObj.getzone_code());
					obj.setDivision_code(uncleansedObj.getDivision_code());
					obj.setUncleansed_count(uncleansedObj.getuncleansed_count());
			//		list.add(obj);	
				}
					}catch (Exception e) {
				// TODO: Handle Exception
				e.getMessage();		}
		}
		private void callTotalSubdivisionwise(DashBoardStationCountDivisionWiseModel uncleansedObj,DashboardStationModel totalobj) {
			
			try {
			if(uncleansedObj.getDivision_code().equalsIgnoreCase(totalobj.getDivision_code())) {
				uncleansedFlag++;
				totalobj.setUncleansed_count(uncleansedObj.getuncleansed_count());
			}
			}catch (Exception e) {
				// TODO: handle exception
				e.getMessage();
			}
		}
		

		
		private void callPendingApprovaldivisionwise(DashBoardStationCountDivisionWiseModel pendingApprovObj,Collection< DashboardStationModel>list) {
			// TODO Auto-generated method stub
			try {
			
				uncleansedFlag=0;
				list.forEach(totalobj -> callPendingApprovalSub(pendingApprovObj,totalobj));	
				if(uncleansedFlag==0) {
					DashboardStationModel obj = new DashboardStationModel();
//					obj.setZone_code(pendingApprovObj.getzone_code());					
					obj.setDivision_code(pendingApprovObj.getDivision_code());
					obj.setPending_approval(pendingApprovObj.getpending_approval());
			//		list.add(obj);	
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.getMessage();
			}
			
		}
		private void callPendingApprovalSubdivisionwise(DashBoardStationCountDivisionWiseModel pendingApprovObj,DashboardStationModel totalobj) {
			
			try {
			if(pendingApprovObj.getDivision_code().equalsIgnoreCase(totalobj.getDivision_code())) {
				uncleansedFlag++;
				totalobj.setPending_approval(pendingApprovObj.getpending_approval());		
		
			}
			}catch (Exception e) {
				// TODO: handle exception
				e.getMessage();
			}
		}
		
		
		private void callCleansedCountdivisionwise(DashBoardStationCountDivisionWiseModel cleansedObj,Collection< DashboardStationModel>list) {
			// TODO Auto-generated method stub
			
			try {
				uncleansedFlag=0;
				list.forEach(totalobj -> callCleansedCountSub(cleansedObj,totalobj));

		
				if(uncleansedFlag==0) {
					DashboardStationModel obj = new DashboardStationModel();
//					obj.setZone_code(cleansedObj.getzone_code());
					obj.setDivision_code(cleansedObj.getDivision_code());
					obj.setCleansed_count(cleansedObj.getcleansed_count());
				//	list.add(obj);		
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.getMessage();
			}
			
		}
		private void callCleansedCountSubdivisionwise(DashBoardStationCountDivisionWiseModel cleansedObj,DashboardStationModel totalobj) {
			try {
			if(cleansedObj.getDivision_code().equalsIgnoreCase(totalobj.getDivision_code())){
				uncleansedFlag++;
				totalobj.setCleansed_count(cleansedObj.getcleansed_count());	
			}
			}catch (Exception e) {
				// TODO: handle exception
				e.getMessage();
			}
		}
		
		private void callDraftCountdivisionwise(DashBoardStationCountDivisionWiseModel draftObj,Collection< DashboardStationModel>list) {
			// TODO Auto-generated method stub
			
			try {
				uncleansedFlag=0;
				list.forEach(totalobj -> callDraftCountSub(draftObj,totalobj));

		
				if(uncleansedFlag==0) {
					DashboardStationModel obj = new DashboardStationModel();
//					obj.setZone_code(draftObj.getzone_code());
					obj.setDivision_code(draftObj.getDivision_code());
					obj.setDraft_forward_approval_count(draftObj.getDraft_forward_approval_count());
				//	list.add(obj);		
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.getMessage();
			}
			
		}
		private void callDraftCountSubdivisionwise(DashBoardStationCountDivisionWiseModel draftObj,DashboardStationModel totalobj) {
			try {
			if(draftObj.getDivision_code().equalsIgnoreCase(totalobj.getDivision_code())){
				uncleansedFlag++;
				totalobj.setDraft_forward_approval_count(draftObj.getDraft_forward_approval_count());	
		//		System.out.println("draft add in list divcode"+ totalobj.getDivision_code()+"|| AND Draft count: "+totalobj.getDraft_forward_approval_count());
			}
			}catch (Exception e) {
				// TODO: handle exception
				e.getMessage();
			}
		}
		
		
		private void setTotalDivisiondivisionwise(DashBoardStationCountDivisionWiseModel DashBoardStationCountDivisionWiseModel,Collection<DashboardStationModel> list) {
		DashboardStationModel obj =new DashboardStationModel();	
//		obj.setZone_code(DashBoardStationCountDivisionWiseModel.getzone_code());
			
		obj.setDivision_code(DashBoardStationCountDivisionWiseModel.getDivision_code());
		obj.setTotal_division_count(DashBoardStationCountDivisionWiseModel.gettotal_division_count());			
		list.add(obj);
		
		}
		
		





// Shilpi 09-03-2021



		public List<DashboardStationModel> getLocoCountSingleShedWise(DashboardStationModel objshedid) {
			String shedid =objshedid.getLoco_Owningshed();
			
			//String shedid =objshedid.getElec_locoOwningShed();
			List<DashboardStationModel> list= new ArrayList<DashboardStationModel>();		
			Collection<DashBoardLocoCountShedWiseModel> totalCountLists= loco_tbl_fois_repo.getLocoSingleShed(shedid);
				logger.info("Service : DashBoardStationService || Method: getLocoSingleShed || getLocoSingleShed Query list return : "+totalCountLists);
				if(totalCountLists.size()>0) {
				totalCountLists.forEach(DashBoardLocoCountShedWiseModel -> setTotalShedwise(DashBoardLocoCountShedWiseModel,list));

			}	
				
				Collection<DashBoardLocoCountShedWiseModel> uncleansedCountLists= loco_tbl_fois_repo.getUncleansedLocoSingleShed(shedid);
				logger.info("Service : DashBoardStationService || Method: getUncleansedLocoSingleShed || getUncleansedLocoSingleShed Query list return : "+uncleansedCountLists.size());

				uncleansedCountLists.forEach(DashBoardLocoCountShedWiseModel -> callTotalShedwise(DashBoardLocoCountShedWiseModel,list));
				
				
					
				Collection<DashBoardLocoCountShedWiseModel> pendingApprovalCountLists= loco_tbl_repo.getLocoPendingSingleshed(shedid);
				logger.info("Service : DashBoardStationService || Method: getLocoPendingSingleshed || getLocoPendingSingleshed Query list return : "+pendingApprovalCountLists.size());
		
				pendingApprovalCountLists.forEach(DashBoardLocoCountShedWiseModel -> callPendingApprovalShedwise(DashBoardLocoCountShedWiseModel,list));

		
				
				Collection<DashBoardLocoCountShedWiseModel> cleansedCountLists= loco_tbl_approve.getLocoApprovedSingleshed(shedid);
				logger.info("Service : DashBoardStationService || Method: getLocoApprovalSingleshed || getLocoApprovalSingleshed Query list return : "+cleansedCountLists.size());			
				cleansedCountLists.forEach(DashBoardLocoCountShedWiseModel -> callCleansedCountShedwise(DashBoardLocoCountShedWiseModel,list));			
			
				
				Collection<DashBoardLocoCountShedWiseModel> draftCountLists= loco_tbl_repo.getDraftLocoApprovalSingleshed(shedid);
				logger.info("Service : DashBoardStationService || Method: getDraftLocoApprovalSingleshed || getDraftLocoApprovalSingleshed Query list return : "+draftCountLists.size());			
				draftCountLists.forEach(DashBoardLocoCountShedWiseModel -> callDraftCountShedwise(DashBoardLocoCountShedWiseModel,list));	
				
				
				
				
				
				return list;
			
		}
			//end changes
		
		private void callTotalShedwise(DashBoardLocoCountShedWiseModel uncleansedObj,Collection< DashboardStationModel>list) {
			// TODO Auto-generated method stub
			try {		
				uncleansedFlag=0;
				list.forEach(totalobj -> callTotalSubShedwise(uncleansedObj,totalobj));	
				if(uncleansedFlag==0){
					DashboardStationModel obj = new DashboardStationModel();
//					obj.setZone_code(uncleansedObj.getzone_code());
					obj.setLoco_Owningshed(uncleansedObj.getLoco_Owningshed());
					obj.setUncleansed_count(uncleansedObj.getuncleansed_count());
			//		list.add(obj);	
				}
					}catch (Exception e) {
				// TODO: Handle Exception
				e.getMessage();		}
		}
		private void callTotalSubShedwise(DashBoardLocoCountShedWiseModel uncleansedObj,DashboardStationModel totalobj) {
			
			try {
			if(uncleansedObj.getLoco_Owningshed().equalsIgnoreCase(totalobj.getLoco_Owningshed())) {
				uncleansedFlag++;
				totalobj.setUncleansed_count(uncleansedObj.getuncleansed_count());
			}
			}catch (Exception e) {
				// TODO: handle exception
				e.getMessage();
			}
		}
		

		
		private void callPendingApprovalShedwise(DashBoardLocoCountShedWiseModel pendingApprovObj,Collection< DashboardStationModel>list) {
			// TODO Auto-generated method stub
			try {
			
				uncleansedFlag=0;
				list.forEach(totalobj -> callPendingApprovalSubShedwise(pendingApprovObj,totalobj));	
				if(uncleansedFlag==0) {
					DashboardStationModel obj = new DashboardStationModel();
//					obj.setZone_code(pendingApprovObj.getzone_code());					
					obj.setLoco_Owningshed(pendingApprovObj.getLoco_Owningshed());
					obj.setPending_approval(pendingApprovObj.getpending_approval());
			//		list.add(obj);	
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.getMessage();
			}
			
		}
		private void callPendingApprovalSubShedwise(DashBoardLocoCountShedWiseModel pendingApprovObj,DashboardStationModel totalobj) {
			
			try {
			if(pendingApprovObj.getLoco_Owningshed().equalsIgnoreCase(totalobj.getLoco_Owningshed())) {
				uncleansedFlag++;
				totalobj.setPending_approval(pendingApprovObj.getpending_approval());		
		
			}
			}catch (Exception e) {
				// TODO: handle exception
				e.getMessage();
			}
		}
		
		
		private void callCleansedCountShedwise(DashBoardLocoCountShedWiseModel cleansedObj,Collection< DashboardStationModel>list) {
			// TODO Auto-generated method stub
			
			try {
				uncleansedFlag=0;
				list.forEach(totalobj -> callCleansedCountSubShedwise(cleansedObj,totalobj));

		
				if(uncleansedFlag==0) {
					DashboardStationModel obj = new DashboardStationModel();
//					obj.setZone_code(cleansedObj.getzone_code());
					obj.setLoco_Owningshed(cleansedObj.getLoco_Owningshed());
					obj.setCleansed_count(cleansedObj.getcleansed_count());
				//	list.add(obj);		
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.getMessage();
			}
			
		}
		private void callCleansedCountSubShedwise(DashBoardLocoCountShedWiseModel cleansedObj,DashboardStationModel totalobj) {
			try {
			if(cleansedObj.getLoco_Owningshed().equalsIgnoreCase(totalobj.getLoco_Owningshed())){
				uncleansedFlag++;
				totalobj.setCleansed_count(cleansedObj.getcleansed_count());	
			}
			}catch (Exception e) {
				// TODO: handle exception
				e.getMessage();
			}
		}
		
		private void callDraftCountShedwise(DashBoardLocoCountShedWiseModel draftObj,Collection< DashboardStationModel>list) {
			// TODO Auto-generated method stub
			
			try {
				uncleansedFlag=0;
				list.forEach(totalobj -> callDraftCountShedwise(draftObj,totalobj));

		
				if(uncleansedFlag==0) {
					DashboardStationModel obj = new DashboardStationModel();
//					obj.setZone_code(draftObj.getzone_code());
					obj.setLoco_Owningshed(draftObj.getLoco_Owningshed());
//					obj.setElec_locoOwningShed(draftObj.getelec_locoOwningShed());
					obj.setDraft_forward_approval_count(draftObj.getDraft_forward_approval_count());
				//	list.add(obj);		
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.getMessage();
			}
			
		}
		private void callDraftCountShedwise(DashBoardLocoCountShedWiseModel draftObj,DashboardStationModel totalobj) {
			try {
			if(draftObj.getLoco_Owningshed().equalsIgnoreCase(totalobj.getLoco_Owningshed())){
				uncleansedFlag++;
				totalobj.setDraft_forward_approval_count(draftObj.getDraft_forward_approval_count());	
		//		System.out.println("draft add in list divcode"+ totalobj.getshedid()+"|| AND Draft count: "+totalobj.getDraft_forward_approval_count());
			}
			}catch (Exception e) {
				// TODO: handle exception
				e.getMessage();
			}
		}
		
		
		private void setTotalShedwise(DashBoardLocoCountShedWiseModel DashBoardLocoCountShedWiseModel,Collection<DashboardStationModel> list) {
		DashboardStationModel obj =new DashboardStationModel();	
//		obj.setZone_code(DashBoardStationCountDivisionWiseModel.getzone_code());
			
		obj.setLoco_Owningshed(DashBoardLocoCountShedWiseModel.getLoco_Owningshed());
		obj.setTotal_loco_count(DashBoardLocoCountShedWiseModel.getTotal_loco_count());			
		list.add(obj);
		
		}
		
		
		// Shilpi 16-03-2021



				public List<DashboardStationModel> getCoachCountSingleDepotWise(DashboardStationModel objcoachid) {
					String owning_depot =objcoachid.getOwning_depot();
					
					
					
					List<DashboardStationModel> list= new ArrayList<DashboardStationModel>();		
					Collection<DashBoardCoachCountDepoWiseModel> totalCountLists= coach_cmm_repo.getCoachSingleDepo(owning_depot);
						logger.info("Service : DashBoardStationService || Method: getCaochSingleDepo || getCaochSingleDepo Query list return : "+totalCountLists);
						if(totalCountLists.size()>0) {
						totalCountLists.forEach(DashBoardCoachCountDepoWiseModel -> setTotalShedwise(DashBoardCoachCountDepoWiseModel,list));

					}	
						
						Collection<DashBoardCoachCountDepoWiseModel> uncleansedCountLists= coach_cmm_repo.getUncleansedCoachSingleDepo(owning_depot);
						logger.info("Service : DashBoardStationService || Method: getUncleansedCoachSingleDepo || getUncleansedCoachSingleDepo Query list return : "+uncleansedCountLists.size());

						uncleansedCountLists.forEach(DashBoardCoachCountDepoWiseModel -> callTotalShedwise(DashBoardCoachCountDepoWiseModel,list));
						
						
							
						Collection<DashBoardCoachCountDepoWiseModel> pendingApprovalCountLists= coach_unclean_repo.getCoachPendingSingledepo(owning_depot);
						logger.info("Service : DashBoardStationService || Method: getCoachPendingSingledepo || getCoachPendingSingledepo Query list return : "+pendingApprovalCountLists.size());
				
						pendingApprovalCountLists.forEach(DashBoardCoachCountDepoWiseModel -> callPendingApprovalShedwise(DashBoardCoachCountDepoWiseModel,list));

				
						
						Collection<DashBoardCoachCountDepoWiseModel> cleansedCountLists= coach_clean_repo.getCoachApprovedSingleDepo(owning_depot);
						logger.info("Service : DashBoardStationService || Method: getCoachApprovedSingleDepo || getCoachApprovedSingleDepo Query list return : "+cleansedCountLists.size());			
						cleansedCountLists.forEach(DashBoardCoachCountDepoWiseModel -> callCleansedCountShedwise(DashBoardCoachCountDepoWiseModel,list));			
					
						
						Collection<DashBoardCoachCountDepoWiseModel> draftCountLists= coach_unclean_repo.getDraftCoachApprovalSingledepo(owning_depot);
						logger.info("Service : DashBoardStationService || Method: getDraftCoachApprovalSingledepo || getDraftCoachApprovalSingledepo Query list return : "+draftCountLists.size());			
						draftCountLists.forEach(DashBoardCoachCountDepoWiseModel -> callDraftCountShedwise(DashBoardCoachCountDepoWiseModel,list));	
						
						
						
						
						
						return list;
					
				}
					//end changes
				
				private void callTotalShedwise(DashBoardCoachCountDepoWiseModel uncleansedObj,Collection< DashboardStationModel>list) {
					// TODO Auto-generated method stub
					try {		
						uncleansedFlag=0;
						list.forEach(totalobj -> callTotalSubShedwise(uncleansedObj,totalobj));	
						if(uncleansedFlag==0){
							DashboardStationModel obj = new DashboardStationModel();
//							obj.setZone_code(uncleansedObj.getzone_code());
							obj.setOwning_depot(uncleansedObj.getOwning_depot());
							obj.setUncleansed_count(uncleansedObj.getuncleansed_count());
					//		list.add(obj);	
						}
							}catch (Exception e) {
						// TODO: Handle Exception
						e.getMessage();		}
				}
				private void callTotalSubShedwise(DashBoardCoachCountDepoWiseModel uncleansedObj,DashboardStationModel totalobj) {
					
					try {
					if(uncleansedObj.getOwning_depot().equalsIgnoreCase(totalobj.getOwning_depot())) {
						uncleansedFlag++;
						totalobj.setUncleansed_count(uncleansedObj.getuncleansed_count());
					}
					}catch (Exception e) {
						// TODO: handle exception
						e.getMessage();
					}
				}
				

				
				private void callPendingApprovalShedwise(DashBoardCoachCountDepoWiseModel pendingApprovObj,Collection< DashboardStationModel>list) {
					// TODO Auto-generated method stub
					try {
					
						uncleansedFlag=0;
						list.forEach(totalobj -> callPendingApprovalSubShedwise(pendingApprovObj,totalobj));	
						if(uncleansedFlag==0) {
							DashboardStationModel obj = new DashboardStationModel();
//							obj.setZone_code(pendingApprovObj.getzone_code());					
							obj.setOwning_depot(pendingApprovObj.getOwning_depot());
							obj.setPending_approval(pendingApprovObj.getpending_approval());
					//		list.add(obj);	
						}
					}catch (Exception e) {
						// TODO: handle exception
						e.getMessage();
					}
					
				}
				private void callPendingApprovalSubShedwise(DashBoardCoachCountDepoWiseModel pendingApprovObj,DashboardStationModel totalobj) {
					
					try {
					if(pendingApprovObj.getOwning_depot().equalsIgnoreCase(totalobj.getOwning_depot())) {
						uncleansedFlag++;
						totalobj.setPending_approval(pendingApprovObj.getpending_approval());		
				
					}
					}catch (Exception e) {
						// TODO: handle exception
						e.getMessage();
					}
				}
				
				
				private void callCleansedCountShedwise(DashBoardCoachCountDepoWiseModel cleansedObj,Collection< DashboardStationModel>list) {
					// TODO Auto-generated method stub
					
					try {
						uncleansedFlag=0;
						list.forEach(totalobj -> callCleansedCountSubShedwise(cleansedObj,totalobj));

				
						if(uncleansedFlag==0) {
							DashboardStationModel obj = new DashboardStationModel();
//							obj.setZone_code(cleansedObj.getzone_code());
							obj.setOwning_depot(cleansedObj.getOwning_depot());
							obj.setCleansed_count(cleansedObj.getcleansed_count());
						//	list.add(obj);		
						}
					}catch (Exception e) {
						// TODO: handle exception
						e.getMessage();
					}
					
				}
				private void callCleansedCountSubShedwise(DashBoardCoachCountDepoWiseModel cleansedObj,DashboardStationModel totalobj) {
					try {
					if(cleansedObj.getOwning_depot().equalsIgnoreCase(totalobj.getOwning_depot())){
						uncleansedFlag++;
						totalobj.setCleansed_count(cleansedObj.getcleansed_count());	
					}
					}catch (Exception e) {
						// TODO: handle exception
						e.getMessage();
					}
				}
				
				private void callDraftCountShedwise(DashBoardCoachCountDepoWiseModel draftObj,Collection< DashboardStationModel>list) {
					// TODO Auto-generated method stub
					
					try {
						uncleansedFlag=0;
						list.forEach(totalobj -> callDraftCountShedwise(draftObj,totalobj));

				
						if(uncleansedFlag==0) {
							DashboardStationModel obj = new DashboardStationModel();
//							obj.setZone_code(draftObj.getzone_code());
							obj.setOwning_depot(draftObj.getOwning_depot());
//							obj.setElec_locoOwningShed(draftObj.getelec_locoOwningShed());
							obj.setDraft_forward_approval_count(draftObj.getdraft_forward_approval_count());
						//	list.add(obj);		
						}
					}catch (Exception e) {
						// TODO: handle exception
						e.getMessage();
					}
					
				}
				private void callDraftCountShedwise(DashBoardCoachCountDepoWiseModel draftObj,DashboardStationModel totalobj) {
					try {
					if(draftObj.getOwning_depot().equalsIgnoreCase(totalobj.getOwning_depot())){
						uncleansedFlag++;
						totalobj.setDraft_forward_approval_count(draftObj.getdraft_forward_approval_count());	
				//		System.out.println("draft add in list divcode"+ totalobj.getowning_depot()+"|| AND Draft count: "+totalobj.getDraft_forward_approval_count());
					}
					}catch (Exception e) {
						// TODO: handle exception
						e.getMessage();
					}
				}
				
				
				private void setTotalShedwise(DashBoardCoachCountDepoWiseModel DashBoardCoachCountDepoWiseModel,Collection<DashboardStationModel> list) {
				DashboardStationModel obj =new DashboardStationModel();	
//				obj.setZone_code(DashBoardStationCountDivisionWiseModel.getzone_code());
					
				obj.setOwning_depot(DashBoardCoachCountDepoWiseModel.getOwning_depot());
				obj.setTotal_depo_count(DashBoardCoachCountDepoWiseModel.getTotal_depo_count());			
				list.add(obj);
				
				}
				
				
// Shilpi 19-03-2021 zone wise loco-stn
				
				public List<DashboardStationModel> getStationCountZoneWise(DashboardStationModel obj1zone_code) {
					String zone_code =obj1zone_code.getZone_code();
					
					List<DashboardStationModel> list= new ArrayList<DashboardStationModel>();		
					Collection<DashBoardStationCountDivisionWiseModel> totalCountLists=stn_tbl_rbs_repo.getTotalStationCountZoneWise(zone_code);
						logger.info("Service : DashBoardStationService || Method: getStnZone || getStnZone Query list return : "+totalCountLists);
						if(totalCountLists.size()>0) {
						totalCountLists.forEach(DashBoardStationCountDivisionWiseModel -> setTotalZone(DashBoardStationCountDivisionWiseModel,list));

					}	
						
						Collection<DashBoardStationCountDivisionWiseModel> uncleansedCountLists= stn_tbl_rbs_repo.getUncleansedStationCountZone(zone_code);
						logger.info("Service : DashBoardStationService || Method: getUncleansedLocoZoneShed || getUncleansedLocoZoneShed Query list return : "+uncleansedCountLists.size());

						uncleansedCountLists.forEach(DashBoardStationCountDivisionWiseModel -> callUncleansedLocoZoneShed(DashBoardStationCountDivisionWiseModel,list));
						
						
							
						Collection<DashBoardStationCountDivisionWiseModel> pendingApprovalCountLists= stn_unclsnd_repo.getPendingApprovalStationCountZoneWise(zone_code);
						logger.info("Service : DashBoardStationService || Method: getLocoPendingZoneshed || getLocoPendingZoneshed Query list return : "+pendingApprovalCountLists.size());
				
						pendingApprovalCountLists.forEach(DashBoardStationCountDivisionWiseModel -> callPendingApproval1(DashBoardStationCountDivisionWiseModel,list));

				
						
						Collection<DashBoardStationCountDivisionWiseModel> cleansedCountLists= stn_clsnd_repo.getTotalCleansedStationCountZoneWise(zone_code);
						logger.info("Service : DashBoardStationService || Method: getLocoApprovedZoneShed || getLocoApprovedZoneShed Query list return : "+cleansedCountLists.size());			
						cleansedCountLists.forEach(DashBoardStationCountDivisionWiseModel -> callCleansedCount1(DashBoardStationCountDivisionWiseModel,list));			
					
						
						Collection<DashBoardStationCountDivisionWiseModel> draftCountLists= stn_unclsnd_repo.getTotalDraftForwardApprovalStationCountZoneWise(zone_code);
						logger.info("Service : DashBoardStationService || Method: getDraftLocoApprovalZoneshed || getDraftLocoApprovalZoneshed Query list return : "+draftCountLists.size());			
						draftCountLists.forEach(DashBoardStationCountDivisionWiseModel -> callDraftCount1(DashBoardStationCountDivisionWiseModel,list));	
										
						
						return list;
					
				}
					//end changes
				
				private void callUncleansedLocoZoneShed(DashBoardStationCountDivisionWiseModel uncleansedObj,Collection< DashboardStationModel>list) {
					// TODO Auto-generated method stub
					try {		
						uncleansedFlag=0;
						list.forEach(totalobj -> callTotalSubb(uncleansedObj,totalobj));	
						if(uncleansedFlag==0){
							DashboardStationModel obj = new DashboardStationModel();
							obj.setZone_code(uncleansedObj.getzone_code());	
							obj.setLoco_Owningshed(uncleansedObj.getLoco_Owningshed());
							obj.setUncleansed_count(uncleansedObj.getuncleansed_count());
							list.add(obj);	
						}
							}catch (Exception e) {
						// TODO: Handle Exception
						e.getMessage();		}
				}
				private void callTotalSubb(DashBoardStationCountDivisionWiseModel uncleansedObj,DashboardStationModel totalobj) {
					
					try {
					if(uncleansedObj.getLoco_Owningshed().equalsIgnoreCase(totalobj.getLoco_Owningshed())) {
						uncleansedFlag++;
						totalobj.setUncleansed_count(uncleansedObj.getuncleansed_count());
					}
					}catch (Exception e) {
						// TODO: handle exception
						e.getMessage();
					}
				}
				

				
				private void callPendingApproval1(DashBoardStationCountDivisionWiseModel pendingApprovObj,Collection< DashboardStationModel>list) {
					// TODO Auto-generated method stub
					try {
					
						uncleansedFlag=0;
						list.forEach(totalobj -> callPendingApprovalSubb(pendingApprovObj,totalobj));	
						if(uncleansedFlag==0) {
							DashboardStationModel obj = new DashboardStationModel();
							obj.setZone_code(pendingApprovObj.getzone_code());					
							obj.setDivision_code(pendingApprovObj.getDivision_code());
							obj.setPending_approval(pendingApprovObj.getpending_approval());
//							list.add(obj);	
						}
					}catch (Exception e) {
						// TODO: handle exception
						e.getMessage();
					}
					
				}
				private void callPendingApprovalSubb(DashBoardStationCountDivisionWiseModel pendingApprovObj,DashboardStationModel totalobj) {
					
					try {
					if(pendingApprovObj.getDivision_code().equalsIgnoreCase(totalobj.getDivision_code())) {
						uncleansedFlag++;
						totalobj.setPending_approval(pendingApprovObj.getpending_approval());		
				
					}
					}catch (Exception e) {
						// TODO: handle exception
						e.getMessage();
					}
				}
				
				
				private void callCleansedCount1(DashBoardStationCountDivisionWiseModel cleansedObj,Collection< DashboardStationModel>list) {
					// TODO Auto-generated method stub
					
					try {
						uncleansedFlag=0;
						list.forEach(totalobj -> callCleansedCountSubb(cleansedObj,totalobj));

				
						if(uncleansedFlag==0) {
							DashboardStationModel obj = new DashboardStationModel();
						    obj.setZone_code(cleansedObj.getzone_code());
							obj.setLoco_Owningshed(cleansedObj.getLoco_Owningshed());
							obj.setCleansed_count(cleansedObj.getcleansed_count());
//							list.add(obj);		
						}
					}catch (Exception e) {
						// TODO: handle exception
						e.getMessage();
					}
					
				}
				private void callCleansedCountSubb(DashBoardStationCountDivisionWiseModel cleansedObj,DashboardStationModel totalobj) {
					try {
					if(cleansedObj.getLoco_Owningshed().equalsIgnoreCase(totalobj.getLoco_Owningshed())){
						uncleansedFlag++;
						totalobj.setCleansed_count(cleansedObj.getcleansed_count());	
					}
					}catch (Exception e) {
						// TODO: handle exception
						e.getMessage();
					}
				}
				
				private void callDraftCount1(DashBoardStationCountDivisionWiseModel draftObj,Collection< DashboardStationModel>list) {
					// TODO Auto-generated method stub
					
					try {
						uncleansedFlag=0;
						list.forEach(totalobj -> callDraftCountSubb(draftObj,totalobj));				
						if(uncleansedFlag==0) {
							DashboardStationModel obj = new DashboardStationModel();
          				 obj.setZone_code(draftObj.getzone_code());						
							obj.setDivision_code(draftObj.getDivision_code());
							obj.setDraft_forward_approval_count(draftObj.getDraft_forward_approval_count());
//							list.add(obj);		
						}
					}catch (Exception e) {
						// TODO: handle exception
						e.getMessage();
					}
					
				}
				private void callDraftCountSubb(DashBoardStationCountDivisionWiseModel draftObj,DashboardStationModel totalobj) {
					try {
					if(draftObj.getDivision_code().equalsIgnoreCase(totalobj.getDivision_code())){
						uncleansedFlag++;
						totalobj.setDraft_forward_approval_count(draftObj.getDraft_forward_approval_count());	
				//		System.out.println("draft add in list divcode"+ totalobj.getshedid()+"|| AND Draft count: "+totalobj.getDraft_forward_approval_count());
					}
					}catch (Exception e) {
						// TODO: handle exception
						e.getMessage();
					}
				}
				
				
				private void setTotalZone(DashBoardStationCountDivisionWiseModel DashBoardStationCountDivisionWiseModel,Collection<DashboardStationModel> list) {
				DashboardStationModel obj =new DashboardStationModel();	
				obj.setZone_code(DashBoardStationCountDivisionWiseModel.getzone_code());
			
			obj.setDivision_code(DashBoardStationCountDivisionWiseModel.getDivision_code());
//
			obj.setTotal_division_count(DashBoardStationCountDivisionWiseModel.gettotal_division_count());			

		list.add(obj);
				
				}
				
		//Shilpi 22-03-2021 -- loco service
				
				
				public List<DashboardStationModel> getLocoCountZoneWise(DashboardStationModel obj1zone_code) {
					String loco_owning_zone_code =obj1zone_code.getLoco_owning_zone_code();
					
					List<DashboardStationModel> list= new ArrayList<DashboardStationModel>();		
					Collection<DashBoardLocoCountShedWiseModel> totalCountLists= loco_tbl_fois_repo.getLocoZoneShed(loco_owning_zone_code);
						logger.info("Service : DashBoardStationService || Method: getLocoZoneShed || getLocoZoneShed Query list return : "+totalCountLists);
						if(totalCountLists.size()>0) {
						totalCountLists.forEach(DashBoardLocoCountShedWiseModel -> setTotalZoneShed(DashBoardLocoCountShedWiseModel,list));
//						totalCountLists.forEach(DashBoardLocoCountShedWiseModel -> callTotalfoisLocoZoneShed(DashBoardLocoCountShedWiseModel,list)); 

					}	
						
						Collection<DashBoardLocoCountShedWiseModel> uncleansedCountLists= loco_tbl_fois_repo.getUncleansedLocoZoneShed(loco_owning_zone_code);
						logger.info("Service : DashBoardStationService || Method: getUncleansedLocoZoneShed || getUncleansedLocoZoneShed Query list return : "+uncleansedCountLists.size());

						uncleansedCountLists.forEach(DashBoardLocoCountShedWiseModel -> callUncleansedLocoZoneShed(DashBoardLocoCountShedWiseModel,list));
						
						
							
						Collection<DashBoardLocoCountShedWiseModel> pendingApprovalCountLists= loco_tbl_repo.getLocoPendingZoneshed(loco_owning_zone_code);
						logger.info("Service : DashBoardStationService || Method: getLocoPendingZoneshed || getLocoPendingZoneshed Query list return : "+pendingApprovalCountLists.size());
				
						pendingApprovalCountLists.forEach(DashBoardLocoCountShedWiseModel -> callLocoPendingZoneshed(DashBoardLocoCountShedWiseModel,list));

				
						
						Collection<DashBoardLocoCountShedWiseModel> cleansedCountLists= loco_tbl_approve.getLocoApprovedZoneShed(loco_owning_zone_code);
						logger.info("Service : DashBoardStationService || Method: getLocoApprovedZoneShed || getLocoApprovedZoneShed Query list return : "+cleansedCountLists.size());			
						cleansedCountLists.forEach(DashBoardLocoCountShedWiseModel -> callApprovedZoneShed(DashBoardLocoCountShedWiseModel,list));			
					
						
						Collection<DashBoardLocoCountShedWiseModel> draftCountLists= loco_tbl_repo.getDraftLocoApprovalZoneshed(loco_owning_zone_code);
						logger.info("Service : DashBoardStationService || Method: getDraftLocoApprovalZoneshed || getDraftLocoApprovalZoneshed Query list return : "+draftCountLists.size());			
						draftCountLists.forEach(DashBoardLocoCountShedWiseModel -> callDraftLocoApprovalZone(DashBoardLocoCountShedWiseModel,list));	
										
						
						return list;
					
				}
					//end changes
				
				private void callTotalfoisLocoZoneShed(DashBoardLocoCountShedWiseModel uncleansedObj,Collection< DashboardStationModel>list) {
					// TODO Auto-generated method stub
					try {		
						uncleansedFlag=0;
						list.forEach(totalobj -> callTotalLocoSubShedwise1(uncleansedObj,totalobj));	
						if(uncleansedFlag==0){
							DashboardStationModel obj = new DashboardStationModel();
							obj.setLoco_owning_zone_code(uncleansedObj.getLoco_owning_zone_code());	
							obj.setLoco_owning_shed_code(uncleansedObj.getLoco_owning_shed_code());
							obj.setUncleansed_count(uncleansedObj.getuncleansed_count());
					//		list.add(obj);	
						}
							}catch (Exception e) {
						// TODO: Handle Exception
						e.getMessage();		}
				}
				private void callTotalLocoSubShedwise1(DashBoardLocoCountShedWiseModel uncleansedObj,DashboardStationModel totalobj) {
					
					try {
					if(uncleansedObj.getLoco_owning_shed_code().equalsIgnoreCase(totalobj.getLoco_owning_shed_code())) {
						uncleansedFlag++;
						totalobj.setUncleansed_count(uncleansedObj.getuncleansed_count());
					}
					}catch (Exception e) {
						// TODO: handle exception
						e.getMessage();
					}
				}
				
				
				
				
				private void callUncleansedLocoZoneShed(DashBoardLocoCountShedWiseModel uncleansedObj,Collection< DashboardStationModel>list) {
					// TODO Auto-generated method stub
					try {		
						uncleansedFlag=0;
						list.forEach(totalobj -> callTotalSubShedwise1(uncleansedObj,totalobj));	
						if(uncleansedFlag==0){
							DashboardStationModel obj = new DashboardStationModel();
							obj.setLoco_owning_zone_code(uncleansedObj.getLoco_owning_zone_code());	
							obj.setLoco_Owningshed(uncleansedObj.getLoco_Owningshed());
							obj.setUncleansed_count(uncleansedObj.getuncleansed_count());
					//		list.add(obj);	
						}
							}catch (Exception e) {
						// TODO: Handle Exception
						e.getMessage();		}
				}
				private void callTotalSubShedwise1(DashBoardLocoCountShedWiseModel uncleansedObj,DashboardStationModel totalobj) {
					
					try {
					if(uncleansedObj.getLoco_Owningshed().equalsIgnoreCase(totalobj.getLoco_Owningshed())) {
						uncleansedFlag++;
						totalobj.setUncleansed_count(uncleansedObj.getuncleansed_count());
					}
					}catch (Exception e) {
						// TODO: handle exception
						e.getMessage();
					}
				}
				

				
				private void callLocoPendingZoneshed(DashBoardLocoCountShedWiseModel pendingApprovObj,Collection< DashboardStationModel>list) {
					// TODO Auto-generated method stub
					try {
					
						uncleansedFlag=0;
						list.forEach(totalobj -> callPendingApprovalSubShedwise1(pendingApprovObj,totalobj));	
						if(uncleansedFlag==0) {
							DashboardStationModel obj = new DashboardStationModel();
							obj.setLoco_owning_zone_code(pendingApprovObj.getLoco_owning_zone_code());					
							obj.setLoco_Owningshed(pendingApprovObj.getLoco_Owningshed());
							obj.setPending_approval(pendingApprovObj.getpending_approval());
					//		list.add(obj);	
						}
					}catch (Exception e) {
						// TODO: handle exception
						e.getMessage();
					}
					
				}
				private void callPendingApprovalSubShedwise1(DashBoardLocoCountShedWiseModel pendingApprovObj,DashboardStationModel totalobj) {
					
					try {
					if(pendingApprovObj.getLoco_Owningshed().equalsIgnoreCase(totalobj.getLoco_Owningshed())) {
						uncleansedFlag++;
						totalobj.setPending_approval(pendingApprovObj.getpending_approval());		
				
					}
					}catch (Exception e) {
						// TODO: handle exception
						e.getMessage();
					}
				}
				
				
				private void callApprovedZoneShed(DashBoardLocoCountShedWiseModel cleansedObj,Collection< DashboardStationModel>list) {
					// TODO Auto-generated method stub
					
					try {
						uncleansedFlag=0;
						list.forEach(totalobj -> callCleansedCountSubShedwise1(cleansedObj,totalobj));

				
						if(uncleansedFlag==0) {
							DashboardStationModel obj = new DashboardStationModel();
						    obj.setLoco_owning_zone_code(cleansedObj.getLoco_owning_zone_code());
							obj.setLoco_Owningshed(cleansedObj.getLoco_Owningshed());
							obj.setCleansed_count(cleansedObj.getcleansed_count());
						//	list.add(obj);		
						}
					}catch (Exception e) {
						// TODO: handle exception
						e.getMessage();
					}
					
				}
				private void callCleansedCountSubShedwise1(DashBoardLocoCountShedWiseModel cleansedObj,DashboardStationModel totalobj) {
					try {
					if(cleansedObj.getLoco_Owningshed().equalsIgnoreCase(totalobj.getLoco_Owningshed())){
						uncleansedFlag++;
						totalobj.setCleansed_count(cleansedObj.getcleansed_count());	
					}
					}catch (Exception e) {
						// TODO: handle exception
						e.getMessage();
					}
				}
				
				private void callDraftLocoApprovalZone(DashBoardLocoCountShedWiseModel draftObj,Collection< DashboardStationModel>list) {
					// TODO Auto-generated method stub
					
					try {
						uncleansedFlag=0;
						list.forEach(totalobj -> callDraftCountShedwise1(draftObj,totalobj));

				
						if(uncleansedFlag==0) {
							DashboardStationModel obj = new DashboardStationModel();
          				// obj.setZone_code(draftObj.getzone_code());
							obj.setLoco_owning_zone_code(draftObj.getLoco_owning_zone_code());
							obj.setLoco_Owningshed(draftObj.getLoco_Owningshed());
//							obj.setElec_locoOwningShed(draftObj.getelec_locoOwningShed());
							obj.setDraft_forward_approval_count(draftObj.getDraft_forward_approval_count());
						//	list.add(obj);		
						}
					}catch (Exception e) {
						// TODO: handle exception
						e.getMessage();
					}
					
				}
				private void callDraftCountShedwise1(DashBoardLocoCountShedWiseModel draftObj,DashboardStationModel totalobj) {
					try {
					if(draftObj.getLoco_Owningshed().equalsIgnoreCase(totalobj.getLoco_Owningshed())){
						uncleansedFlag++;
						totalobj.setDraft_forward_approval_count(draftObj.getDraft_forward_approval_count());	
				//		System.out.println("draft add in list divcode"+ totalobj.getshedid()+"|| AND Draft count: "+totalobj.getDraft_forward_approval_count());
					}
					}catch (Exception e) {
						// TODO: handle exception
						e.getMessage();
					}
				}
				
				
				private void setTotalZoneShed(DashBoardLocoCountShedWiseModel DashBoardLocoCountShedWiseModel,Collection<DashboardStationModel> list) {
				DashboardStationModel obj =new DashboardStationModel();	
         		//obj.setLoco_owning_zone_code(DashBoardStationCountDivisionWiseModel.getLoco_owning_zone_code());	
				obj.setLoco_owning_zone_code(DashBoardLocoCountShedWiseModel.getLoco_owning_zone_code());
				obj.setLoco_Owningshed(DashBoardLocoCountShedWiseModel.getLoco_Owningshed());
//				obj.setLoco_owning_shed_code(DashBoardLocoCountShedWiseModel.getLoco_owning_shed_code());
				obj.setTotal_loco_count(DashBoardLocoCountShedWiseModel.getTotal_loco_count());		
				//obj.setCleansed_count(DashBoardLocoCountShedWiseModel.getcleansed_count());
				//obj.setDraft_forward_approval_count(DashBoardLocoCountShedWiseModel.getDraft_forward_approval_count());
				//obj.setUncleansed_count(DashBoardLocoCountShedWiseModel.getuncleansed_count());
				//obj.setPending_approval(DashBoardLocoCountShedWiseModel.getpending_approval());
				list.add(obj);
				
				}
				
				public List<DashboardStationModel> getLocoCountZoneWiseprivate(DashboardStationModel obj1zone_code) {
					String loco_owning_zone_code =obj1zone_code.getLoco_owning_zone_code();
					
					List<DashboardStationModel> list= new ArrayList<DashboardStationModel>();		
					Collection<DashBoardLocoCountShedWiseModel> totalpvtCountLists= loco_tbl_fois_repo.getLocoZoneShedprivate(loco_owning_zone_code);
						logger.info("Service : DashBoardStationService || Method: getLocoZoneShed || getLocoZoneShedprivate Query list return : "+totalpvtCountLists);
						if(totalpvtCountLists.size()>0) {
							totalpvtCountLists.forEach(DashBoardLocoCountShedWiseModel -> setTotalZoneShedpvt(DashBoardLocoCountShedWiseModel,list));
//						totalCountLists.forEach(DashBoardLocoCountShedWiseModel -> callTotalfoisLocoZoneShed(DashBoardLocoCountShedWiseModel,list)); 

					}	
						
						Collection<DashBoardLocoCountShedWiseModel> uncleansedpvtCountLists= loco_tbl_fois_repo.getUncleansedLocoZoneShedprivate(loco_owning_zone_code);
						logger.info("Service : DashBoardStationService || Method: getUncleansedLocoZoneShedprivate || getUncleansedLocoZoneShedprivate Query list return : "+uncleansedpvtCountLists.size());

						uncleansedpvtCountLists.forEach(DashBoardLocoCountShedWiseModel -> callUncleansedLocoZoneShedpvt(DashBoardLocoCountShedWiseModel,list));
						
						
							
						Collection<DashBoardLocoCountShedWiseModel> pendingpvtApprovalCountLists= loco_tbl_repo.getLocoPendingZoneshedprivate(loco_owning_zone_code);
						logger.info("Service : DashBoardStationService || Method: getpvtLocoPendingZoneshed || getpvtLocoPendingZoneshed Query list return : "+pendingpvtApprovalCountLists.size());
				
						pendingpvtApprovalCountLists.forEach(DashBoardLocoCountShedWiseModel -> callLocoPendingZoneshedpvt(DashBoardLocoCountShedWiseModel,list));

				
						
						Collection<DashBoardLocoCountShedWiseModel> cleansedpvtCountLists= loco_tbl_approve.getLocoApprovedZoneShedprivate(loco_owning_zone_code);
						logger.info("Service : DashBoardStationService || Method: getLocoApprovedZoneShed || getLocoApprovedZoneShed Query list return : "+cleansedpvtCountLists.size());			
						cleansedpvtCountLists.forEach(DashBoardLocoCountShedWiseModel -> callApprovedZoneShedpvt(DashBoardLocoCountShedWiseModel,list));			
					
						
						Collection<DashBoardLocoCountShedWiseModel> draftpvtCountLists= loco_tbl_repo.getDraftLocoApprovalZoneshedprivate(loco_owning_zone_code);
						logger.info("Service : DashBoardStationService || Method: getDraftLocoApprovalZoneshedprivate || getDraftLocoApprovalZoneshedprivate Query list return : "+draftpvtCountLists.size());			
						draftpvtCountLists.forEach(DashBoardLocoCountShedWiseModel -> callDraftLocoApprovalZonepvt(DashBoardLocoCountShedWiseModel,list));	
										
						
						return list;
					
				}
					//end changes
				
				private void callTotalfoisLocoZoneShedpvt(DashBoardLocoCountShedWiseModel uncleansedObj,Collection< DashboardStationModel>list) {
					// TODO Auto-generated method stub
					try {		
						uncleansedFlag=0;
						list.forEach(totalobj -> callTotalLocoSubShedwise1pvt(uncleansedObj,totalobj));	
						if(uncleansedFlag==0){
							DashboardStationModel obj = new DashboardStationModel();
							obj.setLoco_owning_zone_code(uncleansedObj.getLoco_owning_zone_code());	
							obj.setLoco_owning_shed_code(uncleansedObj.getLoco_owning_shed_code());
							obj.setUncleansed_count(uncleansedObj.getuncleansed_count());
					//		list.add(obj);	
						}
							}catch (Exception e) {
						// TODO: Handle Exception
						e.getMessage();		}
				}
				private void callTotalLocoSubShedwise1pvt(DashBoardLocoCountShedWiseModel uncleansedObj,DashboardStationModel totalobj) {
					
					try {
					if(uncleansedObj.getLoco_owning_shed_code().equalsIgnoreCase(totalobj.getLoco_owning_shed_code())) {
						uncleansedFlag++;
						totalobj.setUncleansed_count(uncleansedObj.getuncleansed_count());
					}
					}catch (Exception e) {
						// TODO: handle exception
						e.getMessage();
					}
				}
				
				
				
				
				private void callUncleansedLocoZoneShedpvt(DashBoardLocoCountShedWiseModel uncleansedObj,Collection< DashboardStationModel>list) {
					// TODO Auto-generated method stub
					try {		
						uncleansedFlag=0;
						list.forEach(totalobj -> callTotalSubShedwise1pvt(uncleansedObj,totalobj));	
						if(uncleansedFlag==0){
							DashboardStationModel obj = new DashboardStationModel();
							obj.setLoco_owning_zone_code(uncleansedObj.getLoco_owning_zone_code());	
							obj.setLoco_Owningshed(uncleansedObj.getLoco_Owningshed());
							obj.setUncleansed_count(uncleansedObj.getuncleansed_count());
					//		list.add(obj);	
						}
							}catch (Exception e) {
						// TODO: Handle Exception
						e.getMessage();		}
				}
				private void callTotalSubShedwise1pvt(DashBoardLocoCountShedWiseModel uncleansedObj,DashboardStationModel totalobj) {
					
					try {
					if(uncleansedObj.getLoco_Owningshed().equalsIgnoreCase(totalobj.getLoco_Owningshed())) {
						uncleansedFlag++;
						totalobj.setUncleansed_count(uncleansedObj.getuncleansed_count());
					}
					}catch (Exception e) {
						// TODO: handle exception
						e.getMessage();
					}
				}
				

				
				private void callLocoPendingZoneshedpvt(DashBoardLocoCountShedWiseModel pendingApprovObj,Collection< DashboardStationModel>list) {
					// TODO Auto-generated method stub
					try {
					
						uncleansedFlag=0;
						list.forEach(totalobj -> callPendingApprovalSubShedwise1pvt(pendingApprovObj,totalobj));	
						if(uncleansedFlag==0) {
							DashboardStationModel obj = new DashboardStationModel();
							obj.setLoco_owning_zone_code(pendingApprovObj.getLoco_owning_zone_code());					
							obj.setLoco_Owningshed(pendingApprovObj.getLoco_Owningshed());
							obj.setPending_approval(pendingApprovObj.getpending_approval());
					//		list.add(obj);	
						}
					}catch (Exception e) {
						// TODO: handle exception
						e.getMessage();
					}
					
				}
				private void callPendingApprovalSubShedwise1pvt(DashBoardLocoCountShedWiseModel pendingApprovObj,DashboardStationModel totalobj) {
					
					try {
					if(pendingApprovObj.getLoco_Owningshed().equalsIgnoreCase(totalobj.getLoco_Owningshed())) {
						uncleansedFlag++;
						totalobj.setPending_approval(pendingApprovObj.getpending_approval());		
				
					}
					}catch (Exception e) {
						// TODO: handle exception
						e.getMessage();
					}
				}
				
				
				private void callApprovedZoneShedpvt(DashBoardLocoCountShedWiseModel cleansedObj,Collection< DashboardStationModel>list) {
					// TODO Auto-generated method stub
					
					try {
						uncleansedFlag=0;
						list.forEach(totalobj -> callCleansedCountSubShedwise1pvt(cleansedObj,totalobj));

				
						if(uncleansedFlag==0) {
							DashboardStationModel obj = new DashboardStationModel();
						    obj.setLoco_owning_zone_code(cleansedObj.getLoco_owning_zone_code());
							obj.setLoco_Owningshed(cleansedObj.getLoco_Owningshed());
							obj.setCleansed_count(cleansedObj.getcleansed_count());
						//	list.add(obj);		
						}
					}catch (Exception e) {
						// TODO: handle exception
						e.getMessage();
					}
					
				}
				private void callCleansedCountSubShedwise1pvt(DashBoardLocoCountShedWiseModel cleansedObj,DashboardStationModel totalobj) {
					try {
					if(cleansedObj.getLoco_Owningshed().equalsIgnoreCase(totalobj.getLoco_Owningshed())){
						uncleansedFlag++;
						totalobj.setCleansed_count(cleansedObj.getcleansed_count());	
					}
					}catch (Exception e) {
						// TODO: handle exception
						e.getMessage();
					}
				}
				
				private void callDraftLocoApprovalZonepvt(DashBoardLocoCountShedWiseModel draftObj,Collection< DashboardStationModel>list) {
					// TODO Auto-generated method stub
					
					try {
						uncleansedFlag=0;
						list.forEach(totalobj -> callDraftCountShedwise1pvt(draftObj,totalobj));

				
						if(uncleansedFlag==0) {
							DashboardStationModel obj = new DashboardStationModel();
          				// obj.setZone_code(draftObj.getzone_code());
							obj.setLoco_owning_zone_code(draftObj.getLoco_owning_zone_code());
							obj.setLoco_Owningshed(draftObj.getLoco_Owningshed());
//							obj.setElec_locoOwningShed(draftObj.getelec_locoOwningShed());
							obj.setDraft_forward_approval_count(draftObj.getDraft_forward_approval_count());
						//	list.add(obj);		
						}
					}catch (Exception e) {
						// TODO: handle exception
						e.getMessage();
					}
					
				}
				private void callDraftCountShedwise1pvt(DashBoardLocoCountShedWiseModel draftObj,DashboardStationModel totalobj) {
					try {
					if(draftObj.getLoco_Owningshed().equalsIgnoreCase(totalobj.getLoco_Owningshed())){
						uncleansedFlag++;
						totalobj.setDraft_forward_approval_count(draftObj.getDraft_forward_approval_count());	
				//		System.out.println("draft add in list divcode"+ totalobj.getshedid()+"|| AND Draft count: "+totalobj.getDraft_forward_approval_count());
					}
					}catch (Exception e) {
						// TODO: handle exception
						e.getMessage();
					}
				}
				
				
				private void setTotalZoneShedpvt(DashBoardLocoCountShedWiseModel DashBoardLocoCountShedWiseModel,Collection<DashboardStationModel> list) {
				DashboardStationModel obj =new DashboardStationModel();	
         		//obj.setLoco_owning_zone_code(DashBoardStationCountDivisionWiseModel.getLoco_owning_zone_code());	
				obj.setLoco_owning_zone_code(DashBoardLocoCountShedWiseModel.getLoco_owning_zone_code());
				obj.setLoco_Owningshed(DashBoardLocoCountShedWiseModel.getLoco_Owningshed());
//				obj.setLoco_owning_shed_code(DashBoardLocoCountShedWiseModel.getLoco_owning_shed_code());
				obj.setTotal_loco_count(DashBoardLocoCountShedWiseModel.getTotal_loco_count());		
				//obj.setCleansed_count(DashBoardLocoCountShedWiseModel.getcleansed_count());
				//obj.setDraft_forward_approval_count(DashBoardLocoCountShedWiseModel.getDraft_forward_approval_count());
				//obj.setUncleansed_count(DashBoardLocoCountShedWiseModel.getuncleansed_count());
				//obj.setPending_approval(DashBoardLocoCountShedWiseModel.getpending_approval());
				list.add(obj);
				
				}
								

public List<ZonalUserReportModel> getSingleZoneWiseUsers(UserProfileRegistrationDetailModel obj1) {
					
					logger.info("Service : StationDashboardService || Method: getSingleZoneWiseUsers");
					String utype=obj1.getUser_type();
					String zone=obj1.getZone();
			final String noofusers="select a.division_name, r1.division, r1.count  from  mdms_masters.m_division a join \r\n"
					+ "			(select division,count(*) as count from mdms_app_mgmt.user_profile_registration_detail where user_type='"+utype+"'"
							+ " and  zone='"+zone+"' group by division) r1 on r1.division=a.division_code";					
				   return jdbcTemplate.query(
						   noofusers,
			               (rs, rowNum) ->
			                       new ZonalUserReportModel(
			                               rs.getString("division"),
			                               rs.getInt("count"),
			                               rs.getString("division_name")
			                              
			                       )
			       );
				}
	

public List<ZonalUserReportModel> getSingleLocoZoneWiseUsers(UserProfileRegistrationDetailModel obj1) {
	
	logger.info("Service : StationDashboardService || Method: getSingleLocoZoneWiseUsers");
	String utype=obj1.getUser_type();
	String zone=obj1.getZone();
final String noofusers="select a.shed_code, r1.shed, r1.count  from  mdms_loco.m_loco_shed a join \r\n"
		+ "		(select shed,count(*) as count from mdms_app_mgmt.user_profile_registration_detail where user_type='"+utype+"'"
			+ " and  zone='"+zone+"' group by shed) r1 on r1.shed=a.shed_code";					
   return jdbcTemplate.query(
		   noofusers,
           (rs, rowNum) ->
                   new ZonalUserReportModel(
                           rs.getString("shed"),
                           rs.getInt("count"),
                           rs.getString("shed_code")
                          
                   )
   );
}
	


public List<ZonalUserReportModel> getSingleCoachZoneWiseUsers(UserProfileRegistrationDetailModel obj1) {
	
	logger.info("Service : StationDashboardService || Method: getSingleLocoZoneWiseUsers");
	String utype=obj1.getUser_type();
	String zone=obj1.getZone();
final String noofusers="select a.depo_name, r1.depo, r1.count  from  mdms_coach.m_depo a join \r\n"
		+ "		(select depo,count(*) as count from mdms_app_mgmt.user_profile_registration_detail where user_type='"+utype+"'"
			+ " and  zone='"+zone+"' group by depo) r1 on r1.depo=a.depo_name";					
   return jdbcTemplate.query(
		   noofusers,
           (rs, rowNum) ->
                   new ZonalUserReportModel(
                           rs.getString("division"),
                           rs.getInt("count"),
                           rs.getString("division_name")
                          
                   )
   );
}


//Shilpi 19-04-2021  Coach zone



public List<DashboardStationModel> getCoachCountZoneDepotWise(DashboardStationModel objcoachid) {
	String owning_rly =objcoachid.getOwning_rly();	
	List<DashboardStationModel> list= new ArrayList<DashboardStationModel>();		
	Collection<DashBoardCoachCountDepoWiseModel> totalCountLists= coach_cmm_repo.getCoachZoneDepo(owning_rly);
		logger.info("Service : DashBoardStationService || Method: getCoachZoneDepo || getCoachZoneDepo Query list return : "+totalCountLists);
		if(totalCountLists.size()>0) {
		totalCountLists.forEach(DashBoardCoachCountDepoWiseModel -> setTotalZonedepotwise(DashBoardCoachCountDepoWiseModel,list));

	}	
		
		Collection<DashBoardCoachCountDepoWiseModel> uncleansedCountLists= coach_cmm_repo.getUncleansedCoachZoneDepo(owning_rly);
		logger.info("Service : DashBoardStationService || Method: getUncleansedCoachZoneDepo || getUncleansedCoachZoneDepo Query list return : "+uncleansedCountLists.size());

		uncleansedCountLists.forEach(DashBoardCoachCountDepoWiseModel -> callTotalZonedepot(DashBoardCoachCountDepoWiseModel,list));
		
		
			
		Collection<DashBoardCoachCountDepoWiseModel> pendingApprovalCountLists= coach_unclean_repo.getCoachPendingZonedepo(owning_rly);
		logger.info("Service : DashBoardStationService || Method: getCoachPendingZonedepo || getCoachPendingZonedepo Query list return : "+pendingApprovalCountLists.size());

		pendingApprovalCountLists.forEach(DashBoardCoachCountDepoWiseModel -> callPendingApprovalZonedepot(DashBoardCoachCountDepoWiseModel,list));


		
		Collection<DashBoardCoachCountDepoWiseModel> cleansedCountLists= coach_clean_repo.getCoachApprovedZonalDepo(owning_rly);
		logger.info("Service : DashBoardStationService || Method: getCoachApprovedZonalDepo || getCoachApprovedZonalDepo Query list return : "+cleansedCountLists.size());			
		cleansedCountLists.forEach(DashBoardCoachCountDepoWiseModel -> callCleansedCountZonedepot(DashBoardCoachCountDepoWiseModel,list));			
	
		
		Collection<DashBoardCoachCountDepoWiseModel> draftCountLists= coach_unclean_repo.getDraftCoachApprovalZonedepo(owning_rly);
		logger.info("Service : DashBoardStationService || Method: getDraftCoachApprovalZonedepo || getDraftCoachApprovalZonedepo Query draftlist return : "+draftCountLists.size());			
		draftCountLists.forEach(DashBoardCoachCountDepoWiseModel -> callDraftCountZonedepot(DashBoardCoachCountDepoWiseModel,list));	
		
		
		
		
		
		return list;
	
}
	//end changes

private void callTotalZonedepot(DashBoardCoachCountDepoWiseModel uncleansedObj,Collection< DashboardStationModel>list) {
	// TODO Auto-generated method stub
	try {		
		uncleansedFlag=0;
		list.forEach(totalobj -> callTotalSubZonedepot(uncleansedObj,totalobj));	
		if(uncleansedFlag==0){
			DashboardStationModel obj = new DashboardStationModel();
//			obj.setZone_code(uncleansedObj.getzone_code());
			obj.setOwning_rly(uncleansedObj.getOwning_rly());
			obj.setUncleansed_count(uncleansedObj.getuncleansed_count());
	//		list.add(obj);	
		}
			}catch (Exception e) {
		// TODO: Handle Exception
		e.getMessage();		}
}
private void callTotalSubZonedepot(DashBoardCoachCountDepoWiseModel uncleansedObj,DashboardStationModel totalobj) {
	
	try {
	if(uncleansedObj.getOwning_depot().equalsIgnoreCase(totalobj.getOwning_depot())) {
		uncleansedFlag++;
		totalobj.setUncleansed_count(uncleansedObj.getuncleansed_count());
	}
	}catch (Exception e) {
		// TODO: handle exception
		e.getMessage();
	}
}



private void callPendingApprovalZonedepot(DashBoardCoachCountDepoWiseModel pendingApprovObj,Collection< DashboardStationModel>list) {
	// TODO Auto-generated method stub
	try {
	
		uncleansedFlag=0;
		list.forEach(totalobj -> callPendingApprovalSubZonedepot(pendingApprovObj,totalobj));	
		if(uncleansedFlag==0) {
			DashboardStationModel obj = new DashboardStationModel();
//			obj.setZone_code(pendingApprovObj.getzone_code());					
			obj.setOwning_rly(pendingApprovObj.getOwning_rly());
			obj.setPending_approval(pendingApprovObj.getpending_approval());
	//		list.add(obj);	
		}
	}catch (Exception e) {
		// TODO: handle exception
		e.getMessage();
	}
	
}
private void callPendingApprovalSubZonedepot(DashBoardCoachCountDepoWiseModel pendingApprovObj,DashboardStationModel totalobj) {
	
	try {
	if(pendingApprovObj.getOwning_depot().equalsIgnoreCase(totalobj.getOwning_depot())) {
		uncleansedFlag++;
		totalobj.setPending_approval(pendingApprovObj.getpending_approval());		

	}
	}catch (Exception e) {
		// TODO: handle exception
		e.getMessage();
	}
}


private void callCleansedCountZonedepot(DashBoardCoachCountDepoWiseModel cleansedObj,Collection< DashboardStationModel>list) {
	// TODO Auto-generated method stub
	
	try {
		uncleansedFlag=0;
		list.forEach(totalobj -> callCleansedCountSubZonedepot(cleansedObj,totalobj));


		if(uncleansedFlag==0) {
			DashboardStationModel obj = new DashboardStationModel();
//			obj.setZone_code(cleansedObj.getzone_code());
			obj.setOwning_rly(cleansedObj.getOwning_rly());
			obj.setCleansed_count(cleansedObj.getcleansed_count());
		//	list.add(obj);		
		}
	}catch (Exception e) {
		// TODO: handle exception
		e.getMessage();
	}
	
}
private void callCleansedCountSubZonedepot(DashBoardCoachCountDepoWiseModel cleansedObj,DashboardStationModel totalobj) {
	try {
	if(cleansedObj.getOwning_depot().equalsIgnoreCase(totalobj.getOwning_depot())){
		uncleansedFlag++;
		totalobj.setCleansed_count(cleansedObj.getcleansed_count());	
	}
	}catch (Exception e) {
		// TODO: handle exception
		e.getMessage();
	}
}

private void callDraftCountZonedepot(DashBoardCoachCountDepoWiseModel draftObj,Collection< DashboardStationModel>list) {
	// TODO Auto-generated method stub
	
	try {
		uncleansedFlag=0;
		list.forEach(totalobj -> callDraftCountZonedepot(draftObj,totalobj));
		if(uncleansedFlag==0) {
			DashboardStationModel obj = new DashboardStationModel();
//			obj.setZone_code(draftObj.getzone_code());
			obj.setOwning_rly(draftObj.getOwning_rly());
//			obj.setElec_locoOwningShed(draftObj.getelec_locoOwningShed());
			obj.setDraft_forward_approval_count(draftObj.getdraft_forward_approval_count());
	list.add(obj);		
		}
	}catch (Exception e) {
		// TODO: handle exception
		e.getMessage();
	}
	
}
private void callDraftCountZonedepot(DashBoardCoachCountDepoWiseModel draftObj,DashboardStationModel totalobj) {
	try {
	if(draftObj.getOwning_depot().equalsIgnoreCase(totalobj.getOwning_depot())){
		uncleansedFlag++;
		totalobj.setDraft_forward_approval_count(draftObj.getdraft_forward_approval_count());
		System.out.println("Total Draft"+draftObj.getdraft_forward_approval_count());
	//System.out.println("draft add in list divcode"+ totalobj.getowning_rly()+"|| AND Draft count: "+totalobj.getDraft_forward_approval_count());
	}

	}catch (Exception e) {
		// TODO: handle exception
		e.getMessage();
	}
}


private void setTotalZonedepotwise(DashBoardCoachCountDepoWiseModel DashBoardCoachCountDepoWiseModel,Collection<DashboardStationModel> list) {
DashboardStationModel obj =new DashboardStationModel();	
//obj.setZone_code(DashBoardStationCountDivisionWiseModel.getzone_code());

;
obj.setOwning_rly(DashBoardCoachCountDepoWiseModel.getOwning_rly());
obj.setOwning_depot(DashBoardCoachCountDepoWiseModel.getOwning_depot());
obj.setTotal_depo_count(DashBoardCoachCountDepoWiseModel.getTotal_depo_count());			
list.add(obj);

}

			

public List<DashBoardCoachCountDepoWiseModel> geCoachMapCount( DashBoardCoachCountDepoWiseModel obj ) {
	System.out.println("getUncleanstnHyperDivision");					
	 coach_map_repo.getCoachmapcount();
	List<DashBoardCoachCountDepoWiseModel> temp= new ArrayList<>();
	 coach_map_repo.getCoachmapcount()
	.forEach(temp::add);
	System.out.println(" End getuncleansedpending");
	return temp;
}


public List<GetLocoZonewiseDashboardJsonModel> getLocoZonewiseReport() {
	logger.info("Service : StationDashboardService || Method: getSingleLocoZoneWiseUsers");
//	String utype=obj1.getUser_type();
//	String zone=obj1.getZone();
	String querystring=null;
	
	final String noofusers="select * from mdms_loco.f_loco_dashboard_report_zonewise()"; 					
   return jdbcTemplate.query(
		   noofusers,
           (rs, rowNum) ->
                   new GetLocoZonewiseDashboardJsonModel(
                           rs.getString("loco_owningzone"),
                           rs.getInt("tot_count"),
                           rs.getInt("unclen"),
                           rs.getInt("dft"),
                           rs.getInt("pend"),
                           rs.getInt("appv")
                           
                          
                   )
   );
}


public List<GetLocoZonewiseDashboardJsonModel> getloco() {
	logger.info("Service : StationDashboardService || Method: getloco");

Map<String, Integer> map = new HashMap<>();
	 
try {
	 final String noOfStations = "select * from mdms_loco.f_loco_dashboard_report_zonewise()";
	  List<GetLocoZonewiseDashboardJsonModel> ls= jdbcTemplate.queryForObject(noOfStations,List.class);
	  System.out.println(ls.toString());
	  return ls;
}
catch(Exception e) {
logger.error("Service : StationDashboardService || Method: getDivisionWiseStationStats|| Exception : " +e.getMessage());
e.getMessage();
return null;
}
}


public List<StationHomeDashboard> getStationCountHome(String div_code){
	
	int divno=	divsn_repo.getDivsionCode(div_code);
	List<StationHomeDashboard> temp1=new ArrayList<>();
	StationHomeDashboard temp=new StationHomeDashboard();
	
	
	temp.setTotal(station_repo.getTotal(divno));
	temp.setUncleansed(station_repo.getuncleansed(divno,div_code));
	temp.setUncleansed_cmi(station_repo.getuncleansedCMI(divno, div_code));
	temp.setUncleansed_dti(station_repo.getuncleansedDTI(divno, div_code));
	temp.setDraft_dti(station_repo.getdraftdti(div_code));
	temp.setDrfat_cmi(station_repo.getdraftcmi(div_code));
	temp.setPending_cmi(station_repo.getpendingcmi(div_code));
	temp.setPending_dti(station_repo.getpendingdti(div_code));
	temp.setReject_cmi(station_repo.getrejectcmi(div_code));
	temp.setReject_dti(station_repo.getrejectdti(div_code));
	temp.setNot_initiated(station_repo.getuncleansednotinitiated(divno, div_code));
	temp.setNt_ini_cmi(station_repo.getnotinitiatedcmi(div_code));
	temp.setNt_ini_dti(station_repo.getnotinitiateddti(div_code));
	temp.setCleansed(station_repo.getcleansed(div_code));
	temp.setClean_cmi(station_repo.getcleansedcmi(div_code));
	temp.setClean_dti(station_repo.getcleanseddti(div_code));
	
	temp1.add(temp);

	return temp1;

}
}





















