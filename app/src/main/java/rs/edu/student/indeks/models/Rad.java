package rs.edu.student.indeks.models;

import java.util.Date;

/**
 * Created by enver on 3.3.17..
 */

public class Rad {
    private int skolskaGodina;
    private String nazivPredmeta;
    private int brojSati;
    private double brojPoena;
    private String naslov;
    private Date datumOvere;
    private String fajl;

    public Rad() {
    }

    public int getSkolskaGodina() {
        return skolskaGodina;
    }

    public void setSkolskaGodina(int skolskaGodina) {
        this.skolskaGodina = skolskaGodina;
    }

    public String getNazivPredmeta() {
        return nazivPredmeta;
    }

    public void setNazivPredmeta(String nazivPredmeta) {
        this.nazivPredmeta = nazivPredmeta;
    }

    public int getBrojSati() {
        return brojSati;
    }

    public void setBrojSati(int brojSati) {
        this.brojSati = brojSati;
    }

    public double getBrojPoena() {
        return brojPoena;
    }

    public void setBrojPoena(double brojPoena) {
        this.brojPoena = brojPoena;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public Date getDatumOvere() {
        return datumOvere;
    }

    public void setDatumOvere(Date datumOvere) {
        this.datumOvere = datumOvere;
    }

    public String getFajl() {
        return fajl;
    }

    public void setFajl(String fajl) {
        this.fajl = fajl;
    }
}
