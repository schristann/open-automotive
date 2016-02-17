package de.joshavg.moppedpi_androidsupplier;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;

import java.lang.reflect.Field;

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
        if(!String.valueOf(event.getPackageName()).equals("com.google.android.apps.maps")) {
            return;
        }

        Log.d("snorkel", String.valueOf(event.getPackageName()));
        Log.d("snorkel", String.valueOf(event.getContentDescription()));
        //Log.d("snorkel", String.valueOf(event.getAction()) + "action");
        Log.d("snorkel", String.valueOf(event.getRecordCount()) + " recordcount");

        logConstantName(event.getEventType(), event);
        logConstantName(event.getAction(), event);
        logConstantName(event.getContentChangeTypes(), event);
    }

    private void logConstantName(int value, AccessibilityEvent event) {
        Field[] fields = AccessibilityEvent.class.getDeclaredFields();
        for(Field field : fields) {
            try {
                int fieldValue = field.getInt(event);
                if(fieldValue == value) {
                    Log.d("snorkel",field.getName());
                }
            } catch (Exception e) {
                // noop
            }
        }
    }

    @Override
    public void onInterrupt() {

    }
}
