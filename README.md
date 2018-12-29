# BootRestKafka

The purpose of the project is to implement Rest Api by using Spring Boot Application and by using these API's, Users can feed the messages to post it into Kafka Topic.

API's available:

1. /Apis/messageProducer

This API is to get the message from user and post the same into topic named "MessageTopic" by using KafkaTemplate.

2. /Apis/postMessage

This API is to get the message from user and post the same into topic named "MessageTopic" by using KafkaProducer.

Deployment: Tomcat

Application can be deployed using inbuilt tomcat Server with port 9000.

Build Tool: Gradle
