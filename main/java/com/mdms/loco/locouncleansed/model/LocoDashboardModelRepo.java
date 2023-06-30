package com.mdms.loco.locouncleansed.model;

import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import com.mdms.dahsboard.model.GetLocoZonewiseDashboardJsonModel;

public interface LocoDashboardModelRepo {
	// Developer- Ritu dt. 26.06.23	
		@Procedure(value="mdms_loco.f_loco_dashboard_report_zonewise")
		List<Object[]>  getLocozonewisereport();
	
	
}
