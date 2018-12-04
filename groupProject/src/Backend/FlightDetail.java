package Backend;

public class FlightDetail{
	
	private String departureDate;
	private String arrivalDate;
	private String destination;
	private String departureCity;
	private int flightNumber;
	
	
	public FlightDetail(int flightNumber,String departureCity, String destination, String departureDate, String arrivalDate ) {
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.destination = destination;
		this.departureCity = departureCity;
		this.flightNumber = flightNumber;
	}
	
	public FlightDetail(int flightNumber) {
		this.departureDate = "";
		this.arrivalDate = "";
		this.destination ="";
		this.departureCity = "";
		this.flightNumber = flightNumber;
	}
	
	


	public String getDepartureDate() {
		return departureDate;
	}


	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}


	public String getArrivalDate() {
		return arrivalDate;
	}


	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
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


	public int getFlightNumber() {
		return flightNumber;
	}


	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	
	

}
