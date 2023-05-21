package com.example.accomplish;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;


public class FeedPageController implements Initializable {

    @FXML
    public ScrollPane scrollpane;
    @FXML
    public static Button Auto_Planning ;
    @FXML
    public static Button Manual_Planning ;

    @FXML
    private DatePicker datePicker;
    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        //datePicker.show();
        datePicker.setValue(LocalDate.now());
    }

    public VBox task; // Remove the @FXML annotation

    public FeedPageController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pageTasks.fxml"));
        fxmlLoader.setController(this);
        try {
            Parent parent = fxmlLoader.load();
            // Access the task VBox using the fx:id
            task = (VBox) fxmlLoader.getNamespace().get("task");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void GotoHome(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Feed_Page.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void GoToTasksPage(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("pageTasks.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void CreateTask(MouseEvent event) throws IOException {

        /*try {
            // Load the FXML file for the pop-up content
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add-new-task.fxml"));
            Parent content = fxmlLoader.load();

            // Create a dialog stage for the pop-up
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.initStyle(StageStyle.UTILITY);
            dialogStage.setTitle("Popup");
            dialogStage.setScene(new Scene(content));

            // Show the pop-up
            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }*/

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("add-new-task.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();



    }

    private int task_number = 0;
    private List<CheckBox> checkBoxes;
    private int checkBoxCounter = 0;
    public void AddCustomElement(){
        task_number++;
        CustomElement customElement = new CustomElement();

        customElement.checkBox = new CheckBox();
        customElement.checkBox.setId("checkbox_" + checkBoxCounter);
        checkBoxes = new ArrayList<>();
        checkBoxes.add(customElement.checkBox);
        checkBoxCounter++;
        customElement.addLabel("Task " + task_number + " checkbox_ " + checkBoxCounter);
        task.getChildren().add(customElement);
    }

    public void GoToManualPlanning(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("manual-plannification.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void GoToSettings(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("settings.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public class CheckboxHandler {
        private static int selectedCheckBoxesCounter = 0;


        public static void handleCheckboxAction(ActionEvent event) {
            CheckBox checkBox = (CheckBox) event.getSource();
            boolean isSelected = checkBox.isSelected();

            // Perform the desired actions based on the checkbox selection
            if (isSelected) {
                // Checkbox is selected
                selectedCheckBoxesCounter++; // Increment the counter
            } else {
                // Checkbox is deselected
                selectedCheckBoxesCounter--; // Decrement the counter
            }

            System.out.println("Counter: " + selectedCheckBoxesCounter);

            Auto_Planning.setVisible(CheckboxHandler.selectedCheckBoxesCounter >= 2);
            Manual_Planning.setPrefWidth(50);

            /*if (selectedCheckBoxesCounter >= 2) {
                // Set the label to be invisible
                label.setVisible(false);
            } else {
                // Set the label to be visible
                label.setVisible(true);
            }*/



        }

        public static int getSelectedCheckBoxesCounter() {
            return selectedCheckBoxesCounter;
        }
    }

}