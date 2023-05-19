package com.example.accomplish;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.EventObject;
import java.util.Objects;

public class SignUpController {
    public Button signUpButton;
    public Label Sing_In;
    public Label Sing_Up;
    public TextField username;
    public TextField password1;
    public TextField password2;
    private Stage stage;
    private Parent root;
    private EventObject event;

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    @FXML
    public void handleLabel2Click(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void handleSignUp(MouseEvent event) throws IOException {
        String usernameInputField = username.getText();
        String password1InputField = password1.getText();
        String password2InputField = password2.getText();
        if(password1InputField.compareTo(password2InputField) == 0) {
            Utilisateur user = new Utilisateur(usernameInputField, password1InputField);
            if (!(Systeme.getUsers_list().contains(user))) {
                Systeme.authentification(user, "sign up");
                showPopup((Stage) signUpButton.getScene().getWindow(), "Successful sign up");
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
                stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }else{
                showPopup((Stage) signUpButton.getScene().getWindow(), "User already exists ! try log-in");
            }
        }else{
            showPopup((Stage) signUpButton.getScene().getWindow(), "error ! password doesn't match! ");
        }
    }
    private void showPopup(Stage stage, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("sign up");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(stage);
        alert.showAndWait();
    }
}

