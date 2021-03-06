package GUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {
	
	AlertBox(){
		
	}
	
	public void displayMessage(String message) {
		
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Notice");
		window.setMinWidth(300);
		
		Label label = new Label();
		label.setText(message);
		
		Button OKButton = new Button("Ok");
		
		OKButton.setOnAction(event -> {
				answer = true;
				window.close();
		});

		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, OKButton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
	}
	
	
	//THIS CODE IS FOR CONFIRMING IF THE USER WANTS TO EXIT THE APPLICATION
	static boolean answer;
	
	public boolean displayWhenExit(String title, String message) {
		
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(300);
		
		Label label = new Label();
		label.setText(message);
		
		Button yesButton = new Button("Yes");
		Button noButton = new Button("No");
		
		yesButton.setOnAction(event -> {
				answer = true;
				window.close();
		});
		
		noButton.setOnAction(event -> {
			answer = false;
			window.close();
		});

		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, yesButton, noButton);
		layout.setAlignment(Pos.CENTER);
		
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
		return answer;
		
	}

}
