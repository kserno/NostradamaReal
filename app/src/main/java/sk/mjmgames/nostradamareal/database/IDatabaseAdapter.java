package sk.mjmgames.nostradamareal.database;

/**
 * Created by Filip on 29.7.2015.
 */
public interface IDatabaseAdapter {

    public void addRound(int pId);
    public void addMoney(int pId, int amount);
    public void addKnowledgePoint(int pId);
    public void getMoney(int pId);
    public void createGame(String... params);




}
