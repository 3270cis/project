package Backend;

public class Flight {
	

	private int flightNumber;
	private final int CAPACITY= 20;
	private FlightDetail flightDetails;
	
	Flight(){
		
	}
	
	public Flight(int flightNumber ) {
		
		this.flightDetails = new FlightDetail(flightNumber);
		this.flightNumber =flightNumber;
	}


	public int getFlightNumber() {
		return flightNumber;
	}



	public int getCAPACITY() {
		return CAPACITY;
	}

	public FlightDetail getFlightDetails() {
		return flightDetails;
	}

	public void setFlightDetails(FlightDetail flightDetails) {
		this.flightDetails = flightDetails;
	}
	
	
	
	
}	

