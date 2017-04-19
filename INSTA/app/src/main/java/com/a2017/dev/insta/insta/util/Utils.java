package com.a2017.dev.insta.insta.util;

import android.app.AlertDialog;
import android.content.Context;
import android.widget.Toast;

import com.a2017.dev.insta.insta.interfaces.IUtils;

/**
 * Created by Telest on 19/04/2017.
 */

public class Utils implements IUtils {

    private boolean state = false;

    @Override
    public AlertDialog.Builder dialogBox(Context context, String title, String text) {
        AlertDialog.Builder a = new AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(text)
            .setIcon(android.R.drawable.ic_dialog_alert);

        return a;
    }

    @Override
    public void showToast(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }
}
