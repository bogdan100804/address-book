package com.example.bohdanadressna;

import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Method;

public class HelloController {

    @FXML
    private Button btnAdd, btnDelete, btnEdit, btnSearch, exitButton, btnOtherLabs;

    @FXML
    private Label labelCount, label;

    @FXML
    private TableView<Person> tableAddressBook;

    @FXML
    private TextField txtSearch;

    @FXML
    private TableColumn<Person, String> columnPIP, columnPhone;

    private CollectionAddressBook addressBookImpl = new CollectionAddressBook();
    private FXMLLoader editLoader = new FXMLLoader();
    private EditController editController;

    private Stage dialogStage;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    public void initialize() {
        columnPIP.setCellValueFactory(new PropertyValueFactory<>("pip"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));

        addressBookImpl.getPersonList().addListener((ListChangeListener<Person>) c -> updateCountLabel());

        addressBookImpl.fillTestData();
        tableAddressBook.setItems(addressBookImpl.getPersonList());

//        setupClearButtonField();


    }

//    private void setupClearButtonField(CustomTextField customTextField) {
//        try {
//            Method m = TextFields.class.getDeclaredMethod("setupClearButtonField", TextField.class, ObjectProperty.class);
//            m.setAccessible(true);
//            m.invoke(null, customTextField, customTextField.rightProperty());
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }

    private void updateCountLabel() {
        labelCount.setText("Кількість записів: " + addressBookImpl.getPersonList().size());
    }

    public void getUpdateCountLabel(){
        updateCountLabel();
    }

    @FXML
    public void onAddButtonClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("edit-view.fxml"));
            Parent root = loader.load();

            EditController editController = loader.getController();
            editController.setDialogStage(new Stage());
            editController.setHelloController(this);


            Person newPerson = new Person();
            editController.setPerson(newPerson);

            editController.setAddressBookImpl(addressBookImpl);

            Stage stage = new Stage();
            stage.initModality(Modality.WINDOW_MODAL);
            stage.setTitle("Додавання/редагування користувача");
            stage.setScene(new Scene(root));

            editController.setDialogStage(stage);

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void onEditButtonClick() {
        Person selectedPerson = tableAddressBook.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("edit-view.fxml"));
                Parent root = loader.load();

                EditController editController = loader.getController();
                editController.setDialogStage(new Stage());
                editController.setHelloController(this);

                editController.setPerson(selectedPerson);

                Stage stage = new Stage();
                stage.initModality(Modality.WINDOW_MODAL);
                stage.setTitle("Додавання/редагування користувача");
                stage.setScene(new Scene(root));

                editController.setDialogStage(stage);

                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void exitApplication() {
        Platform.exit();
    }

    @FXML
    public void onDeleteButtonClick() {
        Person selectedPerson = tableAddressBook.getSelectionModel().getSelectedItem();
        if (selectedPerson != null && showConfirmationDialog("Видалення", "Ви впевненні, що хочете видалити запис?")) {
            addressBookImpl.delete(selectedPerson);
        }
    }

    @FXML
    public void onSearchButtonClick() {
        String searchTerm = txtSearch.getText().toLowerCase();
        ObservableList<Person> searchResults = addressBookImpl.search(searchTerm);
        tableAddressBook.setItems(searchResults);
    }

//    public void showDialog() {
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("edit-view.fxml"));
//            Parent root = loader.load();
//
//            // Забезпечте ініціалізацію person перед викликом setPerson
//            Person newPerson = new Person(); // Додайте це
//            EditController editController = loader.getController();
//            editController.setPerson(newPerson); // Забезпечте ініціалізацію person
//            editController.setDialogStage(new Stage());
//            Stage stage = new Stage();
//            stage.initModality(Modality.WINDOW_MODAL);
//            stage.setTitle("Додавання/редагування користувача");
//            stage.setScene(new Scene(root));
//
//            stage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    private boolean showConfirmationDialog(String title, String contentText) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setContentText(contentText);
        return alert.showAndWait().orElse(ButtonType.CANCEL) == ButtonType.OK;
    }

    @FXML
    public void pr6(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pr6-3.fxml"));
            Parent root = loader.load();
            Pr6_3Controller controller = loader.getController();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Практична робота №6");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(btnOtherLabs.getScene().getWindow());
            Scene scene = new Scene(root);
            dialogStage.setScene(scene);

            controller.setDialogStage(dialogStage);

            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
