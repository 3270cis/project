package GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
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
		
		Label searchLabel = new Label("Search for Flights");
		Label fromLabel = new Label("From");
		Label toLabel = new Label("To");
		Label departLabel = new Label("Depart Date");
		Label returnLabel = new Label("Return Date");
		
		BorderPane bp = new BorderPane();
		bp.setPadding(new Insets(10, 10, 10, 10));



		Scene scene = new Scene(bp, 700, 300);
		window.setScene(scene);
		window.setTitle("HelloWorld Airlines ");
		window.show();
	
		
	
	}
}
