/*This controller provides all services for getting  draft/reject and unapproved record from wagon_uncleansed_data.
 * Created By : Ritu, 19-07-2021
 * 
 */
package com.mdms.wagon.wagonuncleansed.controller;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mdms.loco.locouncleansed.model.LocoDataFois;
import com.mdms.loco.locouncleansed.model.LocoUncleansedDataElectric;
import com.mdms.wagon.wagonuncleansed.model.FoisWagonTxn;
import com.mdms.wagon.wagonuncleansed.model.IRWMS_Wagon_Type_Mapping_With_Fois;
import com.mdms.wagon.wagonuncleansed.model.IRWMS_Wagon_Type_Mapping_with_Fmm;
import com.mdms.wagon.wagonuncleansed.model.NewOwningrly;
import com.mdms.wagon.wagonuncleansed.model.NewVehicleType;
import com.mdms.wagon.wagonuncleansed.model.NewWagonDataIrwms;
import com.mdms.wagon.wagonuncleansed.model.RohPohDetailsModel;
import com.mdms.wagon.wagonuncleansed.model.VehicleNo;
import com.mdms.wagon.wagonuncleansed.model.WagonDataIRWMS1;
import com.mdms.wagon.wagonuncleansed.model.WagonDataIrwms;
import com.mdms.wagon.wagonuncleansed.model.WagonUncleansedData;
import com.mdms.wagon.wagonuncleansed.service.FoisWagonTxnService;
import com.mdms.wagon.wagonuncleansed.service.WagonDataIrwmsService;
import com.mdms.wagon.wagonuncleansed.service.WagonEditForwardService;
@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")

@RestController
public class WagonEditForwardController {	
	@Autowired
	private WagonDataIrwmsService obj_wagonirwms;
	
	@Autowired
	private WagonEditForwardService obj_ctrl;
	
	@Autowired
	private FoisWagonTxnService obj_foistxn;
	
	@RequestMapping(method=RequestMethod.POST, value = "/getWagonCleansedRecord")
	public List<WagonUncleansedData> getWagonCleansedRecord(@RequestBody WagonUncleansedData obj)
	{System.out.println(obj);
	obj_ctrl.getWagonCleansedRecord(obj);
	return obj_ctrl.getWagonCleansedRecord(obj);
	}
	

	@RequestMapping(method=RequestMethod.POST, value = "/getIrwmsWagonNo")
	public List<BigInteger> getIrwmsWagonNumber(@RequestBody WagonDataIrwms obj)
	{System.out.println(obj);
	obj_wagonirwms.getIrwmsWagonNumber(obj);
	return obj_wagonirwms.getIrwmsWagonNumber(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/getFoisWagonNo")
	public List<String> getFoisWagonNumber(@RequestBody FoisWagonTxn obj)
	{System.out.println(obj);
	obj_foistxn.getFoisWagonNumber(obj);
	return obj_foistxn.getFoisWagonNumber(obj);
	}
	
	//Develope by Amit Date--23-11-2021,for fetching all data of wagon
	@RequestMapping(method=RequestMethod.POST, value = "/getnewwagondatairwms")
	public List<NewWagonDataIrwms> findNewWagonDataIrwms(){
		return obj_ctrl.getNewWagonDataIrwms();
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/getnewwagondatairwmszsa")
	public List<NewWagonDataIrwms> findAllwagonData(@RequestBody NewWagonDataIrwms newWagonDataIrwms){
		return obj_ctrl.findwagondata(newWagonDataIrwms.getOwningrly(),newWagonDataIrwms.getVehicletype(),newWagonDataIrwms.getVehicleno());
		
	}

	@RequestMapping(method=RequestMethod.POST, value = "/getvehicleno")
	public List<VehicleNo> findVahicleNo(@RequestBody NewWagonDataIrwms newWagonDataIrwms){
		return obj_ctrl.getvehicleNoIrwms(newWagonDataIrwms.getVehicletype(),newWagonDataIrwms.getOwningrly(),newWagonDataIrwms.getGroupname());
	}
	
	//service to get draft record formo uncleansed table
	@RequestMapping(method=RequestMethod.POST, value = "/getdraftvehicleno")
	public List<WagonUncleansedData> findVahicleNo(@RequestBody WagonUncleansedData objdraft){
		return obj_ctrl.getdraftVehicleNO(objdraft.getWagon_type(),objdraft.getWagon_owning_rly(),objdraft.getWagon_class_group());
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "/getowningrly")
	public List<NewOwningrly> findOwingrly(){
		return obj_ctrl.getOwingrly();
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/getvehicletype")
	public List<NewVehicleType> findVehicleType(@RequestBody NewWagonDataIrwms newWagonDataIrwms1){
		return obj_ctrl.getVehicleTypeDetails(newWagonDataIrwms1.getOwningrly(),newWagonDataIrwms1.getGroupname());
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/getgroupname")
	public List<String> getgroupname(@RequestBody NewWagonDataIrwms newWagonDataIrwms1){
		return obj_ctrl.getgroupname(newWagonDataIrwms1.getOwningrly());
	}


	
	@RequestMapping(method=RequestMethod.POST, value="/checkwgnnoexist")
	public List<WagonUncleansedData> checkwagonexist(@RequestBody WagonUncleansedData obj) {
		obj_ctrl.checkwagonexist(obj);
	return  obj_ctrl.checkwagonexist(obj);
	
	}  
	
	@RequestMapping(method=RequestMethod.POST, value="/savewagondata")
		public boolean adddata(@RequestBody WagonUncleansedData objsave) {
		System.out.println("wagon number"+objsave.getWagon_no());
		System.out.println("wagon type" + objsave.getWagon_type()); 		
		boolean flag= obj_ctrl.adddata(objsave);
				return flag;		 		}

    
	@RequestMapping(method=RequestMethod.POST, value = "/getrohpohdata")
	public List<RohPohDetailsModel> findRohPohDetails(@RequestBody WagonDataIRWMS1 newWagonDataIrwms3){
		return obj_ctrl.getRohPohDetails(newWagonDataIrwms3.getOwningrly(),newWagonDataIrwms3.getGroupname(),newWagonDataIrwms3.getVehicletype(),newWagonDataIrwms3.getVehicleno());
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/getrohpohvehicleno")
	public List<VehicleNo> findRohPohVahicleNo(@RequestBody NewWagonDataIrwms newWagonDataIrwms){
		//return obj_ctrl.getvehicleNoIrwms(newWagonDataIrwms.getVehicletype(),newWagonDataIrwms.getOwningrly(),newWagonDataIrwms.getGroupname());
		 return obj_ctrl.getRohPohvehicleNoIrwms(newWagonDataIrwms.getVehicletype(), newWagonDataIrwms.getOwningrly(), newWagonDataIrwms.getGroupname());
		
	}

	//update wagon draft record
 	@RequestMapping(method=RequestMethod.POST, value ="/updatewagondraft")
 	public String updatewagondraft (@RequestBody WagonUncleansedData objupdate)
 	{
 		System.out.println("status"+ objupdate.getStatus());
 		System.out.println("remarks"+ objupdate.getRemarks());
 		System.out.println("wagonnumber"+ objupdate.getWagon_no());	
 		System.out.println("wagontype"+ objupdate.getWagon_type()); 
 		System.out.println("txndt"+ objupdate.getTxn_dates()); 	
 	String flag = obj_ctrl.updatewagondraft(objupdate);
 	return "Wagon Draft Record Update Sucessfully";
 	}
 	
 	
//  status updated = cleansed "D"
    @RequestMapping(method=RequestMethod.POST, value="/markedStatusDinIRWMS")
	public boolean updatestatus(@RequestBody  WagonDataIRWMS1 updatestatusd) {
		boolean flag=obj_ctrl.updatestatus(updatestatusd);
			return flag;
	}

    @RequestMapping(method=RequestMethod.POST, value = "/getirwmsfoistypemappingdata")
	public List<IRWMS_Wagon_Type_Mapping_With_Fois> getirwmsmappingdatawithfois(@RequestBody IRWMS_Wagon_Type_Mapping_With_Fois obj_irwmsfois){
		return obj_ctrl.getirwmsmappingdatawithfois();
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/getirwmsfmmtypemappingdata")
	public List<IRWMS_Wagon_Type_Mapping_with_Fmm> getirwmsmappingdatawithfmm(@RequestBody IRWMS_Wagon_Type_Mapping_With_Fois obj_irwmsfois){
		return obj_ctrl.getirwmsmappingdatawithfmm();
	}
	
	// JYOTI BISHT 1-11-22
  	@PostMapping("/wagon_integration")
	public List<Object[]> integration_stats(@RequestParam("from") String from, @RequestParam("to") String to) throws ParseException
	{
		
		return obj_ctrl.integration_stats(from, to);
	}
	
    // JYOTI BISHT 1-11-22
			
	@PostMapping("/get_total_wagon_count")
	public int get_wagon_count()
	{
		return obj_ctrl.get_wagon_total_count();
	}
	
	// Ritu 07-11-22
	  	@PostMapping("/wagonorgtypecount")
		public List<Object[]> getwagontypecount() throws ParseException
		{
			
			return obj_ctrl.getwagontypecount();
		}
}
