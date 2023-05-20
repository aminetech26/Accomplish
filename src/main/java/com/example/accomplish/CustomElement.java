package com.example.accomplish;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CustomElement extends StackPane {

    private Rectangle rectangle;
    private HBox labelsBox;

    public CustomElement() {

        // Create the CheckBox
        CheckBox checkBox = new CheckBox();
        StackPane.setAlignment(checkBox, Pos.CENTER_LEFT);
        StackPane.setMargin(checkBox, new Insets(10,10 ,0,25));

        // Create the rectangle with black shadow
        rectangle = new Rectangle(500, 75);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.WHITE);
        rectangle.setArcWidth(40);
        rectangle.setArcHeight(40);
        rectangle.setEffect(new DropShadow(7, Color.GRAY));
        StackPane.setAlignment(rectangle,Pos.CENTER);
        StackPane.setMargin(rectangle, new Insets(15,0 ,0,50));

        // Create the labels box
        labelsBox = new HBox(10);
        StackPane.setAlignment(labelsBox,Pos.CENTER);
        StackPane.setMargin(labelsBox, new Insets(35,0,0,100));

        setAlignment(Pos.CENTER);
        getChildren().addAll(rectangle ,checkBox, labelsBox);
    }

    public void addLabel(String labelText) {
        Label label = new Label(labelText);
        labelsBox.getChildren().add(label);
    }
}