package Tp_poo.Services;

import Tp_poo.Models.Enseignant;
import Tp_poo.Models.Filiere;

import java.util.ArrayList;

public class Module  {
    // ajout d'un module
    public static Tp_poo.Models.Module addFiliere(String intitule, Enseignant chef,  Filiere filiere) {
        Tp_poo.Models.Module module=new    Tp_poo.Models.Module();
        module.setId(DB.getMdlId());
        module.setIntitule(intitule);
        module.setProfesseur(chef);
        module.setFiliere(filiere);
        DB.MD.add(module);

        return  new Tp_poo.Models.Module();
    }
    //modifier un module
    public static Tp_poo.Models.Module updateModule(int id , String intitule, Enseignant chef,  Filiere filiere){
        for (Tp_poo.Models.Module module:DB.MD){
            if(module.getId()==id){
                module.setIntitule(intitule);
                module.setProfesseur(chef);
                module.setFiliere(filiere);
                return module;
            }
        }
        return  new Tp_poo.Models.Module();
    }

    // supprimer module par id
    public static ArrayList<Tp_poo.Models.Module> deleteModuleById(int id){
        DB.MD.remove(getModuleById(id));
        return  DB.MD;
    }

    public static Tp_poo.Models.Module getModuleById(int id){
        for (Tp_poo.Models.Module module :DB.MD){
            if(module.getId()==id){
                return module;
            }
        }
        return  new Tp_poo.Models.Module();
    }
    // get tous les modules
    public static ArrayList<Tp_poo.Models.Module> getAllModule(){
        return  DB.MD;
    }



}