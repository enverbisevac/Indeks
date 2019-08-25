package rs.edu.student.indeks.models;

import java.util.Date;

/**
 * Created by enver on 4.3.17..
 */

public class Praksa {
    private int skolskaGodina;
    private String ustanova;
    private String vremenskiPeriod;
    private int brojSati;
    private double brojPoena;
    private String podrucjePrakse;
    private Date datumOvere;

    public Praksa() {
    }

    public int getSkolskaGodina() {
        return skolskaGodina;
    }

    public void setSkolskaGodina(int skolskaGodina) {
        this.skolskaGodina = skolskaGodina;
    }

    public String getUstanova() {
        return ustanova;
    }

    public void setUstanova(String ustanova) {
        this.ustanova = ustanova;
    }

    public String getVremenskiPeriod() {
        return vremenskiPeriod;
    }

    public void setVremenskiPeriod(String vremenskiPeriod) {
        this.vremenskiPeriod = vremenskiPeriod;
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

    public String getPodrucjePrakse() {
        return podrucjePrakse;
    }

    public void setPodrucjePrakse(String podrucjePrakse) {
        this.podrucjePrakse = podrucjePrakse;
    }

    public Date getDatumOvere() {
        return datumOvere;
    }

    public void setDatumOvere(Date datumOvere) {
        this.datumOvere = datumOvere;
    }
}
