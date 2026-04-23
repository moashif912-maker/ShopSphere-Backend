package org.shopsphere.shopsphere.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@Service
public class ChatService {

    @Value("${groq.api.key}")
    private String apiKey;

    @Value("${groq.api.url}")
    private String apiUrl;

    @Value("${groq.model}")
    private String model;

    public String chat(String userMessage) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(
                MediaType.APPLICATION_JSON);
        headers.set("Authorization",
                "Bearer " + apiKey);

        Map<String, Object> message = new HashMap<>();
        message.put("role", "user");
        message.put("content",
                "You are ShopSphere customer service. " +
                        "Help with orders, products, returns. " +
                        "User says: " + userMessage);

        Map<String, Object> body = new HashMap<>();
        body.put("model", model);
        body.put("messages",
                Collections.singletonList(message));
        body.put("max_tokens", 500);

        HttpEntity<Map<String, Object>> request =
                new HttpEntity<>(body, headers);

        try {
            ResponseEntity<Map> response =
                    restTemplate.postForEntity(
                            apiUrl, request, Map.class);

            Map<String, Object> responseBody =
                    response.getBody();
            List<Map<String, Object>> choices =
                    (List<Map<String, Object>>)
                            responseBody.get("choices");
            Map<String, Object> choice =
                    choices.get(0);
            Map<String, Object> msg =
                    (Map<String, Object>)
                            choice.get("message");
            return (String) msg.get("content");

        } catch (Exception e) {
            System.out.println(
                    "Groq Error: " + e.getMessage());
            return "Sorry, unable to process!";
        }
    }
}