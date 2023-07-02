package com.mdms.wagon.wagonuncleansed.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.mdms.wagon.wagonuncleansed.model.WagonNumberMapping;
import com.mdms.wagon.wagonuncleansed.repository.WagonNumerMappingRepository;

@Service
public class WagonNumberMappingService {
	@Autowired
	private WagonNumerMappingRepository obj_wagonnumber;	
	
public List<WagonNumberMapping> getAllWagonDetail()
{
	obj_wagonnumber.getAllWagonDetail();
	List<WagonNumberMapping> temp = new ArrayList<>();
	obj_wagonnumber.getAllWagonDetail().forEach(temp::add);
	return obj_wagonnumber.getAllWagonDetail();
	
}
	

public boolean deleteWagonrecord(String wgnum)
{
	try {
	 obj_wagonnumber.deleteWagonrecord(wgnum);		
	return true;
	}
	catch(Exception e){
		
		System.out.println(e);
		return false;
	}	
}


/*
>>>>>>> a796579cb9d19590a212ed54e6e06c965fa48879

//saving data of wagon 
	public boolean addwagondata(WagonNumberMapping  obj_adddata) {
//		try{
		if(((CrudRepository<WagonNumberMapping, Long>) obj_adddata).save(obj_adddata) != null)
		{
					return true;	
		}
//catch(Exception e){
			
			
		else {	return false;}
//		}
		
		
					}
		
					*/

}
