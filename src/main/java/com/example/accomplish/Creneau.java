package com.example.accomplish;

import javafx.scene.layout.HBox;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Creneau {
    public static List<CustomElement_TimeSlot> customElement_timeSlots = new ArrayList<CustomElement_TimeSlot>();
    public static List<CustomElement_SpecificTimeSlot> customElement_specificTimeSlots = new ArrayList<CustomElement_SpecificTimeSlot>();

    public Creneau(){

    }

    public Creneau(LocalTime debutCrenau, LocalTime finCrenau, Long duree) {
        this.debutCrenau = debutCrenau;
        this.finCrenau = finCrenau;
        this.duree = duree;
    }

    private LocalTime debutCrenau;
    private LocalTime finCrenau;
    public LocalTime getDebutCrenau() {
        return debutCrenau;
    }

    public void setDebutCrenau(LocalTime debutCrenau) {
        this.debutCrenau = debutCrenau;
    }

    public LocalTime getFinCrenau() {
        return finCrenau;
    }

    public void setFinCrenau(LocalTime finCrenau) {
        this.finCrenau = finCrenau;
    }
    private long duree;

    public long getDuree() {
        return duree;
    }

    public void setDuree(long duree) {
        this.duree = duree;
    }
}
