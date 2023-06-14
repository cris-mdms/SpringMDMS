package com.mdms.app.mgmt.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdms.app.mgmt.model.MenuNameListModel;
import com.mdms.app.mgmt.model.UserProfileRegistrationDetailModel;
import com.mdms.app.mgmt.repository.MenuNameListRepository;
import com.mdms.app.mgmt.repository.ShowListOfMenuRightsRepository;
import com.mdms.app.mgmt.repository.UserProfileRegistrationRepository;

@Service
public class ShowMenuRightsService {
	
	
	
	@Autowired
	private UserProfileRegistrationRepository profileRepo;
	
	@Autowired
	private ShowListOfMenuRightsRepository menuRightRepo;
	
	
	@Autowired
	MenuNameListRepository menuNameListRepo;
	
	 Logger logger=LoggerFactory.getLogger(ShowMenuRightsService.class);
	
	
		
	 
	 public List<String>  showMenuRights(String user_id) {
		 List<String> menuNameList = new ArrayList<String>();
		 
	 List<UserProfileRegistrationDetailModel> response=profileRepo.getUserRoleAndType(user_id);
		logger.info("Service : ShowMenuRightsService || Method : showMenuRights,getUserRoleAndType ||user_id: "+user_id+"||roleAndTypeListSize:"+response.size());

	List<Integer> menus_list= menuRightRepo.getMenuRightsList(response.get(0).getRole_type(),response.get(0).getUser_type());
	logger.info("Service : ShowMenuRightsService || Method : showMenuRights ,getMenuRightsList||user_id: "+response.get(0).getUser_id()+"||Roletype"+response.get(0).getRole_type()+" ||MenuIdList:"+menus_list.size());

	
	
	List<MenuNameListModel> menues_name_list= (List<MenuNameListModel>) menuNameListRepo.findAllById(menus_list);
	
	menues_name_list.forEach((MenuNameListModel) -> menuNameList.add(MenuNameListModel.getMenu_descfription()) );
	
	
	logger.info("Service : ShowMenuRightsService || Method : showMenuRights ,findAllById||user_id: "+response.get(0).getUser_id()+"||Roletype"+response.get(0).getRole_type()+" ||MenuIdList:"+menus_list.size());

	return menuNameList;
	 }
	 
	 
	 public String getUserType(String user_id) {
			
		List<String> list= menuRightRepo.getUserType(user_id);
		if(list.size()>0)
		{
			logger.info("Service : ShowMenuRightsService || Method : getUserType ||user_id: "+user_id +"||user_type "+list.get(0));

			return list.get(0);
		}else {
			logger.info("Service : ShowMenuRightsService || Method : getUserType ||user_id: "+user_id +"||user_type No usertype");

			return "NO user type";	
		}
		
			
		}

}
