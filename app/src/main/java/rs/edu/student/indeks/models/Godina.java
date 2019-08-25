package rs.edu.student.indeks.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by enver on 27.2.17..
 */

public class Godina {
    private GodinaEnum godina;
    private int skolskaGodina;
    private Date datum;
    private String nacinFinansiranja;
    private Date potvrdaDatum;

    private List<Predmet> predmeti = new ArrayList();

    public enum GodinaEnum {
        PRVA(1, "PRVA"), DRUGA(2, "DRUGA"), TRECA(3, "TRECA"), CETVRTA(4, "CETVRTA"), PETA(5, "PETA"), SESTA(6, "ŠESTA");

        private int godina;
        private String godinaSlovima;

        GodinaEnum(int i, String slovima) {
            godina = i;
            godinaSlovima = slovima;
        }

        public int getGodina() {
            return godina;
        }

        public String getGodinaSlovima() {
            return godinaSlovima;
        }
    }

    public int getTotalEspb() {
        return 0;
    }

    public GodinaEnum getGodina() {
        return godina;
    }

    public void setGodina(GodinaEnum godina) {
        this.godina = godina;
    }

    public int getSkolskaGodina() {
        return skolskaGodina;
    }

    public void setSkolskaGodina(int skolskaGodina) {
        this.skolskaGodina = skolskaGodina;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getNacinFinansiranja() {
        return nacinFinansiranja;
    }

    public void setNacinFinansiranja(String nacinFinansiranja) {
        this.nacinFinansiranja = nacinFinansiranja;
    }

    public Date getPotvrdaDatum() {
        return potvrdaDatum;
    }

    public void setPotvrdaDatum(Date potvrdaDatum) {
        this.potvrdaDatum = potvrdaDatum;
    }

    public List<Predmet> getPredmeti() {
        return predmeti;
    }

    public void setPredmeti(List<Predmet> predmeti) {
        this.predmeti = predmeti;
    }
}
