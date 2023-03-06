package UstawieniaGry;

import Countres.Panstwo;
import DrogiTransportu.SrodkiTransportu;
import DrogiTransportu.Transport;
import Ulepszenia.Ulepszenie;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class BudowaGry {

    public static ArrayList<Punkty> wszystkeiWyniki = new ArrayList<>();


    public static HashMap <PoziomTrudności, Double > początkowyWzrostZachorowań = new HashMap<>();
    public static HashMap <SrodkiTransportu, Double> procentOdTransportu = new HashMap<>();

    public static void zapiszWynik() {
        try {
            ObjectOutputStream objectOutputStreamPerson = new ObjectOutputStream(new FileOutputStream("ProjektDrugi/src/TabelaWyników.txt"));
            for (Punkty p : wszystkeiWyniki) {
                objectOutputStreamPerson.writeObject(p);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }


            public static void wczytajWynik(){


                try{
                    ObjectInputStream objectInputStreamPunkt = new ObjectInputStream(new FileInputStream("ProjektDrugi/src/TabelaWyników.txt"));

                while(objectInputStreamPunkt.available() > 0) {

                    wszystkeiWyniki.add((Punkty) objectInputStreamPunkt.readObject());
                }
                }catch (Exception e){
                    System.out.println(e);
                }
            }




    public static void budowanieGry() {
        procentOdTransportu.clear();
        początkowyWzrostZachorowań.clear();
        Panstwo.listaPanstwa.clear();
        Ulepszenie.wszystkieUlepszenia.clear();
        procentOdTransportu.put(SrodkiTransportu.POCIAG, 0.003);
        procentOdTransportu.put(SrodkiTransportu.SAMOLOT, 0.005);
        procentOdTransportu.put(SrodkiTransportu.STATEK, 0.001);



        początkowyWzrostZachorowań.put(PoziomTrudności.LATWY,0.012);
        początkowyWzrostZachorowań.put(PoziomTrudności.TRUDNY,0.019);


        Ulepszenie ulepszenie1 = new Ulepszenie("Zamknięcie lasów",40,0.002);
        Ulepszenie ulepszenie2 = new Ulepszenie("Maseczki",60,0.004);
        Ulepszenie ulepszenie3 = new Ulepszenie("Zamknięcie kin i teatrów",80,0.007);
        Ulepszenie ulepszenie4 = new Ulepszenie("Zakaz koncertów i imprez masowych",100,0.008);
        Ulepszenie ulepszenie5 = new Ulepszenie("Zamknięcie galerii handlowych",130,0.009);
        Ulepszenie ulepszenie6 = new Ulepszenie("Dezynfekcja kluczowych miejsc w miastach",150,0.01);
        Ulepszenie ulepszenie7 = new Ulepszenie("Zakaz przemieszczania sie pomiędzy miastami",180,0.012);
        Ulepszenie ulepszenie8 = new Ulepszenie("Zamknięcie szkół i kościołó",250,0.014);
        Ulepszenie ulepszenie9 = new Ulepszenie("Wprowadzenie stanu wyjątkowego",350, 0.016);





        //Polska
        Panstwo polska = new Panstwo("Polska", 48000000l);
        polska.addTransport(new Transport(0.2, SrodkiTransportu.POCIAG));
        polska.addTransport(new Transport(0.4, SrodkiTransportu.SAMOLOT));


        //NIemcy
        Panstwo niemcy = new Panstwo("Niemcy", 83000000l);
        niemcy.addTransport(new Transport(0.2, SrodkiTransportu.POCIAG));
        niemcy.addTransport(new Transport(0.4, SrodkiTransportu.SAMOLOT));
        niemcy.addTransport(new Transport(0.6, SrodkiTransportu.STATEK));


        //Wlochy
        Panstwo wlochy = new Panstwo("Wlochy", 59000000l);
        wlochy.addTransport(new Transport(0.4, SrodkiTransportu.SAMOLOT));
        wlochy.addTransport(new Transport(0.6, SrodkiTransportu.STATEK));


        //Francja
        Panstwo francja = new Panstwo("Francja", 67000000l);
        francja.addTransport(new Transport(0.4, SrodkiTransportu.SAMOLOT));
        francja.addTransport(new Transport(0.6, SrodkiTransportu.STATEK));
        francja.addTransport(new Transport(0.2, SrodkiTransportu.POCIAG));

        //Szwecja
        Panstwo szwecja = new Panstwo("Szwecja", 10000000l);
        szwecja.addTransport(new Transport(0.4, SrodkiTransportu.SAMOLOT));
        szwecja.addTransport(new Transport(0.6, SrodkiTransportu.STATEK));
        szwecja.addTransport(new Transport(0.2, SrodkiTransportu.POCIAG));

        //Austria
        Panstwo austria = new Panstwo("Austria", 9000000l);
        austria.addTransport(new Transport(0.4, SrodkiTransportu.SAMOLOT));
        austria.addTransport(new Transport(0.2, SrodkiTransportu.POCIAG));

        //Hiszpania
        Panstwo hiszpania = new Panstwo("Hiszpania", 47000000);
        hiszpania.addTransport(new Transport(0.4, SrodkiTransportu.SAMOLOT));
        hiszpania.addTransport(new Transport(0.2, SrodkiTransportu.POCIAG));
        szwecja.addTransport(new Transport(0.6, SrodkiTransportu.STATEK));

        //Finlandia
        Panstwo finlandia = new Panstwo("Finlandia", 55000000l);
        finlandia.addTransport(new Transport(0.4, SrodkiTransportu.SAMOLOT));
        finlandia.addTransport(new Transport(0.2, SrodkiTransportu.POCIAG));
        finlandia.addTransport(new Transport(0.6, SrodkiTransportu.STATEK));

        //Anglia
        Panstwo anglia = new Panstwo("Anglia", 56000000l);
        anglia.addTransport(new Transport(0.4, SrodkiTransportu.SAMOLOT));
        anglia.addTransport(new Transport(0.6, SrodkiTransportu.STATEK));

        //Portugalia
        Panstwo portugalia = new Panstwo("Portugalia", 56000000l);
        portugalia.addTransport(new Transport(0.4, SrodkiTransportu.SAMOLOT));
        portugalia.addTransport(new Transport(0.6, SrodkiTransportu.STATEK));
        portugalia.addTransport(new Transport(0.2, SrodkiTransportu.POCIAG));
    }

}





