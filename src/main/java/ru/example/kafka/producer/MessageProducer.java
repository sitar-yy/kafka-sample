package ru.example.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MessageProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/send1/{msg}")
    public void sendMessage1(@PathVariable String msg) {
        kafkaTemplate.send("testTopic",1,"key1", msg);
        log.info(msg);
    }

    @GetMapping("/send2/{msg}")
    public void sendMessage2(@PathVariable String msg) {
        kafkaTemplate.send("testTopic",2,"key2", msg);
        log.info(msg);
    }

}