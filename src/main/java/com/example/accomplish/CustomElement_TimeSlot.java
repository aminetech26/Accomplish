package com.example.accomplish;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


    public class CustomElement_TimeSlot extends HBox{
        private Spinner<Integer> startHourSpinner;
        private Spinner<Integer> startMinuteSpinner;
        private Spinner<Integer> endHourSpinner;
        private Spinner<Integer> endMinuteSpinner;
        private HBox timeRow = new HBox();

        public CustomElement_TimeSlot() {

            timeRow = new HBox();
            timeRow.getStyleClass().add("scroll-pane");
            timeRow.getStylesheets().add("@style.css");
            timeRow.setAlignment(Pos.CENTER);

            Label startHourLabel = new Label("Start Hour:");
            startHourLabel.setPrefHeight(50);
            startHourLabel.setPrefWidth(125);
            startHourLabel.setStyle("-fx-font-size: 19;");
            HBox.setMargin(startHourLabel, new Insets(0, 0, 0, 50));

            startHourSpinner = new Spinner<>(0, 23, 0);
            startHourSpinner.setPrefHeight(40);
            startHourSpinner.setPrefWidth(80);

            startMinuteSpinner = new Spinner<>(0, 59, 0);
            startMinuteSpinner.setPrefHeight(40);
            startMinuteSpinner.setPrefWidth(80);

            Label endHourLabel = new Label("End Hour:");
            endHourLabel.setPrefHeight(50);
            endHourLabel.setPrefWidth(125);
            endHourLabel.setStyle("-fx-font-size: 19;");
            HBox.setMargin(endHourLabel, new Insets(0, 0, 0, 50));

            endHourSpinner = new Spinner<>(0, 23, 0);
            endHourSpinner.setPrefHeight(40);
            endHourSpinner.setPrefWidth(80);

            endMinuteSpinner = new Spinner<>(0, 59, 0);
            endMinuteSpinner.setPrefHeight(40);
            endMinuteSpinner.setPrefWidth(80);
            timeRow.getChildren().addAll(startHourLabel, startHourSpinner, startMinuteSpinner,
                    endHourLabel, endHourSpinner, endMinuteSpinner);
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

        public HBox getTimeRow() {
            return timeRow;
        }

        public void setTimeRow(HBox timeRow) {
            this.timeRow = timeRow;
        }
    }
