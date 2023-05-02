package com.example.accomplish;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Systeme {
    private static final String FLAG_FILENAME = "appdir_created.flag";
    private static final String USER_LIST_FILE = "users.txt";
    private static final String FOLDER_NAME = "AccomplishFiles";
    private static String userDataFilePath = System.getProperty("user.dir") + File.separator + FOLDER_NAME + File.separator + USER_LIST_FILE;

    private static int seuil_minimal;
    private static int nb_tache_minimal;
    private ArrayList<Utilisateur> users_list;

    public Systeme(ArrayList<Utilisateur> users_list) {
        this.users_list = users_list;
    }

    public static int getSeuil_minimal() {
        return seuil_minimal;
    }

    public static void setSeuil_minimal(int seuil_minimal) {
        Systeme.seuil_minimal = seuil_minimal;
    }

    public static int getNb_tache_minimal() {
        return nb_tache_minimal;
    }

    public static void setNb_tache_minimal(int nb_tache_minimal) {
        Systeme.nb_tache_minimal = nb_tache_minimal;
    }

    public ArrayList<Utilisateur> getUsers_list() {
        return users_list;
    }

    public void setUsers_list(ArrayList<Utilisateur> users_list) {
        this.users_list = users_list;
    }

    public void authentification(Utilisateur user, String action) throws IOException {
        users_list = loadUsers();
        if (Objects.equals(action, "login")) {
            if (users_list.contains(user)) {
                System.out.println("successful login");
            } else {
                System.out.print("invalid username or password");
            }
        } else { //action sign up
            if (users_list.contains(user)) {
                System.out.println("User already exist");
            } else {
                System.out.println("Successful sign up");
                users_list.add(user);
                saveUsers(users_list);
            }
        }

    }

    public static void createAppDirectory() {
        String userHomeDir = System.getProperty("user.dir");
        File appDir = new File(userHomeDir, FOLDER_NAME);

        // Check if the flag file exists
        File flagFile = new File(appDir, FLAG_FILENAME);
        if (flagFile.exists()) {
            return; // Directory already created
        }

        // Create the directory and the flag file
        if (!appDir.exists()) {
            appDir.mkdir();
            try {
                flagFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(userHomeDir+FOLDER_NAME);
    }

    public static void saveUsers(List<Utilisateur> users) throws IOException {
        System.out.println(userDataFilePath);
        File userListFile = new File(userDataFilePath);
        if (!userListFile.exists()) {
            userListFile.createNewFile();
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(userDataFilePath));
        for (Utilisateur user : users) {
            writer.write(user.getUsername() + "," + user.getPassword());
            writer.newLine();
        }
        writer.close();
    }

    public static ArrayList<Utilisateur> loadUsers() throws IOException {
        ArrayList<Utilisateur> users = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(userDataFilePath));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            String username = parts[0];
            String password = parts[1];
            Utilisateur user = new Utilisateur(username, password);
            users.add(user);
        }
        reader.close();
        return users;
    }

}
