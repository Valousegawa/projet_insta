package com.a2017.dev.insta.insta;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
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
        final ArrayList<Salon> tabSalon = salon.getAllSalonActive();
        adapter = new SalonAdapter(this, tabSalon);
        listView.setAdapter(adapter);
        listView.setEmptyView(findViewById(R.id.empty_list));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent contact = new Intent(MainActivity.this, ContactActivity.class);
                contact.putExtra("id_salon", tabSalon.get(position).getId());
                startActivity(contact);
            }
        });
        ((BaseAdapter)listView.getAdapter()).notifyDataSetChanged();
        btn_adm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this,ConnexionActivity.class);
                startActivity(myIntent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        salon.open();
        ArrayList<Salon> tabSalon = salon.getAllSalonActive();
        adapter = new SalonAdapter(this, tabSalon);
        listView.setAdapter(adapter);
        listView.setEmptyView(findViewById(R.id.empty_list));
        ((BaseAdapter)listView.getAdapter()).notifyDataSetChanged();
        System.out.println("Activity focused");
    }

    public void deserialiser(){
        listView = (ListView) findViewById(R.id.lv_in_progress);
        btn_adm = (Button) findViewById(R.id.btn_admin);
        salon = new SalonDataSource(MainActivity.this);
    }
}
