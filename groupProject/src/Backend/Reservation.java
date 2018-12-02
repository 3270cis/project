package Backend;

import java.time.LocalDate;
import java.util.Date;

public class Reservation {
	
	private int reservationNo;
	private LocalDate dateCreated;
	FlightDetails flightDetail;
	
	public Reservation(int reservationNo) {
	
		this.reservationNo = reservationNo;
		this.flightDetail = new FlightDetails();
		this.dateCreated =  java.time.LocalDate.now();  
		
	}
	
	
	public Reservation(int reservationNo, FlightDetails flightDetail1) {
		
		this.reservationNo = reservationNo;
		this.flightDetail = flightDetail1;
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


	public FlightDetails getFlightDetail1() {
		return flightDetail;
	}

	public void setFlightDetail1(FlightDetails flightDetail1) {
		this.flightDetail = flightDetail1;
	}
	
	
	

}
