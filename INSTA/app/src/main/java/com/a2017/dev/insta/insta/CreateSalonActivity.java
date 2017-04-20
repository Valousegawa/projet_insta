package com.a2017.dev.insta.insta;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.a2017.dev.insta.insta.model.Salon;
import com.a2017.dev.insta.insta.model.SalonDataSource;

import java.util.Calendar;

import static android.content.Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP;

/**
 * Created by s.mines on 20/04/2017.
 */

public class CreateSalonActivity extends Activity{

    private EditText nameSalon, lieu;
    private TextView title;
    private DatePicker dateEvent;
    private Button create;
    private SalonDataSource mysql;
    private Salon salon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.salon_layout);

        deserialiser();

        if (getIntent().getStringExtra("Text") != null){
            title.setText(getIntent().getStringExtra("Text"));
            create.setText("Modifier");
        }
        nameSalon.setText(getIntent().getStringExtra("Nom"));
        lieu.setText(getIntent().getStringExtra("Adresse"));

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
                if (getIntent().getStringExtra("Text") != null){
                    salon.setId(getIntent().getIntExtra("Id", 0));
                    mysql.updateSalon(salon);

                    finish();
                }
                else{
                    mysql.createSalon(salon);
                    finish();
                }
            }
        });
    }

    public void deserialiser(){
        title = (TextView) findViewById(R.id.tv_modif_salon);
        nameSalon = (EditText) findViewById(R.id.et_nom_salon);
        lieu = (EditText) findViewById(R.id.et_lieu);
        dateEvent = (DatePicker) findViewById(R.id.dp_salon);
        create = (Button) findViewById(R.id.btn_salon);
    }

    public void setSalon(Salon salon){
        salon.setNom(nameSalon.getText().toString());
        salon.setAdresse(lieu.getText().toString());
        salon.setDate(dateEvent.getYear()+"-"+dateEvent.getMonth()+"-"+dateEvent.getDayOfMonth());
        salon.setIs_active(1);
    }
}
