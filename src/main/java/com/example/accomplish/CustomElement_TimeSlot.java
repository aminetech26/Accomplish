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
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


    public class CustomElement_TimeSlot extends HBox{
        private TextField startHourTextField;
        private TextField endHourTextField;
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

            timeRow.getChildren().addAll(startHourLabel, startHourTextField,
                    endHourLabel, endHourTextField);
        }

        public int getStartHour() {
            String startHourText = startHourTextField.getText();
            return Integer.parseInt(startHourText);
        }


        public int getEndHour() {
            String endHourText = endHourTextField.getText();
            return Integer.parseInt(endHourText);
        }

        public HBox getTimeRow() {
            return timeRow;
        }

        public void setTimeRow(HBox timeRow) {
            this.timeRow = timeRow;
        }
    }
