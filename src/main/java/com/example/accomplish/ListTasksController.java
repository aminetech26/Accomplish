package com.example.accomplish;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Pair;

import java.net.URL;
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
        current_planning.trier_tache();
        current_planning.plannification_automatique_avec_periode(current_planning.getListe_taches());

        taskDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        taskNameColumn.setCellValueFactory(new PropertyValueFactory<>("taskName"));

        startCreneauColumn.setCellValueFactory(new PropertyValueFactory<>("debutCrenau"));

        endCreneauColumn.setCellValueFactory(new PropertyValueFactory<>("endCrenau"));

        tableView.getColumns().addAll(taskNameColumn,taskNameColumn,startCreneauColumn,endCreneauColumn);
        ObservableList<AffichagePlannificationController> tasks = FXCollections.observableArrayList();

        // Create a new Task object
        for (Journee journee:current_planning.getPeriode().getList_journee()) {
            for (Pair<Tache,Creneau> pair:journee.getTache_plannifiee()) {
                AffichagePlannificationController affichagePlannificationController =
                        new AffichagePlannificationController(pair.getKey().getTache_name(),pair.getValue().getDebutCrenau().toString(),pair.getValue().getFinCrenau().toString(),journee.getDate().toString());
                        tasks.add(affichagePlannificationController);
            }
        }
        // Set the items to the table view
        tableView.setItems(tasks);

    }

}