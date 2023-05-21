package com.example.accomplish;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Journee {
    private List<Creneau> today_creneaus = new ArrayList<Creneau>();
    private List<Pair<Tache,Creneau>> tache_plannifiee = new ArrayList<Pair<Tache,Creneau>>();

    public List<Pair<Tache, Creneau>> getTache_plannifiee() {
        return tache_plannifiee;
    }

    public void setTache_plannifiee(List<Pair<Tache, Creneau>> tache_plannifiee) {
        this.tache_plannifiee = tache_plannifiee;
    }

    private List<Integer> creneau_duree = new ArrayList<Integer>();
    private List<Tache> today_taches = new ArrayList<Tache>();
    private int nb_tasks_accomplished;
    private int etat_avancement;

    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Integer> getCreneau_duree() {
        return creneau_duree;
    }

    public void setCreneau_duree(List<Integer> creneau_duree) {
        this.creneau_duree = creneau_duree;
    }

    public Journee(List<Creneau> today_creneaus, List<Integer> creneau_duree, List<Tache> today_taches, int nb_tasks_accomplished, int etat_avancement) {
        this.today_creneaus = today_creneaus;
        this.creneau_duree = creneau_duree;
        this.today_taches = today_taches;
        this.nb_tasks_accomplished = nb_tasks_accomplished;
        this.etat_avancement = etat_avancement;
    }

    public List<Creneau> getToday_creneaus() {
        return today_creneaus;
    }

    public void setToday_creneaus(List<Creneau> today_creneaus) {
        this.today_creneaus = today_creneaus;
    }

    public List<Tache> getToday_taches() {
        return today_taches;
    }

    public void setToday_taches(List<Tache> today_taches) {
        this.today_taches = today_taches;
    }

    public int getNb_tasks_accomplished() {
        return nb_tasks_accomplished;
    }

    public void setNb_tasks_accomplished(int nb_tasks_accomplished) {
        this.nb_tasks_accomplished = nb_tasks_accomplished;
    }
    public int getEtat_avancement() {
        return etat_avancement;
    }

    public void setEtat_avancement(int etat_avancement) {
        this.etat_avancement = etat_avancement;
    }
}
