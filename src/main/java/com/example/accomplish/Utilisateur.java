package com.example.accomplish;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Utilisateur {
    private String username;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Project> getListe_projet() {
        return liste_projet;
    }

    public void setListe_projet(List<Project> liste_projet) {
        this.liste_projet = liste_projet;
    }

    private List<Project> liste_projet;
    private Project current_project;

    public Project getCurrent_project() {
        return current_project;
    }

    public void setCurrent_project(Project current_project) {
        this.current_project = current_project;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Utilisateur other = (Utilisateur) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return Objects.equals(this.password, other.password);
    }
    public Utilisateur(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
