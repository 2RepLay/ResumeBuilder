package com.nikitayankov.resumebuilder.core.debug;

import android.util.Log;

import com.nikitayankov.resumebuilder.BuildConfig;

public class Debug {
    private static final String TAG = Debug.class.getSimpleName();

    public static void Log(String string) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "Log: " + string);
        }
    }

    public static void Error(String string) {
        if (BuildConfig.DEBUG) {
            Log.e(TAG, "Log: " + string);
        }
    }
}
