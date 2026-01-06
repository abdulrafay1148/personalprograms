package birtdayapp;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class AudioManager {

    private static MediaPlayer player;

    public static void playMusic() {
        if (player != null) return;

        Media media = new Media(
            AudioManager.class
                .getResource("/music/bg.mp3")
                .toExternalForm()
        );

        player = new MediaPlayer(media);
        player.setVolume(0.3);
        player.setCycleCount(MediaPlayer.INDEFINITE);
        player.play();
    }
}


