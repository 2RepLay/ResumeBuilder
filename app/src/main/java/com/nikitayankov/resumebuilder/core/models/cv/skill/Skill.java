package com.nikitayankov.resumebuilder.core.models.cv.skill;

import android.support.annotation.Nullable;

import io.realm.RealmObject;

public class Skill extends RealmObject {
    private String title;

    @Nullable
    private Long amountOfExperience;
}
