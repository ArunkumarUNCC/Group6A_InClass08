package com.group6a_inclass08.group6a_inclass08;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.parse.ParseObject;
import com.parse.ParseQuery;

public class MessageActivity extends AppCompatActivity {

    ListView fMessageList;
    static MessageAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        fMessageList = (ListView) findViewById(R.id.listViewMessages);

        ParseQuery<ParseObject> messages = ParseQuery.getQuery("Messages");

//        adapter = new MessageAdapter(this,R.layout.message_row,);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_message, menu);
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

    public void refreshOnClick (MenuItem aMenu){

    }
    public void composeOnClick (MenuItem aMenu){
        Intent intent = new Intent("android.intent.action.COMPOSE");
        startActivity(intent);
    }
    public void logoutOnClick (MenuItem aMenu){

    }
}
