package GUI;

import backend.ValueObject;
import database2.DatabaseObject;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SecurityQuestionMenu extends Application {

	Stage window;
	String secQuestion;
	static String username;
	
	public SecurityQuestionMenu(String secQuestion, String username) {
		
		this.secQuestion = secQuestion;
		SecurityQuestionMenu.username = username;

	}

	public String getSecQuestion() {
		return secQuestion;
	}



	public void setSecQuestion(String secQuestion) {
		this.secQuestion = secQuestion;
	}



	public static String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		SecurityQuestionMenu.username = username;
	}



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
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setPadding(new Insets(10, 10, 10, 10));
		
		DatabaseObject dataObj = new DatabaseObject();
		secQuestion = dataObj.getSecurityQuestionDB(SecurityQuestionMenu.getUsername());
		
		Label secQuestionLabel = new Label(secQuestion);
		grid.add(secQuestionLabel, 4, 4);
		
		TextField secQuestionInput = new TextField();
		secQuestionInput.setPromptText("answer");
		grid.add(secQuestionInput, 4, 5);
		
		Button submitButton = new Button("Submit");
		grid.add(submitButton, 5, 5);
		
		Button backToLoginButton = new Button("Back to Login");
		grid.add(backToLoginButton, 0, 5);
		
		submitButton.setOnAction(event -> {
			ValueObject valObj = new ValueObject();
			
			//checks if the user's answer matches in the database
			if (valObj.checkAnswer(secQuestionInput.getText()) ) {
				
				DatabaseObject dataObj2 = new DatabaseObject();
				
				AlertBox aBox = new AlertBox();
				aBox.displayMessage("your password is: " + dataObj2.getPasswordDB(SecurityQuestionMenu.getUsername()) );
				
			}
			
			else {
				
				AlertBox aBox = new AlertBox();
				aBox.displayMessage("wrong answer");
				
			}
		});
		
		backToLoginButton.setOnAction(event -> {
			Login login = new Login();
			try {
				login.start(window);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		Scene scene = new Scene(grid, 700, 300);
		window.setScene(scene);
		window.setTitle("HelloWorld Airlines Security Question");
		window.show();
		
		
		
	}
	
	

}
