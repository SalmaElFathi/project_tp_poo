package Tp_poo.Models;
import java.util.ArrayList;

public class Filiere {
    private int id;
    private String intitule;
    private Enseignant Responsable;
    private Departement departement;
    ArrayList<Module> MD = new ArrayList<Module>();




    public Filiere(){}
    public Filiere(String intitule, Enseignant responsable, Departement departement) {
        this.intitule = intitule;
        this.Responsable = responsable;
        this.departement = departement;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Enseignant getResponsable() {
        return Responsable;
    }

    public void setResponsable(Enseignant responsable) {
        Responsable = responsable;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
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
}
