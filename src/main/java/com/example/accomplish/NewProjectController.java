package com.example.accomplish;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.EventObject;
import java.util.Objects;
import java.util.ResourceBundle;

public class NewProjectController implements Initializable {
    private Stage stage;
    private Parent root;
    private EventObject event;
    public Button addProjectButton;
    public TextField projectTitle;
    public TextArea projectDescription;
    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        projectTitle.setText(Systeme.currentUser.getListe_projet().get(Systeme.currentUser.getListe_projet().size()-1).getProject_name());
        projectDescription.setText(Systeme.currentUser.getListe_projet().get(Systeme.currentUser.getListe_projet().size()-1).getProject_description());
    }
    @FXML
    public void handleAddCategoryButton(MouseEvent event) throws IOException {
        Systeme.currentUser.getListe_projet().get(Systeme.currentUser.getListe_projet().size()-1).setProject_name(projectTitle.getText());
        Systeme.currentUser.getListe_projet().get(Systeme.currentUser.getListe_projet().size()-1).setProject_description(projectDescription.getText());
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("add-new-category.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void handleAddProjectButton(ActionEvent event) throws IOException {

        if ((projectTitle.getLength()==0) || (projectDescription.getLength()==0 || (Systeme.currentUser.getListe_projet().get(Systeme.currentUser.getListe_projet().size()-1)).getProject_categories().size()==0)) {
            showPopup((Stage) addProjectButton.getScene().getWindow(), "Please fill all the fields and add categories!");
        }else {
            Systeme.currentUser.getListe_projet().get(Systeme.currentUser.getListe_projet().size()-1).setProject_name(projectTitle.getText());
            Systeme.currentUser.getListe_projet().get(Systeme.currentUser.getListe_projet().size()-1).setProject_description(projectDescription.getText());
            showPopup((Stage) addProjectButton.getScene().getWindow(), "Project added successfully! " + Systeme.currentUser.getListe_projet().get(Systeme.currentUser.getListe_projet().size()-1).getProject_name() + " " + Systeme.currentUser.getListe_projet().get(Systeme.currentUser.getListe_projet().size()-1).getProject_description());
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("create-planning.fxml")));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    private void showPopup(Stage stage, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Adding a new project");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(stage);
        alert.showAndWait();
    }

}
