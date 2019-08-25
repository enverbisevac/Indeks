package rs.edu.student.indeks.models;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import rs.edu.student.indeks.BR;

/**
 * Created by enver on 2.3.17..
 */

public class IndeksViewModel extends BaseObservable {
    private Indeks indeks;

    public IndeksViewModel() {
    }

    public IndeksViewModel(Indeks indeks) {
        setIndeks(indeks);
    }

    @Bindable
    public Indeks getIndeks() {
        return indeks;
    }

    public void setIndeks(Indeks indeks) {
        this.indeks = indeks;
        notifyPropertyChanged(BR.indeks);
        notifyPropertyChanged(BR.fullName);
    }

    @Bindable
    public String getFullName() {
        if (indeks != null)
            return String.format("%s %s", this.indeks.getIme(), this.indeks.getPrezime());
        return null;
    }
}
