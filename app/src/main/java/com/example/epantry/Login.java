/**
 * TODO: save new <User> signup in db, method to check login matches existing, method that blank fields make button disabled
 * test method for creating new login and making sure method returns match
 * test method for successful login to new activity?
 * test method for any blank fields that button is disabled
 */

package com.example.epantry;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    EditText TFloginUsername;
    EditText TFloginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i("Login", "Hello");

//        TFloginUsername = (EditText) findViewById(R.id.TFloginUsername);
//        TFloginPassword = (EditText) findViewById(R.id.TFloginPassword);
    }

    public void onClick(View v) {
        if(v.getId() == R.id.Bsignup) {
                //check if username and password matches to value in database
            Intent i = new Intent(Login.this, Signup.class);
            startActivity(i);
        }
        if(v.getId() == R.id.Blogin) {
            EditText a = (EditText) findViewById(R.id.TFloginUsername);
            String strUser = a.getText().toString();
            EditText b = (EditText) findViewById(R.id.TFloginPassword);
            String strPass = b.getText().toString();
            Intent i = new Intent(Login.this, Home.class);
            i.putExtra("Username", strUser);
            i.putExtra("Password", strPass); //pass values
            startActivity(i);
        }

    }
}
