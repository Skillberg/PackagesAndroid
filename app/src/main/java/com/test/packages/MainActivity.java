package com.test.packages;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "Debug!");
        Log.w(TAG, "Warning!");
        Log.v(TAG, "Verbose!");
        Log.i(TAG, "Info!");
        Log.e(TAG, "ERROR!");
        Log.wtf(TAG, "WTF???!");
    }

}
