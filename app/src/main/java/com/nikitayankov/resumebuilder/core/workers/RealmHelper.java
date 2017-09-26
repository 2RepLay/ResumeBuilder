package com.nikitayankov.resumebuilder.core.workers;

import com.nikitayankov.resumebuilder.core.models.cv.CVModule;
import com.nikitayankov.resumebuilder.core.models.user.UserModule;

import io.realm.RealmConfiguration;

public class RealmHelper {

    public static class Config {
        public static RealmConfiguration getUserConfig() {
            return new RealmConfiguration.Builder()
                    .name("user.realm")
                    .modules(new UserModule())
                    .build();
        }

        public static RealmConfiguration getCVConfig() {
            return new RealmConfiguration.Builder()
                    .name("cv.realm")
                    .modules(new CVModule())
                    .build();
        }
    }
}
