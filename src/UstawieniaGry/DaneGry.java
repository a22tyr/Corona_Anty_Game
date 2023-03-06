package UstawieniaGry;

import Wirus.Wirus;

import java.time.LocalDate;

public class DaneGry {
    public static PoziomTrudności wybranyPoziom = null;
    public static boolean czyGraTrwa = false;
    public static int pieniadze = StałeGry.getPoczątkowePieniądze();
    public static boolean czyGraZakonczona = false;
    public static int punkty =1;
    public static LocalDate dzisiejszaData =LocalDate.now();

    public static PoziomTrudności getWybranyPoziom() {
        return wybranyPoziom;
    }

    public static void setWybranyPoziom(PoziomTrudności wybranyPoziom) {
        DaneGry.wybranyPoziom = wybranyPoziom;
    }



    public static boolean isCzyGraZakonczona() {
        return czyGraZakonczona;
    }

    public static void setCzyGraZakonczona(boolean czyGraZakonczona) {
        DaneGry.czyGraZakonczona = czyGraZakonczona;
    }


}
