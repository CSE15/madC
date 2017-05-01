/**
 * Created by Faria huq on 19-Apr-17.
 */
package com.example.android.justjava;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Faria huq on 19-Apr-17.
 */

public class intentservice extends IntentService {

    private final static String tag = "com.example.android.justjava";

    public intentservice()
    {
        super("intentservice");
    }

    @Override
    protected void onHandleIntent(Intent intent)
    {
        Log.i(tag , "STARTED" );
        //this is what service do
    }
}