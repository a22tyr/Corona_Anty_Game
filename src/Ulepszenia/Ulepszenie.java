package Ulepszenia;

import UstawieniaGry.DaneGry;
import UstawieniaGry.PoziomTrudności;

import java.util.ArrayList;

public  class Ulepszenie {
    private String nazwa;
    private int cenaUlepszenia;
    private boolean czyAktywna;
    private double zmniejszenieZachoworań;
    public static ArrayList<Ulepszenie> wszystkieUlepszenia = new ArrayList<>();

    public Ulepszenie(String nazwa, int cenaUlepszenia, double zmniejszenieZachoworań) {
        this.nazwa = nazwa;
        setCenaUlepszenia(cenaUlepszenia);
        this.zmniejszenieZachoworań = zmniejszenieZachoworań;
        wszystkieUlepszenia.add(this);
    }


    public String getNazwa() {
        return nazwa;
    }

    public int getCenaUlepszenia() {
        return cenaUlepszenia;
    }

    public boolean czyAktywna() {
        return czyAktywna;
    }

    public double getZmniejszenieZachoworań() {
        return zmniejszenieZachoworań;
    }

    public static ArrayList<Ulepszenie> getWszystkieUlepszenia() {
        return wszystkieUlepszenia;
    }

    public void setCenaUlepszenia(int cenaUlepszenia) {
        if(DaneGry.getWybranyPoziom() == PoziomTrudności.TRUDNY){
            this.cenaUlepszenia = cenaUlepszenia * 2;
        }else {
            this.cenaUlepszenia = cenaUlepszenia;
        }
    }

    public void setZmniejszenieZachoworań(double zmniejszenieZachoworań) {
        if(DaneGry.getWybranyPoziom() == PoziomTrudności.TRUDNY){
            this.zmniejszenieZachoworań = zmniejszenieZachoworań;
        }else {
            this.zmniejszenieZachoworań = zmniejszenieZachoworań;
        }
    }
}
