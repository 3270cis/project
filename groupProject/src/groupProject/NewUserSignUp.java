package groupProject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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

	@Override
	public void start(Stage primaryStage) throws Exception {

	window = primaryStage;
	
	GridPane grid = new GridPane();
	grid.setPadding(new Insets(10, 10, 10,10));
	
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
	TextField passwordInput = new TextField();
	TextField emailInput = new TextField();
	emailInput.setPromptText("example@emailDomain.com");
	TextField securityQuestionInput = new TextField();
	TextField securityQuestionAnswerInput = new TextField();
	
	
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
	
	
	
	
	
	
	grid.getChildren().addAll(firstName, firstNameInput, lastName, lastNameInput, SSN, SSNInput, streetAddress, streetAddressInput, city, cityInput
			,state, stateInput, zipCode, zipCodeInput, phoneNumber, phoneNumberInput );
	
	
	Scene scene = new Scene(grid, 700, 500);
	window.setScene(scene);
	window.setTitle("HelloWorld Register");
	window.show();
	
	
	
	
	
	}

}
