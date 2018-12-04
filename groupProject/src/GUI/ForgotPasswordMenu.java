package GUI;

import Backend.ValueObject;
import Database1.DatabaseObject;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
	
	Button backToLoginButton;
	Button getPassButton;
	Button submitButton;
	
	Label secQuestionLabel;
	TextField secQuestionAnswerInput;
	
	ComboBox<String> listOfSecQuestion;
	
	
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
		secQuestionLabel = new Label("Select security question:");
		
		usernameInput = new TextField();
		usernameInput.setPromptText("username"); 
		
		backToLoginButton = new Button("Back to Login");
		submitButton = new Button("Submit");
		secQuestionAnswerInput = new TextField();
		secQuestionAnswerInput.setPromptText("answer");
		
		listOfSecQuestion = new ComboBox<>();
		listOfSecQuestion.getItems().addAll("What is your favorite class?", "What is your favorite food?", "What city were you born?");
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(10);
		
		grid.add(label, 0, 0);
		grid.add(usernameLabel, 0, 1);
		grid.add(usernameInput, 0, 2);
		grid.add(secQuestionLabel, 0, 3);
		grid.add(listOfSecQuestion, 0, 4);
		grid.add(secQuestionAnswerInput, 0, 5);
		grid.add(submitButton, 0, 6);
		grid.add(backToLoginButton, 0, 8);
		
		submitButton.setOnAction(event -> {
			
			ValueObject valObj = new ValueObject();
			AlertBox aBox1;
			AlertBox aBox2;
			
			if (valObj.isCorrectInputForPasswordRetrieval(usernameInput.getText(), 
												listOfSecQuestion.getValue(), secQuestionAnswerInput.getText())) {
				
					
					DatabaseObject dataObj = new DatabaseObject();
				
					aBox1 = new AlertBox();
					aBox1.displayMessage("your password is: " + dataObj.getPasswordDB(usernameInput.getText()));
			
			}
			
			else {
				
				aBox2 = new AlertBox();
				aBox2.displayMessage("Check your inputs!");
				
			}

		});
		
		
		backToLoginButton.setOnAction(event -> {
			Login_1 login = new Login_1();
			try {
				login.start(window);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		
		Scene scene = new Scene(grid, 700, 300);
		window.setScene(scene);
		window.setTitle("HelloWorld Airlines Forgot Password");
		window.show();
		
		
	}


}
