package com.example.android.justjava;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class listVIEW extends Activity {

    public String[] foods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        Runnable r = new Runnable() {
            @Override
            public void run() {
                // What do you want the thread to do

                synchronized (this) {
                    Bundle appleData = getIntent().getExtras();
                    if (appleData == null) {
                        return;
                    }
                    String applesMessage = appleData.getString("msg");
                    if (applesMessage.equals("firstaid")) {
                        foods = new String[]{"eye", "ham", "tuna", "candy", "meatball", "potato"};
                    } else if (applesMessage.equals("health")) {
                        foods = new String[]{"eye", "potato", "tuna", "candy", "meatball", "ham"};
                    }
                }
            }
        };
        Thread waitThread = new Thread(r);
        waitThread.start();
        ListAdapter buckysAdapter = new CustomAdapter(getBaseContext(),foods);
        ListView buckysListView = (ListView) findViewById(R.id.buckysListView);
        buckysListView.setAdapter(buckysAdapter);

        buckysListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String food = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(listVIEW.this, food, Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getApplicationContext() , details.class);
                        i.putExtra("food" , food);
                        startActivity(i);
                    }
                }
        );

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
           NavUtils.navigateUpTo(this, new Intent(this, Apple.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
