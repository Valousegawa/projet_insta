package com.a2017.dev.insta.insta;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

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

        deserialiser();
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
