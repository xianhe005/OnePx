package com.hxh.onepx;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

public class HooliganActivity extends Activity {

    private static HooliganActivity instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        Window window = getWindow();
        window.setGravity(Gravity.START | Gravity.TOP);
        WindowManager.LayoutParams params = window.getAttributes();
        params.x = 0;
        params.y = 0;
        params.width = 1;
        params.height = 1;
        window.setAttributes(params);
    }

    // 开启保活页面
    public static void startHooligan() {
        Intent intent = new Intent(DWApplication.getAppContext(),HooliganActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        DWApplication.getAppContext().startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        instance = null;
    }

    // 关闭保活页面
    public static void killHooligan() {
        if (instance != null) {
            instance.finish();
        }
    }
}
