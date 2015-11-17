package sk.mjmgames.nostradamareal.activities;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import sk.mjmgames.nostradamareal.R;
import sk.mjmgames.nostradamareal.daos.Game;
import sk.mjmgames.nostradamareal.fragments.AddRoundFragment;
import sk.mjmgames.nostradamareal.fragments.GamesFragment;


public class MainActivity extends FragmentActivity implements View.OnClickListener{

    private static final String PREFS_FILENAME = "sk.mjmgames.nostramareal.PREFS_FILE";
    private Button btNewGame, btLoadGame;
    private List<Game> games;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences prefs = getSharedPreferences(PREFS_FILENAME, Context.MODE_PRIVATE);
        switch(prefs.getInt("used", 0)) {
            case 0:
                IntentIntegrator intentIntegrator = new IntentIntegrator(MainActivity.this);
                intentIntegrator.setCaptureActivity(CaptureActivityExtended.class);
                intentIntegrator.initiateScan();
                break;
            case 1:
                setContentView(R.layout.activity_home_start);
                btNewGame = (Button) findViewById(R.id.btNewGame);
                btNewGame.setOnClickListener(this);
                games = new ArrayList<>();
                break;
            case 2:
                setContentView(R.layout.activity_home);
                games=new ArrayList<>();
                btNewGame = (Button) findViewById(R.id.btNewGame);
                btLoadGame = (Button) findViewById(R.id.btLoadGame);
                btNewGame.setOnClickListener(this);
                btLoadGame.setOnClickListener(this);
                break;
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getSharedPreferences(PREFS_FILENAME, Context.MODE_PRIVATE);
        switch(prefs.getInt("used", 0)) {
            case 0:
                IntentIntegrator intentIntegrator = new IntentIntegrator(MainActivity.this);
                intentIntegrator.setCaptureActivity(CaptureActivityExtended.class);
                intentIntegrator.initiateScan();
                break;
            case 1:
                setContentView(R.layout.activity_home_start);
                btNewGame = (Button) findViewById(R.id.btNewGame);
                btNewGame.setOnClickListener(this);
                break;
            case 2:
                setContentView(R.layout.activity_home);
                btNewGame = (Button) findViewById(R.id.btNewGame);
                btLoadGame = (Button) findViewById(R.id.btLoadGame);
                btNewGame.setOnClickListener(this);
                btLoadGame.setOnClickListener(this);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null ) {
            if (resultCode==6) games = (List<Game>) data.getSerializableExtra("games_back");
            if (resultCode==5) {
                startActivity(data);
            } else {
                IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
                if (intentResult != null) {
                    System.out.println(intentResult.getContents());
                    if (intentResult.getContents().equals("nostradama")) {
                        startActivity(new Intent(this, CreateAccount1Activity.class));
                    } else {
                        Toast.makeText(this, "not valid qr code", Toast.LENGTH_LONG).show();
                        IntentIntegrator intentIntegrator = new IntentIntegrator(MainActivity.this);
                        intentIntegrator.setCaptureActivity(CaptureActivityExtended.class);
                        intentIntegrator.initiateScan();
                    }
                }
            }
        }
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btNewGame :
                Intent intent = new Intent(this, NewGameActivity.class);
                intent.putExtra("games", (Serializable) games);
                //intent.putExtra("igames", (NewGameActivity.IGames) this);
                startActivityForResult(intent,1);
                break;
            case R.id.btLoadGame :
                GamesFragment gf = new GamesFragment();
                gf.setGames(games);
                FragmentManager fm = getSupportFragmentManager();
                gf.show(fm, "games_dialog_fragment");
                break;

        }
    }

}
