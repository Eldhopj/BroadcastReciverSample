package com.example.eldho.broadcastreciversample.BroadcastReceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class StaticBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) { // This method is triggered when the Broadcast receiver is triggered
        String action = intent.getAction();

        if (Intent.ACTION_BOOT_COMPLETED.equals(action)){
            Toast.makeText(context, "Boot Completed", Toast.LENGTH_SHORT).show();
        }


        //NOTE : this api is deprecated from API level 24 , we have to do it on dynamic broadcast or job scheduler is if we have to do some job when connectivity changes
        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(action)){
            Toast.makeText(context, "Connectivity Changed", Toast.LENGTH_SHORT).show();
        }
    }
}
