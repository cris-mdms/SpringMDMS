package com.mdms.dahsboard.model;

import java.util.Date;

public class DivisonUsersAssetModel {
	
public String division;
public String depo;
public String shed;
public String user_id ;
public String name ;
public String designation ;
public String department;
public Date from_date;
public  Date last_login_date;
public String role_type;
	
	
	public DivisonUsersAssetModel(String division,String depo,String shed,String user_id,String name, String designation, String department,Date from_date, Date last_login_date, String role_type)
	{
		
		this.division=division;
		this.depo=depo;
		this.shed=shed;
		this.user_id=user_id;
		this.name=name;
		this.designation=designation;
		this.department=department;
		this.from_date=from_date;
		this.last_login_date=last_login_date;
		this.role_type=role_type;
	}
	
	
	
	

}
