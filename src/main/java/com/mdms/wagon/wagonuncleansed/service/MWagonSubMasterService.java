package com.mdms.wagon.wagonuncleansed.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mdms.wagon.wagonuncleansed.model.MpvtOwnerPartyFoisModel;
import com.mdms.wagon.wagonuncleansed.model.MsubMaster2Model;
import com.mdms.wagon.wagonuncleansed.model.Msubmastermodel;
import com.mdms.wagon.wagonuncleansed.model.MwagonGaugeModel;
import com.mdms.wagon.wagonuncleansed.model.MWagonManufacture;
import com.mdms.wagon.wagonuncleansed.model.MWagonOwningRly;
import com.mdms.wagon.wagonuncleansed.model.MWagonStatus;
import com.mdms.wagon.wagonuncleansed.model.MWagonType;
import com.mdms.wagon.wagonuncleansed.model.MWagonWorkshop;
import com.mdms.wagon.wagonuncleansed.model.WagonUncleansedData;
import com.mdms.wagon.wagonuncleansed.repository.MWagonManufactureRepository;
import com.mdms.wagon.wagonuncleansed.repository.MWagonOwningRlyRepository;
import com.mdms.wagon.wagonuncleansed.repository.MWagonStatusRepository;
import com.mdms.wagon.wagonuncleansed.repository.MWagonTypeRepository;
import com.mdms.wagon.wagonuncleansed.repository.MpvtOwnerCodeRepo;
import com.mdms.wagon.wagonuncleansed.repository.MsubMasterRepo;
import com.mdms.wagon.wagonuncleansed.repository.MsubMasterRepo2;
import com.mdms.wagon.wagonuncleansed.repository.MwagonGagueRepo;
import com.mdms.wagon.wagonuncleansed.repository.MWagonWorkshopRepository;

@Service
public class MWagonSubMasterService {
	@Autowired
	private MWagonOwningRlyRepository obj_own_rlyrepo ;
	
	@Autowired
	private MWagonTypeRepository obj_wgntype_repo ;
	
	@Autowired
	private MsubMasterRepo msubMasterRepo;
	
	@Autowired
	private MsubMasterRepo2 msubMasterRepo2;
	
	
	@Autowired
	private MwagonGagueRepo mwagonGagueRepo;
	
	

	@Autowired
	private MpvtOwnerCodeRepo mpvtOwnerCodeRepo;
	@Autowired
	private MWagonManufactureRepository obj_wgnmfg_repo ;
	
	@Autowired
	private MWagonWorkshopRepository obj_wgnworkshop_repo ;
	
	@Autowired
	private MWagonStatusRepository obj_wgnstatus_repo ;
	
	
	public List<MWagonOwningRly> getWagonOwningRlycode()
	{ 
		obj_own_rlyrepo.getWagonOwningRlycode();
	List<MWagonOwningRly> temp =new ArrayList<>();
	obj_own_rlyrepo.getWagonOwningRlycode();
	return obj_own_rlyrepo.getWagonOwningRlycode();
		}
	
	
	
	public List<MWagonType> getWagonTypecode()
	{ 
		obj_wgntype_repo.getWagonTypecode();
	List<MWagonType> temp =new ArrayList<>();
	obj_wgntype_repo.getWagonTypecode();
	return obj_wgntype_repo.getWagonTypecode();
		}
	
	
	
	public List<Msubmastermodel> getMsubMasterData(){
		
		return msubMasterRepo.getsubMasterdata();
		
	}
	
	
	
	public List<MsubMaster2Model> getMasterData2(){
		
		return msubMasterRepo2.getsubmaster2Data();
	}
	
	
	
	
	public List<MwagonGaugeModel> getMwagonModeldata(){
		
		return mwagonGagueRepo.getMwagonGaguedata();
	}
	
	public List<MpvtOwnerPartyFoisModel> getMpvtOwnerPartyCodeFoisdata(){
		
		return mpvtOwnerCodeRepo.getMpvtownerPartyCodeFois();
	}

	public List<MWagonManufacture> getWagonManufacture()
	{ 
		obj_wgnmfg_repo.getWagonManufacture();
	List<MWagonManufacture> temp =new ArrayList<>();	
	obj_wgnmfg_repo.getWagonManufacture().forEach(temp::add);;
	return obj_wgnmfg_repo.getWagonManufacture();
		}
	
	public List<MWagonWorkshop> getWagonWorkshop()
	{ 
		obj_wgnworkshop_repo.getWagonWorkshop();
	List<MWagonWorkshop> temp =new ArrayList<>();	
	obj_wgnworkshop_repo.getWagonWorkshop().forEach(temp::add);
	return obj_wgnworkshop_repo.getWagonWorkshop();
		}
	
	public List<MWagonStatus> getWagonStatus()
	{ obj_wgnstatus_repo.getWagonStatus();
	List<MWagonStatus> temp =new ArrayList<>();	
	obj_wgnstatus_repo.getWagonStatus().forEach(temp::add);
	return obj_wgnstatus_repo.getWagonStatus();
		}

	
}
