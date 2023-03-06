package DrogiTransportu;

public class  Transport{

    private boolean zamknięte = false;

    public boolean isZamknięte() {
        return zamknięte;
    }

    private double zarażeniDoPrzewożenia;
    private double zmniejszenieZachorowańPoZamknięciu;
    private SrodkiTransportu rodzajTransportu;

    public Transport(double zarażeniDoPrzewożenia, SrodkiTransportu rodzajTransportu) {
        this.zarażeniDoPrzewożenia = zarażeniDoPrzewożenia;
        this.rodzajTransportu = rodzajTransportu;
        setZmniejszenieZachorowańPoZamknięciu(rodzajTransportu);
    }

    public boolean czyZamknięte() {
        return zamknięte;
    }

    public void setCzyZamknięte(boolean czyZamknięte) {
        this.zamknięte = czyZamknięte;
    }

    private void setZmniejszenieZachorowańPoZamknięciu(SrodkiTransportu transport) {
        if (transport == SrodkiTransportu.POCIAG) {
            this.zmniejszenieZachorowańPoZamknięciu = 0.05;
        } else if (transport == SrodkiTransportu.STATEK) {
            this.zmniejszenieZachorowańPoZamknięciu = 0.08;
        } else if (transport == SrodkiTransportu.SAMOLOT) {
            this.zmniejszenieZachorowańPoZamknięciu = 0.3;
        } else System.out.println("Brak takiego  pojazdu");

    }

    public double getZarażeniDoPrzewożenia() {
        return zarażeniDoPrzewożenia;
    }

    public double getZmniejszenieZachorowańPoZamknięciu() {
        return zmniejszenieZachorowańPoZamknięciu;
    }

    public SrodkiTransportu getRodzajTransportu() {
        return rodzajTransportu;
    }
}
