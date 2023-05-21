package com.example.accomplish;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.skin.DatePickerSkin;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateStringConverter;

import java.io.EOFException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CreatePlanningController {
    public GridPane gridPane;
    public DatePicker startDate;
    public RadioButton noRadioButton;
    public TextField planningName;
    public RadioButton yesRadioButton;
    public Button setFreeTimeSlots;
    public DatePicker secondDatePicker;

    public void initialize() {
        ToggleGroup toggleGroup = new ToggleGroup();
        noRadioButton.setToggleGroup(toggleGroup);
        yesRadioButton.setToggleGroup(toggleGroup);
        startDate.setDayCellFactory(picker -> new DatePickerCell());
        Label endDateLabel = new Label("End Date:");
        endDateLabel = new Label("End Date:");
        endDateLabel.setStyle("-fx-font-size: 15px; -fx-font-weight: bold;");
        secondDatePicker.setEditable(false); // Disable manual input
        secondDatePicker.setDisable(true); // Initially disable the secondDatePicker
        Label finalEndDateLabel = endDateLabel;
        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == yesRadioButton) {
                secondDatePicker.setDisable(false); // Enable the secondDatePicker
                if (!gridPane.getChildren().contains(finalEndDateLabel)) {
                    int rowIndex = gridPane.getRowCount();
                    gridPane.addRow(rowIndex, finalEndDateLabel, secondDatePicker);
                }
            } else {
                secondDatePicker.setDisable(true); // Disable the secondDatePicker
                gridPane.getChildren().removeAll(finalEndDateLabel, secondDatePicker);
            }
        });
    }

    public void GoTosetting_free_time_slots(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("setting-free-time-slots.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void handlesetFreeTimeSlotsButton(ActionEvent event) throws IOException {

        Planning current_planning = new Planning();
        current_planning.setPlanning_name(planningName.getText());
        current_planning.setDate_debut(startDate.getValue());
        if(yesRadioButton.isSelected()){
            List<Journee> journeyList = new ArrayList<>();
            LocalDate currentDate = startDate.getValue();
            while (!currentDate.isAfter(secondDatePicker.getValue())) {
                Journee jour = new Journee();
                jour.setDate(currentDate);
                journeyList.add(jour);
                // Move to the next date
                currentDate = currentDate.plusDays(1);
            }
            Periode periode = new Periode(secondDatePicker.getValue(),startDate.getValue(),journeyList);
            current_planning.setPeriode(periode);
            current_planning.setType_planning(true);
            Systeme.getCurrentUser().getCurrent_project().getList_planning().add(current_planning);
        }else if (noRadioButton.isSelected()){
            current_planning.setType_planning(false);
        }
    }
    private class DatePickerCell extends javafx.scene.control.DateCell {
        @Override
        public void updateItem(LocalDate item, boolean empty) {
            super.updateItem(item, empty);

            // Disable selection of dates before today
            setDisable(empty || item.isBefore(LocalDate.now()));

            // Show a warning for disabled dates
            if (item.isBefore(LocalDate.now())) {
                setTooltip(new Tooltip("Please select a date that is not in the past."));
            }
        }
    }

}
