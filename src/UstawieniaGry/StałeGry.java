package UstawieniaGry;

import DrogiTransportu.SrodkiTransportu;
import DrogiTransportu.Transport;

import java.util.HashMap;
import java.util.Map;

public class StałeGry {
    private static final int punktyZaWyleczenie = 1;
    private static final int początkowePieniądze = 500;
    private static final int pieniadzeZaZatrzymanieChoroby = 400;
   /* public static HashMap<PoziomTrudności, Double > początkowyWzrostZachorowań = new HashMap<>();
    public static HashMap<SrodkiTransportu, Double> procentOdTransportu = new HashMap<>();*/


  /*  public static void setPoczątkowyWzrostZachorowań(){
        początkowyWzrostZachorowań.clear();
        początkowyWzrostZachorowań.put(PoziomTrudności.LATWY,0.01);
        początkowyWzrostZachorowań.put(PoziomTrudności.LATWY,0.05);

    }

    public static void setProcentOdTransportu() {
        procentOdTransportu.clear();
       procentOdTransportu.put(SrodkiTransportu.POCIAG, 0.03);
        procentOdTransportu.put(SrodkiTransportu.SAMOLOT, 0.5);
        procentOdTransportu.put(SrodkiTransportu.STATEK, 0.01);
        }

*/


    public static int getPunktyZaWyleczenie() {
        return punktyZaWyleczenie;
    }

    public static int getPoczątkowePieniądze() {
        return początkowePieniądze;
    }

    public static int getPieniadzeZaZatrzymanieChoroby() {
        return pieniadzeZaZatrzymanieChoroby;
    }



}
