package com.wellsfargo.api.evaluator.backend.voice.personification.api;

import com.wellsfargo.api.evaluator.backend.voice.personification.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class VoiceApiController {

    @PostMapping(
            value = "/voice/analyze",
            produces = {"application/json"},
            consumes = {"multipart/form-data"}
    )
    public ResponseEntity<VoiceApiResponse> analyzeVoice(@RequestPart(value = "file")MultipartFile file, @RequestPart(value = "field1", required = false) String field1) {
        if(file != null && file.getOriginalFilename().endsWith("ai1.mp3")) {
            return new ResponseEntity<>(getSampleAI_Response(), HttpStatus.OK);
        } else if(file != null && file.getOriginalFilename().endsWith("human1.mp3")) {
            return new ResponseEntity<>(getSampleHuman_Response(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    private VoiceApiResponse getSampleAI_Response() {
        VoiceApiResponse response = new VoiceApiResponse();
        response.setResponseTime(Long.valueOf(1234));
        response.setStatus("AI_OK");
        Analysis analysis = new Analysis();
        analysis.setDetectedVoice(true);
        analysis.setVoiceType(VoiceType.AI_Generated);

        AdditionalInfo additionalInfo = new AdditionalInfo();
        additionalInfo.setBackgroundNoiseLevel(BackgroundNoiseLevel.low);
        additionalInfo.setEmotionalTone(EmotionalTone.neutral);
        analysis.setAdditionalInfo(additionalInfo);

        ConfidenceScore confidenceScore = new ConfidenceScore();
        confidenceScore.setAiProbability(0.8678912);
        confidenceScore.setHumanProbability(0.1678912);
        analysis.setConfidenceScore(confidenceScore);

        response.setAnalysis(analysis);
        return response;
    }

    private VoiceApiResponse getSampleHuman_Response() {
        VoiceApiResponse response = new VoiceApiResponse();
        response.setResponseTime(Long.valueOf(1234));
        response.setStatus("HUMAN_OK");
        Analysis analysis = new Analysis();
        analysis.setDetectedVoice(true);
        analysis.setVoiceType(VoiceType.human);

        AdditionalInfo additionalInfo = new AdditionalInfo();
        additionalInfo.setBackgroundNoiseLevel(BackgroundNoiseLevel.low);
        additionalInfo.setEmotionalTone(EmotionalTone.neutral);
        analysis.setAdditionalInfo(additionalInfo);

        ConfidenceScore confidenceScore = new ConfidenceScore();
        confidenceScore.setAiProbability(0.243210);
        confidenceScore.setHumanProbability(0.8678912);
        analysis.setConfidenceScore(confidenceScore);

        response.setAnalysis(analysis);
        return response;
    }
}
