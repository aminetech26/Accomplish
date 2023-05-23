package com.example.accomplish;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class TaskPageController implements Initializable {
    public VBox vbox;
    public Button Manual_Planning;
    public Button automatic_plannification;
    public ScrollPane scrollpane;
    public DatePicker datePicker;

    public static List<Tache> list_TaskTest = new ArrayList<Tache>();

    public class CheckBoxHandler {
        private static int selectedCheckBoxesCounter = 0;
        private static int checkBoxCounter = 0;
        public static void handleCheckboxAction (ActionEvent event){

            CheckBox checkBox = (CheckBox) event.getSource();
            boolean isSelected = checkBox.isSelected();
            Parent root = checkBox.getScene().getRoot();
            Button manuel = (Button) root.lookupAll(".button").stream()
                    .filter(node -> node instanceof Button)
                    .map(node -> (Button) node)
                    .filter(button -> button.getText().equals("Manual planification"))
                    .findFirst()
                    .orElse(null);
            Button automatic = (Button) root.lookupAll(".button").stream()
                    .filter(node -> node instanceof Button)
                    .map(node -> (Button) node)
                    .filter(button -> button.getText().equals("Automatic planification"))
                    .findFirst() // Use findFirst() to get a single button (assuming there is only one)
                    .orElse(null);
            // Perform the desired actions based on the checkbox selection
            if (isSelected) {
                // Checkbox is selected
                selectedCheckBoxesCounter++; // Increment the counter
            } else {
                // Checkbox is deselected
                selectedCheckBoxesCounter--; // Decrement the counter
            }
            System.out.println("Counter: " + selectedCheckBoxesCounter);
            if (selectedCheckBoxesCounter>2){
                automatic.setDisable(false);
                manuel.setDisable(true);
            } else if (selectedCheckBoxesCounter==1) {
                manuel.setDisable(false);
                automatic.setDisable(true);
            }else {
                automatic.setDisable(true);
                manuel.setDisable(true);
            }

            //*** Giving id to checkbox ***//

            /*checkBox.setId(String.valueOf(checkBoxCounter));
            checkBoxCounter++;*/


            //****************//
        }
    }
    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        automatic_plannification.setDisable(true);
        Manual_Planning.setDisable(true);
        if (AddNewTaskController.customElements.size()!=0){
        for (CustomElement custom:AddNewTaskController.customElements) {
            AddCustomElement(custom);
        }

        scrollpane.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, null)));
        vbox.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, null)));

        }

        datePicker.setValue(LocalDate.now());
        datePicker.show();

    }
    public void GotoHome (MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Feed_Page.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void handleAutomaticPlannification (ActionEvent event) throws IOException {
        Project current = Systeme.getCurrentUser().getListe_projet().get(Systeme.getCurrentUser().getListe_projet().size()-1);
        Planning current_planning = current.getList_planning().get(current.getList_planning().size()-1);
        showPopup((Stage) automatic_plannification.getScene().getWindow(),current_planning.getListe_taches().get(current_planning.getListe_taches().size()-1).getTache_name());
        current_planning.trier_tache();
        current_planning.plannification_automatique_avec_periode(current_planning.getListe_taches());
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ListTasks.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void GoToTasksPage (MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("pageTasks.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void CreateTask (MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("add-new-task.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    private void showPopup(Stage stage, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("sign up");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(stage);
        alert.showAndWait();
    }

    public void GoToManualPlanning (ActionEvent event) throws IOException {

        Project current = Systeme.getCurrentUser().getListe_projet().get(Systeme.getCurrentUser().getListe_projet().size()-1);
        Planning planning = current.getList_planning().get(current.getList_planning().size()-1);
        Tache task = planning.getListe_taches().get(planning.getListe_taches().size()-1);
        showPopup((Stage) Manual_Planning.getScene().getWindow(),task.getTache_name());

        list_TaskTest.add(task);

        /*Task_Test taskTest = new Task_Test(task.getTache_name(),task.getTache_priorite(),task.getTache_categorie(),false);
        list_TaskTest.add(taskTest);*/

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("manual-plannification.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    private int task_number = 0;
    private List<CheckBox> checkBoxes;
    private int checkBoxCounter = 0;
    public void AddCustomElement(CustomElement customElement){
        vbox.getChildren().add(customElement);
    }
    public void GoToSettings (MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("settings.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

