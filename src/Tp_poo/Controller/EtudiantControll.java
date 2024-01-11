package Tp_poo.Controller;

import Tp_poo.Main;
import Tp_poo.Models.Etudiant;
import Tp_poo.Services.DB;

import java.sql.SQLException;

public class EtudiantControll {
    public static void showMenu() throws SQLException {
        System.out.println("-------------------------[ Etudiant ]---------------------------");

        System.out.println("1: Pour ajouter un étudiant");
        System.out.println("2: Pour afficher les étudiants");
        System.out.println("3: Pour modifier un étudiant");
        System.out.println("4: Pour supprimer un étudiant");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createEtudiant();
                break;
            case 2:
                showEtudiants();
                showMenu();
                break;
            case 3:
                editEtudiant();
                break;
            case 4:
                destroyEtudiant();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }
    public static void showEtudiants(){
        for (Etudiant etudiant : DB.ET) {
            System.out.print("Id : " + etudiant.getId());
            System.out.print(" | nom : " + etudiant.getNom());
            System.out.print(" | prenom : " + etudiant.getPrenom());
            System.out.print(" | email : " + etudiant.getEmail());
            System.out.print(" | apoge : " + etudiant.getApogee());
            System.out.print(" | filiere : " + etudiant.getFiliere().getIntitule());
            System.out.println("");
        }
    }
    public static void createEtudiant() throws SQLException {
        String nom = Main.getStringInput("Entrez le nom :");
        String prenom = Main.getStringInput("Entrez le prenom :");
        String email = Main.getStringInput("Entrez l'email :");
        int apogee = Main.getIntInput("Entrez le numero apogee :");
        FiliereControll.showFilieres();
        int id = Main.getIntInput("Sélectionnez une filière  par id :");
        Tp_poo.Services.Etudiant.addEtd(nom,prenom,email,apogee, Tp_poo.Services.Filiere.getFiliereById(id));
        showEtudiants();
        showMenu();
    }
    public static void editEtudiant() throws SQLException {
        showEtudiants();
        int id = Main.getIntInput("Sélectionnez un étudiant par id :");
        String nom = Main.getStringInput("Entrez le nom :");
        String prenom = Main.getStringInput("Entrez le prenom :");
        String email = Main.getStringInput("Entrez l'email :");
        int apogee = Main.getIntInput("Entrez le numero apogee :");
        FiliereControll.showFilieres();
        int idetd = Main.getIntInput("Sélectionnez une filière  par id :");
        Tp_poo.Services.Etudiant.updateEtd(id, nom,prenom,email,apogee, Tp_poo.Services.Filiere.getFiliereById(id));
        showEtudiants();
        showMenu();
    }
    public static void destroyEtudiant() throws SQLException {
        showEtudiants();
        int id = Main.getIntInput("Sélectionnez un étudiant par id :");
        Tp_poo.Services.Etudiant.deleteEtdById(id);
        showEtudiants();
        showMenu();
    }
}