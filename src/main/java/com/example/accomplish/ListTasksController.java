package com.example.accomplish;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ListTasksController implements Initializable {
    @FXML
    public TableView<AffichagePlannificationController> tableView;

    @FXML
    public TableColumn<AffichagePlannificationController,String> taskDate;
    @FXML
    public TableColumn<AffichagePlannificationController,String> taskNameColumn;
    @FXML
    public TableColumn<AffichagePlannificationController,String> startCreneauColumn;

    @FXML
    public TableColumn<AffichagePlannificationController,String> endCreneauColumn;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Project current = Systeme.getCurrentUser().getListe_projet().get(Systeme.getCurrentUser().getListe_projet().size()-1);
        Planning current_planning = current.getList_planning().get(current.getList_planning().size()-1);

        taskDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        taskNameColumn.setCellValueFactory(new PropertyValueFactory<>("taskName"));

        startCreneauColumn.setCellValueFactory(new PropertyValueFactory<>("debutCrenau"));

        endCreneauColumn.setCellValueFactory(new PropertyValueFactory<>("endCrenau"));

        tableView.getColumns().addAll(taskNameColumn,taskNameColumn,startCreneauColumn,endCreneauColumn);
        ObservableList<AffichagePlannificationController> tasks = FXCollections.observableArrayList();

        // Create a new Task object
        for (Journee journee:current_planning.getPeriode().getList_journee()) {
            if (!journee.getTache_plannifiee().isEmpty()) {
                for (Pair<Tache, Creneau> pair : journee.getTache_plannifiee()) {

                    AffichagePlannificationController affichagePlannificationController =
                            new AffichagePlannificationController(journee.getDate().toString() , pair.getKey().getTache_name(), pair.getValue().getDebutCrenau().toString(), pair.getValue().getFinCrenau().toString());
                    tasks.add(affichagePlannificationController);
                }
            }
        }
        // Set the items to the table view
        tableView.setItems(tasks);

    }

    public void Confirm(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("pageTasks.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void Annuler(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("pageTasks.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}