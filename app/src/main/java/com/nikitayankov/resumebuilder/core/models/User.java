package com.nikitayankov.resumebuilder.core.models;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.RealmModule;

public class User extends RealmObject {
    private String name;
    private String surname;

    private int age;

    @Ignore
    private int sessionId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }
}
