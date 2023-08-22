package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


public class Model_1 {
    String andmebaasi_nimi = "sonad.db";
    Statement sql = null;
    String vaikimisi_kategooria = "All categories";
    String[] kategooriad = null;

    String ajutine_listi_nimi = "";
    int counter = 0;

    HashMap<String, List<String>> sonad_dic = new HashMap<>();
    ArrayList<String> sonad_list = new ArrayList<>();


    //konstruktor on public meetod, mille nmi on klassi nimi
    public Model_1() {
        sonad_list.add("essa");
        sonad_list.add("tessa");
        sonad_list.add("kossa");

        sonad_dic.put("All categories", sonad_list);

        //System.out.println(sonad_dic.get("All categories").get(1));

        for (int i = 0; i < sonad_dic.get("All categories").size(); i++) {
            ajutine_listi_nimi = sonad_dic.get("All categories").get(i);
            ajutine_listi_nimi = i + "";
            ArrayList<String> a = new ArrayList<>();

            a.add(0, "test");

            //System.out.println(sonad_dic.get("All categories").get(i));
        }

        System.out.println("----- a -------");

//capitalCities.put("England", "London");

        //-------------------------------andmebaas


        try (Connection andmebaasi_yhendus = DriverManager.getConnection("jdbc:sqlite:" + andmebaasi_nimi);) {

            Statement sql = andmebaasi_yhendus.createStatement();
            sql.setQueryTimeout(6);
            sql.executeUpdate("PRAGMA foreign_keys='1'");


            ResultSet kategooriad = sql.executeQuery("select * from kategooriad;");
            while (kategooriad.next()) {
                // read the result set
                System.out.println("siin");
                System.out.println("kategooria = " + kategooriad.getString(2));
                ajutine_listi_nimi = counter + "";
                ArrayList<String> ajutine_listi_nimi = new ArrayList<>();

                //-----------------------------------sisemine loop
                ResultSet sonad = sql.executeQuery("select * from sonad");
                //ResultSet sonad = sql.executeQuery("select sona from sonad where kat_id = "+kategooriad.getString("id"));
                /*
                while(sonad.next())
                {
                    ajutine_listi_nimi.add(sonad.getString("sona"));

                }
*/
                //-----------------------------------sisemine loop

                sonad_dic.put(kategooriad.getString(2), ajutine_listi_nimi);

                counter++;

            }
        } catch (SQLException e) {
            System.out.println("viga: " + e.getMessage());
            System.out.println("SQLi viga peaks tegelikult mängu kohe lõpetama");
        }


        //-------------------------------andmebaas
    }//konstruktori lõpp


    public void test() throws IOException {

//piisab kui kasutame throw koos try-with resources statementiga
        //vea püüdmisega tegeleb see, kes funktsiooni välja kutsub
        //kohustuslikus korras niikuinii

        try (BufferedReader br =
                     new BufferedReader(new FileReader("test.txt"))) {

//kui viga tekib, siis selle tekitab nende väite kohaselt alljärgnev rida
//Aga mis juhtub siis, kui Filereaderile anda sisendiks olematu path??
            System.out.println(br.readLine());

        }
        /*
        catch (IOException e) {
            throw new RuntimeException(e);
        }

*/


    }//test() lõpp


}//klassi Model_1 lõpp
