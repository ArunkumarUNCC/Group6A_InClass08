package com.group6a_inclass08.group6a_inclass08;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ComposeMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose_message);
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
        TextView lTextField = (TextView) findViewById(R.id.editTextMessage);

        if(lTextField.length() == 0)
            Toast.makeText(this, "No text entered, message not sent!", Toast.LENGTH_SHORT).show();
    }

    public void refreshOnClick (MenuItem aMenu){

    }
    public void composeOnClick (MenuItem aMenu){

    }
    public void logoutOnClick (MenuItem aMenu){

    }
}
