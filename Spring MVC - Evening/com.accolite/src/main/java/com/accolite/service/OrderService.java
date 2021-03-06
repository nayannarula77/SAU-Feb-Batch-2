package com.accolite.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.accolite.model.Order;

@Service
public class OrderService {
	
	List<Order> orders = new ArrayList<>();

	 public Order createOrder(Order order) throws Exception {
		    // logic to assign sequence roll numbers
		    
		    orders.add(order);
		    // return "Created Successfully";
		    return order;
		  }
	 
	 public Order getOrderById(int id) {
		    Optional<Order> order =
		        orders.stream().filter(e -> id == e.getId()).findFirst();
		    if (order.isPresent()) {
		      return order.get();
		    } else {
		      return null;
		    }
		  }

	public Order addItem(int id, String item) {
		orders.get(id).addItem(item);
		return orders.get(id);
	}

	public ArrayList<String> getItems(int id) {
		return orders.get(id).getItems();
	}

	public String removeItemFromOrder(int id, String item) {
		// TODO Auto-generated method stub
		Order order=orders.get(id);
		ArrayList<String> olditems=order.getItems();
		ArrayList<String> newitems = new ArrayList<String>();
		
		
		 for (int i = 0; i < olditems.size(); i++) {
		      if(item.equals(olditems.get(i))) {
		    	  continue;
		      }
		      else {
		    	  newitems.add(olditems.get(i));
		      }
		    }
		order.setItems(newitems);
		return "Deleted!";
	}

	public Order updateItem(int id, ArrayList<String> items) {
		Order order = orders.get(id);
		order.setItems(items);
		return order;
	}
	
	
	
}
