package GUI;

import Backend.ValueObject;
import Database1.DatabaseObject;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ForgotPasswordMenu extends Application {
	
	Stage window;
	String secQuestion = null;
	
	Label label;
	Label usernameLabel;
	TextField usernameInput;
	
	Button getSecButton;
	Button backToLoginButton;
	Button getPassButton;
	
	Label secQuestionLabel;
	TextField secQuestionAnswerInput;
	
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
		
		label = new Label("Enter your username and click sumbit, then answer the security question to retrieve your password.");
		usernameLabel = new Label("Enter Username: ");
		
		usernameInput = new TextField();
		usernameInput.setPromptText("username"); 
		
		getSecButton = new Button("Get Security Question");
		backToLoginButton = new Button("Back to Login");
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setPadding(new Insets(10, 10, 10, 10));
		
		grid.add(label, 0, 0);
		grid.add(usernameLabel, 0, 1);
		grid.add(usernameInput, 0, 2);
		grid.add(getSecButton, 3, 2);
		grid.add(backToLoginButton, 0, 3);
		
		getSecButton.setOnAction(event -> {
			
			ValueObject valObj = new ValueObject();
			
			if (valObj.doesUsernameExist(usernameInput.getText())) {
				
				
				DatabaseObject dataObj;dataObj = new DatabaseObject();
				secQuestion = dataObj.getSecurityQuestionDB(usernameInput.getText());
				
				getPassButton = new Button("Get Your Password");
				secQuestionLabel = new Label(secQuestion);
				secQuestionAnswerInput = new TextField();
				secQuestionAnswerInput.setPromptText("enter your aswer");
				grid.add(getPassButton, 2, 3);
				grid.add(secQuestionLabel, 2, 2);
				grid.add(secQuestionAnswerInput, 2, 4);
				
			
			}
			
			else {
				
				AlertBox aBox = new AlertBox();
				aBox.displayMessage("Invalid username");
				
			}
		});
		
		
		getPassButton.setOnAction(event -> {
			
			//LOOK, HOW TO MAKE SURE THE USER ACTUALLY INPUTS SOMETHINGN AND NOT LEFT BLANK?
			
			
		});
		
		
		backToLoginButton.setOnAction(event -> {
			Login login = new Login();
			try {
				login.start(window);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		/*grid.getChildren().addAll(label, usernameLabel, usernameInput, submitButton);*/
		
		Scene scene = new Scene(grid, 700, 300);
		window.setScene(scene);
		window.setTitle("HelloWorld Airlines Forgot Password");
		window.show();
		
		
	}


}
