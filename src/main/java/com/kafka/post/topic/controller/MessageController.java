package com.kafka.post.topic.controller;


import com.kafka.post.topic.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Apis")
public class MessageController {

    //Logger logger = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    MessageService service;

    @GetMapping("/messageProducer")
    public String messageProducer(@RequestParam("message") String message) {

        String response = service.send(message);

        return response;
    }

    @GetMapping("/postMessage")
    public String postMessageProducer(@RequestParam("message") String message) {

        String response = service.post(message);

        return response;
    }

    @GetMapping("/test")
    public String testMethod(@RequestParam("message") String message) {

        String response = "Success";

        return response;
    }



}
