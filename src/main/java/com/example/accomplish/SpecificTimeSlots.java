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
import java.time.format.DateTimeFormatter;
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
        // Create a list of values
        List<Journee> journeeList = new ArrayList<Journee>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Project current_project =  Systeme.getCurrentUser().getListe_projet().get(Systeme.getCurrentUser().getListe_projet().size()-1);
        Planning planning = current_project.getList_planning().get(current_project.getList_planning().size()-1);
        journeeList = planning.getPeriode().getList_journee();
        List<String> values = new ArrayList<String>();
        for (Journee journee:journeeList) {
            values.add(journee.getDate().format(formatter));
        }
        // Set the values of the ChoiceBox
        Select_the_day.setItems(FXCollections.observableArrayList(values));
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
        Project current_project =  Systeme.getCurrentUser().getListe_projet().get(Systeme.getCurrentUser().getListe_projet().size()-1);
        showPopup((Stage) confirmSpecificTimeSlots.getScene().getWindow(), current_project.getProject_name()+" size of list planning : "+ String.valueOf(current_project.getList_planning().size()));
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("setting-free-time-slots.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public class CustomElement_SpecificTimeSlot extends HBox {

        private TextField startHourTextField;
        private TextField endHourTextField;
        private ChoiceBox<String> choiceBox;

        public CustomElement_SpecificTimeSlot() {
            VBox freeTimeSlots = new VBox();
            freeTimeSlots.setSpacing(15);
            freeTimeSlots.setAlignment(Pos.CENTER);
            freeTimeSlots.setStyle("-fx-background-color: #FFFFFF;");

            HBox timeRow = new HBox();
            timeRow.getStyleClass().add("scroll-pane");
            timeRow.getStylesheets().add("@style.css");
            timeRow.setAlignment(Pos.CENTER);

            choiceBox = new ChoiceBox<>();
            choiceBox.setItems(FXCollections.observableArrayList("Option 1", "Option 2", "Option 3"));
            choiceBox.setPrefHeight(40);
            choiceBox.setPrefWidth(150);
            HBox.setMargin(choiceBox, new Insets(0, 0, 0, 25));

            Label startHourLabel = new Label("Start Hour:");
            startHourLabel.setPrefHeight(50);
            startHourLabel.setPrefWidth(125);
            startHourLabel.setStyle("-fx-font-size: 19;");
            HBox.setMargin(startHourLabel, new Insets(0, 0, 0, 50));

            TextField startHourTextField = new TextField();
            startHourTextField.setPrefHeight(40);
            startHourTextField.setPrefWidth(120);
            startHourTextField.setEditable(true);

            Label endHourLabel = new Label("End Hour:");
            endHourLabel.setPrefHeight(50);
            endHourLabel.setPrefWidth(125);
            endHourLabel.setStyle("-fx-font-size: 19;");
            HBox.setMargin(endHourLabel, new Insets(0, 0, 0, 50));

            TextField endHourTextField = new TextField();
            endHourTextField.setPrefHeight(40);
            endHourTextField.setPrefWidth(120);
            endHourTextField.setEditable(true);

            timeRow.getChildren().addAll(choiceBox, startHourLabel, startHourTextField,
                    endHourLabel, endHourTextField);

            freeTimeSlots.getChildren().add(timeRow);
            getChildren().add(freeTimeSlots);
        }

        public int getStartHour() {
            String startHourText = startHourTextField.getText();
            return Integer.parseInt(startHourText);
        }


        public int getEndHour() {
            String endHourText = endHourTextField.getText();
            return Integer.parseInt(endHourText);
        }
    }


    @FXML
    public ScrollPane scroller;
    @FXML
    private VBox specific_free_time_slots;

    public void Add_specific_freetime_slot(MouseEvent event) {
        CustomElement_SpecificTimeSlot customElement = new CustomElement_SpecificTimeSlot();
        specific_free_time_slots.getChildren().add(customElement);
    }
}
