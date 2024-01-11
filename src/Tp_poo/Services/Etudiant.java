package Tp_poo.Services;

import Tp_poo.Models.Filiere;

import java.util.ArrayList;
import java.util.Scanner;

public class Etudiant  {
    public static Tp_poo.Models.Etudiant addEtd(String nom, String prenom, String email, int apogee, Filiere filiere){
        Tp_poo.Models.Etudiant etudiant=new Tp_poo.Models.Etudiant();
        etudiant.setId(DB.getEtdId());
        etudiant.setNom(nom);
        etudiant.setPrenom(prenom);
        etudiant.setEmail(email);
        etudiant.setApogee(apogee);
        etudiant.setFiliere(filiere);
        DB.ET.add(etudiant);
        return  new Tp_poo.Models.Etudiant();
    }

    //modifier etudiant
    public static Tp_poo.Models.Etudiant updateEtd(int id,String nom, String prenom, String email, int apogee, Filiere filiere){
        for (Tp_poo.Models.Etudiant etudiant :DB.ET)
        {if (etudiant.getId()==id){
            etudiant.setNom(nom);
            etudiant.setPrenom(prenom);
            etudiant.setEmail(email);
            etudiant.setApogee(apogee);
            etudiant.setFiliere(filiere);
            return etudiant;}}
        return  new Tp_poo.Models.Etudiant();
    }

    // delete etudiant
    public static ArrayList<Tp_poo.Models.Etudiant> deleteEtdById(int id){
        DB.ET.remove(getEtdById(id));

        return  DB.ET;
    }
    //get etudiant by id
    public static Tp_poo.Models.Etudiant getEtdById(int id){
        for (Tp_poo.Models.Etudiant etudiant : DB.ET) {
            if (etudiant.getId() == id) return  etudiant;
        }
        return  new Tp_poo.Models.Etudiant();
    }
//get tous les  etudiants

    public static ArrayList<Tp_poo.Models.Etudiant> getAllEtd(){
        return  DB.ET;
    }
}