package com.kafka.post.topic.controller;


import com.kafka.post.topic.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Apis")
public class MessageController {

    @Autowired
    private ProducerService producerService;

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
        producerService.sendMessage(message);
        return ResponseEntity.ok("Message sent to kafka topic");
    }
}
