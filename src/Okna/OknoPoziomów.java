package Okna;

import UstawieniaGry.BudowaGry;
import UstawieniaGry.DaneGry;
import UstawieniaGry.PoziomTrudności;
import UstawieniaGry.StałeGry;
import Wirus.Wirus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.LocalDate;

public class OknoPoziomów extends JFrame {

    JPodPanel tlo = new JPodPanel(new ImageIcon("ProjektDrugi/src/Obrazy/korona.jpg"));

    public OknoPoziomów() throws HeadlessException {
        Wirus wi = new Wirus();
        tlo.setLayout(new BoxLayout(tlo,BoxLayout.Y_AXIS));
        JLabel napis = new JLabel("Wybór poziomu");
        //napis.setSize(400,200);
        napis.setForeground(Color.GREEN);
        napis.setAlignmentX(Component.CENTER_ALIGNMENT);




        JButton latwy = new JButton("TRUDNY");
        latwy.setAlignmentX(Component.CENTER_ALIGNMENT);
        latwy.addActionListener((p)->{
            DaneGry.pieniadze = StałeGry.getPoczątkowePieniądze()+500;
            DaneGry.czyGraZakonczona=false;
            DaneGry.wybranyPoziom = PoziomTrudności.TRUDNY;
            DaneGry.dzisiejszaData = LocalDate.now();


            BudowaGry.budowanieGry();
            wi.start();

            OknoEuropy oknoEuropy = new OknoEuropy();


            dispose();
        });

        JButton trudny = new JButton("LATWY");
        trudny.setAlignmentX(Component.CENTER_ALIGNMENT);

        trudny.addActionListener((p)->{
            DaneGry.pieniadze = (StałeGry.getPoczątkowePieniądze());
            DaneGry.czyGraZakonczona=false;
            DaneGry.wybranyPoziom = PoziomTrudności.LATWY;
            DaneGry.dzisiejszaData = LocalDate.now();

            BudowaGry.budowanieGry();

            wi.start();

            OknoEuropy oknoEuropy = new OknoEuropy();
            dispose();


        });
        KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK, true);
        this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke, "Q");
        this.getRootPane().getActionMap().put("Q", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {

                DaneGry.czyGraZakonczona = true;
                Wirus.czyOtwartyWatek = false;
                dispose();
                new OknoMenu();
            }
        });


        tlo.add(Box.createVerticalStrut(40));
        tlo.add(napis);
        tlo.add(Box.createVerticalStrut(40));
        tlo.add(trudny);
        tlo.add(Box.createVerticalStrut(40));
        tlo.add(latwy);
        add(tlo);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setPreferredSize(new Dimension(500,400));
        pack();
        setResizable(false);
        setVisible(true);
    }


}
