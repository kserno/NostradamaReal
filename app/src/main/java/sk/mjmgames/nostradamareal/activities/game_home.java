package sk.mjmgames.nostradamareal.activities;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.opengl.EGLExt;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import sk.mjmgames.nostradamareal.R;
import sk.mjmgames.nostradamareal.daos.Game;
import sk.mjmgames.nostradamareal.daos.Player;
import sk.mjmgames.nostradamareal.fragments.StatisticsFragment;
import sk.mjmgames.nostradamareal.fragments.UserFragment;

public class game_home extends FragmentActivity implements View.OnClickListener {

    private Button btAnswers, btInfo, btClose;
    private Button[] players;
    private Button lastSelected;
    private Game game;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_home);

        this.game=(Game) getIntent().getSerializableExtra("game");
        StatisticsFragment sf = new StatisticsFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.rlFraments, sf);
        ft.commit();
        initWidgets();
        // game = (Game) getIntent().getSerializableExtra("game");
    }


    private void initWidgets() {
        btAnswers = (Button) findViewById(R.id.btAnswers);
        btClose = (Button) findViewById(R.id.btClose);
        btInfo = (Button) findViewById(R.id.btInfo);

        players = new Button[4];

        players[0] = (Button) findViewById(R.id.btUser1);
        players[1] = (Button) findViewById(R.id.btUser2);
        players[2] = (Button) findViewById(R.id.btUser3);
        players[3] = (Button) findViewById(R.id.btUser4);



        for (int i=0; i<players.length; i++) {
            if (i<game.getPlayers().length) {
                players[i].setOnClickListener(this);
                players[i].setText(game.getPlayers()[i].getName());
            } else {
                players[i].setVisibility(View.INVISIBLE);

            }
        }

        switch (game.getPlayers().length) {
            case 2:
                View view = (View) findViewById(R.id.vDiv2);
                View view2 = (View) findViewById(R.id.vDiv3);
                view.setVisibility(View.INVISIBLE);
                view2.setVisibility(View.INVISIBLE);
                 break;
            case 3:
                View view3 = (View) findViewById(R.id.vDiv3);
                view3.setVisibility(View.INVISIBLE);
                break;


        }

        btAnswers.setOnClickListener(this);
        btInfo.setOnClickListener(this);
        btClose.setOnClickListener(this);



    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btAnswers :
                changeToAnswers();
                break;
            case R.id.btClose :
                finish();
                break;
            case R.id.btInfo :
                changeToInfo();
                break;
            case R.id.btUser1 :
                btClicked(players[0]);
                break;
            case R.id.btUser2 :
                btClicked(players[1]);
                break;
            case R.id.btUser3 :
                btClicked(players[2]);
                break;
            case R.id.btUser4 :
                btClicked(players[3]);
                break;
        }

    }

    private void btClicked(Button player) {
        if (lastSelected==null || !lastSelected.equals(player)) {
            if (lastSelected!=null) lastSelected.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0);
            player.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.arrow_selected, 0);
            lastSelected = player;

            UserFragment userFragment = new UserFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.rlFraments, userFragment);
            ft.commit();
        }
    }

    private void changeToInfo() {
        if (lastSelected!=null) {
            lastSelected.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0);
            lastSelected = null;
        }


        StatisticsFragment statisticsFragment = new StatisticsFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.rlFraments, statisticsFragment);
        ft.commit();
    }

    private void changeToAnswers() {

    }
}
