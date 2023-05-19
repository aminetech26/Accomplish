package com.example.accomplish;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import java.util.Objects;

public class NewCategoryController extends Node {
    private Stage stage;
    private Parent root;
    private EventObject event;
    public Button addCategoryButton;
    public TextField categoryName;
    public ColorPicker colorPicker;

    @FXML
    private void handleSaveCategory(MouseEvent event) throws IOException {
        if (categoryName.getLength()==0) {
            showPopup((Stage) addCategoryButton.getScene().getWindow(), "Please fill category name!");
        }else {
            Categorie newcategory = new Categorie(categoryName.getText(),colorPicker.toString());
            Systeme.currentUser.getListe_projet().get(Systeme.currentUser.getListe_projet().size()-1).add_categorie(newcategory.getCategorie_name(),newcategory.getCategorie_color());
            showPopup((Stage) addCategoryButton.getScene().getWindow(), "Category added successfully to the project!");
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("add-new-project.fxml")));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    private void showPopup(Stage stage, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Adding a new category");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(stage);
        alert.showAndWait();
    }
}
