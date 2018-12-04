package Backend;

import java.time.LocalDate;
import java.util.Date;

public class Reservation {
	
	private int reservationNo;
	private LocalDate dateCreated;
	FlightDetail flightInfo;
	
	public Reservation(int reservationNo) {
	
		this.reservationNo = reservationNo;
		this.dateCreated =  LocalDate.now();  
		
	}
	
	
	public Reservation(int reservationNo, FlightDetail flightInfo ) {
		
		this.reservationNo = reservationNo;
		this.flightInfo = flightInfo;
	}


	public int getReservationNo() {
		return reservationNo;
	}


	public void setReservationNo(int reservationNo) {
		this.reservationNo = reservationNo;
	}


	public LocalDate getDateCreated() {
		return dateCreated;
	}


	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}


	public FlightDetail getFlightInfo() {
		return flightInfo;
	}


	public void setFlightInfo(FlightDetail flightInfo) {
		this.flightInfo = flightInfo;
	}

	
	
	
	

}
