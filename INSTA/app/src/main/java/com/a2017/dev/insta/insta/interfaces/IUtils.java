package com.a2017.dev.insta.insta.interfaces;

import android.app.AlertDialog;
import android.content.Context;

/**
 * Created by Telest on 19/04/2017.
 */

public interface IUtils {
    public AlertDialog.Builder dialogBox(Context context, String title, String text);

    public void showToast(Context context, String text);
}
