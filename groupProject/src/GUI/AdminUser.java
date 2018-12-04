package GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AdminUser extends Application {
	
	Stage window;
	Button customerReservationsButton;
	Button updateFlightsButton;
	Button logoutButton;
	Label helloWorldAirline;
	
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
	
		customerReservationsButton = new Button(" Customer Reservatiions");
		logoutButton = new Button("Logout");
		updateFlightsButton = new Button("Update Flights");
		
		helloWorldAirline = new Label("HelloWorld Airlines Admin");
		helloWorldAirline.setStyle("-fx-font-size: 28pt");
		helloWorldAirline.setAlignment(Pos.CENTER_LEFT);
		
		GridPane grid = new GridPane();
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 20, 20, 20));
		grid.add(helloWorldAirline, 1, 1);
		grid.add(logoutButton, 0, 2);

		grid.add(customerReservationsButton, 0, 4);
		grid.add(updateFlightsButton, 0, 5);
		
		customerReservationsButton.setOnAction(event -> {
			
			AdminCustomerView adminView = new AdminCustomerView();
			
			try {
				adminView.start(window);
			} catch (Exception e) {

				e.printStackTrace();
			}
			
		});
		
		logoutButton.setOnAction(event -> {
			
			Login log = new Login();
			
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
