package sk.mjmgames.nostradamareal.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import sk.mjmgames.nostradamareal.R;
import sk.mjmgames.nostradamareal.activities.PlayerAccountStateActivity;
import sk.mjmgames.nostradamareal.activities.PlayerCreditActivity;
import sk.mjmgames.nostradamareal.activities.PlayerHouseActivity;
import sk.mjmgames.nostradamareal.activities.PlayerPropertyActivity;
import sk.mjmgames.nostradamareal.activities.PlayerStateActivity;

/**
 * Created by Filip on 31.7.2015.
 */
public class UserFragment extends Fragment implements View.OnClickListener {

    private Button btPlayerState, btCredit, btAB, btProperty, btHouse;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player_info , container, false);
        initWidgets(view);
        return view;
    }

    private void initWidgets(View view) {
        btPlayerState = (Button) view.findViewById(R.id.btPlayerState);
        btCredit = (Button) view.findViewById(R.id.btCredit);
        btAB = (Button) view.findViewById(R.id.btAB);
        btProperty = (Button) view.findViewById(R.id.btProperty);
        btHouse = (Button) view.findViewById(R.id.btHouse);


        btPlayerState.setOnClickListener(this);
        btProperty.setOnClickListener(this);
        btAB.setOnClickListener(this);
        btCredit.setOnClickListener(this);
        btHouse.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btPlayerState:
                startActivity(new Intent(this.getActivity(), PlayerStateActivity.class));
                break;
            case R.id.btCredit:
                startActivity(new Intent(this.getActivity(), PlayerCreditActivity.class));
                break;
            case R.id.btAB :
                startActivity(new Intent(this.getActivity(), PlayerAccountStateActivity.class));
                break;
            case R.id.btProperty:
                startActivity(new Intent(this.getActivity(), PlayerPropertyActivity.class));
                break;
            case R.id.btHouse:
                startActivity(new Intent(this.getActivity(), PlayerHouseActivity.class));
                break;

        }
    }
}
