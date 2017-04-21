package com.a2017.dev.insta.insta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.a2017.dev.insta.insta.model.HttpCustomClient;
import com.a2017.dev.insta.insta.model.User;
import com.a2017.dev.insta.insta.model.UserDataSource;
import com.a2017.dev.insta.insta.util.Utils;

/**
 * Created by Telest on 18/04/2017.
 */

public class ConnexionActivity extends Activity{

    private User aUser;
    private EditText username, password;
    private Button seConnecter;
    private UserDataSource mysql;
    private Utils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connexion_layout);

        aUser = new User();
        utils = new Utils();
        deserialiser();

        mysql = new UserDataSource(this);
        seConnecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mysql.open();
                User userLocal = new User("s.mines", "blabla77");
                mysql.createUser(userLocal);
                setUser(aUser);
                //Traitement de la connexion de l'admin
                //HttpCustomClient.returnHttpRequest("","POST",null);
                if(mysql.isAuthenticated(aUser)){
                    Intent connect = new Intent(getApplicationContext(), AdminPanelActivity.class);
                    startActivity(connect);
                }
                else {
                    utils.showToast(ConnexionActivity.this,"Username ou mdp erronés");
                }

            }
        });

    }

    public void deserialiser(){
        username = (EditText) findViewById(R.id.et_user);
        password = (EditText) findViewById(R.id.et_mdp);
        seConnecter = (Button) findViewById(R.id.btn_conn);
    }

    public User setUser(User user){
        System.out.println(username.getText().toString());
        System.out.println(password.getText().toString());
        user.setUsername(username.getText().toString());
        user.setPassword(password.getText().toString());
        return user;
    }
}
