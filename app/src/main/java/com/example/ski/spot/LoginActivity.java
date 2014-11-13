//Jing Zhang
package com.example.ski.spot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class LoginActivity extends Activity {

//TODO shared preferences for login activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void logIn(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}

//SharedPreferences mySharedPreferences = getSharedPreferences(MY_PREFS,Activity.MODE_PRIVATE);
//SharedPreferences.Editor.editor = mySharedPreferences.edit();
//editor.apply();
