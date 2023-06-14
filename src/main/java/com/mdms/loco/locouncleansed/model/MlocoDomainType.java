package com.mdms.loco.locouncleansed.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="m_loco_domain_type", schema="mdms_loco")
public class MlocoDomainType {
	
	@Id()
	private String domain_type;
	public MlocoDomainType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MlocoDomainType(String domain_type, String domain_type_name) {
		super();
		this.domain_type = domain_type;
		this.domain_type_name = domain_type_name;
	}
	public String getDomain_type() {
		return domain_type;
	}
	public void setDomain_type(String domain_type) {
		this.domain_type = domain_type;
	}
	public String getDomain_type_name() {
		return domain_type_name;
	}
	public void setDomain_type_name(String domain_type_name) {
		this.domain_type_name = domain_type_name;
	}
	private String domain_type_name;

}
