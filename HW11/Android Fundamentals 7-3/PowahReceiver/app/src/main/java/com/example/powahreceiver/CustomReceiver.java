package com.example.powahreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import static com.example.powahreceiver.MainActivity.ACTION_CUSTOM_BROADCAST;

public class CustomReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent){
        String intentAction = intent.getAction();
        if (intentAction != null){
            String toastMessage = "unknown intent action";
            switch (intentAction){
                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMessage = "Power Disconnected!";
                    break;
                case Intent.ACTION_POWER_CONNECTED:
                    toastMessage = "Power Connected!";
                    break;
                case ACTION_CUSTOM_BROADCAST:
                    Bundle extras = intent.getExtras();
                    Integer number = extras.getInt("Numbah");
                    Integer Square = number * number;
                    toastMessage = "Custom Broadcast Received \n Square of the Random number: " + Square;
                    break;
            }
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();

        }
    }
}