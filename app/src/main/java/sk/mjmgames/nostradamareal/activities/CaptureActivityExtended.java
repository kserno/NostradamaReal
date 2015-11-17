package sk.mjmgames.nostradamareal.activities;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.journeyapps.barcodescanner.CaptureManager;
import com.journeyapps.barcodescanner.CompoundBarcodeView;

import sk.mjmgames.nostradamareal.R;

/**
 * Created by Filip on 27.7.2015.
 */
public class CaptureActivityExtended extends Activity implements View.OnClickListener {

    private CaptureManager capture;
    private CompoundBarcodeView barcodeScannerView;
    private Button btLogin;
    private ConnectionChangeReciever reciever;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qrcapture_layout);

        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        reciever = new ConnectionChangeReciever();
        registerReceiver(reciever, intentFilter);

        btLogin = (Button) findViewById(R.id.btLogin);
        btLogin.setOnClickListener(this);

        barcodeScannerView = (CompoundBarcodeView)this.findViewById(R.id.zxing_barcode_scanner);
        capture = new CaptureManager(this, barcodeScannerView);
        capture.initializeFromIntent(this.getIntent(), savedInstanceState);
        capture.decode();

    }
    protected void onResume() {
        super.onResume();
        capture.onResume();
    }

    protected void onPause() {
        super.onPause();
        capture.onPause();
        unregisterReceiver(reciever);
        finish();
    }

    protected void onDestroy() {
        super.onDestroy();
        capture.onDestroy();
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        capture.onSaveInstanceState(outState);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return barcodeScannerView.onKeyDown(keyCode, event) || super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btLogin) {
            Intent intent = new Intent(this, LoginActivity.class );
            setResult(5, intent);
            finish();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    public class ConnectionChangeReciever extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo !=null && networkInfo.isConnected()) {
                isConnected();
            } else {
                isNotConnected();
            }

        }

        private void isConnected() {
            btLogin.setBackgroundResource(R.drawable.button_login);
            btLogin.setClickable(true);
            btLogin.setText(getString(R.string.button_login));
        }

        private void isNotConnected() {
            btLogin.setBackgroundResource(R.drawable.noconnection_button);
            btLogin.setClickable(false);
            btLogin.setText(getString(R.string.button_noconnection));

        }
    }

}
