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
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import java.util.Objects;

public class ProjectsPageController {
    public Button newProjectButton;
    public Label welcomeText;
    private Stage stage;
    private Parent root;
    private EventObject event;

    public void initialize() {
        // Set the text of the label to "welcome + username".
        welcomeText.setText("Signed in as : " + Systeme.getCurrentUser().getUsername());
    }
    @FXML
    private void handleNewProject(MouseEvent event) throws IOException {
        Project newproject = new Project();
        if(Systeme.currentUser.getListe_projet() == null){
            List<Project> projectList = new ArrayList<Project>();
            projectList.add(newproject);
            Systeme.currentUser.setListe_projet(projectList);
        }else {
            Systeme.currentUser.getListe_projet().add(newproject);
        }
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("add-new-project.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
