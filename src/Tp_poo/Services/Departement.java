package Tp_poo.Services;

import Tp_poo.Models.Enseignant;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import static Tp_poo.Phase2.Departement_DB.*;

public class Departement {

    //ajouter un département
    public static Tp_poo.Models.Departement addDpt(String intitule, Enseignant... responsable) throws SQLException {
        Tp_poo.Models.Departement departement=new Tp_poo.Models.Departement();
        departement.setIntitule(intitule);
        departement.setId(DB.getDeptId());

        if(responsable.length>0){departement.setResponsable(responsable[0]);}
        DB.DP.add(departement);
        return departement;
    }
    //  modifier un departement
    public static Tp_poo.Models.Departement updateDept(int id , String intitule, Enseignant... chef){
        for (Tp_poo.Models.Departement departement : DB.DP) {
            if (departement.getId() == id) {
                departement.setIntitule(intitule);
                if (chef.length > 0){
                    departement.setResponsable(chef[0]);
                }
                return departement;
            }
        }
        return  new Tp_poo.Models.Departement();
    }
    //remove departement
    public static ArrayList<Tp_poo.Models.Departement> removeDpt(int id) throws SQLException {
        DB.DP.remove(getDeptById(id));
        return DB.DP;}


    //get departement by id
    public static Tp_poo.Models.Departement getDeptById(int id){
        for (Tp_poo.Models.Departement departement : DB.DP) {
            if (departement.getId() == id) return  departement;
        }
        return  new Tp_poo.Models.Departement();
    }
    //get tous les départements
    public static ArrayList<Tp_poo.Models.Departement> getAllDept() throws SQLException {


        return  DB.DP;
    }


}