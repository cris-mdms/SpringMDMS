/*This Model class refers RBS Data for raw data input and show to user.     
 * Created By : Anshul, 21-10-2020
 * 
 */

package com.mdms.mdms_station.stationuncleansed.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="user_otp_detail", schema="mdms_app_mgmt")
public class StationDataRbs {
	@Id
	@Column(name="user_id")
	private String user_id;

}
