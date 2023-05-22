package com.example.accomplish;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Objects;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
public class SpecificTimeSlots implements Initializable {
    public Button confirmSpecificTimeSlots;
    @FXML
    private ChoiceBox<String> Select_the_day;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

private void showPopup(Stage stage, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("sign up");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(stage);
        alert.showAndWait();
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

    public void Confirm(ActionEvent event)throws IOException {
        Project current = Systeme.getCurrentUser().getListe_projet().get(Systeme.getCurrentUser().getListe_projet().size()-1);
        Planning planning = current.getList_planning().get(current.getList_planning().size()-1);
        List<Journee> journeePeriode = planning.getPeriode().getList_journee();
        LocalDate date = LocalDate.parse(Creneau.customElement_specificTimeSlots.get(Creneau.customElement_specificTimeSlots.size()-1).getChoiceBox().getValue());
        Creneau creneau_libre = new Creneau();
        LocalTime debutCrenau = LocalTime.parse((Creneau.customElement_specificTimeSlots.get(Creneau.customElement_specificTimeSlots.size()-1).getStartHourTextField().getText()), DateTimeFormatter.ofPattern("HH:mm"));
        creneau_libre.setDebutCrenau(debutCrenau);
        LocalTime finCrenau = LocalTime.parse((Creneau.customElement_specificTimeSlots.get(Creneau.customElement_specificTimeSlots.size()-1).getEndHourTextField().getText()), DateTimeFormatter.ofPattern("HH:mm"));
        creneau_libre.setFinCrenau(finCrenau);
        creneau_libre.setFinCrenau(finCrenau);
        creneau_libre.setDuree(Duration.between(debutCrenau, finCrenau).toMinutes());
        for (Journee journee : journeePeriode) {
            if (journee.getDate().equals(date)) {
                journee.getToday_creneaus().add(creneau_libre);
            }
        }
        String creneau = "";
        for (Journee journee:journeePeriode) {
                for (Creneau creneau1:journee.getToday_creneaus()) {
                    creneau = creneau + " Debut crenau : " + String.valueOf(creneau1.getDebutCrenau()) + " Fin Creneau : "+String.valueOf(creneau1.getFinCrenau());
                }
        }
        showPopup((Stage) confirmSpecificTimeSlots.getScene().getWindow(), creneau);
        Creneau.customElement_specificTimeSlots = new ArrayList<CustomElement_SpecificTimeSlot>();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("setting-free-time-slots.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public ScrollPane scroller;
    @FXML
    private VBox specific_free_time_slots;

    public void Add_specific_freetime_slot(MouseEvent event) {
        CustomElement_SpecificTimeSlot customElement = new CustomElement_SpecificTimeSlot();
        // Create a list of values
        List<Journee> journeeList = new ArrayList<Journee>();
        Project current_project =  Systeme.getCurrentUser().getListe_projet().get(Systeme.getCurrentUser().getListe_projet().size()-1);
        Planning planning = current_project.getList_planning().get(current_project.getList_planning().size()-1);
        journeeList = planning.getPeriode().getList_journee();
        List<String> values = new ArrayList<String>();
        for (Journee journee:journeeList) {
            values.add(journee.getDate().toString());
        }
        // Set the values of the ChoiceBox
        customElement.getChoiceBox().setItems(FXCollections.observableArrayList(values));
        specific_free_time_slots.setSpacing(15);
        specific_free_time_slots.setAlignment(Pos.CENTER);
        specific_free_time_slots.setStyle("-fx-background-color: #FFFFFF;");
        specific_free_time_slots.getChildren().add(customElement.getTimeRow());
        List<Journee> journeePeriode = planning.getPeriode().getList_journee();
        if (!Creneau.customElement_specificTimeSlots.isEmpty()) {
            Creneau creneau_libre = new Creneau();
            LocalDate date = LocalDate.parse(Creneau.customElement_specificTimeSlots.get(Creneau.customElement_specificTimeSlots.size()-1).getChoiceBox().getValue());
            LocalTime debutCrenau = LocalTime.parse((Creneau.customElement_specificTimeSlots.get(Creneau.customElement_specificTimeSlots.size()-1).getStartHourTextField().getText()), DateTimeFormatter.ofPattern("HH:mm"));
            creneau_libre.setDebutCrenau(debutCrenau);
            LocalTime finCrenau = LocalTime.parse((Creneau.customElement_specificTimeSlots.get(Creneau.customElement_specificTimeSlots.size()-1).getEndHourTextField().getText()), DateTimeFormatter.ofPattern("HH:mm"));
            creneau_libre.setFinCrenau(finCrenau);
            creneau_libre.setDuree(Duration.between(debutCrenau, finCrenau).toMinutes());
            for (Journee journee : journeePeriode) {
                if (journee.getDate().equals(date)) {
                    journee.getToday_creneaus().add(creneau_libre);
                }
            }
        }
        Creneau.customElement_specificTimeSlots.add(customElement);
    }
}
