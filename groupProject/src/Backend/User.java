package Backend;



public abstract class User {
	
	
	private String firstName;
	private String lastName;
	private String SSN;
	private String phoneNumber;
	private String email;
	private String username;
	private String password;
	private int userID;
	
	
	public User(String firstName, String lastName) {
		
		SSN = "";
		phoneNumber = "";
		email = "";
		username = "";
		password = "";
		
		this.userID = UserIdGenerator.generateID();
		this.firstName = firstName;
		this.lastName = lastName;
	
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
	
	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public abstract void deleteFlight();
	
	public abstract void addFlight();

}
