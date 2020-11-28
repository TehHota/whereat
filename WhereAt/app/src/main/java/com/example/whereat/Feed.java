package com.example.whereat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Feed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed);
        Toolbar toolbar = (Toolbar) findViewById(R.id.feed_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        String location = "";
        String time = "";
        String description = "";

        Intent intent = getIntent();
        if (intent.hasExtra(Post.LOCATION)) location = intent.getStringExtra(Post.LOCATION);
        if (intent.hasExtra(Post.TIME)) time = intent.getStringExtra(Post.TIME);
        if (intent.hasExtra(Post.DESCRIPTION)) description = intent.getStringExtra(Post.DESCRIPTION);

        TextView locationTV = findViewById(R.id.location1);
        if (location != "") locationTV.setText(location);
        else locationTV.setText(R.string.entry1_location);

        TextView timeTV = findViewById(R.id.time1);
        if (time != "") timeTV.setText(time);
        else timeTV.setText(R.string.entry1_time);

        TextView descriptionTV = findViewById(R.id.description1);
        if (description != "") descriptionTV.setText(description);
        else descriptionTV.setText(R.string.entry1_description);


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void newPostActivity(View view) {
        Intent intent = new Intent(this, Post.class);
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
