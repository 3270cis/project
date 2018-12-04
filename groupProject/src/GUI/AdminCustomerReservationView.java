package GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AdminCustomerReservationView extends Application {

	//TABLE VIEW OF ALL FLIGHTS
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void init() throws Exception {
		
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
	//everything customer can do, add flight, delete flights, updates customer information
	// admin can change flight dates around 
		
		
		
		
		
		window = primaryStage;
		

		
		
		
		logoutButton.setOnAction(event -> {
			
			Login_1 log = new Login_1();
			
			try {
				log.start(window);
			} catch (Exception e) {

				e.printStackTrace();
			}
			
		});
		
		
		
	
		Scene scene = new Scene(grid, 700, 300);
		window.setScene(scene);
		window.setTitle("HelloWorld Airlines ADMIN");
		window.show();

	}
}
	