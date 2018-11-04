package groupProject;
import javafx.application.Application; 
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.layout.StackPane; 
import javafx.stage.Stage;


		public class projectTest1 extends Application{
			
			
			public projectTest1() {
				
			}

			public static void main(String[] args) {
				launch(args); // launch goes into Application and sets up this program as a JavaFX application.
				
			} 
			
			@Override
			public void init() throws Exception {
				
				super.init();
			}
			
			@Override
			public void start(Stage primaryStage) throws Exception {
				//Application is going to call start, therefore override
				
				primaryStage.setTitle("This is the login screen");
				Button button1 = new Button();
				button1.setText("click here for baklavas");
				
				
				StackPane layout = new StackPane();
				layout.getChildren().add(button1);
				
				Scene scene = new Scene(layout, 400, 300);
				primaryStage.setScene(scene);
				primaryStage.show();
				
				
				
				
			}

		
	}
	
