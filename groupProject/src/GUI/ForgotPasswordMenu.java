package GUI;

import backend.ValueObject;
import database.DatabaseObject;
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
		
		Label label = new Label("Enter your username and click sumbit, then answer the security question to retrieve your password.");
		grid.add(label, 0, 0);
		
		Label usernameLabel = new Label("Enter Username: ");
		grid.add(usernameLabel, 0, 1);
		
		TextField usernameInput = new TextField();
		usernameInput.setPromptText("username"); 
		grid.add(usernameInput, 0, 2);
		
		Button submitButton = new Button("Submit");
		grid.add(submitButton, 3, 3);
		
		submitButton.setOnAction(event -> {
			ValueObject valObj = new ValueObject();
			
			if (valObj.doesUsernameExist(usernameInput.getText())) {
				
				DatabaseObject dataObj = new DatabaseObject();
				secQuestion = dataObj.getSecurityQuestionDB(usernameInput.getText());
				
				SecurityQuestionMenu sqMenu = new SecurityQuestionMenu(secQuestion, usernameInput.getText());
				try {
					sqMenu.start(window);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			else {
				
				AlertBox aBox = new AlertBox();
				aBox.displayMessage("Invalid username");
				
			}
		});
		
		/*grid.getChildren().addAll(label, usernameLabel, usernameInput, submitButton);*/
		
		Scene scene = new Scene(grid, 700, 300);
		window.setScene(scene);
		window.setTitle("HelloWorld Airlines Forgot Password");
		window.show();
		
		
	}


}
