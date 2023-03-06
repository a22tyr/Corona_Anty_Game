package Okna;

import UstawieniaGry.BudowaGry;
import UstawieniaGry.DaneGry;
import UstawieniaGry.Punkty;
import Wirus.Wirus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class OknoWpisaniaWyniku extends JFrame {




    public OknoWpisaniaWyniku(String str)  {

        JPanel jpanel = new JPanel();
        jpanel.setLayout(new BoxLayout(jpanel,BoxLayout.Y_AXIS));

        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(400,100));
        textField.setAlignmentX(Component.CENTER_ALIGNMENT);


        JLabel jLabel = new JLabel(str);
        jLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        jLabel.setFont(new Font("",Font.ROMAN_BASELINE,35));



        JLabel tekst = new JLabel("Wpisz nick");
        tekst.setAlignmentX(Component.CENTER_ALIGNMENT);


        JButton jButtonZatwierdz = new JButton("Zatwierdz");
        jButtonZatwierdz.setAlignmentX(Component.CENTER_ALIGNMENT);

        jpanel.add(Box.createVerticalStrut(40));
        jpanel.add(jLabel);
        jpanel.add(Box.createVerticalStrut(40));
        jpanel.add(tekst);
        jpanel.add(Box.createVerticalStrut(20));
        jpanel.add(textField);
        jpanel.add(Box.createVerticalStrut(20));
        jpanel.add(jButtonZatwierdz);
        jpanel.add(Box.createVerticalStrut(50));

        jButtonZatwierdz.addActionListener((action)-> {
            Punkty punkt = new Punkty(textField.getText(),(int) ChronoUnit.DAYS.between( Wirus.data,DaneGry.dzisiejszaData),DaneGry.wybranyPoziom,DaneGry.punkty);

            BudowaGry.wszystkeiWyniki.add(punkt);
            BudowaGry.zapiszWynik();
            dispose();
            new OknoMenu();
        });


        KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK, true);
        this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke, "Q");
        this.getRootPane().getActionMap().put("Q", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                DaneGry.czyGraTrwa = true;
                DaneGry.czyGraZakonczona = true;
                dispose();
                new OknoMenu();
            }
        });

        add(jpanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setPreferredSize(new Dimension(400,300));
        pack();
        setResizable(false);
        setVisible(true);
    }
}
