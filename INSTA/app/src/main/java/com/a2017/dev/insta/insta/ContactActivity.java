package com.a2017.dev.insta.insta;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;
import android.widget.ViewAnimator;

import java.util.Calendar;
import java.util.List;

import com.a2017.dev.insta.insta.model.Contact;
import com.a2017.dev.insta.insta.model.ContactsDataSource;
import com.a2017.dev.insta.insta.model.MySQLiteDoc;

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
    private Button btnNext, btnPre, btnValid;
    private ViewAnimator viewAnimator;
    private Animation slide_in_left, slide_out_right;
    private Contact contact;
    private ContactsDataSource mysql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_layout);
        contact =new Contact();

        deserialiser();

        mysql = new ContactsDataSource(this);

        Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);
        date.updateDate(mYear, mMonth, mDay);

        slide_in_left = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        slide_out_right = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);

        viewAnimator.setInAnimation(slide_out_right);
        viewAnimator.setOutAnimation(slide_in_left);

        btnPre.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                viewAnimator.showPrevious();
            }});

        btnNext.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                viewAnimator.showNext();
            }});

        btnValid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mysql.open();
                setContact(contact);
                mysql.createContact(contact);

                //Intent i = new Intent(ContactActivity.this, Contact2Activity.class);
                //startActivity(i);
                //finish();
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
        btnNext = (Button) findViewById(R.id.btn_next);
        btnPre = (Button) findViewById(R.id.btn_prev);
        btnValid = (Button) findViewById(R.id.btn_valider);
        viewAnimator = (ViewAnimator)findViewById(R.id.viewanimator);
    }

    public Contact setContact(Contact contact){
        contact.setNom(nom.getText().toString());
        contact.setPrenom(prenom.getText().toString());
        contact.setDateNaissance(date.getYear()+"-"+date.getMonth()+"-"+date.getDayOfMonth());
        contact.setEmail(email.getText().toString());
        contact.setAdresse(adresse.getText().toString());
        contact.setVille(ville.getText().toString());
        contact.setCodePostal(codePostal.getText().toString());
        contact.setNumMobile(mob.getText().toString());
        contact.setNumTel(tel.getText().toString());
        return contact;
    }
}
