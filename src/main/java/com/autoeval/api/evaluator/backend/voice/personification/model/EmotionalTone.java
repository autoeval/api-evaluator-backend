package com.autoeval.api.evaluator.backend.voice.personification.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EmotionalTone {
    neutral("neutral"),
    happy("happy"),
    sad("sad"),
    angry("angry");

    private String value;
    EmotionalTone(String value) {
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
    public static EmotionalTone fromValue(String value) {
        for(EmotionalTone b: EmotionalTone.values()) {
            if(b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("");
    }
}
