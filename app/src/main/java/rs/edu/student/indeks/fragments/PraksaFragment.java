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
import rs.edu.student.indeks.databinding.FragmentPraksaBinding;
import rs.edu.student.indeks.databinding.PraksaLayoutBinding;
import rs.edu.student.indeks.models.Indeks;
import rs.edu.student.indeks.models.Praksa;
import rs.edu.student.indeks.models.PraksaViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class PraksaFragment extends BaseFragment {
    private List<Praksa> mPrakse = new ArrayList<>();
    private ListView mListView;
    private PraksaAdapter mAdapter;
    private SlidingLayer mSlidingLayer;
    private PraksaViewModel mPraksaViewModel;

    public PraksaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentPraksaBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_praksa,
                container, false);
        mPraksaViewModel = new PraksaViewModel();
        binding.setPraksaViewModel(mPraksaViewModel);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mSlidingLayer = (SlidingLayer) view.findViewById(R.id.slidingLayer1);
        if (indeksViewModel.getIndeks() != null)
            mPrakse = indeksViewModel.getIndeks().getPrakse();
        mListView = (ListView) view.findViewById(R.id.praksa_list);
        mAdapter = new PraksaAdapter(getActivity(), mPrakse);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (mSlidingLayer.isClosed()) {
                    mPraksaViewModel.setPraksa(mPrakse.get(i));
                    mSlidingLayer.openLayer(true);
                } else
                    mSlidingLayer.closeLayer(true);
            }
        });
    }

    private class PraksaAdapter extends BaseAdapter {
        private Context mContext;
        private List<Praksa> mData;

        public PraksaAdapter(Context context, List<Praksa> radovi) {
            mContext = context;
            mData = radovi;
        }

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public Praksa getItem(int i) {
            return mData.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            PraksaLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()),
                    R.layout.praksa_layout, viewGroup, false);
            PraksaViewModel praksaModel = new PraksaViewModel();
            praksaModel.setPraksa(getItem(i));
            binding.setItem(praksaModel);
            return binding.getRoot();
        }
    }

    @Override
    public void setIndeks(Indeks indeks) {
        super.setIndeks(indeks);
        mPrakse.clear();
        mPrakse.addAll(indeks.getPrakse());
        mAdapter.notifyDataSetChanged();
        mSlidingLayer.closeLayer(true);
    }
}
