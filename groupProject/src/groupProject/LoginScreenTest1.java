package groupProject;
import com.sun.javafx.scene.SceneEventDispatcher;

import javafx.application.Application; 
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler; 
import javafx.scene.Scene; 
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class LoginScreenTest1 extends Application{
	
	Stage window;
	Scene loginPage;
	Scene registerPage;
	
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
		Label label1 = new Label("This is the login page");
		Button button1 = new Button("Click here to register a new account");
		button1.setOnAction(event -> window.setScene(registerPage));
		
		//the layout with the layout and button
		StackPane layout1 = new StackPane();
		layout1.getChildren().addAll(label1, button1);
		loginPage = new Scene(layout1, 300, 300);
		
		//button 2 to go back to the login page
		Label label2 = new Label("The is the register new account page");
		Button button2 = new Button("Click here to go back to the login page");
		button2.setOnAction(event -> window.setScene(loginPage));
		
		StackPane layout2 = new StackPane();
		layout2.getChildren().addAll(label2, button2);
		registerPage = new Scene(layout2, 500, 500);
		
		window.setScene(loginPage);
		window.setTitle("HelloWorld Airlines");
		window.show();
		
		
	}

}
