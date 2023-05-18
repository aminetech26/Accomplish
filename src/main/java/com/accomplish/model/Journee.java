package com.accomplish.model;

import java.util.ArrayList;

public class Journee {
    private ArrayList<Creneau> today_creneaus;
    private ArrayList<Tache> today_taches;
    private int nb_tasks_accomplished;
    private int etat_avancement;

    public Journee(ArrayList<Creneau> today_creneaus, ArrayList<Tache> today_taches, int nb_tasks_accomplished, int etat_avancement) {
        this.today_creneaus = today_creneaus;
        this.today_taches = today_taches;
        this.nb_tasks_accomplished = nb_tasks_accomplished;
        this.etat_avancement = etat_avancement;
    }

    public ArrayList<Creneau> getToday_creneaus() {
        return today_creneaus;
    }

    public void setToday_creneaus(ArrayList<Creneau> today_creneaus) {
        this.today_creneaus = today_creneaus;
    }

    public ArrayList<Tache> getToday_taches() {
        return today_taches;
    }

    public void setToday_taches(ArrayList<Tache> today_taches) {
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
