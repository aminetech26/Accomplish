package com.example.accomplish;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.EventObject;
import java.util.Objects;

public class HelloController {


    public Label Sing_In;
    public Label Sing_Up;
    public Button LogInButton;
    private Stage stage;
    private Parent root;
    private EventObject event;
    public TextField username;
    public TextField password;


    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void handleLabel1Click(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Sign-Up_Page.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void handleLabel2Click(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void GoToFeedPage(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Feed_Page.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    private void handleSignIn(MouseEvent event) throws IOException {
        String usernameInputField = username.getText();
        String password1InputField = password.getText();
            Utilisateur user = new Utilisateur(usernameInputField, password1InputField);
            if (!(Systeme.getUsers_list().contains(user))) {
                Systeme.authentification(user, "log in");
                showPopup((Stage) LogInButton.getScene().getWindow(), "No such user ! try sign-up");
            }else{
                showPopup((Stage) LogInButton.getScene().getWindow(), "Successful login !" + " Welcome " + usernameInputField);
                Systeme.setCurrentUser(user);
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("projects-page.fxml")));
                stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }
    private void showPopup(Stage stage, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("sign in");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(stage);
        alert.showAndWait();
    }
}

