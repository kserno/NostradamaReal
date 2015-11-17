package sk.mjmgames.nostradamareal.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import javax.xml.validation.Schema;

/**
 * Created by Filip on 29.7.2015.
 */
public class DatabaseAdapter {

    private Context context;
    private static DatabaseAdapter _dbAdapter;

    private DatabaseAdapter(Context context) {
        this.context = context;
    }

    public static synchronized DatabaseAdapter newInstance(Context context) {
        if (_dbAdapter == null) {
            _dbAdapter = new DatabaseAdapter(context);
        }
        return _dbAdapter;


    }


    static class DatabaseManager extends SQLiteOpenHelper {

        /*
            Database constants
         */
        private static final String DB_NAME = "NostradamaRealDB";
        private static final int DB_VERSION = 1;

        /*
            Tables
         */
        private static final String GAMES_TABLE = "games";

        // table columns
        private static final String GT_UID = "_id";
        private static final String GT_NAME = "name";
        private static final String GT_PLAYERS = "players";

        private static DatabaseManager _instance;

        private DatabaseManager(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }


        public static synchronized DatabaseManager newInstance(Context context) {
            if (_instance== null) {
                _instance = new DatabaseManager(context.getApplicationContext());
            }
            return _instance;

        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            String _createTable = "CREATE TABLE " + GAMES_TABLE + " (" + GT_UID +" INTEGER PRiAMARY KEY AUTOINCREMENT, " + GT_NAME + " VARCHAR(60), " + GT_PLAYERS + " INTEGER);";
            db.execSQL(_createTable);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }


    }

}
