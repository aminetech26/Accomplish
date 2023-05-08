package com.example.accomplish;

import java.util.ArrayList;

public class Tache {
    private String tache_name;
    private Priorite tache_priorite;
    private boolean ifdeadline;
    private int deadline;
    private Categorie tache_categorie;
    private int duree;
    private  boolean tasktype; // decomposable ou non
    private  boolean scheduled=false;
    private Etat_Realisation tache_etat_realisation;
    private boolean tache_locked=false;

    public Tache(String tache_name, Priorite tache_priorite, boolean ifdeadline, int deadline, Categorie tache_categorie, boolean tasktype, boolean tache_locked) {
        this.tache_name = tache_name;
        this.tache_priorite = tache_priorite;
        this.ifdeadline = ifdeadline;
        this.deadline = deadline;
        this.tache_categorie = tache_categorie;
        this.tasktype = tasktype;
        this.scheduled = scheduled;
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
    public int getDeadline() {
        return deadline;
    }
    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }
    public Categorie getTache_categorie() {
        return tache_categorie;
    }
    public void setTache_categorie(Categorie tache_categorie) {
        this.tache_categorie = tache_categorie;
    }
    public int getDuree() {
        return duree;
    }
    public void setDuree(int duree) {
        this.duree = duree;
    }
    public boolean isTasktype() {
        return tasktype;
    }
    public void setTasktype(boolean tasktype) {
        this.tasktype = tasktype;
    }
    public boolean isScheduled() {
        return scheduled;
    }
    public void setScheduled(boolean scheduled) {
        this.scheduled = scheduled;
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

    public void affect_etat_realisation(Etat_Realisation etat_realisation){
        this.tache_etat_realisation=etat_realisation;
    }
    public void afficher(){
        System.out.println("tache name :"+this.tache_name);
        System.out.println("tache priorite :"+this.tache_priorite);
        System.out.println("this tache has a deadline :"+this.ifdeadline);
        if(this.ifdeadline){
            System.out.println("tache deadline :"+this.deadline);
        }
        System.out.println("tache categorie :");
        this.tache_categorie.afficher();
        System.out.println("tache duree :"+this.duree);
        System.out.println("tasktype :"+this.tasktype);
        System.out.println(" etat de realisation "+this.tache_etat_realisation);
        System.out.println(" tache locked :"+this.tache_locked);
    }
    public void choose_categorie(ArrayList<Categorie> project_categories){
      for(int i=0;i < project_categories.size();i++){
          System.out.println(project_categories.get(i)+":"+i);
      }
    }
}
