package rs.edu.student.indeks.models;

import androidx.databinding.Bindable;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by enver on 27.2.17..
 */

public class Indeks {
    @Expose
    private UUID serijskiBroj;
    @Expose
    private String jmbg;
    private String naziv1; // naziv i sediste samostalne visokoskolske ustanove
    private String naziv2; // naziv i sediste visokoskolske ustanove
    private String broj; // ustanova daje broj indeksa

    private String ime;
    private String prezime;
    private String imeRoditelja;

    private Date datumRodjenja;
    private String mestoRodjenja;
    private String opstinaRodjenja;
    private String drzavaRodjenja;
    private String drzavljanstvo;
    private VrstaStudija vrstaStudija;
    private StepenStudija stepenStudija;
    private String studijskiProgram;

    private Date datumUpisa;
    private String fotografija;
    private int espb;
    private List<Godina> godine = new ArrayList();

    private List<Rad> radovi = new ArrayList<>();
    private List<Praksa> prakse = new ArrayList<>();
    private ZavrsniRad zavrsniRad;

    private List<DobrovoljniRad> dobrovoljniRadList = new ArrayList<>();

    private String ostalo;

    public enum VrstaStudija {
        OAS ("Osnovne akademske"),
        OSS ("Osnovne strukovne"),
        MAS ("Master akademske"),
        IOMS ("Integrisane osnovne i master akademske"),
        SAS ("Specijalisticke akademske"),
        SSS ("Specijalisticke strukovne"),
        DAS ("Doktorske akademske");

        private String desc;

        VrstaStudija(String desc) {
            this.desc = desc;
        }
        public String getVrsta() {
            return desc;
        }
    }

    public enum StepenStudija {
        PRVI("I", "Prvi"), DRUGI("II", "Drugi"), TRECI("III", "Treci");

        private String stepen;
        private String opis;

        StepenStudija(String stepen, String opis) {
            this.stepen = stepen;
            this.opis = opis;
        }

        public String getStepen() {
            return this.stepen;
        }
    }

    public UUID getSerijskiBroj() {
        return serijskiBroj;
    }

    public void setSerijskiBroj(UUID serijskiBroj) {
        this.serijskiBroj = serijskiBroj;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getNaziv1() {
        return naziv1;
    }

    public void setNaziv1(String naziv1) {
        this.naziv1 = naziv1;
    }

    public String getNaziv2() {
        return naziv2;
    }

    public void setNaziv2(String naziv2) {
        this.naziv2 = naziv2;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getImeRoditelja() {
        return imeRoditelja;
    }

    public void setImeRoditelja(String imeRoditelja) {
        this.imeRoditelja = imeRoditelja;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getMestoRodjenja() {
        return mestoRodjenja;
    }

    public void setMestoRodjenja(String mestoRodjenja) {
        this.mestoRodjenja = mestoRodjenja;
    }

    public String getOpstinaRodjenja() {
        return opstinaRodjenja;
    }

    public void setOpstinaRodjenja(String opstinaRodjenja) {
        this.opstinaRodjenja = opstinaRodjenja;
    }

    public String getDrzavaRodjenja() {
        return drzavaRodjenja;
    }

    public void setDrzavaRodjenja(String drzavaRodjenja) {
        this.drzavaRodjenja = drzavaRodjenja;
    }

    public String getDrzavljanstvo() {
        return drzavljanstvo;
    }

    public void setDrzavljanstvo(String drzavljanstvo) {
        this.drzavljanstvo = drzavljanstvo;
    }

    public VrstaStudija getVrstaStudija() {
        return vrstaStudija;
    }

    public void setVrstaStudija(VrstaStudija vrstaStudija) {
        this.vrstaStudija = vrstaStudija;
    }

    public StepenStudija getStepenStudija() {
        return stepenStudija;
    }

    public void setStepenStudija(StepenStudija stepenStudija) {
        this.stepenStudija = stepenStudija;
    }

    public String getStudijskiProgram() {
        return studijskiProgram;
    }

    public void setStudijskiProgram(String studijskiProgram) {
        this.studijskiProgram = studijskiProgram;
    }

    public Date getDatumUpisa() {
        return datumUpisa;
    }

    public void setDatumUpisa(Date datumUpisa) {
        this.datumUpisa = datumUpisa;
    }

    public String getFotografija() {
        return fotografija;
    }

    public void setFotografija(String fotografija) {
        this.fotografija = fotografija;
    }

    public int getEspb() {
        return espb;
    }

    public void setEspb(int espb) {
        this.espb = espb;
    }

    public List<Godina> getGodine() {
        return godine;
    }

    public void setGodine(List<Godina> godine) {
        this.godine = godine;
    }

    public List<Rad> getRadovi() {
        return radovi;
    }

    public void setRadovi(List<Rad> radovi) {
        this.radovi = radovi;
    }

    public List<Praksa> getPrakse() {
        return prakse;
    }

    public void setPrakse(List<Praksa> prakse) {
        this.prakse = prakse;
    }

    public ZavrsniRad getZavrsniRad() {
        return zavrsniRad;
    }

    public void setZavrsniRad(ZavrsniRad zavrsniRad) {
        this.zavrsniRad = zavrsniRad;
    }

    public List<DobrovoljniRad> getDobrovoljniRadList() {
        return dobrovoljniRadList;
    }

    public void setDobrovoljniRadList(List<DobrovoljniRad> dobrovoljniRadList) {
        this.dobrovoljniRadList = dobrovoljniRadList;
    }

    public String getOstalo() {
        return ostalo;
    }

    public void setOstalo(String ostalo) {
        this.ostalo = ostalo;
    }
}
