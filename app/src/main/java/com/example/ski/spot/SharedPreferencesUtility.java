package com.example.ski.spot;

/**
 * Created by kathy on 11/20/14.
 *
 * code modified from Amine Boudalia: https://github.com/aboudalia/Teamivore
 */
import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

// Shared preferences has no methods that allow us to save lists of strings
// through a bit of string manipulation, we can create our own utility class that allows us to do that

public class SharedPreferencesUtility {

    public static List<Moment> getMomentList(Activity activity, String key) {

        List<Moment> list = new ArrayList<Moment>();

        // grab the preferences associated with the activity passed into this method
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        String listString = preferences.getString(key, "");

        if(listString.length() != 0) {

            String[] moments = listString.split(";;");

            // loop through teams
            for (String t : moments) {

                String[] momentAttributes = t.split(";");

                String name = momentAttributes[0];
                String description = momentAttributes[1];
                Moment newMoment = new Moment(name, description);

                list.add(newMoment);

            }

        }

        return list;

    }

    public static void putMomentList(Activity activity, String key, List<Moment> list) {

        List<String> tempList = new ArrayList<String>();

        for(Moment t: list) {

            String tempMomentString = t.getName() + ";" +
                    t.getDescription();

            tempList.add(tempMomentString);

        }

        String listString = TextUtils.join(";;", tempList);

        myPutString(activity, key, listString);

    }

    public static List<String> getStringList(Activity activity, String key) {

        List<String> list = new ArrayList<String>();

        // grab the preferences associated with the activity passed into this method
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        String listString = preferences.getString(key, "");

        if(listString.length() != 0) {

            // string.split will create an array returning everything in between the provided "delimiter"
            // parameter

            // example: if the string is hello;world;!, calling split(";") on it would return an array
            // with 3 items: "hello", "world", and "!"

            String[] items = listString.split(";");

            // loop through the array and add it to a list so we can give it back to the method caller
            for (String i : items) {
                list.add(i);
            }

        }

        return list;

    }

    public static void putStringList(Activity activity, String key, List<String> list) {

        // for each string in the list, we want to add it to a new variable and separate the strings
        // by putting semicolons in between them

        // TextUtils.join takes a list or array of objects and places them into one string separated
        // by the string in the first parameter (semicolon in this case)

        String listString = TextUtils.join(";", list);

        // save the new combined string into preferences
        myPutString(activity, key, listString);

    }

    // utility that wraps together the sharedpreferences call into one method
    private static void myPutString(Activity activity, String key, String value) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();

    }

}