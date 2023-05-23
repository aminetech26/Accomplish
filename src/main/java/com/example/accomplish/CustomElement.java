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
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class CustomElement extends StackPane {

    public CheckBox checkBox;
    private Rectangle rectangle;
    private HBox labelsBox;
    public Label label = new Label();
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
        rectangle = new Rectangle(625, 75);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.WHITE);
        rectangle.setArcWidth(40);
        rectangle.setArcHeight(40);
        rectangle.setEffect(new DropShadow(7, Color.GRAY));
        StackPane.setAlignment(rectangle, Pos.CENTER);
        StackPane.setMargin(rectangle, new Insets(15, 0, 0, 75));

        // Create the labels box
        labelsBox = new HBox(10);
        StackPane.setAlignment(labelsBox, Pos.CENTER_LEFT);
        StackPane.setMargin(labelsBox, new Insets(35, 0, 0, 450));
        // Create the ComboBox
        ObservableList<String> options = FXCollections.observableArrayList(
                "NOT REALIZED", "COMPLETED", "IN PROGRESS", "CANCELLED", "DELAYED");
        comboBox = new ComboBox<>(options);
        comboBox.setEditable(false);
        comboBox.setDisable(false);
        comboBox.setPromptText("Select status"); // Optional: Display a prompt text
        comboBox.setValue("NOT REALIZED"); // Optional: Set a default value
        StackPane.setAlignment(comboBox, Pos.CENTER_LEFT);
        StackPane.setMargin(comboBox, new Insets(15, 0, 0, 75));
        comboBox.setPrefSize(175, 75);
        comboBox.getStyleClass().add("combobox-task");
        comboBox.getStylesheets().add("@style.css");

        setAlignment(Pos.CENTER);
        getChildren().addAll(rectangle,comboBox, checkBox, labelsBox);

        // Add the Text element
        Text text = new Text("Task title :");
        text.setStrokeType(StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setTextAlignment(TextAlignment.CENTER);
        Font font = new Font("Segoe UI Semilight", 17.0);
        text.setFont(font);
        StackPane.setAlignment(text, Pos.CENTER_LEFT);
        StackPane.setMargin(text, new Insets(0, 0, 0, 275));
        getChildren().add(text);
    }

    public void setLabel(String label) {
        this.label.setText(label.toString());
    }

    public void addLabel(String labelText) {
        label.setText(labelText);
        labelsBox.getChildren().add(label);
    }
}
