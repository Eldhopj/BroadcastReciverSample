package com.example.eldho.broadcastreciversample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class StaticBroadcastActivity extends AppCompatActivity {

    /**Register the broadcast receiver in manifest*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_broadcast);
    }
}
