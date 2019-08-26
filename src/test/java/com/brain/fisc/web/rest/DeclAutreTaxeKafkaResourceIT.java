package com.brain.fisc.web.rest;

import com.brain.fisc.DeclAutreTaxeApp;
import com.brain.fisc.service.DeclAutreTaxeKafkaProducer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@EmbeddedKafka
@SpringBootTest(classes = DeclAutreTaxeApp.class)
public class DeclAutreTaxeKafkaResourceIT {

    @Autowired
    private DeclAutreTaxeKafkaProducer kafkaProducer;

    private MockMvc restMockMvc;

    @BeforeEach
    public void setup() {
        DeclAutreTaxeKafkaResource kafkaResource = new DeclAutreTaxeKafkaResource(kafkaProducer);

        this.restMockMvc = MockMvcBuilders.standaloneSetup(kafkaResource)
            .build();
    }

    @Test
    public void sendMessageToKafkaTopic() throws Exception {
        restMockMvc.perform(post("/api/decl-autre-taxe-kafka/publish?message=yolo"))
            .andExpect(status().isOk());
    }
}
