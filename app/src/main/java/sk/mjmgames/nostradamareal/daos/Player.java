package sk.mjmgames.nostradamareal.daos;

import java.io.Serializable;

/**
 * Created by Filip on 03.09.2015.
 */
public class Player implements Serializable{

    private String name;

    public Player() {
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}