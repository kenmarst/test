package com.example.noen.activitydatapass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends PreferenceActivity {

    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ///建立建立Button
        Button Button = (Button)findViewById(R.id.ButtonMain);//xml
        Button.setOnClickListener(new Button.OnClickListener() {//監聽

            @Override
            public void onClick(View v) {

                //建立TextView 並 取得輸入字串
                EditText TextMain = (EditText)findViewById(R.id.TextMain);//xml
                Editable NameMain;//Text
                NameMain = TextMain.getText();//Text
                String name = NameMain.toString();//String

                Log.d(TAG,"NameMain = " + name);

                /* 開始傳遞 MainActivity -> SubActivity */

                //1.new一個intent物件，指定Activity切換的class
                Intent intent = new Intent();//建立
                intent.setClass(MainActivity.this, SubActivity.class);//MainActivity -> SubActivity

                //2.傳遞資料
                Bundle bundle = new Bundle();//建立
                bundle.putString("NameMain", name);//**
                //**對應SubActivity 的 String NumberMain = BundleMain.getString("StrName");

                //3.將Bundle物件assign給intent
                intent.putExtras(bundle);

                //4.切換到到SubActivity
                startActivity(intent);


            }

        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
