package com.example.accomplish;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;


public class FeedPageController implements Initializable {

    @FXML
    public ScrollPane scrollpane;
    public Label signedInAsText;
    public Text planningName;
    public Text periodLabel;
    public Text countdown;
    public Text TaskTitle_FeedPage;
    @FXML
    private DatePicker datePicker;

    @FXML
    public void initialize(URL location, ResourceBundle resources) {

//        Tache LastTask = Systeme.getCurrentUser().getListe_projet().get(Systeme.getCurrentUser().getListe_projet().size()-1).getList_planning().get(Systeme.getCurrentUser().getListe_projet().get(Systeme.getCurrentUser().getListe_projet().size()-1).getList_planning().size()-1).getListe_taches().get(Systeme.getCurrentUser().getListe_projet().get(Systeme.getCurrentUser().getListe_projet().size()-1).getList_planning().get(Systeme.getCurrentUser().getListe_projet().get(Systeme.getCurrentUser().getListe_projet().size()-1).getList_planning().size()-1).getListe_taches().size()-1);
  //      TaskTitle_FeedPage.setText(LastTask.getTache_name());

        //datePicker.show();
        signedInAsText.setText("Signed in as : " + Systeme.getCurrentUser().getUsername());
        planningName.setText("Planning Name : " + Systeme.getCurrentUser().getListe_projet().get(Systeme.getCurrentUser().getListe_projet().size() - 1).getList_planning().get(Systeme.getCurrentUser().getListe_projet().get(Systeme.getCurrentUser().getListe_projet().size() - 1).getList_planning().size() - 1).getPlanning_name());
        if (Systeme.getCurrentUser().getListe_projet().get(Systeme.getCurrentUser().getListe_projet().size() - 1).getList_planning().get(Systeme.getCurrentUser().getListe_projet().get(Systeme.getCurrentUser().getListe_projet().size() - 1).getList_planning().size() - 1).getType_planning()) {
            LocalDate startDate = Systeme.getCurrentUser().getListe_projet().get(Systeme.getCurrentUser().getListe_projet().size() - 1).getList_planning().get(Systeme.getCurrentUser().getListe_projet().get(Systeme.getCurrentUser().getListe_projet().size() - 1).getList_planning().size() - 1).getPeriode().getDate_debut();
            LocalDate endDate = Systeme.getCurrentUser().getListe_projet().get(Systeme.getCurrentUser().getListe_projet().size() - 1).getList_planning().get(Systeme.getCurrentUser().getListe_projet().get(Systeme.getCurrentUser().getListe_projet().size() - 1).getList_planning().size() - 1).getPeriode().getDate_fin();
            periodLabel.setText("Period : " + startDate.toString() + " TO " + endDate.toString());
            // Extract the years, months, and days from the period
            LocalDate currentDate = LocalDate.now();
            Period period;
            int months;
            int days;
            if(currentDate == startDate){
                period = Period.between(currentDate, endDate);
                months = period.getMonths();
                days = period.getDays();
            }else{
                period = Period.between(startDate, endDate);
                months = period.getMonths();
                days = period.getDays();
            }
            countdown.setText("Time left : "+String.valueOf(months)+" months "+String.valueOf(days)+" days.");
        } else {
            LocalDate startDate = Systeme.getCurrentUser().getListe_projet().get(Systeme.getCurrentUser().getListe_projet().size() - 1).getList_planning().get(Systeme.getCurrentUser().getListe_projet().get(Systeme.getCurrentUser().getListe_projet().size() - 1).getList_planning().size() - 1).getDate_debut();
            periodLabel.setText("Start date : " + startDate.toString());
            countdown.setVisible(false);
        }
        datePicker.setValue(LocalDate.now());
    }

    @FXML
    public void GotoHome(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Feed_Page.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void GoToSettings (MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("settings.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void GoToTasksPage(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("pageTasks.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


}