package com.example.accomplish;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PopupController {

    public VBox task;
    public ImageView fermer_popup;

    public PopupController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add-new-task.fxml"));
        fxmlLoader.setController(this);
        /*try {
            Parent parent = fxmlLoader.load();
            // Access the task VBox using the fx:id
            task = (VBox) fxmlLoader.getNamespace().get("task");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    public void AddTask(ActionEvent event) throws IOException {

        /*Stage stage = (Stage) fermer_popup.getScene().getWindow();
        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pageTasks.fxml"));
        Parent root = fxmlLoader.load();

        FeedPageController taskspagecontroller = fxmlLoader.getController();
        taskspagecontroller.AddCustomElement();*/


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pageTasks.fxml"));
        Parent root = fxmlLoader.load();

        FeedPageController taskspagecontroller = fxmlLoader.getController();
        taskspagecontroller.AddCustomElement();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void BackToTasksPage(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("pageTasks.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
