package GUI;

import backend.User;
import backend.ValueObject;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class NewUserSignUp extends Application {
	
	Stage window;
	
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
	
	Button createAcctButton = new Button("Create Account");
	GridPane.setConstraints(createAcctButton, 1, 17);
	
	Button backToLoginButton = new Button("Back to Login");
	GridPane.setConstraints(backToLoginButton, 0, 18);
	
	
	//creates all the labels
	Label firstName = new Label("first name : ");
	Label lastName = new Label("last name : ");
	Label SSN = new Label("SSN : ");
	Label streetAddress = new Label("street address: ");
	Label city = new Label("city : ");
	Label state = new Label("state : ");
	Label zipCode = new Label("zip-code : ");
	Label phoneNumber = new Label("Phone Number: ");
	
	Label username = new Label("username: ");
	Label password = new Label("password : ");
	Label email = new Label("email : ");
	Label securityQuestion = new Label("security question : ");
	Label securityQuestionAnswer = new Label("security question answer: ");
	
	//creates all the text box with examples inside the box fields
	TextField firstNameInput = new TextField();
	firstNameInput.setPromptText("Jane");
	TextField lastNameInput = new TextField();
	lastNameInput.setPromptText("Smith");
	TextField SSNInput = new TextField();
	SSNInput.setPromptText("123-45-6789");
	TextField streetAddressInput = new TextField();
	streetAddressInput.setPromptText("35 Broad Street");
	TextField cityInput = new TextField();
	cityInput.setPromptText("Atlanta");
	TextField stateInput = new TextField();
	stateInput.setPromptText("GA");
	TextField zipCodeInput = new TextField();
	zipCodeInput.setPromptText("30303");
	TextField phoneNumberInput = new TextField();
	phoneNumberInput.setPromptText("000-000-0000");
	
	TextField usernameInput = new TextField();
	PasswordField passwordInput = new PasswordField();
	TextField emailInput = new TextField();
	emailInput.setPromptText("example@email.com");
	TextField securityQuestionInput = new TextField();
	TextField securityQuestionAnswerInput = new TextField();
	
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
	GridPane.setConstraints(stateInput, 0, 12);
	GridPane.setConstraints(zipCode, 0, 13);;
	GridPane.setConstraints(zipCodeInput, 0, 14);
    GridPane.setConstraints(phoneNumber, 0, 15);
    GridPane.setConstraints(phoneNumberInput, 0, 16);
    
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
	grid.getChildren().addAll(firstName, firstNameInput, lastName, lastNameInput, SSN, SSNInput, streetAddress, streetAddressInput, city, cityInput
			,state, stateInput, zipCode, zipCodeInput, phoneNumber, phoneNumberInput, username, usernameInput, password, passwordInput, email, emailInput
			,securityQuestion,securityQuestionInput, securityQuestionAnswer, securityQuestionAnswerInput, createAcctButton, backToLoginButton );
	
	
	createAcctButton.setOnAction(event -> {
		
		ValueObject valObj = new ValueObject();
		
	
		if (valObj.doesUsernameExist((usernameInput.getText()))) {
			
			AlertBox abox = new AlertBox();
			abox.alertUsernameTaken(usernameInput.getText());
			//what next?
		}
		
		//create the new user customer
		else {
			
			String firstNameString = firstNameInput.getText();
			String lastNameString = lastNameInput.getText();
			String SSNString = SSNInput.getText();
			String streetAddressString = streetAddressInput.getText();
			String cityString = cityInput.getText();
			String stateString = stateInput.getText();
			String zipCodeString = zipCodeInput.getText();
			String phoneNumberString = phoneNumberInput.getText();
			
			String usernameString = usernameInput.getText();
			String passwordString = passwordInput.getText();
			String emailString = emailInput.getText();
			String securityQuestionString = securityQuestionInput.getText();
			String securityQuestionAnswerString = securityQuestionAnswerInput.getText();
			
			//int zipCodeStringToInt = Integer.parseInt(zipCodeString);
			
			valObj.createNewUser(firstNameString, lastNameString, SSNString, streetAddressString, cityString, stateString,
					zipCodeString, phoneNumberString, usernameString, passwordString, emailString, securityQuestionString, securityQuestionAnswerString);
			
		}
		
	});
	
	
	backToLoginButton.setOnAction(event -> {
		Login log = new Login();
		try {
			log.start(window);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	});
	
	Scene scene = new Scene(grid, 300, 500);
	window.setScene(scene);
	window.setTitle("HelloWorld Register");
	window.show();
	
	
	}
	
	
	//ignore, should i use this method or would it make it more confusing?
	public String getsTheTextFieldAsAString(String s) {
		
		TextField test = new TextField(s);
		
		return test.getText();
	}

}
