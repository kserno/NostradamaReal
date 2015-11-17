package sk.mjmgames.nostradamareal.activities;

import android.app.Activity;
import android.os.Bundle;

import sk.mjmgames.nostradamareal.R;

/**
 * Created by Filip on 03.09.2015.
 */
public class PlayerAccountStateActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_accountstate);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
