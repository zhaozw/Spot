//Kathy Kosinski
package com.example.ski.spot;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;



public class AddActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void addSound(View view) {
        //open new activity
    }
    public void addPicture(View view) {
        //open a new activity
    }
    public void addLink(View view) {
        //open a new activity
    }
    public void addText(View view) {
        Intent intent = new Intent(this, AddText.class);
        startActivity(intent);
    }
    public void addQuote(View view) {
        //open a new activity
    }
    public void addMovie(View view) {
        //open a new activity
    }
}
