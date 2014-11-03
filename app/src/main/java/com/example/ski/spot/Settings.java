//Sylvie Zhang
package com.example.ski.spot;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.graphics.Color;

public class Settings extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.settings, menu);
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

    public void changeColor(View view) {


        RelativeLayout l = (RelativeLayout) findViewById(R.id.layout1);

        if(view.getId() == R.id.testButtonGray){

            l.setBackgroundColor(Color.rgb(96,96,96));
        }
        else if(view.getId() == R.id.testButtonRed){

            l.setBackgroundColor(Color.rgb(128,0,0));
        }

    }

    //public void onToggleClicked(View view) {

        // Is the toggle on?
    //    boolean on = ((toggleButton) view).isChecked();

    //    if (on) {
            // do not login and keep anonymous
    //    } else {
            // re-direct to login page

      //  }
  //  }

}

