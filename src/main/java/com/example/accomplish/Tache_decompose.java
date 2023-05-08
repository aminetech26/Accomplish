package com.example.accomplish;
import java.util.ArrayList;
import java.util.Scanner;
public class Tache_decompose extends Tache{
    private ArrayList<Tache_simple> list_taches;
    private int taux_etat_realisation;

    public Tache_decompose(String tache_name, Priorite tache_priorite, boolean ifdeadline, int deadline, Categorie tache_categorie, boolean tasktype, boolean scheduled, boolean tache_locked, ArrayList<Tache_simple> list_taches) {
        super(tache_name, tache_priorite, ifdeadline, deadline, tache_categorie, tasktype, tache_locked);
        this.list_taches = list_taches;
    }
    public Tache_decompose() {
    }
    public ArrayList<Tache_simple> getList_taches() {
        return list_taches;
    }
    public void setList_taches(ArrayList<Tache_simple> list_taches) {
        this.list_taches = list_taches;
    }
    public int getTaux_etat_realisation() {
        return taux_etat_realisation;
    }
    public void setTaux_etat_realisation(int taux_etat_realisation) {
        this.taux_etat_realisation = taux_etat_realisation;
    }
    public void edit_name_sous_tache(Tache_simple tache_edited,String new_tache_name){
        if (this.list_taches.contains(tache_edited)){
            System.out.println("enter the new name to this tache");
            Scanner sc=new Scanner(System.in);
            new_tache_name=sc.nextLine();
            this.list_taches.get(list_taches.indexOf(tache_edited)).setTache_name(new_tache_name);
        }{
            System.out.println("error !! this tache doesn't exist");
        }
    }
}
