package view;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


public class Edetabel {

    //klassi sisesed globaalid
    JFrame programmi_aken = new JFrame();
    String programmi_akna_tiitli_tekst = "Sõnade äraarvamise mängu edetabel";
    int programmi_akna_laius = 600;
    int programmi_akna_korgus = 300;
    Color programmi_akna_taustavarv = new Color(0xFFFFFF);
    //-------------------------------------------------------------
    JLabel silt_edetabel = new JLabel();

    //public Edetabel () {
    public Edetabel() {
        //---------------- teeme programmi akna -----------------------

        //programmi_aken.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        programmi_aken.setTitle(programmi_akna_tiitli_tekst);
        programmi_aken.setSize(programmi_akna_laius, programmi_akna_korgus);
        programmi_aken.getContentPane().setBackground(programmi_akna_taustavarv);
        programmi_aken.setResizable(false);
//ei kasuta layout manageri esialgu, see muudab leibelid nähtamatuks
        programmi_aken.setLayout(null);
        //----------------- programmi aken valmis ------------------
        //----------------- teeme edetabeli sildi ------------------
        silt_edetabel.setText("edetabel");
        silt_edetabel.setBounds(0, 0, programmi_akna_laius, programmi_akna_korgus);

        //programmi_aken.setVisible(true);

    }//konstruktor View() lõpp


    public JFrame get_edetabel() {
        return programmi_aken;
    }

    ;


}//class View lõpp
