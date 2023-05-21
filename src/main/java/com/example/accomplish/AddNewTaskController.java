package com.example.accomplish;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AddNewTaskController {

    public VBox task;
    public ImageView fermer_popup;

    @FXML
    public static Button Auto_Planning;
    @FXML
    public static Button Manual_Planning;

    public VBox vbox;
    public RadioButton yesRadioButton;
    public RadioButton noRadioButton;
    public DatePicker Date;
    public ComboBox priority;
    public ComboBox category;
    public ComboBox tasktype;
    public ComboBox locked;
    public List<String> category_names;

    public void initialize() {

        category_names = new ArrayList<>();
        for (Categorie categorie : Systeme.getCurrentUser().getListe_projet().get(Systeme.getCurrentUser().getListe_projet().size() - 1).getProject_categories()) {
            category_names.add(categorie.getCategorie_name());
        }

        tasktype.getItems().addAll("simple", "decomposable");
        category.getItems().addAll(category_names);
        priority.getItems().addAll("HIGH", "MEDIUM", "LOW");
        locked.getItems().addAll("YES", "NO");

        ToggleGroup toggleGroup = new ToggleGroup();
        noRadioButton.setToggleGroup(toggleGroup);
        yesRadioButton.setToggleGroup(toggleGroup);

        Date.setDayCellFactory(picker -> new AddNewTaskController.DatePickerCell());
        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == yesRadioButton) {
                Date.setDisable(false); // Enable the secondDatePicker
            } else {
                Date.setDisable(true); // Disable the secondDatePicker
            }
        });
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

    public class DatePickerCell extends javafx.scene.control.DateCell {
        @Override
        public void updateItem(LocalDate item, boolean empty) {
            super.updateItem(item, empty);

            // Disable selection of dates before today
            setDisable(empty || item.isBefore(LocalDate.now()));

            // Show a warning for disabled dates
            if (item.isBefore(LocalDate.now())) {
                setTooltip(new Tooltip("Please select a date that is not in the past."));
            }
        }
    }

    public AddNewTaskController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add-new-task.fxml"));
        fxmlLoader.setController(this);
        /*try {
            Parent parent = fxmlLoader.load();
            // Access the task VBox using the fx:id
            task = (VBox) fxmlLoader.getNamespace().get("task");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
/*
    public void AddTask(ActionEvent event) throws IOException {
        /*Stage stage = (Stage) fermer_popup.getScene().getWindow();
        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pageTasks.fxml"));
        Parent root = fxmlLoader.load();

        FeedPageController taskspagecontroller = fxmlLoader.getController();
        taskspagecontroller.AddCustomElement();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pageTasks.fxml"));
        Parent root = fxmlLoader.load();

        FeedPageController taskspagecontroller = fxmlLoader.getController();
        taskspagecontroller.AddCustomElement();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
*/
    public void BackToTasksPage(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("pageTasks.fxml")));
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

        }

    }
}
