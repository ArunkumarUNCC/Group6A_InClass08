package com.group6a_inclass08.group6a_inclass08;

import android.provider.CalendarContract;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseUser;

import java.sql.Time;

public class ComposeMessage extends AppCompatActivity {

    static final String fCREATED_BY = "createdBy";
    static final String fMESSAGE = "message";
    static final String fTIME = "time";

    ParseUser fCurrentUser = new ParseUser();
//    ParseObject fParseObj = new ParseObject();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose_message);

        //displaying app icon
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.app_icon);
        fCurrentUser = ParseUser.getCurrentUser();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_compose_message, menu);
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

    public void sendMessageOnClick (View aView){
        TextView lMessageField = (TextView) findViewById(R.id.editTextMessage);

        if(lMessageField.length() > 0){
            fCurrentUser.put(fCREATED_BY, ParseUser.getCurrentUser());
            fCurrentUser.put(fMESSAGE, lMessageField.getText().toString());
        }else
            Toast.makeText(this, "No text entered, message not sent!", Toast.LENGTH_SHORT).show();
    }

    public void refreshOnClick (MenuItem aMenu){

    }
    public void composeOnClick (MenuItem aMenu){

    }
    public void logoutOnClick (MenuItem aMenu){

    }
}
