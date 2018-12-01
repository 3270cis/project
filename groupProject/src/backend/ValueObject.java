package backend;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import database.DatabaseObject;

public class ValueObject {
	
	public ValueObject(){
		
	}
	
	public boolean usernameCheck(String username) {
		
		/*ArrayList<String> array = new ArrayList<>();*/
		/*array.add(username);
		boolean contains = username.*/
		
		//maybe only require the username to have certain characteres? for example, no '<,>.?/:;"'{[}]|\ '
		
		DatabaseObject dataObj = new DatabaseObject();
		
			if (dataObj.usernameCheckInDB(username) == true) {
				return true;
			}
			
			else {
				return false;
			}
		}
	
	public void createNewUser(String firstNameString, String lastNameString, String SSNString, String streetAddressString, String cityString, String stateString,
			String zipCodeString, String phoneNumberString, String usernameString, String passwordString, String emailString,String securityQuestionString,String securityQuestionAnswerString ) {
		
;
		
		Customer newCustomer = new Customer(firstNameString,  lastNameString,  SSNString,  streetAddressString,  cityString,  stateString,
				 zipCodeString,  phoneNumberString,  usernameString,  passwordString,  emailString, securityQuestionString, securityQuestionAnswerString);
		
		
		DatabaseObject dataObj = new DatabaseObject();
		
		dataObj.createNewCustomerInDB(newCustomer);
		
		/*dataObj.createNewCustomerInDB(newCustomer.getFirstName(),newCustomer.getLastName(),newCustomer.getSSN(),
				newCustomer.getStreetAddress(), newCustomer.getCity(),newCustomer.getState(),
				newCustomer.getZipCode(), newCustomer.getPhoneNumber(), newCustomer.getUserName(), 
				newCustomer.getPassword(), newCustomer.getEmail(), newCustomer.getSecurityQuestion(), newCustomer.getSecurityQuestionAnswer());*/
		
	}

}



//checks string
/*private static boolean charsOK(String s) { 
    String charactersIdontWant = "^àáâãäåçèéêëìíîïğòóôõöùúûüıÿ!&{}¿?.<>~\\()";
    for (char c : charactersIdontWant.toCharArray()) {
        if (s.indexOf(c) != -1) return false;
    }
    return true;

}
public static void main(String[] args) {
    String myString = "thisMayContïain/anything@";
    String myString2 = "thisMayContain/anything@";
    System.out.println(charsOK(myString));
    System.out.println(charsOK(myString2));
}*/