package com.group6a_inclass08.group6a_inclass08;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {

    EditText fEmail;
    EditText fName;
    EditText fPass;
    EditText fRePass;
    Button fSubmitSignup,fCancelSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        fEmail = (EditText) findViewById(R.id.editTextEmail);
        fName = (EditText) findViewById(R.id.editTextFirstName);
        fPass = (EditText) findViewById(R.id.editTextPassword);
        fRePass = (EditText) findViewById(R.id.editTextConfirmPassword);

        fSubmitSignup = (Button) findViewById(R.id.buttonSignUp);
        fCancelSignup = (Button) findViewById(R.id.buttonCancel);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign_up, menu);
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

    public void signUpOnClick (View aView){

    }

    public void cancelOnClick(View aView){

    }
}
