package com.example.accomplish;

import javafx.util.Pair;

import java.time.LocalDate;
import java.util.*;

public class Planning {
    private String planning_name;
    private List<Tache> liste_taches = new ArrayList<Tache>();
    private LocalDate date_debut;
    private boolean type_planning;//avec periode true ou sans periode false
    private Periode periode;

    public void setListe_taches(List<Tache> liste_taches) {
        this.liste_taches = liste_taches;
    }


    public boolean getType_planning() {
        return type_planning;
    }

    public void setType_planning(boolean type_planning) {
        this.type_planning = type_planning;
    }

    public Periode getPeriode() {
        return periode;
    }

    public void setPeriode(Periode periode) {
        this.periode = periode;
    }
    public Planning(){

    }

    public Planning(String planning_name, List<Tache> liste_taches, LocalDate date_debut) {
        this.planning_name = planning_name;
        this.liste_taches = liste_taches;
        this.date_debut = date_debut;
    }
    public List<Tache> getListe_taches() {
        return liste_taches;
    }

    public void setListe_taches(ArrayList<Tache> liste_taches) {
        this.liste_taches = liste_taches;
    }
    public LocalDate getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(LocalDate date_debut) {
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

    public void trier_tache(){
            // Sort based on deadline first, then priority
            Comparator<Tache> comparator = Comparator.comparing(Tache::getDeadline).thenComparing(Tache::getTache_priorite);
            // Sort the list
            liste_taches.sort(comparator);
    }

    public void plannification_automatique_avec_periode(List<Tache> liste_taches_a_plannifier){
        for (Tache tache:liste_taches_a_plannifier) {
            for (Journee journee: periode.getList_journee()) {
                journee.setCrenauDurations();
            if (journee.getDate().isBefore(tache.getDeadline())){
                    if (journee.getCreneau_duree().stream().anyMatch(value -> Objects.equals(value, tache.getDuree()))){
                        Pair<Tache,Creneau> pair = new Pair<>(tache,journee.getToday_creneaus().get(journee.getCreneau_duree().indexOf(tache.getDuree())));
                        journee.getTache_plannifiee().add(pair);
                        journee.getCreneau_duree().remove(journee.getCreneau_duree().indexOf(tache.getDuree()));
                        journee.getToday_creneaus().remove(journee.getCreneau_duree().indexOf(tache.getDuree()));
                    }else if (Collections.max(journee.getCreneau_duree()) > tache.getDuree()){
                        Creneau creneau_complet = journee.getToday_creneaus().get(journee.getCreneau_duree().indexOf(Collections.max(journee.getCreneau_duree())));
                        //heure fin et minute fin se calcule selon la duree de la tache -- qui seront heure debut et minutre debut du nouveau crenau

                    }

            


            }else {
                Systeme.currentUser.getListe_projet().get(Systeme.currentUser.getListe_projet().size()-1).getTaches_unscheduled().add(tache);
            }








            }



        }
    }


}
