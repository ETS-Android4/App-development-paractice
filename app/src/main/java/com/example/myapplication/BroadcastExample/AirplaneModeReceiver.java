package com.example.myapplication.BroadcastExample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class AirplaneModeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (isAirPlaneModeOn(context)){
            Toast.makeText(context,"Airplane Mode is On", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context,"Airplane Mode is Off", Toast.LENGTH_SHORT).show();
        }
    }

    public static boolean isAirPlaneModeOn(Context context){
        return Settings.System.getInt(context.getContentResolver(),
                Settings.Global.AIRPLANE_MODE_ON,0) != 0 ;
    }
}
