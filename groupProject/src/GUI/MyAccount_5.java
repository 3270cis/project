package GUI;



import java.util.ArrayList;

import Backend.Customer;
import Backend.PersonTest;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyAccount_5 extends Application {
	
	String tempUser;
	
//	MyAccount_5(String tempUser){
//		this.tempUser = tempUser;
//	}
	
	Stage window;
	Button mainMenuButton;
	Button logoutButton;
	Button cancelFlightButton;
	Button searchFlightButton;
	Label helloWorldAirline;
	TableView table;
	ObservableList<ObservableList> listData;

	
	public static void main(String[] args) {
		launch(args);
	}
	
//	@Override
//	public void init() throws Exception {
//		
//		super.init();
//	}

	@Override
	public void start(Stage primaryStage)  {
		
		try {
		
		TableView tableView = new TableView();

        TableColumn<String, PersonTest> column1 = new TableColumn<>("First Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("firstName"));


        TableColumn<String, PersonTest> column2 = new TableColumn<>("Last Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        


        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);

        tableView.getItems().add(new PersonTest("John", "Doe"));
        tableView.getItems().add(new PersonTest("Jane", "Deer"));

        VBox vbox = new VBox(tableView);

        Scene scene = new Scene(vbox);
        
        
        primaryStage.setScene(scene);

        primaryStage.show();
		
		}catch(Exception ex) {
			ex.getCause().printStackTrace();
		}
	
		
		/*window = primaryStage;
		
		mainMenuButton = new Button("Main Menu");
		logoutButton = new Button("Logout");
		cancelFlightButton = new Button("Cancel Flight");
		searchFlightButton = new Button("Search for Flights");
		
		helloWorldAirline = new Label("HelloWorld Airlines My Account");
		helloWorldAirline.setStyle("-fx-font-size: 28pt");
		helloWorldAirline.setAlignment(Pos.CENTER_LEFT);
		*/
		
		
		
	/*	Class.forName("com.mysql.jdbc.Driver");*/

	  /*  Scene scene =new Scene(new Group(),800,600);

	    TableView tableView=new TableView();
	    tableView.setItems(dataSource.getData());
	    tableView.getColumns().addAll(dataSource.getColumns());
	    ((Group)scene.getRoot()).getChildren().add(tableView);

	    stage.setScene(scene);
	    stage.show();
		*/
		
	
//		logoutButton.setOnAction(event -> {
//			
//			Login_1 log = new Login_1();
//			
//			try {
//				log.start(window);
//			} catch (Exception e) {
//
//				e.printStackTrace();
//			}
//			
//		});
		
		
	}

    //displaying the table list
	
	/*public ObservableList<Reservation> buildData() {
		
		DatabaseObject dataObj = new DatabaseObject();
		ObservableList<Reservation> data = FXCollections.observableArrayList();
		
		ObservableList<Reservation> myReservation = FXCollections.observableArrayList();
		ArrayList<Object> array = new ArrayList<>();
		array.add(dataObj.getReservationsFromDB(tempUser));
		
		myReservation.add(array);
		*/
	
	/*
	Scene scene = new Scene(grid, 700, 300);
	window.setScene(scene);
	window.setTitle("HelloWorld Airlines Main Menu");
	window.show();
	*/
	

	private void dataFromDB() {
	
	
	}
	
}
