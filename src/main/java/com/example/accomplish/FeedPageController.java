package com.example.accomplish;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;


public class FeedPageController implements Initializable {

    @FXML
    public ScrollPane scrollpane;
    @FXML
    public static Button Auto_Planning ;
    @FXML
    public static Button Manual_Planning ;

    public Label signedInAsText;
    public Text planningName;
    public Text periodLabel;
    public Text countdown;
    @FXML
    private DatePicker datePicker;
    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        //datePicker.show();
        signedInAsText.setText("Signed in as : "+Systeme.getCurrentUser().getUsername());
        planningName.setText("Planning Name : "+Systeme.getCurrentUser().getListe_projet().get(Systeme.getCurrentUser().getListe_projet().size()-1).getList_planning().get(Systeme.getCurrentUser().getListe_projet().get(Systeme.getCurrentUser().getListe_projet().size()-1).getList_planning().size()-1).getPlanning_name());
        if(Systeme.getCurrentUser().getListe_projet().get(Systeme.getCurrentUser().getListe_projet().size() - 1).getList_planning().get(Systeme.getCurrentUser().getListe_projet().get(Systeme.getCurrentUser().getListe_projet().size() - 1).getList_planning().size() - 1).getType_planning()){
            LocalDate startDate = Systeme.getCurrentUser().getListe_projet().get(Systeme.getCurrentUser().getListe_projet().size()-1).getList_planning().get(Systeme.getCurrentUser().getListe_projet().get(Systeme.getCurrentUser().getListe_projet().size()-1).getList_planning().size()-1).getPeriode().getDate_debut();
            LocalDate endDate = Systeme.getCurrentUser().getListe_projet().get(Systeme.getCurrentUser().getListe_projet().size()-1).getList_planning().get(Systeme.getCurrentUser().getListe_projet().get(Systeme.getCurrentUser().getListe_projet().size()-1).getList_planning().size()-1).getPeriode().getDate_fin();
            periodLabel.setText("Period : "+startDate.toString()+" TO "+endDate.toString());
        }else {
            LocalDate startDate = Systeme.getCurrentUser().getListe_projet().get(Systeme.getCurrentUser().getListe_projet().size()-1).getList_planning().get(Systeme.getCurrentUser().getListe_projet().get(Systeme.getCurrentUser().getListe_projet().size()-1).getList_planning().size()-1).getDate_debut();
            periodLabel.setText("Start date : "+startDate.toString());
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
    private void GoToTasksPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("pageTasks.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void GoToSettings(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("settings.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}