package Backend;

public class Flight {
	

	private int flightNumber;
	private final int CAPACITY= 20;
	private FlightDetails flightDetails;
	
	Flight(){
		
	}
	
	public Flight(int flightNumber ) {
		
		this.flightDetails = new FlightDetails(flightNumber);
		this.flightNumber =flightNumber;
	}


	public int getFlightNumber() {
		return flightNumber;
	}



	public int getCAPACITY() {
		return CAPACITY;
	}

	public FlightDetails getFlightDetails() {
		return flightDetails;
	}

	public void setFlightDetails(FlightDetails flightDetails) {
		this.flightDetails = flightDetails;
	}
	
	
	
	
}	

