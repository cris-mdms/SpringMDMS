package com.mdms.wagon.wagonuncleansed.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdms.wagon.wagonuncleansed.model.WagonDataIrwms;
import com.mdms.wagon.wagonuncleansed.repository.WagonDataIrwmsRepository;
@Service
public class WagonDataIrwmsService {
	@Autowired
	private WagonDataIrwmsRepository obj_irwms_repo ;
	
	
	public List<BigInteger> getIrwmsWagonNumber(WagonDataIrwms obj)
	{ 
	obj_irwms_repo.getIrwmsWagonNumber(obj.getOwningrly(), obj.getVehicletype());
	List<BigInteger> temp =new ArrayList<>();
	obj_irwms_repo.getIrwmsWagonNumber(obj.getOwningrly(), obj.getVehicletype());
	return obj_irwms_repo.getIrwmsWagonNumber(obj.getOwningrly(), obj.getVehicletype());
		}
}
