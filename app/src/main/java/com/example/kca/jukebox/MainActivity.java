package com.example.kca.jukebox;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.Parse;
import com.parse.ParseAnalytics;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enable Local Datastore (parse).
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "9KD0py8rCHOpRrn67pVKGZN1tHKgf1mRS4tOuPvP", "grZ4vGQ7Ydl7W7SnWchhjbyr4oo6zcEabO1dR6Fq");

        //Parse istatistik toplayici kodu
        ParseAnalytics.trackAppOpenedInBackground(new Intent());

        //ornek bi istatistik toplama, parse kullanir
        Map<String, String> dimensions = new HashMap<>();
        // What type of news is this?
        dimensions.put("Time", DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.LONG).format(Calendar.getInstance().getTime()));
        // Send the dimensions to Parse along with the 'read' event
        ParseAnalytics.trackEventInBackground("read", dimensions);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
