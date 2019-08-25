package rs.edu.student.indeks.models;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import java.text.SimpleDateFormat;

import rs.edu.student.indeks.BR;

/**
 * Created by enver on 5.3.17..
 */

public class ZavrsniRadViewModel extends BaseObservable {
    private ZavrsniRad zavrsniRad;

    @Bindable
    public ZavrsniRad getZavrsniRad() {
        return zavrsniRad;
    }

    public void setZavrsniRad(ZavrsniRad zavrsniRad) {
        this.zavrsniRad = zavrsniRad;
        notifyPropertyChanged(BR.zavrsniRad);
        notifyPropertyChanged(BR.datumAsString);
    }

    @Bindable
    public String getDatumAsString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
        if (this.zavrsniRad != null)
            return sdf.format(this.zavrsniRad.getDatum());
        return null;
    }
}
