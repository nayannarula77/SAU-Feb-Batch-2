package com.accolite.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.model.Order;
import com.accolite.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

  @Autowired
  OrderService orderService;

  @PostMapping("/createorder")
  public ResponseEntity<Order> createOrder(@RequestBody Order order) throws Exception {
    System.out.println("Order created: " + order);
    Order response = orderService.createOrder(order);
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @GetMapping("/get/{id}")
  public ResponseEntity<Order> getStudentById(@PathVariable("id") int id) {
    Order order = orderService.getOrderById(id);
    if (order == null) {
      return new ResponseEntity<>(order, HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(order, HttpStatus.OK);
  }

  @PostMapping("/additems/{id}")
  public ResponseEntity<Order> addItem(@PathVariable(required = true, name = "id") int id, @RequestBody String item) {
	  return new ResponseEntity(this.orderService.addItem(id, item), HttpStatus.CREATED);
  }

  @GetMapping({"/items/{id}"})
  public ResponseEntity<ArrayList<String>> getItems(@PathVariable(required = true, name = "id") int id) {
      
      return new ResponseEntity(this.orderService.getItems(id), HttpStatus.OK);
  }
  
  @DeleteMapping({"/deleteItem/{id}/{item}"})
  public ResponseEntity<String> deleteItemFromOrder(@PathVariable(required = true, name = "id") int id, @PathVariable(required = true, name = "item") String item) {
      
      return new ResponseEntity(this.orderService.removeItemFromOrder(id, item), HttpStatus.OK);
  }
  
  
  
  @PutMapping({"/updateItems/{id}"})
  public ResponseEntity<Order> updateItem(@PathVariable(required = true,name = "id") int id, @RequestBody ArrayList<String> items) {
     
          return new ResponseEntity(this.orderService.updateItem(id, items), HttpStatus.OK);
      
  }
  
  
  
}
