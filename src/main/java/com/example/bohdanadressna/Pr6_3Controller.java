package com.example.bohdanadressna;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Pr6_3Controller {
    @FXML
    private Button answer;

    @FXML
    private CheckBox checkBox1;

    @FXML
    private CheckBox checkBox2;

    @FXML
    private CheckBox checkBox3;

    @FXML
    private CheckBox checkBox4;

    @FXML
    private ComboBox comboBox;
    @FXML
    private Label lblAnswerCombo;

    @FXML
    private Label lblTrueAnswer;

    @FXML
    private Label lblAnswerChoice;

    @FXML
    private ChoiceBox choiceBox;

    @FXML
    private RadioButton radioLay;

    @FXML
    private RadioButton radioCode;

    @FXML
    private RadioButton radioHier;

    @FXML
    private RadioButton radioProp;

    @FXML
    private Label lblRadio;

    private ToggleGroup radiotoggleGroup;

    @FXML
    private Button btnNextTasks;

    @FXML
    private Button btnNextPr;

    private Stage dialogStage;


    public void initialize(){
        lblTrueAnswer.setText("");
        lblAnswerChoice.setText("");
        choiceBox.getItems().addAll("Правильно","Неправильно");
        lblAnswerCombo.setText("");
        comboBox.getItems().addAll("BorderPane", "AncorePane","VBox", "HBox");
        lblRadio.setText("");
        radiotoggleGroup = new ToggleGroup();
        this.radioProp.setToggleGroup(radiotoggleGroup);
        this.radioLay.setToggleGroup(radiotoggleGroup);
        this.radioHier.setToggleGroup(radiotoggleGroup);
        this.radioCode.setToggleGroup(radiotoggleGroup);
    }

    @FXML
    public void checkBoxAnswer(ActionEvent event) {

        if(checkBox1.isSelected() & checkBox2.isSelected() & checkBox3.isSelected() & !checkBox4.isSelected()){
            String answer = "\nВідповідь вірна!";
            this.lblTrueAnswer.setText(answer);
        } else {
            this.lblTrueAnswer.setText("Відповідь не вірна!");
        }

    }

    @FXML
    public void choiceBoxAnswer(ActionEvent event) {
        String trueAnswer = "Неправильно";

        if (choiceBox.getValue().toString().equals(trueAnswer)){
            lblAnswerChoice.setText("\nВідповідь вірна!");
        } else {
            lblAnswerChoice.setText("\nВідповідь не вірна!");
        }
    }

    @FXML
    public void comboBoxPressed(ActionEvent event) {
        String trueAnswer = "BorderPane";
        if (comboBox.getValue().toString().equals(trueAnswer)) {
            lblAnswerCombo.setText("\nВідповідь вірна!");
        } else {
            lblAnswerCombo.setText("\nВідповідь не вірна!");
        }
    }

    @FXML
    public void radioAnswer(ActionEvent event) {
        RadioButton selectedRadioButton = (RadioButton) radiotoggleGroup.getSelectedToggle();
        String answer = selectedRadioButton.getText();
        String trueAnswer = "Properties";

        if (answer.equals(trueAnswer)){
            lblRadio.setText("\nВідповідь вірна!");
        } else {
            lblRadio.setText("\nВідповідь не вірна!");
        }
    }

    @FXML
    public void task6_4() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pr6-4.fxml"));
            Parent root = loader.load();
            Pr6_4Controller controller = loader.getController();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Практична робота №6");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(btnNextTasks.getScene().getWindow());
            Scene scene = new Scene(root);
            dialogStage.setScene(scene);

            controller.setNewStage(dialogStage);

            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    public void nextPr() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pr7-1.fxml"));
            Parent root = loader.load();
            Pr7_1Controller controller = loader.getController();

            Stage stage = new Stage();
            stage.setTitle("Практична робота №7");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(btnNextPr.getScene().getWindow());

            Scene scene = new Scene(root);
            stage.setScene(scene);

            controller.setNewStage(stage);

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
}
