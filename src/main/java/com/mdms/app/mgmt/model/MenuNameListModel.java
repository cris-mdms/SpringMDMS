package com.mdms.app.mgmt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity()
@Table(name="m_menu_list", schema="mdms_app_mgmt")
public class MenuNameListModel {
	
	
	@Id
	@Column(name="menu_id")
	private Integer menu_id;
	
	
	@Column(name="menu_description")
	private String menu_descfription;

	@Column(name="parent_id")
	private String parent_id;

	public Integer getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(Integer menu_id) {
		this.menu_id = menu_id;
	}

	public String getMenu_descfription() {
		return menu_descfription;
	}

	public void setMenu_descfription(String menu_descfription) {
		this.menu_descfription = menu_descfription;
	}

	public String getParent_id() {
		return parent_id;
	}

	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}

	@Override
	public String toString() {
		return "MenuNameListModel [menu_id=" + menu_id + ", menu_descfription=" + menu_descfription + ", parent_id="
				+ parent_id + "]";
	}
	
	
	
}

