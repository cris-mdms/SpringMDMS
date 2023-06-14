package com.mdms.wagon.wagonuncleansed.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdms.wagon.wagonuncleansed.model.WagonCleansedData;
import com.mdms.wagon.wagonuncleansed.repository.WagonCleansedRepository;
@Service
public class WagonApproveService {
	@Autowired
	private WagonCleansedRepository obj_cleansedRepo;
	//saving data 
		public boolean addwagonapproveddata(WagonCleansedData obj_save) {
//			try{
			if(obj_cleansedRepo.save(obj_save) != null)
			{
						return true;	
			}
	//catch(Exception e){
				
				
			else {	return false;}
//			}
			
			
						}
}
