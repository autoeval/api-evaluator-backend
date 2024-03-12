package com.autoeval.api.evaluator.backend.voice.personification.api;

import com.autoeval.api.evaluator.backend.voice.personification.model.VoiceApiResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

@RestController
@RequestMapping("/api/pass")
public class VoiceApiControllerPass {
    private static final Logger LOGGER = LoggerFactory.getLogger(VoiceApiControllerPass.class);

    @Value("classpath:responses_all_pass.json")
    private Resource res;

    @PostMapping(
            value = "/voice/analyze",
            produces = {"application/json"},
            consumes = {"multipart/form-data"}
    )
    public ResponseEntity<VoiceApiResponse> analyzeVoice(@RequestPart(value = "file")MultipartFile file/*, @RequestPart(value = "field1", required = false) String field1*/) throws IOException {
        Gson gson = new Gson();
        Map<String, VoiceApiResponse> responseMap = gson.fromJson(Files.readString(Paths.get(res.getURI())), new TypeToken<Map<String, VoiceApiResponse>>() {}.getType());
        final String fileName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("/")+1);
        VoiceApiResponse response = responseMap.get(fileName);

        LOGGER.info("Response for {} is {}", fileName, response.toString());

        if(response != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
