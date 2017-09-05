package com.test.packages;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private AppManager appManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appManager = new AppManager(this);

        List<AppInfo> installedApps = appManager.getInstalledApps();
        for (AppInfo installedApp : installedApps) {
            Log.i(TAG, "App: " + installedApp);
        }
    }

}
