package com.example.eldho.broadcastreciversample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class StaticBroadcastActivity extends AppCompatActivity {

    /**
     * Register the broadcast receiver in manifest
     * Note : most of the broadcast event wont work from android N and O, only the less frequent one and important
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_broadcast);
    }
}
