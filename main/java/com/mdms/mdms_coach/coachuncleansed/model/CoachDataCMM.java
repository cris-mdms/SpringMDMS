/* Model class – CMM Coach Type Table
Developer – Anshul ,09/07/2020
*/

package com.mdms.mdms_coach.coachuncleansed.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="coach_data_cmm", schema="mdms_coach")
public class CoachDataCMM {
	
	@Column(name="coach_no")
	private String coach_no;
	
	@Id
	@Column(name="coach_id")
	private String coach_id;
	
	@Column(name="coach_type")
	private String coach_type;
	
	@Column(name="owning_rly")
	private String owning_rly;
	

	@Column(name="base_depot")
	private String base_depot;
	

	@Column(name="nominated_workshop")
	private String nominated_workshop;
	

	@Column(name="coach_category")
	private String coach_category;
	

	@Column(name="gauge")
	private String gauge;
	
	
	@Column(name="fitness_type")
	private String fitness_type;
	

	@Column(name="coupling_type")
	private String coupling_type;
	
	
	
@Column(name="brake_type")
private String brake_type;


@Column(name="power_generation_type")
private String power_generation_type;
	
	@Column(name="tare_weight")
	private String tare_weight;
	
	@Column(name="max_speed")
	private String max_speed;
	
	@Column(name="coach_age")
	private String coach_age;
	

	@Column(name="coach_status")
	private String coach_status;
	
	@Column(name="condemnation_date")
	private String condemnation_date;
	
	@Column(name="icms_coach_id")
	private String icms_coach_id;
	
	@Column(name="ac_flag")
	private String ac_flag;
	
	@Column(name="built_date")
	private String built_date;
	

	@Column(name="coach_commission_date")
	private String coach_commission_date;
	
	@Column(name="coach_received_date")
	private String coach_received_date;
	
	
	@Column(name="manufacturer")
	private String manufacturer;
	

	@Column(name="underframe_no")
	private String underframe_no;

	@Column(name="shell_no")
	private String shell_no;
	
	@Column(name="coach_auto_generated")
	private String coach_auto_generated;
	
	@Column(name="is_biotoilet_fitted")
	private String is_biotoilet_fitted;
	
	@Column(name="order_id")
	private String order_id;
	

	@Column(name="coach_owning_div")
	private String coach_owning_div;
	

	@Column(name="factory_turnout_date")
	private String factory_turnout_date;
	

	@Column(name="rfid_status")
	private String rfid_status;
	

	@Column(name="id")
	private Long Id;
	
	@Column(name="insert_or_update")
	private String insert_or_update;
	

	@Column(name="insert_or_update_date")
	private Date insert_or_update_date;
	
	
	@Column(name="added_by_import")
	private String added_by_import;


	public String getCoach_no() {
		return coach_no;
	}


	public void setCoach_no(String coach_no) {
		this.coach_no = coach_no;
	}


	public String getCoach_id() {
		return coach_id;
	}


	public void setCoach_id(String coach_id) {
		this.coach_id = coach_id;
	}


	public String getCoach_type() {
		return coach_type;
	}


	public void setCoach_type(String coach_type) {
		this.coach_type = coach_type;
	}


	public String getOwning_rly() {
		return owning_rly;
	}


	public void setOwning_rly(String owning_rly) {
		this.owning_rly = owning_rly;
	}


	public String getBase_depot() {
		return base_depot;
	}


	public void setBase_depot(String base_depot) {
		this.base_depot = base_depot;
	}


	public String getNominated_workshop() {
		return nominated_workshop;
	}


	public void setNominated_workshop(String nominated_workshop) {
		this.nominated_workshop = nominated_workshop;
	}


	public String getCoach_category() {
		return coach_category;
	}


	public void setCoach_category(String coach_category) {
		this.coach_category = coach_category;
	}


	public String getGauge() {
		return gauge;
	}


	public void setGauge(String gauge) {
		this.gauge = gauge;
	}


	public String getFitness_type() {
		return fitness_type;
	}


	public void setFitness_type(String fitness_type) {
		this.fitness_type = fitness_type;
	}


	public String getCoupling_type() {
		return coupling_type;
	}


	public void setCoupling_type(String coupling_type) {
		this.coupling_type = coupling_type;
	}


	public String getBrake_type() {
		return brake_type;
	}


	public void setBrake_type(String brake_type) {
		this.brake_type = brake_type;
	}


	public String getPower_generation_type() {
		return power_generation_type;
	}


	public void setPower_generation_type(String power_generation_type) {
		this.power_generation_type = power_generation_type;
	}


	public String getTare_weight() {
		return tare_weight;
	}


	public void setTare_weight(String tare_weight) {
		this.tare_weight = tare_weight;
	}


	public String getMax_speed() {
		return max_speed;
	}


	public void setMax_speed(String max_speed) {
		this.max_speed = max_speed;
	}


	public String getCoach_age() {
		return coach_age;
	}


	public void setCoach_age(String coach_age) {
		this.coach_age = coach_age;
	}


	public String getCoach_status() {
		return coach_status;
	}


	public void setCoach_status(String coach_status) {
		this.coach_status = coach_status;
	}


	public String getCondemnation_date() {
		return condemnation_date;
	}


	public void setCondemnation_date(String condemnation_date) {
		this.condemnation_date = condemnation_date;
	}


	public String getIcms_coach_id() {
		return icms_coach_id;
	}


	public void setIcms_coach_id(String icms_coach_id) {
		this.icms_coach_id = icms_coach_id;
	}


	public String getAc_flag() {
		return ac_flag;
	}


	public void setAc_flag(String ac_flag) {
		this.ac_flag = ac_flag;
	}


	public String getBuilt_date() {
		return built_date;
	}


	public void setBuilt_date(String built_date) {
		this.built_date = built_date;
	}


	public String getCoach_commission_date() {
		return coach_commission_date;
	}


	public void setCoach_commission_date(String coach_commission_date) {
		this.coach_commission_date = coach_commission_date;
	}


	public String getCoach_received_date() {
		return coach_received_date;
	}


	public void setCoach_received_date(String coach_received_date) {
		this.coach_received_date = coach_received_date;
	}


	public String getManufacturer() {
		return manufacturer;
	}


	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}


	public String getUnderframe_no() {
		return underframe_no;
	}


	public void setUnderframe_no(String underframe_no) {
		this.underframe_no = underframe_no;
	}


	public String getShell_no() {
		return shell_no;
	}


	public void setShell_no(String shell_no) {
		this.shell_no = shell_no;
	}


	public String getCoach_auto_generated() {
		return coach_auto_generated;
	}


	public void setCoach_auto_generated(String coach_auto_generated) {
		this.coach_auto_generated = coach_auto_generated;
	}


	public String getIs_biotoilet_fitted() {
		return is_biotoilet_fitted;
	}


	public void setIs_biotoilet_fitted(String is_biotoilet_fitted) {
		this.is_biotoilet_fitted = is_biotoilet_fitted;
	}


	public String getOrder_id() {
		return order_id;
	}


	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}


	public String getCoach_owning_div() {
		return coach_owning_div;
	}


	public void setCoach_owning_div(String coach_owning_div) {
		this.coach_owning_div = coach_owning_div;
	}




	public String getFactory_turnout_date() {
		return factory_turnout_date;
	}


	public void setFactory_turnout_date(String factory_turnout_date) {
		this.factory_turnout_date = factory_turnout_date;
	}


	public String getRfid_status() {
		return rfid_status;
	}


	public void setRfid_status(String rfid_status) {
		this.rfid_status = rfid_status;
	}


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public String getInsert_or_update() {
		return insert_or_update;
	}


	public void setInsert_or_update(String insert_or_update) {
		this.insert_or_update = insert_or_update;
	}


	public Date getInsert_or_update_date() {
		return insert_or_update_date;
	}


	public void setInsert_or_update_date(Date insert_or_update_date) {
		this.insert_or_update_date = insert_or_update_date;
	}


	public String getAdded_by_import() {
		return added_by_import;
	}


	public void setAdded_by_import(String added_by_import) {
		this.added_by_import = added_by_import;
	}


	
	
}
