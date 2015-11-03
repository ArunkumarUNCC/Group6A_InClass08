package com.group6a_inclass08.group6a_inclass08;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class MainActivity extends AppCompatActivity {

    ParseObject fParse;

    EditText fEmail;
    EditText fPassword;

    Button fLogin,fSignup;

    final String fGOTOSIGNUP = "android.intent.action.SIGNUP";
    final String fGOTOMESSAGE = "android.intent.action.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fEmail = (EditText) findViewById(R.id.editTextEmail);
        fPassword = (EditText) findViewById(R.id.editTextPassword);
        fLogin = (Button) findViewById(R.id.buttonLogIn);
        fSignup = (Button) findViewById(R.id.buttonSignUp);

        ParseUser checkUser = ParseUser.getCurrentUser();
        if (checkUser!=null){
            startMessageActivity();
            finish();
        }

        //displaying app icon
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.app_icon);
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

    public void loginOnClick (View aView){
        String lEmail,lPass;
        lEmail = fEmail.getText().toString();
        lPass = fPassword.getText().toString();

        if(lEmail.isEmpty())
            fEmail.setError("Email cannot be empty");
        if(lPass.isEmpty()) {
            fPassword.setError("Password cannot be empty");
            return;
        }
        ParseUser.logInInBackground(lEmail, lPass, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(e!=null)
                    Toast.makeText(MainActivity.this,"Invalid Details",Toast.LENGTH_SHORT).show();
                else{
                    startMessageActivity();

                }
            }
        });
    }
    public void createAccountOnClick (View aView){
        Intent lSignupIntent = new Intent(fGOTOSIGNUP);
        startActivity(lSignupIntent);
    }
    public void startMessageActivity(){
        Intent intent = new Intent(fGOTOMESSAGE);
        startActivity(intent);
        finish();
    }
}
