package com.example.accomplish;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.skin.DatePickerSkin;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;


public class FeedPageController implements Initializable {

        public AnchorPane TasksPage;
    @FXML
        public ScrollPane scrollpane;
    @FXML
    public VBox task;

    @FXML
        private DatePicker datePicker;

        @Override
        public void initialize(URL location, ResourceBundle resources) {
            //datePicker.show();
            datePicker.setValue(LocalDate.now());
        }


    public void GotoHome(MouseEvent event) {
    }

    @FXML
    private void GoToTasksPage(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("pageTasks.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


    public static class CustomElement extends StackPane {

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

    private int task_number=0 ;
    public void AddTask(MouseEvent event) {
        task_number++;
        CustomElement customElement = new CustomElement();
        customElement.addLabel("Task "+task_number);
        task.setAlignment(Pos.CENTER);
        task.getChildren().add(customElement);
    }
}