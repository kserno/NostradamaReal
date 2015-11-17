package sk.mjmgames.nostradamareal.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import sk.mjmgames.nostradamareal.R;
import sk.mjmgames.nostradamareal.daos.Game;
import sk.mjmgames.nostradamareal.daos.Player;

/**
 * Created by Filip on 06.09.2015.
 */
public class NewGameActivity extends Activity {

    private List<Game> games;
    private Button btAddGame;
    private CheckBox[] cbPlayerActive;
    private EditText[] etPlayerName;
    private EditText etGameName;

    private static final String PREFS_FILENAME = "sk.mjmgames.nostramareal.PREFS_FILE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);
        games = (List<Game>) getIntent().getSerializableExtra("games");

        initWidgets();

    }

    private void initWidgets() {
        btAddGame = (Button) findViewById(R.id.btAddGame);
        btAddGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Player> players = new ArrayList<Player>();
                for (int i =0; i<4; i++) {
                    if (cbPlayerActive[i].isChecked()) {
                        players.add(new Player(etPlayerName[i].getText().toString()));
                    }
                }

                if (players.size()>1) {

                    SharedPreferences prefs = getSharedPreferences(PREFS_FILENAME, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putInt("used", 2);
                    editor.commit();
                    games.add(new Game(etGameName.getText().toString(), players.toArray(new Player[players.size()]), new Date(System.currentTimeMillis())));
                    System.out.println(games.size());
                    Intent intent = new Intent();
                    intent.putExtra("games_back", (Serializable) games);
                    setResult(6, intent);
                    finish();

                }
            }
        });

        etGameName = (EditText) findViewById(R.id.etGameName);

        cbPlayerActive = new CheckBox[4];
        cbPlayerActive[0] = (CheckBox) findViewById(R.id.cbPlayerActive1);
        cbPlayerActive[1] = (CheckBox) findViewById(R.id.cbPlayerActive2);
        cbPlayerActive[2] = (CheckBox) findViewById(R.id.cbPlayerActive3);
        cbPlayerActive[3] = (CheckBox) findViewById(R.id.cbPlayerActive4);

        etPlayerName = new EditText[4];
        etPlayerName[0] = (EditText) findViewById(R.id.etPlayerName1);
        etPlayerName[1] = (EditText) findViewById(R.id.etPlayerName2);
        etPlayerName[2] = (EditText) findViewById(R.id.etPlayerName3);
        etPlayerName[3] = (EditText) findViewById(R.id.etPlayerName4);
    }


}
