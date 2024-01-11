package Tp_poo.Services;

import Tp_poo.Models.Departement;

import java.util.ArrayList;

public class DB {
    public static int id_departement=0;
    public static int id_etudiant=0;
    public static int id_filiere=0;
    public static int id__module=0;
    public static int id_enseignat=0;
    //public static int id_note=0;


    public static ArrayList<Departement> DP=new ArrayList<Tp_poo.Models.Departement>();
    public static ArrayList<Tp_poo.Models.Enseignant> EN = new ArrayList<Tp_poo.Models.Enseignant>();
    public static ArrayList<Tp_poo.Models.Etudiant> ET= new ArrayList<Tp_poo.Models.Etudiant>();
    public static ArrayList<Tp_poo.Models.Filiere> FL = new ArrayList<Tp_poo.Models.Filiere>();
    public static ArrayList<Tp_poo.Models.Module> MD = new ArrayList<Tp_poo.Models.Module>();
    public static ArrayList<Tp_poo.Models.Note> NT = new ArrayList<Tp_poo.Models.Note>();

    public static int getDeptId(){
        id_departement++;
        return id_departement;}
    public static int getEtdId(){
        id_etudiant++;
        return id_etudiant;}
    public static int getFilId(){
        id_filiere++;
        return id_filiere;}
    public static int getMdlId(){
        id__module++;
        return id__module;}
    public static int getEnsId(){
        id_enseignat++;
        return id_enseignat;}
   /* public static int getNoteId(){
        id_note++;
        return id_note;}   */



}