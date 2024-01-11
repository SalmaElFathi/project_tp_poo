package Tp_poo.Models;


import java.util.ArrayList;

public class Enseignant {
    static int id;
    private String nom;
    private String prenom;
    private String email;
    private String grade;
    private Departement departement;
    ArrayList<Module> MD = new ArrayList<Module>();


    public Enseignant() {
    }

    public Enseignant( String nom, String prenom, String email, String grade, Departement departement) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.grade = grade;
        this.departement = departement;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public ArrayList<Module> getMD() {
        return MD;
    }

    public void setMD(ArrayList<Module> MD) {
        this.MD = MD;
    }

    public boolean equals(Enseignant obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getId() != this.id) {
            return false;
        }

        return true;
    }

}