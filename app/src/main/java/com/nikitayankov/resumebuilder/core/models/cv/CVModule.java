package com.nikitayankov.resumebuilder.core.models.cv;

import com.nikitayankov.resumebuilder.core.models.cv.achievement.Achievement;
import com.nikitayankov.resumebuilder.core.models.cv.skill.Skill;

import io.realm.annotations.RealmModule;

@RealmModule(classes = {CV.class, Skill.class, Achievement.class})
public class CVModule {

}
