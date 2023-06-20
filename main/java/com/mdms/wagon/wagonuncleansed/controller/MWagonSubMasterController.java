package com.mdms.wagon.wagonuncleansed.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mdms.wagon.wagonuncleansed.model.MWagonManufacture;
import com.mdms.wagon.wagonuncleansed.model.MWagonOwningRly;

import com.mdms.wagon.wagonuncleansed.model.MpvtOwnerPartyFoisModel;
import com.mdms.wagon.wagonuncleansed.model.MsubMaster2Model;
import com.mdms.wagon.wagonuncleansed.model.Msubmastermodel;
import com.mdms.wagon.wagonuncleansed.model.MwagonGaugeModel;

import com.mdms.wagon.wagonuncleansed.model.MWagonStatus;
import com.mdms.wagon.wagonuncleansed.model.MWagonType;
import com.mdms.wagon.wagonuncleansed.model.MWagonWorkshop;


import com.mdms.wagon.wagonuncleansed.service.MWagonSubMasterService;

@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")
@RestController
public class MWagonSubMasterController {

	@Autowired
    private MWagonSubMasterService obj_wagonsubmaster;
	
	@Autowired
    private MWagonSubMasterService mWagonSubMasterService;
	
	
	
	@RequestMapping(method=RequestMethod.POST, value = "/getWagonOwnRly")
	public List<MWagonOwningRly> getWagonOwningRlycode()
	{
	obj_wagonsubmaster.getWagonOwningRlycode();
	return obj_wagonsubmaster.getWagonOwningRlycode();
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/getWagonTypeCode")
	public List<MWagonType> getWagonTypecode()
	{
	obj_wagonsubmaster.getWagonTypecode();
	return obj_wagonsubmaster.getWagonTypecode();
	}
	

	@RequestMapping(method=RequestMethod.GET, value = "/getwagonorgtype")
	public List<Msubmastermodel> findSubMasterData(){
		
		return mWagonSubMasterService.getMsubMasterData();
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "/getwagonclassgroup")
	public List<MsubMaster2Model> findSubMasterData2(){
		
		return mWagonSubMasterService.getMasterData2();
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "/mwagongaugemaster")
	public List<MwagonGaugeModel> findMwagonGaugedata(){
		return mWagonSubMasterService.getMwagonModeldata();
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "/mpvtownerpartyfois")
	public List<MpvtOwnerPartyFoisModel> findPvtOwnerPartyCodeFoisData(){
		
		return mWagonSubMasterService.getMpvtOwnerPartyCodeFoisdata();
	}
		
		
	@RequestMapping(method=RequestMethod.POST, value = "/getWagonMfg")
	public List<MWagonManufacture> getWagonManufacture()
	{
	//obj_wagonsubmaster.getWagonManufacture();
	return obj_wagonsubmaster.getWagonManufacture();
	}
	
	
	
	@RequestMapping(method=RequestMethod.POST, value = "/getWagonworkshop")
	public List<MWagonWorkshop> getWagonWorkshop()
	{
	//obj_wagonsubmaster.getWagonWorkshop();
	return obj_wagonsubmaster.getWagonWorkshop();
	}
	
	
	
	@RequestMapping(method=RequestMethod.POST, value = "/getWagonstatus")
	public List<MWagonStatus> getWagonStatus()
	{
	//obj_wagonsubmaster.getWagonStatus();
	return obj_wagonsubmaster.getWagonStatus();

	}
}
