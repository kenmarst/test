package com.example.noen.activitydatapass;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;


public class SubActivity extends Activity {

    private final String TAG = "SubActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        Log.d(TAG,"onCreate");

        Bundle BundleMain =this.getIntent().getExtras();
        String name = BundleMain.getString("NameMain");
        Log.d(TAG,"NameMain = " + name);

        TextView SubText = (TextView)findViewById(R.id.subtext);
        SubText.setText("The Name From Main is " + name);

    }
/*
    private String format(double num) {
        NumberFormat formatter = new DecimalFormat("0.00");
        String s = formatter.format(num);
        return s;
    }
*/
}
