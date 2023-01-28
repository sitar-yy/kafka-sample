package ru.example.kafka.consumer;

import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Consumer {

    @KafkaListener(topicPartitions = @TopicPartition(topic = "testTopic", partitions = {"2", "3"}))
    public void listen(String payload) {
        log.info("Received Message: " + payload);
    }

    // @KafkaListener(topics = "testTopic")
    // void listener(ConsumerRecord<String, String> record) {
    // log.info(record.key());
    // log.info(record.value());
    // log.info(null, record.partition());
    // log.info(record.topic());
    // log.info(null, record.offset());
}
