package com.a2017.dev.insta.insta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.a2017.dev.insta.insta.model.HttpCustomClient;
import com.a2017.dev.insta.insta.model.User;

/**
 * Created by Telest on 18/04/2017.
 */

public class ConnexionActivity extends Activity {

    private User aUser;
    private Button seConnecter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connexion_layout);

        deserialiser();

        seConnecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Traitement de la connexion de l'admin
                //HttpCustomClient.returnHttpRequest("","POST",null);
                Intent connect = new Intent(getApplicationContext(), AdminPanelActivity.class);
                startActivity(connect);

            }
        });

    }

    public void deserialiser(){
        //aUser.setUsername(findViewById(R.id.username));
        //aUser.setPassword(findViewById(R.id.password));
        seConnecter = (Button) findViewById(R.id.btn_conn);
    }
}
