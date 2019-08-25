package rs.edu.student.indeks.fragments;


import android.content.Context;
import androidx.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wunderlist.slidinglayer.SlidingLayer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import rs.edu.student.indeks.R;
import rs.edu.student.indeks.databinding.FragmentGodinaBinding;
import rs.edu.student.indeks.databinding.ObavezaLayoutBinding;
import rs.edu.student.indeks.models.Godina;
import rs.edu.student.indeks.models.Indeks;
import rs.edu.student.indeks.models.ObavezaViewModel;
import rs.edu.student.indeks.models.PredispitnaObaveza;
import rs.edu.student.indeks.models.Predmet;
import rs.edu.student.indeks.models.PredmetViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class GodinaFragment extends BaseFragment {

    private LinearLayout mLinearContent;
    private SlidingLayer mSlidingLayer;
    private SlidingLayer mPredmetSlidingLayer;
    private FragmentListener mListener;
    private PredmetViewModel predmetViewModel;
    private LinearLayout mObavezaListView;

    public static GodinaFragment newInstance() {
        GodinaFragment fragment = new GodinaFragment();
        return fragment;
    }

    public interface FragmentListener {
        void setViewPagerScroller(boolean isScroller);
    }

    public GodinaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mListener = (FragmentListener) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentGodinaBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_godina,
                container, false);
        predmetViewModel = new PredmetViewModel();
        binding.setPredmetViewModel(predmetViewModel);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mLinearContent = (LinearLayout) view.findViewById(R.id.linear_content);
        mPredmetSlidingLayer = (SlidingLayer) view.findViewById(R.id.slidingLayer);
        mObavezaListView = (LinearLayout) view.findViewById(R.id.list_obaveze);
    }

    private class PredmetAdapter extends BaseAdapter {
        private Context mContext;
        private List<Predmet> mPredmeti;

        public PredmetAdapter(Context mContext, List<Predmet> predmeti) {
            this.mContext = mContext;
            this.mPredmeti = predmeti;
        }

        @Override
        public int getCount() {
            return mPredmeti.size();
        }

        @Override
        public Predmet getItem(int i) {
            return mPredmeti.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder holder;
            final Predmet predmet = getItem(i);
            if (view == null) {
                view = LayoutInflater.from(mContext).inflate(R.layout.predmet_layout, viewGroup, false);
                holder = new ViewHolder();
                holder.sifra = (TextView) view.findViewById(R.id.sifra_predmeta_text);
                holder.naziv = (TextView) view.findViewById(R.id.naziv_predmeta_text);
                holder.status = (TextView) view.findViewById(R.id.status_predmeta_text);
                view.setTag(holder);
            } else
                holder = (ViewHolder) view.getTag();
            holder.sifra.setText(predmet.getSifra());
            holder.naziv.setText(predmet.getNaziv());
            holder.status.setText(predmet.getStatus().getOpis());
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mPredmetSlidingLayer.isClosed()) {
                        mObavezaListView.removeAllViews();
                        predmetViewModel.setPredmet(predmet);
                        ObavezaAdapter adapter = new ObavezaAdapter(getActivity(), predmet.getPredispitneObaveze());
                        ObavezaViewModel viewModel = new ObavezaViewModel();
                        viewModel.setNazivText("Naziv");
                        viewModel.setPoenaText("Poena");
                        viewModel.setDatumText("Datum");
                        ObavezaLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(getActivity()),
                                R.layout.obaveza_layout, null, false);
                        binding.setObavezaViewModel(viewModel);
                        mObavezaListView.addView(binding.getRoot());

                        for (int i = 0; i < adapter.getCount(); i++) {
                            View v = adapter.getView(i, null, mObavezaListView);
                            mObavezaListView.addView(v);
                        }

                        ObavezaViewModel ispitViewModel = new ObavezaViewModel();
                        ispitViewModel.setNazivText("Ispit");
                        ispitViewModel.setPoenaText(String.valueOf(predmet.getIspitPoena()));
                        if (predmet.getIspitDatum() != null) {
                            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
                            ispitViewModel.setDatumText(sdf.format(predmet.getIspitDatum()));
                        }
                        ObavezaLayoutBinding bindingIspit = DataBindingUtil.inflate(LayoutInflater.from(getActivity()),
                                R.layout.obaveza_layout, null, false);
                        bindingIspit.setObavezaViewModel(ispitViewModel);
                        mObavezaListView.addView(bindingIspit.getRoot());

                        mObavezaListView.requestLayout();
                        mPredmetSlidingLayer.openLayer(true);
                    } else
                        mPredmetSlidingLayer.closeLayer(true);
                }
            });
            return view;
        }

        class ViewHolder {
            TextView sifra;
            TextView naziv;
            TextView status;
        }
    }

    private class PredmetExtAdapter extends BaseAdapter {
        private Context mContext;
        private List<Predmet> mPredmeti;

        public PredmetExtAdapter(Context mContext, List<Predmet> predmeti) {
            this.mContext = mContext;
            this.mPredmeti = predmeti;
        }

        @Override
        public int getCount() {
            return mPredmeti.size();
        }

        @Override
        public Predmet getItem(int i) {
            return mPredmeti.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewExtHolder holder;
            Predmet predmet = getItem(i);
            if (view == null) {
                view = LayoutInflater.from(mContext).inflate(R.layout.predmet_ext_layout, viewGroup, false);
                holder = new ViewExtHolder();
                holder.espb = (TextView) view.findViewById(R.id.espb_text);
                holder.predavanja = (TextView) view.findViewById(R.id.predavanja_casovi_text);
                holder.vezbe = (TextView) view.findViewById(R.id.vezbe_casovi_text);
                holder.drugo = (TextView) view.findViewById(R.id.drugo_casovi_text);
                holder.potpis = (TextView) view.findViewById(R.id.potpis_text);
                view.setTag(holder);
            } else
                holder = (ViewExtHolder) view.getTag();

            holder.espb.setText(String.valueOf(predmet.getEspb()));
            holder.predavanja.setText(String.valueOf(predmet.getPredavanja()));
            holder.vezbe.setText(String.valueOf(predmet.getVezbe()));
            holder.drugo.setText(String.valueOf(predmet.getDrugo()));
            holder.potpis.setText(predmet.isPotpis() ? "Da" : "Ne");
            return view;
        }

        class ViewExtHolder {
            TextView espb;
            TextView predavanja;
            TextView vezbe;
            TextView drugo;
            TextView potpis;
        }
    }

    private class ObavezaAdapter extends BaseAdapter {
        private Context mContext;
        private List<PredispitnaObaveza> mData;

        public ObavezaAdapter(Context mContext, List<PredispitnaObaveza> mData) {
            this.mContext = mContext;
            this.mData = mData;
        }

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public PredispitnaObaveza getItem(int i) {
            return mData.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ObavezaLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext),
                    R.layout.obaveza_layout, viewGroup, false);
            PredispitnaObaveza obaveza = getItem(i);
            ObavezaViewModel viewModel = new ObavezaViewModel();
            viewModel.setNazivText(obaveza.getNaziv());
            viewModel.setPoenaText(String.valueOf(obaveza.getPoena()));
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
            if (obaveza.getDatumPolaganja() != null)
                viewModel.setDatumText(sdf.format(obaveza.getDatumPolaganja()));
            binding.setObavezaViewModel(viewModel);
            view = binding.getRoot();
            return view;
        }
    }

    @Override
    public void setIndeks(Indeks indeks) {
        super.setIndeks(indeks);
        mPredmetSlidingLayer.closeLayer(true);
        mLinearContent.removeAllViews();
        if (indeksViewModel.getIndeks() != null)
            for (Godina g: indeksViewModel.getIndeks().getGodine()) {
                View v = LayoutInflater.from(getActivity()).inflate(R.layout.godina_layout, null);
                TextView godina = (TextView) v.findViewById(R.id.godina_text);
                godina.setText(g.getGodina().getGodinaSlovima());

                TextView skolska = (TextView) v.findViewById(R.id.skolske_text);
                skolska.setText(String.format("%s/%s", g.getSkolskaGodina(), g.getSkolskaGodina() + 1));

                TextView finansiranje = (TextView) v.findViewById(R.id.nacin_finansiranja_text);
                finansiranje.setText(g.getNacinFinansiranja());

                TextView datum = (TextView) v.findViewById(R.id.datum_upisa_text);
                DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(getActivity());
                datum.setText(dateFormat.format(g.getDatum()));

                TextView ukupnoEspb = (TextView) v.findViewById(R.id.espb_ukupno_text);
                ukupnoEspb.setText(String.valueOf(g.getTotalEspb()));

                LinearLayout list = (LinearLayout) v.findViewById(R.id.godina_list);
                mSlidingLayer = (SlidingLayer) v.findViewById(R.id.slidingLayer1);
                mSlidingLayer.setOnInteractListener(new SlidingLayer.OnInteractListener() {
                    @Override
                    public void onOpen() {

                    }

                    @Override
                    public void onShowPreview() {

                    }

                    @Override
                    public void onClose() {

                    }

                    @Override
                    public void onOpened() {
                        //mListener.setViewPagerScroller(false);
                    }

                    @Override
                    public void onPreviewShowed() {

                    }

                    @Override
                    public void onClosed() {
                        //mListener.setViewPagerScroller(true);
                    }
                });

                View headerView = LayoutInflater.from(getActivity()).inflate(R.layout.predmet_layout, null);
                TextView sifra = (TextView) headerView.findViewById(R.id.sifra_predmeta_text);
                TextView naziv = (TextView) headerView.findViewById(R.id.naziv_predmeta_text);
                TextView status = (TextView) headerView.findViewById(R.id.status_predmeta_text);
                final View blank = (View) headerView.findViewById(R.id.blank_view);

                sifra.setTextColor(getResources().getColor(R.color.white));
                naziv.setTextColor(getResources().getColor(R.color.white));
                status.setTextColor(getResources().getColor(R.color.white));

                sifra.setText("SIFRA");
                naziv.setText("NAZIV");
                status.setText("STATUS");

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    blank.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                        @Override
                        public void onLayoutChange(View view, int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7) {
                            mSlidingLayer.setOffsetDistance(blank.getWidth() + 28);
                        }
                    });
                }

                blank.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
                int width = blank.getMeasuredWidth();
                mSlidingLayer.setOffsetDistance(width + 28);

                headerView.setClickable(false);
                headerView.setBackgroundColor(getResources().getColor(R.color.black));
                list.addView(headerView);

                PredmetAdapter predmetAdapter = new PredmetAdapter(getActivity(), g.getPredmeti());
                for (int i = 0; i < predmetAdapter.getCount(); i++)
                    list.addView(predmetAdapter.getView(i, null, list));

                list.requestLayout();

                // dodatna polja
                LinearLayout listAdv = (LinearLayout) v.findViewById(R.id.godina_list_adv);
                View headerViewAdv = LayoutInflater.from(getActivity()).inflate(R.layout.predmet_ext_layout, null);
                TextView espb = (TextView) headerViewAdv.findViewById(R.id.espb_text);
                TextView predavanja = (TextView) headerViewAdv.findViewById(R.id.predavanja_casovi_text);
                TextView vezbe = (TextView) headerViewAdv.findViewById(R.id.vezbe_casovi_text);
                TextView drugo = (TextView) headerViewAdv.findViewById(R.id.drugo_casovi_text);
                TextView potpis = (TextView) headerViewAdv.findViewById(R.id.potpis_text);

                espb.setTextColor(getResources().getColor(R.color.white));
                predavanja.setTextColor(getResources().getColor(R.color.white));
                vezbe.setTextColor(getResources().getColor(R.color.white));
                drugo.setTextColor(getResources().getColor(R.color.white));
                potpis.setTextColor(getResources().getColor(R.color.white));

                espb.setText("ESPB");
                predavanja.setText("PREDAVANJA");
                vezbe.setText("VEZBE");
                drugo.setText("DRUGO");
                potpis.setText("POTPIS");

                headerViewAdv.setClickable(false);
                headerViewAdv.setBackgroundColor(getResources().getColor(R.color.black));
                listAdv.addView(headerViewAdv);

                PredmetExtAdapter predmetExtAdapter = new PredmetExtAdapter(getActivity(), g.getPredmeti());
                for (int i = 0; i < predmetExtAdapter.getCount(); i++)
                    listAdv.addView(predmetExtAdapter.getView(i, null, listAdv));

                listAdv.requestLayout();
                // dodaj v
                mLinearContent.addView(v);
            }
        mLinearContent.requestLayout();
    }
}
