package rs.edu.student.indeks.citac;

import android.nfc.NfcAdapter;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements IndeksReader.AndroidIDCallback {
    public static final String TAG = "MainActivity";

    public static int READER_FLAGS =
            NfcAdapter.FLAG_READER_NFC_A | NfcAdapter.FLAG_READER_SKIP_NDEF_CHECK;
    public IndeksReader mIndeksReader;
    private TextView mId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mId = (TextView) findViewById(R.id.id_text);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            mIndeksReader = new IndeksReader(this);
            enableReaderMode();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            disableReaderMode();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            enableReaderMode();
        }
    }

    private void enableReaderMode() {
        Log.i(TAG, "Enabling reader mode");
        NfcAdapter nfc = NfcAdapter.getDefaultAdapter(this);
        if (nfc != null) {
            nfc.enableReaderMode(this, mIndeksReader, READER_FLAGS, null);
        }
    }

    private void disableReaderMode() {
        Log.i(TAG, "Disabling reader mode");
        NfcAdapter nfc = NfcAdapter.getDefaultAdapter(this);
        if (nfc != null) {
            nfc.disableReaderMode(this);
        }
    }

    @Override
    public void onIdReceived(final String account) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mId.setText(account);
            }
        });

    }
}
