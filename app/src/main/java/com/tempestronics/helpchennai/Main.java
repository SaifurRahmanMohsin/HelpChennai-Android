package com.tempestronics.helpchennai;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;

/**
 * Created by Moz on 02/12/15.
 */
public class Main extends Base {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(Main.this);
                alert.setTitle("About / Suggestions");
                alert.setMessage("I am a freelance Android dev. I currently work on projects for other clients. I made this app out of self interest to see if it may help someone. There is no intension to make money out of this via ads nor other means. It's purely non-profit. If you have any suggestions kindly email me at mohsin92@me.com");
                alert.setPositiveButton("OK", null);
                alert.show();
            }
        });
    }
}
