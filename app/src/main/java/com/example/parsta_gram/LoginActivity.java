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

/** A login screen that offers login via username/password*/

public class LoginActivity extends AppCompatActivity {

    public static final String TAG = "LoginActivity";
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (ParseUser.getCurrentUser() != null) {
            goMainActivity();
        }

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "on Click login button");
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                loginUser(username, password);
            }
        });

    }

    private void loginUser(String username, String password) {
        Log.i(TAG, "Attempting to login user" + username);


        //LOGININBACKGROUND SIGNIFY THIS ACTIVITY IS IN THE BACKGROUND THREAD.
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            //LOGINCALLBACK WILL RETURN A METHOD CALLED DONE WHICH TAKES A PARSEEXCEPTION TO CHECK IF LOGIN E WAS SUCCESSFUL THEN ITS NOT NULL OTHER WISE ITS NULL
            @Override
            public void done(ParseUser user, ParseException e) {
                if(e != null) {
                    //something went wrong.
                    Log.e(TAG, "Issue with login", e);
                    return;

                }

                    //TODO:navigate to the main Activity if the user has signed in properly.
                    goMainActivity();
                    Toast.makeText(LoginActivity.this, "Success!", Toast.LENGTH_SHORT).show();




            }
        });


    }
    //We are calling the new method here goMainActivity, and we are using intent to Switch from this (loginActivity) to MainActivity
    private void goMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();



    }
}

