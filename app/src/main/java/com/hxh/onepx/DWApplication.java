package com.hxh.onepx;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/**
 * Created by HXH on 2017/7/12 0012.
 */
public class DWApplication extends Application {

    private static DWApplication sApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        registerReceiver(new BootCompleteReceiver(), filter);
    }

    public static Context getAppContext() {
        return sApplication;
    }

    private class BootCompleteReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            System.out.println("action:" + action);
            if (action.equals(Intent.ACTION_SCREEN_OFF)) {
                HooliganActivity.startHooligan();
            } else if (action.equals(Intent.ACTION_SCREEN_ON)) {
                HooliganActivity.killHooligan();
            }
        }
    }
}
