package com.example.epantry;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends Activity {

    EditText ETusername;
    EditText ETemail;
    EditText ETpassword;
    EditText ETconfirmpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Log.i("Signup", "Hello");

        ETusername = (EditText) findViewById(R.id.TFname);
        ETemail = (EditText) findViewById(R.id.TFemail);
        ETpassword = (EditText) findViewById(R.id.TFpassword);
        ETconfirmpassword = (EditText) findViewById(R.id.TFconfirmpassword);
    }

    public void onSignupClick(View v) {
        if (v.getId() == R.id.Bsignup) {
            String username = ETusername.getText().toString();
            String email = ETemail.getText().toString();
            String password = ETpassword.getText().toString();
            String confirmpassword = ETconfirmpassword.getText().toString();

            if(!email.contains("@.com")) {
                Toast pass = Toast.makeText(Signup.this, "Email must be valid!", Toast.LENGTH_SHORT);
                pass.show();
            }
            if (!password.equals(confirmpassword)) {
                //popup msg
                Toast pass = Toast.makeText(Signup.this, "Passwords don't match!", Toast.LENGTH_SHORT);
                pass.show();
            } else if (password.equals(confirmpassword) && !password.isEmpty()) {
                Intent i = new Intent(Signup.this, Home.class);
                startActivity(i);
            }
        }
    }

}
