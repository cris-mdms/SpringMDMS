package com.mdms.dashboard.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mdms.app.mgmt.repository.UserProfileRegistrationRepository;
import com.mdms.dahsboard.model.DailyIntegrationModel;
import com.mdms.dahsboard.model.DivisonUsersAssetModel;
import com.mdms.dahsboard.model.RbUserCount;
import com.mdms.dahsboard.model.ZonalUsersAssetModel;
import com.mdms.dashboard.repository.StationDashboardRepo;
import com.mdms.mdms_station.stationuncleansed.repository.StationTableRbsRepository;

@Service
public class SuperUserDashboardService {
	 Logger logger=LoggerFactory.getLogger(SuperUserDashboardService.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	StationTableRbsRepository stn_db_repo;
	
	@Autowired
	UserProfileRegistrationRepository user_repo;
	
	public HashMap<String, Integer> getTotalAssets() {
		logger.info("Service : SuperUserDashboardService || Method: getTotalAssets");

 HashMap<String, Integer> map = new HashMap<>();

		 
 try {
//	 final String no_stations = "SELECT count(a.stn_code) FROM mdms_station.station_table_rbs as a where current_date between stn_vld_from and stn_vld_upto";
	 final String no_stations = "SELECT r1.zone_code, count(DISTINCT r1.stn_code) AS total FROM ( SELECT a.zone_code,b.stn_code FROM (mdms_masters.m_division a"
	 		+ " JOIN mdms_station.station_table_rbs b ON ((a.division_sr_no = (b.div_ser_no)::numeric))) WHERE ((CURRENT_DATE >= b.stn_vld_from) AND (CURRENT_DATE <= b.stn_vld_upto))) r1 	  GROUP BY r1.zone_code";
//		 final String no_stations = "SELECT count(DISTINCT stn_code) FROM mdms_station.station_table_rbs ";
		    final int total_stations = (int)jdbcTemplate.queryForObject(no_stations,Integer.class);

		    final String no_loco = "SELECT count(*) FROM mdms_loco.loco_data_fois loco_status is null";
		    final int total_loco = (int)jdbcTemplate.queryForObject(no_loco,Integer.class);
		    final String no_coach = "select count( coach_no) from mdms_coach.coach_data_cmm where coach_status<>'CONDEMN'";
		    final int total_coach = (int)jdbcTemplate.queryForObject(no_coach,Integer.class);
//		    final String no_wagon = "SELECT count(*) FROM mdms_station.station_table_rbs";
//		    final int total_wagon = (int)jdbcTemplate.queryForObject(no_wagon,Integer.class);


		    map.put("total_stations", total_stations);
		    map.put("total_loco", total_loco);
		    map.put("total_coach", total_coach);
//		    map.put("total_wagon", total_wagon);
		    return map;
	}
	  catch(Exception e) {
	    	logger.error("Service : SuperUserDashboardService || Method: getTotalAssets|| Exception : " +e.getMessage());
			e.getMessage();
			return null;
	    }
	}
	
	
	
	
	public HashMap<String, Integer> getCleansedAssets() {
		logger.info("Service : SuperUserDashboardService || Method: getCleansedAssets");

 HashMap<String, Integer> map = new HashMap<>();

		 
 try {
		 final String no_stations = "SELECT count(*) FROM mdms_station.station_cleansed_data ";
		    final int total_stations = (int)jdbcTemplate.queryForObject(no_stations,Integer.class);

		    final String no_loco = "SELECT count(*) FROM mdms_loco.loco_approved_data";
		    final int total_loco = (int)jdbcTemplate.queryForObject(no_loco,Integer.class);
		    final String no_coach = "SELECT count(*) FROM mdms_coach.coach_cleansed_data";
		    final int total_coach = (int)jdbcTemplate.queryForObject(no_coach,Integer.class);
//		    final String no_wagon = "SELECT count(*) FROM mdms_station.station_table_rbs";
//		    final int total_wagon = (int)jdbcTemplate.queryForObject(no_wagon,Integer.class);
		    map.put("total_stations", total_stations);
		    map.put("total_loco", total_loco);
		    map.put("total_coach", total_coach);
//		    map.put("total_wagon", total_wagon);
		    return map;
	}
	  catch(Exception e) {
	    	logger.error("Service : SuperUserDashboardService || Method: getCleansedAssets|| Exception : " +e.getMessage());
			e.getMessage();
			return null;
	    }
	}
	
	
	
	public  List<RbUserCount> getRegisteredUserCount1() {
		logger.info("Service : SuperUserDashboardService || Method: getRegisteredUserCount");
		
		 List<RbUserCount> temp=new ArrayList<RbUserCount>();
		 RbUserCount tempuser1=new RbUserCount();
		 RbUserCount tempuser2=new RbUserCount();
		 RbUserCount tempuser3=new RbUserCount();
 HashMap<String, Integer> map = new HashMap<>();
		 
 try {
		 final String stationusers = "SELECT count(*) FROM mdms_app_mgmt.user_profile_registration_detail where user_type='SU' ";
		    final int total_stationusers = (int)jdbcTemplate.queryForObject(stationusers,Integer.class);
		    final String locousers = "SELECT count(*) FROM mdms_app_mgmt.user_profile_registration_detail where user_type='LU'";
		    final int total_locousers = (int)jdbcTemplate.queryForObject(locousers,Integer.class);
		    final String coachusers = "SELECT count(*) FROM mdms_app_mgmt.user_profile_registration_detail where user_type='CU'";
		    final int total_coachusers = (int)jdbcTemplate.queryForObject(coachusers,Integer.class);


		    map.put("total_stationusers", total_stationusers);
		    map.put("total_locousers", total_locousers);
		    map.put("total_coachusers", total_coachusers);
		    tempuser1.setEntity("Station");
		    tempuser1.setCount(total_stationusers);
		    temp.add(tempuser1);
		    tempuser2.setEntity("Loco");
		    tempuser2.setCount(total_locousers);
		    temp.add(tempuser2);
		    tempuser3.setEntity("Coach");
		    tempuser3.setCount(total_coachusers);
		    temp.add(tempuser3);
		    
		    return temp;
		    
	}
	  catch(Exception e) {
	    	logger.error("Service : SuperUserDashboardService || Method: getRegisteredUserCount|| Exception : " +e.getMessage());
			e.getMessage();
			return null;
	    }
	}
	
	public  ArrayList<HashMap<String,String>>getRegisteredUserCount() {
		logger.info("Service : SuperUserDashboardService || Method: getRegisteredUserCount");
		
		ArrayList<HashMap<String,String>> userlist= new ArrayList<HashMap<String,String>>();

		 
 try {
		 final String stationusers = "SELECT count(*) FROM mdms_app_mgmt.user_profile_registration_detail where user_type='SU' ";
		    final int total_stationusers = (int)jdbcTemplate.queryForObject(stationusers,Integer.class);
		    final String locousers = "SELECT count(*) FROM mdms_app_mgmt.user_profile_registration_detail where user_type='LU'";
		    final int total_locousers = (int)jdbcTemplate.queryForObject(locousers,Integer.class);
		    final String coachusers = "SELECT count(*) FROM mdms_app_mgmt.user_profile_registration_detail where user_type='CU'";
		    final int total_coachusers = (int)jdbcTemplate.queryForObject(coachusers,Integer.class);
		    
		    String[] entity = new String[]{ "Station","Loco","Coach"};
		    String[] count=new String[3];
		    
		    count[0]=Integer.toString(total_stationusers);
		    count[1]=Integer.toString(total_locousers);
		    count[2]=Integer.toString(total_coachusers);
		    
		    for(int i=0;i<3;i++)
		    { HashMap<String, String> map1 = new HashMap<>();
		    map1.put("entity",entity[i] );
		    map1.put("count",count[i] );
		    userlist.add(map1)  ;
		    	
		    }
		     
		    return userlist;
		    
	}
	  catch(Exception e) {
	    	logger.error("Service : SuperUserDashboardService || Method: getRegisteredUserCount|| Exception : " +e.getMessage());
			e.getMessage();
			return null;
	    }
	}
	
	public 	ArrayList<HashMap<String,String>> getAssetRecords() {
		logger.info("Service : StationDashboardService || Method: getAssetRecords");
		ArrayList<HashMap<String,String>> assetlist= new ArrayList<HashMap<String,String>>();
		
		String[] entity = new String[]{ "Station","Loco","Coach"}; 
		String[] total=new String[3];
		String[] cleansed=new String[3];
		String[] draft=new String[3];
		String[] pending=new String[3];
		

		 
 try {
		 final String noOfStations = "SELECT count(*) FROM mdms_station.station_table_rbs";
		 final int totalStations = (int)jdbcTemplate.queryForObject(noOfStations,Integer.class);
		 final String cleansedStations = "select count(*) from mdms_station.station_cleansed_data";
		 final int noOfCleansedStations = (int)jdbcTemplate.queryForObject(cleansedStations, Integer.class);
		 final String draftstation = "select count(*) from mdms_station.station_uncleansed_data where cmi_status='D' OR dti_status='D'";
		 final int nodraftstation = (int)jdbcTemplate.queryForObject(draftstation, Integer.class);
		 final String unapprovedStations = "select count(*) from mdms_station.station_uncleansed_data where cmi_status='U' OR dti_status='U'";
		 final int waitingForApprovalS = (int)jdbcTemplate.queryForObject(unapprovedStations,Integer.class);
		  total[0]=Integer.toString(totalStations);
		  cleansed[0]=Integer.toString(noOfCleansedStations);
		 draft[0]=Integer.toString(nodraftstation);
		  pending[0]=Integer.toString(waitingForApprovalS);
		 
		 
//		 ........................................Loco..................
		  
		  
		  
		  final String noOfLoco = "select count(*) from mdms_loco.loco_data_fois where status is null";
			 final int totalloco = (int)jdbcTemplate.queryForObject(noOfLoco,Integer.class);
			 final String cleansedloco = "select count(*) from mdms_loco.loco_approved_data where record_status='O'";
			 final int noOfCleansedLoco = (int)jdbcTemplate.queryForObject(cleansedloco, Integer.class);
			 final String draftloco = "select count(*) from mdms_loco.loco_uncleansed_data where status='D' and record_status='O'";
			 final int noDraftloco = (int)jdbcTemplate.queryForObject(draftloco, Integer.class);
			 final String unapprovedloco = "select count(*) from mdms_loco.loco_uncleansed_data where status='U' and record_status='O'";
			 final int waitingForApprovalL = (int)jdbcTemplate.queryForObject(unapprovedloco,Integer.class);
			  total[1]=Integer.toString(totalloco);
			  cleansed[1]=Integer.toString(noOfCleansedLoco);
			 draft[1]=Integer.toString(noDraftloco);
			  pending[1]=Integer.toString(waitingForApprovalL);
		  
		  
			  
				 
//				 ........................................Coach..................
				  
				  
				  
				  final String noOfCoach = "select count(*) from mdms_coach.coach_data_cmm;";
					 final int totalcoach = (int)jdbcTemplate.queryForObject(noOfCoach,Integer.class);
					 final String cleansedcoach = "select count(*) FROM mdms_coach.coach_cleansed_data;";
					 final int noOfCleansedcoach = (int)jdbcTemplate.queryForObject(cleansedcoach, Integer.class);
					 final String draftcoach = "select count(*) from mdms_coach.coach_uncleansed_data where record_status='O' and status='D'";
					 final int noDraftcoach = (int)jdbcTemplate.queryForObject(draftcoach, Integer.class);
					 final String unapprovedcoach = "select count(*) from mdms_coach.coach_uncleansed_data where record_status='O' and status='U'";
					 final int waitingForApprovalC = (int)jdbcTemplate.queryForObject(unapprovedcoach,Integer.class);
					  total[2]=Integer.toString(totalcoach);
					  cleansed[2]=Integer.toString(noOfCleansedcoach);
					 draft[2]=Integer.toString(noDraftcoach);
					  pending[2]=Integer.toString(waitingForApprovalC);
			  
			
					  for(int i=0;i<3;i++)
					  {
						  HashMap<String, String> map1 = new HashMap<>();
						  map1.put("entity",entity[i]) ;
							map1.put("total",total[i]);
							map1.put("cleansed",cleansed[i]);
							map1.put("draft",draft[i]);
							map1.put("pending",pending[i]);
							assetlist.add(map1);
						  
					  }
					  
	
		    return assetlist;
	}
	  catch(Exception e) {
	    	logger.error("Service : StationDashboardService || Method: getAssetRecords|| Exception : " +e.getMessage());
			e.getMessage();
			return null;
	    }
	}

	
	public List<ZonalUsersAssetModel> getZoneWiseUsers(String usertype) {
		
		logger.info("Service : StationDashboardService || Method: getZoneWiseUsers");
		 
//	  final String noofusers ="select zone,count(*) as count from mdms_app_mgmt.user_profile_registration_detail where user_type='"+usertype+"' group by zone";
	  
final String noofusers="select a.zone_name, r1.zone, r1.count  from  mdms_masters.m_zone a join \r\n"
		+ "	(select zone,count(*) as count from mdms_app_mgmt.user_profile_registration_detail where user_type='"+usertype+"'"
				+ " group by zone) r1 on r1.zone=a.zone_code order by zone_code";
    	    	  
    	  
//		stn_db_repo.getZoneWiseUsers().forEach(totalCountList::add);
		

	   return jdbcTemplate.query(
			   noofusers,
               (rs, rowNum) ->
                       new ZonalUsersAssetModel(
                               rs.getString("zone"),
                               rs.getInt("count"),
                               rs.getString("zone_name")
                              
                       )
       );
	}
	
public List<ZonalUsersAssetModel> getZoneWiseUsersfordashboarwithoutlogin(String usertype) {
		
		logger.info("Service : StationDashboardService || Method: getZoneWiseUsersfordashboarwithoutlogin");
		  
final String noofuser="select a.zone_name, a.zone_code, COALESCE(r1.count,0)  from  mdms_masters.m_zone a left join \r\n" + 
		"	(select zone,count(*) as count from mdms_app_mgmt.user_profile_registration_detail \r\n" + 
		"	 where user_type='"+usertype+"'group by zone) r1 on r1.zone=a.zone_code \r\n" + 
		"			 where a.fois_zone is not null order by zone_code";
    	    	  
    	  


	   return jdbcTemplate.query(
			   noofuser,
               (rs, rowNum) ->
                       new ZonalUsersAssetModel(
                               rs.getString("zone_name"),
                               rs.getInt("coalesce"),
                               rs.getString("zone_code")
                               
                              
                       )
       );
	}

	

	
	public List<ZonalUsersAssetModel> getZoneWiseRecords(String usertype) {
		
		logger.info("Service : StationDashboardService || Method: getZoneWiseRecords");
		
		String querystring=null;
		
		switch(usertype)
		{
		case "SU":querystring="select a.zone_code , a.total , b.zone_name , b.cleansed , c.draft , d.pending from public.total_data a"
				+ " 			left outer join public.cleansed_data b on a.zone_code=b.zone_code"
				+ "			left outer join public.draft c on a.zone_code=c.zone_code"
				+ "			left outer join public.uncleansed d on a.zone_code=d.zone_code order by zone_code";
		    	    	  
			break;
		
		
		case "LU":querystring="select a.zone_code , a.total , b.zone_name , b.cleansed , c.draft , d.pending from public.total_data_loco a"
				+ " 			left outer join public.cleansed_data_loco b on a.zone_code=b.zone_code"
				+ "			left outer join public.draft_data_loco c on a.zone_code=c.zone_code"
				+ "			left outer join public.pending_data_loco d on a.zone_code=d.zone_code order by zone_code";
		    	    	  
			
	        break;
		case "CU":querystring="  Select a.zone_code , a.total , b.zone_name , b.cleansed , c.draft , d.pending from public.total_data_coach a"
				+ " 			left outer join public.cleansed_data_coach b on a.zone_code=b.zone_code"
				+ "			left outer join public.draft_data_coach c on a.zone_code=c.zone_code"
				+ "			left outer join public.pending_data_coach d on a.zone_code=d.zone_code order by zone_code";
		    	    	  
		    break;

		default:break;
		}
		 
		  return jdbcTemplate.query(
				   querystring,
	               (rs, rowNum) ->
	                       new ZonalUsersAssetModel(
	                               rs.getString("zone_code"),
	                               rs.getInt("total"),
	                               rs.getString("zone_name"),
	                               rs.getInt("cleansed"),
	                               rs.getInt("draft"),
	                               rs.getInt("pending")
	     
	                              
	                       )   );
	}
	
	
		
	public List<DivisonUsersAssetModel> getDivisionWiseRecords(String usertype,String zone) {
		logger.info("Service : StationDashboardService || Method: getDivisionWiseRecords");
		final String userdetails="select b.last_login_date,a.division ,a.depo,shed, a.user_id ,a.name , a.designation , a.department,a.from_date, a.role_type from mdms_app_mgmt.user_profile_registration_detail a\r\n"
				+ "	join mdms_app_mgmt.user_login_detail b on a.user_id=b.user_id where user_type='"+usertype+"' and zone='"+zone+"' order by division";	 
		 return jdbcTemplate.query(
				 userdetails,
	               (rs, rowNum) ->
	                       new DivisonUsersAssetModel(
	                               rs.getString("division"),
	                               rs.getString("depo"),
	                               rs.getString("shed"),
	                               rs.getString("user_id"),
	                               rs.getString("name"),
	                               rs.getString("designation"),
	                               rs.getString("department"),
	                               rs.getDate("from_date"),
	                               rs.getDate("last_login_date"),
	                               rs.getString("role_type")
  
	                       )   );

	}
	
	public List<DivisonUsersAssetModel> getDivisionWiseRecords1(String usertype,String division, String role) {
		logger.info("Service : StationDashboardService || Method: getDivisionWiseRecords");
		final String userdetails="select b.last_login_date,a.division ,a.depo,shed, a.user_id ,a.name , a.designation , a.department,a.from_date, a.role_type from mdms_app_mgmt.user_profile_registration_detail a\r\n"
				+ "	join mdms_app_mgmt.user_login_detail b on a.user_id=b.user_id where user_type='"+usertype+"' and a.division='"+division+"' and a.role_type='"+role+"' order by division";	 
		 return jdbcTemplate.query(
				 userdetails,
	               (rs, rowNum) ->
	                       new DivisonUsersAssetModel(
	                               rs.getString("division"),
	                               rs.getString("depo"),
	                               rs.getString("shed"),
	                               rs.getString("user_id"),
	                               rs.getString("name"),
	                               rs.getString("designation"),
	                               rs.getString("department"),
	                               rs.getDate("from_date"),
	                               rs.getDate("last_login_date"),
	                               rs.getString("role_type")
  
	                       )   );

	}

	

	public 	ArrayList<HashMap<String,String>> getCoachAssetRecords() {
		logger.info("Service : StationDashboardService || Method: getCoachAssetRecords");
		ArrayList<HashMap<String,String>> coachassetlist= new ArrayList<HashMap<String,String>>();		
		String[] entitymapping = new String[]{ "MappedCoach"}; 
		//For test to commit as mappedcoach
		String[] totalmapping=new String[1];
	String[] totalcoachtypereserved= new String[2];
	String[] totalmappingPercentagedone=new String[3];
		 
 try {
					 
//				 ........................................Coach.mapping...26-04-2021..............
				  
				  
				  
				  final String noOfCoach = "SELECT count(distinct cmm_coach_type) FROM mdms_coach.coach_type_mapping";
					 final int totalcoach = (int)jdbcTemplate.queryForObject(noOfCoach,Integer.class);
   				    final String totalcoachtypereserved1 = "SELECT count(distinct coach_type) from  mdms_coach.m_coach_type_cmm where reserved_flag ='Y'";
   				    final int totalcoachtype=(int)jdbcTemplate.queryForObject(totalcoachtypereserved1,Integer.class);
//					 final int noOfCleansedcoach = (int)jdbcTemplate.queryForObject(cleansedcoach, Integer.class);
//					 final String draftcoach = "select count(*) from mdms_coach.coach_uncleansed_data where record_status='O' and status='D'";
//					 final int noDraftcoach = (int)jdbcTemplate.queryForObject(draftcoach, Integer.class);
//					 final String unapprovedcoach = "select count(*) from mdms_coach.coach_uncleansed_data where record_status='O' and status='U'";
//					 final int waitingForApprovalC = (int)jdbcTemplate.queryForObject(unapprovedcoach,Integer.class);
					 totalmapping[0]=Integer.toString(totalcoach);
					 totalcoachtypereserved[0]=Integer.toString(totalcoachtype);
						 final   float proportionCorrectmapping = (float) ((totalcoach * 100.0) / totalcoachtype);
						 totalmappingPercentagedone[0]=Integer.toString((int) proportionCorrectmapping) + "%";
//					  cleansed[2]=Integer.toString(noOfCleansedcoach);
//					 draft[2]=Integer.toString(noDraftcoach);
//					  pending[2]=Integer.toString(waitingForApprovalC);
			  
			
					  for(int i=0;i<1;i++)
					  {
						  HashMap<String, String> map1 = new HashMap<>();
						  map1.put("entity",entitymapping[i]) ;
							map1.put("totalmapping",totalmapping[i]);
							map1.put("totalcoachtypereserved",totalcoachtypereserved[i]);
							map1.put("totalmappingPercentagedone", totalmappingPercentagedone[i]);
//							map1.put("draft",draft[i]);
//							map1.put("pending",pending[i]);
							coachassetlist.add(map1);
						  
					  }
					  
	
		    return coachassetlist;
	}
	  catch(Exception e) {
	    	logger.error("Service : StationDashboardService || Method: getCoachAssetRecords|| Exception : " +e.getMessage());
			e.getMessage();
			return null;
	    }
	}

// Shilpi 26-04-2021
	
	public 	ArrayList<HashMap<String,String>> getCoachLayoutRecords() {
		logger.info("Service : StationDashboardService || Method: getCoachLayoutRecords");

		ArrayList<HashMap<String,String>> coachlayoutlist= new ArrayList<HashMap<String,String>>();
		
		String[] entityLayout = new String[]{ "CoachLayout"}; 
		String[] totallayout=new String[1];
		String[] totalseatingcoachlayout1=new String[2];
		String[] totalseatingcoachlayoutnotmapped1=new String[3];
		String[] totalphysicalcoachlayoutnotmapped1=new String[4];
		String[] totalseatingPercentagedone=new String[5];
	String[] totalphysicalPercentagedone=new String[6];
	try {
		 
//		 ........................................Coach.layout...26-04-2021..............
		  
		  
		  
		  final String noOfCoachlayout = "SELECT count(*) FROM mdms_coach.cmm_type_layout";  // total physical layout done
			 final int totalcoachlayout = (int)jdbcTemplate.queryForObject(noOfCoachlayout,Integer.class);
			 final String noOfseatingCoachlayout = "SELECT count(*) from  mdms_coach.prs_type_layout"; // total seating layout done
			 final int totalseatingcoachlayout = (int)jdbcTemplate.queryForObject(noOfseatingCoachlayout,Integer.class);
			 final String noOftotalseatingCoachlayout = "SELECT count(*) from  mdms_coach.m_coach_type_cmm";
			 final int totalseatingcoachlayoutnotmapped = (int)jdbcTemplate.queryForObject(noOftotalseatingCoachlayout,Integer.class);// total seating Layout
			 final String noOftotalphysicalCoachlayout = "SELECT count(distinct coach_code ) from  mdms_coach.m_coach_type_prs";
			 final int totalphysicalcoachlayoutnotmapped = (int)jdbcTemplate.queryForObject(noOftotalphysicalCoachlayout,Integer.class);// total Physical Layout

          final  float physicalpercentage = (float)( (totalcoachlayout *100.0) / totalseatingcoachlayoutnotmapped);    
          
        final   float proportionCorrect = (float) ((totalseatingcoachlayout * 100.0) / totalphysicalcoachlayoutnotmapped);
			
        totallayout[0]=Integer.toString(totalcoachlayout);
			 totalseatingcoachlayout1[0]=Integer.toString(totalseatingcoachlayout);
			 totalseatingcoachlayoutnotmapped1[0]=Integer.toString(totalseatingcoachlayoutnotmapped);
			 totalphysicalcoachlayoutnotmapped1[0]=Integer.toString(totalphysicalcoachlayoutnotmapped);
			 totalseatingPercentagedone[0]=Integer.toString((int) proportionCorrect) + "%";
			 totalphysicalPercentagedone[0]=Integer.toString((int) physicalpercentage) + "%";
				
	
			  for(int i=0;i<1;i++)
			  {
				  HashMap<String, String> map2 = new HashMap<>();
				  map2.put("entityLayout",entityLayout[i]) ;
					map2.put("totallayout",totallayout[i]);
					map2.put("totalseatingcoachlayout1",totalseatingcoachlayout1[i]);
					map2.put("totalseatingcoachlayoutnotmapped1",totalseatingcoachlayoutnotmapped1[i]);
					map2.put("totalphysicalcoachlayoutnotmapped1",totalphysicalcoachlayoutnotmapped1[i]);
					map2.put("totalseatingPercentagedone", totalseatingPercentagedone[i]);
					map2.put("totalphysicalPercentagedone", totalphysicalPercentagedone[i]);					
					coachlayoutlist.add(map2);
				  
			  }
			  

   return coachlayoutlist;
}
catch(Exception e) {
	logger.error("Service : StationDashboardService || Method: getCoachLayoutRecords|| Exception : " +e.getMessage());
	e.getMessage();
	return null;
}
}
	public List<DailyIntegrationModel> getdailypublishintegration() {

		logger.info("Service : StationDashboardService || Method: getdailypublishintegration");

		//  final String noofusers ="select zone,count(*) as count from mdms_app_mgmt.user_profile_registration_detail where user_type='"+usertype+"' group by zone";
		 
		final String noofusers="Select * from public.daily_integration_publishingdata";

		return jdbcTemplate.query(
		noofusers,
		          (rs, rowNum) ->
		                  new DailyIntegrationModel(
		                 rs.getString("entity_name"),
		                 rs.getString("group_name"),
		                          rs.getString("asset_name"),
		                          rs.getInt("c_count"),
		                         rs.getDate("publishing_date")
		                         ));
		}


		public List<DailyIntegrationModel> getdailysubscriptionintegration() {

		logger.info("Service : StationDashboardService || Method: getdailysubscriptionintegration");

		 
		final String noofusers="Select * from public.daily_integration_subscriptiondata";

		return jdbcTemplate.query(
		noofusers,
		          (rs, rowNum) ->
		                  new DailyIntegrationModel(
		                 rs.getString("entity_name"),
		                 rs.getString("group_name"),
		                          rs.getString("asset_name"),
		                          rs.getInt("c_count"),
		                         rs.getDate("publishing_date")
		                         ));
		}
	
	
	// jyoti bisht 9-5-23
	public int get_div_station(String div)
	{
		return stn_db_repo.get_division_station_count(div);
	}
	// jyoti bisht 10-5-23
	public List<Object[]> get_stations(String div)
	{
		return stn_db_repo.get_stations(div);
	}
	
	// jyoti bisht 10-5-23
		public int get_usercount_by_div(String div, String user_type, String role_type)
		{
			return user_repo.get_count_by_usertype(div,user_type, role_type);
		}
		
	
}
