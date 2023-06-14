package com.mdms.mdms_coach.coachuncleansed.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdms.mdms_coach.coachuncleansed.model.MBreakType;
import com.mdms.mdms_coach.coachuncleansed.model.MCoachCategoryType;
import com.mdms.mdms_coach.coachuncleansed.model.MCoachStatus;
import com.mdms.mdms_coach.coachuncleansed.model.MCoachType;
import com.mdms.mdms_coach.coachuncleansed.model.MCoachTypePrs;
import com.mdms.mdms_coach.coachuncleansed.model.MCouplingType;
import com.mdms.mdms_coach.coachuncleansed.model.MDepo;
import com.mdms.mdms_coach.coachuncleansed.model.MFitnessType;
import com.mdms.mdms_coach.coachuncleansed.model.MPowerGenerationType;
import com.mdms.mdms_coach.coachuncleansed.repository.MBreakTypeRepo;
import com.mdms.mdms_coach.coachuncleansed.repository.MCoachCategoryTypeRepo;
import com.mdms.mdms_coach.coachuncleansed.repository.MCoachStatusRepo;
import com.mdms.mdms_coach.coachuncleansed.repository.MCoachTypePrsRepository;
import com.mdms.mdms_coach.coachuncleansed.repository.MCoachTypeRepository;
import com.mdms.mdms_coach.coachuncleansed.repository.MCuplingTypeRepo;
import com.mdms.mdms_coach.coachuncleansed.repository.MDepoRepository;
import com.mdms.mdms_coach.coachuncleansed.repository.MFitnessTypeRepository;
import com.mdms.mdms_coach.coachuncleansed.repository.MPowerGenerationTypeRepo;

@Service
public class MasterCoachService {
	
	@Autowired
	private MBreakTypeRepo mBreakTypeRepo;
	
	@Autowired
	private MCoachCategoryTypeRepo mCoachCategoryTypeRepo;
	
	@Autowired
	private MCoachStatusRepo mCoachStatusRepo;
	
	@Autowired
	private MCoachTypeRepository mCoachTypeRepository;
	
	@Autowired
	private MCoachTypePrsRepository mCoachTypePrsRepository;
	
	@Autowired
	private MCuplingTypeRepo mCuplingTypeRepo;
	
	@Autowired
	private MDepoRepository mDepoRepository;
	
	@Autowired
	private MFitnessTypeRepository mFitnessTypeRepository;
	
	@Autowired
	private MPowerGenerationTypeRepo mPowerGenerationTypeRepo;
	
	
	
	public List<MBreakType> findMbreakData(){
		
		return mBreakTypeRepo.getMbreakType();
	}
	
	
	public List<MCoachCategoryType> findMCoachCategoryData(){
		
		return mCoachCategoryTypeRepo.getMCoachCategoryType();
	}

	public List<MCoachStatus> findMCoachstatusData(){
		
		return mCoachStatusRepo.getMCoachStatusType();
	}
	
	public List<MCoachType> findMCoachTypeCmmData(){
		return mCoachTypeRepository.getMCoachTypeCmm();
	}
	
	public List<MCoachTypePrs> findMCoachTypePrsData(){
		return mCoachTypePrsRepository.getMCoachTypesPrs();
	}
	
	public List<MCouplingType> findMCouplingType(){
		return mCuplingTypeRepo.getMCouplingType();
	}
	
	public List<MDepo> findMDepoData(){
		return mDepoRepository.findMDepo();
	}
	
	public List<MFitnessType> findMfitnessTypedata(){
		return mFitnessTypeRepository.getAllFitnessType();
	}
	
	public List<MPowerGenerationType> findMPowerGenerationTypeDetails(){
		return mPowerGenerationTypeRepo.findMPowerGenerationType();
	}
	
	public List<MCoachType> getReservedCoachTypeCmmData(){
		return mCoachTypeRepository.getMCoachTypeCmmReservedCoach();
	}
	
}
