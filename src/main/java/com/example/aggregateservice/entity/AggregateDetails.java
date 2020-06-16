package com.example.aggregateservice.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.ALWAYS)
public class AggregateDetails {
	
 User userDetails;
 List<Order> orders;
public User getUserDetails() {
	return userDetails;
}
public void setUserDetails(User userDetails) {
	this.userDetails = userDetails;
}
public List<Order> getOrders() {
	return orders;
}
public void setOrders(List<Order> orders) {
	this.orders = orders;
}
 

	
	
}
