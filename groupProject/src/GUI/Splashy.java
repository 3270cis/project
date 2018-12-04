
package GUI;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class Splashy extends Application {


public static void main(String[] args) {
launch(args); //method inside Application class, sets everything up, and then calls"start"
}
@Override //overriden because its being inherited from Application class
public void start(Stage stage) throws Exception {

	try {
	String imageURLForSplashScreen = "file:///C:/Users/k/git/project/groupProject/src/GUI/splashfinal.png";
	Image image = new Image(imageURLForSplashScreen);
	

	
	StackPane pane=new StackPane();
	Scene scene = new Scene(pane,700, 380);

	ImageView iv=new ImageView();
	iv.setImage(image);
	iv.setFitWidth(500);
	iv.setFitHeight(500);
	pane.getChildren().add(iv);

	//fade out into login screen
	FadeTransition fadeOut = new FadeTransition(Duration.seconds(6), pane);
	fadeOut.setFromValue(1);
	fadeOut.setToValue(0);
	fadeOut.setCycleCount(1);

	/*need to fade out into next screen (login?)

	this might help: http://www.genuinecoder.com/javafx-splash-screen-loading-screen/
	 */
	stage.setScene(scene);
	stage.show();
	fadeOut.play();
	
	
	
	fadeOut.setOnFinished(event -> {
		Login log = new Login();
		try {
			log.start(stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	});
		
	}catch (Exception ex) {
		ex.printStackTrace();
			}
	}
	
}
