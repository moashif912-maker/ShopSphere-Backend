package org.shopsphere.shopsphere.controller;

import org.shopsphere.shopsphere.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
        import java.util.Map;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("/ask")
    public ResponseEntity<Map<String, String>> ask(
            @RequestParam String message) {
        String reply = chatService.chat(message);
        return ResponseEntity.ok(
                Map.of("reply", reply));
    }
}