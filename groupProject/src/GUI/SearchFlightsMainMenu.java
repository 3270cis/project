package GUI;

import java.util.ArrayList;

import Backend.Flight;
import Backend.ValueObject;
import Database1.DatabaseObject;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;

public class SearchFlightsMainMenu extends Application {
	
	Stage window;
	Scene scene;
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
	
	DatePicker departDate;
	
	String ATL_URL = "file:///C:/Users/k/git/project/groupProject/src/GUI/ATLBack2.jpg";
	Image ATL_IMG;
	BackgroundImage ATLBackgroundImg;
	
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
		mainMenuButton = new Button("Main Menu");
		myFlights = new Button("My Flights");
		
		searchLabel = new Label("Search for Flights");
		searchLabel.setStyle("-fx-font-size: 28pt");
		searchLabel.setAlignment(Pos.TOP_CENTER);
		
		fromLabel = new Label("From");
		toLabel = new Label("To");
		departLabel = new Label("Depart Date");
		returnLabel = new Label("Return Date");
		numOfPassLabel = new Label("Number of passengers");
		
		ATL_IMG = new Image(ATL_URL);
		ATLBackgroundImg = new BackgroundImage(ATL_IMG, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, 
									BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, 
																					false, false, true, false));
		 
		cBoxFrom = new ComboBox<>();
		cBoxFrom.getItems().addAll("Atlanta (ATL)");
		
		cBoxTo = new ComboBox<>();
		cBoxTo.getItems().addAll("Paris (CDG)", "Tokyo (HND)", "Bogota (BOG)", "Dubai (DXB)", "Sydney (SYD)");
		
		departDate = new DatePicker();
		departDate.setPromptText("Date");
		departDate.setEditable(false);
	
			
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(20, 20, 20, 20));
		grid.setHgap(30);
		grid.setVgap(10);
		grid.add(searchLabel, 0, 0);
		grid.add(fromLabel, 0, 1);
		grid.add(cBoxFrom, 0, 2);
		grid.add(toLabel, 0, 3);
		grid.add(cBoxTo, 0, 4);
		grid.add(departLabel, 1	,1);
		//grid.add(returnLabel, 1, 3);
		grid.add(mainMenuButton, 0, 6);
		grid.add(searchFlightsButton, 1, 6);
		grid.add(departDate, 1, 2);
		
		cBoxTo.setOnAction(event -> {
			
			Background back;
			
			switch(cBoxTo.getValue()) {
			
			case "Syndey (SYD)" : back = new Background(ATLBackgroundImg);
									grid.setBackground(back);
									break;
			// have to make the case for each city! not important right now this is just for style points
			}
		});
		
		
		
		searchFlightsButton.setOnAction(event -> {
		
			ValueObject valObj = new ValueObject();
			AlertBox aBox1;
			AlertBox aBox2;
															//getting the user's 'from', 'to', and 'date'
			if (valObj.didCustomerInputFromToAndDateCorrect(cBoxFrom.getValue(), cBoxTo.getValue(), 
															( (TextField)departDate.getEditor()).getText()) ) {
				
				System.out.println("checked customer input, returned true");
				
				DatabaseObject dataObj = new DatabaseObject();
				dataObj.searchTheDBForFlight(cBoxFrom.getValue(), cBoxTo.getValue(), 
						((TextField)departDate.getEditor()).getText()) ;
				
				
			}
			
			else {
				
				aBox1 = new AlertBox();	
				aBox1.displayMessage("check your selections!");
			}
			
			
		});

		mainMenuButton.setOnAction(event -> {
			
				MainMenu main = new MainMenu();
				try {
					main.start(window);
				} catch (Exception e) {
					e.printStackTrace();
				}
			
		});
								
		
		scene = new Scene(grid, 700, 300);
		window.setScene(scene);
		window.setTitle("HelloWorld Airlines Flight Selection");
		window.show();
	}
	
	
}
