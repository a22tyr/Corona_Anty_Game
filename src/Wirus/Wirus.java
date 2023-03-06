package Wirus;

import Countres.Panstwo;
import Okna.OknoWpisaniaWyniku;
import UstawieniaGry.DaneGry;
import UstawieniaGry.PoziomTrudności;
import UstawieniaGry.StałeGry;

import java.time.LocalDate;

public class Wirus extends Thread {
   public static boolean czyOtwartyWatek = true;

    int liczbaPrzgranychPanstw ;
    int liczbaUratowanychPaństw ;
    //double wzrostCodzienny;

    public static LocalDate firstDate = LocalDate.now();
   public static LocalDate data = LocalDate.now();
    @Override
    public void run() {

        while(czyOtwartyWatek){
            liczbaUratowanychPaństw = 0;
            liczbaPrzgranychPanstw  = 0;


            for(Panstwo p : Panstwo.listaPanstwa){
                long wyzdrowieńce=0;

                long chorzyWczoraj = p.getIlośćZahcorowań();

                p.setIlośćZahcorowań((long) (p.getIlośćMieszkańców() * p.wzrostZachorowań() + p.getIlośćZahcorowań()));

                if(p.isCzyWszycyChorzy()) {
                    liczbaPrzgranychPanstw++;
                    continue;
                }
                if (p.isCzyUratowany()) {
                    liczbaUratowanychPaństw++;
                    continue;
                }

               if(p.getIlośćZahcorowań() <= 0){
                   p.setCzyUratowany(true);

                   DaneGry.pieniadze = DaneGry.pieniadze + StałeGry.getPieniadzeZaZatrzymanieChoroby();
                   p.setIlośćZahcorowań(0);
                   continue;

               }
               if(p.getIlośćZahcorowań() >= p.getIlośćMieszkańców()){
                   p.setIlośćZahcorowań(p.getIlośćMieszkańców());
                   p.setCzyWszycyChorzy(true);

                   continue;
               }
                if(p.wzrostZachorowań()<0){
                   wyzdrowieńce = chorzyWczoraj - p.getIlośćZahcorowań();
                   p.setIlośćWyzdrowień(p.getIlośćWyzdrowień()+wyzdrowieńce);
                   DaneGry.pieniadze +=(wyzdrowieńce) / 100000*StałeGry.getPunktyZaWyleczenie();
                   if(DaneGry.getWybranyPoziom() == PoziomTrudności.TRUDNY) {
                       DaneGry.punkty += (wyzdrowieńce) / 10100 * StałeGry.getPunktyZaWyleczenie();
                   }else{
                       DaneGry.punkty += (wyzdrowieńce) / 9000 * StałeGry.getPunktyZaWyleczenie();
                   }

               }


            }
            if(liczbaUratowanychPaństw >= 5){
                DaneGry.czyGraZakonczona = true;
                OknoWpisaniaWyniku okno = new OknoWpisaniaWyniku("WYGRANA");
                czyOtwartyWatek= false;//

            } if(liczbaPrzgranychPanstw >=5){
                DaneGry.czyGraZakonczona =true;
                OknoWpisaniaWyniku okno = new OknoWpisaniaWyniku("PRZEGRANA");
                czyOtwartyWatek = false;//
            }
            if(DaneGry.czyGraTrwa){
                return;
            }

            try {
                DaneGry.dzisiejszaData = DaneGry.dzisiejszaData.plusDays(1);

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
        czyOtwartyWatek=true;

    }
}
