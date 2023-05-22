package com.example.accomplish;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Tache {
    private String tache_name;
    private Priorite tache_priorite;
    private boolean ifdeadline;
    private LocalDate deadline;
    private Categorie tache_categorie;
    private LocalTime duree;
    private boolean scheduled;

    public boolean isScheduled() {
        return scheduled;
    }

    public void setScheduled(boolean scheduled) {
        this.scheduled = scheduled;
    }

    private  boolean tasktype; // decomposable ou non
    private Etat_Realisation tache_etat_realisation;
    private boolean tache_locked=false;

    public Tache(String tache_name, Priorite tache_priorite, boolean ifdeadline, LocalDate deadline, Categorie tache_categorie, boolean tasktype, boolean tache_locked) {
        this.tache_name = tache_name;
        this.tache_priorite = tache_priorite;
        this.ifdeadline = ifdeadline;
        this.deadline = deadline;
        this.tache_categorie = tache_categorie;
        this.tasktype = tasktype;
        this.tache_locked = tache_locked;
    }

    public Tache() {
    }

    public String getTache_name() {
        return tache_name;
    }
    public void setTache_name(String tache_name) {
        this.tache_name = tache_name;
    }
    public Priorite getTache_priorite() {
        return tache_priorite;
    }
    public void setTache_priorite(Priorite tache_priorite) {
        this.tache_priorite = tache_priorite;
    }
    public boolean isIfdeadline() {
        return ifdeadline;
    }
    public void setIfdeadline(boolean ifdeadline) {
        this.ifdeadline = ifdeadline;
    }
    public LocalDate getDeadline() {
        return deadline;
    }
    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }
    public Categorie getTache_categorie() {
        return tache_categorie;
    }
    public void setTache_categorie(Categorie tache_categorie) {
        this.tache_categorie = tache_categorie;
    }
    public LocalTime getDuree() {
        return duree;
    }
    public void setDuree(LocalTime duree) {
        this.duree = duree;
    }
    public boolean isTasktype() {
        return tasktype;
    }
    public void setTasktype(boolean tasktype) {
        this.tasktype = tasktype;
    }
    public Etat_Realisation getTache_etat_realisation() {
        return tache_etat_realisation;
    }
    public void setTache_etat_realisation(Etat_Realisation tache_etat_realisation) {
        this.tache_etat_realisation = tache_etat_realisation;
    }
    public boolean isTache_locked() {
        return tache_locked;
    }
    public void setTache_locked(boolean tache_locked) {
        this.tache_locked = tache_locked;
    }
}
