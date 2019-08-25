package rs.edu.student.indeks.models;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import java.text.SimpleDateFormat;

import rs.edu.student.indeks.BR;

/**
 * Created by enver on 5.3.17..
 */

public class PraksaViewModel extends BaseObservable {
    private Praksa praksa;

    @Bindable
    public Praksa getPraksa() {
        return praksa;
    }

    public void setPraksa(Praksa praksa) {
        this.praksa = praksa;
        notifyPropertyChanged(BR.praksa);
        notifyPropertyChanged(BR.datumOvereAsString);
        notifyPropertyChanged(BR.skolskaGodinaAsString);
    }

    @Bindable
    public String getDatumOvereAsString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
        if (this.praksa != null)
            return sdf.format(this.praksa.getDatumOvere());
        return null;
    }

    @Bindable
    public String getSkolskaGodinaAsString() {
        if (this.praksa != null)
            return String.format("%d/%d", this.praksa.getSkolskaGodina(), this.praksa.getSkolskaGodina()+1);
        return null;
    }
}
