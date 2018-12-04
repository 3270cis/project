package Database1;

//lucid
//nocozubi@autowb.com user
//thisisthepassword? pass


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Backend.Address;
import Backend.Customer;
import Backend.PasswordRetreival;
import Backend.User;

public class DatabaseObject {
	
	static Connection connection;
	String databaseURL= "jdbc:postgresql://ec2-54-225-110-156.compute-1.amazonaws.com/d3r14stg9r3fd4";
	String databaseUser = "sahrzfqchvludh";
	String databasePass="906f8f4de585bb493c7078eb472c4cfc91fe2fbbe6f8af6f78f255631429398c";
	
	public DatabaseObject(){
		
	}
	
	public boolean usernameCheckInDB(String username) {
		
		connection = null;
		boolean isUsernameAlreadyTaken = false;
		
		try {
			Class.forName("org.postgresql.Driver");
			//connection to database
			Connection connect = DriverManager.getConnection(databaseURL, databaseUser, databasePass);
			System.out.println("Database Connected :) 1");
			
			String quertyString = "select * from users ";
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
					connect.close();
					break;
				}
				
				else {
					//if it's not taken, then the username is available
					isUsernameAlreadyTaken = false;
					connect.close();
				}
			}
		}
			catch (Exception exception) {
				exception.printStackTrace();
			}
		
		System.out.println("congrats, usernameCheckInDB method");
		return isUsernameAlreadyTaken;
		
	}
	
	//the original method
	/*public void createNewCustomerInDB(Customer newCustomer) {
		
		try {
			Class.forName("org.postgresql.Driver");
			//connection to database
			Connection connect = DriverManager.getConnection(databaseURL, databaseUser, databasePass);
			System.out.println("Database Connected :) 2");
			
			String quertyString = "INSERT INTO users (firstname, lastname, ssn, streetaddress, city, state, zipcode, phonenumber, "
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
		
		
	}*/

	public boolean isCorrectLoginCredentials(String username, String password) {
	
		boolean userAndPassMatch = false;
		
		try {
			Class.forName("org.postgresql.Driver");
			//connection to database
			Connection connect = DriverManager.getConnection(databaseURL, databaseUser, databasePass);
			System.out.println("Database Connected :) 2");
			
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
					connect.close();
					break;
				}
			}
		
		}
			catch (Exception exception) {	
				exception.printStackTrace();
			}
		
		return userAndPassMatch;
		
	}
	
	
	public boolean isCorrectAdminCredentialsInDB(String username, String password) {//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
		try {
			Class.forName("org.postgresql.Driver");
			//connection to database
			Connection connect = DriverManager.getConnection(databaseURL, databaseUser, databasePass);
			System.out.println("Database Connected :) 3");
			
			String quertyString = "SELECT securityquestion, username FROM passwordretrieval";//HAVE TO FIGURE OUT THE ADMIN CREDENTIALS!
			//create statement
			PreparedStatement preStatement = connect.prepareStatement(quertyString);
			ResultSet rSet = preStatement.executeQuery();
			
		} 
			
		catch (Exception exception) {	
			exception.printStackTrace();
		}
		

		
	}

	public String getSecurityQuestionDB(String username) {
		
		String secQuestion = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			//connection to database
			Connection connect = DriverManager.getConnection(databaseURL, databaseUser, databasePass);
			System.out.println("Database Connected :) 4");
			
			String quertyString = "SELECT securityquestion, username FROM passwordretrieval";	
			//create statement
			PreparedStatement preStatement = connect.prepareStatement(quertyString);
			ResultSet rSet = preStatement.executeQuery();
			
			while(rSet.next()) {
				
				String usernameInDB = rSet.getString("username");
				
				if(username.equals(usernameInDB)) {
					secQuestion = rSet.getString("securityquestion");
					connect.close();
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
			Connection connect = DriverManager.getConnection(databaseURL, databaseUser, databasePass);
			System.out.println("Database Connected :) 5");
			
			String quertyString = "SELECT securityquestion, username FROM passwordretrieval";	
			//create statement
			PreparedStatement preStatement = connect.prepareStatement(quertyString);
			ResultSet rSet = preStatement.executeQuery();
			
			
			while(rSet.next()) {
				
				String secAnswerInDB = rSet.getString("securityanswer");
				
				if(answer.equalsIgnoreCase(secAnswerInDB)) {
					answerMatch =  true;
					connect.close();
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
			Connection connect = DriverManager.getConnection(databaseURL, databaseUser, databasePass);
			System.out.println("Database Connected :) 6");
			
			String quertyString = "SELECT username, upassword FROM users";	
			//create statement
			PreparedStatement preStatement = connect.prepareStatement(quertyString);
			ResultSet rSet = preStatement.executeQuery();
			
			while(rSet.next()) {
			String usernameInDB = rSet.getString("username"); 
			String upasswordInDB = rSet.getString("upassword"); 
			
			if(username.equals(usernameInDB)) {
				upassword = upasswordInDB;
				connect.close();
				break;
			}
			
			}
		}	
		
		
		catch (Exception exception) {	
				exception.printStackTrace();
		}
		
		return upassword;
		
	}

	public void createNewCustomerInDB(User newCustomer, Address newAddress, PasswordRetreival passRetr) {
		
		try {
			Class.forName("org.postgresql.Driver");
			//connection to database
			Connection connect1 = DriverManager.getConnection(databaseURL, databaseUser, databasePass);
			System.out.println("Database Connected :) 7");
			
			//well....does that mean i have to create 3 different queries? 
			String quertyString1 = "INSERT INTO users (userid, firstname, lastname, ssn, phonenumber, username, upassword, email) "
									+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)"; 
			
			int temp = 1050; //DELETE ME!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!11!!
			
			//create statement
			PreparedStatement preStatement1 = connect1.prepareStatement(quertyString1);
			preStatement1.setInt(1, temp);
			preStatement1.setString(2, newCustomer.getFirstName() );
			preStatement1.setString(3, newCustomer.getLastName());
			preStatement1.setString(4, newCustomer.getSSN());
			preStatement1.setString(5, newCustomer.getPhoneNumber());
			preStatement1.setString(6, newCustomer.getUsername());
			preStatement1.setString(7, newCustomer.getPassword());
			preStatement1.setString(8, newCustomer.getEmail());
			//execute SQL query
			preStatement1.executeUpdate();
			connect1.close();
			
			Connection connect2 = DriverManager.getConnection(databaseURL, databaseUser, databasePass);
			System.out.println("Database Connected :) 8");
			
			String quertyString2 = "INSERT INTO address (streetaddress, city, state, zipcode, userid, country)"
									+ " VALUES (?, ?, ?, ?, ?, ?)"; 
			
			PreparedStatement preStatement2 = connect2.prepareStatement(quertyString2);
			preStatement2.setString(1, newAddress.getStreetAddress());
			preStatement2.setString(2, newAddress.getCity());
			preStatement2.setString(3, newAddress.getState());
			preStatement2.setString(4, newAddress.getZipCode());
			preStatement2.setInt(5, temp);
			preStatement2.setString(6, newAddress.getCountry());
			preStatement2.executeUpdate();
			connect2.close();
			
			Connection connect3 = DriverManager.getConnection(databaseURL, databaseUser, databasePass);
			System.out.println("Database Connected :) 9");
			
			String quertyString3 = "INSERT INTO passwordretrieval (userid, securityquestion, securityanswer, username)"
									+ " VALUES (?, ?, ?, ?)"; 
			
			PreparedStatement preStatement3 = connect3.prepareStatement(quertyString3);
			preStatement3.setInt(1, temp);
			preStatement3.setString(2, passRetr.getSecurityQuestion());
			preStatement3.setString(3, passRetr.getSecurityQuestionAnswer());
			preStatement3.setString(4, newCustomer.getUsername() );
			
			preStatement3.executeUpdate();
			connect3.close();
			
			System.out.println("congrats createNewCustomerInDB method");
		}
			catch (Exception exception) {	
				exception.printStackTrace();
			}
		
		
		
	}

	public void searchTheDBForFlight(String departureCity, String destination, String date) {
		
		try {
			Class.forName("org.postgresql.Driver");
			//connection to database
			Connection connect = DriverManager.getConnection(databaseURL, databaseUser, databasePass);
			System.out.println("Database Connected :) 10");
			
			String quertyString = "SELECT destination, departurecity FROM flightdetails";	 //WE HAVE TO COME UP WITH CERTAIN DATES IN THE DB
			//create statement
			PreparedStatement preStatement = connect.prepareStatement(quertyString);
			ResultSet rSet = preStatement.executeQuery();
			
			while(rSet.next()) {
			
			}
		}	
		
		catch (Exception exception) {	
				exception.printStackTrace();
		}
		
		
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

