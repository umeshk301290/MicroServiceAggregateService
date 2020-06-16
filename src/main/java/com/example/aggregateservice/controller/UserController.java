package com.example.aggregateservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.aggregateservice.entity.AggregateDetails;
import com.example.aggregateservice.entity.Order;
import com.example.aggregateservice.entity.User;


@RestController
public class UserController {
	
	@Autowired
	RestTemplate template;

	@GetMapping(value = "/orderdetails/{userid}")
	public ResponseEntity<AggregateDetails> getAggregateDetails(@PathVariable("userid") Long userid) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
	HttpEntity entity = new HttpEntity<>(null,headers);
	String userUrl = "http://localhost:8080/users/"+userid;
	String orderUrl = "http://localhost:8081/orders/"+userid;
	ResponseEntity<User> user = template.exchange(userUrl,HttpMethod.GET,entity ,User.class);
	ResponseEntity<User> userOrder = template.exchange(orderUrl,HttpMethod.GET,entity ,User.class);
	AggregateDetails aggregateDetails = new AggregateDetails();
	user.getBody().setOrders(null);
	aggregateDetails.setUserDetails(user.getBody());
	aggregateDetails.setOrders(userOrder.getBody().getOrders());
	

         return new ResponseEntity<AggregateDetails>(aggregateDetails,HttpStatus.OK);
	}

}
