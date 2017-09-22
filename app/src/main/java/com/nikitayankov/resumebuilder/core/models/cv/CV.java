package com.nikitayankov.resumebuilder.core.models.cv;

import io.realm.RealmObject;

public class CV extends RealmObject {
    private String vacancy;
    private long salary;

    public String getVacancy() {
        return vacancy;
    }

    public void setVacancy(String vacancy) {
        this.vacancy = vacancy;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}
