package com.a2017.dev.insta.insta;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.a2017.dev.insta.insta.model.Salon;
import com.a2017.dev.insta.insta.model.SalonAdapter;
import com.a2017.dev.insta.insta.model.SalonDataSource;

import java.util.ArrayList;

/**
 * Created by s.mines on 20/04/2017.
 */

public class DeleteSalonActivity extends Activity{

    private ListView listView;
    private SalonDataSource mysql;
    private SalonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_salon_layout);

        deserialiser();

        mysql = new SalonDataSource(this);
        mysql.open();

        final ArrayList<Salon> tabSalon = mysql.getAllSalon();
        if(tabSalon.isEmpty()){
            Salon bla = new Salon(0,"Empty", "Empty", "0-0-0", 1);
            tabSalon.add(0, bla);
        }

        adapter = new SalonAdapter(DeleteSalonActivity.this, tabSalon);
        listView.setAdapter(adapter);
        listView.setEmptyView(findViewById(R.id.empty_list));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mysql.deleteSalon(tabSalon.get(position));
                finish();
            }
        });
        ((BaseAdapter)listView.getAdapter()).notifyDataSetChanged();
    }

    protected void onResume() {
        super.onResume();
        mysql.open();
        ArrayList<Salon> tabSalon = mysql.getAllSalon();
        adapter = new SalonAdapter(this, tabSalon);
        listView.setAdapter(adapter);
        listView.setEmptyView(findViewById(R.id.empty_list));
        ((BaseAdapter)listView.getAdapter()).notifyDataSetChanged();
        System.out.println("Activity focused");
    }

    public void deserialiser() {
        listView = (ListView) findViewById(R.id.lv_salons);
    }
}
