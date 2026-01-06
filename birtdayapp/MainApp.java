package birtdayapp;

import javafx.application.Application;
import javafx.stage.Stage;

	public class MainApp extends Application {

	    @Override
	    public void start(Stage stage) {
	        stage.setTitle("Birthday Celebration");
	        WelcomeScreen.show(stage);
	        stage.show();
	    }

	    public static void main(String[] args) {
	        launch(args);
	    }
	}


