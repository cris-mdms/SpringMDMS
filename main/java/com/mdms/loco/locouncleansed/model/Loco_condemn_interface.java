package com.mdms.loco.locouncleansed.model;

import java.util.Date;

public interface Loco_condemn_interface {
	
	Integer getLoco_no();
	String getLoco_type();
	String getLoco_owning_shed_code();
	String getLoco_owning_zone_code();
	String getLoco_permanent_domain();
	String getTraction_code();
	Date getCondemnation_date();
	String getCondemnation_proposal_type();
	String getUser_id();
	String getStatus();
	String getThrough_interface();

}
