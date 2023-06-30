package com.mdms.app.mgmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.app.mgmt.model.MenuNameListModel;


public interface MenuNameListRepository extends CrudRepository<MenuNameListModel,Integer>{
		
		@Query(value="SELECT menu_id from mdms_app_mgmt.m_menu_list where menu_id=?1",nativeQuery=true)
		  List<Integer> getMenuRightsNameList(String menu_id);
		
		

	}



