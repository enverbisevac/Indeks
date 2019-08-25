package rs.edu.student.indeks.fragments;


import android.content.Context;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import rs.edu.student.indeks.R;
import rs.edu.student.indeks.databinding.DobrovoljniRadLayoutBinding;
import rs.edu.student.indeks.models.DobrovoljniRad;
import rs.edu.student.indeks.models.DobrovoljniRadViewModel;
import rs.edu.student.indeks.models.Indeks;

/**
 * A simple {@link Fragment} subclass.
 */
public class DobrovoljniRadFragment extends BaseFragment {
    private List<DobrovoljniRad> mRadovi = new ArrayList<>();
    private ListView mList;
    private RadAdapter mAdapter;

    public DobrovoljniRadFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dobrovoljni_rad, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mAdapter = new RadAdapter(getActivity(), mRadovi);
        mList = (ListView) view.findViewById(R.id.list_view);
        mList.setAdapter(mAdapter);
    }

    private class RadAdapter extends BaseAdapter {
        private Context mContext;
        private List<DobrovoljniRad> mData;

        public RadAdapter(Context mContext, List<DobrovoljniRad> mData) {
            this.mContext = mContext;
            this.mData = mData;
        }

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public DobrovoljniRad getItem(int i) {
            return mData.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            DobrovoljniRadLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext),
                    R.layout.dobrovoljni_rad_layout, viewGroup, false);
            DobrovoljniRadViewModel radViewModel = new DobrovoljniRadViewModel();
            radViewModel.setDobrovoljniRad(getItem(i));
            binding.setRadViewModel(radViewModel);
            return binding.getRoot();
        }
    }

    @Override
    public void setIndeks(Indeks indeks) {
        super.setIndeks(indeks);
        mRadovi.clear();
        mRadovi.addAll(indeks.getDobrovoljniRadList());
        mAdapter.notifyDataSetChanged();
    }
}
