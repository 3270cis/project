package GUI;

import java.util.ArrayList;

import Backend.User;
import Backend.ValueObject;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class NewUserSignUp extends Application {
	
	Stage window;
	
	//creates all the labels
	Label firstName;
	Label lastName;
	Label SSN;
	Label streetAddress;
	Label city;
	Label state;
	Label zipCode;
	Label country;
	Label phoneNumber;
	Label Glad; //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
	
	Label username;
	Label password;
	Label email;
	Label securityQuestion;
	Label securityQuestionAnswer;
	
	//creates all the text box with examples inside the box fields
	TextField firstNameInput;
	TextField lastNameInput;
	TextField SSNInput;
	TextField streetAddressInput;
	TextField cityInput;
	TextField stateInput;
	TextField zipCodeInput;
	TextField countryInput;
	TextField phoneNumberInput;
	
	TextField usernameInput;
	PasswordField passwordInput;
	TextField emailInput;
	TextField securityQuestionInput;
	TextField securityQuestionAnswerInput;
	
	Button createAcctButton;
	Button backToLoginButton;
	
	ComboBox<String> listOfState;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void init() throws Exception {
		
		super.init();
	}
	
	//starts the program
	@Override
	public void start(Stage primaryStage) throws Exception {

	window = primaryStage;
	
	//creates the gridpane window
	GridPane grid = new GridPane();
	grid.setPadding(new Insets(10, 10, 10,10));
	grid.setVgap(5);
	grid.setHgap(10);
	grid.setAlignment(Pos.BASELINE_CENTER);
	
	createAcctButton = new Button("Create Account");
	GridPane.setConstraints(createAcctButton, 1, 19);
	
	backToLoginButton = new Button("Back to Login");
	GridPane.setConstraints(backToLoginButton, 0, 19);
	
	//creates all the labels
	firstName = new Label("first name : ");
	lastName = new Label("last name : ");
	SSN = new Label("SSN : ");
	streetAddress = new Label("street address: ");
	city = new Label("city : ");
	state = new Label("state : ");
	zipCode = new Label("zip-code : ");
	country = new Label("country");
	phoneNumber = new Label("Phone Number: ");
	
	username = new Label("username: ");
	password = new Label("password : ");
	email = new Label("email : ");
	securityQuestion = new Label("security question : ");
	securityQuestionAnswer = new Label("security question answer: ");
	
	//creates all the text box with examples inside the box fields
	firstNameInput = new TextField();
	firstNameInput.setPromptText("Jane");
	lastNameInput = new TextField();
	lastNameInput.setPromptText("Smith");
	SSNInput = new TextField();
	SSNInput.setPromptText("123-45-6789");
	streetAddressInput = new TextField();
	streetAddressInput.setPromptText("35 Broad Street");
	cityInput = new TextField();
	cityInput.setPromptText("Atlanta");
	/*stateInput = new TextField();
	stateInput.setPromptText("GA");*/
	zipCodeInput = new TextField();
	zipCodeInput.setPromptText("30303");
	countryInput = new TextField();
	phoneNumberInput = new TextField();
	phoneNumberInput.setPromptText("000-000-0000");
	
	usernameInput = new TextField();
	passwordInput = new PasswordField();
	emailInput = new TextField();
	emailInput.setPromptText("example@email.com");
	securityQuestionInput = new TextField();
	securityQuestionAnswerInput = new TextField();
	
	 listOfState = new ComboBox<>();
	 listOfState.getItems().addAll("AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DC", "DE", "FL", "GA", "HI", "IA", "ID", 
	    							"IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO", "MS", "MT", "NC", 
	    							"ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", 
	    							"TX", "UT", "VA", "VT", "WA", "WI", "WV", "WY");
	
	//saying where each textfield and labels should go
	//how do you make it pretty?
	GridPane.setConstraints(firstName, 0, 1);
	GridPane.setConstraints(firstNameInput, 0, 2);
	GridPane.setConstraints(lastName, 0, 3);;
	GridPane.setConstraints(lastNameInput, 0, 4);
	GridPane.setConstraints(SSN, 0, 5);
	GridPane.setConstraints(SSNInput, 0, 6);
	GridPane.setConstraints(streetAddress, 0, 7);;
	GridPane.setConstraints(streetAddressInput, 0, 8);
	GridPane.setConstraints(city, 0, 9);
	GridPane.setConstraints(cityInput, 0, 10);
	GridPane.setConstraints(state, 0, 11);;
	GridPane.setConstraints(listOfState, 0, 12);
	GridPane.setConstraints(zipCode, 0, 13);;
	GridPane.setConstraints(zipCodeInput, 0, 14);
	GridPane.setConstraints(country, 0, 15);
	GridPane.setConstraints(countryInput, 0, 16);
    GridPane.setConstraints(phoneNumber, 0, 17);
    GridPane.setConstraints(phoneNumberInput, 0, 18);
    
	GridPane.setConstraints(username, 1, 1);
	GridPane.setConstraints(usernameInput, 1, 2);;
	GridPane.setConstraints(password, 1, 3);
    GridPane.setConstraints(passwordInput, 1, 4);;
    GridPane.setConstraints(email, 1, 5);
	GridPane.setConstraints(emailInput, 1, 6);;
	GridPane.setConstraints(securityQuestion, 1, 7);
    GridPane.setConstraints(securityQuestionInput, 1, 8);
    GridPane.setConstraints(securityQuestionAnswer, 1, 9);
    GridPane.setConstraints(securityQuestionAnswerInput, 1, 10);
    

	
	//adding all the textfields and labels into the grid 
  //creating a scene of a certain size, and adding the grid on it
	grid.getChildren().addAll(firstName, firstNameInput, lastName, lastNameInput, 
							SSN, SSNInput, streetAddress, streetAddressInput, city, cityInput,
							state, listOfState, zipCode, zipCodeInput, country, countryInput, 
							phoneNumber, phoneNumberInput, username, usernameInput, password, passwordInput, email, emailInput ,
							securityQuestion,securityQuestionInput, securityQuestionAnswer, securityQuestionAnswerInput, 
							createAcctButton, backToLoginButton );

	createAcctButton.setOnAction(event -> {
		
		ValueObject valObj = new ValueObject();
		AlertBox aBox1;
		AlertBox aBox2;
		AlertBox aBox3;
		
		//checks zipcode...maybe i need a method that passes and checks all the inputs at the same time -__- , why didn't i do that earlier? fail
		//or maybe just past in some of the items at a time, have methods for checking strings and not string inputs
		//check fields inputs to make sure they're not left blank
		if(valObj.isValidZipCode(zipCodeInput.getText()) || valObj.isValidPhoneNumber(phoneNumberInput.getText()) ) {
		
			if (valObj.doesUsernameExist((usernameInput.getText()))) {
			
				aBox1 = new AlertBox();
				aBox1.displayMessage(usernameInput.getText() + " username is taken!");
				
			}
		
			//create the new user customer
			else {
				//this code was making the user inputs into strings and passing all the strings into valueobject.
				/*String firstNameString = firstNameInput.getText();
				String lastNameString = lastNameInput.getText();
				String SSNString = SSNInput.getText();
				String streetAddressString = streetAddressInput.getText();
				String cityString = cityInput.getText();
				String stateString = ( ((TextField)listOfState.getEditor()).getText() ); //dropdox box to string
				String zipCodeString = zipCodeInput.getText();
				String countryString = countryInput.getText();
				String phoneNumberString = phoneNumberInput.getText();
				
				String usernameString = usernameInput.getText();
				String passwordString = passwordInput.getText();
				String emailString = emailInput.getText();
				String securityQuestionString = securityQuestionInput.getText();
				String securityQuestionAnswerString = securityQuestionAnswerInput.getText();*/
				
				/*valObj.createNewUser(firstNameString, lastNameString, SSNString, streetAddressString, cityString, stateString,
										zipCodeString,countryString, phoneNumberString, usernameString, passwordString,
										emailString, securityQuestionString, securityQuestionAnswerString);*/
				
				
				
				valObj.createNewUser(firstNameInput.getText(), lastNameInput.getText(), SSNInput.getText(), streetAddressInput.getText(), cityInput.getText(),  
									listOfState.getValue(), zipCodeInput.getText(), countryInput.getText(), phoneNumberInput.getText(),
									usernameInput.getText(), passwordInput.getText(), emailInput.getText(), 
									securityQuestionInput.getText(), securityQuestionAnswerInput.getText());
				
				
				/*valObj.createNewUser(customerArray, addressArray, passwordRereivalArray);*/
				
				/*aBox2 = new AlertBox();
				aBox2.displayMessage("Account Created!");*/
				
				clearTextFields();
			}
		}
		
		else {
			aBox3 = new AlertBox();
			aBox3.displayMessage("Please check number format in zip code or phone number");
		}
		
	});
	
	
	backToLoginButton.setOnAction(event -> {
		Login log = new Login();
		try {
			log.start(window);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	});
	
	Scene scene = new Scene(grid, 380, 550 );
	window.setScene(scene);
	window.setTitle("HelloWorld Register");
	window.show();
	
	
	}
	
	public void clearTextFields() {
	firstNameInput.clear();
	lastNameInput.clear();
	SSNInput.clear();
	streetAddressInput.clear();
	cityInput.clear();
	//stateInput.clear();
	zipCodeInput.clear();
	phoneNumberInput.clear();
	
	usernameInput.clear();
	passwordInput.clear();
	emailInput.clear();
	securityQuestionInput.clear();
	securityQuestionAnswerInput.clear();
	}
	
	
	//ignore, should i use this method or would it make it more confusing?
	public String getsTheTextFieldAsAString(String s) {
		
		TextField test = new TextField(s);
		
		return test.getText();
	}

}
