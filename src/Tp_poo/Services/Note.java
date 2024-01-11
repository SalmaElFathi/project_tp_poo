package Tp_poo.Services;

import Tp_poo.Models.Etudiant;
import Tp_poo.Models.Module;

import java.util.ArrayList;

public class Note {
    //ajout d'une note
    public static Tp_poo.Models.Note addNote(float n, Tp_poo.Models.Etudiant etudiant, Tp_poo.Models.Module module) {
        Tp_poo.Models.Note note = new Tp_poo.Models.Note();
        note.setNote(n);
        note.setEtudiant(etudiant);
        note.setModule(module);
        return new Tp_poo.Models.Note();
    }

    //modifier une note
    public static Tp_poo.Models.Note updateNote(float n, Tp_poo.Models.Etudiant etudiant, Tp_poo.Models.Module module) {
        for (Tp_poo.Models.Note note : DB.NT) {
            if ((note.getEtudiant().getId() == etudiant.getId()) && (note.getModule().getId() ==module.getId())) {
                note.setNote(n);
                note.setEtudiant(etudiant);
                note.setModule(module);
                return note;
            }
        }
        return new Tp_poo.Models.Note();
    }

    // supprimer note par id d'etudiant et de module
    public static ArrayList<Tp_poo.Models.Note> deleteNoteById(int id_etud, int id_mod) {
        DB.NT.remove(getNoteById(id_etud, id_mod));
        return DB.NT;
    }
    //GET NOT BY ID ETUDIANT ET ID FILIERE
    public static Tp_poo.Models.Note getNoteById(int id_etud, int id_mod) {
        for (Tp_poo.Models.Note note : DB.NT) {
            if ((note.getEtudiant().getId() == id_etud) && (note.getModule().getId() == id_mod)) {
                return note;
            }
        }
        return new Tp_poo.Models.Note();
    }

    // get tous les notes
    public static ArrayList<Tp_poo.Models.Note> getAllNote() {
        return DB.NT;
    }

}