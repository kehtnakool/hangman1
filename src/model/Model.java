package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Model {
    String andmebaasi_nimi = "sonad.db";
    Statement sql = null;
    String vaikimisi_kategooria = "All categories";
    String[] kategooriad = null;


    //konstruktor on public meetod, mille nmi on klassi nimi
    public Model() {

        try {
            Connection andmebaasi_yhendus = DriverManager.getConnection("jdbc:sqlite:" + andmebaasi_nimi);
            Statement sql = andmebaasi_yhendus.createStatement();
            sql.setQueryTimeout(6);
            sql.executeUpdate("PRAGMA foreign_keys='1'");


            ResultSet rs = sql.executeQuery("select kategooria from kategooriad;");
            while (rs.next()) {
                // read the result set
                System.out.println("sona = " + rs.getString("kategooria"));
            }
        } catch (SQLException e) {
            System.out.println("viga: " + e.getMessage());
            System.out.println("SQLi viga peaks tegelikult mängu kohe lõpetama");
        }

    }//konstruktori lõpp


}//klassi Model lõpp
