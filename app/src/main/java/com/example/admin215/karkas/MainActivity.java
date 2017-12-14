package com.example.admin215.karkas;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    Button settingButton, startButton;
    LinearLayout linearLayout;
    final static String COLORSTRING = "Color setting";
    Intent intent;
    int color;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        settingButton = (Button) findViewById(R.id.settings);
        startButton = (Button) findViewById(R.id.start_button);
        linearLayout = (LinearLayout) findViewById(R.id.content_main);
        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
        Intent backIntent = getIntent();
        if(backIntent != null){
            color = backIntent.getIntExtra(COLORSTRING, 0);
            switch (color){
                case 1: linearLayout.setBackgroundColor(Color.rgb(255, 0, 0)); break;
                case 2: linearLayout.setBackgroundColor(Color.rgb(0, 255, 0)); break;
                case 3: linearLayout.setBackgroundColor(Color.rgb(0, 0, 255)); break;
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.findItem(R.id.action_settings).setIntent(new Intent(MainActivity.this, AboutActivity.class));
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
            startActivity(item.getIntent());
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
