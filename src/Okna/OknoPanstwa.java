package Okna;

import Countres.Panstwo;
import DrogiTransportu.Transport;
import Ulepszenia.Ulepszenie;
import UstawieniaGry.DaneGry;
import Wirus.Wirus;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class OknoPanstwa extends JFrame implements Runnable{


    ImageIcon imageIcon = new ImageIcon("ProjektDrugi/src/Obrazy/korona.jpg");


        private Map<Transport, JLabel> transportsLabels = new HashMap<>();
        private Map<Transport, JButton> transportsButtons = new HashMap<>();
        private Map<Ulepszenie, JButton> improvementButton = new HashMap<>();
        private Panstwo panstwo;
        private JPodPanel jPodPanel;
        private JPanel pojazdy;
        private JPanel statystyki;
        private JPodPanel ulepszenia;

    private final JLabel dzisiejszaData;
    private final JLabel dniOdStartu;
    private final JLabel liczbaZakazonych;
    private final JLabel procentZakazonych;
    private final JLabel pieniadze;
    private final JLabel liczbaWyzdrowialych;
    private final JLabel dziennyWzrost;

         boolean czyOdswierzac = true;

        public OknoPanstwa(Panstwo panstwo) {
            this.jPodPanel = new JPodPanel(imageIcon);
            this.panstwo = panstwo;
            setTitle("Zarzadzanie " + panstwo.getNazwaPanstwa());
            jPodPanel.setLayout(new GridBagLayout());

            JLabel pansto = new JLabel(panstwo.getNazwaPanstwa());
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



            pojazdy = new JPanel();
            ulepszenia = new JPodPanel(imageIcon);


            // --- Prawo GORA----
            pojazdy.setLayout(new BoxLayout(pojazdy, BoxLayout.Y_AXIS));


            JPanel zarzanieTransportem = new JPanel();
            zarzanieTransportem.setLayout(new GridLayout(0, 3));

            for (Transport countryTransport : panstwo.getWszystkieTransporty()) {
                zarzanieTransportem.add(new JLabel(countryTransport.getRodzajTransportu().toString()));

                JLabel status = new JLabel();
                JButton zakmnij = new JButton("zamknij");

                transportsLabels.put(countryTransport, status);
                transportsButtons.put(countryTransport, zakmnij);

                if(countryTransport.isZamknięte()) {
                    status.setText("zamkniete");
                    status.setForeground(Color.RED);
                    zakmnij.setEnabled(false);
                }
                else {
                    status.setText("otwarte");
                    status.setForeground(Color.GREEN);
                }
                zarzanieTransportem.add(status);
                zarzanieTransportem.add(zakmnij);

                zakmnij.addActionListener(e -> {
                    if(panstwo.getIlośćZahcorowań() >= countryTransport.getZarażeniDoPrzewożenia()) {
                        countryTransport.setCzyZamknięte(true);
                        zakmnij.setEnabled(false);
                        status.setForeground(Color.RED);
                        zakmnij.setEnabled(false);
                    }
                });
                zakmnij.setEnabled(false);
            }

            JLabel tytułIkna = new JLabel("Srodki transportu");


            pojazdy.add((Box.createVerticalStrut(20)));
            pojazdy.add(tytułIkna);
            pojazdy.add(Box.createVerticalStrut(10));
            pojazdy.add(zarzanieTransportem);
            pojazdy.add(Box.createVerticalStrut(30));



            GridBagConstraints gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.ipadx = 20;
            gridBagConstraints.ipady= 20;
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy =0;

            jPodPanel.add(pojazdy, gridBagConstraints);


/////////////////////////////
            dzisiejszaData = new JLabel();
            dniOdStartu = new JLabel();
            pieniadze = new JLabel();
            liczbaZakazonych = new JLabel();
            procentZakazonych = new JLabel();
            liczbaWyzdrowialych = new JLabel();
            dziennyWzrost = new JLabel();
            //procentZakazonychBar = new JProgressBar(0, 100);

            JButton backToMap = new JButton("Wróć do mapy");
           // backToMap.setAlignmentX(Component.CENTER_ALIGNMENT);
            backToMap.addActionListener((e) ->{

                this.dispose();
                czyOdswierzac = false;
                new OknoEuropy();
            });
            statystyki = new JPanel();
            statystyki.setBorder(BorderFactory.createTitledBorder("Statystyki"));
            GridBagConstraints gridBagConstraints1v2 = new GridBagConstraints();
            gridBagConstraints1v2.gridx = 0;
            gridBagConstraints1v2.gridy = 0;
            gridBagConstraints1v2.ipadx = 30;

            statystyki.add(dzisiejszaData);
            statystyki.add(Box.createVerticalStrut(10));
            statystyki.add(dniOdStartu);
            statystyki.add(Box.createVerticalStrut(10));
            statystyki.add(pieniadze);
            statystyki.add(Box.createVerticalStrut(10));
            statystyki.add(liczbaZakazonych);
            statystyki.add(Box.createVerticalStrut(10));
            statystyki.add(procentZakazonych);
            statystyki.add(Box.createVerticalStrut(10));
            statystyki.add(liczbaWyzdrowialych);
            statystyki.add(Box.createVerticalStrut(10));
            statystyki.add(procentZakazonych);
            statystyki.add(Box.createVerticalStrut(10));
            statystyki.add(dziennyWzrost);
            statystyki.add(Box.createVerticalStrut(10));
            statystyki.add(backToMap);

            statystyki.setLayout(new BoxLayout(statystyki, BoxLayout.Y_AXIS));

            jPodPanel.add(statystyki, gridBagConstraints1v2);

            ////////////
            ulepszenia.setLayout(new GridLayout(3, 0, 10, 10));
            TitledBorder title;
            title = BorderFactory.createTitledBorder("Kup Ulepszenia");
            title.setTitleColor(Color.GREEN);

            ulepszenia.setBorder(title);
            GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
            gridBagConstraints1.gridx = 0;
            gridBagConstraints1.gridy = 1;
            gridBagConstraints1.gridwidth = 2;

            for (Ulepszenie improvement : Ulepszenie.getWszystkieUlepszenia()) {
                JButton button = new JButton(improvement.getNazwa());
                improvementButton.put(improvement, button);

                if(panstwo.getOdpaloneUlepszenia().contains(improvement))
                    button.setEnabled(false);

                button.addActionListener(e -> new OknoUlpeszeń(panstwo, improvement));
                ulepszenia.add(button);


            }

            jPodPanel.add(ulepszenia, gridBagConstraints1);


            add(jPodPanel);
            setPreferredSize(new Dimension(900,600));
            pack();
            setVisible(true);
            setLocationRelativeTo(null);
            Thread odswierzanie = new Thread(this);
            odswierzanie.start();


        }

        @Override
        public void run(){
            while(czyOdswierzac) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if(DaneGry.czyGraZakonczona){
                    dispose();
                    czyOdswierzac = false;
                }

                dzisiejszaData.setText("Dzień: "+DaneGry.dzisiejszaData);
                dniOdStartu.setText("Uplynelo dni: "+ ChronoUnit.DAYS.between(LocalDate.now(), DaneGry.dzisiejszaData));
                procentZakazonych.setText(String.format("Zakazonych: %.2f", panstwo.getProcentZachoworań()*100)+"%");
                dziennyWzrost.setText(String.format("Dzienny wzrost zakazonych: %.2f",panstwo.wzrostZachorowań()*100)+"%");
                pieniadze.setText("Pieniadze: "+ DaneGry.pieniadze);
                liczbaZakazonych.setText("Liczba zakazonych: " + panstwo.getIlośćZahcorowań());
                liczbaWyzdrowialych.setText("Wyzdrowałych: " + panstwo.getIlośćWyzdrowień());


                if(panstwo.isCzyWszycyChorzy() || panstwo.isCzyUratowany()){
                    for(Map.Entry<Ulepszenie, JButton> entry : improvementButton.entrySet()) {
                        entry.getValue().setEnabled(false);
                    }
                    for(Map.Entry<Transport, JButton> entry : transportsButtons.entrySet()) {
                        entry.getValue().setEnabled(false);
                    }continue;
                }

                if((panstwo.wzrostZachorowań()*100) > 0){
                    dziennyWzrost.setForeground(Color.RED);
                }else{
                    dziennyWzrost.setForeground(Color.GREEN);
                }

                for (Transport countryTransport : panstwo.getWszystkieTransporty()) {
                    JLabel status = transportsLabels.get(countryTransport);
                    JButton zamknij = transportsButtons.get(countryTransport);

                    if(countryTransport.czyZamknięte()) {
                        status.setText("zamkniete");
                        zamknij.setEnabled(false);
                        status.setForeground(Color.GREEN);

                    }
                    else {
                        status.setText("otwarte");
                        status.setForeground(Color.RED);

                        if (panstwo.getIlośćZahcorowań() >= countryTransport.getZarażeniDoPrzewożenia()) {
                            zamknij.setEnabled(true);
                        }
                    }
                }

                for (Ulepszenie ulepszenie : panstwo.getOdpaloneUlepszenia()) {
                    JButton button = improvementButton.get(ulepszenie);
                    button.setEnabled(false);
                }
            }
        }
}
