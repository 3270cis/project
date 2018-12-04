package GUI;

import java.util.ArrayList;

import java.time.DayOfWeek;
import java.time.LocalDate;

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
import javafx.scene.control.DateCell;
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

public class SearchAndBookFlight_4 extends Application {
	
	String tempUser;
	
	SearchAndBookFlight_4(String tempUser){
		this.tempUser = tempUser;
	}
	
	Stage window;
	Scene scene;
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
	
	String Paris_URL = "file:///C:/Users/k/git/project/groupProject/src/GUI/paris.jpg";
	String Kashmir_URL = "file:///C:/Users/k/git/project/groupProject/src/GUI/kashmir2.jpg";
	String Tokyo_URL = "file:///C:/Users/k/git/project/groupProject/src/GUI/tokyo.jpg";
	String Rome_URL = "file:///C:/Users/k/git/project/groupProject/src/GUI/Rome.jpg";
	String Sydney_URL = "file:///C:/Users/k/git/project/groupProject/src/GUI/sydney.jpg";
	
	Image Paris_IMG;
	Image Kashmir_IMG;
	Image Tokyo_IMG;
	Image Rome_IMG;
	Image Sydney_IMG;
	
	BackgroundImage ParisBackgroundImage;
	BackgroundImage KashmirBackgroundImage;
	BackgroundImage TokyoBackgroundImage;
	BackgroundImage RomeBackgroundImage;
	BackgroundImage SydneyBackgroundImage;
	
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
		
		bookFlightButton = new Button("Book your Flight!");
		mainMenuButton = new Button("Main Menu");
		myFlights = new Button("My Flights");
		
		searchLabel = new Label("Search for Flights");
		searchLabel.setStyle("-fx-font-size: 28pt");
		searchLabel.setAlignment(Pos.TOP_CENTER);
		
		fromLabel = new Label("From");
		toLabel = new Label("To");
		departLabel = new Label("Depart Date");
		returnLabel = new Label("Return Date");
		//numOfPassLabel = new Label("Number of passengers");
		
		Paris_IMG = new Image(Paris_URL);
		ParisBackgroundImage = new BackgroundImage(Paris_IMG, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, 
									BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, 
																					false, false, true, false));
		Kashmir_IMG = new Image(Kashmir_URL);
		KashmirBackgroundImage = new BackgroundImage(Kashmir_IMG, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, 
									BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, 
																					false, false, true, false));
		Tokyo_IMG = new Image(Tokyo_URL);
		TokyoBackgroundImage = new BackgroundImage(Tokyo_IMG, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, 
									BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, 
																					false, false, true, false));
		Rome_IMG = new Image(Rome_URL);
		RomeBackgroundImage = new BackgroundImage(Rome_IMG, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, 
									BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, 
																					false, false, true, false));
		Sydney_IMG = new Image(Sydney_URL);
		SydneyBackgroundImage = new BackgroundImage(Sydney_IMG, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, 
									BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, 
																					false, false, true, false));
		
		 
		cBoxFrom = new ComboBox<>();
		cBoxFrom.getItems().addAll("Atlanta (ATL)");
		
		cBoxTo = new ComboBox<>();
		cBoxTo.getItems().addAll("Paris(CDG)", "Kashmir(SXR)", "Tokyo(HND)", "Rome(FCO)", "Sydney(SYD)");
		
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
		grid.add(bookFlightButton, 1, 6);
		grid.add(departDate, 1, 2);
		
		cBoxTo.setOnAction(event -> {
			
			Background back;
			
			switch(cBoxTo.getValue()) {
			
			case "Paris(CDG)" : back = new Background(ParisBackgroundImage);
									grid.setBackground(back);
									break;
									
			case "Kashmir(SXR)" : back = new Background(KashmirBackgroundImage);
									grid.setBackground(back);
									break; 	
									
			case "Tokyo(HND)" : back = new Background(TokyoBackgroundImage);
									grid.setBackground(back);
									break;					
			case "Rome(FCO)" : back = new Background(RomeBackgroundImage);
									grid.setBackground(back);
									break;
			case "Sydney(SYD)" : back = new Background(SydneyBackgroundImage);
									grid.setBackground(back);
									break;
			}
			
			/*departDate.setDayCellFactory(picker -> new DateCell() {
				
	            @Override
	            public void updateItem(LocalDate date, boolean empty) {
	                super.updateItem(date, empty);
	                setDisable(empty || date.getDayOfWeek() == DayOfWeek.MONDAY && empty || date.getDayOfWeek() == DayOfWeek.TUESDAY);
	            }
	            
	        });*/
			
			
			
		});
		
		
		
		bookFlightButton.setOnAction(event -> {
		
			ValueObject valObj = new ValueObject();
			AlertBox aBox1;
			AlertBox aBox2;
			AlertBox aBox3;
															//making sure from to and date is not empty
			if ( !(cBoxFrom.getValue().isEmpty()) && !(cBoxTo.getValue().isEmpty()) 
					&& !(((TextField)departDate.getEditor()).getText().isEmpty()) &&
																//getting the user's 'from', 'to', and 'date'
					(valObj.didCustomerInputFromToAndDateCorrect(cBoxFrom.getValue(), cBoxTo.getValue(), 
															((TextField)departDate.getEditor()).getText()))) {
				
							
						System.out.println("checked customer input, returned true");
				
							DatabaseObject dataObj = new DatabaseObject();
				
							//maybe !
							if(dataObj.isAlreadyBookForTheUsername(cBoxFrom.getValue(), cBoxTo.getValue(), 
									( (TextField)departDate.getEditor()).getText(), tempUser)) {
				
								aBox2 = new AlertBox();
								aBox2.displayMessage("Can not book same flight twice!");
							}
				
							else {
					
								dataObj.bookTheFlight(cBoxFrom.getValue(), cBoxTo.getValue(), 
										((TextField)departDate.getEditor()).getText(), tempUser);
					
								aBox3 = new AlertBox();
								aBox3.displayMessage("Sucessfully booked!");
					
								System.out.println("sucessfully booked the flight!");
							}
			}
			
			else {
				
				aBox1 = new AlertBox();	
				aBox1.displayMessage("check your selections!");
			}
			
			
		});

		mainMenuButton.setOnAction(event -> {
			
				MainMenu_3 main = new MainMenu_3(tempUser);
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
