package com.a2017.dev.insta.insta.model;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.a2017.dev.insta.insta.ContactActivity;

import org.w3c.dom.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by s.mines on 18/04/2017.
 */

public class ContactsDataSource {

    //Champs BDD
    private SQLiteDatabase sqLiteDatabase;
    private MySQLiteDoc sqLiteDoc;
    private String[] allColumns = {MySQLiteDoc.COLUMN_ID, MySQLiteDoc.COLUMN_ID_SALON, MySQLiteDoc.COLUMN_NAME, MySQLiteDoc.COLUMN_SURNAME,
                        MySQLiteDoc.COLUMN_ADRESS, MySQLiteDoc.COLUMN_CP, MySQLiteDoc.COLUMN_CITY,
                        MySQLiteDoc.COLUMN_DATE, MySQLiteDoc.COLUMN_PHONE, MySQLiteDoc.COLUMN_MOBILE,
                        MySQLiteDoc.COLUMN_MAIL};
    private Contact contact;

    public ContactsDataSource(Context context){
        sqLiteDoc = new MySQLiteDoc(context);
    }

    public void open() throws SQLException{
        sqLiteDatabase = sqLiteDoc.getWritableDatabase();
    }

    public void close() {
        sqLiteDoc.close();
    }

    public boolean createContact(Contact c) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteDoc.COLUMN_ID_SALON, c.getIdSalon());
        values.put(MySQLiteDoc.COLUMN_NAME, c.getNom());
        values.put(MySQLiteDoc.COLUMN_SURNAME, c.getPrenom());
        values.put(MySQLiteDoc.COLUMN_ADRESS, c.getAdresse());
        values.put(MySQLiteDoc.COLUMN_CP, c.getCodePostal());
        values.put(MySQLiteDoc.COLUMN_CITY, c.getVille());
        values.put(MySQLiteDoc.COLUMN_DATE, c.getDateNaissance());
        values.put(MySQLiteDoc.COLUMN_PHONE, c.getNumTel());
        values.put(MySQLiteDoc.COLUMN_MOBILE, c.getNumMobile());
        values.put(MySQLiteDoc.COLUMN_MAIL, c.getEmail());
        //values.put(MySQLiteDoc.COLUMN_FORMATION, c.getFormationSouhaitee());

        long insertId = sqLiteDatabase.insert(MySQLiteDoc.TABLE_CONTACT, null,
                values);

        Cursor cursor = sqLiteDatabase.query(MySQLiteDoc.TABLE_CONTACT,
                allColumns, MySQLiteDoc.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Contact contact = cursorToContact(cursor);
        Log.d("Debug", contact.getDateNaissance());
        cursor.close();
        return insertId !=0;
    }

    public void deleteContact(Contact contact) {
        long id = contact.getId();
        System.out.println("Contact deleted with id: " + id);
        sqLiteDatabase.delete(MySQLiteDoc.TABLE_CONTACT, MySQLiteDoc.COLUMN_ID
                + " = " + id, null);
    }

    public List<Contact> getAllContact() {
        List<Contact> contacts = new ArrayList<Contact>();

        Cursor cursor = sqLiteDatabase.query(MySQLiteDoc.TABLE_CONTACT,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Contact contact = cursorToContact(cursor);
            contacts.add(contact);
            cursor.moveToNext();
        }
        cursor.close();
        return contacts;
    }

    private Contact cursorToContact(Cursor cursor) {
        Contact contact = new Contact();
        contact.setId(cursor.getInt(0));
        contact.setNom(cursor.getString(1));
        contact.setPrenom(cursor.getString(2));
        contact.setAdresse(cursor.getString(3));
        contact.setCodePostal(cursor.getString(4));
        contact.setVille(cursor.getString(5));
        contact.setDateNaissance(cursor.getString(6));
        contact.setNumTel(cursor.getString(7));
        contact.setNumMobile(cursor.getString(8));
        contact.setEmail(cursor.getString(9));
        //contact.setIdSalon(cursor.getInt(10));
        //contact.setFormationSouhaitee(cursor.getString(10));

        return contact;
    }
}
