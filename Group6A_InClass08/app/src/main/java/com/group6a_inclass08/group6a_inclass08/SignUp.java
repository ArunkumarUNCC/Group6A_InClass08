package com.group6a_inclass08.group6a_inclass08;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

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
        final String lName,lEmail,lPassword,lRePass;
        lName = fName.getText().toString();
        lEmail = fEmail.getText().toString();
        lPassword = fPass.getText().toString();
        lRePass = fRePass.getText().toString();

        if(lName.isEmpty()){
            fName.setError("Enter Name");
        }
        if(lEmail.isEmpty()){
            fEmail.setError("Enter Email");
        }
        if (lPassword.isEmpty()){
            fPass.setError("Empty Password");
        }
        if (lRePass.isEmpty()){
            fRePass.setError("Re Enter Password");
        }
        if(!lPassword.equals(lRePass)){
            fPass.setText("");
            fRePass.setText("");
            Toast.makeText(this,"Passwords Mismatch",Toast.LENGTH_SHORT).show();

            return;
        }


        ParseUser lSignupUser = new ParseUser();
        lSignupUser.setEmail(lEmail);
        lSignupUser.setPassword(lPassword);
        lSignupUser.setUsername(lEmail);
        lSignupUser.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {

                    if (e == null) {
                        Toast.makeText(SignUp.this,"Signup Successful",Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        e.printStackTrace();
                        Toast.makeText(SignUp.this,"Email Already exists",Toast.LENGTH_SHORT).show();
                    }

            }
        });


    }

    public void cancelOnClick(View aView){
        finish();
    }
}
