package com.example.accomplish;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
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
import javafx.util.Pair;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.time.LocalDate.parse;

public class ManualPlannificationController {
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
            SetDay_ManualPlanning.setDayCellFactory(picker -> new DatePickerCell());
            SetDay_ManualPlanning.setValue(LocalDate.now());

            task_test = TaskPageController.list_TaskTest.get(0);

        setTask_name(task_test.getTache_name());
        setPriority(task_test.getTache_priorite());
        setCategory(task_test.getTache_categorie().getCategorie_name());
        setTache_locked(task_test.isTache_locked());
        Set_TimeSlot.setDisable(true);

        Task_IfLocked.setDisable(true);
        TaskPriority.setDisable(true);
        TaskCategory.setDisable(true);
        TaskName.setDisable(true);

        // Create a list of values
        List<Journee> journeeList = new ArrayList<Journee>();
        Project current_project =  Systeme.getCurrentUser().getListe_projet().get(Systeme.getCurrentUser().getListe_projet().size()-1);
        Planning planning = current_project.getList_planning().get(current_project.getList_planning().size()-1);
        journeeList = planning.getPeriode().getList_journee();
        final List<Creneau>[] creneaux = new List[]{new ArrayList<Creneau>()};

            //******

        List<Journee> finalJourneeList = journeeList;
        SetDay_ManualPlanning.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                Set_TimeSlot.setDisable(false);
                checkboxValues = new ArrayList<>();
                for (int i = 0; i < finalJourneeList.size(); i++) {
                    if (getDatePicker().equals(finalJourneeList.get(i).getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))) ){
                        creneaux[0] = finalJourneeList.get(i).today_creneaus;

                        values = new ArrayList<>();
                        values2 = new ArrayList<>();

                        for (Creneau creneau: creneaux[0]) {
                            //values.add(LocalDate.parse(LocalTime.parse(creneau.getDebutCrenau().toString()).toString()));
                            values.add(creneau.getDebutCrenau().format(DateTimeFormatter.ofPattern("HH:mm")));
                        }
                        for (Creneau creneau: creneaux[0]) {
                            //values.add(LocalDate.parse(LocalTime.parse(creneau.getDebutCrenau().toString()).toString()));
                            values2.add(creneau.getFinCrenau().format(DateTimeFormatter.ofPattern("HH:mm")));
                        }

                        // Set the values of the ChoiceBox

                        for (int j = 0; j < values.size(); j++) {
                            String checkboxValue = values.get(j) + " TO " + values2.get(j);
                            checkboxValues.add(checkboxValue);
                        }
                        Set_TimeSlot.setItems(FXCollections.observableArrayList(checkboxValues));
                    }


                }
            }


        });


    }


    public String getDatePicker() {
        return SetDay_ManualPlanning.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public void setTask_name(String tache_name) {
        TaskName.setText(tache_name);
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

    public void Plan_Manual(ActionEvent event) throws IOException {

        List<Journee> journeeList;
        Project current_project =  Systeme.getCurrentUser().getListe_projet().get(Systeme.getCurrentUser().getListe_projet().size()-1);
        Planning planning = current_project.getList_planning().get(current_project.getList_planning().size()-1);
        journeeList = planning.getPeriode().getList_journee();
        List<Creneau> creneaux;

        for (int i = 0; i < journeeList.size(); i++) {
            journeeList.get(i).setCrenauDurations();
            if (getDatePicker().equals(journeeList.get(i).getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))) ) {
                creneaux = journeeList.get(i).today_creneaus;
                for (int l = 0; l < creneaux.size(); l++){
                    if ( (creneaux.get(l).getDebutCrenau().format((DateTimeFormatter.ofPattern("HH:mm"))).equals(getTimeSlot().substring(0,5))) && (creneaux.get(l).getFinCrenau().format((DateTimeFormatter.ofPattern("HH:mm"))).equals(getTimeSlot().substring(9,14)) )){
                        Pair<Tache, Creneau> pair = new Pair<Tache, Creneau>(task_test, creneaux.get(l));
                        journeeList.get(l).getTache_plannifiee().add(pair);
                        journeeList.get(l).today_creneaus.remove(journeeList.get(l).today_creneaus.get(l));
                        journeeList.get(l).getCreneau_duree().remove(journeeList.get(l).getCreneau_duree().get(l));
                        System.out.println("creneau trouve");


                        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ListTasks.fxml")));
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();

                    }
                }
            }
            }


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

