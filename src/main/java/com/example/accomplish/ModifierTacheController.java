package com.example.accomplish;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

public class ModifierTacheController {


    public DatePicker SetDay_ManualPlanning;
    public TextField TaskName;
    public ComboBox TaskCategory;
    public ComboBox TaskPriority;
    public ComboBox Set_TimeSlot;
    public ComboBox Task_IfLocked;
    public Tache task_test;
    private List<String> values;
    private List<String> values2;

    List<String> checkboxValues ;
    public void initialize(){
        SetDay_ManualPlanning.setDayCellFactory(picker -> new ManualPlannificationController.DatePickerCell());
        SetDay_ManualPlanning.setValue(LocalDate.now());

        task_test = TaskPageController.list_TaskTest.get(0);

        setTask_name(task_test.getTache_name());
        setPriority(task_test.getTache_priorite());
        setCategory(task_test.getTache_categorie().getCategorie_name());
        setTache_locked(task_test.isTache_locked());

    }

    public void modifiertache(MouseEvent event) throws IOException {

        task_test.setTache_name(getTask_name());
        AddNewTaskController.customElements.get(AddNewTaskController.customElements.size()-1).setLabel(getTask_name());
        Project current = Systeme.getCurrentUser().getListe_projet().get(Systeme.getCurrentUser().getListe_projet().size()-1);
        Planning current_planning = current.getList_planning().get(current.getList_planning().size()-1);
        current_planning.getListe_taches().set(current_planning.getListe_taches().size()-1,task_test);

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("pageTasks.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


    public String getDatePicker() {
        return SetDay_ManualPlanning.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public void setTask_name(String tache_name) {
        TaskName.setText(tache_name);
    }
    public String getTask_name(){
        return this.TaskName.getText();
    }
    public String getCategory(){
        return this.TaskCategory.toString();
    }
    public void setPriority(Priorite tache_prio) {
        TaskPriority.setValue(tache_prio);
    }
    public void setCategory(String tache_category) {
        TaskCategory.setValue(tache_category);
    }
    public void setTache_locked(boolean tache_locked) {
        Task_IfLocked.setValue(tache_locked);
    }
    public void setTache_timeslot(String tache_timeslot) {
        Set_TimeSlot.setValue(tache_timeslot);
    }
    public LocalDate getDay(){
        return this.SetDay_ManualPlanning.getValue();
    }
    public String getTimeSlot(){
        return this.Set_TimeSlot.getValue().toString();
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

    public void GoToSettings(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("settings.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    private class DatePickerCell extends javafx.scene.control.DateCell {
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



}
