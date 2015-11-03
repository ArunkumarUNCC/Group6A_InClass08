package com.group6a_inclass08.group6a_inclass08;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

public class MainActivity extends AppCompatActivity {

    ParseObject fParse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize Parse
        Parse.initialize(this, "3HaYVvf3qFMsKrCrh3AjmdfSm1J2LFtQ5ogCg94v", "CuvIH6vAsYF2Sp7zmRAKty12R1MQ2RbKFGBfeSuW");

        fParse = new ParseObject("Login");
        fParse.put("Name","Arun kumar");
        fParse.put("Email","asdsand@gmail.com");
        fParse.put("Password","djasjdk");
        fParse.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e==null)
                    Log.d("Msg","Signup Success");
                else Log.d("Msg","Signup Failed");
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
