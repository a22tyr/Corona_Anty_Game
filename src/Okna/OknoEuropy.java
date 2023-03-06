package Okna;

import Countres.Panstwo;
import UstawieniaGry.BudowaGry;
import UstawieniaGry.DaneGry;
import Wirus.Wirus;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class OknoEuropy extends JFrame {
    ImageIcon imageIcon = new ImageIcon("ProjektDrugi/src/Obrazy/europa.jpg");
    PanelMapy panelMapy = new PanelMapy(imageIcon,this);




    public OknoEuropy() throws HeadlessException {

        KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK, true);
        this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke, "Q");
        this.getRootPane().getActionMap().put("Q", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                //DaneGry.czyGraTrwa = true;
                DaneGry.czyGraZakonczona = true;
                Wirus.czyOtwartyWatek = false;
                dispose();
                new OknoMenu();
            }
        });


            JTabbedPane jTabbedPane = new JTabbedPane();
            jTabbedPane.add("Mapka Europy", panelMapy);








       add(jTabbedPane);
        setPreferredSize(new Dimension(1400,1000));
        pack();
        setLocationRelativeTo(null);

        setVisible(true);
    }

}
