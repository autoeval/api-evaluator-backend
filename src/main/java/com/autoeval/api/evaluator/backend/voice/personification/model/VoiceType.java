package com.autoeval.api.evaluator.backend.voice.personification.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.annotations.SerializedName;

public enum VoiceType {
    human("human"),
    @SerializedName("AI-Generated")
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
