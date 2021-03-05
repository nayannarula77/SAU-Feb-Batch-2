package com.example.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ConsumerService {

	@KafkaListener(topics = "order-creation")
    public void consumeCreatedOrder(String order) {
        log.info("Consumer consumed : Created Order = {}", order);
    }

    @KafkaListener(topics = "order-shipped")
    public void consumeShippedOrder(String order) {
        log.info("Consumer consumed : Shipped Order = {}", order);
    }
    
}
