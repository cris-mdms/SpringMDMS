package com.mdms.wagon.wagonuncleansed.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="irwms_wagon_type_mapping_with_fmm", schema="mdms_wagon")
public class IRWMS_Wagon_Type_Mapping_with_Fmm {
	@Id
	@Column(name="s_no")
	private BigInteger s_no;
	
	
	@Column(name="irwms_wagon_type")
	private String irwms_wagon_type;
	
	@Column(name="fmm_wagon_type")
	private String fmm_wagon_type;
	
	@Column(name="suggested_irwms_group_name")
	private String suggested_irwms_group_name;
	
	@Column(name="remarks")
	private String remarks;

	public BigInteger getS_no() {
		return s_no;
	}

	public void setS_no(BigInteger s_no) {
		this.s_no = s_no;
	}

	public String getIrwms_wagon_type() {
		return irwms_wagon_type;
	}

	public void setIrwms_wagon_type(String irwms_wagon_type) {
		this.irwms_wagon_type = irwms_wagon_type;
	}

	public String getFmm_wagon_type() {
		return fmm_wagon_type;
	}

	public void setFmm_wagon_type(String fmm_wagon_type) {
		this.fmm_wagon_type = fmm_wagon_type;
	}

	public String getSuggested_irwms_group_name() {
		return suggested_irwms_group_name;
	}

	public void setSuggested_irwms_group_name(String suggested_irwms_group_name) {
		this.suggested_irwms_group_name = suggested_irwms_group_name;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
}
