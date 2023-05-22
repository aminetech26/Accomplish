package com.example.accomplish;

import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

public class Creneau {
    public static List<CustomElement_TimeSlot> customElement_timeSlots = new ArrayList<CustomElement_TimeSlot>();
    public Creneau(){

    }

    public Creneau( int heure_debut, int minutes_debut, int heure_fin, int minutes_fin, int duree) {
        this.heure_debut = heure_debut;
        this.minutes_debut = minutes_debut;
        this.heure_fin = heure_fin;
        this.minutes_fin = minutes_fin;
        this.duree = duree;
    }

    private int heure_debut;
    private int minutes_debut;
    private int heure_fin;
    private int minutes_fin;

    public int getMinutes_debut() {
        return minutes_debut;
    }

    public void setMinutes_debut(int minutes_debut) {
        this.minutes_debut = minutes_debut;
    }

    public int getMinutes_fin() {
        return minutes_fin;
    }

    public void setMinutes_fin(int minutes_fin) {
        this.minutes_fin = minutes_fin;
    }

    private int duree;

    public int getHeure_debut() {
        return heure_debut;
    }

    public void setHeure_debut(int heure_debut) {
        this.heure_debut = heure_debut;
    }

    public int getHeure_fin() {
        return heure_fin;
    }

    public void setHeure_fin(int heure_fin) {
        this.heure_fin = heure_fin;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }
}
