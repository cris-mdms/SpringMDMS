package com.mdms.wagon.wagonuncleansed.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mdms.wagon.wagonuncleansed.model.FoisWagonTxn;
import com.mdms.wagon.wagonuncleansed.repository.FoisWagonTxnRepository;
@Service
public class FoisWagonTxnService {
	@Autowired
	private FoisWagonTxnRepository obj_foistxn_repo;
	
	public List<String> getFoisWagonNumber(FoisWagonTxn obj)
	{ 
		obj_foistxn_repo.getFoisWagonNumber(obj.getWagon_no());
	List<String> temp =new ArrayList<>();
	obj_foistxn_repo.getFoisWagonNumber(obj.getWagon_no());
	return obj_foistxn_repo.getFoisWagonNumber(obj.getWagon_no());
		}
}
