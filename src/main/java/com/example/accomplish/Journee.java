package com.example.accomplish;

import java.util.ArrayList;
import java.util.List;

public class Journee {
    private List<Creneau> today_creneaus;
    private List<Tache> today_taches;
    private int nb_tasks_accomplished;
    private int etat_avancement;

    public Journee(List<Creneau> today_creneaus, List<Tache> today_taches, int nb_tasks_accomplished, int etat_avancement) {
        this.today_creneaus = today_creneaus;
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
    public void afficher(){
        System.out.println("**************************** journee creneaus *********************************");
        for (Creneau creneau:this.today_creneaus) {
            System.out.println("--------------------------------------------------------------------");
            creneau.afficher();
            System.out.println("---------------------------------------------------------------------");
            System.out.println(" ");
        }
        System.out.println("**************************** journee taches   *********************************");
        for (Tache task:this.today_taches) {
            System.out.println("--------------------------------------------------------------------");
            task.afficher();
            System.out.println("---------------------------------------------------------------------");
            System.out.println(" nombre de task accomplished :"+this.nb_tasks_accomplished);
            System.out.println(" etat d'avancement : "+this.etat_avancement);
        }
    }
}
