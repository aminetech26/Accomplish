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
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AddNewTaskController {

    public ImageView fermer_popup;
    public TextField taskDuration;
    public static List<CustomElement> customElements = new ArrayList<CustomElement>();


    @FXML
    public static Button Auto_Planning;
    @FXML
    public static Button Manual_Planning;

    public RadioButton yesRadioButton;
    public RadioButton noRadioButton;
    public DatePicker taskDeadline;
    public TextField taskName;
    public ComboBox taskPriority;
    public ComboBox taskCategory;
    public ComboBox taskType;
    public ComboBox locked;
    public List<String> category_names;

    public Button addTaskButton;

    public void initialize() {

        category_names = new ArrayList<>();
        for (Categorie categorie : Systeme.getCurrentUser().getListe_projet().get(Systeme.getCurrentUser().getListe_projet().size() - 1).getProject_categories()) {
            category_names.add(categorie.getCategorie_name());
        }

        taskType.getItems().addAll("simple", "decomposable");
        taskCategory.getItems().addAll(category_names);
        taskPriority.getItems().addAll("HIGH", "MEDIUM", "LOW");
        locked.getItems().addAll("YES", "NO");
        taskDeadline.setDayCellFactory(picker -> new DatePickerCell());

        ToggleGroup toggleGroup = new ToggleGroup();
        noRadioButton.setToggleGroup(toggleGroup);
        yesRadioButton.setToggleGroup(toggleGroup);

        taskDeadline.setDayCellFactory(picker -> new AddNewTaskController.DatePickerCell());
        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == yesRadioButton) {
                taskDeadline.setDisable(false); // Enable the secondDatePicker
            } else {
                taskDeadline.setDisable(true); // Disable the secondDatePicker
            }
        });

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
    public void BackToTasksPage(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("pageTasks.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private int checkBoxCounter = 0;

    @FXML
    public void handleAddTaskButton(ActionEvent event) throws IOException {
        Categorie categorie = new Categorie();
        for (Categorie categ:Systeme.getCurrentUser().getListe_projet().get(Systeme.getCurrentUser().getListe_projet().size()-1).getProject_categories()) {
            if (categ.getCategorie_name().compareTo(taskCategory.getValue().toString())==0){
                categorie = categ;
                break;
            }
        }
        boolean decomposable;
        if(taskType.getValue().toString().compareTo("decomposable")==0){
            decomposable = true;
        }else {
            decomposable = false;
        }
        boolean isLocked;
        if(locked.getValue().toString().compareTo("YES")==0){
            isLocked = true;
        }else {
            isLocked = false;
        }
        Tache new_task = new Tache(taskName.getText(),Priorite.valueOf(taskPriority.getValue().toString()),yesRadioButton.isSelected(),taskDeadline.getValue(),categorie,decomposable,isLocked);
        new_task.setTache_etat_realisation(Etat_Realisation.NOTREALIZED);
        new_task.setScheduled(false);
        LocalTime duree = LocalTime.parse(taskDuration.getText(), DateTimeFormatter.ofPattern("HH:mm"));
        new_task.setDuree(duree);
        Systeme.getCurrentUser().getListe_projet().get(Systeme.getCurrentUser().getListe_projet().size()-1).getList_planning().get(Systeme.getCurrentUser().getListe_projet().get(Systeme.getCurrentUser().getListe_projet().size()-1).getList_planning().size()-1).getListe_taches().add(new_task);
        CustomElement customElement = new CustomElement();
        customElement.addLabel(new_task.getTache_name());
        customElements.add(customElement);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pageTasks.fxml"));
        TaskPageController taskspagecontroller = fxmlLoader.getController();
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
