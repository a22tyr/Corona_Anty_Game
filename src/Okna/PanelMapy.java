package Okna;

import Countres.Panstwo;
import UstawieniaGry.DaneGry;

import javax.swing.*;
import java.awt.*;

public class PanelMapy extends JPanel{
    boolean isOpen =true;
    private Image imga;
    JFrame jFrame;

    PanelMapy(ImageIcon img, JFrame jFrame) {
        this.jFrame = jFrame;


        imga = img.getImage();
        repaint();

        new Thread(() -> {
            while (isOpen) {
                if (DaneGry.czyGraZakonczona) {
                    isOpen = false;
                    jFrame.dispose();
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        for (Panstwo p : Panstwo.listaPanstwa) {

            JButton panstwo = new JButton(p.getNazwaPanstwa());



            panstwo.addActionListener((a) -> {
                isOpen = false;
                jFrame.dispose();
                new OknoPanstwa(p);


            });
            add(panstwo);
        }
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imga, 0, 0, getWidth(), getHeight(), this);
    }
}
