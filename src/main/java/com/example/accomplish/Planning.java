package com.example.accomplish;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Planning {
    private String planning_name;
    private List<Tache> liste_taches;
    private List<Creneau> crenaux_libres;
    private Date date_debut;

    private String type_planning;//avec periode ou sans periode


    public Planning(String planning_name, List<Tache> liste_taches, List<Creneau> crenaux_libres, Date date_debut) {
        this.planning_name = planning_name;
        this.liste_taches = liste_taches;
        this.crenaux_libres = crenaux_libres;
        this.date_debut = date_debut;
    }
    public List<Tache> getListe_taches() {
        return liste_taches;
    }

    public void setListe_taches(List<Tache> liste_taches) {
        this.liste_taches = liste_taches;
    }

    public List<Creneau> getCrenaux_libres() {
        return crenaux_libres;
    }

    public void setCrenaux_libres(List<Creneau> crenaux_libres) {
        this.crenaux_libres = crenaux_libres;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
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
    public void modifier_tache(Tache oldtache, Tache newtache){
        if( liste_taches.contains(oldtache)){
            int index = liste_taches.indexOf(oldtache);
            liste_taches.add(index,newtache);
        }else{
            System.out.println("no such old task");
        }
    }

}
