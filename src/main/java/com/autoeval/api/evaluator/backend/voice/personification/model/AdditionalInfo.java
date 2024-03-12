package com.autoeval.api.evaluator.backend.voice.personification.model;

public class AdditionalInfo {
    private BackgroundNoiseLevel backgroundNoiseLevel;
    private EmotionalTone emotionalTone;

    public BackgroundNoiseLevel getBackgroundNoiseLevel() {
        return backgroundNoiseLevel;
    }

    public void setBackgroundNoiseLevel(BackgroundNoiseLevel backgroundNoiseLevel) {
        this.backgroundNoiseLevel = backgroundNoiseLevel;
    }

    public EmotionalTone getEmotionalTone() {
        return emotionalTone;
    }

    public void setEmotionalTone(EmotionalTone emotionalTone) {
        this.emotionalTone = emotionalTone;
    }

    @Override
    public String toString() {
        return "AdditionalInfo{" +
                "backgroundNoiseLevel=" + backgroundNoiseLevel +
                ", emotionalTone=" + emotionalTone +
                '}';
    }
}
