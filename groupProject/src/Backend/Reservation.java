package Backend;

import java.time.LocalDate;
import java.util.Date;

public class Reservation {
	
	private String departureDate;
	private String destination;
	private String departureCity;
	private String username;
	
	public Reservation() {
		
		 departureDate ="";
		destination ="";
		departureCity ="";
		 username="";
		
	}

	public Reservation(String departureDate, String destination, String departureCity, String username) {
		
		this.departureDate = departureDate;
		this.destination = destination;
		this.departureCity = departureCity;
		this.username = username;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDepartureCity() {
		return departureCity;
	}
	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	
	
}