package com.nikitayankov.resumebuilder.core.workers;

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
    }
}
