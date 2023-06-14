
/*This Model class refers Station Booking Resource  Table for referential data input and show to user.     
 * Created By : Anshul, 20-11-2020
 * 
 */

package com.mdms.mdms_station.stationuncleansed.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="m_booking_resource", schema="mdms_station")
public class MBookingResource {

	@Id
	@Column(name="booking_code")
	private String booking_code;
	
	
	@Column(name="description")
	private String description;


	public String getBooking_code() {
		return booking_code;
	}


	public void setBooking_code(String booking_code) {
		this.booking_code = booking_code;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
