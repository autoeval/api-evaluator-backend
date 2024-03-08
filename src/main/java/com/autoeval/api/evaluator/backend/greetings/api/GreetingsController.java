package com.autoeval.api.evaluator.backend.greetings.api;

import com.autoeval.api.evaluator.backend.greetings.model.GreetingsRequest;
import com.autoeval.api.evaluator.backend.greetings.model.GreetingsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GreetingsController {

    @GetMapping("/get/hello")
    public ResponseEntity<GreetingsResponse> getHello() {
        GreetingsResponse response = new GreetingsResponse();
        response.setMessage("Hello There!!");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/post/hello")
    public ResponseEntity<GreetingsResponse> postHello(@RequestBody GreetingsRequest request) {
        GreetingsResponse response = new GreetingsResponse();
        response.setMessage("Hello " + request.getName() + "!!");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
