package rs.edu.student.indeks.models;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import rs.edu.student.indeks.BR;

/**
 * Created by enver on 6.3.17..
 */

public class ObavezaViewModel extends BaseObservable {
    private String nazivText;
    private String poenaText;
    private String datumText;

    @Bindable
    public String getNazivText() {
        return nazivText;
    }

    public void setNazivText(String nazivText) {
        this.nazivText = nazivText;
        notifyPropertyChanged(BR.nazivText);
    }

    @Bindable
    public String getPoenaText() {
        return poenaText;
    }

    public void setPoenaText(String poenaText) {
        this.poenaText = poenaText;
        notifyPropertyChanged(BR.poenaText);
    }

    @Bindable
    public String getDatumText() {
        return datumText;
    }

    public void setDatumText(String datumText) {
        this.datumText = datumText;
        notifyPropertyChanged(BR.datumText);
    }
}
