package rs.edu.student.indeks.models;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import java.text.SimpleDateFormat;

import rs.edu.student.indeks.BR;

/**
 * Created by enver on 5.3.17..
 */

public class DobrovoljniRadViewModel extends BaseObservable {
    private DobrovoljniRad dobrovoljniRad;

    @Bindable
    public DobrovoljniRad getDobrovoljniRad() {
        return dobrovoljniRad;
    }

    public void setDobrovoljniRad(DobrovoljniRad dobrovoljniRad) {
        this.dobrovoljniRad = dobrovoljniRad;
        notifyPropertyChanged(BR.dobrovoljniRad);
    }

    @Bindable
    public String getDatumOvereAsString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
        if (this.dobrovoljniRad != null)
            return sdf.format(this.dobrovoljniRad.getDatumOvere());
        return null;
    }
}
