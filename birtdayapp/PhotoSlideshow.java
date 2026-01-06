package birtdayapp;

import javafx.animation.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import java.net.URL;

public class PhotoSlideshow {

    private ImageView imageView;
    private Image[] images;
    private int index = 0;

    public PhotoSlideshow() {

        images = loadImages();

        imageView = new ImageView(images[0]);
        imageView.setFitWidth(600);
        imageView.setFitHeight(600);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);

        Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(4), e -> nextImage())
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private Image[] loadImages() {

        String[] paths = {
            "/images/pic1.jpg",
            "/images/pic2.jpg",
            "/images/pic3.jpg"
        };

        Image[] loaded = new Image[paths.length];

        for (int i = 0; i < paths.length; i++) {
            URL url = getClass().getResource(paths[i]);

            if (url == null) {
                System.out.println("❌ Image NOT FOUND: " + paths[i]);
                loaded[i] = new Image("https://via.placeholder.com/300");
            } else {
                loaded[i] = new Image(url.toExternalForm());
            }
        }

        return loaded;
    }

    private void nextImage() {
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(1), imageView);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);

        fadeOut.setOnFinished(e -> {
            index = (index + 1) % images.length;
            imageView.setImage(images[index]);

            FadeTransition fadeIn = new FadeTransition(Duration.seconds(1), imageView);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.play();
        });

        fadeOut.play();
    }

    public StackPane getView() {
        return new StackPane(imageView);
    }
}
