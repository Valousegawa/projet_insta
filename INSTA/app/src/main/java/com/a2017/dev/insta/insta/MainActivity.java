package com.a2017.dev.insta.insta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.a2017.dev.insta.insta.model.Contact;
import com.a2017.dev.insta.insta.model.MySQLiteSalon;
import com.a2017.dev.insta.insta.model.Salon;
import com.a2017.dev.insta.insta.model.SalonAdapter;
import com.a2017.dev.insta.insta.model.SalonDataSource;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private ListView listView;
    private Button btn_adm;
    private SalonDataSource salon;
    private SalonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        deserialiser();
        salon.open();
        ArrayList<Salon> tabSalon = salon.getAllSalonActive();
        if(tabSalon.isEmpty()){
            Salon bla = new Salon(0,"Empty", "Empty", "0-0-0", 1);
            tabSalon.add(0, bla);
        }
        adapter = new SalonAdapter(this, tabSalon);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent contact = new Intent(MainActivity.this, ContactActivity.class);
                contact.putExtra("id_salon", adapter.getItemId(0));
                startActivity(contact);
            }
        });
        btn_adm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this,ConnexionActivity.class);
                startActivity(myIntent);
            }
        });

    }
    public void deserialiser(){
        listView = (ListView) findViewById(R.id.lv_in_progress);
        btn_adm = (Button) findViewById(R.id.btn_admin);
        salon = new SalonDataSource(MainActivity.this);
    }
}
