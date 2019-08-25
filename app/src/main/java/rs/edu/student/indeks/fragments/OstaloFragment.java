package rs.edu.student.indeks.fragments;


import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import rs.edu.student.indeks.R;
import rs.edu.student.indeks.databinding.FragmentOstaloBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class OstaloFragment extends BaseFragment {


    public OstaloFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentOstaloBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_ostalo,
                container, false);
        binding.setIndeksViewModel(indeksViewModel);
        return binding.getRoot();
    }

}
