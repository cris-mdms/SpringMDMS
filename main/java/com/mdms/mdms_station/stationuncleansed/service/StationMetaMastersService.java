package com.mdms.mdms_station.stationuncleansed.service;



import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdms.mdms_station.stationuncleansed.model.MGauge;
import com.mdms.mdms_station.stationuncleansed.model.MGisDetail;
import com.mdms.mdms_station.stationuncleansed.model.MInterlockingStandard;
import com.mdms.mdms_station.stationuncleansed.model.MOperatingStationSignal;



import com.mdms.mdms_station.stationuncleansed.model.MStationCategory;




import com.mdms.mdms_station.stationuncleansed.model.MStationCategory;


import com.mdms.mdms_station.stationuncleansed.model.MStationCategory;
import com.mdms.mdms_station.stationuncleansed.model.MStationCategory;

import com.mdms.mdms_station.stationuncleansed.model.MStationClass;
import com.mdms.mdms_station.stationuncleansed.model.MStationInterchange;
import com.mdms.mdms_station.stationuncleansed.model.MStationJunction;
import com.mdms.mdms_station.stationuncleansed.model.MTraction;
import com.mdms.mdms_station.stationuncleansed.model.MTrafficType;
import com.mdms.mdms_station.stationuncleansed.model.MgisDetails;
import com.mdms.mdms_station.stationuncleansed.model.MgsNewModel;
import com.mdms.mdms_station.stationuncleansed.model.RtisLatLongModel;
import com.mdms.mdms_station.stationuncleansed.model.rbs_division;
import com.mdms.mdms_station.stationuncleansed.model.MBookingResource;
import com.mdms.mdms_station.stationuncleansed.model.MBookingType;
import com.mdms.mdms_station.stationuncleansed.model.MState;
import com.mdms.mdms_station.stationuncleansed.model.MDistrict;

import com.mdms.mdms_station.stationuncleansed.model.MBookingType;
import com.mdms.mdms_station.stationuncleansed.model.MState;
import com.mdms.mdms_station.stationuncleansed.model.MDistrict;

import com.mdms.mdms_station.stationuncleansed.repository.MGaugeRepository;
import com.mdms.mdms_station.stationuncleansed.repository.MGisDetailRepository;
import com.mdms.mdms_station.stationuncleansed.repository.MInterlockingStandardRepository;
import com.mdms.mdms_station.stationuncleansed.repository.MOperatingStationSignalRepository;

import com.mdms.mdms_station.stationuncleansed.repository.MStateRepository;
import com.mdms.mdms_station.stationuncleansed.repository.MStationCategoryRepository;
import com.mdms.mdms_station.stationuncleansed.repository.MStateRepository;
import com.mdms.mdms_station.stationuncleansed.repository.MStationCategoryRepository;




import com.mdms.mdms_station.stationuncleansed.repository.MStateRepository;
import com.mdms.mdms_station.stationuncleansed.repository.MStationCategoryRepository;

import com.mdms.mdms_station.stationuncleansed.repository.MStateRepository;
import com.mdms.mdms_station.stationuncleansed.repository.MStationCategoryRepository;


import com.mdms.mdms_station.stationuncleansed.repository.MStationClassRepository;
import com.mdms.mdms_station.stationuncleansed.repository.MStationInterchangeRepository;
import com.mdms.mdms_station.stationuncleansed.repository.MStationJunctionRepository;
import com.mdms.mdms_station.stationuncleansed.repository.MTractionRepository;
import com.mdms.mdms_station.stationuncleansed.repository.MTrafficTypeRepository;
import com.mdms.mdms_station.stationuncleansed.repository.MgisDetailsRepo;
import com.mdms.mdms_station.stationuncleansed.repository.MgisLatLongRepo;
import com.mdms.mdms_station.stationuncleansed.repository.RbsDivisionRepo;
import com.mdms.mdms_station.stationuncleansed.repository.RitsLatLongRepo;
import com.mdms.mdms_station.stationuncleansed.repository.MBookingResourceRepository;
import com.mdms.mdms_station.stationuncleansed.repository.MBookingTypeRepository;
import com.mdms.mdms_station.stationuncleansed.repository.MDistrictRepository;



@Service
public class StationMetaMastersService {

	@Autowired
	RbsDivisionRepo obj_rbsrepo;
	
	@Autowired
	MGaugeRepository gauge_repo;
	
	@Autowired
	MGisDetailRepository gis_repo;
		
	@Autowired
	MInterlockingStandardRepository interlock_repo;
		
	@Autowired
	MOperatingStationSignalRepository oprtn_repo;
	
	@Autowired
	MStationClassRepository stnclass_repo;
	
	@Autowired
	MStationInterchangeRepository stnintrchng_repo;
	
	@Autowired
	MStationJunctionRepository stnjuncn_repo;
	
	@Autowired
	MTractionRepository traction_repo;
	
	@Autowired
	MTrafficTypeRepository traffic_repo;

	@Autowired
	MBookingTypeRepository booking_repo;
	
	@Autowired
	MStationCategoryRepository stn_cat_repo;
	
	@Autowired
	MStateRepository staterepo;
	
	@Autowired
	MDistrictRepository districtrepo;

	
	@Autowired
	MBookingResourceRepository booking_res_repo ;
	
	
	@Autowired
	MgisLatLongRepo mgisLatLongRepo;
	
	@Autowired
	MgisDetailsRepo mgisDetailsRepo;
	
	@Autowired
	RitsLatLongRepo ritsLatLongRepo;

	
	public List<MGauge> getAllGauge() {
		
		return gauge_repo.getAllGauge();
	}

	public List<MGisDetail> getLatLong(String station_code) {
		// TODO Auto-generated method stub
		return gis_repo.getLatLong(station_code);
	}
	 
	public List<MgsNewModel> getlatlongitude(String station_code){
		return mgisLatLongRepo.getLatLatLongitude(station_code);
	}

	public List<MInterlockingStandard> getInterLock() {
		// TODO Auto-generated method stub
		return interlock_repo.getInterLock();
	}

	public List<MOperatingStationSignal> getOperatingSignal() {
		// TODO Auto-generated method stub
		return oprtn_repo.getOperatingSignal();
	}

	public List<MStationClass> getStationClass() {
		// TODO Auto-generated method stub
		return stnclass_repo.getStationClass();
	}

	public List<MStationInterchange> getStationInterchange() {
		// TODO Auto-generated method stub
		return stnintrchng_repo.getStationInterchange();
	}

	public List<MStationJunction> getStationJunction() {
		// TODO Auto-generated method stub
		return stnjuncn_repo.getStationJunction();
	}

	public List<MTraction> getTraction() {
		// TODO Auto-generated method stub
		return traction_repo.getTraction();
	}

	public List<MTrafficType> getTraffic() {
		// TODO Auto-generated method stub
		return traffic_repo.getTraffic();
	}


	public List<MBookingType> getBookingType() {
		// TODO Auto-generated method stub
		return booking_repo.getBookingType();
	}

	public List<MStationCategory> getStationCategory() {
		// TODO Auto-generated method stub
		return stn_cat_repo.getStationCategory();
	}
	
	public List<MState> getLgdState() {
		// TODO Auto-generated method stub
		return staterepo.getLgdState();
	}
    
	
	
	public List<MDistrict> getLgdDistrict() {
		// TODO Auto-generated method stub
		return districtrepo.getLgdDistrict();
	}

	public List<MBookingResource> getBookingResource() {
		// TODO Auto-generated method stub
		return booking_res_repo.getBookingResource();
	}

	public List<MgisDetails> getLatLongDetails(String station_code){
		
		
		//class LatLongDetails
		
		if(mgisDetailsRepo.getLatLatLongitude(station_code).size()==0) {
			
			List<RtisLatLongModel> list= ritsLatLongRepo.getLatLatLongitudeDetail(station_code);
			System.out.println("FROM LAT LONG");
			
			MgisDetails mgisDetail= new MgisDetails();
			mgisDetail.setLatitude(list.get(0).getStation_latitude());
			mgisDetail.setLongitude(list.get(0).getStation_longitude());
			//mgisDetail.setTable_name("from rtis");
			
			
			List<MgisDetails> listt= new ArrayList<MgisDetails>();
			listt.add(mgisDetail);
			return listt;
			
		} 
		else {
			System.out.println("from GIS DETAIL");
			List<MgisDetails> lis= mgisDetailsRepo.getLatLatLongitude(station_code);
			//lis.get(0).setTable_name("from gis");
			return lis;
			
    	   // return mgisDetailsRepo.getLatLatLongitude(station_code);
    }
	}
	
	
	public List<String> getrbsallzone() {
		// TODO Auto-generated method stub
		return obj_rbsrepo.getrbszone();
	}
	
	
	
	public List<rbs_division> getrbsdivision(String zc) {
		System.out.println(zc);
		return obj_rbsrepo.getrbsdivision(zc);
	}
	
	/*
	 * public List<RtisLatLongModel> getLatLongRtisDetails(String station_code){
	 * return ritsLatLongRepo.getLatLatLongitudeDetail(station_code); }
	 */
	
}
