package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class View implements ActionListener {

    //klassi sisesed globaalid
    JFrame programmi_aken = new JFrame();
    String programmi_akna_tiitli_tekst = "Word puzzle summer 2023";
    int programmi_akna_laius = 600;
    int programmi_akna_korgus = 300;
    Color programmi_akna_taustavarv = new Color(0xAABBCC);
    //-------------------------------------------------------------
    JPanel ylemine_paneel = new JPanel();
    int yp_raami_laius = 10;
    Color yp_taustavarv = new Color(0xFFFFFF);
    //--------------------------------------------------------------
    JLabel silt_kuupaev = new JLabel();
    JLabel silt_kategooria = new JLabel();
    JLabel silt_sisesta_taht = new JLabel();
    JLabel silt_valed_tahed = new JLabel();
    //--------------------------------------------------------------
    JButton nupp_cancel = new JButton();
    JButton nupp_leader = new JButton();
    JButton nupp_new = new JButton();
    JButton nupp_send = new JButton();

    public View() {
        //---------------- teeme programmi akna -----------------------
        programmi_aken.setDefaultCloseOperation(3);//exit_on_close
        programmi_aken.setTitle(programmi_akna_tiitli_tekst);
        programmi_aken.setSize(programmi_akna_laius, programmi_akna_korgus);
        programmi_aken.getContentPane().setBackground(programmi_akna_taustavarv);
        programmi_aken.setResizable(false);
        programmi_aken.setVisible(true);
//ei kasuta layout manageri esialgu, see muudab leibelid nähtamatuks
        programmi_aken.setLayout(null);
        //----------------- programmi aken valmis ------------------
        //----------------- teeme ülemise paneeli ------------------

        ylemine_paneel.setBackground(yp_taustavarv);
        //kui ei kasuta layout manageri, siis saab niimoodi set bounds (x,y, laius, kõrgus)
        ylemine_paneel.setBounds(0, 0, programmi_akna_laius, programmi_akna_korgus / 2);
        ylemine_paneel.setBorder(BorderFactory.createMatteBorder(yp_raami_laius, yp_raami_laius, yp_raami_laius, yp_raami_laius, programmi_akna_taustavarv));

        programmi_aken.add(ylemine_paneel);

        //----------------- paneme ülemisele paneelile sildid

        silt_kuupaev.setText("kuupaev");
        silt_kategooria.setText("Category");
        silt_sisesta_taht.setText("Input character");
        silt_valed_tahed.setText("Wrong 0 letters");

        ylemine_paneel.add(silt_kuupaev);
        ylemine_paneel.add(silt_kategooria);
        ylemine_paneel.add(silt_sisesta_taht);
        ylemine_paneel.add(silt_valed_tahed);

        //----------------- paneme ülemisele paneelile nupud

        nupp_cancel.setBounds(0, 50, 10, 40);


        nupp_cancel.setText("Cancel");
        nupp_leader.setText("View scoreboard");
        nupp_new.setText("New game");
        nupp_send.setText("Send");

        nupp_cancel.addActionListener(this);
        nupp_leader.addActionListener(this);
        nupp_new.addActionListener(this);
        nupp_send.addActionListener(this);

        ylemine_paneel.add(nupp_cancel);
        ylemine_paneel.add(nupp_leader);
        ylemine_paneel.add(nupp_new);
        ylemine_paneel.add(nupp_send);


    }//konstruktor View() lõpp

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if (actionEvent.getSource() == nupp_cancel) {
            System.out.println("cancel prssed");
        }

        if (actionEvent.getSource() == nupp_leader) {
            System.out.println("leader prssed");
        }

        if (actionEvent.getSource() == nupp_new) {
            System.out.println("new prssed");
        }

        if (actionEvent.getSource() == nupp_send) {
            System.out.println("send prssed");
        }

    }
}//class View lõpp
