package sk.mjmgames.nostradamareal.fragments;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import sk.mjmgames.nostradamareal.R;
import sk.mjmgames.nostradamareal.activities.LoginActivity;
import sk.mjmgames.nostradamareal.activities.game_home;
import sk.mjmgames.nostradamareal.daos.Game;
import sk.mjmgames.nostradamareal.fragments.GamesAdapter.ClickListener;

/**
 * Created by Filip on 1.8.2015.
 */
public class GamesFragment extends DialogFragment implements ClickListener{

    private RecyclerView recyclerView;
    private GamesAdapter adapter;
    private List<Game> games;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_games, null);


        adapter = new GamesAdapter(getActivity(),games);
        adapter.setClickListener(this);
        recyclerView = (RecyclerView) view.findViewById(R.id.rvGames);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        return view;
    }




    @Override
    public void itemClicked(View view, int position) {
        Intent intent = new Intent(this.getActivity(), game_home.class);
        intent.putExtra("game", games.get(position));
        startActivity(intent);
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
