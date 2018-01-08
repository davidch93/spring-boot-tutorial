package com.dch.tutorial.kafka.service;

import com.dch.tutorial.kafka.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Message producer service.
 *
 * @author David.Christianto
 */
@Service
public class MessageProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, Greeting> greetingKafkaTemplate;

    @Value(value = "${kafka.topic.default}")
    private String topicName;

    @Value(value = "${kafka.topic.partitioned}")
    private String partitionedTopicName;

    @Value(value = "${kafka.topic.filtered}")
    private String filteredTopicName;

    @Value(value = "${kafka.topic.greeting}")
    private String greetingTopicName;

    /**
     * Method used to send message to server with topic 'test'.
     *
     * @param message Message to send.
     */
    public void sendMessage(String message) {
        kafkaTemplate.send(topicName, message);
    }

    /**
     * Method used to send message to server with topic 'partitioned'.
     *
     * @param message   Message to send.
     * @param partition Number of partition.
     */
    public void sendMessageToPartition(String message, int partition) {
        kafkaTemplate.send(partitionedTopicName, partition, message);
    }

    /**
     * Method used to send message to server with topic 'filtered'.
     *
     * @param message Message to send.
     */
    public void sendMessageToFiltered(String message) {
        kafkaTemplate.send(filteredTopicName, message);
    }

    /**
     * Method used to send message to server with topic 'greeting'.
     *
     * @param greeting Message to send.
     */
    public void sendGreetingMessage(Greeting greeting) {
        greetingKafkaTemplate.send(greetingTopicName, greeting);
    }
}
