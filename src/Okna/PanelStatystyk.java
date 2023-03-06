package Okna;

import Countres.Panstwo;
import UstawieniaGry.DaneGry;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class PanelStatystyk extends JPanel  {
    /*Map<Panstwo, JProgressBar> panswoweStatystyki = new HashMap<>();

    boolean odswierz = true;


    public PanelStatystyk() {


        JPanel panstwa = new JPanel();
        panstwa.setLayout(new GridLayout(0, 2, 30, 30));
        for (Panstwo p : Panstwo.listaPanstwa) {
            JLabel panstwo = new JLabel(p.getNazwaPanstwa());
            JProgressBar progressBar = new JProgressBar(0, 100);

            panstwa.add(progressBar);
            panstwa.add(panstwo);
            panswoweStatystyki.put(p, progressBar);
        }
        add(panstwa);
        Thread odswierz = new Thread(this);
        odswierz.start();

    }





    @Override
    public void run() {
        while (odswierz) {
            for(Panstwo p : Panstwo.listaPanstwa){
                JProgressBar bar = panswoweStatystyki.get(p);
                bar.setValue( (int)p.getProcentZachoworań()*100);

            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
*/
    }
