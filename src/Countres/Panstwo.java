package Countres;

import DrogiTransportu.Transport;
import DrogiTransportu.SrodkiTransportu;
import Ulepszenia.Ulepszenie;
import UstawieniaGry.BudowaGry;
import UstawieniaGry.DaneGry;
import UstawieniaGry.PoziomTrudności;
import UstawieniaGry.StałeGry;

import java.awt.*;
import java.util.ArrayList;

public class Panstwo {
    private String nazwaPanstwa;
    private long ilośćZahcorowań;
    private long ilośćMieszkańców;
    private long ilośćWyzdrowień=0;
    private long procentZachoworań;
    private double procentRand= Math.random() * 0.018;


    boolean czyUratowany = false;
    boolean czyWszycyChorzy = false;

       public static ArrayList<Panstwo> listaPanstwa = new ArrayList<>();

    private ArrayList<Ulepszenie> odpaloneUlepszenia = new ArrayList<>();

    public ArrayList<Ulepszenie> getOdpaloneUlepszenia() {
        return odpaloneUlepszenia;
    }


    public ArrayList<Transport> getWszystkieTransporty() {
        return wszystkieTransporty;
    }

    private ArrayList<Transport> wszystkieTransporty = new ArrayList<>();

    public Panstwo(String nazwa ,long ilośćMieszkańców) {
        this.nazwaPanstwa = nazwa;
        this.ilośćMieszkańców = ilośćMieszkańców;

        listaPanstwa.add(this);
    }
    public void addTransport(Transport transport){
        this.wszystkieTransporty.add(transport);
    }

    public long getIlośćZahcorowań() {
        return ilośćZahcorowań;
    }

    public void setIlośćZahcorowań(long ilośćZahcorowań) {
        this.ilośćZahcorowań = ilośćZahcorowań;
    }

    public long getIlośćMieszkańców() {
        return ilośćMieszkańców;
    }

    public void setIlośćMieszkańców(long ilośćMieszkańców) {
        this.ilośćMieszkańców = ilośćMieszkańców;
    }

    public long getIlośćWyzdrowień() {
        return ilośćWyzdrowień;
    }

    public void setIlośćWyzdrowień(long ilośćWyzdrowień) {
        this.ilośćWyzdrowień = ilośćWyzdrowień;
    }

    public String getNazwaPanstwa() {
        return nazwaPanstwa;
    }

    public void setNazwaPanstwa(String nazwaPanstwa) {
        nazwaPanstwa = nazwaPanstwa;
    }

    public boolean isCzyUratowany() {
        return czyUratowany;
    }

    public void setCzyUratowany(boolean czyUratowany) {
        this.czyUratowany = czyUratowany;
    }

    public double wzrostZachorowań( ){
        double procent = BudowaGry.początkowyWzrostZachorowań.get(DaneGry.wybranyPoziom) - procentRand;

        for (Transport transport : getWszystkieTransporty())
        {
            if(!transport.czyZamknięte())
            {
                procent += BudowaGry.procentOdTransportu.get(transport.getRodzajTransportu());
            }
        }

        for(Ulepszenie ulepszenie : getOdpaloneUlepszenia())
        {
            procent -= ulepszenie.getZmniejszenieZachoworań();
        }
        if(DaneGry.getWybranyPoziom() == PoziomTrudności.TRUDNY){
            return procent + 0.02;
        }else{
            return procent+0.006;
        }
    }

    public boolean isCzyWszycyChorzy() {
        return czyWszycyChorzy;
    }

    public void setCzyWszycyChorzy(boolean czyWszycyChorzy) {
        this.czyWszycyChorzy = czyWszycyChorzy;
    }

    public double getProcentZachoworań() {
        if(czyWszycyChorzy = false){
            return 100;
        }else if(czyUratowany = false){
            return 0;
        }else return (double) ilośćZahcorowań / (double) ilośćMieszkańców;
    }


}
