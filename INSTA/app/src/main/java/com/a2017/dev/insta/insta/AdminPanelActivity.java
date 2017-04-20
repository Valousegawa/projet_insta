package com.a2017.dev.insta.insta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Telest on 18/04/2017.
 */

public class AdminPanelActivity extends Activity {

    private Button create, modif, cloture, delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_panel_layout);

        deserialiser();



        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent created = new Intent(getApplicationContext(), CreateSalonActivity.class);
                startActivity(created);
            }
        });

        modif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent modified = new Intent(getApplicationContext(), ModifSalonActivity.class);
                startActivity(modified);
            }
        });
    }

    public void deserialiser(){
        create = (Button) findViewById(R.id.btn_creer);
        modif = (Button) findViewById(R.id.btn_modif);
        cloture = (Button) findViewById(R.id.btn_clot);
        delete = (Button) findViewById(R.id.btn_suppr);
    }
}
