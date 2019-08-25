package rs.edu.student.indeks.models;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import rs.edu.student.indeks.BR;

/**
 * Created by enver on 5.3.17..
 */

public class PredmetViewModel extends BaseObservable {
    private Predmet predmet;

    @Bindable
    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
        notifyPropertyChanged(BR.predmet);
    }

}
