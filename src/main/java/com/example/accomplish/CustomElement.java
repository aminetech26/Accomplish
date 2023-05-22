package com.example.accomplish;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CustomElement extends StackPane {

    public CheckBox checkBox;
    private Rectangle rectangle;
    private HBox labelsBox;
    private ComboBox<String> comboBox; // Add ComboBox

    public CheckBox getCheckBox() {
        return this.checkBox;
    }

    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public HBox getLabelsBox() {
        return labelsBox;
    }

    public void setLabelsBox(HBox labelsBox) {
        this.labelsBox = labelsBox;
    }

    public ComboBox<String> getComboBox() {
        return comboBox;
    }

    public void setComboBox(ComboBox<String> comboBox) {
        this.comboBox = comboBox;
    }

    public CustomElement() {
        // Create the CheckBox
        CheckBox checkBox = new CheckBox();
        StackPane.setAlignment(checkBox, Pos.CENTER_LEFT);
        StackPane.setMargin(checkBox, new Insets(10, 10, 0, 25));
        checkBox.setOnAction(TaskPageController.CheckBoxHandler::handleCheckboxAction);
        // Create the rectangle with black shadow
        rectangle = new Rectangle(500, 75);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.WHITE);
        rectangle.setArcWidth(40);
        rectangle.setArcHeight(40);
        rectangle.setEffect(new DropShadow(7, Color.GRAY));
        StackPane.setAlignment(rectangle, Pos.CENTER);
        StackPane.setMargin(rectangle, new Insets(15, 0, 0, 75));

        // Create the labels box
        labelsBox = new HBox(10);
        StackPane.setAlignment(labelsBox, Pos.CENTER);
        StackPane.setMargin(labelsBox, new Insets(35, 0, 0, 125));
        // Create the ComboBox
        ObservableList<String> options = FXCollections.observableArrayList("NOT REALIZED","COMPLETED","IN PROGRESS","CANCELLED","DELAYED");
        comboBox = new ComboBox<>(options);
        StackPane.setMargin(comboBox, new Insets(15, 0, 0, 50));
        comboBox.setPrefSize(150, 50);
        comboBox.getStyleClass().add("combobox-task");
        comboBox.getStylesheets().add("@style.css");
        setAlignment(Pos.CENTER);
        getChildren().addAll(rectangle,comboBox, checkBox, labelsBox);
    }
    public void addLabel(String labelText) {
        Label label = new Label(labelText);
        labelsBox.getChildren().add(label);
    }
}
