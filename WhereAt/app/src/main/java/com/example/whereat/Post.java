package com.example.whereat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Post extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post);
        Toolbar toolbar = (Toolbar) findViewById(R.id.post_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void postActivity(View view) {
        Intent intent = new Intent(this, Feed.class);
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
