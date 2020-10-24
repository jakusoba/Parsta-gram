package com.example.parsta_gram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    // Initializes Parse SDK as soon as the application is created
    @Override
    public void onCreate() {
        super.onCreate();

        // Register your parse models
        ParseObject.registerSubclass(Post.class);


        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("yeQcVz0G4X5lqNoxSR8rjQSle30oQFFbBnh2NSdT")
                .clientKey("n17LyEut1KdAiyoxwNYZEEZvqRz0bdQVTPC2uIo8")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
