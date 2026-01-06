package birtdayapp;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.animation.FadeTransition;
import javafx.util.Duration;

public class CelebrationScreen {

    public static void show(Stage stage, String name, String dob) {

        // Play background music
        AudioManager.playMusic();

        // Heading (Top)
        Label heading = new Label("Happy Birthday " + name + " 💙");
        heading.setFont(Font.font(40));
        heading.setTextFill(Color.WHITE);

        // DOB Label (Top)
        Label dobLabel = new Label("Born on: " + dob);
        dobLabel.setFont(Font.font(18));
        dobLabel.setTextFill(Color.LIGHTGRAY);

        // English Message (Left)
        Label message = new Label(
                "May Allah grant you\n" +
                "a long life filled with good health,\n" +
                "surround you with peace and comfort,\n" +
                "strengthen you with patience and wisdom,\n" +
                "and bless every day with joy and happiness.\n" +
                "Ameen."
        );
        message.setFont(Font.font(35));
        message.setTextFill(Color.WHITE);
        message.setWrapText(true);
        message.setAlignment(Pos.CENTER_LEFT);
        message.setMaxWidth(350); // fix width so slideshow stays visible

        // Urdu Message (Right)
        Label urduMessage = new Label(
                "اللہ تعالیٰ آپ کو صحت،\n" +
                "سکون اور درازیٔ عمر عطا فرمائے،\n" +
                "آپ کی ہر صبح خیر و برکت سے بھر دے،\n" +
                "اور ہر لمحہ خوشیوں سے روشن رکھے۔\n" +
                "آمین۔"
        );
        urduMessage.setTextFill(Color.WHITE);
        urduMessage.setWrapText(true);
        urduMessage.setAlignment(Pos.CENTER_RIGHT);
        urduMessage.setMaxWidth(350); // fix width
        urduMessage.setStyle("-fx-font-family: 'Jameel Noori Nastaleeq'; -fx-font-size: 40;");

        // Photo Slideshow (Center)
        PhotoSlideshow slideshow = new PhotoSlideshow();
        slideshow.getView().setPrefWidth(400);
        slideshow.getView().setPrefHeight(400);

        // Middle row HBox: message | slideshow | Urdu message
        HBox middleRow = new HBox(30, message, slideshow.getView(), urduMessage);
        middleRow.setAlignment(Pos.CENTER);

        // VBox for top + middle
        VBox center = new VBox(20, heading, dobLabel, middleRow);
        center.setAlignment(Pos.TOP_CENTER);

        // Signature (Bottom-right)
        Label signature = new Label("— From Abdul Rafay");
        signature.setFont(Font.font(16));
        signature.setTextFill(Color.GOLD);

        // Root layout
        BorderPane root = new BorderPane();
        root.setCenter(center);
        root.setBottom(signature);
        BorderPane.setAlignment(signature, Pos.BOTTOM_RIGHT);
        BorderPane.setMargin(signature, new javafx.geometry.Insets(10));

        // Background gradient
        root.setBackground(new Background(new BackgroundFill(
                new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE,
                        new Stop(0, Color.web("#000428")),
                        new Stop(1, Color.web("#004e92"))),
                CornerRadii.EMPTY, null)));

        // Scene
        Scene scene = new Scene(root, 900, 600);

        // Fade animation for center content
        FadeTransition ft = new FadeTransition(Duration.seconds(2), center);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();

        // Set scene
        stage.setScene(scene);
    }
}
