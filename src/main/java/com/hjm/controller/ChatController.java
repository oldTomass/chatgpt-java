package com.hjm.controller;

import com.hjm.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChatController {

    @Autowired
    ChatService chatService;

    @PostMapping("chatText")
    public ResponseEntity<String> chatText(String reqText){

        return ResponseEntity.ok(chatService.chatText(reqText));
    }

    @PostMapping("chatImage")
    public ResponseEntity<List<String>> chatImage(String reqImage){
        return ResponseEntity.ok(chatService.chatImage(reqImage));
    }

}
