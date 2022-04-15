package com.kafka.controller;

import com.kafka.dto.KafkaMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/kafka")
@RequiredArgsConstructor
public class KafkaController {

    @Value("${kafkaexample.kafka.topic}")
    private String topic;

    private final KafkaTemplate<String, KafkaMessage> kafkaTemplate;

    @PostMapping
    private void sendMessage(@RequestBody KafkaMessage kafkaMessage) {
        kafkaTemplate.send(topic, UUID.randomUUID().toString(),kafkaMessage);
    }

}
