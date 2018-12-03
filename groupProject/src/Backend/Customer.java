package Backend;



public class Customer extends User {
	
	
	private String firstName;
	private String lastName;
	private String SSN;
	private String phoneNumber;
	private String email;
	private int userID;
	
	
	public Customer(String firstName, String lastName) {
		
		super(firstName, lastName);
	}

	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getSSN() {
		return SSN;
	}



	public void setSSN(String sSN) {
		SSN = sSN;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public int getUserID() {
		return userID;
	}



	public void setUserID(int userID) {
		this.userID = userID;
	}


	@Override
	public void deleteFlight() {
	}

	@Override
	public void addFlight() {
	}
	
	
	

	
	
	
	
	

}
