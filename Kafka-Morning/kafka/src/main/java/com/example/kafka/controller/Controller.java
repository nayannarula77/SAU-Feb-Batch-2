package com.example.kafka.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.kafka.service.ProducerService;
import lombok.extern.slf4j.Slf4j;
import com.example.kafka.model.Order;
@RestController
@CrossOrigin("*")
@Slf4j
public class Controller {

  @Autowired
  private ProducerService producerService;

  
  private HashMap<Integer, Order> orders = new HashMap<>();
  private int lastGivenOrderId = 0;

  @PostMapping(value = "/create-order")
  public ResponseEntity<Order> produceNewOrder(@RequestBody Order order) {
      order.setOrderId(++lastGivenOrderId);
      producerService.createOrder(order);
      orders.put(lastGivenOrderId, order);
      return new ResponseEntity(order, HttpStatus.CREATED);
  }

  @GetMapping(value = "/ship-order/{orderId}")
  public ResponseEntity<Order> produceNewShippingOrder(@PathVariable(required = true, name = "orderId") int orderId) {
	  
      if(orders.containsKey(orderId)) {
          producerService.shipOrder(orders.get(orderId));
          Order tempOrder = orders.get(orderId);
          orders.remove(orderId);
          return new ResponseEntity(tempOrder, HttpStatus.OK);
      }
      else{
          return new ResponseEntity(null, HttpStatus.NOT_FOUND);
      }
  }

}
