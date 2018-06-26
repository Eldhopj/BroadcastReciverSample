package com.example.eldho.broadcastreciversample;
/**
 * Aim: This sample code is to create a dynamic broadcast Intent for charger connected and disconnected
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    onChargingBroadCastReceiver mChargingReceiver;
    IntentFilter mChargingIntentFilter;

    TextView chargeConnected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chargeConnected = findViewById(R.id.charge);

        //This intent filter is setup to catch either the device is connected to power or disconnected
        mChargingIntentFilter = new IntentFilter(); // Instantiate intent filter
        mChargingIntentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        mChargingIntentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        //intent filter ends here

        mChargingReceiver = new onChargingBroadCastReceiver(); // Instantiate BroadcastReceiver
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(mChargingReceiver, mChargingIntentFilter); // passing intent filter and the broadcast receiver
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mChargingReceiver); // detaching broadcast intent
    }

    private class onChargingBroadCastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(Intent.ACTION_POWER_CONNECTED)) {
                chargeConnected.setText("Charger Connected");
            } else if (action.equals(Intent.ACTION_POWER_DISCONNECTED)) {
                chargeConnected.setText("Charger Disconnected");
            }
        }
    }
}
