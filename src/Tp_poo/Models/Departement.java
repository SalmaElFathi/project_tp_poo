package Tp_poo.Models;


import java.util.ArrayList;

import static Tp_poo.Services.DB.DP;

public class Departement {
    private int id;
    private String intitule;
    private Enseignant Responsable;
    private int id_ens;
    ArrayList<Filiere> FL = new ArrayList<Filiere>();
    public Departement(){}

    public Departement(String intitule, Enseignant responsable) {
        this.intitule = intitule;
        this.Responsable = responsable;
    }

    public Departement(int id_ens,String intitule) {
        this.id_ens = id_ens;
        this.intitule=intitule;
    }

    /* Departments(String intitule,int id_ens){
             this.intitule=intitule;
             this.id_ens=id_ens;
    }*/
    public String getIntitule() {
        return intitule;
    }

    public  void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Enseignant getResponsable() {
        return Responsable;
    }

    public void setResponsable(Enseignant responsable) {
        Responsable = responsable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Filiere> getFilieres() {
        return FL;
    }

    public void setFilieres(ArrayList<Filiere> filieres) {
        this.FL = filieres;
    }
}