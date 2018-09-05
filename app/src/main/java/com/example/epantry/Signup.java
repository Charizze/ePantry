/**
 * TODO:
 * test method to make sure it creates new user with login if no match - assertNotNull
 * test method that username field isn't empty
 * test method that it checks password matches confirmed password
 */
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
    Database db = new Database(this);

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

   /* public boolean checkFilledTextFields(String username, String email) {
        boolean valid;
        if (!(username.isEmpty() && email.isEmpty())) {
            valid = true;
            Log.i("Signup", "true");
        } else {
            valid = false;
            Log.i("Signup", "false");
        }
        return valid;
    }*/

    public void onSignupClick(View v) {
        if (v.getId() == R.id.Bsignup) {
            String username = ETusername.getText().toString();
            String email = ETemail.getText().toString();
            String password = ETpassword.getText().toString();
            String confirmpassword = ETconfirmpassword.getText().toString();

            if (!email.contains("@.com")) {
                Toast pass = Toast.makeText(Signup.this, "Email must be valid!", Toast.LENGTH_SHORT);
                pass.show();
            }
            if (!password.equals(confirmpassword)) {
                //popup msg
                Toast pass = Toast.makeText(Signup.this, "Passwords don't match!", Toast.LENGTH_SHORT);
                pass.show();
            }
            if (password.equals(confirmpassword) && !password.isEmpty() && !(username.isEmpty() && email.isEmpty())) {

                User user = new User(username, email, password);
                db.addUser(user);

                    Log.i("Signup", "Confirmed login");
                    Intent i = new Intent(Signup.this, Home.class);
                    startActivity(i);
            }
        }
    }

}
