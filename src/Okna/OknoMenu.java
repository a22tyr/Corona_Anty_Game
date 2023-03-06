package Okna;

import UstawieniaGry.BudowaGry;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class OknoMenu extends JFrame  {

    ImageIcon imageIcon = new ImageIcon("ProjektDrugi/src/Obrazy/korona.jpg");
    JPodPanel tlo = new JPodPanel(imageIcon);




    public OknoMenu() {

        tlo.setLayout(new BoxLayout(tlo,BoxLayout.Y_AXIS));
        tlo.setBorder(new EmptyBorder(50,150,50,50));

        JLabel tytul = new JLabel("Koronawirus AntiPlague");
        tytul.setAlignmentX(Component.CENTER_ALIGNMENT);
        tytul.setFont(new Font("a", Font.HANGING_BASELINE, 70));
        tytul.setForeground(Color.GREEN);
        tlo.add(tytul);

        JPodPanel jPanel = new JPodPanel(imageIcon);

        jPanel.setBackground(Color.cyan);


        JButton nowaGra = new JButton("Nowa Gra");
        nowaGra.setPreferredSize(new Dimension(600,100));
        nowaGra.setBackground(Color.BLUE);
        nowaGra.setForeground(Color.black);
        nowaGra.setFont(new Font("b",Font.HANGING_BASELINE,40));
        JButton wyniki = new JButton("Wyniki");
        wyniki.setPreferredSize(new Dimension(600,100));
        wyniki.setBackground(Color.BLUE);
        wyniki.setForeground(Color.black);
        wyniki.setFont(new Font("b",Font.HANGING_BASELINE,40));
        JButton wyjdz = new JButton("Wyjdz");
        wyjdz.setPreferredSize(new Dimension(600,100));
        wyjdz.setBackground(Color.BLUE);
        wyjdz.setForeground(Color.black);
        wyjdz.setFont(new Font("b",Font.HANGING_BASELINE,40));






        wyjdz.addActionListener((b)-> {
            BudowaGry.zapiszWynik();
            System.exit(0);
        });
        wyniki.addActionListener(((b)->{
           BudowaGry.wczytajWynik();
            new OknoWyniki();
            dispose();
        }));
        nowaGra.addActionListener((ng)->{
            new OknoPoziomów();
            dispose();
        });
        jPanel.add(nowaGra);
        jPanel.add(wyniki);
        jPanel.add(wyjdz);




        tlo.add(jPanel);
        add(tlo);
        setPreferredSize(new Dimension(1200,645));
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }
}
