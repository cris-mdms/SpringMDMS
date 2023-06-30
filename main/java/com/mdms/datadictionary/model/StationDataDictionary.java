package com.mdms.datadictionary.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity()
@Table(name="station_attribute", schema="mdm_data_dictionary")
public class StationDataDictionary {
	
	@Id
	@Column(name="attribute_name")
	private String attribute;
	
	@Column(name="application_group")
	private String applicationGroup;
	
	
	
	@Column(name="description")
	private String description;
	
	@Column(name="data_type_mdms")
	private String dataTypeInMdms;
	
	@Column(name="example")
	private String example;
	
	@Column(name="status")
	private String status;
	
	@Column(name="constrains")
	private String constrains;
	
	@Column(name="asset_name")
	private String assetName;

	public StationDataDictionary(String applicationGroup, String attribute, String description, String dataTypeInMdms,
			String example, String status, String constrains, String assetName) {
		super();
		this.applicationGroup = applicationGroup;
		this.attribute = attribute;
		this.description = description;
		this.dataTypeInMdms = dataTypeInMdms;
		this.example = example;
		this.status = status;
		this.constrains = constrains;
		this.assetName = assetName;
	}

	public StationDataDictionary() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getApplicationGroup() {
		return applicationGroup;
	}

	public void setApplicationGroup(String applicationGroup) {
		this.applicationGroup = applicationGroup;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDataTypeInMdms() {
		return dataTypeInMdms;
	}

	public void setDataTypeInMdms(String dataTypeInMdms) {
		this.dataTypeInMdms = dataTypeInMdms;
	}

	public String getExample() {
		return example;
	}

	public void setExample(String example) {
		this.example = example;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getConstrains() {
		return constrains;
	}

	public void setConstrains(String constrains) {
		this.constrains = constrains;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	

}
