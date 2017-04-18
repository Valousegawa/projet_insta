package com.a2017.dev.insta.insta;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;

import com.a2017.dev.insta.insta.model.Contact;

/**
 * Created by s.mines on 18/04/2017.
 */

public class ContactActivity extends Activity{

    private EditText nom;
    private EditText prenom;
    private DatePicker date;
    private EditText adresse;
    private EditText codePostal;
    private EditText ville;
    private EditText tel;
    private EditText mob;
    private EditText email;
    private Button btnValid;
    private Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_layout);

        deserialiser();

        Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);
        date.updateDate(mYear, mMonth, mDay);

        btnValid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ContactActivity.this, Contact2Activity.class);
                startActivity(i);
                finish();
            }
        });
    }

    public void deserialiser(){
        nom = (EditText) findViewById(R.id.et_nom);
        prenom = (EditText) findViewById(R.id.et_prenom);
        date = (DatePicker) findViewById(R.id.dp_bd);
        adresse = (EditText) findViewById(R.id.et_adresse);
        codePostal = (EditText) findViewById(R.id.et_cp);
        ville = (EditText) findViewById(R.id.et_ville);
        tel = (EditText) findViewById(R.id.et_fixe);
        mob = (EditText) findViewById(R.id.et_mobile);
        email = (EditText) findViewById(R.id.et_mail);
        btnValid = (Button) findViewById(R.id.btn_next);
    }
}
