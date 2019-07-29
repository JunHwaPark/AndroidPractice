package com.junhwa.doitmission12;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Date;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("Mission12", "Receive");

        String string = intent.getStringExtra("string");
        sendToActivity(context, string);
    }

    private void sendToActivity(Context context, String string) {
        Intent myIntent = new Intent(context, MainActivity.class);
        myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);
        myIntent.putExtra("string", string);

        context.startActivity(myIntent);
    }
}
