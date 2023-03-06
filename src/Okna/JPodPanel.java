package Okna;

import javax.swing.*;
import java.awt.*;

public class JPodPanel extends JPanel {
    private Image imga;

    JPodPanel(ImageIcon img){


        imga=img.getImage();
        repaint();

    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Wyrysowujesz zdjecie tak zeby zajelo caly obszar
        g.drawImage(imga, 0, 0, getWidth(), getHeight(), this);
    }
}
