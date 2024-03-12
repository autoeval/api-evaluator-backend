package com.autoeval.api.evaluator.backend.voice.personification.model;

public class Analysis {
    private boolean detectedVoice;
    private VoiceType voiceType;
    private ConfidenceScore confidenceScore;
    private AdditionalInfo additionalInfo;

    public boolean isDetectedVoice() {
        return detectedVoice;
    }

    public void setDetectedVoice(boolean detectedVoice) {
        this.detectedVoice = detectedVoice;
    }

    public VoiceType getVoiceType() {
        return voiceType;
    }

    public void setVoiceType(VoiceType voiceType) {
        this.voiceType = voiceType;
    }

    public ConfidenceScore getConfidenceScore() {
        return confidenceScore;
    }

    public void setConfidenceScore(ConfidenceScore confidenceScore) {
        this.confidenceScore = confidenceScore;
    }

    public AdditionalInfo getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(AdditionalInfo additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Override
    public String toString() {
        return "Analysis{" +
                "detectedVoice=" + detectedVoice +
                ", voiceType=" + voiceType +
                ", confidenceScore=" + confidenceScore +
                ", additionalInfo=" + additionalInfo +
                '}';
    }
}
