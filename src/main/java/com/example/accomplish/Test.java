package com.example.accomplish;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
       /* Utilisateur user1 = new Utilisateur("aminetech26","Amine2003");
        Utilisateur user2 = new Utilisateur("test","test2023");
        Utilisateur user3 = new Utilisateur("aminetech26","Amine2003");
        Utilisateur user4 = new Utilisateur("testuser","newuser");
        //System.out.println(user1.equals(user2));//it works
        ArrayList<Utilisateur> users = new ArrayList<Utilisateur>((Arrays.asList(user1,user2,user3)));
        Systeme sys = new Systeme(users);
        sys.setUsers_list(users);
        sys.authentification(user4,"sign up");*/
        Project myproject=new Project();
        myproject.setProject_name("my first project");
        myproject.setProject_description("my project for studying for my final exams");
        myproject.setProject_avancement(0.00);
       // Planning myplanning = new Planning("Exams planning");
        ArrayList<Tache> mytachelist=new ArrayList<Tache>();
        Categorie study_categorie=new Categorie("Study","blue");
      //  Tache new_tache=new Tache("revision maths",Priorite.MEDIUM,true,2023,study_categorie,false,false,false);
    }
}
