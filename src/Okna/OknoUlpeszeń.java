package Okna;

import Countres.Panstwo;
import Ulepszenia.Ulepszenie;
import UstawieniaGry.DaneGry;

import javax.swing.*;
import java.awt.*;

public class OknoUlpeszeń extends JFrame {

    JPanel tlo = new JPanel();


    public OknoUlpeszeń(Panstwo panstwo, Ulepszenie ulepszenie) throws HeadlessException {
        tlo.setLayout(new GridLayout(3,0,20,10));
        JLabel ul = new JLabel("Ulepszenie");

        tlo.add(ul);
        JLabel ulNazwa = new JLabel(ulepszenie.getNazwa());

        tlo.add(ulNazwa);
        JLabel cena = new JLabel("Cena");

        tlo.add(cena);
        JLabel koszt = new JLabel(ulepszenie.getCenaUlepszenia() + "zł");

        tlo.add(koszt);

       JButton wroc = new JButton("Powrot");
       wroc.addActionListener((w)->{
           dispose();
       });
       tlo.add(wroc);
       JButton kup = new JButton("Kup");

       kup.addActionListener((k)->{
           if(DaneGry.pieniadze >= ulepszenie.getCenaUlepszenia()) {
               panstwo.getOdpaloneUlepszenia().add(ulepszenie);
               DaneGry.pieniadze -= ulepszenie.getCenaUlepszenia();
               dispose();
           }
       });

       if(DaneGry.pieniadze < ulepszenie.getCenaUlepszenia()){
           kup.setEnabled(false);
       }else kup.setEnabled(true);


        tlo.add(kup);


        add(tlo);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setPreferredSize(new Dimension(400,400));
        pack();
        setVisible(true);


    }
}
