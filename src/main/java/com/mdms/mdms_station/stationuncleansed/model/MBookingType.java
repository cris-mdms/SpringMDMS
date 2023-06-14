/*This Model class refers Station Booking Type  Table for referential data input and show to user.     
 * Created By : Anshul, 27-10-2020
 * 
 */

package com.mdms.mdms_station.stationuncleansed.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="m_booking_type", schema="mdms_station")

public class MBookingType {
	@Id
	@Column(name="booking_type_code")
	private String booking_type_code;
	
	
	@Column(name="description")
	private String description;


	public String getBooking_type_code() {
		return booking_type_code;
	}


	public void setBooking_type_code(String booking_type_code) {
		this.booking_type_code = booking_type_code;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	
	

}
