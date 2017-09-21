package com.nikitayankov.resumebuilder.core;

import android.app.Application;
import io.realm.Realm;

public class CoreApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
    }
}
