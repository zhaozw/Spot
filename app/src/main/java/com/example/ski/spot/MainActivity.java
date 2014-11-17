//Kathy Kosinski
//gps code from:http://www.androidhive.info/2012/07/android-gps-location-manager-tutorial/
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
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
<<<<<<< HEAD
import java.util.HashMap;
import android.text.Html;
import android.widget.Button;
import android.widget.Toast;

=======
import android.location.Criteria;
>>>>>>> FETCH_HEAD


//TODO figure out how to enable a dummy location. then set it so you can run with the dummy location or not

public class MainActivity extends ListActivity {
    private LocationManager locationManager;
    private String provider;
    GPSTracker gps;

    @Override
        public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // storing string resources into Array
        String[] moments = getResources().getStringArray(R.array.moments);

        // Binding resources Array to ListAdapter
        this.setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, R.id.label, moments));

        ListView lv = getListView();

        // listening to single list item on click
        lv.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // selected item
                String product = ((TextView) view).getText().toString();

                // Launching new Activity on selecting single List Item
                Intent i = new Intent(getApplicationContext(), SingleListItem.class);
                // sending data to new activity
                i.putExtra("product", product);
                startActivity(i);

            }
        });

        gps = new GPSTracker(MainActivity.this);
        if(gps.canGetLocation()){
            double latitude = gps.getLatitude();
            double longitude = gps.getLongitude();
        }

/*  not sure whether this code works, so for now I just comment them out
final String providerName = "MyFancyGPSProvider";
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (locationManager.getProvider(providerName) != null) {
            locationManager.removeTestProvider(providerName);
        }
        locationManager.addTestProvider(providerName, true, false, false, false, true, true, true,
                Criteria.POWER_LOW, Criteria.ACCURACY_FINE);
        Location loc = new Location(providerName);
        loc.setLongitude(13);
        loc.setTime(System.currentTimeMillis());
        loc.setLatitude(10);
        locationManager.setTestProviderLocation(providerName, loc);*/


    }




        //IF there are posts from this location, display them


       // if [(Case_A) moments=false]
  //setContentView(R.layout.activity_main);

       // else [(Case_B) moments=true]
  //setContentView(R.layout.activity_main_2);







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


