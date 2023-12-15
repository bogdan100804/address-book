package com.example.bohdanadressna;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Pr7_1Controller implements Initializable{

    @FXML
    private Button btnNextTask;

    @FXML
    private MediaView mediaView;

    @FXML
    private Button pauseButton;

    @FXML
    private Button playButton;

    @FXML
    private Button resetButton;

    private Stage newStage;
    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        file = new File("video.mp4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);

    }
    @FXML
    void playButton(ActionEvent event) { // реалізація кнопки Play
        mediaPlayer.play();
    }
    @FXML
    void pauseButton(ActionEvent event) { // реалізація кнопки Pause
        mediaPlayer.pause();
    }
    @FXML
    void resetButton(ActionEvent event) { // реалізація кнопки Reset
        if(mediaPlayer.getStatus() != MediaPlayer.Status.READY) {
            mediaPlayer.seek(Duration.seconds(0.0));
            mediaPlayer.play();
        }
    }


    @FXML
    public void nextTask() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pr7-2.fxml"));
            Parent root = loader.load();
            Pr7_2Controller controller = loader.getController();


            Stage stage = new Stage();
            stage.setTitle("Практична робота 7");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(btnNextTask.getScene().getWindow());
            Scene scene = new Scene(root);
            stage.setScene(scene);

            controller.setStage(stage);

            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void setNewStage(Stage newStage) {
        this.newStage = newStage;
    }


}


