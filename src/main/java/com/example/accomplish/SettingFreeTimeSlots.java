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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class SettingFreeTimeSlots implements Initializable {
    public Button confirmCreneau;
    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        if (Creneau.customElement_timeSlots.size()>0) {
            for (CustomElement_TimeSlot custom : Creneau.customElement_timeSlots) {
                free_time_slots.setSpacing(15);
                free_time_slots.setAlignment(Pos.CENTER);
                free_time_slots.setStyle("-fx-background-color: #FFFFFF;");
                free_time_slots.getChildren().add(custom.getTimeRow());
            }
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

    @FXML
    public ScrollPane scroller;
    @FXML
    private VBox free_time_slots;

    public void GoToSpecifci_time_slot_page(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("specific-time-slots.fxml")));
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
    public void Confirm(ActionEvent event) throws IOException {
        Project current = Systeme.getCurrentUser().getListe_projet().get(Systeme.getCurrentUser().getListe_projet().size()-1);
        Planning planning = current.getList_planning().get(current.getList_planning().size()-1);
        List<Journee> journeeList = planning.getPeriode().getList_journee();
        showPopup((Stage) confirmCreneau.getScene().getWindow(), "Heure debut : " + String.valueOf(journeeList.get(0).getToday_creneaus().get(0).getHeure_debut()) + " Heure fin : " + String.valueOf(journeeList.get(0).getToday_creneaus().get(0).getHeure_fin()));
        Creneau.customElement_timeSlots = new ArrayList<CustomElement_TimeSlot>();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Feed_Page.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void Add_time_slot(ActionEvent event) throws IOException {
        CustomElement_TimeSlot customElement = new CustomElement_TimeSlot();
        free_time_slots.setSpacing(15);
        free_time_slots.setAlignment(Pos.CENTER);
        free_time_slots.setStyle("-fx-background-color: #FFFFFF;");
        free_time_slots.getChildren().add(customElement.getTimeRow());
        if (!Creneau.customElement_timeSlots.isEmpty()){
            Creneau creneau_libre = new Creneau();
            creneau_libre.setHeure_debut(Creneau.customElement_timeSlots.get(Creneau.customElement_timeSlots.size()-1).getStartHour());
            //creneau_libre.setMinutes_debut(Creneau.customElement_timeSlots.get(Creneau.customElement_timeSlots.size()-1).getStartMinute());
            creneau_libre.setHeure_fin(Creneau.customElement_timeSlots.get(Creneau.customElement_timeSlots.size()-1).getEndHour());
            //creneau_libre.setMinutes_fin(Creneau.customElement_timeSlots.get(Creneau.customElement_timeSlots.size()-1).getEndMinute());
            for (Journee journee:Systeme.currentUser.getListe_projet().get(Systeme.currentUser.getListe_projet().size()-1).getList_planning().get(Systeme.currentUser.getListe_projet().get(Systeme.currentUser.getListe_projet().size()-1).getList_planning().size()-1).getPeriode().getList_journee()) {
                journee.getToday_creneaus().add(creneau_libre);
            }
        }
        Creneau.customElement_timeSlots.add(customElement);
    }
}
