package rs.edu.student.indeks.models;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import java.text.SimpleDateFormat;

import rs.edu.student.indeks.BR;

/**
 * Created by enver on 4.3.17..
 */

public class RadViewModel extends BaseObservable {

    private Rad rad;

    @Bindable
    public Rad getRad() {
        return rad;
    }

    public void setRad(Rad rad) {
        this.rad = rad;
        notifyPropertyChanged(BR.rad);
        notifyPropertyChanged(BR.datumOvereAsString);
        notifyPropertyChanged(BR.skolskaGodinaAsString);
    }

    @Bindable
    public String getDatumOvereAsString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
        if (this.rad != null)
            return sdf.format(this.rad.getDatumOvere());
        return null;
    }

    @Bindable
    public String getSkolskaGodinaAsString() {
        if (this.rad != null)
            return String.format("%d/%d", this.rad.getSkolskaGodina(), this.rad.getSkolskaGodina()+1);
        return null;
    }
}
