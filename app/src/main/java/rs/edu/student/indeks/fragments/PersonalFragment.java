package rs.edu.student.indeks.fragments;


import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.DateFormat;

import rs.edu.student.indeks.R;
import rs.edu.student.indeks.databinding.FragmentPersonalBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalFragment extends BaseFragment {

    public static PersonalFragment newInstance() {
        PersonalFragment fragment = new PersonalFragment();
        return fragment;
    }

    public PersonalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(getActivity());
        FragmentPersonalBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_personal, container, false);
        binding.setViewModelIndeks(indeksViewModel);
        binding.setDateFormat(dateFormat);
        return binding.getRoot();
    }
}
