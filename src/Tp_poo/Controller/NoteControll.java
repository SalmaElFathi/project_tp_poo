package Tp_poo.Controller;

import Tp_poo.Main;
import Tp_poo.Models.Note;
import Tp_poo.Services.DB;

import java.sql.SQLException;

import static Tp_poo.Controller.EtudiantControll.showEtudiants;
import static Tp_poo.Controller.ModuleControll.showModules;

public class NoteControll {
    public static void showMenu() throws SQLException {
        System.out.println("-------------------------[ Note ]---------------------------");

        System.out.println("1: Pour ajouter une note");
        System.out.println("2: Pour afficher les notes");
        System.out.println("3: Pour modifier les notes");
        System.out.println("4: Pour supprimer une note");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createNote();
                break;
            case 2:
                showNotes();
                showMenu();
                break;
            case 3:
                editNote();
                break;
            case 4:
                destroyNote();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }
    public static void showNotes(){
        for (Note note : DB.NT) {
            System.out.print("étudiant  : " + note.getEtudiant().getNom()+" "+note.getEtudiant().getPrenom());
            System.out.print(" | module : " + note.getModule().getIntitule());
            System.out.print(" | note : " + note.getNote());
            System.out.println("");
        }
    }
    public static void createNote() throws SQLException {
        showEtudiants();
        int id = Main.getIntInput("Sélectionnez un étudiant par id:");
        showModules();
        int idmod = Main.getIntInput("Sélectionnez un module par id:");
        int note = Main.getIntInput("Entrez la note :");
        Tp_poo.Services.Note.addNote(note,Tp_poo.Services.Etudiant.getEtdById(id), Tp_poo.Services.Module.getModuleById(idmod));
        showNotes();
        showMenu();
    }
    public static void editNote() throws SQLException {
        showModules();
        int id_module = Main.getIntInput("Sélectionnez un module par id :");
        showEtudiants();
        int id_etudiant = Main.getIntInput("Sélectionnez un étudiant par id :");
        int note = Main.getIntInput("Entrez la nouvelle note:");
        Tp_poo.Services.Note.updateNote(note,Tp_poo.Services.Etudiant.getEtdById(id_etudiant), Tp_poo.Services.Module.getModuleById(id_module));
        showMenu();
    }
    public static void destroyNote() throws SQLException {
        showNotes();
        int id_etudiant = Main.getIntInput("Sélectionnez un étudiant par id :");
        int id_module = Main.getIntInput("Sélectionnez un module par id :");
        Tp_poo.Services.Note.deleteNoteById(id_etudiant,id_module);
        showNotes();
        showMenu();
    }



}