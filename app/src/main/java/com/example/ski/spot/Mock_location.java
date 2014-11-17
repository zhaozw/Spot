package com.example.ski.spot;
//Sylvie Zhang 11/17/2014
//tutorial found here: http://mobiarch.wordpress.com/2012/07/17/testing-with-mock-location-data-in-android/

import android.app.Activity;
import android.location.LocationListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Context;
import android.location.LocationManager;
import android.location.Location;

public class Mock_location extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mock_location);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mock_location, menu);
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
    public class MockLocationProvider {
        String providerName;
        Context ctx;

        public MockLocationProvider(String name, Context ctx) {
            this.providerName = name;
            this.ctx = ctx;

            LocationManager lm = (LocationManager) ctx.getSystemService(
                    Context.LOCATION_SERVICE);
            lm.addTestProvider(providerName, false, false, false, false, false,
                    true, true, 0, 5);
            lm.setTestProviderEnabled(providerName, true);
        }

        public void pushLocation(double lat, double lon) {
            LocationManager lm = (LocationManager) ctx.getSystemService(
                    Context.LOCATION_SERVICE);

            Location mockLocation = new Location(providerName);
            mockLocation.setLatitude(lat);
            mockLocation.setLongitude(lon);
            mockLocation.setAltitude(0);
            mockLocation.setTime(System.currentTimeMillis());
            lm.setTestProviderLocation(providerName, mockLocation);
        }

        public void shutdown() {
            LocationManager lm = (LocationManager) ctx.getSystemService(
                    Context.LOCATION_SERVICE);
            lm.removeTestProvider(providerName);
        }
    }
    public class MainActivity extends Activity {
        MockLocationProvider mock;
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            mock = new MockLocationProvider(LocationManager.NETWORK_PROVIDER, this);

            //Set test location
            mock.pushLocation(-12.34, 23.45);

            LocationManager locMgr = (LocationManager)
                    getSystemService(LOCATION_SERVICE);
            LocationListener lis = new LocationListener() {
                public void onLocationChanged(Location location) {
                    //You will get the mock location
                }

                @Override
                public void onStatusChanged(String s, int i, Bundle bundle) {

                }

                @Override
                public void onProviderEnabled(String s) {

                }

                @Override
                public void onProviderDisabled(String s) {

                }
                //...
            };

            locMgr.requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER, 1000, 1, lis);
        }

        protected void onDestroy() {
            mock.shutdown();
            super.onDestroy();
        }
    }
}
