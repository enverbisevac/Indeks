package rs.edu.student.indeks.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by enver on 27.2.17..
 */

public class Predmet {
    private String sifra;
    private String naziv;
    private Status status;
    private int espb;
    private int predavanja;
    private int vezbe;
    private int drugo;
    private boolean potpis;

    private double ispit;
    private double ispitPoena;
    private Date ispitDatum;
    private Ocena ocena;
    private String nastavnik;

    private List<PredispitnaObaveza> predispitneObaveze = new ArrayList<>();

    public enum Ocena {
        PET(5, "PET"), SEST(6, "SEST"), SEDAM(7, "SEDAM"), OSAM(8, "OSAM"), DEVET(9, "DEVET"), DESET(10, "DESET"),
        OBAVIO(null, "OBAVIO");

        private Integer ocena;
        private String slovima;
        Ocena(Integer ocena, String slovima) {
            this.ocena = ocena;
            this.slovima = slovima;
        }

        public Integer getOcena() {
            return ocena;
        }

        public String getSlovima() {
            return slovima;
        }
    }

    public enum Status {
        OBAVEZAN("O", "Obavezan"), IZBORNI("I", "Izborni");

        private String oznaka;
        private String opis;

        Status(String oznaka, String opis) {
            this.oznaka = oznaka;
            this.opis = opis;
        }

        public String getOznaka() {
            return oznaka;
        }

        public String getOpis() {
            return opis;
        }
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getEspb() {
        return espb;
    }

    public void setEspb(int espb) {
        this.espb = espb;
    }

    public int getPredavanja() {
        return predavanja;
    }

    public void setPredavanja(int predavanja) {
        this.predavanja = predavanja;
    }

    public int getVezbe() {
        return vezbe;
    }

    public void setVezbe(int vezbe) {
        this.vezbe = vezbe;
    }

    public int getDrugo() {
        return drugo;
    }

    public void setDrugo(int drugo) {
        this.drugo = drugo;
    }

    public boolean isPotpis() {
        return potpis;
    }

    public void setPotpis(boolean potpis) {
        this.potpis = potpis;
    }

    public double getIspit() {
        return ispit;
    }

    public void setIspit(int ispit) {
        this.ispit = ispit;
    }

    public Ocena getOcena() {
        return ocena;
    }

    public void setOcena(Ocena ocena) {
        this.ocena = ocena;
    }

    public String getNastavnik() {
        return nastavnik;
    }

    public void setNastavnik(String nastavnik) {
        this.nastavnik = nastavnik;
    }

    public List<PredispitnaObaveza> getPredispitneObaveze() {
        return predispitneObaveze;
    }

    public void setPredispitneObaveze(List<PredispitnaObaveza> predispitneObaveze) {
        this.predispitneObaveze = predispitneObaveze;
    }

    public void setIspit(double ispit) {
        this.ispit = ispit;
    }

    public double getIspitPoena() {
        return ispitPoena;
    }

    public void setIspitPoena(double ispitPoena) {
        this.ispitPoena = ispitPoena;
    }

    public Date getIspitDatum() {
        return ispitDatum;
    }

    public void setIspitDatum(Date ispitDatum) {
        this.ispitDatum = ispitDatum;
    }
}
