package com.example.osamakhalid.zia_e_raza.ui.calls;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by Osama Khalid on 9/1/2018.
 */

public class CommonCalls {

    public static ProgressDialog createDialouge(Context context, String title, String msg) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setTitle(title);
        progressDialog.setMessage(msg);
        progressDialog.show();
        return progressDialog;
    }
}
