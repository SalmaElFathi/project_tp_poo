package Tp_poo.Phase2;

import Tp_poo.Models.Departement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Departement_DB   {

    public static void insertDepartement(Departement departement, Connection cx )throws SQLException {
       // cx=Connection_db.createconnection();

        String query="Insert into departements(intitule,id_ens)values(?,?)";

        PreparedStatement ps = cx.prepareStatement(query);

        ps.setString(1, departement.getIntitule());
        ps.setInt(2, departement.getResponsable().getId());

        ps.executeUpdate();


    }

    public static void deleteDepartement(int id, Connection cx) throws SQLException {
        //cx=Connection_db.createconnection();
        String query = "DELETE  from departements where id = ?";
        PreparedStatement ps = cx.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();


    }



    public static List<Departement> getAllDepartements(Connection cx) throws SQLException {
        //cx=Connection_db.createconnection();
        String query = "SELECT * from departements";
        List<Departement> departements = new ArrayList<>();

        Statement st = cx.createStatement();

        ResultSet r = st.executeQuery(query);

        while (r.next()) {

            departements.add(
                    new Departement(r.getInt("id_ens"),
                            r.getString("intitule")

                    )
            );
        }

        return departements;


    }

    // jjjjjjj
   /* public static void getDepartement(int id ,Connection cx) throws SQLException {
        String query = "SELECT * from departements where id="+id;
        Statement st = cx.createStatement();
        ResultSet r = st.executeQuery(query);
        while (r.next()) {


                  System.out.println((r.getInt("id_ens"),
                            r.getString("intitule")

                    )
            );
        }}*/

    public static void createTable(Connection cx) throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS departements(\n" +
                "                                       id int primary key auto_increment,\n" +
                "                                       intitule varchar(255),\n" +
                "                                       id_responsable int\n" +
                ");";

        Statement st = cx.createStatement();

        st.execute(query);


    }

}

