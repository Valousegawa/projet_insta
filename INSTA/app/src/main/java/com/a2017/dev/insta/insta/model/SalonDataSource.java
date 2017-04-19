package com.a2017.dev.insta.insta.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by s.mines on 19/04/2017.
 */

public class SalonDataSource {

    private SQLiteDatabase sqLiteDatabase;
    private MySQLiteSalon mySQLiteSalon;
    private String[] allColumns = {MySQLiteSalon.COLUMN_SALON_ID, MySQLiteSalon.COLUMN_SALON_NAME,
                                    MySQLiteSalon.COLUMN_SALON_ADRESS, MySQLiteSalon.COLUMN_SALON_DATE,
                                    MySQLiteSalon.COLUMN_SALON_ACTIVE};
    private Salon salon;

    public SalonDataSource(Context context){
        mySQLiteSalon = new MySQLiteSalon(context);
    }

    public void open() throws SQLException {
        sqLiteDatabase = mySQLiteSalon.getWritableDatabase();
    }

    public void close() {
        mySQLiteSalon.close();
    }

    public boolean createSalon(Salon s) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteSalon.COLUMN_SALON_NAME, s.getNom());
        values.put(MySQLiteSalon.COLUMN_SALON_ADRESS, s.getAdresse());
        values.put(MySQLiteSalon.COLUMN_SALON_DATE, s.getDate());
        values.put(MySQLiteSalon.COLUMN_SALON_ACTIVE, s.is_active());

        long insertId = sqLiteDatabase.insert(MySQLiteSalon.TABLE_SALON, null,
                values);

        Cursor cursor = sqLiteDatabase.query(MySQLiteSalon.TABLE_SALON,
                allColumns, MySQLiteSalon.COLUMN_SALON_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Salon salon = cursorToSalon(cursor);
        //Log.d("Debug", salon.getDate());
        cursor.close();
        return insertId !=0;
    }

    public  void clotureSalon(Salon salon){
        long id = salon.getId();
        System.out.println("Salon cloture with id: " + id);
        ContentValues values = new ContentValues();
        values.put(MySQLiteSalon.COLUMN_SALON_ACTIVE, 0);
        sqLiteDatabase.update(MySQLiteSalon.TABLE_SALON, values, null, null);
        salon.setIs_active(0);
    }

    public void deleteSalon(Salon salon) {
        long id = salon.getId();
        System.out.println("Salon deleted with id: " + id);
        sqLiteDatabase.delete(MySQLiteSalon.TABLE_SALON, MySQLiteSalon.COLUMN_SALON_ID
                + " = " + id, null);
    }

    public List<Salon> getAllSalon() {
        List<Salon> salons = new ArrayList<Salon>();

        Cursor cursor = sqLiteDatabase.query(MySQLiteSalon.TABLE_SALON,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Salon salon = cursorToSalon(cursor);
            salons.add(salon);
            cursor.moveToNext();
        }
        cursor.close();
        return salons;
    }

    public List<Salon> getAllSalonActive() {
        List<Salon> salons = new ArrayList<Salon>();

        Cursor cursor = sqLiteDatabase.query(MySQLiteSalon.TABLE_SALON,
                allColumns, MySQLiteSalon.COLUMN_SALON_ACTIVE+ " = " + 1, null,
                null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Salon salon = cursorToSalon(cursor);
            salons.add(salon);
            cursor.moveToNext();
        }
        cursor.close();
        return salons;
    }

    private Salon cursorToSalon(Cursor cursor) {
        Salon salon = new Salon();
        salon.setId(cursor.getInt(0));
        salon.setNom(cursor.getString(1));
        salon.setAdresse(cursor.getString(2));
        salon.setDate(cursor.getString(3));
        salon.setIs_active(cursor.getInt(4));

        return salon;
    }
}
