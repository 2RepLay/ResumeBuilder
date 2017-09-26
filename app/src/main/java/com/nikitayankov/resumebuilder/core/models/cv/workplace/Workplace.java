package com.nikitayankov.resumebuilder.core.models.cv.workplace;

import android.support.annotation.Nullable;

import io.realm.RealmObject;

public class Workplace extends RealmObject {
    public String positionName;
    public String companyName;
    public Long startOfWork;

    @Nullable
    public Long endOfWork;
}
