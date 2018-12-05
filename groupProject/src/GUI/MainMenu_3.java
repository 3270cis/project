package GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainMenu_3 extends Application {
	
	String tempUser;
	
	MainMenu_3(String tempUser){
		
		this.tempUser = tempUser;
	}
	
	Stage window;
	Button searchForFlightsButton;
	Button myReservationsButton;
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
		
		window = primaryStage;
		
		searchForFlightsButton = new Button("Search for Flights");
		myReservationsButton = new Button("My Reservations");
		logoutButton = new Button("Logout");
		
		helloWorldAirline = new Label("HelloWorld Airlines Main Menu");
		helloWorldAirline.setStyle("-fx-font-size: 28pt");
		helloWorldAirline.setAlignment(Pos.CENTER_LEFT);
		
		GridPane grid = new GridPane();
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 20, 20, 20));
		grid.add(helloWorldAirline, 1, 1);
		grid.add(logoutButton, 0, 2);
		grid.add(searchForFlightsButton, 0, 3);
		grid.add(myReservationsButton, 0, 4);
		
		searchForFlightsButton.setOnAction(event -> {
			
			SearchAndBookFlight_4 bkmm = new SearchAndBookFlight_4(tempUser);
			try {
				bkmm.start(window);
			} catch (Exception e) {

				e.printStackTrace();
			}
			
		});
		
		//having errors
		myReservationsButton.setOnAction(event -> {
			
			MyAccount_5 fr = new MyAccount_5(tempUser);
			
			try {
				fr.start(window);
			} catch (Exception e) {

				e.printStackTrace();
			}
			
		});
		
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
		window.setTitle("HelloWorld Airlines Main Menu");
		window.show();
		
		
		
	}
	

}
