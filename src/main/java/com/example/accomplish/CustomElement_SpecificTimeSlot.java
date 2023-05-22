package com.example.accomplish;


import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
public class CustomElement_SpecificTimeSlot extends HBox {

    private TextField startHourTextField;
    private TextField endHourTextField;
    private HBox timeRow = new HBox();
    private ChoiceBox<String> choiceBox;
    public CustomElement_SpecificTimeSlot() {

        timeRow = new HBox();
        timeRow.getStyleClass().add("scroll-pane");
        timeRow.getStylesheets().add("@style.css");
        timeRow.setAlignment(Pos.CENTER);

        choiceBox = new ChoiceBox<>();
        choiceBox.setPrefHeight(40);
        choiceBox.setPrefWidth(150);
        HBox.setMargin(choiceBox, new Insets(0, 0, 0, 25));

        Label startHourLabel = new Label("Start :");
        startHourLabel.setPrefHeight(50);
        startHourLabel.setPrefWidth(125);
        startHourLabel.setStyle("-fx-font-size: 19;");
        HBox.setMargin(startHourLabel, new Insets(0, 0, 0, 50));

        startHourTextField = new TextField();
        startHourTextField.setPrefHeight(40);
        startHourTextField.setPrefWidth(120);
        startHourTextField.setEditable(true);

        Label endHourLabel = new Label("End :");
        endHourLabel.setPrefHeight(50);
        endHourLabel.setPrefWidth(125);
        endHourLabel.setStyle("-fx-font-size: 19;");
        HBox.setMargin(endHourLabel, new Insets(0, 0, 0, 50));

        endHourTextField = new TextField();
        endHourTextField.setPrefHeight(40);
        endHourTextField.setPrefWidth(120);
        endHourTextField.setEditable(true);

        timeRow.getChildren().addAll(choiceBox, startHourLabel, startHourTextField,
                endHourLabel, endHourTextField);

    }

    public TextField getStartHourTextField() {
        return startHourTextField;
    }

    public void setStartHourTextField(TextField startHourTextField) {
        this.startHourTextField = startHourTextField;
    }

    public TextField getEndHourTextField() {
        return endHourTextField;
    }

    public void setEndHourTextField(TextField endHourTextField) {
        this.endHourTextField = endHourTextField;
    }

    public HBox getTimeRow() {
        return timeRow;
    }

    public void setTimeRow(HBox timeRow) {
        this.timeRow = timeRow;
    }

    public ChoiceBox<String> getChoiceBox() {
        return choiceBox;
    }

    public void setChoiceBox(ChoiceBox<String> choiceBox) {
        this.choiceBox = choiceBox;
    }
}