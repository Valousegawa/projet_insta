package com.a2017.dev.insta.insta.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by s.mines on 20/04/2017.
 */

public class MySqLiteUser extends SQLiteOpenHelper{

    public static final String TABLE_USER = "user";
    public static final String COLUMN_ID_USER = "_id";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_MDP = "mdp";


    private static final String DATABASE_NAME = "user";
    private static final int DATABASE_VERSION = 1;

    // Commande sql pour la création de la base de données
    public static final String DATABASE_CREATE = "create table "
            + TABLE_USER + "("
            + COLUMN_ID_USER + " integer primary key autoincrement, "
            + COLUMN_USERNAME + " text not null, "
            + COLUMN_MDP + " text not null"
            +");";



    public MySqLiteUser(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DATABASE_NAME,"Upgrading database from version " + oldVersion + " to "
                + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
    }
}
