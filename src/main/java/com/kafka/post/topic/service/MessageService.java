package com.kafka.post.topic.service;

import com.kafka.post.topic.constants.KafkaProperties;
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
        producerProperties.put(KafkaProperties.BOOTSTRAP_SERVERS_KEY, kafkaBootstrapServers);
        producerProperties.put(KafkaProperties.BOOTSTRAP_ACKS_KEY, KafkaProperties.BOOTSTRAP_ACKS_VALUE);
        producerProperties.put(KafkaProperties.BOOTSTRAP_RETRIES_KEY, 0);
        producerProperties.put(KafkaProperties.BOOTSTRAP_BATCH_SIZE_KEY, 16384);
        producerProperties.put(KafkaProperties.BOOTSTRAP_LINGER_MS_KEY, 1);
        producerProperties.put(KafkaProperties.BOOTSTRAP_BUFFER_MEMEORY_KEY, 33554432);
        producerProperties.put(KafkaProperties.BOOTSTRAP_SERIALIZER_KEY, KafkaProperties.BOOTSTRAP_SERIALIZER_VALUE);
        producerProperties.put(KafkaProperties.BOOTSTRAP_SERIALIZER_VALUE_KEY, KafkaProperties.BOOTSTRAP_SERIALIZER_VALUE_VALUE);

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
