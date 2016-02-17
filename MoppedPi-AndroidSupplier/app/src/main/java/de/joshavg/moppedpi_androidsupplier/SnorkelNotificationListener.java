package de.joshavg.moppedpi_androidsupplier;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by josha on 13.02.16.
 */
public class SnorkelNotificationListener extends NotificationListenerService {

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        String packageName = sbn.getPackageName();
        if(!packageName.equals("com.google.android.apps.maps")) {
            //return;
        }

        Log.i("snorkel","**********  onNotificationPosted");
        Log.i("snorkel","ID :" + sbn.getId() + "\t" + sbn.getNotification().tickerText + "\t" + sbn.getPackageName());

        //Log.d("snorkel", "key " + sbn.getKey());
        //Log.d("snorkel", "tag " + sbn.getTag());
        //Log.d("snorkel", "id  " + sbn.getId());
        //Log.d("snorkel", "s   " + sbn.getNotification().toString());
    }

}
