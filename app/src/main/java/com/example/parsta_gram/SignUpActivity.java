package com.example.parsta_gram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

/** A login screen that offers login via username/password*/

public class SignUpActivity extends AppCompatActivity {

    public static final String TAG = "SignUpActivity";
    private EditText etEmail;
    private EditText etUsername;
    private EditText etPassword;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);



        etEmail = findViewById(R.id.etEmail);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "on Click sign up button");
                String email = etEmail.getText().toString();
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                signUpUser(email, username, password);

                ParseUser user = new ParseUser();
// Set core properties
                user.setUsername("joestevens");
                user.setPassword("secret123");
                user.setEmail("email@example.com");
// Set custom properties
                user.put("phone", "650-253-0000");
                // Invoke signUpInBackground
                user.signUpInBackground(new SignUpCallback() {
                    public void done(ParseException e) {
                        if(e == null) {
                            //TODO:navigate to the login Activity if the user has signed in properly.
                            goLoginActivity();
                            Toast.makeText(SignUpActivity.this, "Success!", Toast.LENGTH_SHORT).show();

                        } else {
                            //something went wrong.
                            Log.e(TAG, "Issue with sign up", e);
                            return;
                        }






                    }
                });
            }
        });

    }



    private void signUpUser(String email, String username, String password) {
        Log.i(TAG, "Attempting create account" + username + email + password) ;

    }
    //We are calling the new method here goMainActivity, and we are using intent to Switch from this (loginActivity) to MainActivity
    private void goLoginActivity() {
        Intent a = new Intent(this, LoginActivity.class);
        startActivity(a);
        finish();




    }
}

