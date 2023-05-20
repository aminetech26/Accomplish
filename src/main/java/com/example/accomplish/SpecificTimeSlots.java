package com.example.accomplish;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
public class SpecificTimeSlots implements Initializable {

    @FXML
    private ChoiceBox<String> Select_the_day;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Create a list of values
        List<String> values = List.of("Value 1", "Value 2", "Value 3", "Value 4");

        // Set the values of the ChoiceBox
        Select_the_day.setItems(FXCollections.observableArrayList(values));
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

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Feed_Page.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public class CustomElement_SpecificTimeSlot extends HBox {

        private Spinner<Integer> startHourSpinner;
        private Spinner<Integer> startMinuteSpinner;
        private Spinner<Integer> endHourSpinner;
        private Spinner<Integer> endMinuteSpinner;
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

            Label startHourLabel = new Label("Start Hour :");
            startHourLabel.setPrefHeight(50);
            startHourLabel.setPrefWidth(110);
            startHourLabel.setStyle("-fx-font-size: 19;");
            HBox.setMargin(startHourLabel, new Insets(0, 0, 0, 50));

            startHourSpinner = new Spinner<>(0, 23, 0);
            startHourSpinner.setPrefHeight(40);
            startHourSpinner.setPrefWidth(80);
            HBox.setMargin(startHourSpinner, new Insets(0, 0, 0, 0));

            startMinuteSpinner = new Spinner<>(0, 59, 0);
            startMinuteSpinner.setPrefHeight(40);
            startMinuteSpinner.setPrefWidth(80);
            HBox.setMargin(startMinuteSpinner, new Insets(0, 0, 0, 0));

            Label endHourLabel = new Label("End Hour :");
            endHourLabel.setPrefHeight(50);
            endHourLabel.setPrefWidth(110);
            endHourLabel.setStyle("-fx-font-size: 19;");
            HBox.setMargin(endHourLabel, new Insets(0, 0, 0, 50));

            endHourSpinner = new Spinner<>(0, 23, 0);
            endHourSpinner.setPrefHeight(40);
            endHourSpinner.setPrefWidth(80);
            HBox.setMargin(endHourSpinner, new Insets(0, 0, 0, 0));

            endMinuteSpinner = new Spinner<>(0, 59, 0);
            endMinuteSpinner.setPrefHeight(40);
            endMinuteSpinner.setPrefWidth(80);
            HBox.setMargin(endMinuteSpinner, new Insets(0, 0, 0, 0));

            timeRow.getChildren().addAll(choiceBox, startHourLabel, startHourSpinner, startMinuteSpinner,
                    endHourLabel, endHourSpinner, endMinuteSpinner);

            freeTimeSlots.getChildren().add(timeRow);
            getChildren().add(freeTimeSlots);
        }

        public int getStartHour() {
            return startHourSpinner.getValue();
        }

        public int getStartMinute() {
            return startMinuteSpinner.getValue();
        }

        public int getEndHour() {
            return endHourSpinner.getValue();
        }

        public int getEndMinute() {
            return endMinuteSpinner.getValue();
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
