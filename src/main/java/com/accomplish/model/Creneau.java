package com.accomplish.model;

public class Creneau {
    private boolean libre=true;
    private int creneau_date;
    private int heure_debut;
    private int heure_fin;
    private int duree;

    public Creneau(boolean libre, int creneau_date, int heure_debut, int heure_fin, int duree) {
        this.libre = libre;
        this.creneau_date = creneau_date;
        this.heure_debut = heure_debut;
        this.heure_fin = heure_fin;
        this.duree = duree;
    }

    public boolean isLibre() {
        return libre;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }

    public int getCreneau_date() {
        return creneau_date;
    }

    public void setCreneau_date(int creneau_date) {
        this.creneau_date = creneau_date;
    }

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
