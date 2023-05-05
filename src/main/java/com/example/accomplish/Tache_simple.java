package com.example.accomplish;

import java.util.Objects;

public class Tache_simple extends Tache{
    private Peridicite tache_periodicite;
    public Peridicite getTache_periodicite() {
        return tache_periodicite;
    }
    public void setTache_periodicite(Peridicite tache_periodicite) {
        this.tache_periodicite = tache_periodicite;
    }

    public Tache_simple(String tache_name, Priorite tache_priorite, boolean ifdeadline, int deadline, Categorie tache_categorie, boolean tasktype, boolean scheduled, boolean tache_locked, Peridicite tache_periodicite) {
        super(tache_name, tache_priorite, ifdeadline, deadline, tache_categorie, tasktype, scheduled, tache_locked);
        this.tache_periodicite = tache_periodicite;
    }
    public Tache_simple() {
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        final Tache_simple other = (Tache_simple) obj;
        if (!Objects.equals(this.getTache_name(),other.getTache_name()))
            return false;
        if(!Objects.equals(this.getTache_priorite(),other.getTache_priorite()))
            return false;
        if(!Objects.equals(this.getDeadline(),other.getDeadline()))
            return false;
        if(!Objects.equals(this.isIfdeadline(),other.isIfdeadline()))
            return false;
        if(!Objects.equals(this.getTache_categorie(),other.getTache_categorie()))
            return false;
        if(!Objects.equals(this.getDuree(),other.getDuree()))
            return false;
        if(!Objects.equals(this.isTasktype(),other.isTasktype()))
            return false;
        if(!Objects.equals(this.getTache_etat_realisation(),other.getTache_etat_realisation()))
            return false;
        if(!Objects.equals(this.isTache_locked(),other.isTache_locked()))
            return false;
        return Objects.equals(this.isScheduled(),other.isScheduled());
    }
}
