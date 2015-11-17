package sk.mjmgames.nostradamareal.daos;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Filip on 01.09.2015.
 */
public class Game implements Serializable {

    private String name;
    private Player[] players;
    private Date last_saved;


    public Game() {
    }

    public Game(String name, Player[] players, Date last_saved) {
        this.name = name;
        this.players = players;
        this.last_saved = last_saved;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Date getLast_saved() {
        return last_saved;
    }

    public void setLast_saved(Date last_saved) {
        this.last_saved = last_saved;
    }
}
