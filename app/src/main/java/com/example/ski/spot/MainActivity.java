//Kathy Kosinski
package com.example.ski.spot;

import android.app.Activity;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.location.LocationManager;
import android.location.LocationListener;
import android.location.Location;
import android.content.Context;
import android.app.FragmentManager;

//TODO figure out how to enable a dummy location. then set it so you can run with the dummy location or not

public class MainActivity extends Activity {
    private LocationManager locationManager;
    private String provider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* FragmentManager fm = getFragmentManager();
        TestDialog testDialog = new TestDialog();
        testDialog.setRetainInstance(true);
        testDialog.show(fm, "fragment_name"); */


        //find GPS location
       // LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
       // Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);

       /* private final LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                longitude = location.getLongitude();
                latitude = location.getLatitude();
            }
        } */

       // lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 10, locationListener);




        //IF there are posts from this location, display them
        /*  scroll view, filled with image buttons, pick up the image that is shared
        possibly save an id with the GPS location keyed in.


        if (Case_A)
  setContentView(R.layout.activity_main);

else if (Case_B)
  setContentView(R.layout.activity_main_2);
         */



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent intent= new Intent(this, Settings.class);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.action_about) {
            Intent intent= new Intent(this, About.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public void addActivity(View view) {
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }



}


