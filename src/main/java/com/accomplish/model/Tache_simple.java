package com.accomplish.model;

import java.util.Date;

public class Tache_simple extends Tache{
    private Peridicite tache_periodicite;
    public Peridicite getTache_periodicite() {
        return tache_periodicite;
    }
    public void setTache_periodicite(Peridicite tache_periodicite) {
        this.tache_periodicite = tache_periodicite;
    }

    public Tache_simple(String tache_name, Priorite tache_priorite, boolean ifdeadline, Date deadline, Categorie tache_categorie, boolean tasktype, boolean tache_locked, Peridicite tache_periodicite) {
        super(tache_name, tache_priorite, ifdeadline, deadline, tache_categorie, tasktype, tache_locked);
        this.tache_periodicite = tache_periodicite;
    }

    public Tache_simple() {
    }
}
