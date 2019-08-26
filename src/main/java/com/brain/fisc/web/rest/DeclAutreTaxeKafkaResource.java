package com.brain.fisc.web.rest;

import com.brain.fisc.service.DeclAutreTaxeKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/decl-autre-taxe-kafka")
public class DeclAutreTaxeKafkaResource {

    private final Logger log = LoggerFactory.getLogger(DeclAutreTaxeKafkaResource.class);

    private DeclAutreTaxeKafkaProducer kafkaProducer;

    public DeclAutreTaxeKafkaResource(DeclAutreTaxeKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.sendMessage(message);
    }
}
