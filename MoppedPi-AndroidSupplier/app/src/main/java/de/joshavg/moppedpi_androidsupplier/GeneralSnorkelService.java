package de.joshavg.moppedpi_androidsupplier;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;

/**
 * Created by josha on 06.02.16.
 */
public class GeneralSnorkelService extends AccessibilityService {
    @Override
    protected void onServiceConnected() {
        AccessibilityServiceInfo info = new AccessibilityServiceInfo();

        info.eventTypes = AccessibilityEvent.TYPES_ALL_MASK;
        info.notificationTimeout = 100;
        info.feedbackType = AccessibilityEvent.TYPES_ALL_MASK;
        //info.packageNames = new String[]{
        //        "com.google.adroid.apps.maps"
        //};

        setServiceInfo(info);
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        Log.d("snorkel", String.valueOf(event.getPackageName()));
        Log.d("snorkel", String.valueOf(event.getContentDescription()));
        Log.d("snorkel", event.getEventType() + "type");
        Log.d("snorkel", String.valueOf(event.getAction()) + "action");
        Log.d("snorkel", String.valueOf(event.getRecordCount()) + "recordcount");
    }

    @Override
    public void onInterrupt() {

    }
}
