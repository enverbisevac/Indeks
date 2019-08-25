package rs.edu.student.indeks.models;

import java.util.Date;
import java.util.List;

/**
 * Created by enver on 4.3.17..
 */

public class ZavrsniRad {
    private String naslov;
    private int espb;
    private Date datum;
    private int ocena;
    private List<String> komisija;
    private String fajl;

    public ZavrsniRad() {
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public int getEspb() {
        return espb;
    }

    public void setEspb(int espb) {
        this.espb = espb;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public List<String> getKomisija() {
        return komisija;
    }

    public void setKomisija(List<String> komisija) {
        this.komisija = komisija;
    }

    public String getFajl() {
        return fajl;
    }

    public void setFajl(String fajl) {
        this.fajl = fajl;
    }
}
