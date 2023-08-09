package com.mdms.dashboard.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.mdms.dahsboard.model.DailyIntegrationModel;
import com.mdms.dahsboard.model.LocoDataSlamModel;
import com.mdms.dashboard.repository.LocoDataSlamRepo;
import com.mdms.loco.locouncleansed.model.LocoDataSlam;
import com.mdms.mdms_station.stationuncleansed.model.StationTableRbs;

@Service
public class LocoDataSlamService {
	 Logger logger=LoggerFactory.getLogger(LocoDataSlamService.class);	 
	 @Autowired
	 LocoDataSlamRepo obj_repo;

	 @Autowired
		private JdbcTemplate jdbcTemplate;
	 public List<LocoDataSlamModel> getslamlocoonly(){		
		 List<LocoDataSlamModel> tmp = new ArrayList<>();
		 obj_repo.getlocoonlyinslam().forEach(tmp::add);		
		    return tmp;
			 	 
		 }
	 
//	 public List<LocoDataSlamModel> getmdmslocoonly(){		
//		 List<LocoDataSlamModel> tmp = new ArrayList<>();
//		 obj_repo.getlocoonlyinmdms().forEach(tmp::add);		
//		    return tmp;
//			 	 
//		 }
	 
	 
	 
	 public List<LocoDataSlam> getmdmslocoonly() {
			
			logger.info("Service : LocoDataSlamService || Method: getmdmslocoonly");			 
			  
		final String noofusers=" select  loco_no, loco_owning_zone, loco_owning_shed, loco_type, status ,loco_flag\r\n"
				+ "from  mdms_loco.loco_approved_data where loco_no in (\r\n"
				+ "select  distinct loco_no  from  mdms_loco.loco_approved_data\r\n"
				+ "where loco_flag='E' and status<>'CN' and loco_owning_shed in (\r\n"
				+ "select  distinct loco_owning_shed  from mdms_analysis.loco_data_slam_250723)\r\n"
				+ "except\r\n"
				+ "select  loco_no  from mdms_analysis.loco_data_slam_250723\r\n"
				+ "where locostatus<>'Condemned')";

		return jdbcTemplate.query(
				noofusers,
		          (rs, rowNum) ->
		                  new LocoDataSlam(
		                		  rs.getInt("loco_no") ,
		                		  rs.getString("loco_owning_zone"),
		                		  rs.getString("loco_owning_shed"),
		                          rs.getString("loco_type"),
		                          rs.getString("status"),
		                          rs.getString("loco_flag")  
		                         ));
		}
	 
	 public List<LocoDataSlam> getshedcodemismatche() {
		 logger.info("Service : LocoDataSlamService || Method: getshedcodemismatche");	
		 final String noofusers="select  a.loco_no, a.loco_owning_shed as loco_owning_shed ,b.loco_owning_shed as loco_owning_sheds from mdms_loco.loco_approved_data as a,mdms_analysis.loco_data_slam_250723 as b"
		 		+ " where a.loco_flag='E' and a.status<>'CN' and a.loco_owning_shed in (select  distinct loco_owning_shed  from mdms_analysis.loco_data_slam_250723)"
		 		+ "	 and  a.loco_no=b.loco_no and b.locostatus<>'Condemned' and a.loco_owning_shed<>b.loco_owning_shed order by 1";	 
		 return jdbcTemplate.query(
					noofusers,
			          (rs, rowNum) ->
			                  new LocoDataSlam(
			                		  rs.getInt("loco_no") ,			                		  
			                		  rs.getString("loco_owning_shed"),
			                		  rs.getString("loco_owning_sheds")
			                         ));
}
	 
	 
	 // same  above function using for this query, so loco type will come in owning shed code column .. otherwise we have to create a new model for this only.. 
	 public List<LocoDataSlam> gettypemismatche() {
		 logger.info("Service : LocoDataSlamService || Method: gettypemismatche");	
		 final String noofusers="select  a.loco_no, a.loco_type as loco_owning_shed ,b.loco_type as loco_owning_sheds from mdms_loco.loco_approved_data as a,mdms_analysis.loco_data_slam_250723 as b"
		 		+ "	 where a.loco_flag='E' and a.status<>'CN' and a.loco_owning_shed in (select  distinct loco_owning_shed  from mdms_analysis.loco_data_slam_250723)"
		 		+ "	 and  a.loco_no=b.loco_no and b.locostatus<>'Condemned'	 and a.loco_type <>b.loco_type order by 1";
		 return jdbcTemplate.query(
					noofusers,
			          (rs, rowNum) ->
			                  new LocoDataSlam(
			                		  rs.getInt("loco_no") ,			                		  
			                		  rs.getString("loco_owning_shed"),
			                		  rs.getString("loco_owning_sheds")
			                         ));
	 }
}
