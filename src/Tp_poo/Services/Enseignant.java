package Tp_poo.Services;

import Tp_poo.Models.Departement;

import java.util.ArrayList;
import java.util.Scanner;

public class Enseignant{
    //ajouter enseignant
    public static Tp_poo.Models.Enseignant addEns(String nom, String prenom, String email, String grade, Departement dept) {

        Tp_poo.Models.Enseignant enseignant = new Tp_poo.Models.Enseignant();
        enseignant.setId(DB.getEnsId());
        enseignant.setNom(nom);
        enseignant.setPrenom(prenom);
        enseignant.setEmail(email);
        enseignant.setGrade(grade);
        enseignant.setDepartement(dept);
        DB.EN.add(enseignant);
        return new Tp_poo.Models.Enseignant();
    }
    //UPDATE enseignant
    public static Tp_poo.Models.Enseignant updateEns(int id, String nom, String prenom, String email, String grade, Departement dept){
        for (Tp_poo.Models.Enseignant enseignant:DB.EN)
        {if(enseignant.getId()==id)
        {enseignant.setNom(nom);
            enseignant.setPrenom(prenom);
            enseignant.setGrade(grade);
            enseignant.setEmail(email);
            enseignant.setDepartement(dept);
            return enseignant;}}
        return  new Tp_poo.Models.Enseignant();
    }
    //supprimer enseignant
    public static ArrayList<Tp_poo.Models.Enseignant> deleteEnsById(int id){
        DB.EN.remove(getEnsById(id));
        return  DB.EN;
    }
    // get enseignant by id
    public static Tp_poo.Models.Enseignant getEnsById(int id){
        for (Tp_poo.Models.Enseignant enseignant : DB.EN) {
            if (enseignant.getId() == id) return  enseignant;
        }
        return  new Tp_poo.Models.Enseignant();
    }

    public static ArrayList<Tp_poo.Models.Enseignant>  getAllEnseignants() {
        return DB.EN;
    }
}