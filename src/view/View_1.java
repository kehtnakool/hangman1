package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class View_1 implements ActionListener {

    //klassi sisesed globaalid
    JFrame programmi_aken = new JFrame();
    String programmi_akna_tiitli_tekst = "Word puzzle summer 2023";
    int programmi_akna_laius = 600;
    int programmi_akna_korgus = 300;
    Color programmi_akna_taustavarv = new Color(0xAABBCC);
    //-------------------------------------------------------------
    JPanel ylemine_paneel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    int yp_raami_laius = 10;
    Color yp_taustavarv = new Color(0xFFFFFF);
    //--------------------------------------------------------------
    JLabel silt_kuupaev = new JLabel();
    JLabel silt_kategooria = new JLabel();
    JLabel silt_sisesta_taht = new JLabel();
    JLabel silt_valed_tahed = new JLabel();
    JLabel silt_valede_tahtede_arv = new JLabel();
    JLabel silt_pilt = new JLabel();
    //pildifail peab olema projekti kaustas
    //pildi puudumise korral asi ilma hoiatuse või veateateta käitub ettearvamatult
    ImageIcon pilt = new ImageIcon("01.png");
    //--------------------------------------------------------------
    JButton nupp_cancel = new JButton();
    JButton nupp_leader = new JButton();
    JButton nupp_new = new JButton();
    JButton nupp_send = new JButton();
    //--------------------------------------------------------------


    List kategooriad = new ArrayList<>();
    //komboboksi loomis hetkel peab tal olemas olema massiiv
    //cmbCategory = new JComboBox<>(model.getCmbNames()=massiiv);
    //usjuures sinna sulgude vahele ei sobi massiivi literaal, miks??
    //kas seda massiivi saab hiljem jooksvalt muuta??
    String[] strmassiiv = {"Bird", "Cat", "Dog", "Rabbit", "Pig"};
    //String[] strmassiiv_1={};
    JComboBox<String> kategooriabox = new JComboBox<>(strmassiiv);

    JTextField sisestuskast = new JTextField("", 14);


    ///futureMonths.add("January");


    public View_1() {
        /*
        kategooriad.add("zz");
        kategooriad.add("zz");
        System.out.println(kategooriad.get(0));
        */
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
        silt_valede_tahtede_arv.setText("valed tähed");
        silt_pilt.setText("siin on pilt");
        //silt_pilt.setIcon(pilt);


        nupp_cancel.setText("Cancel");
        nupp_leader.setText("View scoreboard");
        nupp_new.setText("New game");
        nupp_send.setText("Send");

        nupp_cancel.addActionListener(this);
        nupp_leader.addActionListener(this);
        nupp_new.addActionListener(this);
        nupp_send.addActionListener(this);


        //--------- alustame elementide paneelile ladumist

        // ESIMENE TULP

        //----------------------------------------------- 1
        gbc.gridy = 1; // rida
        gbc.gridx = 0; // Veerg
        //gbc.gridwidth = 3; // A label over three columns
        ylemine_paneel.add(silt_kategooria, gbc);
        //----------------------------------------------- 1
        gbc.gridy = 2; // rida
        gbc.gridx = 0; // Veerg
        //gbc.gridwidth = 3; // A label over three columns
        ylemine_paneel.add(silt_sisesta_taht, gbc);
        //----------------------------------------------- 1
        gbc.gridy = 3; // rida
        gbc.gridx = 0; // Veerg
        //gbc.gridwidth = 3; // A label over three columns
        ylemine_paneel.add(silt_valed_tahed, gbc);
        //----------------------------------------------- 1
        gbc.gridy = 4; // rida
        gbc.gridx = 0; // Veerg
        //gbc.gridwidth = 3; // A label over three columns
        ylemine_paneel.add(nupp_cancel, gbc);

        //              teine tulp

        //----------------------------------------------- 1
        gbc.gridy = 0; // rida
        gbc.gridx = 1; // Veerg
        //gbc.gridwidth = 3; // A label over three columns
        ylemine_paneel.add(silt_kuupaev, gbc);

        //----------------------------------------------- 1
        gbc.gridy = 1; // rida
        gbc.gridx = 1; // Veerg
        //gbc.gridwidth = 3; // A label over three columns
        ylemine_paneel.add(kategooriabox, gbc);

        //----------------------------------------------- 1
        gbc.gridy = 2; // rida
        gbc.gridx = 1; // Veerg
        //gbc.gridwidth = 3; // A label over three columns
        ylemine_paneel.add(sisestuskast, gbc);

        //----------------------------------------------- 1
        gbc.gridy = 3; // rida
        gbc.gridx = 1; // Veerg
        //gbc.gridwidth = 3; // A label over three columns
        //silt_valede_tahtede_arv.setBackground(yp_taustavarv);
        ylemine_paneel.add(silt_valede_tahtede_arv, gbc);

        //----------------------------------------------- 1
        gbc.gridy = 4; // rida
        gbc.gridx = 1; // Veerg
        //gbc.gridwidth = 3; // A label over three columns
        //silt_valede_tahtede_arv.setBackground(yp_taustavarv);
        ylemine_paneel.add(nupp_leader, gbc);

        //           kolmas tulp

        //----------------------------------------------- 1
        gbc.gridy = 1; // rida
        gbc.gridx = 2; // Veerg
        //gbc.gridwidth = 3; // A label over three columns
        ylemine_paneel.add(nupp_new, gbc);
        //----------------------------------------------- 1
        gbc.gridy = 2; // rida
        gbc.gridx = 2; // Veerg
        //gbc.gridwidth = 3; // A label over three columns
        ylemine_paneel.add(nupp_send, gbc);
        //----------------------------------------------- 1

//neljas tulp
        //----------------------------------------------- 1
        gbc.gridy = 2; // rida
        gbc.gridx = 3; // Veerg
        //gbc.gridwidth = 3; // A label over three columns
        ylemine_paneel.add(silt_pilt, gbc);
        //----------------------------------------------- 1


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
