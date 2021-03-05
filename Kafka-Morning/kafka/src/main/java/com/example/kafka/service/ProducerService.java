package com.example.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import com.example.kafka.model.Order;
@Slf4j
@Component
public class ProducerService {

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  public void createOrder(Order order) {
      String topicName = "order-creation";
      kafkaTemplate.send(topicName, order.toString());
      log.info("Producer: Kafka Order Created  {}", order.toString());
  }

  public void shipOrder(Order order) {
      String topicName = "order-shipped";
      kafkaTemplate.send(topicName, order.toString());
      String msg="Order Id:"+order.getOrderId();
      log.info("Producer: Kafka Order Shipped  {}", msg);
  }
  
  
}
