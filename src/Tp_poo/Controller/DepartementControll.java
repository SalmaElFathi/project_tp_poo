package Tp_poo.Controller;

import Tp_poo.Main;
import Tp_poo.Models.Departement;
import Tp_poo.Phase2.Connection_db;
import Tp_poo.Phase2.Departement_DB;
import Tp_poo.Services.DB;
import Tp_poo.Services.Enseignant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static Tp_poo.Phase2.Departement_DB.deleteDepartement;
import static Tp_poo.Phase2.Departement_DB.getAllDepartements;


public class DepartementControll {
    static String url = "jdbc:mysql://localhost:3306/test";
    static String user = "root";
    static String pwd = "";

        static Connection cx;

    static {
        try {
            cx = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public DepartementControll() throws SQLException {
    }

    public static void showMenu() throws SQLException {
        System.out.println("-------------------------[ Départements ]---------------------------");

        System.out.println("1: Pour ajouter un département");
        System.out.println("2: Pour afficher les départements");
        System.out.println("3: Pour modifier un département");
        System.out.println("4: Pour supprimer un département");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createDepartement();
                break;
            case 2:
                showDepartements();
                showMenu();
                break;
            case 3:
                editDepartement();
                break;
            case 4:
                destroyDepartement();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }
    public static void showDepartements() throws SQLException {

        for (Departement departement : DB.DP) {
            System.out.print("Id : " + departement.getId());
            System.out.print(" | Intitulé : " + departement.getIntitule());
            if (! Main.isNull(departement.getResponsable())) {
                System.out.print(" | Chef : " + departement.getResponsable().getNom() + " " + departement.getResponsable().getPrenom());
            }
            System.out.println("");
        }
        getAllDepartements( cx);

    }
    public static void createDepartement() throws SQLException {
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        EnseignantControll.showEnseignants();
        int id = Main.getIntInput("Sélectionnez un enseignant par id :");
        Departement departement=Tp_poo.Services.Departement.addDpt(intitule, Tp_poo.Services.Enseignant.getEnsById(id));

        showDepartements();
        System.out.println();
        Departement_DB.insertDepartement(departement,cx);
        showMenu();
    }
    public static void editDepartement() throws SQLException {
        showDepartements();
        int id = Main.getIntInput("Sélectionnez un departement par id :");
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        EnseignantControll.showEnseignants();
        int idEns = Main.getIntInput("Sélectionnez un enseignant par id :");
        Tp_poo.Services.Departement.updateDept(id, intitule, Tp_poo.Services.Enseignant.getEnsById(idEns));
        showDepartements();
        showMenu();
    }
    public static void destroyDepartement() throws SQLException {
        showDepartements();
        int id = Main.getIntInput("Sélectionnez un departement par id :");
        Tp_poo.Services.Departement.removeDpt(id);
        deleteDepartement( id,cx) ;
        showDepartements();
        showMenu();
    }
}