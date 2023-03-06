package UstawieniaGry;

import java.io.Serializable;

public class Punkty implements Serializable {
    private String nick;
    private int przeżyteDni;
    private PoziomTrudności poziomTrudności;
    private int zdobytePunkty;


    public Punkty(String nick, int przeżyteDni, PoziomTrudności poziomTrudności, int zdobytePunkty) {
        this.nick = nick;
        this.przeżyteDni = przeżyteDni;
        this.poziomTrudności = poziomTrudności;
        this.zdobytePunkty = zdobytePunkty;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getPrzeżyteDni() {
        return przeżyteDni;
    }

    public void setPrzeżyteDni(int przeżyteDni) {
        this.przeżyteDni = przeżyteDni;
    }

    public PoziomTrudności getPoziomTrudności() {
        return poziomTrudności;
    }

    public void setPoziomTrudności(PoziomTrudności poziomTrudności) {
        this.poziomTrudności = poziomTrudności;
    }

    public int getZdobytePunkty() {
        return zdobytePunkty;
    }

    public void setZdobytePunkty(int zdobytePunkty) {
        this.zdobytePunkty = zdobytePunkty;
    }

    @Override
    public String toString() {
        return "Punkty{" +
                "nick='" + nick + '\'' +
                '}';
    }
}
