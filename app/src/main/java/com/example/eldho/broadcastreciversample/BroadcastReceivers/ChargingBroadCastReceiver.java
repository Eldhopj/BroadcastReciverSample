package com.example.eldho.broadcastreciversample.BroadcastReceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.eldho.broadcastreciversample.Listener.BroadcastMessageListener;

public class ChargingBroadCastReceiver extends BroadcastReceiver {
    BroadcastMessageListener listener;

    public void setOnReceivedListener(Context context) {
        this.listener = (BroadcastMessageListener) context;
    }

    @Override
    // This method is triggered when ever the event occurs
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction(); // Message from the event
        if (listener != null) {
            if (action != null) {
                if (Intent.ACTION_POWER_CONNECTED.equals(action)) {
                    listener.message("charger Connected");
                }
                else if (Intent.ACTION_POWER_DISCONNECTED.equals(action)) {
                    listener.message("Charger Disconnected");
                }
            }
        }
    }
}
