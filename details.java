package com.example.android.justjava;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        setmsg();
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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public  void setmsg()
    {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                // What do you want the thread to do

                    synchronized(this){
                        BufferedReader reader = null;
                        StringBuilder text = new StringBuilder();
                        String txt = "p.txt";
                        try {
                            reader = new BufferedReader(
                                    new InputStreamReader(getAssets().open(txt)));

                            // do reading, usually loop until end of file reading
                            String mLine;
                            while ((mLine = reader.readLine()) != null) {
                                text.append(mLine);
                                text.append('\n');
                            }
                        } catch (IOException e) {
                            Toast.makeText(getApplicationContext(),"Error reading file!",Toast.LENGTH_LONG).show();
                            e.printStackTrace();
                        } finally {
                            if (reader != null) {
                                try {
                                    reader.close();
                                } catch (IOException e) {
                                    //log the exception
                                }
                            }

                            TextView det = (TextView) findViewById(R.id.det);
                            det.setText(text);

                        }
                    }

            }
        };

        Thread waitThread = new Thread(r);
        waitThread.start();
    }
}
