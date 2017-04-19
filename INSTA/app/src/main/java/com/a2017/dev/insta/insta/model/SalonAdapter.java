package com.a2017.dev.insta.insta.model;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.a2017.dev.insta.insta.R;

import java.util.ArrayList;

/**
 * Created by s.mines on 19/04/2017.
 */

public class SalonAdapter extends BaseAdapter{

    private Activity context;
    private ArrayList<Salon> salons;

    public SalonAdapter(Activity context, ArrayList<Salon> salons) {
        this.context = context;
        this.salons = salons;
    }
    @Override
    public int getCount() {
        return salons.size();
    }

    @Override
    public Object getItem(int position) {
        return salons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.salon_element_layout, null);
        TextView textSalon = (TextView) rowView.findViewById(R.id.tv_salon_nom);
        TextView textDate = (TextView) rowView.findViewById(R.id.tv_salon_date);
        TextView textLieu = (TextView) rowView.findViewById(R.id.tv_salon_lieu);

        textSalon.setText(salons.get(position).getNom());
        textDate.setText(salons.get(position).getDate());
        textLieu.setText(salons.get(position).getAdresse());
        return rowView;
    }
}
