package com.nikitayankov.resumebuilder.core.models.cv;

import io.realm.RealmObject;

public class CV extends RealmObject {
    private String name;
    private String vacancy;
    private long salary;

    private String email;
    private String phone;

    public Builder getBuilder() {
        return new Builder();
    }

    private class Builder {
        public CV setName(String name) {
            CV.this.name = name;

            return CV.this;
        }

        public CV addContactInformation(CVContactInformation contactInformation) {
            CV.this.email = contactInformation.getEmail();
            CV.this.phone = contactInformation.getPhone();

            return CV.this;
        }

        public CV setVacancy(String vacancy) {
            CV.this.vacancy = vacancy;

            return CV.this;
        }

        public CV setSalary(long salary) {
            CV.this.salary = salary;

            return CV.this;
        }
    }
}
