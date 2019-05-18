package com.scrapbook.com.scrapbook.enums;

public enum Gender {
    M("male"), F("female");

    private String genderString;

    Gender(String genderString) {
        this.genderString = genderString;
    }

    public String getGenderString() {
        return genderString;
    }

    public Gender setGenderString(String genderString) {
        this.genderString = genderString;
        return this;
    }
}
