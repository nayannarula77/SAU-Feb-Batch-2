package com.accolite.model;

import java.util.ArrayList;

public class Order {
	private int id,amount;
	private String customername;
	public ArrayList<String> items = new ArrayList<String>();
	
	public void addItem(String item){
        
        items.add(item);
        
    }
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public ArrayList<String> getItems() {
		return items;
	}
	public void setItems(ArrayList<String> items) {
		this.items = items;
	}
	
}
