package Tp_poo.Controller;

import Tp_poo.Main;
import Tp_poo.Models.Enseignant;
import Tp_poo.Services.DB;

import java.sql.SQLException;


public class EnseignantControll {


    public static void showMenu() throws SQLException {
        System.out.println("-------------------------[ Enseignant ]---------------------------");

        System.out.println("1: Pour ajouter un enseignant");
        System.out.println("2: Pour afficher les enseignants");
        System.out.println("3: Pour modifier un enseignant");
        System.out.println("4: Pour supprimer un enseignant");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createEnseignant();
                break;
            case 2:
                showEnseignants();
                showMenu();
                break;
            case 3:
                editEnseignant();
                break;
            case 4:
                destroyEnseignant();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }


    public static void showEnseignants(){
        for (Enseignant enseignant : DB.EN) {
            System.out.print("Id : " + enseignant.getId());
            System.out.print(" | Nom : " + enseignant.getNom() + " " + enseignant.getPrenom());
            System.out.print(" | Email : " + enseignant.getEmail() );
            if (! Main.isNull(enseignant.getDepartement())) {
                System.out.print(" | département : " + enseignant.getDepartement().getIntitule());
            }
            System.out.println("");
        }
    }
    public static void createEnseignant() throws SQLException {
        String nom = Main.getStringInput("Entrez le nom :");
        String prenom = Main.getStringInput("Entrez le prenom :");
        String email = Main.getStringInput("Entrez l'email :");
        String grade = Main.getStringInput("Entrez  grade :");
        DepartementControll.showDepartements();
        int id = Main.getIntInput("Sélectionnez un département par id :");
        Tp_poo.Services.Enseignant.addEns(nom,prenom,email,grade,Tp_poo.Services.Departement.getDeptById(id));
        showEnseignants();
        showMenu();
    }
    public static void editEnseignant() throws SQLException {
        showEnseignants();
        int id = Main.getIntInput("Sélectionnez un enseiegnant par id :");
        String nom = Main.getStringInput("Entrez le nom :");
        String prenom = Main.getStringInput("Entrez le prenom :");
        String email = Main.getStringInput("Entrez l'email :");
        String grade = Main.getStringInput("Entrez  grade :");
        DepartementControll.showDepartements();
        int iddep = Main.getIntInput("Sélectionnez un département par id :");
        Tp_poo.Services.Enseignant.updateEns(id,nom,prenom,email,grade,Tp_poo.Services.Departement.getDeptById(iddep));
        showEnseignants();
        showMenu();


    }
    public static void destroyEnseignant() throws SQLException {
        showEnseignants();
        int id = Main.getIntInput("Sélectionnez un enseiegnant par id :");
        Tp_poo.Services.Enseignant.deleteEnsById(id);
        showEnseignants();
        showMenu();
    }
}