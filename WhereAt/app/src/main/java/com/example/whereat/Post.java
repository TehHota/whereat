package com.example.whereat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Post extends AppCompatActivity {

    public static final String LOCATION = "com.example.whereat.LOCATION";
    public static final String TIME = "com.example.whereat.TIME";
    public static final String END_TIME = "com.example.whereat.END_TIME";
    public static final String DESCRIPTION = "com.example.whereat.DESCRIPTION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post);
        Toolbar toolbar = (Toolbar) findViewById(R.id.post_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void postActivity(View view) {
        Intent intent = new Intent(this, Feed.class);
        EditText locationText = (EditText) findViewById(R.id.locationText);
        String location = locationText.getText().toString();
        intent.putExtra(LOCATION, location);
        EditText timeText = (EditText) findViewById(R.id.timeText);
        String time = timeText.getText().toString();
        intent.putExtra(TIME, time);
        EditText endTimeText = (EditText) findViewById(R.id.endTimeText);
        String endTime = endTimeText.getText().toString();
        intent.putExtra(END_TIME, endTime);
        EditText descriptionText = (EditText) findViewById(R.id.descriptionText);
        String description = descriptionText.getText().toString();
        intent.putExtra(DESCRIPTION, description);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.Settings) {
            settingsActivity();
            return true;
        }
        else return super.onOptionsItemSelected(item);
    }

    public void settingsActivity() {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

}
