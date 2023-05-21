package com.example.accomplish;

import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Periode {
    private Date date_fin;
    private Date date_debut;
    private List<Journee> list_journee;

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public List<Journee> getList_journee() {
        return list_journee;
    }

    public void setList_journee(List<Journee> list_journee) {
        this.list_journee = list_journee;
    }

    public Periode(Date date_fin, Date date_debut, List<Journee> list_journee) {
        this.date_fin = date_fin;
        this.date_debut = date_debut;
        this.list_journee = list_journee;
    }
}
