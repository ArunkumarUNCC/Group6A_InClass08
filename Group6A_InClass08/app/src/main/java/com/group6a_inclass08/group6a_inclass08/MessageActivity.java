package com.group6a_inclass08.group6a_inclass08;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.LogOutCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

public class MessageActivity extends AppCompatActivity {

    final String fGOTOMAIN = "android.intent.action.MAIN";
    ListView fMessageList;
    static MessageAdapter adapter;

    static List<ParseObject> userMessages = new ArrayList<ParseObject>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        fMessageList = (ListView) findViewById(R.id.listViewMessages);

        queryMessagess();
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
        userMessages.clear();
        adapter.notifyDataSetChanged();
        queryMessagess();
    }
    public void composeOnClick (MenuItem aMenu){
        Intent intent = new Intent("android.intent.action.COMPOSE");
        startActivity(intent);
    }
    public void logoutOnClick (MenuItem aMenu){
        ParseUser.logOutInBackground(new LogOutCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Intent intent = new Intent(fGOTOMAIN);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    public void queryMessagess(){
        final ParseQuery<ParseObject> messages = ParseQuery.getQuery("Messages");
        messages.include("createdBy");
        messages.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                userMessages = objects;
                adapter = new MessageAdapter(MessageActivity.this, R.layout.message_row, objects);
                fMessageList.setAdapter(adapter);
                adapter.setNotifyOnChange(true);
            }
        });
    }

}
