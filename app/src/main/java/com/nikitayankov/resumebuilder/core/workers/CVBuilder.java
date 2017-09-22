package com.nikitayankov.resumebuilder.core.workers;

import com.nikitayankov.resumebuilder.core.models.cv.CV;

public class CVBuilder {
    private CV mCV;

    public CVBuilder() {
        mCV = new CV();
    }

    public CV addVacancy(String vacancy) {
        mCV.setVacancy(vacancy);
        return mCV;
    }

    public CV addSalary(long salary) {
        mCV.setSalary(salary);
        return mCV;
    }
}
