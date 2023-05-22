package com.example.accomplish;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Task {
    private final StringProperty taskName = new SimpleStringProperty();
    private final IntegerProperty startHour = new SimpleIntegerProperty();
    private final StringProperty endHour = new SimpleStringProperty();
    private final StringProperty date = new SimpleStringProperty();

    public Task(String taskName, int startHour, String endHour, String date) {
        setTaskName(taskName);
        setStartHour(startHour);
        setEndHour(endHour);
        setDate(date);
    }

    public StringProperty taskNameProperty() {
        return taskName;
    }

    public String getTaskName() {
        return taskName.get();
    }

    public void setTaskName(String taskName) {
        this.taskName.set(taskName);
    }

    public IntegerProperty startHourProperty() {
        return startHour;
    }

    public int getStartHour() {
        return startHour.get();
    }

    public void setStartHour(int startHour) {
        this.startHour.set(startHour);
    }

    public StringProperty endHourProperty() {
        return endHour;
    }

    public String getEndHour() {
        return endHour.get();
    }

    public void setEndHour(String endHour) {
        this.endHour.set(endHour);
    }

    public StringProperty dateProperty() {
        return date;
    }

    public String getDate() {
        return date.get();
    }

    public void setDate(String date) {
        this.date.set(date);
    }
}