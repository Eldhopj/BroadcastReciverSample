package com.example.eldho.broadcastreciversample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Broadcast receivers are an android app component which we can lesson to different system events like device boot up, sms, charging etc.... every system event will send broadcast
 * Not only the system can send broadcast, app broadcast messages to other app or with in the app
 */


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void staticBroadcast(View view) {
        Intent intent = new Intent(getApplicationContext(), DynamicBroadcastActivity.class);
        startActivity(intent);
    }

    public void dynamicBroadcast(View view) {
        Intent intent = new Intent(getApplicationContext(), StaticBroadcastActivity.class);
        startActivity(intent);
    }
}
