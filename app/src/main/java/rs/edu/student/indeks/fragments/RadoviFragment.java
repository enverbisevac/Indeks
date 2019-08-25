package rs.edu.student.indeks.fragments;


import android.content.Context;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.wunderlist.slidinglayer.SlidingLayer;

import java.util.ArrayList;
import java.util.List;

import rs.edu.student.indeks.R;
import rs.edu.student.indeks.databinding.FragmentRadoviBinding;
import rs.edu.student.indeks.databinding.RadLayoutBinding;
import rs.edu.student.indeks.models.Indeks;
import rs.edu.student.indeks.models.Rad;
import rs.edu.student.indeks.models.RadViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class RadoviFragment extends BaseFragment {
    private List<Rad> mRadovi = new ArrayList<>();
    private ListView mListView;
    private RadAdapter mAdapter;
    private SlidingLayer mSlidingLayer;
    private RadViewModel mRadViewModel;

    public RadoviFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentRadoviBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_radovi,
                container, false);
        mRadViewModel = new RadViewModel();
        binding.setRadViewModel(mRadViewModel);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mSlidingLayer = (SlidingLayer) view.findViewById(R.id.slidingLayer1);
        if (indeksViewModel.getIndeks() != null)
            mRadovi = indeksViewModel.getIndeks().getRadovi();
        mListView = (ListView) view.findViewById(R.id.radovi_list);
        mAdapter = new RadAdapter(getActivity(), mRadovi);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (mSlidingLayer.isClosed()) {
                    mRadViewModel.setRad(mRadovi.get(i));
                    mSlidingLayer.openLayer(true);
                } else
                    mSlidingLayer.closeLayer(true);
            }
        });
    }

    private class RadAdapter extends BaseAdapter {
        private Context mContext;
        private List<Rad> mData;

        public RadAdapter(Context context, List<Rad> radovi) {
            mContext = context;
            mData = radovi;
        }

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public Rad getItem(int i) {
            return mData.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            RadLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()),
                    R.layout.rad_layout, viewGroup, false);
            RadViewModel radModel = new RadViewModel();
            radModel.setRad(getItem(i));
            binding.setItem(radModel);
            return binding.getRoot();
        }
    }

    @Override
    public void setIndeks(Indeks indeks) {
        super.setIndeks(indeks);
        mRadovi.clear();
        mRadovi.addAll(indeks.getRadovi());
        mAdapter.notifyDataSetChanged();
        mSlidingLayer.closeLayer(true);
    }
}
