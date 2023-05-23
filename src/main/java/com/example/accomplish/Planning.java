package com.example.accomplish;

import javafx.util.Pair;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class Planning {
    private String planning_name;
    private List<Tache> liste_taches = new ArrayList<Tache>();
    private LocalDate date_debut;
    private boolean type_planning;//avec periode true ou sans periode false
    private Periode periode;


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

    public void setListe_taches(List<Tache> liste_taches) {
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
        Comparator<Tache> comparator = Comparator.comparing(Tache::getDeadline,
                        Comparator.nullsLast(Comparator.naturalOrder()))
                .thenComparing(Tache::getTache_priorite);
        liste_taches.sort(comparator);
    }
    public void plannification_automatique_avec_periode(List<Tache> liste_taches_a_plannifier){
        for (Tache tache:liste_taches_a_plannifier) {
            for (Journee journee: periode.getList_journee()) {
                journee.setCrenauDurations();
                //tache avec deadline
                if (tache.isIfdeadline()) {
                    if (journee.getDate().isBefore(tache.getDeadline())) {
                        if (journee.getCreneau_duree().stream().anyMatch(value -> Objects.equals(value, tache.getDuree()))) {
                            tache.setScheduled(true);
                            Pair<Tache, Creneau> pair = new Pair<>(tache, journee.getToday_creneaus().get(journee.getCreneau_duree().indexOf(tache.getDuree())));
                            journee.getTache_plannifiee().add(pair);
                            journee.getCreneau_duree().remove(journee.getCreneau_duree().indexOf(tache.getDuree()));
                            journee.getToday_creneaus().remove(journee.getCreneau_duree().indexOf(tache.getDuree()));
                        } else if (Collections.max(journee.getCreneau_duree()) > tache.getDuree()) {
                            int index = journee.getCreneau_duree().indexOf(Collections.max(journee.getCreneau_duree()));
                            Creneau creneau_complet = journee.getToday_creneaus().get(index);
                            Creneau creneau_tache = new Creneau(creneau_complet.getDebutCrenau(),creneau_complet.getDebutCrenau().plusMinutes(tache.getDuree()),tache.getDuree());
                            tache.setScheduled(true);
                            Pair<Tache, Creneau> pair = new Pair<>(tache, creneau_tache);
                            journee.getTache_plannifiee().add(pair);
                            if (Duration.between(creneau_tache.getFinCrenau(),creneau_complet.getFinCrenau()).toMinutes()>Systeme.getSeuil_minimal()) {
                                Creneau nouveau_crenau_libre = new Creneau();
                                nouveau_crenau_libre.setDebutCrenau(creneau_tache.getFinCrenau());
                                nouveau_crenau_libre.setFinCrenau(creneau_complet.getFinCrenau());
                                nouveau_crenau_libre.setDuree(Duration.between(creneau_tache.getFinCrenau(),creneau_complet.getFinCrenau()).toMinutes());
                                journee.getToday_creneaus().set(index,nouveau_crenau_libre);
                                journee.getCreneau_duree().set(index,nouveau_crenau_libre.getDuree());
                            }else {
                                journee.getToday_creneaus().remove(index);
                                journee.getCreneau_duree().remove(index);
                            }
                        }else if (tache.getDuree()>Collections.max(journee.getCreneau_duree())){
                            if (tache.isTasktype()){
                                Tache nouvelle_tache1 = new Tache();
                                nouvelle_tache1.setTasktype(false);
                                nouvelle_tache1.setTache_name(tache.getTache_name()+" D");
                                nouvelle_tache1.setScheduled(false);
                                nouvelle_tache1.setIfdeadline(tache.isIfdeadline());
                                nouvelle_tache1.setTache_etat_realisation(Etat_Realisation.NOTREALIZED);
                                if (tache.isIfdeadline()){
                                    nouvelle_tache1.setDeadline(tache.getDeadline());
                                }
                                nouvelle_tache1.setDuree(tache.getDuree()-Collections.max(journee.getCreneau_duree()));
                                Tache nouvelle_tache2 = new Tache();
                                nouvelle_tache2.setTache_name(tache.getTache_name()+" D");
                                nouvelle_tache2.setTasktype(false);
                                nouvelle_tache2.setScheduled(false);
                                nouvelle_tache2.setIfdeadline(tache.isIfdeadline());
                                nouvelle_tache2.setTache_etat_realisation(Etat_Realisation.NOTREALIZED);
                                if (tache.isIfdeadline()){
                                    nouvelle_tache2.setDeadline(tache.getDeadline());
                                }
                                int index = liste_taches_a_plannifier.indexOf(tache);
                                nouvelle_tache2.setDuree(Collections.max(journee.getCreneau_duree()));
                                liste_taches_a_plannifier.add(index+1,nouvelle_tache1);
                                liste_taches_a_plannifier.add(index+2,nouvelle_tache1);
                                liste_taches_a_plannifier.remove(index);
                            }else { //tache non decomposable - simple
                                continue;
                            }
                        }
                    } else {
                        Systeme.currentUser.getListe_projet().get(Systeme.currentUser.getListe_projet().size() - 1).getTaches_unscheduled().add(tache);
                    }
                }
                //tache sans deadline
                else {
                    if (journee.getCreneau_duree().stream().anyMatch(value -> Objects.equals(value, tache.getDuree()))) {
                        tache.setScheduled(true);
                        Pair<Tache, Creneau> pair = new Pair<>(tache, journee.getToday_creneaus().get(journee.getCreneau_duree().indexOf(tache.getDuree())));
                        journee.getTache_plannifiee().add(pair);
                        //journee.getCreneau_duree().remove(journee.getCreneau_duree().indexOf(tache.getDuree()));
                        //journee.getToday_creneaus().remove(journee.getCreneau_duree().indexOf(tache.getDuree()));
                    } else if (Collections.max(journee.getCreneau_duree()) > tache.getDuree()) {
                        int index = journee.getCreneau_duree().indexOf(Collections.max(journee.getCreneau_duree()));
                        Creneau creneau_complet = journee.getToday_creneaus().get(index);
                        Creneau creneau_tache = new Creneau(creneau_complet.getDebutCrenau(),creneau_complet.getDebutCrenau().plusMinutes(tache.getDuree()),tache.getDuree());
                        tache.setScheduled(true);
                        Pair<Tache, Creneau> pair = new Pair<>(tache, creneau_tache);
                        journee.getTache_plannifiee().add(pair);
                        if (Duration.between(creneau_tache.getFinCrenau(),creneau_complet.getFinCrenau()).toMinutes()>Systeme.getSeuil_minimal()) {
                            Creneau nouveau_crenau_libre = new Creneau();
                            nouveau_crenau_libre.setDebutCrenau(creneau_tache.getFinCrenau());
                            nouveau_crenau_libre.setFinCrenau(creneau_complet.getFinCrenau());
                            nouveau_crenau_libre.setDuree(Duration.between(creneau_tache.getFinCrenau(),creneau_complet.getFinCrenau()).toMinutes());
                            journee.getToday_creneaus().set(index,nouveau_crenau_libre);
                            journee.getCreneau_duree().set(index,nouveau_crenau_libre.getDuree());
                        }else {
                            journee.getToday_creneaus().remove(index);
                            journee.getCreneau_duree().remove(index);
                        }
                    }else if (tache.getDuree()>Collections.max(journee.getCreneau_duree())){
                        if (tache.isTasktype()){
                            Tache nouvelle_tache1 = new Tache();
                            nouvelle_tache1.setTasktype(false);
                            nouvelle_tache1.setTache_name(tache.getTache_name()+" D");
                            nouvelle_tache1.setScheduled(false);
                            nouvelle_tache1.setIfdeadline(tache.isIfdeadline());
                            nouvelle_tache1.setTache_etat_realisation(Etat_Realisation.NOTREALIZED);
                            if (tache.isIfdeadline()){
                                nouvelle_tache1.setDeadline(tache.getDeadline());
                            }
                            nouvelle_tache1.setDuree(tache.getDuree()-Collections.max(journee.getCreneau_duree()));
                            Tache nouvelle_tache2 = new Tache();
                            nouvelle_tache2.setTache_name(tache.getTache_name()+" D");
                            nouvelle_tache2.setTasktype(false);
                            nouvelle_tache2.setScheduled(false);
                            nouvelle_tache2.setIfdeadline(tache.isIfdeadline());
                            nouvelle_tache2.setTache_etat_realisation(Etat_Realisation.NOTREALIZED);
                            if (tache.isIfdeadline()){
                                nouvelle_tache2.setDeadline(tache.getDeadline());
                            }
                            int index = liste_taches_a_plannifier.indexOf(tache);
                            nouvelle_tache2.setDuree(Collections.max(journee.getCreneau_duree()));
                            liste_taches_a_plannifier.add(index+1,nouvelle_tache1);
                            liste_taches_a_plannifier.add(index+2,nouvelle_tache1);
                            liste_taches_a_plannifier.remove(index);
                        }else { //tache non decomposable - simple
                            continue;
                        }
                    }
                    }

            }

        }
    }


}
