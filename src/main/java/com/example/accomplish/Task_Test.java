package com.example.accomplish;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
public class Task_Test {
    private String tache_name;
    private Priorite tache_priorite;
    private Categorie tache_categorie;
    private boolean tache_locked=false;

    public Task_Test(String tache_name, Priorite tache_priorite, Categorie tache_categorie, boolean tache_locked) {
        this.tache_name = tache_name;
        this.tache_priorite = tache_priorite;
        this.tache_categorie = tache_categorie;
        this.tache_locked = tache_locked;
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
    public Categorie getTache_categorie() {
        return tache_categorie;
    }
    public void setTache_categorie(Categorie tache_categorie) {
        this.tache_categorie = tache_categorie;
    }
    public boolean isTache_locked() {
        return tache_locked;
    }
    public void setTache_locked(boolean tache_locked) {
        this.tache_locked = tache_locked;
    }
}

