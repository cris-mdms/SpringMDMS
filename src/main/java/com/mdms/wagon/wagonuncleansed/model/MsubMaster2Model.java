package com.mdms.wagon.wagonuncleansed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="m_wagon_class_group", schema="mdms_wagon")	
public class MsubMaster2Model {
	
	
	@Id
	@Column(name="wagon_class_group")
	private String wagon_class_group;
	private String description;
	private String wagon_class_id;
	
	
	public MsubMaster2Model() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MsubMaster2Model(String wagon_class_group, String description, String wagon_class_id) {
		super();
		this.wagon_class_group = wagon_class_group;
		this.description = description;
		this.wagon_class_id = wagon_class_id;
	}
	public String getWagon_class_group() {
		return wagon_class_group;
	}
	public void setWagon_class_group(String wagon_class_group) {
		this.wagon_class_group = wagon_class_group;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getWagon_class_id() {
		return wagon_class_id;
	}
	public void setWagon_class_id(String wagon_class_id) {
		this.wagon_class_id = wagon_class_id;
	}

}
