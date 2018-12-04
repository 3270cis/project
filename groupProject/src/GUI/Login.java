package GUI;
import com.sun.javafx.scene.SceneEventDispatcher;

import Backend.ValueObject;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene; 
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Login extends Application{
	
	Stage window;
	/*Scene loginPage;
	Scene registerPage;*/
	
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
		grid.setVgap(5);
		
		Label helloWorldLabel = new Label("HelloWorld Airlines");
		helloWorldLabel.setStyle("-fx-font-size: 28pt");
		helloWorldLabel.setAlignment(Pos.TOP_CENTER);
		
		Label usernameLabel = new Label("Username: ");
		GridPane.setConstraints(usernameLabel, 0, 1);
		
		TextField usernameInput = new TextField();
		usernameInput.setPromptText("UserID");
		GridPane.setConstraints(usernameInput, 0, 2);
		
		Label passwordLabel = new Label("Password: ");
		GridPane.setConstraints(passwordLabel, 0, 3);
		
		PasswordField passwordInput = new PasswordField();
		passwordInput.setPromptText("password");
		GridPane.setConstraints(passwordInput, 0, 4);
		
		Button loginButton = new Button("Login");
		GridPane.setConstraints(loginButton, 0, 5);
		
		Button newUserButton = new Button("Register");
		GridPane.setConstraints(newUserButton, 0, 6);
		
		Button forgotPasswordButton = new Button("Forgot Password");
		GridPane.setConstraints(forgotPasswordButton, 4, 4);
		
		Button adminLoginInButton = new Button("Admin Login");
		GridPane.setConstraints(adminLoginInButton, 0, 7);
		
		//"register" button should bring up the NewUserSignUp window
		newUserButton.setOnAction(event -> {
			NewUserSignUp signUp = new NewUserSignUp();
			try {
				signUp.start(window);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		//login button should go through the username & pw checks and if it returns true, then open up the flight main menu
		loginButton.setOnAction(event -> {
			ValueObject valObj = new ValueObject();
			
			if (valObj.checkLoginCredentials(usernameInput.getText(), passwordInput.getText())) {
				
				SearchFlightsMainMenu main = new SearchFlightsMainMenu();
				
				try {
					main.start(window);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			else {
				
				AlertBox aBox = new AlertBox();
				aBox.displayMessage("Invalid username or password!");
			}
			
		});
		
		forgotPasswordButton.setOnAction(event -> {
			ForgotPasswordMenu fpmenu = new ForgotPasswordMenu();

			try {
				fpmenu.start(window);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		});
		
		adminLoginInButton.setOnAction(event -> {
			
			
			
			ValueObject valObj = new ValueObject();
			
			if(valObj.isCorrectAdminCredentials(usernameInput.getText(), passwordInput.getText())) {
			
				AdminUser admin = new AdminUser();
				try {
					admin.start(window);
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
			
		});
		
		grid.getChildren().addAll(helloWorldLabel,usernameLabel, usernameInput, passwordLabel, passwordInput, 
									loginButton, newUserButton, forgotPasswordButton,adminLoginInButton);
		
		Scene scene = new Scene(grid, 700, 300);
		window.setScene(scene);
		window.setTitle("HelloWorld Airlines Login");
		window.show();
		
		window.setOnCloseRequest(event -> {
			event.consume(); //need to consume to make sure it doesn't close the program when the user clicks 'No' 
			closeProgram(); //close program method call
		});
		
	}
	
	//this method calls the AlertBoxText.java class. It confirms the user if he/she wants to exit the program.
	public void closeProgram() {
		AlertBox abox = new AlertBox();
		Boolean answer = abox.displayWhenExit("Exit", "Exit the program?");
		if(answer) {
			Platform.exit();
		}
	}
	
	
	
	
}
