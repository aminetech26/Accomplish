package com.example.accomplish;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ListTasksController implements Initializable {

    public TableColumn taskNameColumn;
    public TableColumn startHourColumn;
    public TableColumn endHourColumn;
    public TableColumn dateColumn;
    @FXML
    private TableView<Task> tableView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        taskNameColumn.setCellValueFactory(new PropertyValueFactory<>("taskName"));

        startHourColumn.setCellValueFactory(new PropertyValueFactory<>("startHour"));

        endHourColumn.setCellValueFactory(new PropertyValueFactory<>("endHour"));

        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        tableView.getColumns().addAll(taskNameColumn,startHourColumn,endHourColumn,dateColumn);

        // Create a new Task object

        ObservableList<Task> tasks = FXCollections.observableArrayList(
                new Task("Task 1", 10, "12:00", "2023-05-22"),
                new Task("Task 2", 14, "16:00", "2023-05-23"),
                new Task("Task 3", 9, "11:00", "2023-05-24"));

        // Set the items to the table view
        tableView.setItems(tasks);

    }

}