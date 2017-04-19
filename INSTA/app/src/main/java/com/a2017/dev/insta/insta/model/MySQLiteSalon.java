package com.a2017.dev.insta.insta.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by s.mines on 19/04/2017.
 */

public class MySQLiteSalon extends SQLiteOpenHelper{

    public static final String TABLE_SALON = "salon";
    public static final String COLUMN_SALON_ID = "_id";
    public static final String COLUMN_SALON_NAME = "nom";
    public static final String COLUMN_SALON_ADRESS = "adresse";
    public static final String COLUMN_SALON_DATE = "date";
    public static final String COLUMN_SALON_ACTIVE = "is_active";


    private static final String DATABASE_NAME_SALON = "salon";
    private static final int DATABASE_VERSION = 1;

    // Commande sql pour la création de la base de données
    private static final String DATABASE_CREATE = "create table "
            + TABLE_SALON + "("
            + COLUMN_SALON_ID + " integer primary key autoincrement, "
            + COLUMN_SALON_NAME + "text not null, "
            + COLUMN_SALON_ADRESS + " text not null, "
            + COLUMN_SALON_DATE + " date not null, "
            + COLUMN_SALON_ACTIVE + " integer not null"
            +");";



    public MySQLiteSalon(Context context) {
        super(context, DATABASE_NAME_SALON, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DATABASE_NAME_SALON,"Upgrading database from version " + oldVersion + " to "
                + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SALON);
        onCreate(db);
    }
}
