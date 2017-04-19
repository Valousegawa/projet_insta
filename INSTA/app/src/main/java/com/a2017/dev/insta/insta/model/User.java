package com.a2017.dev.insta.insta.model;

import android.widget.EditText;

/**
 * Created by s.mines on 18/04/2017.
 */

public class User {
    private EditText username;
    private EditText password;

    public User(EditText username, EditText password) {
        this.username = username;
        this.password = password;
    }

    public boolean isConnected(){
        return true;
    }

    public EditText getUsername() {
        return username;
    }

    public void setUsername(EditText username) {
        this.username = username;
    }

    public EditText getPassword() {
        return password;
    }

    public void setPassword(EditText password) {
        this.password = password;
    }
}
