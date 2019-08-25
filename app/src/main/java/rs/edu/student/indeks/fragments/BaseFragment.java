package rs.edu.student.indeks.fragments;

import androidx.fragment.app.Fragment;

import rs.edu.student.indeks.models.Indeks;
import rs.edu.student.indeks.models.IndeksViewModel;

/**
 * Created by enver on 28.2.17..
 */

public class BaseFragment extends Fragment {

    protected IndeksViewModel indeksViewModel = new IndeksViewModel();

    public void setIndeks(Indeks indeks) {
        if (indeks != null)
            this.indeksViewModel.setIndeks(indeks);

    }
}
