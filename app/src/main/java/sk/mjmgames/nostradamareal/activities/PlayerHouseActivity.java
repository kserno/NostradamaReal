package sk.mjmgames.nostradamareal.activities;

import android.app.Activity;
import android.os.Bundle;

import sk.mjmgames.nostradamareal.R;

/**
 * Created by Filip on 03.09.2015.
 */
public class PlayerHouseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_house);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }


}
