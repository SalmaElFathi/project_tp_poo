package Tp_poo;
import Tp_poo.Controller.*;
import Tp_poo.Models.Departement;
import Tp_poo.Services.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import static Tp_poo.Phase2.Departement_DB.createTable;
import static Tp_poo.Phase2.Departement_DB.getAllDepartements;


public class Main {


    public static boolean isNull(Object ob) {
        return ob == null ;
    }
    public static int getIntInput(String... msg) {
        Scanner S = new Scanner(System.in);
        String message = "Entrez un nombre entier : ";
        if (msg.length > 0 )
            message = msg[0] ;
        System.out.print(message);

        // This method reads the number provided using keyboard
        int num = S.nextInt();

        // Closing Scanner after the use
        //  scan.close();
        return num;
    }

    public static String getStringInput(String... msg) {
        Scanner S = new Scanner(System.in);
        String message = "Entrez un texte : ";
        if (msg.length > 0 )
            message = msg[0] ;
        System.out.print(message);

        // This method reads the number provided using keyboard
        String str = S.nextLine();

        // Closing Scanner after the use
        //  scan.close();
        return str;
    }

    public static void showPrincipalMenu() throws SQLException {
        System.out.println("******** welcome *******");


        System.out.println("1: Pour gérer les départements");
        System.out.println("2: Pour gérer les filières");
        System.out.println("3: Pour gérer les enseignants");
        System.out.println("4: Pour gérer les modules");
        System.out.println("5: Pour gérer les étudiants");
        System.out.println("6: Pour gérer les notes");

        System.out.println("0: Pour sortir");

        //"Veuillez sélectionner une option : ")
        int option = getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                DepartementControll.showMenu();
                break;
            case 2:
                FiliereControll.showMenu();
                break;
            case 3:
                EnseignantControll.showMenu();
                break;
            case 4:
                ModuleControll.showMenu();
                break;
            case 5:
                EtudiantControll.showMenu();
                break;
            case 6:
                NoteControll.showMenu();
                break;
            default: Main.showPrincipalMenu();
        }
    }


    public static  void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/test";
         String user = "root";
        String pwd = "";
        try {

             Connection cx= DriverManager.getConnection(url, user, pwd);
            System.out.println("Good Connection");

         createTable(cx);
            List<Departement> departements = getAllDepartements(cx);
            for (Departement departement : departements) {
                System.out.println(departement.toString());
            }

            Tp_poo.Models.Enseignant enseignant = new Tp_poo.Models.Enseignant();
            enseignant.setNom("salma");
            enseignant.setPrenom("fathi");
            enseignant.setEmail("salma@gmail.com");
            enseignant.setGrade("PES");
            enseignant.setId(DB.getEnsId());
            DB.EN.add(enseignant);
            showPrincipalMenu();




        } catch (
                SQLException e) {
            System.out.println("Bad Connection");
            e.printStackTrace();
        }




    }
}