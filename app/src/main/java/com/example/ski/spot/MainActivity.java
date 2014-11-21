package com.example.ski.spot;
//adapter code modified from https://github.com/aboudalia/Teamivore
//Thanks Amine! You're the best!
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends Activity {
    GPSTracker gps;

    // the string variable we use for sending messages with intents
    public final static String EXTRA_MESSAGE = "com.example.ski.spot";

    // a list class type must be used when using a list view
    // list items are added to a list view programatically and not through xml
    List<Map<String, String>> momentsList = new ArrayList<Map<String,String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        initData();

        // we need to pick which view we want our context menu to respond to
        // here, we've chosen the list of team names (which in turn applies the context menu to
        // each list item separately)
        registerForContextMenu((ListView) findViewById(R.id.listView));

        // we call this initiList function to fill in our list class variable with our team names
        initList();

        // adapters are what we use to associate the list variable and its contents with the list view
        ListView momentListView = (ListView) findViewById(R.id.listView);
        SimpleAdapter simpleAdpt = new SimpleAdapter(this, momentsList, android.R.layout.simple_list_item_1, new String[] {"moment"}, new int[] {android.R.id.text1});
        momentListView.setAdapter(simpleAdpt);

        // setOnItemClickListener tells the activity what to do when a list item is clicked on
        momentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parentAdapter, View view, int position,
                                    long id) {
                openMomentDetail(id);
            }
        });

        gps = new GPSTracker(MainActivity.this);
        if (gps.canGetLocation()) {
            double latitude = gps.getLatitude();
            double longitude = gps.getLongitude();
        }

    }

    // initList simply adds our team names to the list variable
    // in a real app, this would be where we query our database to retrieve the list of teams, but
    // we can perform some shared preferences data storing for now
    private void initList() {

        List<Moment> moments = SharedPreferencesUtility.getMomentList(this, "moments");

        for(Moment t: moments) {

            momentsList.add(createMoment("moment", t));

        }

    }

    private void initData() {



        List<Moment> momentsList = new ArrayList<Moment>();

        String defaultDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do" +
                " eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam," +
                " quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat." +
                " Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu " +
                "fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in " +
                "culpa qui officia deserunt mollit anim id est laborum.";

        momentsList.add(new Moment("Spotted in the Media Gateway", defaultDescription));
        momentsList.add(new Moment("Ode to my Bro", defaultDescription));
        momentsList.add(new Moment("Big Life Moment", defaultDescription));
        momentsList.add(new Moment("Ready for the event!", defaultDescription));
        momentsList.add(new Moment("Raspy Puck", defaultDescription));
        momentsList.add(new Moment("Ladybug Studios", defaultDescription));
        momentsList.add(new Moment("Fourtwelve", defaultDescription));

        SharedPreferencesUtility.putMomentList(this, "moments", momentsList);

    }

    // this method helps us minimize the amount of repeat calls we need to make in initList to place
    // a team name into out list
    private HashMap<String, String> createMoment(String key, Moment t) {
        HashMap<String, String> moment = new HashMap<String, String>();
        String name = t.getName();
        moment.put(key, name);
        return moment;
    }

    // openTeamDetail is called whenever a list item is clicked on
    // it calls for an intent that starts up the team detail activity and sends the team's id over
    // to the activity with the message variable declared at the top of the activity
    public void openMomentDetail(long id) {
        Intent intent = new Intent(this, MomentDetailActivity.class);
        String message = String.valueOf(id);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    // onCreateOptionsMenu adds the options menu to your activity
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
        else if (id==R.id.action_add){
            Intent intent= new Intent(this, AddActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }






    // onCreateContextMenu associates the context menu found in the menu resources folder with this
    // activity

   /* @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    } */

    // onContextItemSelected tells the activity what to do when a menu item in the context menu is
    // clicked on

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        //AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        int id = item.getItemId();

       /* if (id == R.id.action_favorite) {
            // message that this one is in favorites
            // proceed to add to favorites
            return true;
        }
        else if(id == R.id.action_contact) {
            // initiate an intent to send user to contact activity with this team's email as the
            // data
            return true;
        } */

        return super.onContextItemSelected(item);

    }

   /* public void addMoment() {
        Intent intent = new Intent(this, AddMomentActivity.class);
        startActivity(intent);
    } */

}