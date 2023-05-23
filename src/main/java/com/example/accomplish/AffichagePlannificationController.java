package com.example.accomplish;

import javafx.beans.property.*;

import java.time.LocalTime;

public class AffichagePlannificationController {
    private String date;
    private String taskName;
    private String debutCrenau;
    private String endCrenau;


    public AffichagePlannificationController(String date1, String taskName1, String debutCrenau1, String endCrenau1) {
        setTaskName(taskName1);
        setDebutCrenau(debutCrenau1);
        setEndCrenau(endCrenau1);
        setDate(date1);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDebutCrenau() {
        return debutCrenau;
    }

    public void setDebutCrenau(String debutCrenau) {
        this.debutCrenau = debutCrenau;
    }

    public String getEndCrenau() {
        return endCrenau;
    }

    public void setEndCrenau(String endCrenau) {
        this.endCrenau = endCrenau;
    }
}