FROM openjdk:8
ADD build/libs/KafkaPostMessageTopic-0.0.1-SNAPSHOT.jar boot-docker-rest-kafka.jar
EXPOSE 8086
ENTRYPOINT ["java","-jar","boot-docker-rest-kafka.jar"]