package Okna;

import UstawieniaGry.BudowaGry;
import UstawieniaGry.Punkty;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class OknoWyniki extends JFrame {

    JPodPanel jPanel = new JPodPanel(new ImageIcon("ProjektDrugi/src/Obrazy/korona.jpg"));
    JPanel guzik = new JPanel();
    int lenght = BudowaGry.wszystkeiWyniki.size();


    public OknoWyniki( )  {
        BudowaGry.wczytajWynik();
         String[] wyszystkieWyniki = new String[lenght];
        int i=0;
        for(Punkty punkty : BudowaGry.wszystkeiWyniki){
            wyszystkieWyniki[i] = "Zdobyte punkty to "+ punkty.getZdobytePunkty() +", Nick to "+ punkty.getNick()+" Przeżył " + punkty.getPrzeżyteDni() + "dni, Poziom to " + punkty.getPoziomTrudności();
            i++;
        }


            JList<String> listaWynikow = new JList<>(wyszystkieWyniki);
            JScrollPane jScrollPane = new JScrollPane(listaWynikow);
            jPanel.add(jScrollPane);


        JButton powrot = new JButton("Powrót");
        powrot.addActionListener((action)->{
            dispose();
            OknoMenu oknoMenu = new OknoMenu();
        });


        jPanel.add(powrot);

        add(guzik);
        add(jPanel);
        setLocationRelativeTo(null);
        setPreferredSize(new Dimension(700,400));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
