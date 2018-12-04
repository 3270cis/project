package GUI;



import java.util.ArrayList;

import Backend.Reservation;
import Database1.DatabaseObject;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MyAccount_5 extends Application {
	
	String tempUser;
	
	MyAccount_5(String tempUser){
		this.tempUser = tempUser;
	}
	
	Stage window;
	Button mainMenuButton;
	Button logoutButton;
	Button cancelFlightButton;
	Button searchFlightButton;
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
		
		mainMenuButton = new Button("Main Menu");
		logoutButton = new Button("Logout");
		cancelFlightButton = new Button("Cancel Flight");
		searchFlightButton = new Button("Search for Flights");
		
		helloWorldAirline = new Label("HelloWorld Airlines My Account");
		helloWorldAirline.setStyle("-fx-font-size: 28pt");
		helloWorldAirline.setAlignment(Pos.CENTER_LEFT);
		
		GridPane grid = new GridPane();
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 20, 20, 20));
		grid.add(helloWorldAirline, 1, 1);
		grid.add(logoutButton, 0, 2);
		grid
		
		
		
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
	
	public ObservableList<Reservation> buildData() {
		
		DatabaseObject dataObj = new DatabaseObject();
		/*ObservableList<Reservation> data = FXCollections.observableArrayList();*/
		
		ObservableList<Reservation> myReservation = FXCollections.observableArrayList();
		ArrayList<Object> array = new ArrayList<>();
		array.add(dataObj.getReservationsFromDB(tempUser));
		
		myReservation.add(array);
		
	}
	
}
