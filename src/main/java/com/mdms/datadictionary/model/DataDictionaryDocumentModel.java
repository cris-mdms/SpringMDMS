package com.mdms.datadictionary.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity()
public class DataDictionaryDocumentModel {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="s_no")	
	private Long s_no;
	
	@Column(name="asset_name")
	private String assetName;
	
	@Column(name="file_name")
	private String fileName;
	
	@Column(name="file_link")
	private String fileLink;
	
	@Column(name="display_name")
	private String displayName;

	public DataDictionaryDocumentModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DataDictionaryDocumentModel(Long s_no, String assetName, String fileName, String fileLink, String displayName) {
		super();
		this.s_no=s_no;
		this.assetName = assetName;
		this.fileName = fileName;
		this.fileLink = fileLink;
		this.displayName=displayName;
	}

	public Long getS_no() {
		return s_no;
	}

	public void setS_no(Long s_no) {
		this.s_no = s_no;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileLink() {
		return fileLink;
	}

	public void setFileLink(String fileLink) {
		this.fileLink = fileLink;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	

}
