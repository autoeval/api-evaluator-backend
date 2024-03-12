package com.autoeval.api.evaluator.backend.voice.personification.model;

public class ConfidenceScore {
    private double aiProbability;
    private double humanProbability;

    public double getAiProbability() {
        return aiProbability;
    }

    public void setAiProbability(double aiProbability) {
        this.aiProbability = aiProbability;
    }

    public double getHumanProbability() {
        return humanProbability;
    }

    public void setHumanProbability(double humanProbability) {
        this.humanProbability = humanProbability;
    }

    @Override
    public String toString() {
        return "ConfidenceScore{" +
                "aiProbability=" + aiProbability +
                ", humanProbability=" + humanProbability +
                '}';
    }
}
