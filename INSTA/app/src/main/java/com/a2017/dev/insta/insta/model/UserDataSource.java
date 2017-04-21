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
 * Created by s.mines on 20/04/2017.
 */

public class UserDataSource {

    private SQLiteDatabase sqLiteDatabase;
    private MySqLiteUser mySqLiteUser;
    private String[] allColumns = {MySqLiteUser.COLUMN_ID_USER, MySqLiteUser.COLUMN_USERNAME, MySqLiteUser.COLUMN_MDP};
    private String[] idPath = {MySqLiteUser.COLUMN_ID_USER};
    private User user;

    public UserDataSource (Context context){
        mySqLiteUser = new MySqLiteUser(context);
    }

    public void open() throws SQLException {
        sqLiteDatabase = mySqLiteUser.getWritableDatabase();
    }

    public void close() {
        mySqLiteUser.close();
    }

    public boolean createUser(User u) {
        ContentValues values = new ContentValues();
        values.put(MySqLiteUser.COLUMN_USERNAME, u.getUsername());
        values.put(MySqLiteUser.COLUMN_MDP, u.getPassword());

        long insertId = sqLiteDatabase.insert(MySqLiteUser.TABLE_USER, null,
                values);

        Cursor cursor = sqLiteDatabase.query(MySqLiteUser.TABLE_USER,
                allColumns, MySqLiteUser.COLUMN_ID_USER + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        User user = cursorToUser(cursor);
        cursor.close();
        return insertId !=0;
    }

    public void deleteUser(User user) {
        long id = user.getId();
        System.out.println("User deleted with id: " + id);
        sqLiteDatabase.delete(MySqLiteUser.TABLE_USER, MySqLiteUser.COLUMN_ID_USER
                + " = " + id, null);
    }

    public boolean isAuthenticated(User user){
        Cursor cursor = sqLiteDatabase.query(MySqLiteUser.TABLE_USER, allColumns,
                MySqLiteUser.COLUMN_USERNAME+" =? AND "+MySqLiteUser.COLUMN_MDP+" =?", new String[]{user.getUsername(), user.getPassword()}, null, null, null);
        if (cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }
    }

    public List<User> getAllUser() {
        List<User> users = new ArrayList<User>();

        Cursor cursor = sqLiteDatabase.query(MySqLiteUser.TABLE_USER,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            User user = cursorToUser(cursor);
            users.add(user);
            cursor.moveToNext();
        }
        cursor.close();
        return users;
    }

    private User cursorToUser(Cursor cursor) {
        User user = new User();
        user.setId(cursor.getInt(0));
        user.setUsername(cursor.getString(1));
        user.setPassword(cursor.getString(2));

        return user;
    }
}
