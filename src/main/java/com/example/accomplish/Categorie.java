package com.example.accomplish;

import java.util.Objects;

public class Categorie {
    private String categorie_name;
    private String Categorie_color;
    private  int durre_passe_dans_categorie=0; // initialement zero .......
    public Categorie(String categorie_name, String categorie_color) {
        this.categorie_name = categorie_name;
        Categorie_color = categorie_color;
    }
    public Categorie(){

    }
    public String getCategorie_name() {
        return categorie_name;
    }
    public void setCategorie_name(String categorie_name) {
        this.categorie_name = categorie_name;
    }
    public String getCategorie_color() {
        return Categorie_color;
    }
    public void setCategorie_color(String categorie_color) {
        Categorie_color = categorie_color;
    }
    public void affecter_color(String color){
        setCategorie_color(color);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        final Categorie other = (Categorie) obj;
        if (!Objects.equals(this.categorie_name,other.categorie_name)){
            return false;
        }
        return Objects.equals(this.Categorie_color,other.Categorie_color);
    }
}
