package com.example.accomplish;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        Utilisateur user1 = new Utilisateur("aminetech26","Amine2003");
        Utilisateur user2 = new Utilisateur("test","test2023");
        Utilisateur user3 = new Utilisateur("aminetech26","Amine2003");
        Utilisateur user4 = new Utilisateur("testuser","newuser");
        //System.out.println(user1.equals(user2));//it works
        ArrayList<Utilisateur> users = new ArrayList<Utilisateur>((Arrays.asList(user1,user2,user3)));
        Systeme sys = new Systeme(users);
        sys.setUsers_list(users);
        sys.authentification(user4,"sign up");
        Categorie cat1 = new Categorie("Study","RED");
        LocalDate dealine = LocalDate.parse("2023-05-15");
        LocalDate dealine2 = LocalDate.parse("2023-05-10");
        Tache task1 = new Tache("TP POO",Priorite.HIGH,true,dealine,cat1,true,false);
        Tache task2 = new Tache("INTERFACE",Priorite.LOW,true,dealine,cat1,true,false);
        Tache task3 = new Tache("REV",Priorite.MEDIUM,true,dealine,cat1,true,false);
        Tache task4 = new Tache("ENTERTAINMENT",Priorite.HIGH,true,dealine2,cat1,true,false);
        Date date_debut = new Date(2023,4,14);
        List<Tache> taches = new ArrayList<Tache>();
        taches.add(task1);
        taches.add(task2);
        taches.add(task3);
        taches.add(task4);
        List<Creneau> cren = new ArrayList<Creneau>();
        Planning plan = new Planning("plan_test",taches,LocalDate.parse("2023-04-14"));
        plan.trier_tache();
        //ENTERTAINMENT,POO,REV,INTEFRACE
        for (Tache task:taches) {
            System.out.println(task.getTache_name());
        }


    }


}
