package com.arij.configserver;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class WebhookController {

    @PostMapping("/webhook")
    public ResponseEntity<String> webhook() {
        RestClient.create()
                .post()
                .uri("http://localhost:9999/actuator/busrefresh")
                .retrieve()
                .toBodilessEntity();
        return ResponseEntity.ok("refresh envoye");
    }
}