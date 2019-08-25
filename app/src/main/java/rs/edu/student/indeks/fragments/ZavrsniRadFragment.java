package rs.edu.student.indeks.fragments;


import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import rs.edu.student.indeks.R;
import rs.edu.student.indeks.databinding.FragmentZavrsniRadBinding;
import rs.edu.student.indeks.models.Indeks;
import rs.edu.student.indeks.models.ZavrsniRadViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZavrsniRadFragment extends BaseFragment {


    public ZavrsniRadFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentZavrsniRadBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_zavrsni_rad,
                container, false);
        ZavrsniRadViewModel viewModel = new ZavrsniRadViewModel();
        binding.setZavrsniRadViewModel(viewModel);
        return binding.getRoot();
    }

    @Override
    public void setIndeks(Indeks indeks) {
        super.setIndeks(indeks);
    }
}
