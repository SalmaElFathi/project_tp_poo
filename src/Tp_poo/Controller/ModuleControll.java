package Tp_poo.Controller;

import Tp_poo.Main;
import Tp_poo.Models.Module;
import Tp_poo.Services.DB;

import java.sql.SQLException;

public class ModuleControll {
    public static void showMenu() throws SQLException {
        System.out.println("-------------------------[ Module ]---------------------------");

        System.out.println("1: Pour ajouter un module");
        System.out.println("2: Pour afficher les modules");
        System.out.println("3: Pour modifier les modules");
        System.out.println("4: Pour supprimer un module");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createModule();
                break;
            case 2:
                showModules();
                showMenu();
                break;
            case 3:
                editModule();
                break;
            case 4:
                destroyModule();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }
    public static void showModules(){
        for (Module module : DB.MD) {
            System.out.print("Intitulé  : " + module.getIntitule());
            System.out.print(" | chef : " + module.getProfesseur().getPrenom()+" "+ module.getProfesseur().getNom());
            System.out.print(" | Filiere : " + module.getFiliere().getIntitule());
            System.out.println("");
        }
    }
    public static void createModule() throws SQLException {
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        EnseignantControll.showEnseignants();
        int id = Main.getIntInput("Sélectionnez un prof par id:");
        FiliereControll.showFilieres();
        int idfil = Main.getIntInput("Sélectionnez une filiere par id:");
        Tp_poo.Services.Module.addFiliere(intitule,Tp_poo.Services.Enseignant.getEnsById(id), Tp_poo.Services.Filiere.getFiliereById(idfil));
        showModules();
        showMenu();
    }
    public static void editModule() throws SQLException {
        showModules();
        int id = Main.getIntInput("Sélectionnez un module par id :");
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        EnseignantControll.showEnseignants();
        int idens = Main.getIntInput("Sélectionnez un prof par id:");
        FiliereControll.showFilieres();
        int idfil = Main.getIntInput("Sélectionnez une filiere par id:");
        Tp_poo.Services.Module.updateModule(id,intitule,Tp_poo.Services.Enseignant.getEnsById(id), Tp_poo.Services.Filiere.getFiliereById(idfil));
        showModules();
        showMenu();
    }
    public static void destroyModule() throws SQLException {
        showModules();
        int id = Main.getIntInput("Sélectionnez un module par id :");
        Tp_poo.Services.Module.deleteModuleById(id);
        showModules();
        showMenu();
    }


}