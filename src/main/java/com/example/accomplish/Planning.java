package com.example.accomplish;

import java.util.ArrayList;
import java.util.Date;

public class Planning {
    private String planning_name;
    private ArrayList<Tache> liste_taches;
    private ArrayList<Creneau> crenaux_libres;
    private Date date_debut;

    public Planning(String planning_name) {
        this.planning_name = planning_name;
    }

    public String getPlanning_name() {
        return planning_name;
    }

    public void setPlanning_name(String planning_name) {
        this.planning_name = planning_name;
    }
    public void ajouter_tache(Tache tache){
        liste_taches.add(tache);
    }

}
