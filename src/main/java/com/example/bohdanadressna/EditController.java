package com.example.bohdanadressna;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditController {

    private CollectionAddressBook addressBookImpl;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnOk;

    @FXML
    private TextField txtPhoneNum;

    @FXML
    private TextField txtPip;

    @FXML
    private Label error;

    private Person person;

    private boolean okClicked = false;

    private Stage dialogStage;

    private HelloController helloController;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setPerson(Person person) {
        this.person = person;
        txtPip.setText(person.getPip());
        txtPhoneNum.setText(person.getPhone());
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void onOkButtonClicked(ActionEvent event) {
        try {
            // Отримую значення з текстових полів
            String pipValue = txtPip.getText().trim();
            String phoneValue = txtPhoneNum.getText().trim();

            if (pipValue.isEmpty() || phoneValue.isEmpty()) {
                error.setText("Заповніть поля!");
            } else {
                error.setText("");

                person.setPip(pipValue);
                person.setPhone(phoneValue);
                okClicked = true;

                if (addressBookImpl != null) {
                    if (!addressBookImpl.getPersonList().contains(person)) {
                        addressBookImpl.add(person);
                    }
                }

                dialogStage.close();

                if (helloController != null) {
                    helloController.getUpdateCountLabel();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        event.consume();
    }






    @FXML
    private void onCancelButtonClicked(ActionEvent event) {
        try {
            dialogStage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        event.consume();
    }


    public void setHelloController(HelloController helloController) {
        this.helloController = helloController;
    }

    public void setAddressBookImpl(CollectionAddressBook addressBookImpl) {
        this.addressBookImpl = addressBookImpl;
    }

}


