package com.mdms.loco.locouncleansed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="m_loco_shed_new",schema="mdms_loco")

public class MLocoShedNew {

		
		@Column(name="shed_code")
		private String shedCode;
		
		@Id
		@Column(name="sno")
		private int sno;
		
		@Column(name="shed_name")
		private String shedName;
		

		@Column(name="zone_code")
		private String zoneCode;

		@Column(name="shed_flag")
		private String shedflag;
		
		@Column(name="division_code")
		private String divisionCode;
		
		@Column(name="serving_station")
		private String serving_station;
		
		@Column(name="shed_type")
		private String shed_type;
		
		
		

		public int getSno() {
			return sno;
		}

		public void setSno(int sno) {
			this.sno = sno;
		}

		public String getShedCode() {
			return shedCode;
		}

		public void setShedCode(String shedCode) {
			this.shedCode = shedCode;
		}

		public String getShedName() {
			return shedName;
		}

		public void setShedName(String shedName) {
			this.shedName = shedName;
		}

		public String getZoneCode() {
			return zoneCode;
		}

		public void setZoneCode(String zoneCode) {
			this.zoneCode = zoneCode;
		}

		public String getShedflag() {
			return shedflag;
		}

		public void setShedflag(String shedflag) {
			this.shedflag = shedflag;
		}

	

		public String getDivisionCode() {
			return divisionCode;
		}

		public void setDivisionCode(String divisionCode) {
			this.divisionCode = divisionCode;
		}

		public String getServing_station() {
			return serving_station;
		}

		public void setServing_station(String serving_station) {
			this.serving_station = serving_station;
		}

		public String getShed_type() {
			return shed_type;
		}

		public void setShed_type(String shed_type) {
			this.shed_type = shed_type;
		}
		
		
}
