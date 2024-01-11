package Tp_poo.Controller;

import Tp_poo.Main;
import Tp_poo.Models.Filiere;
import Tp_poo.Services.DB;


import java.sql.SQLException;

public class FiliereControll {public static void showMenu() throws SQLException {
    System.out.println("-------------------------[ Filiere ]---------------------------");

    System.out.println("1: Pour ajouter une filiere");
    System.out.println("2: Pour afficher les filieres");
    System.out.println("3: Pour modifier une filiere");
    System.out.println("4: Pour supprimer une filiere");
    System.out.println("0: Pour retourner au menu principal");

    int option = Main.getIntInput("Veuillez sélectionner une option : ");
    switch(option) {
        case 1:
            createFiliere();
            break;
        case 2:
            showFilieres();
            showMenu();
            break;
        case 3:
            editFiliere();
            break;
        case 4:
            destroyFiliere();
            break;
        default:
            Main.showPrincipalMenu();
    }
}
    public static void showFilieres(){
        for (Filiere filiere : DB.FL) {
            System.out.print("Intitulé  : " + filiere.getIntitule());
            System.out.print(" | chef : " + filiere.getResponsable().getPrenom()+" "+filiere.getResponsable().getNom());
            System.out.print(" | Departement : " + filiere.getDepartement().getIntitule());
            System.out.println("");
        }
    }
    public static void createFiliere() throws SQLException {
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        EnseignantControll.showEnseignants();
        int id = Main.getIntInput("Sélectionnez un chef par id:");
        DepartementControll.showDepartements();
        int iddep = Main.getIntInput("Sélectionnez un département par id:");
        Tp_poo.Services.Filiere.addFiliere(intitule,Tp_poo.Services.Enseignant.getEnsById(id), Tp_poo.Services.Departement.getDeptById(iddep));
        showFilieres();
        showMenu();
    }
    public static void editFiliere() throws SQLException {
        showFilieres();
        int id = Main.getIntInput("Sélectionnez une filiere par id :");
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        EnseignantControll.showEnseignants();
        int idens = Main.getIntInput("Sélectionnez un chef par id:");
        DepartementControll.showDepartements();
        int iddep = Main.getIntInput("Sélectionnez un département par id:");
        Tp_poo.Services.Filiere.updateFiliere(id,intitule,Tp_poo.Services.Enseignant.getEnsById(idens), Tp_poo.Services.Departement.getDeptById(iddep));
        showFilieres();
        showMenu();
    }
    public static void destroyFiliere() throws SQLException {
        showFilieres();
        int id = Main.getIntInput("Sélectionnez une filiere par id :");
        Tp_poo.Services.Filiere.deleteFiliereById(id);
        showFilieres();
        showMenu();
    }
}