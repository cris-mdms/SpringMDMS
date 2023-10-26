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
import com.mdms.loco.locouncleansed.model.LocoDataSlamJson;
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
	 
	 public List<LocoDataSlamModel> getlocoonlyinslam_exceptAllMdms(){		
		 List<LocoDataSlamModel> tmp = new ArrayList<>();
		 obj_repo.getlocoonlyinslam_exceptAllMdms().forEach(tmp::add);		
		    return tmp;
			 	 
		 }
	 
	 
//	 public List<LocoDataSlamModel> getmdmslocoonly(){		
//		 List<LocoDataSlamModel> tmp = new ArrayList<>();
//		 obj_repo.getlocoonlyinmdms().forEach(tmp::add);		
//		    return tmp;
//			 	 
//		 }
	 
	 
	 
	 public List<LocoDataSlamJson> getmdmslocoonly() {
			
			logger.info("Service : LocoDataSlamService || Method: getmdmslocoonly");			 
			  
		final String noofusers="select  loco_no, loco_owning_zone, loco_owning_shed, loco_type, status ,loco_flag\r\n"
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
		                  new LocoDataSlamJson(
		                		  rs.getInt("loco_no") ,
		                		  rs.getString("loco_owning_zone"),
		                		  rs.getString("loco_owning_shed"),
		                          rs.getString("loco_type"),
		                          rs.getString("status"),
		                          rs.getString("loco_flag")  
		                         ));
		}
	 
	 public List<LocoDataSlamJson> getshedcodemismatche() {
		 logger.info("Service : LocoDataSlamService || Method: getshedcodemismatche");	
		 final String noofusers="select  a.loco_no, a.loco_owning_shed as loco_owning_shed ,b.loco_owning_shed as loco_owning_sheds from mdms_loco.loco_approved_data as a,mdms_analysis.loco_data_slam_250723 as b"
		 		+ " where a.loco_flag='E' and a.status<>'CN' and a.loco_owning_shed in (select  distinct loco_owning_shed  from mdms_analysis.loco_data_slam_250723)"
		 		+ "	 and  a.loco_no=b.loco_no and b.locostatus<>'Condemned' and a.loco_owning_shed<>b.loco_owning_shed order by 1";	 
		 return jdbcTemplate.query(
					noofusers,
			          (rs, rowNum) ->
			                  new LocoDataSlamJson(
			                		  rs.getInt("loco_no") ,			                		  
			                		  rs.getString("loco_owning_shed"),
			                		  rs.getString("loco_owning_sheds")
			                         ));
}
	 
	 
	 // same  above function using for this query, so loco type will come in owning shed code column .. otherwise we have to create a new model for this only.. 
	 public List<LocoDataSlamJson> gettypemismatche() {
		 logger.info("Service : LocoDataSlamService || Method: gettypemismatche");	
		 final String noofusers="select  a.loco_no, a.loco_type as loco_owning_shed ,b.loco_type as loco_owning_sheds from mdms_loco.loco_approved_data as a,mdms_analysis.loco_data_slam_250723 as b"
		 		+ "	 where a.loco_flag='E' and a.status<>'CN' and a.loco_owning_shed in (select  distinct loco_owning_shed  from mdms_analysis.loco_data_slam_250723)"
		 		+ "	 and  a.loco_no=b.loco_no and b.locostatus<>'Condemned'	 and a.loco_type <>b.loco_type order by 1";
		 return jdbcTemplate.query(
					noofusers,
			          (rs, rowNum) ->
			                  new LocoDataSlamJson(
			                		  rs.getInt("loco_no") ,			                		  
			                		  rs.getString("loco_owning_shed"),
			                		  rs.getString("loco_owning_sheds")
			                         ));
	 }
	 
	 
	 public List<LocoDataSlamJson> getalltypemismatche() {
		 
		 logger.info("Service : LocoDataSlamService || Method: getalltypemismatche");	
		 final String noofusers="select a.loco_no, (case when a.loco_no=b.loco_no then b.loco_type else a.loco_type end ) as loco_type,loco_types\r\n"
		 		+ "from(\r\n"
		 		+ "select c.loco_no ,c.loco_type,b.loco_type as loco_types \r\n"
		 		+ "from\r\n"
		 		+ "mdms_analysis.loco_data_slam_250723 as b,\r\n"
		 		+ "mdms_loco.loco_data_fois as c where b.loco_no=c.loco_no and b.loco_no in (\r\n"
		 		+ "select distinct a.loco_no \r\n"
		 		+ "from mdms_loco.loco_approved_data as a,mdms_analysis.loco_data_slam_250723 as b\r\n"
		 		+ "where  loco_flag='E' and  status<>'CN' and  a.loco_owning_shed in (\r\n"
		 		+ "select  distinct loco_owning_shed  from mdms_analysis.loco_data_slam_250723)\r\n"
		 		+ "and  a.loco_no=b.loco_no and b.locostatus<>'Condemned'  \r\n"
		 		+ "and a.loco_type<>b.loco_type\r\n"
		 		+ "union\r\n"
		 		+ "select distinct a.loco_no \r\n"
		 		+ "from mdms_loco.loco_data_fois as a,mdms_analysis.loco_data_slam_250723 as b\r\n"
		 		+ "where a.loco_traction_code='E'  and  a.loco_owning_shed_code in (\r\n"
		 		+ "select  distinct loco_owning_shed  from mdms_analysis.loco_data_slam_250723)\r\n"
		 		+ "and  a.loco_no=b.loco_no and b.locostatus<>'Condemned'  \r\n"
		 		+ "and a.loco_type<>b.loco_type)) as a left join mdms_loco.loco_approved_data as b\r\n"
		 		+ "on a.loco_no=b.loco_no\r\n"
		 		+ "order by 2";	  
		 			 return jdbcTemplate.query(
							noofusers,
					          (rs, rowNum) ->
					                  new LocoDataSlamJson(
					                		  rs.getInt("loco_no") ,			                		  
//					                		  rs.getString("loco_owning_shed"),
					                		  rs.getString("loco_type"),
					                		  rs.getString("loco_types")
					                         ));
}
	 public List<LocoDataSlamJson> getallshedmismatched()
	 {
	 logger.info("Service : LocoDataSlamService || Method: getallshedmismatched");	
	 final String noofusers=" select a.loco_no, (case when a.loco_no=b.loco_no then b.loco_owning_shed else a.loco_owning_shed_code end ) as loco_owning_shed,loco_owning_sheds\r\n"
	 		+ "	 from(\r\n"
	 		+ "	 select c.loco_no ,c.loco_owning_shed_code,b.loco_owning_shed as loco_owning_sheds  \r\n"
	 		+ "	 from\r\n"
	 		+ "	 mdms_analysis.loco_data_slam_250723 as b,\r\n"
	 		+ "	 mdms_loco.loco_data_fois as c where b.loco_no=c.loco_no and b.loco_no in (\r\n"
	 		+ "	 select distinct a.loco_no --- ,a.loco_type,b.loco_type\r\n"
	 		+ "	 from mdms_loco.loco_approved_data as a,mdms_analysis.loco_data_slam_250723 as b\r\n"
	 		+ "	 where  loco_flag='E' and  status<>'CN' and  a.loco_owning_shed in (\r\n"
	 		+ "	 select  distinct loco_owning_shed  from mdms_analysis.loco_data_slam_250723)\r\n"
	 		+ "	 and  a.loco_no=b.loco_no and b.locostatus<>'Condemned'  \r\n"
	 		+ "	 and a.loco_owning_shed<>b.loco_owning_shed\r\n"
	 		+ "	 union\r\n"
	 		+ "	 select distinct a.loco_no --- ,a.loco_type,b.loco_type\r\n"
	 		+ "	 from mdms_loco.loco_data_fois as a,mdms_analysis.loco_data_slam_250723 as b\r\n"
	 		+ "	 where a.loco_traction_code='E'  and  a.loco_owning_shed_code in (\r\n"
	 		+ "	 select  distinct loco_owning_shed  from mdms_analysis.loco_data_slam_250723)\r\n"
	 		+ "	 and  a.loco_no=b.loco_no and b.locostatus<>'Condemned'  \r\n"
	 		+ "	 and a.loco_owning_shed_code<>b.loco_owning_shed)) as a left join mdms_loco.loco_approved_data as b\r\n"
	 		+ "	 on a.loco_no=b.loco_no\r\n"
	 		+ "	 order by 2";
	 
	 return jdbcTemplate.query(
		noofusers,
          (rs, rowNum) ->
                  new LocoDataSlamJson(
                		  rs.getInt("loco_no") ,			                		  
               		  rs.getString("loco_owning_shed"),
                		  rs.getString("loco_owning_sheds")
                		
                         ));
	 
}
	 public List<LocoDataSlamJson> getallmdmslocono_notinslam(){
		 logger.info("Service :LocoDataSlamService || Method : getallmdmslocono_notinslam");
	 final String totallococount ="select loco_no, loco_owning_zone_code as loco_owning_zone, loco_owning_shed_code as loco_owning_shed,loco_type, status,loco_traction_code as loco_flag"
	 		+ "		from  mdms_loco.loco_data_fois where loco_no in (select  distinct loco_no  from  mdms_loco.loco_data_fois"
	 		+ "		where loco_traction_code='E' and status<>'CN' and loco_owning_shed_code in"
	 		+ " (select  distinct loco_owning_shed  from mdms_analysis.loco_data_slam_250723)) union select loco_no, loco_owning_zone, loco_owning_shed, loco_type, status ,loco_flag	from  mdms_loco.loco_approved_data where loco_no in ("
	 		+ "	select  distinct loco_no  from  mdms_loco.loco_approved_data where loco_flag='E' and status<>'CN' and loco_owning_shed in ("
	 		+ "	select  distinct loco_owning_shed  from mdms_analysis.loco_data_slam_250723)"
	 		+ "	except	select  loco_no  from mdms_analysis.loco_data_slam_250723 where locostatus<>'Condemned')";
		 return jdbcTemplate.query(
				 totallococount,
			          (rs, rowNum) ->
			                  new LocoDataSlamJson(
			                		  rs.getInt("loco_no") ,			                		  
			               		  rs.getString("loco_owning_zone"),
			                		  rs.getString("loco_owning_shed"),
			                		  rs.getString("loco_type"),
			                		  rs.getString("status"),
			                		  rs.getString("loco_flag")
			                		
			                         ));
	 }
}
