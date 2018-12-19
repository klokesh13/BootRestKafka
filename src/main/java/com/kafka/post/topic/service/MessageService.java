package com.kafka.post.topic.service;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class MessageService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic}")
    private String kafkaTopicName;

    public String send(String message) {

        try{

            kafkaTemplate.send(kafkaTopicName, message);

        }catch(Exception ex) {

            ex.printStackTrace();

            return "Failed to send the message in topic \""+kafkaTopicName+"\"";
        }

        return "Message has been sent successfully to topic \""+kafkaTopicName+"\"";

    }

    // Using Kafka Producer

    @Value("${kafka.bootstrap.servers}")
    private String kafkaBootstrapServers;


    public String post(String message) {

        Properties producerProperties = new Properties();
        producerProperties.put("bootstrap.servers", kafkaBootstrapServers);
        producerProperties.put("acks", "all");
        producerProperties.put("retries", 0);
        producerProperties.put("batch.size", 16384);
        producerProperties.put("linger.ms", 1);
        producerProperties.put("buffer.memory", 33554432);
        producerProperties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producerProperties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(producerProperties);

        try{

            producer.send(new ProducerRecord<>(kafkaTopicName, message));

        }catch(Exception ex) {

            ex.printStackTrace();

            return "Failed to send the message in topic \""+kafkaTopicName+"\"";
        }

        return "Message has been sent successfully to topic \""+kafkaTopicName+"\"";

    }

}
