package com.example.accomplish;

import java.util.ArrayList;

public class Project {
    private String project_name;
    private String project_description;
    //private ArrayList<planning> list_planning;
    private ArrayList<Categorie> project_categories;
    private int project_avancement; // pourcentage
    private ArrayList<Tache> Taches_unscheduled;
    public Project(String project_name, String project_description, ArrayList<Categorie> project_categories) {
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
   /* public ArrayList<planning> getList_planning() {
        return list_planning;
    }
    public void setList_planning(ArrayList<planning> list_planning) {
        this.list_planning = list_planning;
    }*/
    public ArrayList<Categorie> getProject_categories() {
        return project_categories;
    }

    public void setProject_categories(ArrayList<Categorie> project_categories) {
        this.project_categories = project_categories;
    }

    public int getProject_avancement() {
        return project_avancement;
    }
    public void setProject_avancement(int project_avancement) {
        this.project_avancement = project_avancement;
    }
    public ArrayList<Tache> getTaches_unscheduled() {
        return Taches_unscheduled;
    }
    public void setTaches_unscheduled(ArrayList<Tache> taches_unscheduled) {
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
}
