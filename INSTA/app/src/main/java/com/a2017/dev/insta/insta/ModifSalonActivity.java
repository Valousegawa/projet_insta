package com.a2017.dev.insta.insta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;

import com.a2017.dev.insta.insta.model.Salon;
import com.a2017.dev.insta.insta.model.SalonAdapter;
import com.a2017.dev.insta.insta.model.SalonDataSource;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by s.mines on 20/04/2017.
 */

public class ModifSalonActivity extends Activity{

    private EditText nameSalon, lieu;
    private ListView listView;
    private DatePicker dateEvent;
    private Button create;
    private SalonDataSource mysql;
    private Salon salon;
    private SalonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_salon_layout);

        deserialiser();

        mysql = new SalonDataSource(this);
        mysql.open();

        final ArrayList<Salon> tabSalon = mysql.getAllSalonActive();
        if(tabSalon.isEmpty()){
            Salon bla = new Salon(0,"Empty", "Empty", "0-0-0", 1);
            tabSalon.add(0, bla);
        }

        adapter = new SalonAdapter(ModifSalonActivity.this, tabSalon);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent mod = new Intent(getApplicationContext(), CreateSalonActivity.class);
                mod.putExtra("Text", "Modifier le salon");
                mod.putExtra("Nom", tabSalon.get(position).getNom());
                mod.putExtra("Date", tabSalon.get(position).getDate());
                mod.putExtra("Adresse", tabSalon.get(position).getAdresse());
                startActivity(mod);
            }
        });

        /*
        mysql = new SalonDataSource(this);

        salon = new Salon();

        Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);
        dateEvent.updateDate(mYear, mMonth, mDay);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mysql.open();
                setSalon(salon);
                Log.d("Nom", salon.getNom());
                Log.d("Date", salon.getDate());
                Log.d("Adresse", salon.getAdresse());
                mysql.createSalon(salon);
                finish();
            }
        });
        */
    }

    public void deserialiser(){
        nameSalon = (EditText) findViewById(R.id.et_nom_salon);
        lieu = (EditText) findViewById(R.id.et_lieu);
        dateEvent = (DatePicker) findViewById(R.id.dp_salon);
        create = (Button) findViewById(R.id.btn_salon);
        listView = (ListView) findViewById(R.id.lv_salons);
    }

    public void setSalon(Salon salon){
        salon.setNom(nameSalon.getText().toString());
        salon.setAdresse(lieu.getText().toString());
        salon.setDate(dateEvent.getYear()+"-"+dateEvent.getMonth()+"-"+dateEvent.getDayOfMonth());
        salon.setIs_active(1);
    }
}
