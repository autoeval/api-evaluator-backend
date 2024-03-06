package com.wellsfargo.api.evaluator.backend.voice.personification.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum VoiceType {
    human("human"),
    AI_Generated("AI-Generated");

    private String value;
    VoiceType(String value) {
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
    public static VoiceType fromValue(String value) {
        for(VoiceType b: VoiceType.values()) {
            if(b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("");
    }
}
