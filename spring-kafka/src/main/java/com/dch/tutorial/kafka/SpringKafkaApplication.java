package com.dch.tutorial.kafka;

import com.dch.tutorial.kafka.model.Greeting;
import com.dch.tutorial.kafka.service.MessageListenerService;
import com.dch.tutorial.kafka.service.MessageProducerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * Main application of Spring with Kafka Client and used to start application.
 *
 * @author David.Christianto
 */
@SpringBootApplication
public class SpringKafkaApplication {

    /**
     * Main method to start application.
     *
     * @param args arguments.
     */
    public static void main(String... args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(SpringKafkaApplication.class, args);

        MessageProducerService messageProducerService = context.getBean(MessageProducerService.class);
        MessageListenerService messageListenerService = context.getBean(MessageListenerService.class);

        /*
         * Sending a Hello World message to topic 'test'.
         * Must be recieved by both listeners with group foo
         * and bar with containerFactory fooKafkaListenerContainerFactory
         * and barKafkaListenerContainerFactory respectively.
         * It will also be recieved by the listener with
         * headersKafkaListenerContainerFactory as container factory
         */
        messageProducerService.sendMessage("Hello, World!");
        messageListenerService.latch.await(10, TimeUnit.SECONDS);

        /*
         * Sending message to a topic with 5 partition,
         * each message to a different partition. But as per
         * listener configuration, only the messages from
         * partition 0 and 3 will be consumed.
         */
        for (int i = 0; i < 5; i++) {
            messageProducerService.sendMessageToPartition("Hello To Partitioned Topic!", i);
        }
        messageListenerService.partitionLatch.await(10, TimeUnit.SECONDS);

        /*
         * Sending message to 'filtered' topic. As per listener
         * configuration,  all messages with char sequence
         * 'World' will be discarded.
         */
        messageProducerService.sendMessageToFiltered("Hello Everyone!");
        messageProducerService.sendMessageToFiltered("Hello World!");
        messageListenerService.filterLatch.await(10, TimeUnit.SECONDS);

        /*
         * Sending message to 'greeting' topic. This will send
         * and recieved a java object with the help of
         * greetingKafkaListenerContainerFactory.
         */
        messageProducerService.sendGreetingMessage(new Greeting("Greetings", "World!"));
        messageListenerService.greetingLatch.await(10, TimeUnit.SECONDS);

        context.close();
    }
}
