package com.example.bohdanadressna;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Pr7_2Controller implements Initializable {
    @FXML
    private Slider volume;

    @FXML
    private ProgressBar audioProgress;

    @FXML
    private Label label_audio;

    private File file;
    private File[] files;
    private Media media;
    private MediaPlayer mediaPlayer;
    private ArrayList<File> songs;
    private int songNumber;

    private Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        file = new File("songs");
        files = file.listFiles();

        songs = new ArrayList<>();

        if (files != null) {
            for (File f : files) {
                songs.add(f);
                System.out.println(f);
            }
        }

        media = new Media(songs.get(songNumber).toURI().toString());
        mediaPlayer = new MediaPlayer(media);

        volume.valueProperty().addListener((observableValue, number, t1) ->
                mediaPlayer.setVolume(volume.getValue() * 0.01)
        );
    }

    @FXML
    void play(ActionEvent event) {
        mediaPlayer.play();
        label_audio.setText(songs.get(songNumber).getName());
    }

    @FXML
    void pause(ActionEvent event) {
        mediaPlayer.pause();
        label_audio.setText(songs.get(songNumber).getName());
    }

    @FXML
    void next(ActionEvent event) {
        if (songNumber < songs.size() - 1) {
            songNumber++;
        } else {
            songNumber = 0;
        }
        handleMediaChange();
    }

    @FXML
    void previous(ActionEvent event) {
        if (songNumber > 0) {
            songNumber--;
        } else {
            songNumber = songs.size() - 1;
        }
        handleMediaChange();
    }

    private void handleMediaChange() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }

        media = new Media(songs.get(songNumber).toURI().toString());
        mediaPlayer = new MediaPlayer(media);

        label_audio.setText(songs.get(songNumber).getName());

        mediaPlayer.play();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
