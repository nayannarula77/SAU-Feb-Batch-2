package com.example.kafka.model;

public class Order {
private int OrderId, Quantity;
private String OrderType, OrderCreationDate;
public int getOrderId() {
	return OrderId;
}
public void setOrderId(int orderId) {
	OrderId = orderId;
}
public int getQuantity() {
	return Quantity;
}
public void setQuantity(int quantity) {
	Quantity = quantity;
}
public String getOrderType() {
	return OrderType;
}
public void setOrderType(String orderType) {
	OrderType = orderType;
}
public String getOrderCreationDate() {
	return OrderCreationDate;
}
public void setOrderCreationDate(String orderCreationDate) {
	OrderCreationDate = orderCreationDate;
}

@Override
public String toString() {
    return "Order= {" +
            "Order Id: " + OrderId +
            ", Quantity: " + Quantity +
            ", Order Type: " + OrderType +
            ", Order Creation Date: " + OrderCreationDate  +
            "}";
}

}
