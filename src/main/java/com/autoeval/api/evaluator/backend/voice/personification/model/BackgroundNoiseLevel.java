package com.autoeval.api.evaluator.backend.voice.personification.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum BackgroundNoiseLevel {
    low("low"),
    medium("medium"),
    high("high");
    private String value;
    BackgroundNoiseLevel(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static BackgroundNoiseLevel fromValue(String value) {
        for(BackgroundNoiseLevel b: BackgroundNoiseLevel.values()) {
            if(b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("");
    }
}
