package rs.edu.student.indeks;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.provider.Settings;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.core.view.MenuItemCompat;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import rs.edu.student.indeks.fragments.BaseFragment;
import rs.edu.student.indeks.fragments.DobrovoljniRadFragment;
import rs.edu.student.indeks.fragments.FotoFragment;
import rs.edu.student.indeks.fragments.GodinaFragment;
import rs.edu.student.indeks.fragments.OstaloFragment;
import rs.edu.student.indeks.fragments.PersonalFragment;
import rs.edu.student.indeks.fragments.PraksaFragment;
import rs.edu.student.indeks.fragments.RadoviFragment;
import rs.edu.student.indeks.fragments.ZavrsniRadFragment;
import rs.edu.student.indeks.models.DobrovoljniRad;
import rs.edu.student.indeks.models.Godina;
import rs.edu.student.indeks.models.Indeks;
import rs.edu.student.indeks.models.Praksa;
import rs.edu.student.indeks.models.PredispitnaObaveza;
import rs.edu.student.indeks.models.Predmet;
import rs.edu.student.indeks.models.Rad;

import static com.google.android.material.tabs.TabLayout.MODE_SCROLLABLE;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener,
        GodinaFragment.FragmentListener {

    private TabLayout mTabs;
    private CustomViewPager mPager;
    private MyPagerAdapter mAdapter;
    private List<Indeks> mIndeksi = new ArrayList<>();

    private Indeks mIndeks1;
    private int selectedItem;

    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd")
            .serializeNulls().create();
    private NfcAdapter mNfcAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initJson1();
        initJson2();

        mPager = (CustomViewPager) findViewById(R.id.pager);
        mTabs = (TabLayout) findViewById(R.id.main_tabs);
        mTabs.setTabMode(MODE_SCROLLABLE);
        mAdapter = new MyPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mAdapter);
        mTabs.setupWithViewPager(mPager);
        mPager.setOffscreenPageLimit(8);
        mPager.setPagingEnabled(false);

        if (savedInstanceState != null) {
            selectedItem = savedInstanceState.getInt("index_item");
        }

        //check nfc
        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);

        if (mNfcAdapter == null) {
            Toast.makeText(this, "Vas uredjaj ne podrzava NFC!", Toast.LENGTH_SHORT);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("index_item", selectedItem);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mNfcAdapter != null) {
            if (!mNfcAdapter.isEnabled()) {
                showWirelessSettingsDialog();
            }
        }
    }

    private void initJson1() {
        Indeks indeks = new Indeks();
        indeks.setSerijskiBroj(UUID.randomUUID());
        indeks.setBroj("1A/BB/10");
        Calendar c = Calendar.getInstance();
        c.set(1990, 12, 12);
        indeks.setDatumRodjenja(c.getTime());
        c.set(2010, 10, 10);
        indeks.setDatumUpisa(c.getTime());
        indeks.setDrzavaRodjenja("R. Srbija");
        indeks.setIme("Denis");
        indeks.setPrezime("Denis");
        indeks.setImeRoditelja("Elvis");
        indeks.setJmbg("220022002100");
        indeks.setDrzavljanstvo("R. Srbije");
        indeks.setNaziv1("Univerzitet u Novom Pazaru");
        indeks.setMestoRodjenja("Novi Pazar");
        indeks.setStepenStudija(Indeks.StepenStudija.PRVI);
        indeks.setVrstaStudija(Indeks.VrstaStudija.OAS);
        indeks.setStudijskiProgram("Psihologija");
        indeks.setOstalo("Neki podaci bitni za studenta tokom studiranja");

        Godina indeksGodina1 = new Godina();
        c.set(2010, 10, 10);
        indeksGodina1.setDatum(c.getTime());
        indeksGodina1.setGodina(Godina.GodinaEnum.PRVA);
        indeksGodina1.setNacinFinansiranja("samofinansiranje");
        indeksGodina1.setSkolskaGodina(2010);
        indeksGodina1.setPotvrdaDatum(c.getTime());

        Predmet predmet = new Predmet();
        predmet.setNaziv("Uvod u psihologiju");
        predmet.setSifra("PEP101");
        predmet.setEspb(7);
        predmet.setPredavanja(2);
        predmet.setVezbe(2);
        predmet.setStatus(Predmet.Status.OBAVEZAN);
        predmet.setDrugo(2);

        indeksGodina1.getPredmeti().add(predmet);

        Predmet predmet1 = new Predmet();
        predmet1.setNaziv("Inteligencija");
        predmet1.setSifra("PEP101");
        predmet1.setEspb(9);
        predmet1.setPredavanja(3);
        predmet1.setVezbe(3);
        predmet1.setStatus(Predmet.Status.OBAVEZAN);
        predmet1.setDrugo(3);

        PredispitnaObaveza predispitnaObaveza = new PredispitnaObaveza();
        predispitnaObaveza.setNaziv("Prisutnost");
        predispitnaObaveza.setPoena(10);
        predispitnaObaveza.setPotpis("Da");

        predmet1.getPredispitneObaveze().add(predispitnaObaveza);
        indeksGodina1.getPredmeti().add(predmet1);

        indeks.getGodine().add(indeksGodina1);

        Rad rad = new Rad();
        rad.setNazivPredmeta("Inteligencija");
        rad.setNaslov("Vestacka inteligencija");
        rad.setBrojPoena(10);
        rad.setBrojSati(5);
        rad.setSkolskaGodina(2012);
        c.set(2012, 12, 12);
        rad.setDatumOvere(c.getTime());

        indeks.getRadovi().add(rad);

        Praksa praksa = new Praksa();
        praksa.setSkolskaGodina(2012);
        praksa.setPodrucjePrakse("Informacioni sistemi");
        praksa.setBrojSati(60);
        praksa.setBrojPoena(10);
        praksa.setUstanova("Univerzitet u Novom Pazaru");
        praksa.setVremenskiPeriod("6 meseci");
        praksa.setDatumOvere(c.getTime());

        indeks.getPrakse().add(praksa);

        DobrovoljniRad dobrovoljniRad = new DobrovoljniRad();
        dobrovoljniRad.setNaziv("Uređenje stare novopazarske banje");
        dobrovoljniRad.setVrsta("Fizicki rad");
        dobrovoljniRad.setVrednovanje("Odlicno");
        dobrovoljniRad.setDatumOvere(c.getTime());

        indeks.getDobrovoljniRadList().add(dobrovoljniRad);

        FileWriter writer = null;
        try {
            File file = new File(getFilesDir(), "indeks1.json");
            writer = new FileWriter(file);
            gson.toJson(indeks, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initJson2() {
        Indeks indeks = new Indeks();
        indeks.setSerijskiBroj(UUID.randomUUID());
        indeks.setBroj("1A/CC/02");
        Calendar c = Calendar.getInstance();
        c.set(1980, 2, 4);
        indeks.setDatumRodjenja(c.getTime());
        c.set(2002, 10, 11);
        indeks.setDatumUpisa(c.getTime());
        indeks.setDrzavaRodjenja("R. Srbija");
        indeks.setIme("Denis");
        indeks.setPrezime("Denis");
        indeks.setImeRoditelja("Elvis");
        indeks.setJmbg("220022002100");
        indeks.setDrzavljanstvo("R. Srbije");
        indeks.setNaziv1("Univerzitet u Novom Pazaru");
        indeks.setMestoRodjenja("Novi Pazar");
        indeks.setStepenStudija(Indeks.StepenStudija.PRVI);
        indeks.setVrstaStudija(Indeks.VrstaStudija.OAS);
        indeks.setStudijskiProgram("Informatika");

        Godina indeksGodina1 = new Godina();
        c.set(2010, 10, 10);
        indeksGodina1.setDatum(c.getTime());
        indeksGodina1.setGodina(Godina.GodinaEnum.PRVA);
        indeksGodina1.setNacinFinansiranja("samofinansiranje");
        indeksGodina1.setSkolskaGodina(2010);
        indeksGodina1.setPotvrdaDatum(c.getTime());

        Predmet predmet = new Predmet();
        predmet.setNaziv("Uvod u informatiku");
        predmet.setSifra("IOA100");
        predmet.setEspb(7);
        predmet.setPredavanja(2);
        predmet.setVezbe(2);
        predmet.setStatus(Predmet.Status.OBAVEZAN);
        predmet.setDrugo(2);

        indeksGodina1.getPredmeti().add(predmet);

        indeks.getGodine().add(indeksGodina1);
        FileWriter writer = null;
        try {
            File file = new File(getFilesDir(), "indeks2.json");
            writer = new FileWriter(file);
            gson.toJson(indeks, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Indeks readJson(File file) {
        FileReader reader = null;
        try {
            reader = new FileReader(file);
            return gson.fromJson(reader, Indeks.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        selectedItem = i;
        ((TextView) adapterView.getChildAt(0)).setTextColor(Color.WHITE);
        mIndeks1 = mIndeksi.get(i);
        for (Fragment f: getSupportFragmentManager().getFragments()) {
            ((BaseFragment) f).setIndeks(mIndeks1);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void setViewPagerScroller(boolean isScroller) {
        mPager.setPagingEnabled(isScroller);
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        Class [] classes = {
                FotoFragment.class,
                PersonalFragment.class,
                GodinaFragment.class,
                RadoviFragment.class,
                PraksaFragment.class,
                ZavrsniRadFragment.class,
                DobrovoljniRadFragment.class,
                OstaloFragment.class
        };

        String[] titles = {
                "Foto",
                "Podaci",
                "Skolska godina",
                "Radovi",
                "Praksa",
                "Zavrsni rad",
                "Dobrovoljni rad",
                "Ostalo"
        };

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public BaseFragment getItem(int position) {
            try {
                BaseFragment fragment = (BaseFragment) classes[position].newInstance();
                return fragment;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public int getCount() {
            return classes.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        File [] files = getFilesDir().listFiles();
        List<String> brojeviIndeksa = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, brojeviIndeksa);
        for (File f: files)
            if (f.getName().endsWith(".json")) {
                mIndeksi.add(readJson(new File(getFilesDir(), f.getName())));
                brojeviIndeksa.add(mIndeksi.get(mIndeksi.size()-1).getBroj());
            }
        adapter.notifyDataSetChanged();
        MenuItem item = menu.findItem(R.id.spinner);
        Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);
        spinner.setAdapter(adapter); // set the adapter to provide layout of rows and content
        spinner.setSelection(selectedItem);
        spinner.setOnItemSelectedListener(this);
        if (brojeviIndeksa.size() == 1)
            item.setVisible(false);
        return super.onCreateOptionsMenu(menu);
    }

    private void showWirelessSettingsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.nfc_disabled);
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                startActivity(intent);
            }
        });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.create().show();
        return;
    }
}
