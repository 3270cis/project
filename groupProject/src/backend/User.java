package backend;

public abstract  class User {
	
	private String firstName ="";
	private String lastName = "";
	private String SSN = "";
	private String streetAddress = "";
	private String city = "";
	private String state = "";
	private int zipCode;
	private String phoneNumber="";
	
	private String userName ="";
	private String password = "";
	private String email ="";
	private String securityQuestion="";
	private String securityQuestionAnswer="";
	
	
	public User() {
		
	}

	public User(String firstName, String lastName, String SSN, String streetAddress, String city, String state,
			int zipCode, String phoneNumber, String userName, String password, String email, String securityQuestion, String securityQuestionAnswer ) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.SSN = SSN;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.securityQuestion = securityQuestion;
		this.securityQuestionAnswer = securityQuestionAnswer;
		
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

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getSecurityQuestionAnswer() {
		return securityQuestionAnswer;
	}

	public void setSecurityQuestionAnswer(String securityQuestionAnswer) {
		this.securityQuestionAnswer = securityQuestionAnswer;
	}

	

	
	
	
	
	
	
}
