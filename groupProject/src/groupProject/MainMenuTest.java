package groupProject;
import com.sun.javafx.scene.SceneEventDispatcher;

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


public class MainMenuTest extends Application{
	
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
		
		//button1 for registering new account
		/*Label label1 = new Label("This is the Main Menu");
		Button button1 = new Button("Login");
		button1.setOnAction(event -> window.setScene(registerPage));
		
		//the layout with the layout and button
		StackPane layout1 = new StackPane();
		layout1.getChildren().addAll(label1, button1);
		loginPage = new Scene(layout1, 300, 300);*/
		
		//button 2 to go back to the login page
		/*Label label2 = new Label("The is the register new account page");
		Button button2 = new Button("Click here to go back to the login page");
		button2.setOnAction(event -> window.setScene(loginPage));*/
		
		/*StackPane layout2 = new StackPane();
		layout2.getChildren().addAll(label2, button2);
		registerPage = new Scene(layout2, 500, 500)*/;
		
		/*Button closeButton = new Button("close");
		closeButton.setOnAction(event -> closeProgram());*/
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(10);
		grid.setHgap(10);
		
		Label usernameLabel = new Label("Username: ");
		grid.setConstraints(usernameLabel, 0, 0);
		
		TextField usernameInput = new TextField();
		grid.setConstraints(usernameInput, 1, 0);
		
		Label passwordLabel = new Label("Password: ");
		grid.setConstraints(usernameLabel, 0, 1);
		
		TextField passwordInput = new TextField();
		grid.setConstraints(passwordInput, 1, 0);
		
		
		
		/*window.setScene(loginPage);*/
		window.setTitle("HelloWorld Airlines Login");
		window.show();
		
		window.setOnCloseRequest(event -> {
			event.consume(); //need to consume to make sure it doesn't close the program when the user clicks 'No'
			closeProgram();
		});
		
	
		
	}
	
	public void closeProgram() {
		Boolean answer = AlertBoxTest.display("Exit", "Close the program?");
		if(answer) {
			Platform.exit();
		}
	}

}
