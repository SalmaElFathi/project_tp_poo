package Tp_poo.Services;

import Tp_poo.Models.Departement;
import Tp_poo.Models.Enseignant;

import java.util.ArrayList;
import java.util.Scanner;

public class Filiere {
    // ajouter une filiere
    public static Tp_poo.Models.Filiere addFiliere(String intitule, Enseignant chef, Departement dept) {
        Tp_poo.Models.Filiere filiere=new Tp_poo.Models.Filiere();
        filiere.setId(DB.getFilId());
        filiere.setIntitule(intitule);
        filiere.setResponsable(chef);
        filiere.setDepartement(dept);
        DB.FL.add(filiere);

        return  new Tp_poo.Models.Filiere();
    }

    //update filiere
    public static Tp_poo.Models.Filiere updateFiliere(int id , String intitule, Enseignant chef, Departement dept){
        for (Tp_poo.Models.Filiere filiere :DB.FL)
        {if (filiere.getId()==id){
            filiere.setIntitule(intitule);
            filiere.setResponsable(chef);
            filiere.setDepartement(dept);
            return filiere;}}
        return  new Tp_poo.Models.Filiere();
    }
    //delete filiere
    public static ArrayList<Tp_poo.Models.Filiere> deleteFiliereById(int id){
        DB.FL.remove(getFiliereById(id));
        return  DB.FL;
    }

    //get filiere by id
    public static Tp_poo.Models.Filiere getFiliereById(int id){
        for (Tp_poo.Models.Filiere filiere:DB.FL)
            if(filiere.getId()==id){return filiere;}
        return  new Tp_poo.Models.Filiere();}

    // get toutes les  filiere
    public static ArrayList<Tp_poo.Models.Filiere> getAllFiliere(){
        return  DB.FL;
    }

}