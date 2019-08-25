package rs.edu.student.indeks.fragments;


import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import rs.edu.student.indeks.R;
import rs.edu.student.indeks.databinding.FragmentFotoBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class FotoFragment extends BaseFragment {
    FragmentFotoBinding binding;

    public static FotoFragment newInstance() {
        FotoFragment fragment = new FotoFragment();
        return fragment;
    }

    public FotoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_foto,
                container, false);
        binding.setViewModelIndeks(indeksViewModel);
        return binding.getRoot();
    }
}
