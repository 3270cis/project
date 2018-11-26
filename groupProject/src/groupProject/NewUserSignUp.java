package groupProject;

import javafx.application.Application;
import javafx.geometry.Insets;
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
	
	
	grid.setConstraints(firstName, 0, 1);
	
	}

}
