package GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FlightsMainMenu extends Application {
	
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
		
		Button searchFlightsButton = new Button("Search Flights");
		Button bookFlightButton = new Button("Book Flight");
		Button MainMenuButton = new Button("Main Menu");
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setPadding(new Insets(10, 10, 10, 10));
		
		Scene scene = new Scene(grid, 700, 300);
		window.setScene(scene);
		window.setTitle("HelloWorld Airlines Flight Selection");
		window.show();
		
		
	
	}
}
