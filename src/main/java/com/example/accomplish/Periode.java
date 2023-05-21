package com.example.accomplish;

import javafx.scene.control.Label;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Periode {
    private LocalDate date_fin;
    private LocalDate date_debut;
    private List<Journee> list_journee;

    public LocalDate getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(LocalDate date_fin) {
        this.date_fin = date_fin;
    }

    public LocalDate getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(LocalDate date_debut) {
        this.date_debut = date_debut;
    }

    public List<Journee> getList_journee() {
        return list_journee;
    }

    public void setList_journee(List<Journee> list_journee) {
        this.list_journee = list_journee;
    }

    public Periode(LocalDate date_fin, LocalDate date_debut, List<Journee> list_journee) {
        this.date_fin = date_fin;
        this.date_debut = date_debut;
        this.list_journee = list_journee;
    }
}
