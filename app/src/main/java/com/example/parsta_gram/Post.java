package com.example.parsta_gram;

import com.parse.Parse;
import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;


@ParseClassName("Post")
public class Post extends ParseObject {
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_USER = "user";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_CREATED_KEY = "createdAt";

    // getter
    public String getDescription(){
        return getString(KEY_DESCRIPTION);

    }
    // setter
    public void setDescription(String description) {
        put(KEY_DESCRIPTION, description);
    }
    // getter
    public ParseFile getImage() {
        return getParseFile(KEY_IMAGE );

    }

    // setter

    public void setImage(ParseFile parseFile) {
        put(KEY_IMAGE, parseFile);

    }

    //getter

    public ParseUser getUser() {
        return getParseUser(KEY_USER);
    }
    // setter
    public void setUser(ParseUser user) {
        put(KEY_USER, user);
    }
}
