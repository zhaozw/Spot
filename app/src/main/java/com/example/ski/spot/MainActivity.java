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
import android.widget.Toast;

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
        testDialog.show(fm, "TestDialog");

        //Location manager to obtain gps
        LocationManager mlocManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);

        LocationListener mlocListener = new MyLocationListener();
        mlocManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 0, mlocListener);

        //find GPS location
        public class MyLocationListener implements LocationListener {
            @Override
            public void onLocationChanged(Location loc) {
                loc.getLatitude();
                loc.getLongitude();
            }
            @Override
            public void onStatusChanged(String provider, int status, Bundle extras){
            }
        }*/
      /* double longitude=0.0;
       double latitude=0.0;

       LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
       Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
         longitude = location.getLongitude();
        latitude = location.getLatitude();

       private final LocationListener locationListener = new LocationListener() {
           public void onLocationChanged(Location location) {
               longitude = location.getLongitude();
               latitude = location.getLatitude();
           }

           on

           @Override
           public void onStatusChanged(String s, int i, Bundle bundle) {

           }
       }

        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 10, locationListener); */



        //IF there are posts from this location, display them


       // if [(Case_A) moments=false]
  //setContentView(R.layout.activity_main);

       // else [(Case_B) moments=true]
  //setContentView(R.layout.activity_main_2);




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


