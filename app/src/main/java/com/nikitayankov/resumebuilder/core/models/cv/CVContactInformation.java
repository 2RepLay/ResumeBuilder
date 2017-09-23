package com.nikitayankov.resumebuilder.core.models.cv;

public class CVContactInformation {
    private String email;
    private String phone;

    public CVContactInformation(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }

    String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email;
    }

    String getPhone() {
        return phone;
    }

    void setPhone(String phone) {
        this.phone = phone;
    }
}
