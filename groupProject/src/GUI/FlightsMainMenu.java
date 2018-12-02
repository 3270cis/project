package GUI;

import java.util.ArrayList;

import Backend.Flight;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FlightsMainMenu extends Application {
	
	Stage window;
	Button searchFlightsButton;
	Button bookFlightButton;
	Button mainMenuButton;
	Button myFlights;
	
	Label searchLabel;
	Label fromLabel;
	Label toLabel;
	Label departLabel;
	Label returnLabel;
	Label numOfPassLabel;
	ComboBox<String> cBoxFrom;
	ComboBox<String> cBoxTo;
	HBox hbox1;
	ArrayList<Flight> flights;
	
	public static void main(String[] args) {
		launch(args);
		
		/*Flight flight1 = new Flight(1001);
		flight1.getFlightDetails().setDepartureCity("Atlanta");
		flight1.getFlightDetails().setDestination("Paris");
		*/
		
		
	}
	
	@Override
	public void init() throws Exception {
		
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		window = primaryStage;
		
		searchFlightsButton = new Button("Search Flights");
		//bookFlightButton = new Button("Book Flight");
		//mainMenuButton = new Button("Main Menu");
		myFlights = new Button("My Flights");
		
		searchLabel = new Label("Search for Flights");
		searchLabel.setStyle("-fx-font-size: 28pt");
		searchLabel.setAlignment(Pos.TOP_CENTER);
		
		fromLabel = new Label("From");
		fromLabel.setPadding(new Insets(10));
		toLabel = new Label("To");
		toLabel.setPadding(new Insets(10));
		departLabel = new Label("Depart Date");
		returnLabel = new Label("Return Date");
		numOfPassLabel = new Label("Number of passengers");
		
		
		
		/*cBoxFrom = new ComboBox<>();
		cBoxFrom.getItems().addAll("Atlanta (ATL)", "Paris (CDG)", "Tokyo (HND)", "Bogota (BOG)", "Dubai (DXB)", "Sydney (SYD)");
		
		cBoxTo = new ComboBox<>();
		cBoxTo.getItems().addAll("Atlanta (ATL)", "Paris (CDG)", "Tokyo (HND)", "Bogota (BOG)", "Dubai (DXB)", "Sydney (SYD)");*/
		
		
		
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.add(fromLabel, 0, 1);
		grid.add(cBoxFrom, 1, 1);
		grid.add(cBoxTo, 1, 2);
		grid.add(toLabel, 0, 2);
		
		
		/*bp.getChildren().addAll(searchFlightsButton, bookFlightButton, mainMenuButton, myFlights, searchLabel, fromLabel, toLabel,
				
								departLabel, returnLabel, numOfPassLabel, cBoxFrom, cBoxTo);*/
								
		
		Scene scene = new Scene(grid, 700, 300);
		window.setScene(scene);
		window.setTitle("HelloWorld Airlines Flight Selection");
		window.show();
	}
	
	
}
