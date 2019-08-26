package com.brain.fisc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DeclAutreTaxeKafkaConsumer {

    private final Logger log = LoggerFactory.getLogger(DeclAutreTaxeKafkaConsumer.class);
    private static final String TOPIC = "topic_declautretaxe";

    @KafkaListener(topics = "topic_declautretaxe", groupId = "group_id")
    public void consume(String message) throws IOException {
        log.info("Consumed message in {} : {}", TOPIC, message);
    }
}
