package com.mdms.loco.locouncleansed.model;

public class LocoDataSlam {
	
	public Integer loco_no;
	public String loco_owning_zone;
	public String loco_owning_shed; 
	public String loco_type;
	public 	String status;
	public 	String loco_flag;
	public String loco_owning_sheds; 
//	public String loco_types;


public LocoDataSlam(Integer loco_no, String loco_owning_zone, String loco_owning_shed, String loco_type, String status, String loco_flag)
{
this.loco_no=loco_no;
this.loco_owning_zone=loco_owning_zone;
this.loco_owning_shed=loco_owning_shed;
this.loco_type=loco_type;
this.status=status;
this.loco_flag=loco_flag;
}

public LocoDataSlam(Integer loco_no,  String loco_owning_shed , String loco_owning_sheds)
{
this.loco_no=loco_no;
this.loco_owning_sheds=loco_owning_sheds;
this.loco_owning_shed=loco_owning_shed;
}


}
