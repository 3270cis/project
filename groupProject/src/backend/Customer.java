package backend;



public class Customer extends User {
	
	//WHAT DOES THE CUSTOMER NEED TO HAVE ?
	//it already inherits the User class.
	//maybe a customer id?
	
	private String firstName ="";
	private String lastName = "";
	private String SSN = "";
	private String streetAddress = "";
	private String city = "";
	private String state = "";
	private String zipCode;
	private String phoneNumber="";
	
	private String userName ="";
	private String password = "";
	private String email ="";
	private String securityQuestion="";
	private String securityQuestionAnswer="";
	
	private int customerID;

	
	
	
	Customer(){
		
	}
	
	
	
	public Customer(String firstNameString, String lastNameString, String sSNString, String streetAddressString,
			String cityString, String stateString, String zipCodeString, String phoneNumberString,
			String usernameString, String passwordString, String emailString, String securityQuestionString,
			String securityQuestionAnswerString) {
		
		this.firstName = firstNameString;
		this.lastName = lastNameString;
		this.SSN = sSNString;
		this.streetAddress = streetAddressString;
		this.city = cityString;
		this.state = stateString;
		this.zipCode = zipCodeString;
		this.phoneNumber = phoneNumberString;
		this.userName = usernameString;
		this.password = passwordString;
		this.email = emailString;
		this.securityQuestion = securityQuestionString;
		this.securityQuestionAnswer = securityQuestionAnswerString;
		
		
		// TODO Auto-generated constructor stub
	}
	
	
	

	public int getCustomerID() {
		return customerID;
	}



	public void setCustomerID(int customerID) {
		this.customerID = customerID;
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

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
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
