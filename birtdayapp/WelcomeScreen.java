package birtdayapp;
	
import javafx.geometry.Pos;
	import javafx.scene.Scene;
	import javafx.scene.control.*;
	import javafx.scene.layout.*;
	import javafx.scene.paint.*;
	import javafx.scene.text.Font;
	import javafx.stage.Stage;
	import javafx.animation.FadeTransition;
	import javafx.util.Duration;

	public class WelcomeScreen {

	    public static void show(Stage stage) {

	        Label title = new Label("Birthday Celebration");
	        title.setFont(Font.font(36));
	        title.setTextFill(Color.WHITE);

	        TextField nameField = new TextField("Abujee");
	        nameField.setMaxWidth(250);
	        nameField.setPromptText("Enter Name");

	        DatePicker dobPicker = new DatePicker();
	        dobPicker.setMaxWidth(250);

	        Button startBtn = new Button("Begin Celebration 🎉");
	        startBtn.setStyle(
	                "-fx-background-radius: 25;" +
	                "-fx-font-size: 16;" +
	                "-fx-padding: 10 25;"
	        );

	        VBox box = new VBox(20, title, nameField, dobPicker, startBtn);
	        box.setAlignment(Pos.CENTER);

	        BackgroundFill bgFill = new BackgroundFill(
	                new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,
	                        new Stop(0, Color.web("#0f2027")),
	                        new Stop(1, Color.web("#203a43"))),
	                CornerRadii.EMPTY, null);

	        StackPane root = new StackPane(box);
	        root.setBackground(new Background(bgFill));

	        Scene scene = new Scene(root, 900, 600);

	        FadeTransition ft = new FadeTransition(Duration.seconds(2), box);
	        ft.setFromValue(0);
	        ft.setToValue(1);
	        ft.play();

	        startBtn.setOnAction(e -> {
	            String name = nameField.getText();
	            String dob = dobPicker.getValue() != null ? dobPicker.getValue().toString() : "";
	            CelebrationScreen.show(stage, name, dob);
	        });

	        stage.setScene(scene);
	    }
	}


