package com.a2017.dev.insta.insta.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by s.mines on 18/04/2017.
 */

public class MySQLiteDoc extends SQLiteOpenHelper {

    public static final String TABLE_CONTACT = "contacts";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "nom";
    public static final String COLUMN_SURNAME = "prenom";
    public static final String COLUMN_ADRESS = "adresse";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_CP = "code_postal";
    public static final String COLUMN_CITY = "ville";
    public static final String COLUMN_PHONE = "tel";
    public static final String COLUMN_MOBILE = "mobile";
    public static final String COLUMN_MAIL = "email";
    public static final String COLUMN_FORMATION = "formation";


    private static final String DATABASE_NAME = "contacts";
    private static final int DATABASE_VERSION = 1;

    // Commande sql pour la création de la base de données
    private static final String DATABASE_CREATE = "create table "
            + TABLE_CONTACT + "("
            + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_NAME + " text not null"
            + COLUMN_SURNAME + "text not null"
            + COLUMN_ADRESS + "text not null"
            + COLUMN_DATE + "date not null"
            + COLUMN_CP + "text not null"
            + COLUMN_CITY + "text not null"
            + COLUMN_PHONE + "text null"
            + COLUMN_MOBILE + "text null"
            + COLUMN_MAIL + "text not null"
            +");";



    public MySQLiteDoc(Context context) {
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
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACT);
        onCreate(db);
    }
}
