package com.a2017.dev.insta.insta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;

import static android.view.KeyEvent.KEYCODE_NAVIGATE_PREVIOUS;

/**
 * Created by Telest on 18/04/2017.
 */

public class ContactActivity extends Activity {

    DatePicker dp;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_layout);

        Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        dp = (DatePicker) findViewById(R.id.dp_bd);
        dp.updateDate(mYear, mMonth, mDay);

        next = (Button) findViewById(R.id.btn_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ContactActivity.this, Contact2Activity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
