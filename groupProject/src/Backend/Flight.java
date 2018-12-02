package Backend;

public class Flight {
	
	private String departureDate;
	private String arrivalDate;
	private String destinationCity;
	private String departureCity;
	private int flightNumber;
	
	
	Flight(){
		
	}
	
	Flight(String departureDate, String arrivalDate, String destinationCity,String departureCity,int flightNumber ) {
		
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.destinationCity = destinationCity;
		this.departureCity = departureCity;
		this.flightNumber =flightNumber;
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


	public String getDestinationCity() {
		return destinationCity;
	}


	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
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

