package com.example.accomplish;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private String project_name;
    private String project_description;
    private List<Planning> list_planning;
    private List<Categorie> project_categories;
    private double project_avancement; // pourcentage
    private List<Tache> Taches_unscheduled;
    public Project(String project_name, String project_description, List<Categorie> project_categories) {
        this.project_name = project_name;
        this.project_description = project_description;
        this.project_categories = project_categories;
    }
    public Project() {
    }
    public String getProject_name() {
        return project_name;
    }
    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }
    public String getProject_description() {
        return project_description;
    }
    public void setProject_description(String project_description) {
        this.project_description = project_description;
    }
    public List<Planning> getList_planning() {
        return list_planning;
    }
    public void setList_planning(List<Planning> list_planning) {
        this.list_planning = list_planning;
    }
    public List<Categorie> getProject_categories() {
        return project_categories;
    }

    public void setProject_categories(List<Categorie> project_categories) {
        this.project_categories = project_categories;
    }

    public double getProject_avancement() {
        return project_avancement;
    }
    public void setProject_avancement(double project_avancement) {
        this.project_avancement = project_avancement;
    }
    public List<Tache> getTaches_unscheduled() {
        return Taches_unscheduled;
    }
    public void setTaches_unscheduled(List<Tache> taches_unscheduled) {
        Taches_unscheduled = taches_unscheduled;
    }
    public void add_categorie(String categoriename,String categoriecolor){
        Categorie categorie_added=new Categorie(categoriename,categoriecolor);
        this.project_categories.add(categorie_added);
    }
    public void edit_categorie(Categorie categorie,String new_name,String new_color){
        if(project_categories.contains(categorie)){
        project_categories.get( project_categories.indexOf(categorie)).setCategorie_name(new_name);
        project_categories.get( project_categories.indexOf(categorie)).setCategorie_color(new_color);
        }else{
            System.out.println("error no such category");
        }
    }
    public void affect_project_avancement(double taux_avancement){
        this.project_avancement=taux_avancement;
    }
    public void add_planning(Planning planning_added){
        this.list_planning.add(planning_added);
    }
}
