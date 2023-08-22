package com.mdms.dashboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.dahsboard.model.LocoDataSlamModel; 

public interface LocoDataSlamRepo  extends CrudRepository<LocoDataSlamModel,String>{
	@Query(value="select  loco_no, loco_owning_zone, loco_owning_division,loco_owning_shed, loco_type, loco_traction_code,locostatus\r\n"
			+ "from mdms_analysis.loco_data_slam_250723 where loco_no in (\r\n"
			+ "select  distinct loco_no  from mdms_analysis.loco_data_slam_250723\r\n"
			+ "where locostatus<>'Condemned'\r\n"
			+ "EXCEPT\r\n"
			+ "( select  distinct loco_no\r\n"
			+ "from  mdms_loco.loco_approved_data\r\n"
			+ "where  status<>'CN'\r\n"
//			+ "UNION\r\n"
//			+ "select  distinct loco_no\r\n"
//			+ "from  mdms_loco.loco_data_fois\r\n"
		+ ")\r\n"
		+ ")\r\n"
			+ "order by 2,4,5",nativeQuery=true)
				List<LocoDataSlamModel> getlocoonlyinslam();


	@Query(value="select  loco_no, loco_owning_zone, loco_owning_division,loco_owning_shed, loco_type, loco_traction_code,locostatus\r\n"
			+ "from mdms_analysis.loco_data_slam_250723 where loco_no in (\r\n"
			+ "select  distinct loco_no  from mdms_analysis.loco_data_slam_250723\r\n"
			+ "where locostatus<>'Condemned'\r\n"
			+ "EXCEPT\r\n"
			+ "( select  distinct loco_no\r\n"
			+ "from  mdms_loco.loco_approved_data\r\n"
			+ "where  status<>'CN'\r\n"
			+ "UNION\r\n"
			+ "select  distinct loco_no\r\n"
			+ "from  mdms_loco.loco_data_fois\r\n"
			+ ")\r\n"
			+ ")\r\n"
			+ "order by 2,4,5",nativeQuery=true)
				List<LocoDataSlamModel> getlocoonlyinslam_exceptAllMdms();

	


}
//loco_no , loco_owning_zone , loco_owning_division,loco_owning_shed , loco_type , loco_traction_code ,locostatus