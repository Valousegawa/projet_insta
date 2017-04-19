package com.a2017.dev.insta.insta;

import android.accounts.AccountManager;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.HttpAuthHandler;
import android.widget.Button;

import com.a2017.dev.insta.insta.model.HttpCustomClient;
import com.a2017.dev.insta.insta.model.User;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by s.mines on 18/04/2017.
 */

public class ConnectionActivity extends Activity{

    private User aUser;
    private Button seConnecter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_connection);

        deserialiser();

        seConnecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Traitement de la connexion de l'admin
                HttpCustomClient.returnHttpRequest("","POST",null);

            }
        });

    }

    public void deserialiser(){
        //aUser.setUsername(findViewById(R.id.username));
        //aUser.setPassword(findViewById(R.id.password));
        //seConnecter = findViewById(R.id.seConnecter);
    }
}
