package rs.edu.student.indeks.models;

import java.util.Date;

/**
 * Created by enver on 5.3.17..
 */

public class DobrovoljniRad {
    private String naziv;
    private String vrsta;
    private String vrednovanje;
    private Date datumOvere;

    public DobrovoljniRad() {
    }

    public DobrovoljniRad(String naziv, String vrsta, String vrednovanje, Date datumOvere) {
        this.naziv = naziv;
        this.vrsta = vrsta;
        this.vrednovanje = vrednovanje;
        this.datumOvere = datumOvere;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    public String getVrednovanje() {
        return vrednovanje;
    }

    public void setVrednovanje(String vrednovanje) {
        this.vrednovanje = vrednovanje;
    }

    public Date getDatumOvere() {
        return datumOvere;
    }

    public void setDatumOvere(Date datumOvere) {
        this.datumOvere = datumOvere;
    }
}
