package sk.mjmgames.nostradamareal.fragments;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import sk.mjmgames.nostradamareal.R;
import sk.mjmgames.nostradamareal.activities.game_home;
import sk.mjmgames.nostradamareal.daos.Game;

/**
 * Created by Filip on 2.8.2015.
 */
public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.GamesViewHolder> {

    private LayoutInflater inflater;
    private List<Game> games = Collections.emptyList();
    private ClickListener clickListener;

    public GamesAdapter(Context context, List<Game> games) {
        this.games= games;
        inflater = LayoutInflater.from(context);

    }

    @Override
    public GamesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.fragment_games_custom_row, parent, false);
        GamesViewHolder holder = new GamesViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(GamesViewHolder holder, int position) {
        Game currentGame = games.get(position);

        holder.tvPlayers.setText(String.valueOf(currentGame.getPlayers().length));
        holder.tvGamename.setText(currentGame.getName());
        holder.tvSaved.setText(currentGame.getLast_saved().toString());

    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener=clickListener;
    }

    @Override
    public int getItemCount() {
        return games.size();
    }



    class GamesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView tvGamename, tvSaved, tvPlayers;


        public GamesViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tvGamename = (TextView) itemView.findViewById(R.id.tvGamename);
            tvSaved = (TextView) itemView.findViewById(R.id.tvSaved);
            tvPlayers = (TextView) itemView.findViewById(R.id.tvPlayers);

        }


        @Override
        public void onClick(View v) {
            if (clickListener!=null) {
                clickListener.itemClicked(v, getAdapterPosition());
            }
        }
    }

    public interface ClickListener {
        public void itemClicked(View view, int position);
    }
}
