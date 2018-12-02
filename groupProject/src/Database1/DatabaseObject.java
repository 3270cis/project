package Database1;

//lucid
//nocozubi@autowb.com user
//thisisthepassword? pass


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Backend.Customer;

public class DatabaseObject {
	
	static Connection connection;
	
	public DatabaseObject(){
		
	}
	
	public boolean usernameCheckInDB(String username) {
		
		connection = null;
		boolean isUsernameAlreadyTaken = false;
		
		try {
			Class.forName("org.postgresql.Driver");
			//connection to database
			Connection connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AirlineDatabase", "postgres", "passpass");
			System.out.println("Database Connected :) 1");
			
			String quertyString = "select * from customerairline ";
			String usernameColumnInDB = "username";
			
			//create statement
			PreparedStatement preStatement = connect.prepareStatement(quertyString);
			
			//execute SQL query
			ResultSet rSet = preStatement.executeQuery();
			
			//check if the username already exists in the database and return true / false
			while (rSet.next()) {
		
				//its going to get the string from the 'username' column in the DB and assign it to usernameFromDB
				String usernameFromDB = rSet.getString(usernameColumnInDB);
				
				//checks if the username that was inputed into the method equals the username from the DB
				if (username.equals(usernameFromDB)) {
					
					//if it equals then the username is already taken
					isUsernameAlreadyTaken = true;
					break;
				}
				
				else {
					//if it's not taken, then the username is available
					isUsernameAlreadyTaken = false;
				}
			}
		}
			catch (Exception exception) {
				exception.printStackTrace();
			}
		
		System.out.println("congrats, usernameCheckInDB method");
		return isUsernameAlreadyTaken;
		
	}
	
	public void createNewCustomerInDB(Customer newCustomer) {
		
		try {
			Class.forName("org.postgresql.Driver");
			//connection to database
			Connection connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AirlineDatabase", "postgres", "passpass");
			System.out.println("Database Connected :) 2");
			
			String quertyString = "INSERT INTO customerairline (firstname, lastname, ssn, streetaddress, city, state, zipcode, phonenumber, "
									+ "username, upassword, email, securityquestion, securityquestionanswer)"
									+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)  "; 	
			//create statement
			PreparedStatement preStatement = connect.prepareStatement(quertyString);
			
			preStatement.setString(1, newCustomer.getFirstName() );
			preStatement.setString(2, newCustomer.getLastName());
			preStatement.setString(3, newCustomer.getSSN());
			preStatement.setString(4, newCustomer.getStreetAddress());
			preStatement.setString(5, newCustomer.getCity());
			preStatement.setString(6, newCustomer.getState());
			preStatement.setString(7, newCustomer.getZipCode());
			preStatement.setString(8, newCustomer.getPhoneNumber());
			preStatement.setString(9, newCustomer.getUserName());
			preStatement.setString(10, newCustomer.getPassword());
			preStatement.setString(11, newCustomer.getEmail());
			preStatement.setString(12, newCustomer.getSecurityQuestion());
			preStatement.setString(13, newCustomer.getSecurityQuestionAnswer());
			//execute SQL query
			preStatement.executeUpdate();
			
			
			System.out.println("congrats createNewCustomerInDB method");
		}
			catch (Exception exception) {	
				exception.printStackTrace();
			}
		
		
	}

	public boolean isCorrectLoginCredentials(String username, String password) {
	
		boolean userAndPassMatch = false;
		
		try {
			Class.forName("org.postgresql.Driver");
			//connection to database
			Connection connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AirlineDatabase", "postgres", "passpass");
			System.out.println("Database Connected :) 3");
			
			String quertyString = "SELECT username, upassword FROM customerairline";	
			//create statement
			PreparedStatement preStatement = connect.prepareStatement(quertyString);
			ResultSet rSet = preStatement.executeQuery();
			
			while (rSet.next()) {
				String usernameInDB = rSet.getString("username"); //the username column in the DB
				String upasswordInDB = rSet.getString("upassword"); //the upassword column in the DB
				
				if(username.equals(usernameInDB) && password.equals(upasswordInDB)) {
					userAndPassMatch = true;
					System.out.println("sucessful login");
					break;
				}
			}
		
		}
			catch (Exception exception) {	
				exception.printStackTrace();
			}
		
		return userAndPassMatch;
		
	}

	public String getSecurityQuestionDB(String username) {
		
		String secQuestion = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			//connection to database
			Connection connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AirlineDatabase", "postgres", "passpass");
			System.out.println("Database Connected :) 4");
			
			String quertyString = "SELECT username, securityquestion FROM customerairline";	
			//create statement
			PreparedStatement preStatement = connect.prepareStatement(quertyString);
			ResultSet rSet = preStatement.executeQuery();
			
			while(rSet.next()) {
				
				String usernameInDB = rSet.getString("username");
				
				if(username.equals(usernameInDB)) {
					secQuestion = rSet.getString("securityquestion");
					break;
				}
				
			}	
		} 
			
		catch (Exception exception) {	
			exception.printStackTrace();
		}
		
		return secQuestion;
		
	}

	public boolean doesAnswerMatchInDB(String answer) {
		
		boolean answerMatch = false;
		
		try {
			Class.forName("org.postgresql.Driver");
			//connection to database
			Connection connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AirlineDatabase", "postgres", "passpass");
			System.out.println("Database Connected :) 5");
			
			String quertyString = "SELECT securityquestion, securityquestionanswer FROM customerairline";	
			//create statement
			PreparedStatement preStatement = connect.prepareStatement(quertyString);
			ResultSet rSet = preStatement.executeQuery();
			
			
			while(rSet.next()) {
				
				String secAnswerInDB = rSet.getString("securityquestionanswer");
				
				if(answer.equalsIgnoreCase(secAnswerInDB)) {
					answerMatch =  true;
				}
			}
		}	
		
		catch (Exception exception) {	
				exception.printStackTrace();
		}
		
		return answerMatch;	
	}
	
	public String getPasswordDB(String username) {
		
		String upassword = null;
	
		try {
			Class.forName("org.postgresql.Driver");
			//connection to database
			Connection connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AirlineDatabase", "postgres", "passpass");
			System.out.println("Database Connected :) 6");
			
			String quertyString = "SELECT username, upassword FROM customerairline";	
			//create statement
			PreparedStatement preStatement = connect.prepareStatement(quertyString);
			ResultSet rSet = preStatement.executeQuery();
			
			while(rSet.next()) {
			String usernameInDB = rSet.getString("username"); 
			String upasswordInDB = rSet.getString("upassword"); 
			
			if(username.equals(usernameInDB)) {
				upassword = upasswordInDB;
				break;
			}
			
			}
		}	
		
		catch (Exception exception) {	
				exception.printStackTrace();
		}
		
		return upassword;
		
	}
}
	

/*	public void createNewCustomerInDB(String firstNameString, String lastNameString, String SSNString, String streetAddressString, String cityString, String stateString,
			String zipCodeString, String phoneNumberString, String usernameString, String passwordString, String emailString,String securityQuestionString,String securityQuestionAnswerString) {
	
			preStatement.setString(1, firstNameString );
			preStatement.setString(2, lastNameString);
			preStatement.setString(3, SSNString);
			preStatement.setString(4, streetAddressString);
			preStatement.setString(5, cityString);
			preStatement.setString(6, stateString);
			preStatement.setString(7, zipCodeString);
			preStatement.setString(8, phoneNumberString);
			preStatement.setString(9, usernameString);
			preStatement.setString(10, passwordString);
			preStatement.setString(11, emailString);
			preStatement.setString(12, securityQuestionString);
			preStatement.setString(13, securityQuestionAnswerString);
		
	}*/

