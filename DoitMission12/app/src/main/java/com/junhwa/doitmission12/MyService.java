package com.junhwa.doitmission12;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("Mission12", "Service");
        if(intent == null)
            return Service.START_STICKY;
        else {
            Intent intent1 = new Intent("com.junhwa.doitmission12.SEND_BROAD_CAST");
            intent1.putExtra("string", intent.getStringExtra("string"));
            sendBroadcast(intent1);
        }

        return super.onStartCommand(intent, flags, startId);
    }
}
