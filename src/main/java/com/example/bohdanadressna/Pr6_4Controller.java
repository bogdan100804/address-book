package com.example.bohdanadressna;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class Pr6_4Controller {

    private Stage newStage;

    private Pr6_3Controller controller;

    private RadioMenuItem one;

    @FXML
    private TextField textField;

    @FXML
    private RadioMenuItem two;

    @FXML
    private ToggleGroup toggleContextText;

    @FXML
    void toggleContextText(ActionEvent event) {
        if (toggleContextText.getSelectedToggle().equals(this.one))
            textField.setText("RandomText");
        else if (toggleContextText.getSelectedToggle().equals(this.two))
            textField.setText(null);
    }

    @FXML
    void exitButton(ActionEvent event) {
        newStage.close();
    }

    public void setNewStage(Stage newStage) {
        this.newStage = newStage;
    }

    public void setController(Pr6_3Controller controller) {
        this.controller = controller;
    }
}


