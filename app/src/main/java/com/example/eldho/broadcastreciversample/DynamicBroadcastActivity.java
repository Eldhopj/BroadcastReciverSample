package com.example.eldho.broadcastreciversample;
/**
 * This sample code is to create a dynamic broadcast Intent for charger connected and disconnected
 * Life of dynamic broadcast is same as the context of the activity
 */

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.eldho.broadcastreciversample.BroadcastReceivers.ChargingBroadCastReceiver;
import com.example.eldho.broadcastreciversample.Listener.BroadcastMessageListener;

public class DynamicBroadcastActivity extends AppCompatActivity implements BroadcastMessageListener {
    private static final String TAG = "DynamicBroadcast";
    ChargingBroadCastReceiver mChargingReceiver;
    IntentFilter intentFilter;

    TextView chargeConnected;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_dynamic);

        chargeConnected = findViewById(R.id.charge);

        //This intent filter is setup to catch either the device is connected to power or disconnected
        intentFilter = new IntentFilter(); // Instantiate intent filter
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        //intent filter ends here

        mChargingReceiver = new ChargingBroadCastReceiver(); // Instantiate BroadcastReceiver
        mChargingReceiver.setOnReceivedListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(mChargingReceiver, intentFilter); // passing intent filter and the broadcast receiver
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mChargingReceiver); // detaching broadcast intent
    }

    @Override
    public void message(String message) {
        Log.d(TAG, "message from broadcast: " + message);
        chargeConnected.setText(message);
    }
}
