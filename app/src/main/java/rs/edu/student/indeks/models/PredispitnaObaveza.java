package rs.edu.student.indeks.models;

import java.util.Date;

/**
 * Created by enver on 3.3.17..
 */

public class PredispitnaObaveza {
    private String naziv;
    private double poena;
    private Date datumPolaganja;
    private String potpis;

    public PredispitnaObaveza() {
    }

    public PredispitnaObaveza(String naziv, int poena, Date datumPolaganja, String potpis) {
        this.naziv = naziv;
        this.poena = poena;
        this.datumPolaganja = datumPolaganja;
        this.potpis = potpis;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getPoena() {
        return poena;
    }

    public void setPoena(double poena) {
        this.poena = poena;
    }

    public Date getDatumPolaganja() {
        return datumPolaganja;
    }

    public void setDatumPolaganja(Date datumPolaganja) {
        this.datumPolaganja = datumPolaganja;
    }

    public String getPotpis() {
        return potpis;
    }

    public void setPotpis(String potpis) {
        this.potpis = potpis;
    }
}
