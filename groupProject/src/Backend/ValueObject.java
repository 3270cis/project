package Backend;


import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import Database1.DatabaseObject;
import javafx.scene.control.TextField;

public class ValueObject {
	
	public ValueObject(){
		
	}
	
	public boolean doesUsernameExist(String username) {
		
		DatabaseObject dataObj = new DatabaseObject();
		
			if (dataObj.doesUsernameExistInDB(username)) {
				return true;
			}
			
			else {
				return false;
			}
	}
	
	
	public void createNewUser(String firstNameString, String lastNameString, String SSNString, 
			  String streetAddressString, String cityString, String stateString,
			  String zipCodeString, String countryString, String phoneNumberString,
			  String usernameString, String passwordString, String emailString,
			  String securityQuestionString,String securityQuestionAnswerString ) {
		
		User newCustomer = new Customer(firstNameString, lastNameString);
		newCustomer.setFirstName(firstNameString);
		newCustomer.setLastName(lastNameString);
		newCustomer.setUserID(newCustomer.getUserID());
		newCustomer.setSSN(SSNString);
		newCustomer.setPhoneNumber(phoneNumberString);
		newCustomer.setEmail(emailString);
		newCustomer.setUsername(usernameString);
		newCustomer.setPassword(passwordString);
		
		Address newAddress = new Address(streetAddressString, cityString, stateString,
										zipCodeString, countryString);
		
		newAddress.setStreetAddress(streetAddressString);
		newAddress.setCity(cityString);
		newAddress.setState(stateString);
		newAddress.setZipCode(zipCodeString);
		newAddress.setCountry(countryString);
		
		PasswordRetreival passRetr = new PasswordRetreival();
		passRetr.setSecurityQuestion(securityQuestionString);
		passRetr.setSecurityQuestionAnswer(securityQuestionAnswerString);
		
		
		DatabaseObject dataObj = new DatabaseObject();
		dataObj.createNewCustomerInDB(newCustomer, newAddress, passRetr);
		
		
	}
	
	public boolean checkLoginCredentials(String username, String password) {
		
		DatabaseObject dataObj = new DatabaseObject();
			
		if(dataObj.isCorrectLoginCredentials(username, password)) {
			
			return true;
		}
		
		else {
			return false;
		}
		
	}
	
	public boolean isCorrectAdminCredentials(String username, String password) {
		
		DatabaseObject dataObj = new DatabaseObject();
			
		//the field cannot be empty
		if(!username.isEmpty() && !password.isEmpty()) {
			
			if(dataObj.isCorrectAdminCredentialsInDB(username, password)){
				System.out.println("sucess admin");
				return true;
				
			}
		
			else {
				return false;
			}
		}
		
		return false;
	}
	
/*	
	public boolean checkAnswer(String answer) {
		
		DatabaseObject dataObj = new DatabaseObject();
		
		if (dataObj.doesAnswerMatchInDB(answer)) {
			
			return true;
			
		}
		
		else {
			
			return false;
		}
		
	}*/
	
/*	public boolean isNumber(String num) {
		
		try {
			Integer.parseInt(num);
			return true;
			
		}catch(NumberFormatException ex) {
			ex.printStackTrace();
			return false;
		}	
	}*/
	
	public boolean isValidZipCode(String zipCodeInput) {
		
		if(zipCodeInput.length() == 5) {
			
			try {
				Integer.parseInt(zipCodeInput);
				return true;
			
			}catch(NumberFormatException ex) {
				ex.printStackTrace();
				return false;
			}	
		}
		else {
			return false;
		}
	}

	
	@SuppressWarnings("deprecation")
/*	A program element annotated @Deprecated is one that programmers are discouraged from using,
	typically because it is dangerous, or because a better alternative exists. 
	Compilers warn when a deprecated program element is used or overridden in non-deprecated code.*/
	
	//the customer can't choose today's date and before for their flight
	public boolean didCustomerInputFromToAndDateCorrect(String from, String to, String flightDate) {
		
		Date date1;
		Date date2;
		try {
			
			date1 = new Date(flightDate);
			date2 = new Date();
			
			//if the flight is before today's date OR if the flight is today, return false;
			if(date1.before(date2) || date1.equals(date2)) {
				
				System.out.println("flight date: " + date1);
				System.out.println("today date: " +date2);
				return false;
			}	
				//if both departure city and destination match, return false
			if (from.equals(to)) {
				return false;
			} 

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("check customer input method");
		}
		
		return true;
	}
	
	
	public boolean isValidPhoneNumber(String phoneNumber) {
		
		boolean isValid = false;
		
		ArrayList<String> array = new ArrayList<>();
		array.add(phoneNumber);
		
		   /* Following are valid phone number examples */             
        //"(111)1234567", "1111111111", "333-222-0000", "(444)454-8231",
		
		// 10 digits, 3 digits times 2 with 2 dahes
		String pattern = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";  
		
		//for each input in the array
		for (String input : array) {
			
			if (input.matches(pattern)) {
				System.out.println("1");
				isValid = true;
			}
			else {
				System.out.println("2");
				isValid = false;
			}
		}
		System.out.println("3");
		return isValid;
	
	}

	public boolean isCorrectInputForPasswordRetrieval(String username, String secQuestion, String secAnswer) {
		
		DatabaseObject dataObj = new DatabaseObject();

			if(dataObj.doesUsernameQuestionAndAnswerMatch(username, secQuestion, secAnswer)) {
				return true;	
			}
			
			else {
			
				return false;
				
			}
	}
	
	
	
	public boolean isValidSocialSecurity(String ssn) {
		
		
		boolean isValid = false;
		
		ArrayList<String> array = new ArrayList<>();
		array.add(ssn);
		
		String pattern = "\\d{9}|\\d{3}\\-\\d{2}\\-\\d{4}";
		
		for (String input : array) {
			
			if (input.matches(pattern)) {
				System.out.println("1");
				isValid = true;
			}
			else {
				System.out.println("2");
				isValid = false;
			}
		}
		System.out.println("3");
		return isValid;
		
		
		
	}

	public boolean isEmailValid(String email) {
		
	boolean isValid = false;
		
		ArrayList<String> array = new ArrayList<>();
		array.add(email);

		String pattern = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
	
		for (String input : array) {
			
			if (input.matches(pattern)) {
				System.out.println("1");
				isValid = true;
			}
			else {
				System.out.println("2");
				isValid = false;
			}
		}
		System.out.println("3");
		return isValid;
	}
		
		
	

}
