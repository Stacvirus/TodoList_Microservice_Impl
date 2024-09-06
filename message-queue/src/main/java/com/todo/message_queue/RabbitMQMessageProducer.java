package com.todo.message_queue;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class RabbitMQMessageProducer {
    private final RabbitTemplate rabbitTemplate;

    public void publish(Object payload, String exchange, String routingKey) {
        log.info("Publishing to {} using routingkey {}. Payload: {}", exchange, routingKey, payload);
        rabbitTemplate.convertAndSend(exchange, routingKey, payload);
        log.info("Published to {} using routingkey {}. Payload: {}", exchange, routingKey, payload);
    }
}
